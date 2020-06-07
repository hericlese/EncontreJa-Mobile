-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 31, 2020 at 02:56 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `encontrejadatabase`
--

-- --------------------------------------------------------

--
-- Table structure for table `empresa_vagas`
--

CREATE TABLE `empresa_vagas` (
  `id` int(11) NOT NULL,
  `cargo` varchar(50) NOT NULL,
  `empresa` varchar(50) NOT NULL,
  `competencia_1` varchar(50) NOT NULL,
  `competencia_1_nivel` int(1) NOT NULL,
  `competencia_2` varchar(50) NOT NULL,
  `competencia_2_nivel` int(1) NOT NULL,
  `competencia_3` varchar(50) NOT NULL,
  `competencia_3_nivel` int(1) NOT NULL,
  `competencia_4` int(50) NOT NULL,
  `competencia_4_nivel` int(1) NOT NULL,
  `competencia_5` int(50) NOT NULL,
  `competencia_5_nivel` int(1) NOT NULL,
  `vagas` varchar(4) NOT NULL,
  `description` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `usuario_competencias`
--

CREATE TABLE `usuario_competencias` (
  `id` int(11) NOT NULL,
  `competencia` varchar(50) NOT NULL,
  `nivel_1` tinyint(1) NOT NULL,
  `nivel_2` tinyint(1) NOT NULL,
  `nivel_3` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `usuario_curriculo`
--

CREATE TABLE `usuario_curriculo` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `objetivo` varchar(500) NOT NULL,
  `formacao` varchar(1000) NOT NULL,
  `experiencia_1` varchar(1000) NOT NULL,
  `experiencia_2` varchar(1000) NOT NULL,
  `experiencia_3` varchar(1000) NOT NULL,
  `cursos` varchar(1000) NOT NULL,
  `links` varchar(500) NOT NULL,
  `competencia_extras` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `usuario_empresa`
--

CREATE TABLE `usuario_empresa` (
  `id` int(11) NOT NULL,
  `nique_id` varchar(23) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `encrypted_password` varchar(128) NOT NULL,
  `salt` varchar(16) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `empresa` tinyint(1) NOT NULL,
  `responsavel` varchar(50) NOT NULL,
  `description` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `usuario_profissional`
--

CREATE TABLE `usuario_profissional` (
  `id` int(11) NOT NULL,
  `unique_id` varchar(23) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `encrypted_password` varchar(128) NOT NULL,
  `salt` varchar(16) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `email_contato` varchar(100) NOT NULL,
  `empresa` tinyint(1) NOT NULL,
  `data` int(8) NOT NULL,
  `telefone` int(11) NOT NULL,
  `cep` int(8) NOT NULL,
  `sexo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usuario_profissional`
--

INSERT INTO `usuario_profissional` (`id`, `unique_id`, `name`, `email`, `encrypted_password`, `salt`, `created_at`, `updated_at`, `email_contato`, `empresa`, `data`, `telefone`, `cep`, `sexo`) VALUES
(1, '15c30c3f-44a8-41d3-bb11', 'hericles', 'hericles@hotmail.com', '1e023154f669b14401bcd613bd4245113246a196f5936e128f9dbce7f3b97552d8034616e67b84c1e02ae84a2e045cae3970cfc09d18869bf019fb94cc4a69f7', '43685b086d0cf287', '2020-05-23 19:30:45', '2020-05-23 19:30:45', '', 0, 0, 0, 0, 0),
(2, '66c33496-5c26-4c23-94ee', 'hhericles', 'hericles@teste2.com', 'ef74f92f437231b39c98749804b67d11b51c183b784c5b9c20e3b3d6d543b5f6268d5d5c3924363a5f0721972836d26e98f43ca879ac4a6ed0facb11817ae9cf', '7e84a2ceb2e96a50', '2020-05-27 00:13:47', '2020-05-27 00:13:47', '', 0, 0, 0, 0, 0),
(3, '59b5449e-f7b8-4011-b40f', 'saulo', 'Saulo.lindo@gmail.com', 'df35b7012fb4ce8843a7ff424bd572ec8f6781871d4d288a25988c4d8152933692254a0f046587dd1fa2d1916cc0335de4bf24dd004824603bf4a1ddb48faa54', '98cf263b3c6cf39c', '2020-05-27 00:20:18', '2020-05-27 00:20:18', '', 0, 0, 0, 0, 0),
(4, '0739c945-e962-4948-8fcc', 'hericles', 'senha1234e@teste.com', '52a95320ffc93ba65c5eb78752d9b697439afc3a11019d73453a4b7d661e709897c12d6e1b4a365959d1ac04e6a33011d361d8fafd3717b8c4d107cbcee20341', 'c4c238bb913589ab', '2020-05-27 13:16:29', '2020-05-27 13:16:29', '', 0, 0, 0, 0, 0),
(5, '998d2a6c-19d7-4eed-ae5b', 'hericles', 'senha234e@teste.com', '01462173109478275d6297a7242c88bcbc30d89b0330db75b5dd74d707207da958cdc25e1528022a9ee2280fa79506b0b2eb47655d77cba09a87e734df2c1e74', '18c7b1cd29bd36f5', '2020-05-27 13:24:59', '2020-05-27 13:24:59', '', 0, 0, 0, 0, 0),
(6, '43ae3366-1e70-419f-b69c', 'hericles', 'hericlesgustavo1996@gmail.com', 'f9e4e2ea1e9bb9e6b675cb91cccc4304517d876b7b1f3413324559c11bec62ac41bb36bb422fb7a16bd19881cf8c7f70fecd7c0d37af5ca283f5041c25d6eb12', '0ccc85fb76f33d28', '2020-05-30 18:07:07', '2020-05-30 18:07:07', '', 0, 0, 0, 0, 0),
(7, '1bab3666-51c7-45b1-b152', '', '', '1fb52dc99c1bebb97991facd2219e0a6ed0a458db22bd80488ba221040f17d1af98c678f480472c85c88a7c2d664d363ccc41a5b5b3d9274b0a41b58790a275e', '5c02ea8c9afda5b4', '2020-05-30 18:36:20', '2020-05-30 18:36:20', '', 0, 0, 0, 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `empresa_vagas`
--
ALTER TABLE `empresa_vagas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuario_competencias`
--
ALTER TABLE `usuario_competencias`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuario_curriculo`
--
ALTER TABLE `usuario_curriculo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuario_empresa`
--
ALTER TABLE `usuario_empresa`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuario_profissional`
--
ALTER TABLE `usuario_profissional`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_id` (`unique_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `empresa_vagas`
--
ALTER TABLE `empresa_vagas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `usuario_competencias`
--
ALTER TABLE `usuario_competencias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `usuario_curriculo`
--
ALTER TABLE `usuario_curriculo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `usuario_empresa`
--
ALTER TABLE `usuario_empresa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `usuario_profissional`
--
ALTER TABLE `usuario_profissional`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
