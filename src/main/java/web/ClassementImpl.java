package web;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Classement;
import model.Joueur;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import dto.ClassementDTO;
import dto.JoueurDTO;

/**
 * Controlleur Classement
 * @author Jordan
 *
 */

@Controller
public class ClassementImpl implements IClassement {
	List<Classement> classements = new ArrayList<Classement>();	
	List<Joueur> joueurs = new ArrayList<Joueur>();	
	
	public ClassementImpl(){		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		EntityManager em = emf.createEntityManager();
		String sql = "SELECT * FROM PUBLIC.JOUEUR";
		Query query = em.createNativeQuery(sql, Joueur.class);
		try {
			joueurs = query.getResultList();
		} catch (Exception e) {
			throw e;
		}
			
		String sql2 = "SELECT * FROM PUBLIC.CLASSEMENT";
		Query query2 = em.createNativeQuery(sql2, Classement.class);
		try {
			classements = query2.getResultList();
		} catch (Exception e) {
			throw e;
		}	
	}
	
	
	@RequestMapping(value = "/entryPoint", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@Override
	public ResourceSupport get() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Récupère la liste des 5 premiers du classement
	 * @return classement des meilleurs joueurs
	 */
	@RequestMapping(value = "/classement/top", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@Override
	public List<ClassementDTO> getTopClassement() {
		ClassementDTO classementDTO;
		List<ClassementDTO> dtos = new ArrayList<ClassementDTO>();

		for(Classement classement : classements){
			if(classement.getPlacement() < 5){
				classementDTO = new ClassementDTO(classement);
				dtos.add(classementDTO);
			}
		}
		return dtos;
	}
	
	/**
	 * Récupère la liste des 5 derniers du classement
	 * @return classement des moins bon joueurs
	 */
	@RequestMapping(value = "/classement/bad", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@Override
	public List<ClassementDTO> getBadClassement() {
		ClassementDTO classementDTO;
		List<ClassementDTO> dtos = new ArrayList<ClassementDTO>();

		for(Classement classement : classements){
			if(classement.getPlacement() > (classements.size() - 5)){
				classementDTO = new ClassementDTO(classement);
				dtos.add(classementDTO);
			}
		}
		return dtos;
	}
	
	/**
	* @return liste des joueurs
	*/
	@RequestMapping(value = "/joueurs", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@Override
	public List<JoueurDTO> getJoueurs() {
		JoueurDTO joueurDTO;
		List<JoueurDTO> dtos = new ArrayList<JoueurDTO>();
		
		for(Joueur joueur : joueurs){
			joueurDTO = new JoueurDTO(joueur);
			dtos.add(joueurDTO);
		}
		return dtos;
	}
	
	/**
	* @param id
	* @return liste des joueurs
	* @throws Exception Il n'y a pas de joueurs correspondant à cet id : %ID%
	*/
	@RequestMapping(value = "/joueur/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@Override
	public JoueurDTO getJoueur(Integer id) throws Exception {
		int  i = 0;
		while(i<joueurs.size() && joueurs.get(i).getId() == id){
			i++;
		}
		if(i < joueurs.size()){
			return new JoueurDTO(joueurs.get(i));
		} else {
			throw new Exception("Il n'y a pas de joueurs correspondant à cet id : " + id);
		}
	}
	
	/**
	* Supprimer un joueur
	* @param id
	* @throws Exception Il n'y a pas de joueurs correspondant à cet id : %ID%
	*/
	@RequestMapping(value = "/joueur/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteJoueur(@PathVariable("id") Integer id) throws Exception {
		int  i = 0;
		while(i<joueurs.size() && joueurs.get(i).getId() == id){
			i++;
		}
		if(i < joueurs.size()){
			supprimerJoueur(joueurs.get(i).getId());
		} else {
			throw new Exception("Il n'y a pas de joueurs correspondant à cet id : " + id);
		}
	}
	
	private void supprimerJoueur(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		EntityManager em = emf.createEntityManager();
		String sql = "DELETE FROM PUBLIC.JOUEUR WHERE ID = " + id;
		Query query = em.createNativeQuery(sql, Joueur.class);
	}
	
	/**
	* Ajouter un joueur
	* @param name
	* @throws Exception Le joueur existe déjà
	*/
	@RequestMapping(value = "/joueur/{name}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void ajoutJoueur(@PathVariable("name") String name) throws Exception{
		int  i = 0;
		while(i<joueurs.size() && joueurs.get(i).getName().compareTo(name)!=0){
			i++;
		}
		if(i < joueurs.size()){
			throw new Exception("Le joueur existe déjà.");
		} else {
			ajouterJoueur(name);
		}
	}

	private void ajouterJoueur(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		EntityManager em = emf.createEntityManager();
		String sql = "INSERT INTO PUBLIC.JOUEUR VALUES (?,"+name+",?,?,?,?)";
		Query query = em.createNativeQuery(sql, Joueur.class);		
	}
	
	// Ajouter score 
	// mettre à jour le score le ration les defaites et les victoires du joueur 
}
