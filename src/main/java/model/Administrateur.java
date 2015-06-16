package model;
/**
 * Classe d�finissant le joueur comme administrateur lui octroyant plusieurs droits :
 * 	- Modification du nombre de victoire d'un joueur.
 *  - Modification du nombre de d�faite d'un joueur.
 *  - Suppression d'un utilisateur. 
 * @author Jordan
 */
public class Administrateur extends Joueur {
	boolean isAdmin;

	public Administrateur(String name) {
		super(name);
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}
