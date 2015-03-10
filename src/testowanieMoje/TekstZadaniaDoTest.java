package testowanieMoje;

public class TekstZadaniaDoTest {

	public TekstZadaniaDoTest(){}
	
	protected String ustalonyKod(){
		StringBuilder kod = new StringBuilder("package zadanie;"
				+ "\n"
				+ "\npublic class Zadanie {"
				+ "\n"
				+ "\n\tpublic Zadanie(){}"
				+ "\n"
				+ "\n\tpublic synchronized int zadanie(int[] A){"
				+ "\n"
				+ "\t\tSystem.out.println(\"poszlo... 1\");\n"
				+ "\n\treturn 10;"
				+ "\n\t}\n"
				+ "\n}");
		return kod.toString();
	}
	
	protected String ustalonyKod1(){
		StringBuilder kod = new StringBuilder("package zadanie;"
				+ "\n"
				+ "\npublic class Zadanie {"
				+ "\n"
				+ "\n\tpublic Zadanie(){}"
				+ "\n"
				+ "\n\tpublic synchronized int zadanie(int[] A){"
				+ "\n"
				+ "\t\tSystem.out.println(\"poszlo... 2\");\n"
				+ "\n\treturn 41;"
				+ "\n\t}\n"
				+ "\n}");
		return kod.toString();
	}
}
