package swing;

import java.util.ArrayList;
import java.util.List;

import sprawdzenie.Kompiluj;
import sprawdzenie.Sciezki;
import sprawdzenie.ZapiszKod;
import zadanie.SprawdzZadanie;

public class LogikaButtonow {

	private ZapiszKod zapiszKod;
	private Kompiluj kompiluj;
	private Sciezki sciezki;
	//
	
	public LogikaButtonow(){
		zapiszKod = new ZapiszKod();
		kompiluj = new Kompiluj();
		sciezki = new Sciezki();
		//sprawdzZadanie = new SprawdzZadanie();
	}
	
	public List<String> sprawdzRozwiazanie(String code){
		List<String> lista = new ArrayList<String>();
		SprawdzZadanie sprawdzZadanie = new SprawdzZadanie();
		
		System.out.println(code);
		zapiszKod.zapiszRozwiazanie(code);
		if(kompiluj.kompiluj(sciezki.getZadanieJava(), sciezki.getZadanieClass())){
			if( kompiluj.kompiluj(sciezki.getSprawdzZadanieJava(), sciezki.getSprawdzZadanieClass() ) ){
				lista.addAll(sprawdzZadanie.sprawdzRozwiazanie());
			}else{
				return kompiluj.getBledy();
			}
		}else{
			return kompiluj.getBledy();
		}
		
		return lista;
	}
}