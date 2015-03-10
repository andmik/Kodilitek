package zadanie;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PobierzKlaseDoTekst {

	public PobierzKlaseDoTekst(){}
	
	public String przeczytajPlikZwrocString(String sciezka, Charset kodowanie){
		byte[] kod;
		try {
			kod = Files.readAllBytes(Paths.get(sciezka));
			return new String(kod, kodowanie);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Nie uda³o siê odczytaæ pliku.";
	}
}
