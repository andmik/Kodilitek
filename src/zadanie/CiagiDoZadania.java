package zadanie;

import swing.NumerZadaniaRozwiazywanego;

public class CiagiDoZadania {

	private NumerZadaniaRozwiazywanego numerZadaniaRozwiazywanego;
	
	public CiagiDoZadania(){
		this.numerZadaniaRozwiazywanego = new NumerZadaniaRozwiazywanego();
	}

	public int[] ciag1(){
		
		switch(numerZadaniaRozwiazywanego.getNrZadaniaRozwiazywanego()){
		case 1:	
			int[] A = {3, 2, 1, 6, 4};
			return A;
		default:
			int[] A1 = {0};
			return A1;
		}
	}
}