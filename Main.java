package pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame{
	private static final long serialVersionUID = 1L; // Ajout automatique d'Eclipse
	private JPanel jContentPane = null;
	private PanelPong panel = null;
	int resoX = 800, resoY = 600;
	private PanelPong getPanel(){
		if (panel == null){
			// Cr�ation du Panel
			panel = new PanelPong(); 
		}
		return panel;
	}

	public Main(){
		super();
		initialize();
		
		// Ecoute du clavier
		this.addKeyListener(new KeyAdapter(){
			// Ecoute quand une touche est enfonc�e
			public void keyPressed(KeyEvent evt){
				formKeyPressed(evt);
			}
			// Ecoute quand une touche est relach�e
			public void keyReleased(KeyEvent evt){
				formKeyReleased(evt);
			}
		});
	}

	// Envoi la touche press�e
	private void formKeyPressed(KeyEvent evt){
		panel.keyPressed(evt);
	}

	// Envoi la touche relach�e
	private void formKeyReleased(KeyEvent evt){
		panel.keyReleased(evt);
	}

	// Initialisation du terrain
	private void initialize() {
		this.setResizable(false);
		this.setBounds(new Rectangle(800, 300, resoX, resoY)); //800,300 = position sur le bureau 800/600 = taille de la fen�tre
		this.setContentPane(getJContentPane());
		this.setTitle("Pong");
	}

	private JPanel getJContentPane(){
		if (jContentPane == null){
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getPanel(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Main thisClass = new Main();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}
}