package com.articles;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class VisualStories_TC {

	
  @BeforeSuite
  public void start() {
	 comman_oper.Open_given_Browser();
  }
  
  @Test(dataProvider="article_list", dataProviderClass=data_repos.class)
	public void main_script(String page_URL, String exl_page_title)
	{
	  comman_oper.driver.get(page_URL);
	  String current_title=comman_oper.driver.getTitle();
	  check_page_title(current_title, exl_page_title, page_URL);
	  
	  WebDriverWait wait = new WebDriverWait(comman_oper.driver,10);	  
	  WebElement logo=comman_oper.driver.findElement(By.xpath("//img[contains(@src,'https://media.visualstories.com/vs/logo-183x60.png')]"));
	  wait.until(ExpectedConditions.visibilityOf(logo));
	  check_logo(logo,page_URL);
	  
	  String page_src=comman_oper.driver.getPageSource();
	  CharSequence char_seq_for_google_analytics="UA-127736096-1";
	  System.out.println(page_URL+"=Google Analytics code present="+page_src.contains(char_seq_for_google_analytics));
	  
	  links(page_URL);
	  
	  amp_image_links(page_URL);
	  
	  script_links(page_URL);
    }
  
  public void check_page_title(String actual_tit,String exp_tit,String page_url)
  {
	  System.out.println("Page title="+actual_tit);
	  if(actual_tit.equals(exp_tit))
		  System.out.println(page_url+"=page title is correct");
	  else
		  System.out.println(page_url+"=page title is wrong");
  }
  
  public void check_logo(WebElement logo_for_function,String page_url)
  {
	  if(logo_for_function.isDisplayed())
	       System.out.println(page_url+"=Logo displayed");
	  else
		  System.out.println(page_url+"=Logo NOT displayed");
  }
  
  public void links(String page_url)
  {
	  List<WebElement> allLink=comman_oper.driver.findElements(By.tagName("a"));
	  
	  for(int i=0;i<allLink.size();i++)
		{
			WebElement ele=allLink.get(i);
			String url=ele.getAttribute("href");
			verifyLinkActive(url,page_url);
		}
  }
  
  public void amp_image_links(String page_url)
  {
	  List<WebElement> allAmpImages=comman_oper.driver.findElements(By.tagName("amp-img"));
	  for(int m=0;m<allAmpImages.size();m++)
		{
			WebElement eleAmpImg=allAmpImages.get(m);
			String AmpImgSrc=eleAmpImg.getAttribute("src");
			verifyLinkActive(AmpImgSrc,page_url);
		}
  }
  
  public void script_links(String page_url)
  {
	  List<WebElement> all_script=comman_oper.driver.findElements(By.tagName("script"));
	  for(int l=0;l<all_script.size();l++)
	  {
		  WebElement elescript=all_script.get(l);
		  String script_url=elescript.getAttribute("src");
		  verifyLinkActive(script_url,page_url);
	  }
  }
  
  public void verifyLinkActive(String linkurl,String page_url)
	{
		try
		{
		URL url=new URL(linkurl);
		HttpURLConnection httpUrlConnect = (HttpURLConnection) url.openConnection();
		httpUrlConnect.setConnectTimeout(3000);
		httpUrlConnect.connect();
		int status_code=httpUrlConnect.getResponseCode();
		
		if(status_code==200 || status_code==201 || status_code==204 || status_code==301 || status_code==302 || status_code==300 || status_code==304)
		{
			System.out.println(page_url+"="+linkurl + "=" + httpUrlConnect.getResponseCode()+ "=" + httpUrlConnect.getResponseMessage());
		}
		if(status_code==404 || status_code==503 || status_code==501 || status_code==502 || status_code==400 || status_code==403 || status_code==409 || status_code==401 || status_code==504 || httpUrlConnect.getResponseMessage()=="ERR_CONNECTION_TIMED_OUT")
		{
			System.out.println(page_url+"="+linkurl + "=" + httpUrlConnect.getResponseCode() + "=" + httpUrlConnect.getResponseMessage());
		}
		
		
		} catch(Exception e)
		{
			
		}
		}
  
  
  @AfterSuite
  public void end()
  {
	  comman_oper.Closebrowser();	  
  }
  }

