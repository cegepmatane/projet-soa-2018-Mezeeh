<?php
  include "../ServiceDao.php";
  $serviceDao = new ServiceDao();
  $listeVaisseaux = $serviceDao->lireVaisseaux();
  //print_r($listeVaisseaux);
  header("Content-type: text/xml");
  echo '<?xml version="1.0" encoding="UTF-8"?>';
?>
<vaisseaux>
  <?php foreach($listeVaisseaux as $vaisseau){?>
      <vaisseau>
          <id><?=$vaisseau['id']?></id>
          <nom><?=utf8_encode($vaisseau['nom'])?></nom>
          <description><?=utf8_encode($vaisseau['description'])?></description>
          <capaciter><?=utf8_encode($vaisseau['capaciter'])?></capaciter>
          <porter><?=$vaisseau['porter']?></porter>
      </vaisseau>
    <?php } ?>
  </vaisseaux>
