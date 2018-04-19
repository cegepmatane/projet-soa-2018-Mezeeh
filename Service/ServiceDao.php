<?php
  include_once "baseDeDonnees.php";
  class ServiceDao
  {
    function lireVaisseaux()
    {
      global $basededonnees;
      $SQL_LIRE_VAISSEAUS = "SELECT * FROM vaisseau";
      $requete = $basededonnees->prepare($SQL_LIRE_VAISSEAUS);
      $requete->execute();
      $vaisseaux = $requete->fetchAll();

      return $vaisseaux;
    }
    function lireVoyages()
    {
      $SQL_LIRE_VOYAGES = "SELECT * FROM voyage";
      global $basededonnees;
      $requete = $basededonnees->prepare($SQL_LIRE_VOYAGES);
      $requete->execute();
      $voyages = $requete->fetchAll();

      return $voyages;
    }
    function lireVoyage($id)
    {
      global $basededonnees;
      $SQL_LIRE_VOYAGE = "SELECT * FROM voyage WHERE id = :id";
      $requete = $basededonnees->prepare($SQL_LIRE_VOYAGE);
      $requete->bindParam(':id', $id, PDO::PARAM_INT);
      $requete->execute();
      $voyage = $requete->fetch();

      return $voyage;
    }
    function lireVoyagesVaisseau($id)
    {
      global $basededonnees;
      $SQL_LIRE_VOYAGES_VAISSEAU = "SELECT * FROM voyage WHERE idvaisseau = :id";
      $requete = $basededonnees->prepare($SQL_LIRE_VOYAGES_VAISSEAU);
      $requete->bindParam(':id', $id, PDO::PARAM_INT);
      $requete->execute();
      $voyages = $requete->fetchAll();

      return $voyages;
    }
    function lireVaisseau($id)
    {
      global $basededonnees;
      $SQL_LIRE_VAISSEAU = "SELECT * FROM vaisseau WHERE id = :id";
      $requete = $basededonnees->prepare($SQL_LIRE_VAISSEAU);
      $requete->bindParam(':id', $id, PDO::PARAM_INT);
      $requete->execute();
      $vaisseau = $requete->fetch();

      return $vaisseau;
    }
    function ajouterVoyages($voyage)
    {
      global $basededonnees;
			$SQL_AJOUTER_VOYAGE = "INSERT INTO voyage(id, nom, destination, description, distance, idvaisseau) VALUES(:id, :nom, :destination, :description, :distance, :idvaisseau)";
			$requeteAjouter = $basededonnees->prepare($SQL_AJOUTER_VOYAGE);
			$requeteAjouter->bindParam(':id', $pensee['id'], PDO::PARAM_STR);
			$requeteAjouter->bindParam(':nom', $pensee['nom'], PDO::PARAM_STR);
			$requeteAjouter->bindParam(':description', $pensee['destination'], PDO::PARAM_STR);
			$requeteAjouter->bindParam(':description',$pensee['description'], PDO::PARAM_STR);
      $requeteAjouter->bindParam(':distance', $pensee['distance'], PDO::PARAM_STR);
      $requeteAjouter->bindParam(':idvaisseau',$pensee['idvaisseau'], PDO::PARAM_STR);
			$requeteAjouter->execute();
    }
  }
?>
