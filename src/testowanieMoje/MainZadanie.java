package testowanieMoje;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MainZadanie{

	public MainZadanie(){}
	
	public static void main(String[] args){
		System.out.println("MainZadanie main...");
		
	}
	
	public void uruchomZadanie(){
        try {
			runProcess("javac D:/workE/Kodilitek/src/testowanieMoje/MainZadanie.java");
			runProcess("java D:/workE/Kodilitek/src/testowanieMoje/MainZadanie");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	  private void runProcess(String command) throws Exception {
		    System.out.println("run Proces.");
		    Process pro = Runtime.getRuntime().exec(command);
		    printLines(command + " stdout:", pro.getInputStream());
		    printLines(command + " stderr:", pro.getErrorStream());
		    pro.waitFor();
		    System.out.println(command + " exitValue() " + pro.exitValue());
		  }
	  
	  private void printLines(String name, InputStream ins) throws Exception {
		    String line = null;
		    BufferedReader in = new BufferedReader(
		        new InputStreamReader(ins));
		    while ((line = in.readLine()) != null) {
		        System.out.println(name + " " + line);
		    }
	  }
}

class Zadanie{
	
	public Zadanie(){}
	
}
