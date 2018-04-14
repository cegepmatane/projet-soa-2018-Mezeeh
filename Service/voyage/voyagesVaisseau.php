<?php
  include_once "../ServiceDao.php";
  $dao = new ServiceDao();
  $voyages = $dao->lireVoyagesVaisseau($_GET['id']);
  //var_dump($voyages);
  header("Content-type: text/xml");
  echo '<?xml version="1.0" encoding="UTF-8"?>';
?>
<voyages>
  <?php foreach($voyages as $voyage){?>
      <voyage>
          <id><?=$voyage['id']?></id>
          <nom><?=utf8_encode($voyage['nom'])?></nom>
          <destination><?=utf8_encode($voyage['destination'])?></destination>
          <description><?=utf8_encode($voyage['description'])?></description>
          <distance><?=$voyage['distance']?></distance>
          <idvaisseau><?=$voyage['idvaisseau']?></idvaisseau>
      </voyage>
    <?php } ?>
  </voyages>
