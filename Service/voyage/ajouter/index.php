<?php

	include "../../ServiceDao";
	$serviceDao = new ServiceDao();
	$filtreVoyage = array();
	$filtreVoyage['id'] = FILTER_SANITIZE_NUMBER_INT;
	$filtreVoyage['nom'] = FILTER_SANITIZE_STRING;
	$filtreVoyage['destination'] = FILTER_SANITIZE_STRING;
	$filtreVoyage['description'] = FILTER_SANITIZE_STRING;
  $filtreVoyage['distance'] = FILTER_SANITIZE_NUMBER_INT;
  $filtreVoyage['idvaisseau'] = FILTER_SANITIZE_NUMBER_INT;
	$voyage = filter_var_array($_POST, $filtreVoyage);
	$serviceDao->ajouterVoyages($voyage);
	//print_r($penseeDAO);
?>
