package genericlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary implements FrameworkConstant {
	static FileInputStream fis;
	static FileOutputStream fos;
	static Workbook book;

	public static String readsingledata(String sheet, int row, int column) {

		// 1.Convert External File Into Java Understandable
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 2.Create an Workbook Using WorkBookFactory
		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 3.Read the Data
		String data = book.getSheet(sheet).getRow(row).getCell(column).getStringCellValue();
		System.out.println("Data Fetched Succesful");

		return data;
	}

	public static void writeNewData(String sheet, int row, int column, String data) {

		// 1.Convert External File Into Java Understandable
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 2.Create an Workbook Using WorkBookFactory
		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 3.Write the new Data in new sheet,row,column
		book.createSheet(sheet).createRow(row).createCell(column).setCellValue(data);

		// 4.Convert Java Understandable Into External File
		try {
			fos = new FileOutputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 5.Call the Write method and pass fos reff
		try {
			book.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 6.Close the Workbook
		try {
			book.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("new Data Written Succesful");

	}

	public static void updateNewData(String sheet, int row, int column, String data) {

		// 1.Convert External File Into Java Understandable
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 2.Create an Workbook Using WorkBookFactory
		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 3.Update the new Data in Existing Sheet ,Row
		book.getSheet(sheet).getRow(row).createCell(column).setCellValue(data);

		// 4.Convert Java Understandable Into External File
		try {
			fos = new FileOutputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 5.Call the Write method and pass fos reff
		try {
			book.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 6.Close the Workbook
		try {
			book.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("new Data Updated Succesful");

	}

	public static void readmultipledata_specificRow(String sheet, int row) {

		// 1.Convert External File Into Java Understandable
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 2.Create an Workbook Using WorkBookFactory
		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Fetch Last Column Number in the 3rd row
		int lastcolumnnum = book.getSheet(sheet).getRow(row).getLastCellNum();
		System.out.println(lastcolumnnum);

		for (int i = 0; i < lastcolumnnum; i++) {
			// 3.Read the Data
			String data = book.getSheet(sheet).getRow(3).getCell(i).getStringCellValue();
			System.out.println(data);
		}
	}

	public static void readmultipledata_specificcolumn(String sheet, int column)
		{

		// 1.Convert External File Into Java Understandable
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 2.Create an Workbook Using WorkBookFactory
		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Fetch Last Row Number
		int lastrownum = book.getSheet(sheet).getLastRowNum();
		System.out.println(lastrownum);

		for (int i = 1; i <= lastrownum; i++) {
			// 3.Read the Data
			String data = book.getSheet(sheet).getRow(i).getCell(column).getStringCellValue();
			System.out.println(data);
		}

	}

}
