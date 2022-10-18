package com.actiTime.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author shashank
 * this is generic class for data driven testing
 *
 */
public class FileLib {
	
	/**
	 * this is generic method for reading the data from propertyfile.
	 * @author shashank
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyData(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("./data/commondata.property");
		Properties p = new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
		
	}
	
	/**
	 * this generic method is used for reading the data from Excel file
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws IOException
	 */
	
	public String getExcelData(String sheetname,int row, int cell) throws IOException
	{
		FileInputStream fis = new FileInputStream("./data/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data= wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return data;	
	}
	
	/**
	 * this generic method is used for writing(replacing the value present in cell) the data in Excel file
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @param setvalue
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public void setExcelData(String sheetname,int row, int cell, String setvalue) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./data/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetname).getRow(row).getCell(cell).setCellValue(setvalue);
		FileOutputStream fos = new FileOutputStream("./data/Book1.xlsx");
		wb.write(fos);
		wb.close();
		
	}

}
