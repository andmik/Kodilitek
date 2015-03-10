package testowanieMoje;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import sprawdzenie.GetCode;
import sprawdzenie.ZapiszKod;
import zadanie.Zadanie;

public class MainNewWatek2  implements Runnable{

	public MainNewWatek2(){}

	@Override
	public void run() {
		uruchom();
	}
	
	public void uruchom(){
		
		GetCode gc = new GetCode();
		TekstZadaniaDoTest zapiszTekst = new TekstZadaniaDoTest();
		
			System.out.println("\n\nnowy w¹tek\n\n");
		
				//---------------------------------------------
				//---------------------------------------------
				 ZapiszKod zapiszKod2 = new ZapiszKod();
				 gc.getCodeRead();
				 zapiszKod2.zapiszRozwiazanie(zapiszTekst.ustalonyKod());
					gc.getCodeRead();
					//reloadClass();

					 try {
						runProcess("javac -d D:/workE/Kodilitek/target/classes/ D:/workE/Kodilitek/src/zadanie/Zadanie.java");
						//runProcess("javac -d D:/workE/Kodilitek/target/mojeKlasy D:/workE/Kodilitek/src/zadanie/Zadanie.java");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					 
					 try {
						 File classesDir2 = new File("D:/workE/Kodilitek/target/classes/zadanie");
						 //File classesDir2 = new File("D:/workE/Kodilitek/target/mojeKlasy/zadanie");
						 ClassLoader parentLoader2 = Zadanie.class.getClassLoader();
						 URLClassLoader loader2;
						 Class<?> cls2;
						 
						 loader2 = new URLClassLoader( new URL[] { classesDir2.toURI().toURL() }, parentLoader2);
						 //cls2 = new MainNewWatek().loadClass("zadanie.Zadanie");

						 cls2 = loader2.loadClass("zadanie.Zadanie");
					
						 Zadanie zadanie2 = (Zadanie) cls2.newInstance();
						 
						 //Zadanie zadanie2 = (Zadanie) new MainNewWatek().loadClass("zadanie.Zadanie").newInstance();
						 //Zadanie zadanie2 = (Zadanie) new MainNewWatek().loadClass("zadanie.Zadanie").newInstance();
						 
							int[] A1 = {1,2,4};
							//Zadanie zad = new Zadanie();
							System.out.println( "int: " + zadanie2.zadanie(A1) );
						
						try {
							loader2.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					} catch (MalformedURLException | InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				 
				//--------------------------------------------- 
				//---------------------------------------------
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
	  
	  /*
	   
	    @Override
	    public Class<?> loadClass(String s) {
	    	System.out.println("------- przes³oniêta -----------");
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
	        File f = new File("D:/workE/Kodilitek/target/classes/zadanie" + className);//.replaceAll("\\.", "/") + ".class"
	        //File f = new File("D:/workE/Kodilitek/target/mojeKlasy" + className);
	        int size = (int) f.length();
	        byte buff[] = new byte[size];
	        FileInputStream fis = new FileInputStream(f);
	        DataInputStream dis = new DataInputStream(fis);
	        dis.readFully(buff);
	        dis.close();
	        return buff;
	    }	
	    */
}