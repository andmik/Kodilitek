package wizja;

import java.awt.EventQueue;

public class Glowna {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run(){
				new PierwszaStrona();
			}
		});
	}

}