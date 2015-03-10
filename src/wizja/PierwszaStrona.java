package wizja;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PierwszaStrona extends JFrame{

	private static final long serialVersionUID = 2704600814303886135L;

	private JPanel glownyPanel;
	private JPanel prawyPanel;
	
	private JTextArea areaKodProgramu;
	
	
	private Dimension screenSize;
	public PierwszaStrona(){
		initUI();
	}
	
	private void initUI(){
		
		//---- JMenuBar -------
		//na razie nie potrzebne
		
		glownyPanel = new JPanel();
			glownyPanel.setLayout(new GridLayout(1, 2));
		
		areaKodProgramu = new JTextArea();
		prawyPanel = new JPanel();
			prawyPanel.setLayout(new GridLayout(2, 1));
		
		glownyPanel.add(areaKodProgramu);
			glownyPanel.add(prawyPanel);
		
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		add(glownyPanel);
		setTitle("Kodilitek");
		setSize( screenSize.width, screenSize.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}