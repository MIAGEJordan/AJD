//package mainApp;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//
//import model.Film;
//import model.Person;
//import model.Reserv;
//import model.Salle;
//import model.Seance;
//
//public class mainApp {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
//		EntityManager entityManager = emf.createEntityManager();
//		
//		EntityTransaction tx = entityManager.getTransaction();
//		tx.begin();
//		
//		//création d'un client
//		Person person1 = new Person("Alexandra Lemaire");
//		Person person2 = new Person("Marion Boko");
//		Person person3 = new Person("Flora Guy Coichard");
//		Person person4 = new Person("Jordan Vo Ngoc");
//		
//		//création d'un film
//		Film film1 = new Film("Wall-e", "Un petit robot sauve la Terre", "Bob Marley", "Dessin", "image", 250);
//		Film film2 = new Film("Pocahontas", "Une indienne", "Elie Semouy", "Dessin", "image", 230);
//		Film film3 = new Film("Big Fish", "C'est l'histoire d'un poisson", "Tim Burton", "Fantastique", "image", 240);
//		Film film4 = new Film("Le jour d'après", "La vie est une misère", "James Cameron", "Catastrophe", "image", 320);
//		
//		//creation d'une seance
//		
//		Salle salle1 = new Salle("Soleil", 100);
//		Salle salle2 = new Salle("Mer", 2);
//				
//		String dateduJour = "30/06";
//		String dateduJour2 = "02/07";
//		
//		Seance sea1 = new Seance(film1,14,salle1,dateduJour);
//		Seance sea2 = new Seance(film2,12,salle2,dateduJour2);
//		
//		film1.getSeances().add(sea1);
//		salle1.getSeances().add(sea1);
//		
//		film2.getSeances().add(sea2);
//		salle2.getSeances().add(sea2);
//		
//		
//		Reserv res = new Reserv(sea2, person1, dateduJour);
//		person1.getReservations().add(res);
//		sea2.getReservations().add(res);
//		
//		sea2.decrementerPlaceRestante();
//		
//		Reserv res2 = new Reserv(sea2, person2, dateduJour2);
//		person1.getReservations().add(res2);
//		sea2.getReservations().add(res2);
//
//		sea2.decrementerPlaceRestante();
//				
//		entityManager.persist(person1);
//		entityManager.persist(person2);
//		entityManager.persist(person3);
//		entityManager.persist(person4);
//		entityManager.persist(film1);
//		entityManager.persist(film2);
//		entityManager.persist(film3);
//		entityManager.persist(film4);
//		entityManager.persist(salle1);
//		entityManager.persist(salle2);
//		entityManager.persist(sea1);
//		entityManager.persist(sea2);
//
//		entityManager.persist(res);
//		entityManager.persist(res2);
//		
//		tx.commit();
//		
//	
//		entityManager.close();
//		emf.close();
//		
//		
//		
//	}
//
//}
