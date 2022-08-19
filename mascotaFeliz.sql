-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-08-2022 a las 16:19:49
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mascotafeliz`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `identificacion` varchar(12) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `identificacion`, `nombre`, `apellido`, `direccion`, `telefono`) VALUES
(1, '523525', 'Juan', 'Perez', 'asfaf', '12124'),
(2, '35235', 'Camilo', 'Gonzalez', 'asfasf', '123123'),
(3, '352353', 'Tomas', 'Rodriguez', 'sfasdf', '342412'),
(4, '14244', 'Carlos', 'Soto', 'sdsdg', '324234'),
(5, '23535', 'Andres', 'Herrera', 'wettwet', '124124');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mascota`
--

CREATE TABLE `mascota` (
  `id` int(11) NOT NULL,
  `codigo` varchar(10) NOT NULL,
  `nombre` varchar(15) NOT NULL,
  `edad` varchar(50) NOT NULL,
  `peso` varchar(50) NOT NULL,
  `especie` varchar(10) NOT NULL,
  `idCliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `mascota`
--

INSERT INTO `mascota` (`id`, `codigo`, `nombre`, `edad`, `peso`, `especie`, `idCliente`) VALUES
(2, '5123', 'Samy', '2', '3', 'Gato', 1),
(3, '54utrr', 'Pita', '3', '5', 'Perro', 5),
(4, 'ii867', 'Lucas', '6', '7', 'Perro', 1),
(5, '78op', 'Cletus', '6', '1', 'Hamster', 1),
(6, '67yu', 'memo', '2', '1', 'Pez', 1),
(7, '56te2', 'Magic', '2', '1', 'Loro', 2),
(8, 'iu89', 'Pepe', '10', '8', 'Reptil', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE `pago` (
  `id` int(11) NOT NULL,
  `codigo` varchar(150) NOT NULL,
  `fecha` varchar(10) NOT NULL,
  `numeroCuotas` varchar(100) NOT NULL,
  `idMascota` int(11) NOT NULL,
  `idPlan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pago`
--

INSERT INTO `pago` (`id`, `codigo`, `fecha`, `numeroCuotas`, `idMascota`, `idPlan`) VALUES
(1, 'uu754', '7/07/2022', '10', 2, 1),
(2, '00p9', '5/07/3033', '5', 4, 3),
(3, 'ik8712', '8/05/2022', '2', 6, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plan`
--

CREATE TABLE `plan` (
  `id` int(11) NOT NULL,
  `codigo` varchar(10) NOT NULL,
  `nombre` varchar(15) NOT NULL,
  `precio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `plan`
--

INSERT INTO `plan` (`id`, `codigo`, `nombre`, `precio`) VALUES
(1, 'twet43', 'Bienestar', 2000),
(2, '568urj', 'Élite', 5000),
(3, 'gghh5', 'Diamante', 8000),
(4, 'tr234', 'Diamante', 7000),
(5, '67ufg', 'Bienestar', 13000),
(6, 'ty645', 'Bienestar', 3000),
(7, '99op', 'Élite', 23000),
(8, '674w', 'Élite', 12000);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `mascota`
--
ALTER TABLE `mascota`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_cliente` (`idCliente`);

--
-- Indices de la tabla `pago`
--
ALTER TABLE `pago`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_mascota` (`idMascota`),
  ADD KEY `id_plan` (`idPlan`);

--
-- Indices de la tabla `plan`
--
ALTER TABLE `plan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `mascota`
--
ALTER TABLE `mascota`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `pago`
--
ALTER TABLE `pago`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `plan`
--
ALTER TABLE `plan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `mascota`
--
ALTER TABLE `mascota`
  ADD CONSTRAINT `mascota_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`);

--
-- Filtros para la tabla `pago`
--
ALTER TABLE `pago`
  ADD CONSTRAINT `pago_ibfk_1` FOREIGN KEY (`idMascota`) REFERENCES `mascota` (`id`),
  ADD CONSTRAINT `pago_ibfk_2` FOREIGN KEY (`idPlan`) REFERENCES `plan` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
