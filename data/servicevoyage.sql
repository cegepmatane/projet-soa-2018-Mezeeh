-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le :  mar. 03 avr. 2018 à 19:02
-- Version du serveur :  5.7.21
-- Version de PHP :  7.1.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `servicevoyage`
--

-- --------------------------------------------------------

--
-- Structure de la table `vaisseau`
--

CREATE TABLE `vaisseau` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `capaciter` int(11) NOT NULL,
  `porter` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `vaisseau`
--

INSERT INTO `vaisseau` (`id`, `nom`, `description`, `capaciter`, `porter`) VALUES
(1, 'Retaliator', 'un vaisseau de combat', 2, 1000000),
(2, 'Iteron MKV', 'un vaisseau de transport', 100, 500000),
(3, 'Ark', 'vaisseau de transport comercial', 1000, 1500000),
(4, 'Reliant Kore', 'petit vaisseau d\'exploration', 2, 1000000),
(5, 'Naglfar', 'vaisseau de combat ', 50, 1500000);

-- --------------------------------------------------------

--
-- Structure de la table `voyage`
--

CREATE TABLE `voyage` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `destination` varchar(100) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `distance` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `voyage`
--

INSERT INTO `voyage` (`id`, `nom`, `destination`, `description`, `distance`) VALUES
(1, 'le voyage de muff', 'Mustafar\r\n', 'Mustafar n\'est pas seulement une planète pleine de lave , son habitant le plus célèbre est Dark Vador, qui semble être le voisin le moins invitant de la Galaxie.\r\n', 1000000),
(2, 'le voyage de Gé', 'Géonosis\r\n', 'Géonosis est préservée du bas de l\'échelle grâce à une économie industrielle prospère et à une conception novatrice des arènes .\r\n', 100000),
(5, 'le voyage de plis', 'Polis Massa', 'Cet espace rocailleux rocheux a la particularité d\'être le lieu de naissance de Luke et Leia (ainsi que le lieu de la mort de Padmé Amidala), et pas grand-chose d\'autre.', 5000212),
(6, 'le voyage de wowo', 'Wobani', 'C\'est la planète de la prison déserte que Jyn Erso a sauvée au début de Rogue One .', 43251),
(7, 'le voyage de Ea', 'Eadu', 'Rogue One avait des planètes merdiques, n\'est-ce pas? Celui-ci est génial si vous aimez la pluie, le meurtre, les scientifiques retenus contre leur volonté, et les falaises.', 453264532),
(8, 'le voyage de hos', 'Hosnian Prime', 'Hosnian Prime c\'est une ville planétaire située près du noyau de la galaxie.', 342),
(9, 'le voyage hots', 'Hoth ', 'C\'est une planète de glace inhospitalière dont le prédateur de l\'apex est le cousin moins baisable de l\'abominable bonhomme de neige, mais il abrite aussi les tauntauns, le meilleur animal de Star Wars .', 345576),
(10, 'le voyage de jaja\r\n', 'Jakku', 'Ce n\'est pas Tatooine. Au contraire, cette planète désertique semble être encore plus éloignée que l\'ancienne, qui avait au moins assez d\'économie pour soutenir un circuit de podrace en plein essor.', 24653),
(11, 'le voyage de Je', 'Jedha ', 'Pour mon argent, voici la nouvelle planète Star Wars (techniquement c\'est une lune) qui sent le Star Wars- esque.', 4351313),
(12, 'le voyage de tat', 'Tatooine', 'Comme l\'île de Lost , Tatooine a perdu sa mystique au fur et à mesure que nous la voyions, car il s\'avérait que la planète abritait aussi une limace qui était le plus redouté des criminels de la Galaxie, un gros trou avec des dents, un tas de podracers, et, il était une fois, l\'enfant qui deviendrait Dark Vador. Pourtant, nous aurons toujours ce coucher de soleil binaire et la cantina Mos Eisley , qui nous a dit tout ce que nous avions besoin de savoir sur cet étrange nouvel univers.', 1289347);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `vaisseau`
--
ALTER TABLE `vaisseau`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `voyage`
--
ALTER TABLE `voyage`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `vaisseau`
--
ALTER TABLE `vaisseau`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `voyage`
--
ALTER TABLE `voyage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
