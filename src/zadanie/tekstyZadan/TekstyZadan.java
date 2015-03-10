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
		return "Masz podan¹ tablicê: int[] A, o d³ugoœci N.\n Sk³ada sie z liczb od 1 do N, przy czym w ci¹gu brakuje jednej liczby.\n Twoim zadaniem jest odnalezenie jej i zwrócenie (return) brakuj¹cej liczby.\n Przyk³ad:\n"
				+ "A[0] = 3\n"
				+ "A[1] = 2\n"
				+ "A[2] = 1\n"
				+ "A[3] = 6\n"
				+ "A[4] = 4\n"
				+ "Widzimy, ¿e brakuj¹cy element to 5. Czyli jako wynik dzia³ania nale¿y zwróciæ: 5.\n\n"
				+ "W rozwi¹zywanym przyk³adzie tablica A[] jest jak powy¿szy przyk³ad.\n"
				+ "Uwzglêdnij ró¿ne sprawy:)\n"
				+ "Powodzenia!!!";
	}
	
}
