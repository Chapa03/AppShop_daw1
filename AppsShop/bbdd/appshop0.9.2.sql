-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-05-2021 a las 09:54:46
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `appshop`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aplicaciones`
--

CREATE TABLE `aplicaciones` (
  `idAplicacion` int(10) NOT NULL,
  `nombreApp` varchar(50) NOT NULL,
  `descripcion` varchar(250) DEFAULT NULL,
  `idDesarrollador` int(11) DEFAULT NULL,
  `fechaPublicacion` date DEFAULT NULL,
  `peso` float DEFAULT NULL,
  `edadMinima` int(2) DEFAULT NULL,
  `idCategoriaApp` int(10) NOT NULL,
  `idTipo` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `aplicaciones`
--

INSERT INTO `aplicaciones` (`idAplicacion`, `nombreApp`, `descripcion`, `idDesarrollador`, `fechaPublicacion`, `peso`, `edadMinima`, `idCategoriaApp`, `idTipo`) VALUES
(0, 'Whatsapp', '', 0, '0000-00-00', 0, 0, 0, 0),
(8, 'hola', NULL, NULL, NULL, NULL, NULL, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bibliotecas`
--

CREATE TABLE `bibliotecas` (
  `idUsuario` int(10) NOT NULL,
  `idAplicacion` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `idCategoria` int(10) NOT NULL,
  `nombreCategoria` varchar(30) NOT NULL,
  `idTipo` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `opiniones`
--

CREATE TABLE `opiniones` (
  `idOpinion` int(10) NOT NULL,
  `idUsuario` int(10) NOT NULL,
  `idAplicacion` int(10) NOT NULL,
  `comentario` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `opiniones`
--

INSERT INTO `opiniones` (`idOpinion`, `idUsuario`, `idAplicacion`, `comentario`) VALUES
(1, 0, 0, 'Escribe aquí tu comentario');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoapp`
--

CREATE TABLE `tipoapp` (
  `idTipo` int(11) NOT NULL,
  `nombreTipo` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipoapp`
--

INSERT INTO `tipoapp` (`idTipo`, `nombreTipo`) VALUES
(0, 'Juego');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `idUsuario` int(10) NOT NULL,
  `nombreCompleto` varchar(50) DEFAULT NULL,
  `alias` varchar(15) NOT NULL,
  `password` varchar(255) NOT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `pais` varchar(20) DEFAULT NULL,
  `correo` varchar(40) NOT NULL,
  `developer` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idUsuario`, `nombreCompleto`, `alias`, `password`, `fechaNacimiento`, `pais`, `correo`, `developer`) VALUES
(1, 'Cristian Chaparro Arteaga', 'chapa', 'chapa', '1993-03-01', 'España', 'chapa@appshop.com', 1),
(2, 'Carlos Marc Guinea', 'guinea', '', NULL, NULL, 'guinea@appshop.com', 1),
(3, 'Iván Flores', 'flores', '', NULL, NULL, 'flores@appshop.com', 1),
(4, 'Sergio Dragos Gerghely', 'dragos', '', NULL, NULL, 'dragos@appshop.com', 1),
(10, 'Usuario 01', 'usuario1', 'usuario1', '1900-01-01', 'Luxemburgo', 'usuario1@appshop.com', 0),
(15, 'Usuario 02', 'usuario2', 'usuario2', '1900-01-01', 'Luxemburgo', 'usuario2@appshop.com', 0),
(16, 'Usuario 03', 'usuario3', 'usuario3', '1900-01-01', 'Dinamarca', 'usuario3@appshop.com', 0),
(17, 'Usuario 04', 'usuario4', 'usuario4', '1900-01-01', 'UK', 'usuario4@appshop.com', 0),
(18, 'Usuario 05', 'usuario5', 'usuario5', '1900-01-01', 'Francia', 'usuario5@appshop.com', 0),
(19, 'Usuario 06', 'usuario6', 'usuario6', '1900-01-01', 'Italia', 'usuario6@appshop.com', 0),
(20, 'Usuario 07', 'usuario7', 'usuario7', '1900-01-01', 'Rumania', 'usuario7@appshop.com', 0),
(21, 'Usuario 08', 'usuario8', 'usuario8', '1900-01-01', 'Rusia', 'usuario8@appshop.com', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aplicaciones`
--
ALTER TABLE `aplicaciones`
  ADD PRIMARY KEY (`idAplicacion`),
  ADD KEY `idTipo` (`idTipo`),
  ADD KEY `idCategoriaApp` (`idCategoriaApp`);

--
-- Indices de la tabla `bibliotecas`
--
ALTER TABLE `bibliotecas`
  ADD PRIMARY KEY (`idUsuario`,`idAplicacion`),
  ADD UNIQUE KEY `idUsuario` (`idUsuario`,`idAplicacion`),
  ADD KEY `idUsuario_2` (`idUsuario`,`idAplicacion`),
  ADD KEY `fk_biblioteca_aplicaciones` (`idAplicacion`);

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`idCategoria`),
  ADD KEY `idTipo` (`idTipo`);

--
-- Indices de la tabla `opiniones`
--
ALTER TABLE `opiniones`
  ADD PRIMARY KEY (`idOpinion`),
  ADD UNIQUE KEY `isUsuario` (`idUsuario`,`idAplicacion`);

--
-- Indices de la tabla `tipoapp`
--
ALTER TABLE `tipoapp`
  ADD PRIMARY KEY (`idTipo`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idUsuario`),
  ADD UNIQUE KEY `alias` (`alias`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `aplicaciones`
--
ALTER TABLE `aplicaciones`
  MODIFY `idAplicacion` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `opiniones`
--
ALTER TABLE `opiniones`
  MODIFY `idOpinion` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idUsuario` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `aplicaciones`
--
ALTER TABLE `aplicaciones`
  ADD CONSTRAINT `fk_aplicaciones_tipoApp` FOREIGN KEY (`idTipo`) REFERENCES `tipoapp` (`idTipo`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `bibliotecas`
--
ALTER TABLE `bibliotecas`
  ADD CONSTRAINT `fk_biblioteca_aplicaciones` FOREIGN KEY (`idAplicacion`) REFERENCES `aplicaciones` (`idAplicacion`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_biblioteca_usuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `tipoapp`
--
ALTER TABLE `tipoapp`
  ADD CONSTRAINT `tipoapp_ibfk_1` FOREIGN KEY (`idTipo`) REFERENCES `aplicaciones` (`idTipo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
