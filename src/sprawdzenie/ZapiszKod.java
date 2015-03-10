package sprawdzenie;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ZapiszKod {

	private FileWriter fileWriter;
	
	public ZapiszKod(){}
	
	public void zapiszRozwiazanie(String newCode){

		try {
			
			fileWriter = new FileWriter(new File("D:/workE/Kodilitek/src/zadanie/Zadanie.java"));
			fileWriter.write(newCode);
			//InputStream is = Zadanie.class.getClass().getResourceAsStream("D:/workE/Kodilitek/src/zadanie/Zadanie.java");
			
			//Properties  prop = new Properties();
			//InputStream trackerFileStream = Zadanie.class.getClassLoader().getResourceAsStream("D:/workE/Kodilitek/src/zadanie/Zadanie.java");
			//prop.load(trackerFileStream);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}