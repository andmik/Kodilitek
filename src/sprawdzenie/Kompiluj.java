package sprawdzenie;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

public class Kompiluj {
	
	private Iterable<? extends JavaFileObject> compilationUnits;
	private DiagnosticCollector<JavaFileObject> diagnostics;
	
	private boolean success = false;
	
	public Kompiluj(){}
	
	public boolean kompiluj(String sciezkaJava, String sciezkaClass){
		
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		
		diagnostics = new DiagnosticCollector<JavaFileObject>();
		
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
			try {
				fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Arrays.asList(new File(sciezkaClass)));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			compilationUnits = fileManager.getJavaFileObjectsFromStrings(Arrays.asList(sciezkaJava));
			
			JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, null,
			        null, compilationUnits);
			
			try{
			success = task.call();
			System.out.println("\ntry: " + success);
				if( !success )
					wypiszBledy(diagnostics);
				
			}catch(Exception e){
				System.err.println("blad : " + e.getMessage() );
				e.printStackTrace();
			}
			
			try {
				fileManager.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		return success;
	}
	
	public void wypiszCompilationUnits(){
		System.out.println("wypisz compilationUnits:");
		Iterator<? extends JavaFileObject> itr = compilationUnits.iterator();
		while( itr.hasNext() ){
			System.out.println( itr.next() );
		}
	}
	
	public void wypiszBledy(DiagnosticCollector<JavaFileObject> diagnostics){
		
		System.out.println("wypisz b³êdy");
		//List<Diagnostic<? extends JavaFileObject>> lista = new ArrayList<Diagnostic<? extends JavaFileObject>>();
		
		for(Diagnostic<? extends JavaFileObject> diagnos: diagnostics.getDiagnostics() ){
			System.out.println("" + diagnos + ""
					+ "\n" + diagnos.getMessage(null)
					+ "\nlineNumber : " + diagnos.getLineNumber()
					+ "\ngetKind : " + diagnos.getKind()
					+ "\n------\n");
		}
	}

	public List<String> getBledy(){
		List<String> lista = new ArrayList<String>();
		
		for(Diagnostic<? extends JavaFileObject> diagnos: getDiagnostics().getDiagnostics() ){
			String blad = "" + diagnos + ""
					+ "\n" + diagnos.getMessage(null)
					+ "\nlineNumber : " + diagnos.getLineNumber()
					+ "\ngetKind : " + diagnos.getKind()
					+ "\n------\n";
			lista.add(blad);
		}
		
		return lista;
	}
	
	public boolean isSuccess() {return success;}
	public void setSuccess(boolean success) {this.success = success;}
	
	protected DiagnosticCollector<JavaFileObject> getDiagnostics(){return diagnostics;}
}