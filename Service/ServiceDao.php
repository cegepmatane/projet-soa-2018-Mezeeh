<?php
  include_once "baseDeDonnees.php";
  class ServiceDao
  {
    function lireVaisseaux()
    {
      global $basededonnees;
      $requete = $basededonnees->prepare("SELECT * FROM vaisseau");
      $requete->execute();
      $vaisseau = $requete->fetchAll();

      return $vaisseau;
    }
    function lireVoyages()
    {
      global $basededonnees;
      $requete = $basededonnees->prepare("SELECT * FROM voyage");
      $requete->execute();
      $voyage = $requete->fetchAll();

      return $voyage;
    }
  }
?>
