package dto;

import model.Classement;
import model.Joueur;

public class ClassementDTO {
	int idClassement;

	int placement;
	Joueur joueur;

	public ClassementDTO(Classement classement) {
		idClassement = classement.getIdClassement();
		placement = classement.getPlacement();
		joueur = classement.getJoueur();
	}
	
	public int getIdClassement() {
		return idClassement;
	}

	public void setIdClassement(int idClassement) {
		this.idClassement = idClassement;
	}

	public int getPlacement() {
		return placement;
	}

	public void setPlacement(int placement) {
		this.placement = placement;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	
}
