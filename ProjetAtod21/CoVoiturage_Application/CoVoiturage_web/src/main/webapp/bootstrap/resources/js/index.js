$(function() {
	
	var owl = $("#owl-demo");
	 
	owl.owlCarousel({
		autoPlay : 5000,
		items : 10,
		singleItem : true,
	    autoHeight : true,
	    pagination: false
	});
 
	$(".play").click(function(){
		owl.trigger('owl.play',1000); //owl.play event accept autoPlay speed as second parameter
	});
	 
	$(".datePickerDeparture" ).datetimepicker({
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