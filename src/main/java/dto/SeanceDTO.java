//package dto;
//
//import model.Seance;
//
//public class SeanceDTO {
//	
//	int seanceHoraire;
//	String seanceDate;
//	boolean full;
//	FilmDTO filmDTO;
//	SalleDTO salleDTO;
//	int nbrePlaceRestante;
//		
//	public FilmDTO getFilm() {
//		return filmDTO;
//	}
//
//	public void setFilm(FilmDTO film) {
//		this.filmDTO = film;
//	}
//	
//	public SalleDTO getSalle(){
//		return salleDTO;
//	}
//	
//	public void setSalle(SalleDTO salle){
//		this.salleDTO = salle;
//	}
//
//	public SeanceDTO(Seance seance) {
//		seanceHoraire = seance.getSeanceHoraire();
//		full = seance.isFull();
//		nbrePlaceRestante = seance.getNbrePlaceRestante();
//		seanceDate = seance.getdateSeance();
//	}
//
//	public int getSeanceHoraire() {
//		return seanceHoraire;
//	}
//	
//	public boolean isFull(){
//		return full;
//	}
//	
//	public void setSeanceHoraire(int seanceHoraire) {
//		this.seanceHoraire = seanceHoraire;
//	}
//	
//	public void setFull(boolean full){
//		this.full = full;
//	}
//
//	public String getdateSeance() {
//		return seanceDate;
//	}
//	
//	public void setdateSeance(String dateSeance) {
//		this.seanceDate = dateSeance;
//	}
//	
//	public int getPlaceRestante(){
//		return nbrePlaceRestante;
//	}
//	
//	public void setPlaceRestante(int placeRestante){
//		this.nbrePlaceRestante = placeRestante;
//	}
//
//	
//}
