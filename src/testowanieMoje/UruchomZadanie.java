package testowanieMoje;

import zadanie.Zadanie;

public class UruchomZadanie implements Runnable{

	public UruchomZadanie(){}
	
	public void uruchomZadanie(){
		System.out.println("\n klasa UruchomZadanie \n");
		Zadanie zadanie = new Zadanie();
		int[] A = {1,2,3,5};
		zadanie.zadanie(A);
	}

	@Override
	public void run() {
		uruchomZadanie();
	}
}
