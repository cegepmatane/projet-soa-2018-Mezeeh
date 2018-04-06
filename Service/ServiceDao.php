<?php
  include_once "baseDeDonner.php";
  class ServiceDao
  {
    function lireVaisseau()
    {
      global $basededonnees;
      $requete = $basededonnees->prepare("SELECT * FROM vaisseau");
      $requete->execute();
      $vaisseau = $requete->fetchAll();

      return $vaisseau;
    }
    function lireVoyage()
    {
      global $basededonnees;
      $requete = $basededonnees->prepare("SELECT * FROM voyage");
      $requete->execute();
      $voyage = $requete->fetchAll();

      return $voyage;
    }
  }
?>
