$(document).ready(function(){
	

	$( ".datePickerDeparture" ).datetimepicker({
		
		 lang:'de',
		 i18n:{
		  de:{
		   months:['Janvier', 'Fevrier', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'Aout', 'Septembre', 'Octobre', 'Novembre', 'Decembre'],
		   
		   dayOfWeek:['Dim.', 'Lun.', 'Mar.', 'Mer.', 'Jeu.', 'Ven.', 'Sam.']
			   
		    
		  }
		 },
		
		minDate: new Date()
	});
		
	
	
});