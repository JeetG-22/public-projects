from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager
driver = webdriver.Chrome(ChromeDriverManager().install())
driver.get("https://www.teledynamics.com/#/catalog/manufacturer/Jabra")
print(driver.page_source)