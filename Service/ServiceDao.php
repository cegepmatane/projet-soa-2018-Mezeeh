<?php
  include_once "baseDeDonnees.php";
  class ServiceDao
  {
    function lireVaisseaux()
    {
      global $basededonnees;
      $requete = $basededonnees->prepare("SELECT * FROM vaisseau");
      $requete->execute();
      $vaisseaux = $requete->fetchAll();

      return $vaisseaux;
    }
    function lireVoyages()
    {
      global $basededonnees;
      $requete = $basededonnees->prepare("SELECT * FROM voyage");
      $requete->execute();
      $voyages = $requete->fetchAll();

      return $voyages;
    }
    function lireVoyage($id)
    {
      global $basededonnees;
      $requete = $basededonnees->prepare("SELECT * FROM voyage WHERE id = :id");
      $requete->bindParam(':id', $id, PDO::PARAM_INT);
      $requete->execute();
      $voyage = $requete->fetch();

      return $voyage;
    }
    function lireVoyagesVaisseau($id)
    {
      global $basededonnees;
      $requete = $basededonnees->prepare("SELECT * FROM voyage WHERE idvaisseau = :id");
      $requete->bindParam(':id', $id, PDO::PARAM_INT);
      $requete->execute();
      $voyages = $requete->fetchAll();

      return $voyages;
    }
    function lireVaisseau($id)
    {
      global $basededonnees;
      $requete = $basededonnees->prepare("SELECT * FROM vaisseau WHERE id = :id");
      $requete->bindParam(':id', $id, PDO::PARAM_INT);
      $requete->execute();
      $vaisseau = $requete->fetch();

      return $vaisseau;
    }
  }
?>
