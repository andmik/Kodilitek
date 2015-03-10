package swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainWyglad extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4338899108037250022L;
	private JPanel contentPane;

	private Dimension screenSize;
	private JTextArea textZadania;
	private JTextField textField_1;
	
	private JTextArea textPoKompilacji;
	
	private Logika logika;
	private LogikaButtonow logikaButtonow;
	private LogikaZamkniecia logikaZamkniecia;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public MainWyglad() {
		logika = new Logika();
		logikaButtonow = new LogikaButtonow();
		initUI();
	}

	private void initUI(){
		
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, screenSize.width, screenSize.height - 30);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JTextArea textRozwiazaniaArea = new JTextArea(logika.pobierzTekstKlasyZadania(1));
		textRozwiazaniaArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		textRozwiazaniaArea.setBounds(10, 10, (screenSize.width/2 ) - 50, (screenSize.height - 30) - 60);
		contentPane.add(textRozwiazaniaArea);
		
		textZadania = new JTextArea(logika.pobierzTekstZadania(1));
		textZadania.setForeground(new Color(0, 0, 0));
		textZadania.setBackground(new Color(255, 255, 255));
		textZadania.setFont(new Font("Verdana", Font.PLAIN, 12));
		textZadania.setEditable(false);
		textZadania.setEnabled(false);
		textZadania.setBounds(screenSize.width/2, 10, screenSize.width/2-20, screenSize.height/2);
		contentPane.add(textZadania);
		textZadania.setColumns(10);
		
		JButton btnRun = new JButton("RUN");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zmienTextPoKompilacji(logikaButtonow.sprawdzRozwiazanie(textRozwiazaniaArea.getText()));
			}
		});
		
		btnRun.setBackground(new Color(255, 255, 153));
		btnRun.setBounds(640, 421, 91, 23);
		contentPane.add(btnRun);
		
		JButton btnSprawd = new JButton("SPRAWD\u0179");
		btnSprawd.setBackground(new Color(255, 255, 153));
		btnSprawd.setBounds(758, 421, 124, 23);
		contentPane.add(btnSprawd);
		
		JButton btnKoniec = new JButton("KONIEC");
		btnKoniec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logikaZamkniecia = new LogikaZamkniecia();
				logikaZamkniecia.zapiszPlikZadanieUstalonymKodem();
				System.exit(DISPOSE_ON_CLOSE);
			}
		});
		
		btnKoniec.setBackground(new Color(255, 255, 153));
		btnKoniec.setBounds(909, 421, 91, 23);
		contentPane.add(btnKoniec);
		
		textPoKompilacji = new JTextArea();
		textZadania.setForeground(new Color(0, 0, 0));
		textZadania.setBackground(new Color(255, 255, 255));
		textPoKompilacji.setFont(new Font("Monospaced", Font.BOLD, 14));
		textPoKompilacji.setEnabled(false);
		textPoKompilacji.setEditable(false);
		textPoKompilacji.setBounds(640, 455, 620, 210);
		contentPane.add(textPoKompilacji);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setBounds(640, 679, 620, 34);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
	
	private void zmienTextPoKompilacji( List<String> lista){
		textPoKompilacji.setText("");
		
		StringBuilder sb = new StringBuilder();
		
		for(String str: lista){
			sb.append(str);
		}
		textPoKompilacji.setText(sb.toString());
	}
}