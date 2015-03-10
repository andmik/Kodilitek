package sprawdzenie;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//http://commons.apache.org/proper/commons-configuration/userguide/howto_filebased.html
//http://stackoverflow.com/questions/7774036/auto-reload-changed-files-in-java

public class GetCode {

	public GetCode(){}
	
	public void getCodeRead(){
		File file = new File("D:/workE/Kodilitek/src/zadanie/Zadanie.java");
		 
		try (FileInputStream fis = new FileInputStream(file)) {
 
			System.out.println("Total file size to read (in bytes) : "+ fis.available());
 
			int content;
			while ((content = fis.read()) != -1) {
				// convert to char and display it
				System.out.print((char) content);
			}
 
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
