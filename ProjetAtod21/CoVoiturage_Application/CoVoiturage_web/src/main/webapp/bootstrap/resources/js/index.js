$(function() {
    
	$('.dropdown-menu').find('div').click(function (e) {
        e.stopPropagation();
    });
    
	var owl = $("#owl-demo");
	var owl_right = $("#owl-demo-right");
	var owl_left = $("#owl-demo-left");
	 
	owl.owlCarousel({
		autoPlay : 5000,
		items : 10,
		singleItem : true,
	    autoHeight : false,
	    pagination: false
	});
	
	owl_left.owlCarousel({
		autoPlay : 10000,
		items : 10,
		singleItem : true,
	    autoHeight : false,
	    pagination: false,
	    slideSpeed : 1000,
	    lazyEffect : "fade",
	    transitionStyle : "fade"
	});
	
	owl_right.owlCarousel({
		autoPlay : 10000,
		items : 10,
		singleItem : true,
	    autoHeight : false,
	    pagination: false,
	    slideSpeed : 1000,
	    lazyEffect : "fade",
	    transitionStyle : "fade"
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
	 
	 
//	 if($('#destinationForBanner')){
//		 updateBanners($('#destinationForBanner').val());
//     }
	 
     updateBanners = function(destination)
     {
         $.ajax
         (
             {
                 url:'/CoVoiturage_web/pub',
                 data:{"destination":destination},
                 type:'post',
                 cache:false,
                 success: function(data) { rebuildCarousels(data);},
                 error:function(){console.error('error');}
             }
         );
     };
	 
     rebuildCarousels = function(data){
    	 
//    	var banners = [
//    	               {"elem" : $("#owl-demo-left"), "owl" : $("#owl-demo-left").data('owlCarousel'), "newitems" : data[0].hotel},
//    	               {"elem" : $("#owl-demo-right"), "owl" : $("#owl-demo-right").data('owlCarousel'), "newitems" : data[0].restaurant},
//    	               {"elem" : $("#owl-demo"), "owl" : $("#owl-demo").data('owlCarousel'), "newitems" : data[0].terroir}
//       ];
    	
    	var banners = [
    	               {"elem" : $("#owl-demo-left"), "owl" : $("#owl-demo-left").data('owlCarousel'), "newitems" : data[0].hotel},
    	               {"elem" : $("#owl-demo-right"), "owl" : $("#owl-demo-right").data('owlCarousel'), "newitems" : data[0].restaurant}
       ];
    	
    	// Appliquer la function annonyme sur chaque entrée du tableau
    	banners.map(function(entry){
    		updateCarousel(entry.elem, entry.owl, entry.newitems);
    	});
    	
     };
     
     updateCarousel = function(elem, objOwl, newItems){
    	// la partie fixe d'URL vers le dossier bannières
    	var adPrefix = "http://localhost:8080/CoVoiturage_web/bootstrap/resources/images/bannieres/";
    	
    	/* Sauvgarder le nombre d'éléments existant dans la caroussel pour pouvoir les supprimer après l'ajout des nouvel éléments dans la caroussel 
    	 * [premiers $lengthBeforeUpdate element dans la caroussel après MAJ]
    	 */ 
    	var lengthBeforeUpdate = elem.find('.owl-wrapper').children().length;
    	
    	// l'ajout des bannières reçus par la requete AJAX vers la servlet
    	for(var i = 0; i< newItems.length; i++){
    		objOwl.addItem('<div class="item"><img src="'+ adPrefix + newItems[i] + '.jpg"/></div>');
    	}
    	
    	// afficher la première bannières dans la liste récuperée
    	objOwl.jumpTo(lengthBeforeUpdate);
    	
    	// suppression des ancienne bannières
    	for(var i = 0 ; i< lengthBeforeUpdate; i++){
    		objOwl.removeItem(0);
    	}
     };
     
     
});