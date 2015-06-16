package dto;

import model.Classement;
import model.IHashPolicy;
import model.Joueur;

public class JoueurDTO {
	int id;
	String name;
	String hashPass;
	transient IHashPolicy hashPolicy;
	int numberVictory;
	int numberDefeat;
	float ratioVicDef;
	Classement classement;

	public JoueurDTO(Joueur joueur) {
		id = joueur.getId();
		name = joueur.getName();
		hashPass = joueur.getHashPass();
		hashPolicy = joueur.getHashPolicy();
		numberVictory = joueur.getNumberVictory();
		numberDefeat = joueur.getNumberDefeat();
		ratioVicDef = joueur.getRatioVicDef();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHashPass() {
		return hashPass;
	}
	public void setHashPass(String hashPass) {
		this.hashPass = hashPass;
	}
	public IHashPolicy getHashPolicy() {
		return hashPolicy;
	}
	public void setHashPolicy(IHashPolicy hashPolicy) {
		this.hashPolicy = hashPolicy;
	}
	public int getNumberVictory() {
		return numberVictory;
	}
	public void setNumberVictory(int numberVictory) {
		this.numberVictory = numberVictory;
	}
	public int getNumberDefeat() {
		return numberDefeat;
	}
	public void setNumberDefeat(int numberDefeat) {
		this.numberDefeat = numberDefeat;
	}
	public float getRatioVicDef() {
		return ratioVicDef;
	}
	public void setRatioVicDef(float ratioVicDef) {
		this.ratioVicDef = ratioVicDef;
	}
	public Classement getClassement() {
		return classement;
	}
	public void setClassement(Classement classement) {
		this.classement = classement;
	}
}
