-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 23 mars 2022 à 17:24
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bracelet`
--
CREATE DATABASE IF NOT EXISTS `bracelet` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bracelet`;

-- --------------------------------------------------------

--
-- Structure de la table `frequence`
--

CREATE TABLE `frequence` (
  `id` bigint(20) NOT NULL,
  `freq1` int(11) NOT NULL,
  `freq10` int(11) NOT NULL,
  `freq11` int(11) NOT NULL,
  `freq12` int(11) NOT NULL,
  `freq13` int(11) NOT NULL,
  `freq14` int(11) NOT NULL,
  `freq15` int(11) NOT NULL,
  `freq2` int(11) NOT NULL,
  `freq3` int(11) NOT NULL,
  `freq4` int(11) NOT NULL,
  `freq5` int(11) NOT NULL,
  `freq6` int(11) NOT NULL,
  `freq7` int(11) NOT NULL,
  `freq8` int(11) NOT NULL,
  `freq9` int(11) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `frequence`
--

INSERT INTO `frequence` (`id`, `freq1`, `freq10`, `freq11`, `freq12`, `freq13`, `freq14`, `freq15`, `freq2`, `freq3`, `freq4`, `freq5`, `freq6`, `freq7`, `freq8`, `freq9`, `user_id`) VALUES
(1, 78, 56, 55, 82, 84, 55, 84, 59, 79, 71, 64, 79, 61, 55, 85, 8);

-- --------------------------------------------------------

--
-- Structure de la table `infos`
--

CREATE TABLE `infos` (
  `id` bigint(20) NOT NULL,
  `chest_pain_type` varchar(255) DEFAULT NULL,
  `cholesterol` varchar(255) DEFAULT NULL,
  `danger` varchar(255) DEFAULT NULL,
  `exercise_angina` varchar(255) DEFAULT NULL,
  `fastingbs` varchar(255) DEFAULT NULL,
  `restingecg` varchar(255) DEFAULT NULL,
  `st_slope` varchar(255) DEFAULT NULL,
  `oldpeak` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `infos`
--

INSERT INTO `infos` (`id`, `chest_pain_type`, `cholesterol`, `danger`, `exercise_angina`, `fastingbs`, `restingecg`, `st_slope`, `oldpeak`, `user_id`, `age`, `sex`) VALUES
(2, 'ASY', '200', '1', 'Y', '0', 'Normal', 'Up', '0', 8, '40', 'M'),
(3, 'NAP', '190', '1', 'N', '1', 'ST', 'Up', '1', NULL, '35', 'F'),
(4, 'ASY', '201', '1', 'Y', '0', 'LVH', 'Up', '1.5', 16, '45', 'M'),
(7, 'ASY', '350', '0', 'Y', '1', 'ST', 'Flat', '0.5', 21, '24', 'M');

-- --------------------------------------------------------

--
-- Structure de la table `messagerie`
--

CREATE TABLE `messagerie` (
  `id` bigint(20) NOT NULL,
  `message` varchar(255) DEFAULT NULL,
  `receiver_id` bigint(20) DEFAULT NULL,
  `sender_id` bigint(20) DEFAULT NULL,
  `name_sender` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `messagerie`
--

INSERT INTO `messagerie` (`id`, `message`, `receiver_id`, `sender_id`, `name_sender`) VALUES
(1, 'Hi its me', 6, 8, 'achrafP1');

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_MEDECIN'),
(3, 'ROLE_PATIENT');

-- --------------------------------------------------------

--
-- Structure de la table `temperature`
--

CREATE TABLE `temperature` (
  `id` bigint(20) NOT NULL,
  `temp1` int(11) NOT NULL,
  `temp10` int(11) NOT NULL,
  `temp11` int(11) NOT NULL,
  `temp12` int(11) NOT NULL,
  `temp13` int(11) NOT NULL,
  `temp14` int(11) NOT NULL,
  `temp15` int(11) NOT NULL,
  `temp2` int(11) NOT NULL,
  `temp3` int(11) NOT NULL,
  `temp4` int(11) NOT NULL,
  `temp5` int(11) NOT NULL,
  `temp6` int(11) NOT NULL,
  `temp7` int(11) NOT NULL,
  `temp8` int(11) NOT NULL,
  `temp9` int(11) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `temperature`
--

INSERT INTO `temperature` (`id`, `temp1`, `temp10`, `temp11`, `temp12`, `temp13`, `temp14`, `temp15`, `temp2`, `temp3`, `temp4`, `temp5`, `temp6`, `temp7`, `temp8`, `temp9`, `user_id`) VALUES
(1, 38, 35, 35, 35, 38, 37, 35, 38, 36, 36, 36, 36, 38, 37, 38, 8);

-- --------------------------------------------------------

--
-- Structure de la table `tension`
--

CREATE TABLE `tension` (
  `id` bigint(20) NOT NULL,
  `tens1` int(11) NOT NULL,
  `tens10` int(11) NOT NULL,
  `tens11` int(11) NOT NULL,
  `tens12` int(11) NOT NULL,
  `tens13` int(11) NOT NULL,
  `tens14` int(11) NOT NULL,
  `tens15` int(11) NOT NULL,
  `tens2` int(11) NOT NULL,
  `tens3` int(11) NOT NULL,
  `tens4` int(11) NOT NULL,
  `tens5` int(11) NOT NULL,
  `tens6` int(11) NOT NULL,
  `tens7` int(11) NOT NULL,
  `tens8` int(11) NOT NULL,
  `tens9` int(11) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `tension`
--

INSERT INTO `tension` (`id`, `tens1`, `tens10`, `tens11`, `tens12`, `tens13`, `tens14`, `tens15`, `tens2`, `tens3`, `tens4`, `tens5`, `tens6`, `tens7`, `tens8`, `tens9`, `user_id`) VALUES
(1, 13, 12, 10, 13, 10, 13, 10, 12, 11, 14, 10, 12, 13, 11, 12, 8);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `hopitale` varchar(255) DEFAULT NULL,
  `age` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(120) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `username`, `hopitale`, `age`, `email`, `password`) VALUES
(5, 'ensias', NULL, '23', 'ndads@gmail.com', '$2a$10$Zpbiy9utfJUoDO.T6z/T8.Bn16zrR/iubNdy3AnWcWZBJW5lxy196'),
(6, 'Achraf', 'Mohammed 5', '23', 'nddds@gmail.com', '$2a$10$stPdpSDqApY6TWWEqGJ7xenOH5qbARSjBfogZGGxETjAZrVV.4qx6'),
(7, 'Rajaa', 'hassan 2', '23', 'nqds@gmail.com', '$2a$10$krFJ2L53I51p9jcTo6kRXeaKsrJeSjMxXX.ILuxarHd6tmDIr93h6'),
(8, 'Fadwa', NULL, '23', 'nqd@gmail.com', '$2a$10$8qSmJXF2It8NQifIyTySwO8.DKu4xHmtSVeNUZIxMd1gN0fbfstTi'),
(9, 'Safaaa', NULL, '23', 'nd@gmail.com', '$2a$10$nRY3O2YOFEh1lrYc/5v6.ucicAJsUCQiRREaE1QBAA588bVULkS.G'),
(10, 'Safaa', NULL, '22', 'aa@gm.c', '$2a$10$F0HCH1YWW8DzgsYVHrMp/uoh54sTY2lO8qvmUJAejaNKMj0QzqsCu'),
(11, 'Hiba', NULL, '77', 'aa@ga.c', '$2a$10$5248x3z0n4PxlBkDN69MSOxe3HbO6Pxqgg4By//ZPFJZ0w5wcOhZG'),
(13, 'achrafP4', NULL, '55', 'dcs@d.c', '$2a$10$mzTR1Euv7TVbypGPjg7Pv.7f4c.wtwGk8uL4Lw2O0C7Zcn6tBHc.K'),
(16, 'test1', NULL, '88', 'ds@gd.cs', '$2a$10$g3XvD3yGRvjyjDzIRHV3zOH5o4Cft.93KCQDJH9hCT/o1R/ESdM8m'),
(21, 'ensiasP1', NULL, '23', 'aa@gmail.com', '$2a$10$NECkuwyfVYiOXrsAu72oBej/v2q3RdepPYdrkzGjxKJzAcMCtPJ5C'),
(22, 'Nabil', 'Mohammed 5', '23', 'Nabil@gmail.com', '$2a$10$mUqjchJo70tf5fZp8G/CbuICMeXSSqx//ugI6h9dBaKPwMgXfJVoK'),
(23, 'Hasna', 'Mohammed 5', '33', 'hansa@gmail.com', '$2a$10$VuETQf44zeG0mTJhI6TvOuPVb79jZXMMzObdPs3zNeIGgpyImkiV6'),
(24, 'Amine', 'Mohammed 5', '23', 'amine@gmail.com', '$2a$10$MP/BS0gqY83y9tzWIDtJKer6tVulX2P4p0ia6.848B8T570vH.Ujq');

-- --------------------------------------------------------

--
-- Structure de la table `user_role`
--

CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL,
  `respo` bigint(20) DEFAULT NULL,
  `alert` bigint(20) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `resultat` bit(1) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user_role`
--

INSERT INTO `user_role` (`id`, `respo`, `alert`, `message`, `resultat`, `role_id`, `user_id`) VALUES
(5, NULL, NULL, NULL, NULL, 1, 5),
(6, NULL, NULL, NULL, NULL, 2, 6),
(7, NULL, NULL, NULL, NULL, 2, 7),
(8, 6, 0, 'Bonjour Monsieur', b'1', 3, 8),
(9, 7, 0, NULL, b'1', 3, 9),
(10, 6, 0, NULL, b'1', 3, 10),
(11, 6, 0, NULL, b'1', 3, 11),
(13, 6, 0, NULL, b'1', 3, 13),
(16, 6, 0, NULL, b'1', 3, 16),
(21, 6, 0, NULL, b'1', 3, 21),
(22, NULL, NULL, NULL, NULL, 2, 22),
(23, NULL, NULL, NULL, NULL, 2, 23),
(24, NULL, NULL, NULL, NULL, 2, 24);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `frequence`
--
ALTER TABLE `frequence`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5ai2xewsl1k6knm0tdb2sfttr` (`user_id`);

--
-- Index pour la table `infos`
--
ALTER TABLE `infos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjyns3bw013w2k2evtmvuneswy` (`user_id`);

--
-- Index pour la table `messagerie`
--
ALTER TABLE `messagerie`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdhnax8qwuv0qrs19m3pw15ac9` (`receiver_id`),
  ADD KEY `FKgpqgv4cxtiq804afl5gvy64k1` (`sender_id`);

--
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `temperature`
--
ALTER TABLE `temperature`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKniktht5fenq6ia4wxbb7mj36m` (`user_id`);

--
-- Index pour la table `tension`
--
ALTER TABLE `tension`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6rvw1b9xlejacpqtm5ohwt0w2` (`user_id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  ADD KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `frequence`
--
ALTER TABLE `frequence`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `infos`
--
ALTER TABLE `infos`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `messagerie`
--
ALTER TABLE `messagerie`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `temperature`
--
ALTER TABLE `temperature`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `tension`
--
ALTER TABLE `tension`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT pour la table `user_role`
--
ALTER TABLE `user_role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `frequence`
--
ALTER TABLE `frequence`
  ADD CONSTRAINT `FK5ai2xewsl1k6knm0tdb2sfttr` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `infos`
--
ALTER TABLE `infos`
  ADD CONSTRAINT `FKjyns3bw013w2k2evtmvuneswy` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `messagerie`
--
ALTER TABLE `messagerie`
  ADD CONSTRAINT `FKdhnax8qwuv0qrs19m3pw15ac9` FOREIGN KEY (`receiver_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKgpqgv4cxtiq804afl5gvy64k1` FOREIGN KEY (`sender_id`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `temperature`
--
ALTER TABLE `temperature`
  ADD CONSTRAINT `FKniktht5fenq6ia4wxbb7mj36m` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `tension`
--
ALTER TABLE `tension`
  ADD CONSTRAINT `FK6rvw1b9xlejacpqtm5ohwt0w2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
