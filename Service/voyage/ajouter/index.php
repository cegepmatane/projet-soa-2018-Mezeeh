<?php

	include "../../accesseur/ServiceDao.php";
	$serviceDao = new ServiceDao();
	$filtreVoyage = array();
	$filtreVoyage['nom'] = FILTER_SANITIZE_STRING;
	$filtreVoyage['destination'] = FILTER_SANITIZE_STRING;
	$filtreVoyage['description'] = FILTER_SANITIZE_STRING;
	$filtreVoyage['distance'] = FILTER_SANITIZE_NUMBER_INT;
	$filtreVoyage['idvaisseau'] = FILTER_SANITIZE_NUMBER_INT;
	$voyage = filter_var_array($_POST, $filtreVoyage);
	//print_r($voyage);
	$succes = $serviceDao->ajouterVoyages($voyage);
?><?php 
//header("Content-type: text/xml");
//echo '<?xml version="1.0" encoding="UTF-8"?>';
?>
<action>
	<type>ajouter</type>
	<moment><?=time()?></moment>
	<succes><?=$succes?></succes>
	<message></message>
</action>
