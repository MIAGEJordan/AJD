//package web;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.Query;
//
//import model.Film;
//import model.Person;
//import model.Reserv;
//import model.Salle;
//import model.Seance;
//
//import org.springframework.hateoas.ResourceSupport;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//import dto.SalleDTO;
//import dto.SeanceDTO;
//import dto.FilmDTO;
//
//
//@Controller
//public class MyReservController implements ReservService{
//	
//	EntityManager entityManager;
//
//	List<Seance> seances = new ArrayList<Seance>();
//	List<Film> films = new ArrayList<Film>();
//	
//	
//	public MyReservController(){
//		
//		// Extraction de la liste des séances disponibles		
//		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
//		entityManager = emf.createEntityManager();
//		String sql = "SELECT * FROM PUBLIC.SEANCE";
//		Query query = entityManager.createNativeQuery(sql, Seance.class);
//		try {
//			seances = query.getResultList();
//		} catch (Exception e) {
//			throw e;
//		}
//			
//		String sql2 = "SELECT * FROM PUBLIC.FILM";
//		Query query2 = entityManager.createNativeQuery(sql2, Film.class);
//		try {
//			films = query2.getResultList();
//		} catch (Exception e) {
//			throw e;
//		}	
//	
//	}
//	
//	@RequestMapping(value = "/entryPoint", method = RequestMethod.GET)
//	@ResponseStatus(HttpStatus.OK)
//	@ResponseBody
//	@Override
//	public ResourceSupport get() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	/**
//	*
//	* @return all seance not full
//	*/
//	@RequestMapping(value = "/seance", method = RequestMethod.GET)
//	@ResponseStatus(HttpStatus.OK)
//	@ResponseBody
//	@Override
//	public List<SeanceDTO> getSeances() {
//		
//		List<SeanceDTO> dtos = new ArrayList<SeanceDTO>();
//		Seance seance;
//		Film film;
//		Salle salle;
//		
//		for(int i=0; i<seances.size(); i++){	// parcours BDD
//			seance = seances.get(i);
//			film = seances.get(i).getFilm();
//			salle = seances.get(i).getSalle();
//			// extrait ième 
//			if(seance.isFull() == false){	// ? pleine
//				SeanceDTO dto = new SeanceDTO(seance);
//				FilmDTO dtof = new FilmDTO(film);
//				SalleDTO dto_salle = new SalleDTO(salle);
//				dto.setFilm(dtof);
//				dto.setSalle(dto_salle);
//				dtos.add(dto);				
//			}
//		}
//		return dtos;
//	}
//
//	/**
//	*
//	* @return all film
//	*/
//	@RequestMapping(value = "/film", method = RequestMethod.GET)
//	@ResponseStatus(HttpStatus.OK)
//	@ResponseBody
//	@Override
//	public List<FilmDTO> getFilms() {
//		List<FilmDTO> dtofs = new ArrayList<FilmDTO>();
//		Film film;
//		for(int i=0; i<films.size(); i++){	// parcours BDD
//			film = films.get(i);				// extrait ième 
//			FilmDTO dtof = new FilmDTO(film);
//			dtofs.add(dtof);				
//		}
//		return dtofs;
//	}
//
//	/**
//	* Return specifications of a seaance.
//	* @param seanceNumber
//	* @return 
//	* @throws 
//	*/
//	
//	@RequestMapping(value = "/seance/{seanceNumber}", method = RequestMethod.GET)
//	@ResponseStatus(HttpStatus.OK)
//	@ResponseBody
//	@Override
//	public SeanceDTO getSeance(@PathVariable("seanceNumber") int seanceNumber) throws Exception {
//		Seance seance;
//		Film film;
//		Salle salle;
//		int i=0;
//		while(i<seances.size() && seances.get(i).getId() != seanceNumber){
//			i++;
//		}
//		if(i<seances.size()){	// seance trouvée
//			seance = seances.get(i);
//			film = seances.get(i).getFilm();
//			salle = seances.get(i).getSalle();
//			SeanceDTO dto = new SeanceDTO(seance);
//			FilmDTO dtof = new FilmDTO(film);
//			SalleDTO dto_salle = new SalleDTO(salle);
//			dto.setFilm(dtof);
//			dto.setSalle(dto_salle);
//			return dto;
//		} else {			// seance non trouvée
//			throw new IOException("Pas de seance avec ce nombre");
//		}
//	}
//	
//		
//	/**
//	* Return specifications of a film.
//	* @param filmNumber
//	* @return films specifications
//	* @throws Exception no film with this filmNumber
//	*/
//	@RequestMapping(value = "/film/{filmNumber}", method = RequestMethod.GET)
//	@ResponseStatus(HttpStatus.OK)
//	@ResponseBody
//	@Override
//	public FilmDTO getFilm(@PathVariable("filmNumber") int filmNumber) throws Exception {
//		Film film;
//		int i=0;
//		while(i<films.size() && films.get(i).getId() != filmNumber){
//			i++;
//		}
//		if(i<films.size()){	// seance trouvée
//			film = films.get(i);
//			return new FilmDTO(film);
//		} else {			// seance non trouvée
//			throw new IOException("Pas de film avec cet identifiant");
//		}
//	}
//	
//	/**
//	* Reserver une seance.
//	* @param seanceNumber
//	* @return film specifications
//	* @throws Exception
//	*/
//	@RequestMapping(value = "/reserv", method = RequestMethod.POST)
//	@ResponseStatus(HttpStatus.OK)
//	@Override
//	public void reservSeance(@PathVariable("seanceNumber") int seanceNumber, @PathVariable ("personName") String name) throws Exception {
//		int  i = 0;
//		while(i<seances.size() && seances.get(i).getId() != seanceNumber){
//			i++;
//		}
//		if(i < seances.size()){
//			if(seances.get(i).isFull() == false){ //seance non pleine
//				Person person = new Person(name);
//				Seance seance = seances.get(i);
//				String dateduJour = "";
//				Reserv res = new Reserv(seance, person, dateduJour);
//				seances.get(i).decrementerPlaceRestante();
//			} else {
//				throw new Exception("Seance already full");
//			}
//		} else {
//			throw new Exception("No seance with such a seance number");
//		}
//	}
//
//}
