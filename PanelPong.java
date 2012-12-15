package pong;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class PanelPong extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;

	private int  PosInitBalleX = 400, PosInitBalleY = 300; // Position initialle de la balle
	private int largballe = 20, HautBalle = 20; // Largeur et hauteur de la balle
	private int VitDroite= 5, VitGauche= -5, VitHaut= 5, VitBas= -5; // Vitesse de la balle
	
	private int PosInitR1X = 0, PosInitR1Y = 200, PosInitR2X = 775, PosInitR2Y = 200; // Position initialle des raquettes
	private int largeurRaquette = 20, HauteurRaquette = 100; // Largeur et hauteur des raquettes
	private int PosScore1X = 100, PosScore1Y = 20, PosScore2X = 600, PosScore2Y = 20; // Position des scores
	
	private int ScoreGameOVer = 5;	// Score pour gagner
	private int ScoreJoueur1 = 0, ScoreJoueur2 = 0; // Score Initiaux
	
	Thread sincro;

	Balle Balle1 = new Balle(largballe,HautBalle,PosInitBalleX,PosInitBalleY,VitDroite,VitGauche,VitHaut,VitBas);
	Raquette Raquette1 = new Raquette(largeurRaquette,HauteurRaquette, PosInitR1X,PosInitR1Y,VitBas,VitHaut);
	Raquette Raquette2 = new Raquette(largeurRaquette, HauteurRaquette, PosInitR2X, PosInitR2Y,VitBas,VitHaut);
	
	//boolean joueur1FlagHaut,player1FlagBas, joueur2FlagHaut, player2FlagAba;
	boolean jeux, gameOver;

	public PanelPong(){
		jeux=true;
		sincro=new Thread(this);
		sincro.start();
	}

	// Graphique
	public void paintComponent(Graphics gc){
		setOpaque(false);
		super.paintComponent(gc);

		gc.setColor(Color.black); // Couleur des composants

		gc.fillOval(Balle1.getposX(), Balle1.getposY(), Balle1.getlargeur(), Balle1.gethauteur()); // Taille de la balle

		// Graphique de la raquette
		gc.fillRect(Raquette1.getposX(), Raquette1.getposY(), Raquette1.getlargeur(), Raquette1.gethauteur());
		gc.fillRect(Raquette2.getposX(), Raquette2.getposY(), Raquette2.getlargeur(), Raquette2.gethauteur());

		// Dessin des scores
		gc.drawString("Joueur 1 : "+ScoreJoueur1, PosScore1X, PosScore1Y);
		gc.drawString("Joueur 2 : "+ScoreJoueur2, PosScore2X, PosScore2Y);

		if(gameOver)
			gc.drawString("Game Over", 400, 300);
	}


	// Reception de la touche relachee
	public void keyReleased(KeyEvent evt){
		switch(evt.getKeyCode()){

		// Raquette 1
		case KeyEvent.VK_Z :
			Raquette1.setflagHaut(false);
			break;
		case KeyEvent.VK_S : 
			Raquette1.setflagBas(false);
			break;

			// Raquette 2
		case KeyEvent.VK_UP:
			Raquette2.setflagHaut(false);
			break;
		case KeyEvent.VK_DOWN:
			Raquette2.setflagBas(false);
			break;
		}
	}

	// Reception de la touche enfoncee		
	public void keyPressed(KeyEvent evt){
		switch(evt.getKeyCode()){

		// Mouvement raquette 1
		case KeyEvent.VK_Z :
			Raquette1.setflagHaut(true);
			break;
		case KeyEvent.VK_S : 
			Raquette1.setflagBas(true);
			break;

			// Mouvement raquette 2
		case KeyEvent.VK_UP:
			Raquette2.setflagHaut(true);
			break;
		case KeyEvent.VK_DOWN:
			Raquette2.setflagBas(true);
			break;
		}
	}

	public void run(){
		while(true){
			
			try {Thread.sleep(15);} // Rapidite du jeux
			catch(InterruptedException ex){}
			
			Balle1.mouvement(jeux); // Mouvement de la Balle
			repaint();
			
			Raquette1.mouvement(); // Mouvement Raquettes
			Raquette2.mouvement();

			if (Balle1.getposX() == 780){ // Incrementation du score 'joueur 1'
				ScoreJoueur1++;
				Balle1.setposX(PosInitBalleX);
				Balle1.setposY(PosInitBalleY);
			}
			
			if ( Balle1.getposX() == 0){ // Incrementation du score 'joueur 2'
				ScoreJoueur2++;
				Balle1.setposX(PosInitBalleX);
				Balle1.setposY(PosInitBalleY);
			}
	
			if(ScoreJoueur1==ScoreGameOVer || ScoreJoueur2==ScoreGameOVer){ // Fin du jeu
				jeux=false;
				gameOver=true;
			}

			// La balle cogne a la raquette 1
			if(Balle1.getposX()==(Raquette1.getposX()+Raquette1.getlargeur()) && Balle1.getposY()>=Raquette1.getposY() && Balle1.getposY()<=(Raquette1.getposY()+Raquette1.gethauteur()))
				Balle1.setdirectionDG(true);

			// La balle cogne a la raquette 2
			if(Balle1.getposX()==(Raquette2.getposX()-Raquette2.getlargeur()) && Balle1.getposY()>=Raquette2.getposY() && Balle1.getposY()<=(Raquette2.getposY()+Raquette2.gethauteur()))
				Balle1.setdirectionDG(false);
		}
	}
}