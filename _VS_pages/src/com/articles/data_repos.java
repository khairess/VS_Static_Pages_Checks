package com.articles;

import org.testng.annotations.DataProvider;

public class data_repos {
  @DataProvider(name="article_list")
  public static Object[][] loginsheet() 
  {
  Object[][] arrayobject=excel_util.getexceldata("G:/mobile app testing/65_domains/dev/VS_pages/all_VS_pages1.xls","Sheet1");
  return arrayobject;
  }
}
