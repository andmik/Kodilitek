package testowanieMoje;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestAplikacjaZewn {

	public static void main(String[] args) {
		
		try {
			//runProcess("javac -d D:/workE/KodilitekDoTest/target/classes/ D:/workE/KodilitekDoTest/src/zadanie/Zadanie.java");
			runProcess("javac -d D:/workE/KodilitekDoTest/target/classes/sprawdzenie/ D:/workE/KodilitekDoTest/src/sprawdzenie/Test.java");
			runProcess("java -cp D:/workE/KodilitekDoTest/ Test");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Runtime.getRuntime().exec("D:\\workE\\KodilitekDoTest\\target\\sprawdzenie\\Test");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	  private static void runProcess(String command) throws Exception {
		    System.out.println("run Proces.");
		    Process pro = Runtime.getRuntime().exec(command);
		    printLines(command + " stdout:", pro.getInputStream());
		    printLines(command + " stderr:", pro.getErrorStream());
		    //pro.getOutputStream();
		    pro.waitFor();
		    System.out.println(command + " exitValue() " + pro.exitValue());
		  }
	  
	  private static void printLines(String name, InputStream ins) throws Exception {
		    String line = null;
		    BufferedReader in = new BufferedReader(
		        new InputStreamReader(ins));
		    while ((line = in.readLine()) != null) {
		        System.out.println(name + " " + line);
		    }
	  }
}