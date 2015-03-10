package swing;

import java.nio.charset.StandardCharsets;

import sprawdzenie.Sciezki;
import zadanie.PobierzKlaseDoTekst;
import zadanie.tekstyZadan.TekstyZadan;

public class Logika {

	private TekstyZadan tekstyZadan;
	private PobierzKlaseDoTekst pobierzTekstKlasy;
	private Sciezki sciezka;
	private NumerZadaniaRozwiazywanego numerZadaniaRozwiazywanego;
	
	public Logika(){
		tekstyZadan = new TekstyZadan();
		pobierzTekstKlasy = new PobierzKlaseDoTekst();
		sciezka = new Sciezki();
		numerZadaniaRozwiazywanego = new NumerZadaniaRozwiazywanego();
	}
	
	protected String pobierzTekstZadania(int nrZadanie){
		numerZadaniaRozwiazywanego.setNrZadaniaRozwiazywanego(nrZadanie);
		
		switch(nrZadanie){
		case 1:
			return tekstyZadan.tekstZadanie1();
		}
		return "Nie wybrano zadania.";
	}
	
	protected String pobierzTekstKlasyZadania(int nrTekstuZadania){
		//default Charset
		//String content = readFile("test.txt", Charset.defaultCharset());
		switch(nrTekstuZadania){
		case 1:
			return pobierzTekstKlasy.przeczytajPlikZwrocString( sciezka.getZadanieJava(), StandardCharsets.UTF_8);
		}
		return  "Nie wybrano zadania";
	}		
}