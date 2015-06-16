$(document).ready( function(){

	/*var listOfSeance = getListOfSeance();			

	$.each(listOfSeance, function(key, val) {
				var seanceName = val["seanceHoraire"];
				$('#seancesListSelectId').append(
						"<tr><td>" + seanceName + "</td></tr>");
			});

			$.each( listOfSeance, function( key, val ) {	
				var movieName = val["seanceHoraire"];
				 $('#moviesListSelectId').append("<option>" + movieName + "</option>");
			});*/

	var listOfFilm = getListOfFilm();			
	$.each(listOfFilm, function(key, val) {
		var filmName = val["filmName"];
		$('#moviesListSelectId').append("<option value="+key+">" + filmName + "</option>");
	});


});

/*
 * Récupère la liste de toutes les séances
 * 
 */

function getListOfSeance() {
	var uri = "http://localhost:8081/Cinemax/seance/";
	var seance;
	$.ajax({
		url : uri,
		dataType : 'json',
		async : false,
		type : 'GET',
		success : function(data) {
			seance = data;
		},
		error : function(jqXHR) {
			throw new Error(jqXHR.status + ". " + jqXHR.responseText);
		}
	});
	return seance;
}

/*
 * Récupère la liste de tout les films
 * 
 */

function getListOfFilm() {
	var uri = "http://localhost:8081/Cinemax/film/";
	var film;
	$.ajax({
		url : uri,
		dataType : 'json',
		async : false,
		type : 'GET',
		success : function(data) {
			film = data;
		},
		error : function(jqXHR) {
			throw new Error(jqXHR.status + ". " + jqXHR.responseText);
		}
	});
	return film;
}

function resetValue(selectName){
	
	var Obj = document.getElementById(""+selectName);
	Obj.selectedIndex = 0;
	
	for(var i = 1; i<Obj.options.length; i++){
		Obj.removeChild(Obj.options[i]);
	}
	
}

function search_salle(){

	var listOfSeances = getListOfSeance();	
	var select = document.getElementById("moviesListSelectId");
	var texte = select.options[select.selectedIndex].text;

	resetValue("salleListSelectId");	
	resetValue("dayListSelectId");
	resetValue("horaireListSelectId");
	resetValue("nbPlacesSelectId");
	
	$.each(listOfSeances, function(key, val) {		
		if( texte == val["film"].filmName){			
			$('#salleListSelectId').append("<option value="+key+">" + val["salle"].salleName + "</option>");
		}

	});
}

function search_day(){
	
	var listOfSeances = getListOfSeance();	
	
	select = document.getElementById("salleListSelectId");
	choice = select.selectedIndex;
	texte = select.options[choice].text;

	$.each(listOfSeances, function(key, val) {
		var salleName = val["salle"].salleName;
		var dayOfSeance = val["dateSeance"];
		var horaireSeance = val["seanceHoraire"];
		
		if(texte !="Choisir une salle"){
			if( salleName == texte){			
				$('#dayListSelectId').append("<option value="+key+">" + dayOfSeance + "</option>");
				$('#horaireListSelectId').append("<option value="+key+">" + horaireSeance + "h </option>");
			}
		}else{
			document.getElementById("dayListSelectId").selectedIndex = 0;
			document.getElementById("horaireListSelectId").selectedIndex = 0;
		}

	});	

}

function search_nbPlaces(){
	var listOfSeances = getListOfSeance();	

	select = document.getElementById("salleListSelectId");
	choice = select.selectedIndex;
	texte = select.options[choice].text;
	
	select2 = document.getElementById("horaireListSelectId");
	choice2 = select2.selectedIndex;
	texte2 = select2.options[choice2].text;
	
	select3 = document.getElementById("moviesListSelectId");
	choice3 = select3.selectedIndex;
	texte3 = select3.options[choice3].text;

	$.each(listOfSeances, function(key, val) {
		var salleName = val["salle"].salleName;
		var nbPlaces = val["placeRestante"];
		
		if(texte2 !="Choisir une séance"){
			if( (salleName == texte) && ( val["film"].filmName == texte3)){	
				
				for(var i = 1; i<nbPlaces; i++){
					if(i <=5){
						$('#nbPlacesSelectId').append("<option value="+key+">" + i + "</option>");
					}
				}
			}
		}

	});	
	
}



