from bs4 import BeautifulSoup
from helium import *
import selenium
# from selenium.webdriver import ChromeOptions
# options = ChromeOptions()
# options.add_argument('--proxy-server=1.2.3.4:5678')
# start_chrome(options=options)
# import requests
# from selenium import webdriver
# from webdriver_manager.chrome import ChromeDriverManager
# driver = webdriver.Chrome(ChromeDriverManager().install())
# webdriver.open()

url = "https://www.teledynamics.com/#/catalog/manufacturer/Jabra"
headers = {'User-Agent': 'Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36'}

browser = start_chrome(url, headless=True)

html = browser.page_source
print(html)

# html_text = requests.get("https://www.teledynamics.com/#/catalog/manufacturer/Jabra", headers=headers).text
# print(html_text)
# soup = BeautifulSoup(html_text, "lxml")
# product = soup.find_all('li', class_='col-md-3 col-sm-4 shown search-result ng-scope')
# product = soup.find('li', class_='clearfix job-bx wht-shd-bx')
# print(product)
# print(soup.body.div.li)
