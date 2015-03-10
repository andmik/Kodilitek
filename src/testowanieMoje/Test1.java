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
import sprawdzenie.Kompiluj;
import sprawdzenie.Sciezki;
import sprawdzenie.ZapiszKod;
import zadanie.Zadanie;

//http://stackoverflow.com/questions/4842684/how-to-compile-run-java-program-in-another-java-program

//dynamiczna kompilacja
//http://www.javaworld.com/article/2071777/design-patterns/add-dynamic-java-code-to-your-application.html

//jenkov
//http://tutorials.jenkov.com/java-reflection/dynamic-class-loading-reloading.html#dynamicreloading

//reloader
//http://stackoverflow.com/questions/3971534/how-to-force-java-to-reload-class-upon-instantiation

public class Test1{

	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		Sciezki sciezki = new Sciezki();
		Kompiluj kompiluj = new Kompiluj();
		TekstZadaniaDoTest zapiszTekst = new TekstZadaniaDoTest();
		
		GetCode gc = new GetCode();
		gc.getCodeRead();
		
		ZapiszKod zapiszKod = new ZapiszKod();
		zapiszKod.zapiszRozwiazanie(zapiszTekst.ustalonyKod1());
		gc.getCodeRead();
		//reloadClass();

		 try {
			 //String str[] = {"javac", "-d D:/workE/Kodilitek/src/zadanie/Zadanie.java", "D:/workE/Kodilitek/src/zadanie/Zadanie.java"};
			runProcess("javac -d D:/workE/Kodilitek/target/classes/ D:/workE/Kodilitek/src/zadanie/Zadanie.java");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		 
		 try {
			 File classesDir2 = new File("D:/workE/Kodilitek/target/classes/zadanie");
			 ClassLoader parentLoader2 = Zadanie.class.getClassLoader();
			 URLClassLoader loader2;
			 Class<?> cls2;
			 
			 loader2 = new URLClassLoader( new URL[] { classesDir2.toURI().toURL() }, parentLoader2);
			 cls2 = loader2.loadClass("zadanie.Zadanie");
			 Zadanie zadanie2 = (Zadanie) cls2.newInstance();
			 
				int[] A1 = {1,2,4};
				//Zadanie zad = new Zadanie();
				System.out.println( "int: " + zadanie2.zadanie(A1) );
			
			try {
				loader2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (MalformedURLException | ClassNotFoundException | InstantiationException | IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		//------------------------
		//------------------------
		
		Runnable r1 = new MainNewWatek();
		Thread t1 = new Thread(r1);
		t1.start();
		 
		//------------------------
		//------------------------
		 
			//---------------------------------------------
			//---------------------------------------------
		 
		 /*
		  
		  
			 ZapiszKod zapiszKod2 = new ZapiszKod();
			 zapiszKod2.zapiszRozwiazanie(zapiszTekst.ustalonyKod1());
				gc.getCodeRead();
				//reloadClass();

				 try {
					 //String str[] = {"javac", "-d D:/workE/Kodilitek/src/zadanie/Zadanie.java", "D:/workE/Kodilitek/src/zadanie/Zadanie.java"};
					runProcess("javac -d D:/workE/Kodilitek/target/classes/ D:/workE/Kodilitek/src/zadanie/Zadanie.java");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				 
				 try {
					 File classesDir2 = new File("D:/workE/Kodilitek/target/classes/zadanie");
					 ClassLoader parentLoader2 = Zadanie.class.getClassLoader();
					 URLClassLoader loader2;
					 Class<?> cls2;
					 
					 loader2 = new URLClassLoader( new URL[] { classesDir2.toURI().toURL() }, parentLoader2);
					 cls2 = loader2.loadClass("zadanie.Zadanie");
					 Zadanie zadanie2 = (Zadanie) cls2.newInstance();
					 
						int[] A1 = {1,2,4};
						//Zadanie zad = new Zadanie();
						System.out.println( "int: " + zadanie2.zadanie(A1) );
					
					try {
						loader2.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				} catch (MalformedURLException | ClassNotFoundException | InstantiationException | IllegalAccessException e1) {
					e1.printStackTrace();
				}
			
			*/
		 
			//--------------------------------------------- 
			//---------------------------------------------
				 
		/*
			 
		for(int i = 0; i < 1; i++){
			
		if( kompiluj.kompiluj(sciezki.getZadanieJava(), sciezki.getZadanieClass() ) ){
			zapiszKod.zapiszRozwiazanie(zapiszTekst.ustalonyKod1());
			gc.getCodeRead();
			 try{
					runProcess("javac -d D:/workE/Kodilitek/target/classes/ D:/workE/Kodilitek/src/zadanie/Zadanie.java");
			}catch (Exception e1) {
					e1.printStackTrace();
			}
			 
			if( kompiluj.kompiluj(sciezki.getSprawdzZadanieJava(), sciezki.getSprawdzZadanieClass()) ){
				
				
				
				int[] A = {1,2,3,5};
				 try {
					 File classesDir22 = new File("D:/workE/Kodilitek/target/classes/zadanie");
					 ClassLoader parentLoader22 = Zadanie.class.getClassLoader();
					 URLClassLoader loader22;
					 Class<?> cls22;
					 
					 loader22 = new URLClassLoader( new URL[] { classesDir22.toURI().toURL() }, parentLoader22);
					 cls22 = loader22.loadClass("zadanie.Zadanie");
					 Zadanie zadanie22 = new Zadanie();
					 zadanie22 = (Zadanie) cls22.newInstance();
					 
						int[] A1 = {1,2,3,5};
						//Zadanie zad = new Zadanie();
						System.out.println( "int: " + zadanie22.zadanie(A1) );
					
					try {
						loader22.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} catch (MalformedURLException | ClassNotFoundException | InstantiationException | IllegalAccessException e1) {
					e1.printStackTrace();
				}
				
			    try {
			        //runProcess("javac D:/workE/Kodilitek/src/zadanie/Zadanie.java");
			        
			       
			        //reloadClass();
			    	Zadanie zadanie2 = new Zadanie();
			        System.out.println("\nprzed zadanie.zadanie()...");
			        System.out.println( "int: " + zadanie2.zadanie(A) );
			        
			      } catch (Exception e) {
			        e.printStackTrace();
			      }
			    
				//SprawdzZadanie sz = new SprawdzZadanie();
				//sz.sprawdzRozwiazanie();
			}

		}
		
		}
		*/
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
	
	  @SuppressWarnings("resource")
	public static void reloadClass(){
		// The dir contains the compiled classes. 
		  File classesDir = new File("D:/workE/Kodilitek/target/classes/zadanie");

		// The parent classloader 
		  ClassLoader parentLoader = Zadanie.class.getClassLoader();

		// Load class "sample.PostmanImpl" with our own classloader. 
		  URLClassLoader loader1;
		try {
			 loader1 = new URLClassLoader( new URL[] { classesDir.toURI().toURL() }, parentLoader);
			
			 Class<?> cls1;
			 cls1 = loader1.loadClass("zadanie.Zadanie");
			 Zadanie zadanie = (Zadanie) cls1.newInstance();
			 
				/* * Invoke on postman1 ... * Then PostmanImpl.java is modified and recompiled. */

				// Reload class "sample.PostmanImpl" with a new classloader. 
			 
			 URLClassLoader loader2;
			 loader2 = new URLClassLoader( new URL[] { classesDir.toURI().toURL() }, parentLoader);
			 
			 Class<?> cls2;
			 cls2 = loader2.loadClass("zadanie.Zadanie");
			 
			 Zadanie zadanie2 = (Zadanie) cls2.newInstance();
			 
				 try {
					loader1.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				 try {
					loader2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		} catch (MalformedURLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	  }
	  
}