$(function() {
    
	$('.dropdown-menu').find('div').click(function (e) {
        e.stopPropagation();
    });
    
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
	
	 $('.listTrajet').dataTable({
		 searching : false,
		 "order": [[ 2, "desc" ]],
		 language : {
			    "sProcessing":     "Traitement en cours...",
			    "sSearch":         "Rechercher&nbsp;:",
			    "sLengthMenu":     "Afficher _MENU_ &eacute;l&eacute;ments",
			    "sInfo":           "Affichage de l'&eacute;lement _START_ &agrave; _END_ sur _TOTAL_ &eacute;l&eacute;ments",
			    "sInfoEmpty":      "Affichage de l'&eacute;lement 0 &agrave; 0 sur 0 &eacute;l&eacute;ments",
			    "sInfoFiltered":   "(filtr&eacute; de _MAX_ &eacute;l&eacute;ments au total)",
			    "sInfoPostFix":    "",
			    "sLoadingRecords": "Chargement en cours...",
			    "sZeroRecords":    "Aucun &eacute;l&eacute;ment &agrave; afficher",
			    "sEmptyTable":     "Aucune donnée disponible dans le tableau",
			    "oPaginate": {
			        "sFirst":      "Premier",
			        "sPrevious":   "Pr&eacute;c&eacute;dent",
			        "sNext":       "Suivant",
			        "sLast":       "Dernier"
			    },
			    "oAria": {
			        "sSortAscending":  ": activer pour trier la colonne par ordre croissant",
			        "sSortDescending": ": activer pour trier la colonne par ordre décroissant"
			    }
		}
	 });
});