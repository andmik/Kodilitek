package zadanie.tekstyZadan;

public class TekstyZadan {

	private TekstZadanie1 tekstZadanie1;
	
	public TekstyZadan(){
		tekstZadanie1 = new TekstZadanie1();
	}
	
	public String tekstZadanie1(){
		return tekstZadanie1.pobierzTekstZadanie1();
	}
}

class TekstZadanie1{
	
	TekstZadanie1(){}
	
	String pobierzTekstZadanie1(){
		return "Masz podan� tablic�: int[] A, o d�ugo�ci N.\n Sk�ada sie z liczb od 1 do N, przy czym w ci�gu brakuje jednej liczby.\n Twoim zadaniem jest odnalezenie jej i zwr�cenie (return) brakuj�cej liczby.\n Przyk�ad:\n"
				+ "A[0] = 3\n"
				+ "A[1] = 2\n"
				+ "A[2] = 1\n"
				+ "A[3] = 6\n"
				+ "A[4] = 4\n"
				+ "Widzimy, �e brakuj�cy element to 5. Czyli jako wynik dzia�ania nale�y zwr�ci�: 5.\n\n"
				+ "W rozwi�zywanym przyk�adzie tablica A[] jest jak powy�szy przyk�ad.\n"
				+ "Uwzgl�dnij r�ne sprawy:)\n"
				+ "Powodzenia!!!";
	}
	
}
