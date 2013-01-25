-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 24-01-2013 a las 15:32:53
-- Versión del servidor: 5.5.24
-- Versión de PHP: 5.3.10-1ubuntu3.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `prueba_crud`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `PHONE`
--

CREATE TABLE IF NOT EXISTS `PHONE` (
  `PHONE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PHONE_TYPE` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `PHONE_NUMBER` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`PHONE_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `PHONE`
--

INSERT INTO `PHONE` (`PHONE_ID`, `PHONE_TYPE`, `PHONE_NUMBER`) VALUES
(1, 'house', '32354353'),
(2, 'mobile', '9889343423');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `STUDENT`
--

CREATE TABLE IF NOT EXISTS `STUDENT` (
  `STUDENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `STUDENT_NAME` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`STUDENT_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `STUDENT`
--

INSERT INTO `STUDENT` (`STUDENT_ID`, `STUDENT_NAME`) VALUES
(1, 'Eswar');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `STUDENT_PHONE`
--

CREATE TABLE IF NOT EXISTS `STUDENT_PHONE` (
  `STUDENT_ID` bigint(20) NOT NULL,
  `PHONE_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`STUDENT_ID`,`PHONE_ID`),
  UNIQUE KEY `PHONE_ID` (`PHONE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `STUDENT_PHONE`
--

INSERT INTO `STUDENT_PHONE` (`STUDENT_ID`, `PHONE_ID`) VALUES
(1, 1),
(1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarea`
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
-- Volcado de datos para la tabla `tarea`
--

INSERT INTO `tarea` (`id`, `nombre`, `descripcion`, `hecha`, `tipo_tarea`) VALUES
(1, 'Muerte y Dolor', 'Destripar y matar lentamente', 0, 4),
(2, 'Asesinar', 'Hacha de doble filo', 0, 0),
(3, 'Tarea', 'Nueva tarea', 1, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipotarea`
--

CREATE TABLE IF NOT EXISTS `tipotarea` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `USER`
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
-- Volcado de datos para la tabla `USER`
--

INSERT INTO `USER` (`USER_ID`, `USER_NAME`, `USER_GENDER`, `USER_COUNTRY`, `USER_ABOUT_YOU`, `USER_MAILING_LIST`) VALUES
(1, 'Muerte', 'Male', 'USA', 'Everlasting Pain', 1),
(2, 'Asesinar', 'Matar', 'Destripar', 'Mutilar', 1),
(3, 'sdfasdf', 'Male', 'USA', 'sdfasdf', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
