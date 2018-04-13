<?php
  include_once "../serviceDao.php";
  $dao = new ServiceDao();
  $vaisseau = $dao->lireVaisseau($_GET['id']);
  var_dump($vaisseau);
 ?>
