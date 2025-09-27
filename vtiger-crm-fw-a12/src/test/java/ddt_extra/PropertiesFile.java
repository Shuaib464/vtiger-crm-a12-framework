package ddt_extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

	public static void main(String[] args) throws IOException {
		
		// 1> Get the Java Representation Object of Physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/testdata/commondata.properties");
		Properties pObj = new Properties();
		
		// 2> use the load() and load all the keys
		pObj.load(fis);
		
		// 3> use getProperty() and pass key and get the value of key
		String BROWSER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		
		System.out.println("Browser : " + BROWSER);
		System.out.println("URl : " + URL);
	}

}
