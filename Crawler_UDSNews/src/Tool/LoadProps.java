package Tool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProps {
	static String propertiesPath = "D:\\workplace\\Crawler_UDSNews\\resource\\Database.properties";
	
	private static Properties props;
	

	//Test用
	public static void main(String[] args) {
		System.out.println(getProperties("databaseName"));
		
	}
	
	private static void loadProperties() {
		props = new Properties();
		try {
			props.load(new FileInputStream(propertiesPath));// 設定檔案名稱
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperties(String key) {// 把Database.properties載入程式
		loadProperties();
		return props.getProperty(key);
	}

	

}
