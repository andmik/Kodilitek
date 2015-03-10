package sprawdzenie;

public class Sciezki {

	private final String zadanieJava = "D:/workE/Kodilitek/src/zadanie/Zadanie.java";
	//private final String zadanieClass = "D:/workE/Kodilitek/target/classes/poKompilacji/";
	private final String zadanieClass = "D:/workE/Kodilitek/target/classes/";

	private final String sprawdzZadanieJava = "D:/workE/Kodilitek/src/zadanie/SprawdzZadanie.java";
	private final String sprawdzZadanieClass = "D:/workE/Kodilitek/target/classes/";
	
	public Sciezki(){}
	
	public String getZadanieJava(){return zadanieJava;}
	public String getZadanieClass(){return zadanieClass;}
	
	public String getSprawdzZadanieJava(){return sprawdzZadanieJava;}
	public String getSprawdzZadanieClass(){return sprawdzZadanieClass;}
}
