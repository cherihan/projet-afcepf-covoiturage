-- MySQL Administrator dump 1.4
-- ------------------------------------------------------
-- Server version	5.1.31-community
-- ======================================================

SET NAMES utf8;
SET CHARACTER SET utf8;

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Creating Database 'db_covoiturage'
-- -----------------------------------------------------

DROP DATABASE IF EXISTS db_covoiturage ;
CREATE DATABASE IF NOT EXISTS db_covoiturage DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE db_covoiturage;


-- -----------------------------------------------------
-- Definition of Table 'ville'
-- -----------------------------------------------------

DROP TABLE IF EXISTS `ville`;
CREATE TABLE `ville` (
  `id_ville` INT unsigned NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `code_postal` VARCHAR(45) NOT NULL,
  `pays` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_ville`)
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- Dumping data for table 'ville'
-- -----------------------------------------------------

INSERT INTO ville(id_ville, nom, code_postal, pays)
	VALUES
		('1', 'Paris','75000','France'),
		('2', 'Lyon','69000','France'),
		('3', 'Lille','59000','France'),
		('4', 'Marseille','13000','France'),
		('5', 'Bordeaux','33000','France'),
		('6', 'Rouen','76000','France'),
		('7', 'Montpellier','34000','France'),
		('8', 'Biarritz','64000','France'),
		('9', 'Brest','29000','France'),
		('10', 'Amiens','60000','France');


-- -----------------------------------------------------
-- Definition of Table 'adresse'
-- -----------------------------------------------------

DROP TABLE IF EXISTS `adresse` ;
CREATE TABLE `adresse` (
  `id_adresse` INT unsigned NOT NULL AUTO_INCREMENT,
  `numero` VARCHAR(45) NOT NULL,
  `type_voie` VARCHAR(45) NOT NULL,
  `nom_voie` VARCHAR(45) NOT NULL,
  `ville_id_ville` INT unsigned NOT NULL,
  PRIMARY KEY (`id_adresse`),
  INDEX `fk_adresse_ville1_idx` (`ville_id_ville` ASC),
  CONSTRAINT `fk_adresse_ville1`
    FOREIGN KEY (`ville_id_ville`)
    REFERENCES `db_covoiturage`.`ville` (`id_ville`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- Dumping data for table 'adresse'
-- -----------------------------------------------------

INSERT INTO adresse(id_adresse, numero, type_voie, nom_voie, ville_id_ville)
	VALUES
		(1,'25','rue','de la paix',1),
		(2,'38','avenue','de la republique',1),
		(3,'50','boulevard','napoleon',2),
		(4,'19','place','de la convention',2),
		(5,'23','impasse ','des jesuites',3),
		(6,'42','avenue','des peupliers',3),
		(7,'16','rue','des rosiers',4),
		(8,'28','place','de la concorde',4);


-- -----------------------------------------------------
-- Definition of Table 'utilisateur'
-- -----------------------------------------------------

DROP TABLE IF EXISTS `utilisateur` ;
CREATE TABLE `utilisateur` (
  `id_utilisateur` INT unsigned NOT NULL AUTO_INCREMENT,
  `civilite` VARCHAR(45) NULL,
  `nom` VARCHAR(255) NOT NULL,
  `prenom` VARCHAR(255) NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `telephone` VARCHAR(45) NULL,
  `date_naissance` DATE NULL,
  `type_vehicule` VARCHAR(45) NULL,
  `permis_conduire` VARCHAR(1) NULL,
  `adresse_id_adresse` INT unsigned NOT NULL,
  PRIMARY KEY (`id_utilisateur`),
  UNIQUE INDEX `id_utilisateur_UNIQUE` (`id_utilisateur` ASC),
  INDEX `fk_utilisateur_adresse1_idx` (`adresse_id_adresse` ASC),
  CONSTRAINT `fk_utilisateur_adresse1`
    FOREIGN KEY (`adresse_id_adresse`)
    REFERENCES `db_covoiturage`.`adresse` (`id_adresse`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- Dumping data for table 'utilisateur'
-- -----------------------------------------------------

INSERT INTO utilisateur(id_utilisateur, civilite, nom, prenom, email, password, telephone, date_naissance, type_vehicule, permis_conduire, adresse_id_adresse)
	VALUES
		(1,'M.','Lesage','Paul','lesage@free.fr','lesage','0323654785','1976-06-07','moyenne berline',1,3),
		(2,'M.','Durant','Pierre','durant@free.fr','durant','0147852356','1985-08-19','citadine',1,1),
		(3,'Mme','Nobel','Chantal','nobel@free.fr','nobel','0278890425','1982-11-28','break',1,2),
		(4,'Mlle','Lafayette','Marine','lafayette@free.fr','lafayette','0128145689','1990-12-24','monospace',1,1),
		(5,'M.','Riverain','Pascal','riverain@free.fr','riverain','0256820932','1960-01-15','citadine',1,2),
		(6,'Mme','Caster','Emilie','caster@free.fr','caster','0413124568','1965-05-16','grande berline',1,3),
		(7,'Mlle','Claire','Roselyne','claire@free.fr','claire','0453482406','1976-10-03','4x4',1,4);


-- -----------------------------------------------------
-- Definition of Table 'trajet'
-- -----------------------------------------------------

DROP TABLE IF EXISTS `trajet` ;
CREATE TABLE `trajet` (
  `id_trajet` INT unsigned NOT NULL AUTO_INCREMENT,
  `date_creation` DATETIME NOT NULL,
  `conducteur_id_user` INT unsigned NOT NULL,
  `date_depart` DATETIME NOT NULL,
  `ville_depart_id` INT unsigned NOT NULL,
  `ville_arrivee_id` INT unsigned NOT NULL,
  `nb_passagers_max` INT unsigned NOT NULL,
  `nb_passagers_restant` INT unsigned NULL,
  `tarif` INT unsigned NOT NULL,
  `statut` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_trajet`),
  UNIQUE INDEX `id_trajet_UNIQUE` (`id_trajet` ASC),
  INDEX `fk_trajet_ville1_idx` (`ville_depart_id` ASC),
  INDEX `fk_trajet_ville2_idx` (`ville_arrivee_id` ASC),
  CONSTRAINT `fk_trajet_ville1`
    FOREIGN KEY (`ville_depart_id`)
    REFERENCES `db_covoiturage`.`ville` (`id_ville`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_trajet_ville2`
    FOREIGN KEY (`ville_arrivee_id`)
    REFERENCES `db_covoiturage`.`ville` (`id_ville`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- Dumping data for table 'trajet'
-- -----------------------------------------------------

INSERT INTO trajet(id_trajet, date_creation, conducteur_id_user, date_depart, ville_depart_id, ville_arrivee_id, nb_passagers_max, nb_passagers_restant, tarif, statut)
	VALUES
		(1,'2013-01-10 22:00:00',7,'2013-01-16 09:45:00',3,4,4,2,18,'terminé'),
		(2,'2013-01-11 22:00:00',2,'2013-01-17 15:30:00',10,8,3,0,24,'terminé'),
		(3,'2013-01-12 22:00:00',7,'2013-01-18 11:15:00',6,5,3,0,21,'terminé'),
		(4,'2013-01-13 22:00:00',2,'2013-01-19 15:30:00',4,3,3,0,16,'terminé'),
		(5,'2013-01-14 22:00:00',2,'2013-01-20 16:00:00',3,7,3,1,15,'terminé'),
		(6,'2013-01-15 22:00:00',7,'2013-01-21 18:15:00',5,2,3,0,17,'terminé'),
		(7,'2013-01-16 22:00:00',7,'2013-01-22 19:00:00',8,7,4,1,23,'terminé'),
		(8,'2013-01-17 22:00:00',7,'2013-01-23 17:30:00',10,6,3,0,14,'terminé'),
		(9,'2014-01-02 22:00:00',2,'2014-01-15 09:30:00',2,1,4,0,26,'terminé'),
		(10,'2014-01-24 22:00:00',3,'2014-02-15 13:45:00',7,9,4,1,15,'terminé'),
		(11,'2014-03-11 22:00:00',4,'2014-03-15 22:00:00',5,9,2,0,28,'terminé'),
		(12,'2014-04-05 22:00:00',5,'2014-04-15 15:00:00',7,3,3,0,28,'terminé'),
		(13,'2014-04-13 22:00:00',6,'2014-05-15 13:45:00',7,9,4,0,15,'terminé'),
		(14,'2014-05-08 22:00:00',7,'2014-06-15 22:00:00',5,9,2,0,28,'terminé'),
		(15,'2014-06-22 22:00:00',5,'2014-07-15 15:00:00',7,3,3,1,28,'terminé'),

		(16,'2014-09-19 20:30:00',7,'2014-10-20 14:30:00',8,5,4,2,28,'en cours'),
		(17,'2014-10-26 20:30:00',6,'2014-11-21 11:00:00',9,7,5,3,28,'en cours'),
		(18,'2014-11-01 20:30:00',3,'2014-12-22 08:30:00',1,2,4,2,25,'en cours'),
		(19,'2014-11-14 20:30:00',4,'2014-12-22 08:30:00',1,2,3,1,25,'en cours'),
		(20,'2014-12-07 20:30:00',2,'2014-12-22 08:30:00',1,2,4,2,25,'en cours'),

		(21,'2014-12-20 22:00:00',2,'2015-01-01 10:00:00',1,2,4,4,28,'proposé'),
		(22,'2014-12-21 22:00:00',2,'2015-01-01 10:00:00',1,2,4,4,30,'proposé'),
		(23,'2014-12-22 22:00:00',3,'2015-01-01 10:00:00',1,2,3,3,29,'proposé'),
		(24,'2014-12-23 22:00:00',3,'2015-01-01 10:00:00',1,2,4,4,26,'proposé'),
		(25,'2014-12-24 22:00:00',4,'2015-01-01 10:00:00',1,2,3,3,32,'proposé'),
		(26,'2014-12-25 22:00:00',4,'2015-01-01 10:00:00',1,2,4,4,24,'proposé'),
		(27,'2014-12-26 22:00:00',5,'2015-01-01 10:00:00',1,2,4,4,28,'proposé'),
		(28,'2014-12-27 22:00:00',5,'2015-01-01 10:00:00',1,2,4,4,35,'proposé'),
		(29,'2014-12-28 22:00:00',6,'2015-01-01 10:00:00',1,2,3,3,33,'proposé'),
		(30,'2014-12-29 22:00:00',6,'2015-01-01 10:00:00',1,2,2,2,29,'proposé'),
		(31,'2014-12-30 22:00:00',7,'2015-01-01 10:00:00',1,2,4,4,24,'proposé'),
		(32,'2014-12-31 22:00:00',7,'2015-01-01 10:00:00',1,2,3,3,23,'proposé'),

		(33,'2012-01-10 22:00:00',1,'2012-01-16 09:45:00',3,4,4,0,18,'terminé'),
		(34,'2012-01-11 22:00:00',1,'2012-01-17 15:30:00',10,8,3,1,24,'terminé'),
		(35,'2012-01-12 22:00:00',1,'2012-01-18 11:15:00',6,5,3,0,21,'terminé'),
		(36,'2012-01-13 22:00:00',1,'2012-01-19 15:30:00',4,3,3,0,16,'terminé'),
		(37,'2012-01-14 22:00:00',1,'2012-01-20 16:00:00',3,7,4,0,15,'terminé'),
		(38,'2012-01-15 22:00:00',1,'2012-01-21 18:15:00',5,2,3,0,17,'terminé'),
		(39,'2012-01-16 22:00:00',1,'2012-01-22 19:00:00',8,7,4,1,23,'terminé'),
		
		(40,'2014-09-21 22:00:00',1,'2014-10-20 14:30:00',8,5,4,3,28,'en cours'),
		(41,'2014-10-28 22:00:00',1,'2014-11-21 11:00:00',9,7,4,3,22,'en cours'),
		(42,'2014-11-03 22:00:00',1,'2014-12-25 08:30:00',1,2,4,3,24,'en cours'),
		(43,'2014-11-16 22:00:00',1,'2014-12-27 08:30:00',1,2,3,2,30,'en cours'),
		(44,'2014-12-09 22:00:00',1,'2014-12-30 08:30:00',1,2,4,3,21,'en cours'),
		
		(45,'2014-12-25 22:00:00',1,'2015-01-01 10:00:00',1,2,3,3,29,'proposé'),
		(46,'2014-12-25 22:00:00',1,'2015-02-01 10:00:00',1,2,3,3,35,'proposé'),
		(47,'2015-01-14 22:00:00',1,'2015-03-01 10:00:00',1,2,4,4,31,'proposé'),
		(48,'2015-02-17 22:00:00',1,'2015-04-01 10:00:00',1,2,4,4,17,'proposé'),
		(49,'2015-03-08 22:00:00',1,'2015-05-01 10:00:00',1,2,2,2,32,'proposé'),
		(50,'2015-04-29 22:00:00',1,'2015-06-01 10:00:00',1,2,3,3,19,'proposé');

-- -----------------------------------------------------
-- Definition of Table `utilisateur_has_trajet`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `utilisateur_has_trajet` ;
CREATE TABLE `utilisateur_has_trajet` (
  `utilisateur_id_utilisateur` INT unsigned NOT NULL,
  `trajet_id_trajet` INT unsigned NOT NULL,
  PRIMARY KEY (`utilisateur_id_utilisateur`, `trajet_id_trajet`),
  INDEX `fk_utilisateur_has_trajet_trajet1_idx` (`trajet_id_trajet` ASC),
  INDEX `fk_utilisateur_has_trajet_utilisateur1_idx` (`utilisateur_id_utilisateur` ASC),
  CONSTRAINT `fk_utilisateur_has_trajet_utilisateur1`
    FOREIGN KEY (`utilisateur_id_utilisateur`)
    REFERENCES `db_covoiturage`.`utilisateur` (`id_utilisateur`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_utilisateur_has_trajet_trajet1`
    FOREIGN KEY (`trajet_id_trajet`)
    REFERENCES `db_covoiturage`.`trajet` (`id_trajet`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- Dumping data for table 'utilisateur_has_trajet'
-- -----------------------------------------------------

INSERT INTO utilisateur_has_trajet(utilisateur_id_utilisateur, trajet_id_trajet)
	VALUES
		(7,1),(1,1),(2,1),
		(2,2),(1,2),(3,2),(4,2),
		(7,3),(1,3),(2,3),(4,3),
		(2,4),(1,4),(3,4),(4,4),
		(2,5),(1,5),(3,5),
		(7,6),(1,6),(2,6),(3,6),
		(7,7),(1,7),(2,7),(3,7),
		(7,8),(1,8),(2,8),(3,8),
		(2,9),(1,9),(3,9),(4,9),(5,9),
		(3,10),(1,10),(2,10),(4,10),
		(4,11),(1,11),(2,11),
		(5,12),(1,12),(3,12),(4,12),
		(6,13),(1,13),(2,13),(3,13),(4,13),
		(7,14),(1,14),(2,14),
		(5,15),(1,15),(2,15),
		
		(7,16),(1,16),(2,16),
		(6,17),(1,17),(2,17),
		(3,18),(1,18),(2,18),
		(4,19),(1,19),(2,19),
		(2,20),(1,20),(3,20),
				
		(2,21),
		(2,22),
		(3,23),
		(3,24),
		(4,25),
		(4,26),
		(5,27),
		(5,28),
		(6,29),
		(6,30),
		(7,31),
		(7,32),
		
		(1,33),(2,33),(3,33),(4,33),(5,33),
		(1,34),(2,34),(3,34),
		(1,35),(2,35),(3,35),(4,35),
		(1,36),(2,36),(3,36),(4,36),
		(1,37),(2,37),(3,37),(4,37),(5,37),
		(1,38),(2,38),(3,38),(4,38),
		(1,39),(2,39),(3,39),(4,39),
		
		(7,40),(1,40),(2,40),
		(6,41),(1,41),
		(3,42),(1,42),(2,42),(4,42),
		(4,43),(1,43),
		(2,44),(1,44),(3,44),(4,44),

		(1,45),
		(1,46),
		(1,47),
		(1,48),
		(1,49),
		(1,50);
		
-- -----------------------------------------------------
-- Definition of  Table 'avis'
-- -----------------------------------------------------

DROP TABLE IF EXISTS `avis` ;
CREATE TABLE `avis` (
  `id_avis` INT unsigned NOT NULL AUTO_INCREMENT,
  `contenu` VARCHAR(45) NULL,
  `note` VARCHAR(45) NOT NULL,
  `utilisateur_id_utilisateur` INT unsigned NOT NULL,
  `trajet_id_trajet` INT unsigned NOT NULL,
  PRIMARY KEY (`id_avis`),
  INDEX `fk_avis_utilisateur_idx` (`utilisateur_id_utilisateur` ASC),
  INDEX `fk_avis_trajet1_idx` (`trajet_id_trajet` ASC),
  CONSTRAINT `fk_avis_utilisateur`
    FOREIGN KEY (`utilisateur_id_utilisateur`)
    REFERENCES `db_covoiturage`.`utilisateur` (`id_utilisateur`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_avis_trajet1`
    FOREIGN KEY (`trajet_id_trajet`)
    REFERENCES `db_covoiturage`.`trajet` (`id_trajet`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- Dumping data for table 'avis'
-- -----------------------------------------------------

INSERT INTO avis(id_avis, contenu, note, utilisateur_id_utilisateur, trajet_id_trajet)
	VALUES
		(1,'Super et très bien',4,1,1),
		(2,'Super bien',4,1,1),

		(3,'Excellent',5,1,2),
		(4,'Vraiment excellent',5,1,2),
		(5,'Franchement excellent',5,1,2),

		(6,'Assez bien',3,1,3),
		(7,'Passablement bien ',3,1,3),

		(8,'Excellent',5,1,4),
		(9,'Parfait',5,1,4),
		(10,'Très bien',5,1,4),

		(11,'Très très bien',5,1,5),
		(12,'très cool',5,1,5),

		(13,'Excellent',5,1,6),
		(14,'Très bien',5,1,6),
		(15,'Très cool',5,1,6),

		(16,'Super',4,1,7),
		(17,'Super bien',4,1,7),
		(18,'Superbement bien',4,1,7),

		(19,'Pas mal du tout',4,1,8),
		(20,'Assez bien',4,1,8),

		(21,'Excellente compagnie',5,1,9),
		(22,'Très agréable et amiusant',5,1,9),
		(23,'Voyage très agréable',5,1,9),

		(24,'Voyage parfait',5,1,10),
		(25,'Magnifiques rencontres et voyage agréable',5,1,10);

		
-- -----------------------------------------------------
-- Definition of Table 'commentaire_trajet'
-- -----------------------------------------------------

DROP TABLE IF EXISTS `commentaire_trajet` ;
CREATE TABLE `commentaire_trajet` (
  `id_commentaire_trajet` INT unsigned NOT NULL AUTO_INCREMENT,
  `trajet_id_trajet` INT unsigned NOT NULL,
  `commentaire` VARCHAR(300) NOT NULL,
  `commentaire_id_QR` INT unsigned NOT NULL,
  `commentaire_type_QR` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id_commentaire_trajet`),
  INDEX `fk_commentaire_trajet_trajet1_idx` (`trajet_id_trajet` ASC),
  CONSTRAINT `fk_commentaire_trajet_trajet1`
    FOREIGN KEY (`trajet_id_trajet`)
    REFERENCES `db_covoiturage`.`trajet` (`id_trajet`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- Dumping data for table 'commentaire_trajet'
-- -----------------------------------------------------

INSERT INTO commentaire_trajet(id_commentaire_trajet, trajet_id_trajet, commentaire, commentaire_id_QR, commentaire_type_QR)
	VALUES
		(1,45,'Bonjour ! faites-vous un arrêt à Dijon !?',1,'Q'),
		(2,45,'Oui je peux faire un arrêt à Dijon si vous le souhaitez.',1,'R'),
		(3,45,'Est-il possible de ramener 2 valises ?',2,'Q'),
		(4,45,'Ce n''est pas possible ! chaque voyageur a le droit à une seule valise',2,'R'),
		(5,45,'Pourriez-vous me récupérer directement à la place de la Nation ?',3,'Q'),
		(6,45,'Oui c''est possible.',3,'R'),
		(7,45,'Votre voiture possède-t-elle un climatiseur !?',4,'Q'),
		(8,45,'Oui',4,'R'),
		(9,45,'Pourrais-je ramener un chat !?',5,'Q'),
		(10,45,'les animaux ne sont pas admis malheureusement ! des voyageurs peuvent présenter des allergies ou peuvent ne pas aimer être accompagnés par des animaux.',5,'R'),
		(11,45,'Je souhaite être déposé à l''avenue de la République ! est-ce faisable ?',6,'Q'),
		(12,45,'Oui mais ce sera après avoir déposé tout le monde.',6,'R');
		

-- -----------------------------------------------------
-- Definition of Table 'carte'
-- -----------------------------------------------------

DROP TABLE IF EXISTS `carte`;
CREATE TABLE `carte` (
  `id_carte` INT unsigned NOT NULL AUTO_INCREMENT,
  `porteur` VARCHAR(45) NOT NULL,
  `num_carte` VARCHAR(19) NOT NULL,
  `cryptogramme` VARCHAR(3) NOT NULL,
  `date_expiration` DATE NOT NULL,
  PRIMARY KEY (`id_carte`)
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- Dumping data for table 'carte'
-- -----------------------------------------------------

INSERT INTO carte(id_carte, porteur, num_carte, cryptogramme, date_expiration)
	VALUES
		(1,'M. Durant Pierre', '1234 5678 9123 4567', '123', '2016-09-30 00:00:00'),
		(2,'M. Lesage Paul', '5678 9123 4567 8912', '456', '2017-10-30 00:00:00'),
		(3,'M. Lesage Paul', '9123 4567 8912 3456', '789', '2018-11-30 00:00:00'),
		(4,'Mme Nobel Chantal', '4567 8912 3456 7891', '234', '2015-03-31 00:00:00'),
		(5,'Mme Nobel Chantal', '8912 3456 7891 2345', '567', '2016-02-28 00:00:00');

		
		
-- ------------------------------------------------------
-- ------------------------------------------------------

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

