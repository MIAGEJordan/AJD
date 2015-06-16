package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Cette classe définit le classement globale
 * @author Jordan
 * 	
 */
@Entity
public class Classement {
	@Id
	int idClassement;
	@OneToOne(mappedBy = "classement")
	private Joueur joueur; 
	int placement;

	public Classement(){}
	
	@GeneratedValue(strategy=GenerationType.AUTO)
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
