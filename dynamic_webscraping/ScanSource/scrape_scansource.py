from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager
# from selenium.webdriver import ChromeOptions
from bs4 import BeautifulSoup
import time
import pandas as pd
from openpyxl import load_workbook
# from xlsxwriter import Workbook
# from selenium.webdriver.firefox.options import Options

# options = ChromeOptions()
# options = Options()
# options.headless = True

full_product_list_info = []

x=5000

#Looping through each page to get the data 
while x < 5221 :

    #Using f strings
    url = f"https://www.scansource.com/shop#search-product_o=MfrPartNum%2CDescending&search-product_manufacturer=jabra%2Cplantronics%2Cxpcc%2Ceaton%2Capc%2Fschneider%20electric%2Cyealink%2Cvtech%20communications%2Citw%20linx%2Cvalcom&search-product_e={x}"

    driver = webdriver.Chrome(ChromeDriverManager().install())
    # driver = webdriver.Firefox(options=options)
    driver.get(url)

    time.sleep(3)

    html_text = driver.page_source
    # print(html_text)

    soup = BeautifulSoup(html_text, "lxml")

    product_list = soup.find_all("div", class_="product-detail-container")

    for product in product_list :

        #Product name
        try:
            product_name = product.find("div", class_="product-detail-name field-marketingproductfamilyname").text.strip()
        except:
            product_name = ""
        
        #Generating sku number in the right format
        try:
            comp_name = product.find("div", class_="product-detail-number field-scansourceitemnumber").text.strip().rpartition("-")[0]
            mfr_num = product.find("div", class_="mfr-num field-manufactureritemnumber").find(text=True, recursive=False).strip()
            sku_num = comp_name + "-" + mfr_num
        except:
            sku_num = ""
        
        #Product description 
        try:
            description = product.find("div", class_="product-desc field-webdescription").text.strip()
        except:
            description = ""

        try:
            image_url = product.find("img", class_="product-image")["src"]
        except:
            image_url = ""

        product_info = {
            "Product Number" : sku_num,
            "Product Name" : product_name,
            "Product Description" : description,
            "Image URL" : image_url,
            "X" : x
        }
        full_product_list_info.append(product_info)


    #x represents the amount of products processed

    # if x % 500 == 0:
    #     df = pd.DataFrame(full_product_list_info)
    #     # print(full_product_list_info)
    #     df.to_excel(f"C:/Users/4pupp/Downloads/test{x}.xlsx", sheet_name="test", index=False)
    print(x)
    x = x + 20
    driver.quit()

df = pd.DataFrame(full_product_list_info)
# print(full_product_list_info)
df.to_excel(f"C:/Users/4pupp/Downloads/test5000-5220.xlsx", sheet_name="test", index=False)