-- phpMyAdmin SQL Dump
-- version 3.3.2deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 27, 2013 at 06:43 PM
-- Server version: 5.1.41
-- PHP Version: 5.3.2-1ubuntu4.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `prueba`
--

-- --------------------------------------------------------

--
-- Table structure for table `equipo`
--

CREATE TABLE IF NOT EXISTS `equipo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;

--
-- Dumping data for table `equipo`
--

INSERT INTO `equipo` (`id`, `nombre`) VALUES
(1, 'Juventus'),
(2, 'Urroztarra FC'),
(3, 'test'),
(4, 'osasuna'),
(5, 'Otro');

-- --------------------------------------------------------

--
-- Table structure for table `jugador`
--

CREATE TABLE IF NOT EXISTS `jugador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `puesto` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `dorsal` int(11) NOT NULL,
  `idequipo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKB4D49BC29ADEDE6C` (`idequipo`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=8 ;

--
-- Dumping data for table `jugador`
--

INSERT INTO `jugador` (`id`, `nombre`, `puesto`, `dorsal`, `idequipo`) VALUES
(1, 'Drenthe', 'Madero', 6, 1),
(2, 'Fauvert', 'Rey de copas', 34, 2),
(3, 'Urban', 'Delantero', 7, 3),
(4, 'Otro', 'bueno', 3, 2),
(5, 'eee', 'fff', 11, 1),
(6, 'www', 'eee', 12, 1),
(7, 'Llorente', 'Delantero', 9, 3);

-- --------------------------------------------------------

--
-- Table structure for table `tarea`
--

CREATE TABLE IF NOT EXISTS `tarea` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `descripcion` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `hecha` tinyint(1) NOT NULL,
  `tipo_tarea` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Dumping data for table `tarea`
--

INSERT INTO `tarea` (`id`, `nombre`, `descripcion`, `hecha`, `tipo_tarea`) VALUES
(1, 'Muerte y Dolor', 'Destripar y matar lentamente', 0, 3),
(2, 'Asesinar', 'Hacha de doble filo', 0, 2),
(3, 'Tarea', 'Nueva tarea', 1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `tipo`
--

CREATE TABLE IF NOT EXISTS `tipo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;

--
-- Dumping data for table `tipo`
--

INSERT INTO `tipo` (`id`, `nombre`) VALUES
(1, 'importante'),
(2, 'sin más'),
(3, 'Urgente'),
(5, 'mierda');

-- --------------------------------------------------------

--
-- Table structure for table `USER`
--

CREATE TABLE IF NOT EXISTS `USER` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `USER_GENDER` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `USER_COUNTRY` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `USER_ABOUT_YOU` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `USER_MAILING_LIST` tinyint(1) NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Dumping data for table `USER`
--

INSERT INTO `USER` (`USER_ID`, `USER_NAME`, `USER_GENDER`, `USER_COUNTRY`, `USER_ABOUT_YOU`, `USER_MAILING_LIST`) VALUES
(1, 'Muerte', 'Male', 'USA', 'Everlasting Pain', 1),
(2, 'Asesinar', 'Matar', 'Destripar', 'Mutilar', 1),
(3, 'sdfasdf', 'Male', 'USA', 'sdfasdf', 0);
