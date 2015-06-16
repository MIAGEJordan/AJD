//package web;
//
//import java.util.List;
//
//import org.springframework.hateoas.ResourceSupport;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//import dto.FilmDTO;
//import dto.SeanceDTO;
//
//public interface ReservService {
//
//	@RequestMapping(value = "/entryPoint", method = RequestMethod.GET)
//	@ResponseStatus(HttpStatus.OK)
//	@ResponseBody
//	public ResourceSupport get();
//	
//	/**
//	*
//	* @return all seance
//	*/
//	@RequestMapping(value = "/seance", method = RequestMethod.GET)
//	@ResponseStatus(HttpStatus.OK)
//	@ResponseBody
//	public List<SeanceDTO> getSeances();
//	
//	/**
//	*
//	* @return all film
//	*/
//	@RequestMapping(value = "/film", method = RequestMethod.GET)
//	@ResponseStatus(HttpStatus.OK)
//	@ResponseBody
//	public List<FilmDTO> getFilms();
//	
//	/**
//	* Return specifications of a car.
//	* @param plateNumber
//	* @return car specifications only (if not rented)
//	* @throws Exception no car with this plate number or already rented
//	*/
//	@RequestMapping(value = "/seance/{seanceNumber}", method = RequestMethod.GET)
//	@ResponseStatus(HttpStatus.OK)
//	@ResponseBody
//	public SeanceDTO getSeance(@PathVariable("seanceNumber") int plateNumber) throws Exception;
//	
//	/**
//	* Return specifications of a film.
//	* @param NameFilm
//	* @return films
//	* @throws Exception
//	*/
//	@RequestMapping(value = "/film/{filmNumber}", method = RequestMethod.GET)
//	@ResponseStatus(HttpStatus.OK)
//	@ResponseBody
//	public FilmDTO getFilm(@PathVariable("filmNumber") int filmNumber) throws Exception;
//	
//	/**
//	*
//	** @
//	* @
//	*/
//	@RequestMapping(value = "/reserv", method = RequestMethod.POST)
//	@ResponseStatus(HttpStatus.OK)
//	public void reservSeance(@PathVariable("seanceNumber") int plateNumber, @PathVariable("personName") String personName) throws Exception;
//
//	
//}
