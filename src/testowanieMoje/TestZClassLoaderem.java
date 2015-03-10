package testowanieMoje;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import sprawdzenie.GetCode;
import sprawdzenie.Kompiluj;
import sprawdzenie.Sciezki;
import sprawdzenie.ZapiszKod;
import zadanie.Zadanie;

public class TestZClassLoaderem {


	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		Sciezki sciezki = new Sciezki();
		Kompiluj kompiluj = new Kompiluj();
		TekstZadanZLoadClass zapiszTekst = new TekstZadanZLoadClass();
		
		GetCode gc = new GetCode();
		gc.getCodeRead();
		
		ZapiszKod zapiszKod = new ZapiszKod();
		
		zapiszKod.zapiszRozwiazanie(zapiszTekst.ustalonyKod());
		gc.getCodeRead();

		 try {
			runProcess("javac -d D:/workE/Kodilitek/target/classes/ D:/workE/Kodilitek/src/zadanie/Zadanie.java");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		 
		/*
		try {
			
			 Zadanie zadanie2 = (Zadanie) new Zadanie().loadClass("zadanie.Zadanie").newInstance();
			 int[] A1 = {1,2,4};
			 System.out.println( "int: " + zadanie2.zadanie(A1) );
			 
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
			//------------------------
			//------------------------
		
		zapiszKod.zapiszRozwiazanie(zapiszTekst.ustalonyKod1());
		gc.getCodeRead();

		 try {
			runProcess("javac -d D:/workE/Kodilitek/target/classes/ D:/workE/Kodilitek/src/zadanie/Zadanie.java");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		 
		try {
			
			 Zadanie zadanie3 = (Zadanie) new Zadanie().loadClass("zadanie.Zadanie").newInstance();
			 int[] A1 = {1,2,4};
			 System.out.println( "int: " + zadanie3.zadanie(A1) );
			 
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		*/
		 
		//------------------------
		//------------------------

	
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
