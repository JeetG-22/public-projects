import pandas as pd
import numpy as np

df1 = pd.read_excel(r"web_scrape\scansource_scrape_scripts\Master Catalog.xlsx")
df2 = pd.read_excel(r"web_scrape\scansource_scrape_scripts\scansource-scrape.xlsx")

comparevalues = df1.values == df2.values

print(comparevalues)

# print(df2)