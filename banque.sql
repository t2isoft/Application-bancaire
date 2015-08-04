-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.14


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema banque
--

CREATE DATABASE IF NOT EXISTS banque;
USE banque;

--
-- Definition of table `agence`
--

DROP TABLE IF EXISTS `agence`;
CREATE TABLE `agence` (
  `LibelleAg` varchar(45) NOT NULL,
  `AdresseAg` varchar(45) NOT NULL,
  PRIMARY KEY (`LibelleAg`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `agence`
--

/*!40000 ALTER TABLE `agence` DISABLE KEYS */;
INSERT INTO `agence` (`LibelleAg`,`AdresseAg`) VALUES 
 ('Aminata Plataux ','Km1 Dakar plataux 23');
/*!40000 ALTER TABLE `agence` ENABLE KEYS */;


--
-- Definition of table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `NumCl` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Civilite` varchar(25) DEFAULT NULL,
  `Nom` varchar(45) NOT NULL,
  `Prenom` varchar(45) NOT NULL,
  `DateNaisse` date NOT NULL,
  `Adresse` varchar(45) NOT NULL,
  `Telephone` varchar(45) DEFAULT NULL,
  `LibelleAg` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`NumCl`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `client`
--

/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` (`NumCl`,`Civilite`,`Nom`,`Prenom`,`DateNaisse`,`Adresse`,`Telephone`,`LibelleAg`) VALUES 
 (1,'Monsieur','Diallo','Mustapha','1988-08-03','Ouakam Cité asecan','773452310','Aminata Plataux '),
 (2,'Mademoiselle','Faye','Marietou','2011-08-28','Gd Dakar 306','338674323','Aminata Plataux ');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;


--
-- Definition of table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE `compte` (
  `NumCp` int(10) unsigned NOT NULL,
  `LibelleCp` varchar(45) NOT NULL,
  `SensCp` varchar(45) NOT NULL,
  `Solde` int(20) unsigned DEFAULT NULL,
  `NumCl` int(10) unsigned NOT NULL,
  PRIMARY KEY (`NumCp`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `compte`
--

/*!40000 ALTER TABLE `compte` DISABLE KEYS */;
INSERT INTO `compte` (`NumCp`,`LibelleCp`,`SensCp`,`Solde`,`NumCl`) VALUES 
 (16235,'Famillial compt','Debiteur',300000,2),
 (24615,'perso','Debiteur',119880,1);
/*!40000 ALTER TABLE `compte` ENABLE KEYS */;


--
-- Definition of table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `numl` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nomprenom` varchar(45) NOT NULL,
  `utilisateur` varchar(45) NOT NULL,
  `mpasse` varchar(45) NOT NULL,
  `niveau` int(10) unsigned NOT NULL,
  PRIMARY KEY (`numl`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` (`numl`,`nomprenom`,`utilisateur`,`mpasse`,`niveau`) VALUES 
 (2,'Mohamed Hanafi','admin','admin',4),
 (3,'moussa diamanka','maman','passer',2);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;


--
-- Definition of table `operation`
--

DROP TABLE IF EXISTS `operation`;
CREATE TABLE `operation` (
  `NumOp` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `LibelleOp` varchar(45) NOT NULL,
  `MontantOp` int(20) unsigned NOT NULL,
  `SensOp` varchar(45) NOT NULL,
  `DateOp` date NOT NULL,
  `NumCp` int(10) unsigned NOT NULL,
  PRIMARY KEY (`NumOp`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `operation`
--

/*!40000 ALTER TABLE `operation` DISABLE KEYS */;
INSERT INTO `operation` (`NumOp`,`LibelleOp`,`MontantOp`,`SensOp`,`DateOp`,`NumCp`) VALUES 
 (1,'retraut espece',120,'Debiteur','2011-08-08',24615);
/*!40000 ALTER TABLE `operation` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
