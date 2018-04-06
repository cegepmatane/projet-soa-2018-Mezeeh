<?php
	$usager = 'root';
	$motdepasse = 'admin1';
	$hote = 'localhost';
	$base = 'servicevoyage';
	$dsn = 'mysql:dbname='.$base.';host=' . $hote;
	$basededonnees = new PDO($dsn, $usager, $motdepasse);
?>
