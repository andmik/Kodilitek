package zadanie;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class SprawdzZadanie extends ClassLoader{

	
	//private Zadanie zadanie;
	private CiagiDoZadania ciagiDoZadania;
	//private AlgorytmyDoZadan algorytmyDoZadan;
	
	
	public SprawdzZadanie(){
		//this.ciagiDoZadania = new CiagiDoZadania();
		//this.algorytmyDoZadan = new AlgorytmyDoZadan();
	}
	
	public List<String> sprawdzRozwiazanie(){
		List<String> lista = new ArrayList<String>();
		
		Zadanie zadanie;
		AlgorytmyDoZadan algorytmyDoZadan;
		
		//this.zadanie = new Zadanie();
		//zadanie.zadanie(ciagiDoZadania.ciag1());
		
		 try {
			runProcess("javac -d D:/workE/Kodilitek/target/classes/ D:/workE/Kodilitek/src/zadanie/Zadanie.java");
			//runProcess("javac -d D:/workE/Kodilitek/target/classes/poKompilacji/ D:/workE/Kodilitek/src/zadanie/Zadanie.java");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		 
			//this.ciagiDoZadania = new CiagiDoZadania();
			//this.algorytmyDoZadan = new AlgorytmyDoZadan();
			this.ciagiDoZadania = new CiagiDoZadania();
			algorytmyDoZadan = new AlgorytmyDoZadan();
			
		 try {
			 File classesDir2 = new File("D:/workE/Kodilitek/target/classes/zadanie");
			 //D:/workE/Kodilitek/target/classes/zadanie
			 ClassLoader parentLoader2 = Zadanie.class.getClassLoader();
			 URLClassLoader loader2;
			 Class<?> cls2;
			 
			 loader2 = new URLClassLoader( new URL[] { classesDir2.toURI().toURL() }, parentLoader2);
			 cls2 = loader2.loadClass("zadanie.Zadanie");
			 //cls2 = loader2.loadClass("poKompilacji.Zadanie");
			 //this.zadanie = (Zadanie) cls2.newInstance();
			 zadanie = (Zadanie) cls2.newInstance();
			
			parentLoader2.clearAssertionStatus();
			try {
				loader2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			int rozwiazanieUzytkownika = zadanie.zadanie(ciagiDoZadania.ciag1());
			int rozwiazanieSystemowe = algorytmyDoZadan.algorytm1();
			
			System.out.println("uzytkownik: " + rozwiazanieUzytkownika + ", systemowe: " + rozwiazanieSystemowe);
			
			if( rozwiazanieUzytkownika == rozwiazanieSystemowe ){
				lista.add("Compilation successfull.");
				lista.add("Your code is good and count correctly for given example.\n");
				lista.add("Dla przyk³adu:\n [" + ciagDoString() + "]\n");
				lista.add("Twój wynik: " + rozwiazanieUzytkownika + "\n");
				lista.add("co jest zgodne z prawid³owym rozwi¹zaniem: " + rozwiazanieSystemowe + "\n");
				lista.add("\nB¹dŸ pewny, ¿e dla innych ci¹gów Twój kod tak¿e dzia³a.");
			}else{
				lista.add("Compilation successfull.\n");
				lista.add("Your code is good, but wrong count for given example.\n");
				lista.add("Dla przyk³adu:\n [" + ciagDoString() + "]\n");
				lista.add("Twój wynik: " + rozwiazanieUzytkownika + "\n");
				lista.add("a ma byæ: " + rozwiazanieSystemowe + "\n");
				lista.add("Popraw kod.");
			}
			//this.zadanie = null;
			zadanie = null;
			return lista;
		} catch (MalformedURLException | ClassNotFoundException | InstantiationException | IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		 return lista;
	}
	
	public String ciagDoString(){
		StringBuilder sb = new StringBuilder();
		for(int element: ciagiDoZadania.ciag1()){
			sb.append(element + ", ");
		}
		return sb.toString();
	}
	
	  private void runProcess(String command) throws Exception {
		    System.out.println("run Proces.");
		    Process pro = Runtime.getRuntime().exec(command);
		    printLines(command + " stdout:", pro.getInputStream());
		    printLines(command + " stderr:", pro.getErrorStream());
		    //pro.getOutputStream();
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
	  
	    @Override
	    public Class<?> loadClass(String s) {
	    	System.out.println("------- przes³oniêta loadClass --------");
	        return findClass(s);
	    }
	    
	    @Override
	    public Class<?> findClass(String s) {
	        try {
	            byte[] bytes = loadClassData(s);
	            return defineClass(s, bytes, 0, bytes.length);
	        } catch (IOException ioe) {
	            try {
	                return super.loadClass(s);
	            } catch (ClassNotFoundException ignore) { }
	            ioe.printStackTrace(System.out);
	            return null;
	        }
	    }
	    
	  private byte[] loadClassData(String className) throws IOException {
	        File f = new File("D:/workE/Kodilitek/target/classes/zadanie" + className.replaceAll("\\.", "/") + ".class");
	        int size = (int) f.length();
	        byte buff[] = new byte[size];
	        FileInputStream fis = new FileInputStream(f);
	        DataInputStream dis = new DataInputStream(fis);
	        dis.readFully(buff);
	        dis.close();
	        return buff;
	    }
}
