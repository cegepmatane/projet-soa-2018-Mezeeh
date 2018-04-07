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
                  <nom><?=$vaisseau['nom']?></nom>
                  <description><?=$vaisseau['description']?></description>
                  <capaciter><?=$vaisseau['capaciter']?></capaciter>
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
                  <nom><?=$voyages['nom']?></nom>
                  <description><?=$voyages['destination']?></description>
                  <capaciter><?=$voyages['description']?></capaciter>
                  <porter><?=$voyages['distance']?></porter>
              </voyage>
              <?php
          }
      ?>
  </voyages>
</servicevoyage>
