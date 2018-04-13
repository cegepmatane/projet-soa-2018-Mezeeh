<?php
  include "../ServiceDao.php";
  $serviceDao = new ServiceDao();
  $listevoyages = $serviceDao->lirevoyages();
  //print_r($listevoyages);
  header("Content-type: text/xml");
  echo '<?xml version="1.0" encoding="UTF-8"?>';
?>
<voyages>
  <?php foreach($listevoyages as $voyage){?>
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
