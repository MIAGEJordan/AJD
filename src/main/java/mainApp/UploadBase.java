package mainApp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Administrateur;
import model.Classement;
import model.Joueur;

public class UploadBase {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Joueur j1 = new Joueur("Jordan");
		Classement classement = new Classement();
		classement.setIdClassement(0);
		classement.setPlacement(1);
		classement.setJoueur(j1);
		
		em.persist(j1);
		em.persist(classement);
		tx.commit();
		em.close();
		emf.close();

	}
	
}
