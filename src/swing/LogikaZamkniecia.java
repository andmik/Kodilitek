package swing;

import sprawdzenie.ZapiszKod;

public class LogikaZamkniecia {

	private ZapiszKod zapiszKod;
	
	public LogikaZamkniecia(){
		zapiszKod = new ZapiszKod();
	}
	
	public void zapiszPlikZadanieUstalonymKodem(){
		zapiszKod.zapiszRozwiazanie(ustalonyKod());
	}
	
	private String ustalonyKod(){
		String kod = "package zadanie;"
				+ "\n"
				+ "\npublic class Zadanie {"
				+ "\n"
				+ "\n\tpublic Zadanie(){}"
				+ "\n"
				+ "\n\tpublic int zadanie(int[] A){"
				+ "\n"
				+ "\n\treturn 0;"
				+ "\n\t}\n"
				+ "\n}";
		return kod;
	}
}
