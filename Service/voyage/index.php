<?php
  include_once "../accesseur/serviceDao.php";
  $dao = new ServiceDao();
  $voyage = $dao->lireVoyage($_GET['id']);
  //var_dump($voyage);
  header("Content-type: text/xml");
  echo '<?xml version="1.0" encoding="UTF-8"?>';
?>
<voyage>
    <id><?=$voyage['id']?></id>
    <nom><?=utf8_encode($voyage['nom'])?></nom>
    <destination><?=utf8_encode($voyage['destination'])?></destination>
    <description><?=utf8_encode($voyage['description'])?></description>
    <distance><?=$voyage['distance']?></distance>
    <idvaisseau><?=$voyage['idvaisseau']?></idvaisseau>
</voyage>
