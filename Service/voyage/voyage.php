<?php
  include_once "../serviceDao.php";
  $dao = new ServiceDao();
  $voyage = $dao->lireVoyage($_GET['id']);
  var_dump($voyage);
?>
