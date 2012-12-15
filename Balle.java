package pong;

import javax.swing.JPanel;

public class Balle extends JPanel {
	private static final long serialVersionUID = 1L;

	// Variables
	private int largeur, hauteur;
	private int posX;
	private int posY;
	private int vitDroite;
	private int vitGauche;
	private int vitHaut;
	private int vitBas;
	private boolean directionDG=false; // droite / gauche
	private boolean directionHB=false; // haut / bas

	// Getters & Setters
	public int getlargeur() {return largeur;}
	public void setlargeur(int l) {largeur = l;}
	public int gethauteur() {return hauteur;}
	public void sethauteur(int h) {hauteur = h;}
	public int getposX() {return posX;}
	public void setposX(int x) {posX = x;}
	public int getposY() {return posY;}
	public void setposY(int y) {posY = y;}
	public int getvitDroite() {return vitDroite;}
	public void setvitDroite(int vitD) {vitDroite = vitD;}
	public int getvitGauche() {return vitGauche;}
	public void setvitGauche(int vitG) {vitGauche = vitG;}
	public int getvitHaut() {return vitHaut;}
	public void setvitHaut(int vitH) {vitHaut = vitH;}
	public int getvitBas() {return vitBas;}
	public void setvitBas(int vitB) {vitBas = vitB;}
	public boolean isdirectionDG() {return directionDG;}
	public void setdirectionDG(boolean DG) {directionDG = DG;}
	public boolean isdirectionHB() {return directionHB;}
	public void setdirectionHB(boolean HB) {directionHB = HB;}

	public Balle (int l, int h, int x, int y, int vitD, int vitG, int vitH, int vitB){
		largeur = l;
		hauteur = h;
		posX = x;
		posY = y;
		vitDroite = vitD;
		vitGauche = vitG;
		vitHaut = vitH;
		vitBas = vitB;
	}

	// mouvement de la balle
	public void mouvement(boolean jeux){
		if(jeux){			
			if (directionDG){ // Droite
				posX += vitDroite;
				if (posX >= 780)
					directionDG= false;
			}
			else{ // Gauche
				posX += vitGauche;
				if ( posX <= 0)
					directionDG =  true;
			}
			if (directionHB){ // Haut
				posY += vitHaut;
				if (posY >= 550)
					directionHB= false;
			}
			else{ // Bas
				posY += vitBas;
				if ( posY <= 0)
					directionHB =  true;
			}
		}
	}
}