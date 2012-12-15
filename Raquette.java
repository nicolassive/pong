package pong;

import javax.swing.*;

public class Raquette extends JPanel{
	private static final long serialVersionUID = 1L;
	
	// Variables
	private int largeur, hauteur;
	private int posX, posY;
	private boolean flagHaut,flagBas;
	private int vitHaut;
	private int vitBas;

	// Getters & Setters
	public int getlargeur() {return largeur;}
	public void setlargeur(int largeur) {this.largeur = largeur;}
	public int gethauteur() {return hauteur;}
	public void sethauteur(int hauteur) {this.hauteur = hauteur;}
	public int getposX() {return posX;}
	public void setposX(int posX) {this.posX = posX;}
	public int getposY() {return posY;}
	public void setposY(int posY) {this.posY = posY;}
	public int getvitHaut() {return vitHaut;}
	public void setvitHaut(int vitHaut) {this.vitHaut = vitHaut;}
	public int getvitBas() {return vitBas;}
	public void setvitBas(int vitBas) {this.vitBas = vitBas;}

	public boolean isflagHaut() {return flagHaut;}
	public void setflagHaut(boolean flagHaut) {this.flagHaut = flagHaut;}
	public boolean isflagBas() {return flagBas;}
	public void setflagBas(boolean flagBas) {this.flagBas = flagBas;}
	Thread sincro;

	// Largeur, hauteur, posX, posY, vitBas, vitHaut)
	public Raquette (int l, int h, int x, int y, int vitB, int vitH){
		largeur = l;
		hauteur = h;
		posX = x;
		posY = y;
		vitBas = vitB;
		vitHaut = vitH;
	}

	// Déplacement
	public void mouvement(){
		if (flagHaut == true && posY >= 0)
			posY+=vitBas;
		if (flagBas == true && posY <= (570-hauteur))
			posY+=vitHaut;
	}
}