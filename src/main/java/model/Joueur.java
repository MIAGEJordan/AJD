package model;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Cette classe définit le joueur pour les statistiques des parties.
 * @author Jordan
 * @author Matthieu
 */
@Entity
public class Joueur {
	@Id
	int id;
	String name;
	String hashPass;
	IHashPolicy hashPolicy;
	int numberVictory;
	int numberDefeat;
	float ratioVicDef;
	
    @OneToOne
    @JoinColumn(name = "idClassement")
	Classement classement;
	
	public Joueur(){}
	
	public Joueur(String name){
		this.name = name;
		hashPolicy = new HashSHA256();
	}
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String s) throws Exception {
		hashPass = hashPolicy.hashString(s);
	}
	public int getNumberVictory() {
		return numberVictory;
	}

	public void setNumberVictory(int numberVictory) {
		this.numberVictory = numberVictory;
	}

	public int getNumnerDefeat() {
		return numberDefeat;
	}

	public void setNumnerDefeat(int numnerDefeat) {
		this.numberDefeat = numnerDefeat;
	}

	public float getRatioVicDef() {
		return ratioVicDef;
	}

	public void setRatioVicDef(float ratioVicDef) {
		this.ratioVicDef = ratioVicDef;
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

	public int getNumberDefeat() {
		return numberDefeat;
	}

	public void setNumberDefeat(int numberDefeat) {
		this.numberDefeat = numberDefeat;
	}

	public void setId(int id) {
		this.id = id;
	}
	  @Override
	    public String toString() {
	        return String.format(
	                "Joueur[id=%d, name='%s', numberVictory='%s', numberDefeat='%s', ratioVicDef='%s']",
	                id, name, numberVictory,numberDefeat,ratioVicDef);
	    }
}