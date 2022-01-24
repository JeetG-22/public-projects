from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager

full_product_info_list = []

x = 0

url = "https://www.scansource.com/shop#search-product_o=MfrPartNum%2CDescending&search-product_manufacturer=jabra%2Cplantronics%2Cxpcc%2Ceaton%2Capc%2Fschneider%20electric%2Cyealink%2Cvtech%20communications%2Citw%20linx%2Cvalcom&search-product_e=0"

driver = webdriver.Chrome(ChromeDriverManager().install())
driver.get(url)

print(driver.page_source)

product_names = driver.find_elements_by_class_name(
    "product-detail-name field-marketingproductfamilyname")
comp_names = driver.find_elements_by_class_name(
    "product-detail-number field-scansourceitemnumber")
mfr_nums = driver.find_elements_by_class_name(
     "mfr-num field-manufactureritemnumber")
product_desc = driver.find_elements_by_class_name(
      "product-desc field-webdescription")
image_urls = driver.find_elements_by_class_name("product-image")

for i in range(len(product_names)):
        full_product_info_list.append(
            [product_names[i], comp_names[i], mfr_nums[i], product_desc[i]])


print(full_product_info_list)
