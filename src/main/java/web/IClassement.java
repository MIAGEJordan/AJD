package web;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import dto.ClassementDTO;
import dto.JoueurDTO;
/**
 * Interface pour le classement des joueurs
 * @author Jordan
 *
 */
public interface IClassement {
	
	@RequestMapping(value = "/entryPoint", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResourceSupport get();
	
	/**
	* @return classement des meilleurs joueurs
	*/
	@RequestMapping(value = "/classement/top", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<ClassementDTO> getTopClassement();
	
	/**
	* @return classement des moins bon joueurs
	*/
	@RequestMapping(value = "/classement/bad", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<ClassementDTO> getBadClassement();
	
	/**
	* @return liste des joueurs
	*/
	@RequestMapping(value = "/joueurs", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<JoueurDTO> getJoueurs();
	
	/**
	* @param id
	* @return liste des joueurs
	* @throws Exception Il n'y a pas de joueurs correspondant à cet id : %ID%
	*/
	@RequestMapping(value = "/joueur/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public JoueurDTO getJoueur(@PathVariable("id") Integer id) throws Exception;
	
	/**
	* Supprimer un joueur
	* @param id
	* @throws Exception Il n'y a pas de joueurs correspondant à cet id : %ID%
	*/
	@RequestMapping(value = "/joueur/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteJoueur(@PathVariable("id") Integer id) throws Exception;
	
	/**
	* Ajouter un joueur
	* @param name
	* @throws Exception Le joueur existe déjà
	*/
	@RequestMapping(value = "/joueur/{name}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void ajoutJoueur(@PathVariable("name") String name) throws Exception;
	
	/**
	* Mettre à jour le score d'un joueur
	* @throws Exception Le joueur existe déjà
//	*/
//	@RequestMapping(value = "/joueur/{name}", method = RequestMethod.PUT)
//	@ResponseStatus(HttpStatus.OK)
//	public void ajoutJoueur(@PathVariable("name") String name) throws Exception;

}
