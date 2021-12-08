-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: nomina-db-1
-- Tiempo de generación: 26-11-2021 a las 08:21:48
-- Versión del servidor: 10.6.5-MariaDB-1:10.6.5+maria~focal
-- Versión de PHP: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `Administrador` (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `nombre` varchar(55) NOT NULL,
  `salario` double NOT NULL,
  `numHorasTrabajadas` int NOT NULL,
  `horasExtras` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


