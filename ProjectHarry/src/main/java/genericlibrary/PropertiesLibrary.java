package genericlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLibrary implements FrameworkConstant {

	static FileInputStream fis;

	static FileOutputStream fos;

	static Properties property;

	public static String readData(String key) {

		// 1.Convert the External File Into Java Understandable
		try {
			fis = new FileInputStream(propertypath);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 2.Create An Object for Properties class
		property = new Properties();

		// 3.Load All the Property
		try {
			property.load(fis);
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		// 4.Read/Fetch the data
		return property.getProperty(key);
		
	}
	
	
	
	
	
	
	public static void writeData(String newkey, String newdata, String message) {

		// 1.Convert the External File Into Java Understandable
	try {
		fis = new FileInputStream(propertypath);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}

		// 2.Create An Object for Properties class
		property = new Properties();

		// 3.Load All the Property
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 4.Put the New Data in Properties File
		property.put(newkey, newdata);

		// 5.Convert the Java Understandable Into External File
		try {
			fos = new FileOutputStream(propertypath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 6.Store the New Data With Message
		try {
			property.store(fos, message);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
