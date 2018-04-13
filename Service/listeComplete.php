<?php
  include "ServiceDao.php";
  $serviceDao = new ServiceDao();
  $listeVaisseaux = $serviceDao->lireVaisseaux();
  $listeVoyages = $serviceDao->lireVoyages();
  //print_r($listeVaisseaux);
  header("Content-type: text/xml");
  echo '<?xml version="1.0" encoding="UTF-8"?>';
?>
<servicevoyage>
  <vaisseaux>
      <?php
          foreach($listeVaisseaux as $vaisseau){?>
              <vaisseau>
                  <id><?=$vaisseau['id']?></id>
                  <nom><?=utf8_encode($vaisseau['nom'])?></nom>
                  <description><?=utf8_encode($vaisseau['description'])?></description>
                  <capaciter><?=utf8_encode($vaisseau['capaciter'])?></capaciter>
                  <porter><?=$vaisseau['porter']?></porter>
              </vaisseau>
              <?php
          }
      ?>
  </vaisseaux>
  <voyages>
      <?php
          foreach($listeVoyages as $voyages){?>
              <voyage>
                  <id><?=$voyages['id']?></id>
                  <nom><?=utf8_encode($voyages['nom'])?></nom>
                  <destination><?=utf8_encode($voyages['destination'])?></destination>
                  <description><?=utf8_encode($voyages['description'])?></description>
                  <distance><?=$voyages['distance']?></distance>
                  <idvaisseau><?=$voyages['idvaisseau']?></idvaisseau>
              </voyage>
              <?php
          }
      ?>
  </voyages>
</servicevoyage>
