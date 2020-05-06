package com.articles;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

import jxl.Workbook;
import jxl.Sheet;
import jxl.read.biff.BiffException;

public class excel_util {
	
	public static String[][] getexceldata(String filename, String sheet)
	{
		String[][] arrayexceldata=null;
		try
		{
			FileInputStream fs=new FileInputStream(filename);
			Workbook wb=Workbook.getWorkbook(fs);
			Sheet sh=wb.getSheet(sheet);
			int totalcol=sh.getColumns();
			int totalrow=sh.getRows();
			arrayexceldata=new String[totalrow-1][totalcol];
			for(int i=1; i<totalrow; i++)
			{
				for(int j=0; j<totalcol; j++)
				{
					//System.out.println(sh.getCell(j,i).getContents());
					arrayexceldata[i-1][j]=sh.getCell(j,i).getContents();
				}
			}
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		return arrayexceldata;
	}

}
