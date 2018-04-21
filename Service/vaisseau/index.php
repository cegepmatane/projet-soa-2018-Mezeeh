<?php
  include_once "../accesseur/serviceDao.php";
  $dao = new ServiceDao();
  $vaisseau = $dao->lireVaisseau($_GET['id']);
  //var_dump($vaisseau);
  header("Content-type: text/xml");
  echo '<?xml version="1.0" encoding="UTF-8"?>';
 ?>
 <vaisseau>
     <id><?=$vaisseau['id']?></id>
     <nom><?=utf8_encode($vaisseau['nom'])?></nom>
     <description><?=utf8_encode($vaisseau['description'])?></description>
     <capaciter><?=utf8_encode($vaisseau['capaciter'])?></capaciter>
     <porter><?=$vaisseau['porter']?></porter>
 </vaisseau>
