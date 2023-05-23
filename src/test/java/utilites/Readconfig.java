package utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readconfig {
	public static	Properties prop=null;
	Readconfig (){
		try {
			FileInputStream fis =new FileInputStream("D:\\New folder\\endtoendproject\\Configurations\\config.properties");
		 prop=new Properties();
		 prop.load(fis);
		
		
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public String geturl() {
	String url=prop.getProperty("url");
	return url;
}
public String getusername() {
	String username=prop.getProperty("username");
	return username;
}
public String getpassword() {
	String password=prop.getProperty("password");
	return password;
}

	
}


