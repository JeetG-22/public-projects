from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver import ChromeOptions
from bs4 import BeautifulSoup
import time
import requests
import pandas as pd

main_url = "https://www.teledynamics.com/"
url = "https://www.teledynamics.com/#/catalog/manufacturer/Yealink"

options = ChromeOptions()
options.headless = True

driver = webdriver.Chrome(ChromeDriverManager().install(), options=options)
driver.get(url)

#Function to scroll down the continous page (not my code)
def scroll(driver, timeout):
    scroll_pause_time = timeout

    # Get scroll height
    last_height = driver.execute_script("return document.body.scrollHeight")

    while True:
        # Scroll down to bottom
        driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")

        # Wait to load page
        time.sleep(scroll_pause_time)

        # Calculate new scroll height and compare with last scroll height
        new_height = driver.execute_script("return document.body.scrollHeight")
        if new_height == last_height:
            # If heights are the same it will exit the function
            break
        last_height = new_height

scroll(driver, .5)

#Getting the full HTML code (including tags loaded using javascript)
html_text = driver.page_source
soup = BeautifulSoup(html_text, "lxml")

#Finding Product tags
product_list = soup.find_all('li', class_='col-md-3 col-sm-4 shown search-result ng-scope')
product_links = []

#Getting Product links
for product in product_list :
    for link in product.find_all("a", class_="ng-binding") :
        product_links.append(main_url + link["href"])
print(len(product_links))

full_product_list_info = []
for link in product_links :
    #Creating a new driver instance
    driver = webdriver.Chrome(ChromeDriverManager().install(), options=options)
    driver.get(link)

    #HTML text from the product page
    html_text = driver.page_source
    soup = BeautifulSoup(html_text, "lxml")

    #Pulling out product info
    try: 
        product_name = soup.find("span", class_="product_identity ng-binding").text.strip()
    except:
        product_name=""
    try:
        sku_num = soup.find("strong", class_="product_no ng-binding").text.strip()
    except:
        sku_num = ""

    #Finding Product descriptions
    description = ""
    try: 
        for litags in soup.find("ul", class_="ng-binding").find_all("li") :
            description += litags.text.strip() + "\n"
    except:
        description = ""
    
    product_info = {
        "Product Number" : sku_num,
        "Product Name" : product_name,
        "Product Description" : description
    }

    # print("Saving", product_info["name"])

    full_product_list_info.append(product_info)
    driver.close()

df = pd.DataFrame(full_product_list_info)
df.to_excel(r'C:\Users\4pupp\Downloads\teledynamics-scrape-yeahlink.xlsx', sheet_name="Yeahlink", index=False)
