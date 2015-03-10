package zadanie;

import swing.NumerZadaniaRozwiazywanego;

public class AlgorytmyDoZadan {

	private Algorytm1 algorytm1;
	private CiagiDoZadania ciagiDoZadania;
	private NumerZadaniaRozwiazywanego numerZadaniaRozwiazywanego;
	
	public AlgorytmyDoZadan(){
		this.ciagiDoZadania = new CiagiDoZadania();
	}
	
	public int algorytm1(){
		numerZadaniaRozwiazywanego = new NumerZadaniaRozwiazywanego();
		
		switch(numerZadaniaRozwiazywanego.getNrZadaniaRozwiazywanego()){
		case 1:
			algorytm1 = new Algorytm1();
			return algorytm1.oblicz(ciagiDoZadania.ciag1());
		default:

			algorytm1 = new Algorytm1();
			return algorytm1.oblicz(ciagiDoZadania.ciag1());
		}
	}
}

class Algorytm1{
	
	public Algorytm1(){}
	
	public int oblicz(int[] A){
		
        int sum = 0;
        int correctSum = 0;
        int i = 0;
        
        for( i=0; i<A.length; i++){
            sum += A[i];
            correctSum += (i+1);
        }    
         correctSum += (i+1);
        
        return (correctSum-sum);

	}
}