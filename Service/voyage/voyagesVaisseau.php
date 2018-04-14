<?php
  include_once "../ServiceDao.php";
  $dao = new ServiceDao();
  $voyages = $dao->lireVoyagesVaisseau($_GET['id']);
  var_dump($voyages);
 ?>
