-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 14, 2020 at 02:32 AM
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
  `vagas` varchar(4) NOT NULL,
  `description` varchar(500) NOT NULL,
  `fk_empresa` int(11) DEFAULT NULL,
  `contrato` varchar(20) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `empresa_vagas`
--

INSERT INTO `empresa_vagas` (`id`, `cargo`, `empresa`, `competencia_1`, `competencia_1_nivel`, `competencia_2`, `competencia_2_nivel`, `competencia_3`, `competencia_3_nivel`, `vagas`, `description`, `fk_empresa`, `contrato`, `cidade`, `estado`) VALUES
(4, 'analista teste', 'Uninove teste', 'Ingles', 2, 'CorelDRAW', 0, '1', 0, '3', '2', 33, 'CLT', 'Osasco', 'São Paulo'),
(5, 'analista teste', 'Uninove teste', 'ingles', 2, 'espanhol', 3, 'Autocard', 2, '3', 'Execercee .........\nBenefícios.......\ntemporário......', 33, 'CLT', 'Osasco', 'São Paulo'),
(6, 'analista teste3', 'uninive teste', 'Espanhol', 2, 'Excel', 3, 'Autocard', 2, '3', 'benefícios...', 33, 'CLT', 'São Paulo', 'São Paulo'),
(7, 'analista teste3', 'uninive teste', 'Ingles', 2, 'Excel', 3, 'Autocard', 2, '3', 'benefícios...', 33, 'CLT', 'São Paulo', 'São Paulo'),
(8, 'analista teste3', 'uninive teste', 'Ingles', 2, 'Excel', 3, 'Autocard', 2, '3', 'benefícios...', 33, 'CLT', 'São Paulo', 'São Paulo'),
(9, 'analista teste3', 'uninive teste', 'Espanhol', 2, 'Excel', 3, 'Espanhol', 2, '3', 'benefícios...', 33, 'CLT', 'São Paulo', 'São Paulo'),
(10, 'analista teste3', 'uninive teste', 'Ingles', 2, 'Excel', 3, 'Autocard', 2, '3', 'benefícios...', 33, 'CLT', 'São Paulo', 'São Paulo'),
(11, 'analista teste3', 'uninive teste', 'Ingles', 1, 'Excel', 1, 'Autocard', 1, '3', 'benefícios...', 33, 'CLT', 'São Paulo', 'São Paulo'),
(12, 'analista teste3', 'uninive teste', 'Ingles', 2, 'Excel', 2, 'Autocard', 2, '3', 'benefícios...', 33, 'CLT', 'São Paulo', 'São Paulo'),
(13, 'analista teste3', 'uninive teste', 'Espanhol', 3, 'Excel', 3, 'Autocard', 3, '3', 'benefícios...', 33, 'CLT', 'São Paulo', 'São Paulo'),
(14, 'Auxiliar', 'test', 'ex', 2, 'in', 2, 'au', 2, '4', 'descp', 33, 'CTL', 'SP', 'SP'),
(15, 'Auxiliar', 'test', 'inlges', 2, 'Corel', 2, 'teste', 2, '4', 'descp', 33, 'CTL', 'SP', 'SP'),
(16, 'Auxiliar', 'test', 'Teste1', 1, 'Teste2', 2, 'Teste3', 3, '4', 'descp', 33, 'CTL', 'SP', 'SP');

-- --------------------------------------------------------

--
-- Table structure for table `usuario_competencias`
--

CREATE TABLE `usuario_competencias` (
  `id` int(11) NOT NULL,
  `competencia` varchar(50) NOT NULL,
  `nivel` int(1) NOT NULL,
  `fk_competencia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usuario_competencias`
--

INSERT INTO `usuario_competencias` (`id`, `competencia`, `nivel`, `fk_competencia`) VALUES
(1, 'ingles', 3, 9),
(2, 'Excel', 3, 9),
(3, 'autocard', 3, 9),
(4, 'ingles', 3, 9),
(5, 'Excel', 3, 9),
(6, 'autocard', 3, 9);

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
  `competencia_extras` varchar(1000) NOT NULL,
  `fk_profissional` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usuario_curriculo`
--

INSERT INTO `usuario_curriculo` (`id`, `name`, `objetivo`, `formacao`, `experiencia_1`, `experiencia_2`, `experiencia_3`, `cursos`, `links`, `competencia_extras`, `fk_profissional`) VALUES
(1, 'hericles', 'objetivo', 'formação x', 'experiência x', 'experiência y', 'experiência z', 'cursos', 'github', '', 9),
(2, 'hericles', 'objetivo', 'formação x', 'experiência x', 'experiência y', 'experiência z', 'cursos', 'github', 'teste', 9);

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
  `empresa` int(1) NOT NULL,
  `responsavel` varchar(50) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `email_contato` varchar(100) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usuario_empresa`
--

INSERT INTO `usuario_empresa` (`id`, `nique_id`, `name`, `email`, `encrypted_password`, `salt`, `empresa`, `responsavel`, `description`, `email_contato`, `created_at`, `updated_at`) VALUES
(1, 'c0bf1ebe-ec9a-45b2-ab7c', '123', 'hericlesgustavo1996@gmail.com', '0077d3b93d9f5c589df899669e67585e8bd0f9c3e9a56fc24e00131d516cce264781046d15d02bd16b7b58cd6d1f43128c2fe74b2b8676ea273bef728ec088b4', '56d60c07bcabddf9', 0, '2', '222', 'empresa fodq', '2020-05-31 15:38:27', '2020-05-31 15:38:27'),
(3, '80dfc796-6b5c-423d-9b0d', 'empresa', 'hericles2@empresa.com', '51a1aaa2a3ad189a26b299061b0f8d1f70070c918eb14753d985dc709cefd6b96b8ffbfbd4499eda95382cfd8a76db63ef8b2e89f7cbe857123c72f93559e8ce', '0bc0d01df4f89e36', 1, 'hericles', 'empresa', 'empresa@contato.com', '2020-05-31 16:54:20', '2020-05-31 16:54:20'),
(33, 'ce8c3397-e68a-4e15-a4b0', 'hericles', 'hericles@empresa.com', 'f55b3c8460afd554c30bd05d33ffadd5fe805a9f558e85d0d52e95146e6f93906daa8daa0648325e9369f6507c245861fae7995187f980f4fcd9abe91b8363d5', 'cebf2a78c9059858', 1, 'hericles', 'descrição', 'hericles@empresa.com2', '2020-06-03 22:40:29', '2020-06-03 22:40:29'),
(34, '10', 'testedb', 'testedm@dt.com', '123', '1234', 1, 'hericles', 'desc', 'she@teste.com', '2020-06-03 22:40:29', '2020-06-03 22:40:29');

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
  `email_contato` varchar(100) NOT NULL,
  `empresa` int(1) NOT NULL,
  `data` int(8) NOT NULL,
  `telefone` int(11) NOT NULL,
  `sexo` tinyint(1) NOT NULL,
  `cidade` varchar(50) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usuario_profissional`
--

INSERT INTO `usuario_profissional` (`id`, `unique_id`, `name`, `email`, `encrypted_password`, `salt`, `email_contato`, `empresa`, `data`, `telefone`, `sexo`, `cidade`, `estado`, `created_at`, `updated_at`) VALUES
(8, '0753860e-0485-4722-a995', 'Michael alemao', 'michael@alemao.com', 'c45387e5ca9597f786485fc34a1b70218e756fa6e723287dc203dc76644e9821fb8075a0909860ca32eb55c9066618278eca2acfc39288de1470470eb7e7f4d2', 'cb23d5658d6000f3', 'michael@contato.com', 0, 12121996, 2147483647, 1, '', '', '2020-05-31 00:25:10', '2020-05-31 00:25:10'),
(9, '72c28ce5-5e8e-45c4-8426', 'herixkes', 'hericles@usuario.com', 'e91bffb33e04716755f49820aa2076b9b63f484b9fa1478739addb8cfc2fa18b1c50eeb4eedd6db7bc7db2b7ed485f02d57d66b0e2b171348ee89b0fda682dd3', 'd609e1662a4c6664', 'hdd.@hotmkm.com', 0, 14121996, 2147483647, 1, '', '', '2020-05-31 16:19:28', '2020-05-31 16:19:28'),
(10, '416759e2-7757-417d-b2c8', 'hh', 'hericlesgustavo1996h@gmail.com', '5e3739b021d8c5b7012d9355cb1d2d623fc49cd20dda71b822ec9944a4dd4d9b2d27dca51809b59823365a8f99f2d97387ac2807f9295a976806c49f0da4bf7a', 'c961865856ab0979', 'hh', 0, 66, 66, 1, '', '', '2020-05-31 17:32:09', '2020-05-31 17:32:09'),
(11, '3e88d979-7d37-4b05-9b90', 'hh', 'hericlesgustavo199623@gmail.com', '051a4bc69a56b74c3bf1d870d7336557bada33d5626da757b32934a5dec5d85373e6860b81512485d816c14d7b000db30905456d5ec2c6b71491ab608dbd7d7d', '400e9a1932833456', 'hh', 0, 55, 96, 1, '', '', '2020-06-01 21:01:08', '2020-06-01 21:01:08'),
(12, '5089b72a-8cdc-4448-b473', 'hericles', 'hericles2@usuario.com', '461d5c17c5bf6e7e7f807fa158f887cef1708cc894b648200e2e304ab85f8b627be9aefc696daede5116f7c21e0b5c85523ca13c0869348303e8f76e4cfee9ff', '24c004d5c151fff8', 'hericles@usuario.com', 0, 14121996, 55, 1, '', '', '2020-06-03 20:44:47', '2020-06-03 20:44:47'),
(13, '35ee198f-075e-411d-b0e7', 'heri', 'hericles3@usuario.com', '90c5f2677f120734e06667d9e1dc6c622ca78443974fbf4f5401936e7cc17d3f22e11c985c0472596a66530b241f37e3b3a82c7b3d7b20e27917167aefdd097a', '01a6d2403ee93e19', 'hh', 0, 96, 9, 1, '', '', '2020-06-03 20:47:28', '2020-06-03 20:47:28'),
(14, '429d7421-2b02-43c9-ad50', 'herixl', 'teste@usuario.con', '51554f535a8ba7a2538697c829481b817767150704b480547e7e36273b02ae026c5f557c6c077205a51b261fce6e88f6518efad352c72a1ce313aaa3bca4f6be', '82d2c0dcb2c29048', 'heircl', 0, 14121996, 141216, 1, '', '', '2020-06-03 22:05:41', '2020-06-03 22:05:41'),
(15, 'd4a54746-1002-4fab-b568', 'hh', 'hericlesaraujo@uni9.edu.br', '2ed5f77cfa707dfbc8cad884cd7ea8dd00a2bf15e483c9b54881acd025ee7b489e0160329c21609b10e85618da588845a34fc240d28f507a96afa5b20a8b121a', 'fb511314f65eaf70', 'hh', 0, 66, 66, 1, '', '', '2020-06-03 22:14:10', '2020-06-03 22:14:10'),
(16, 'cdd8fb69-b776-4457-bb06', 'hh', 'hericlesaraujo@uni9.edu.br2', '3a561a2915de49fcc40b69b1b4a425fdd5ef9d38aea8dd09d89828d7aea4ac4a630689339c4408c673105d40ea6c4b5c627a1ba82cdfca13a1a237151efa1321', '189df4b6d8e0f9a4', 'hh', 0, 66, 66, 0, '', '', '2020-06-03 22:14:21', '2020-06-03 22:14:21'),
(17, '412bcfb6-7ccd-4c50-9b27', 'teste', 'teste@cidade.com', 'e27afc59a1084ba0c7cea183b6cfc0a933eeb324f11f8a9e18bb0fb149dcaf362b9d64f315f5733fd5e5f04f6ebebd8580eb56939c356f98a3bad20b8dfe6e48', 'b8c1fb4a9349070b', 'hericles@usuario.com', 0, 1234, 58321888, 1, 'São Roque do Canaã', 'São Paulo', '2020-06-09 02:58:15', '2020-06-09 02:58:15');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `empresa_vagas`
--
ALTER TABLE `empresa_vagas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_empresa` (`fk_empresa`);

--
-- Indexes for table `usuario_competencias`
--
ALTER TABLE `usuario_competencias`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_competencia` (`fk_competencia`);

--
-- Indexes for table `usuario_curriculo`
--
ALTER TABLE `usuario_curriculo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `foreign_key` (`fk_profissional`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `usuario_competencias`
--
ALTER TABLE `usuario_competencias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `usuario_curriculo`
--
ALTER TABLE `usuario_curriculo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `usuario_empresa`
--
ALTER TABLE `usuario_empresa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `usuario_profissional`
--
ALTER TABLE `usuario_profissional`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `empresa_vagas`
--
ALTER TABLE `empresa_vagas`
  ADD CONSTRAINT `fk_empresa` FOREIGN KEY (`fk_empresa`) REFERENCES `usuario_empresa` (`id`);

--
-- Constraints for table `usuario_competencias`
--
ALTER TABLE `usuario_competencias`
  ADD CONSTRAINT `fk_competencia` FOREIGN KEY (`fk_competencia`) REFERENCES `usuario_profissional` (`id`);

--
-- Constraints for table `usuario_curriculo`
--
ALTER TABLE `usuario_curriculo`
  ADD CONSTRAINT `foreign_key` FOREIGN KEY (`fk_profissional`) REFERENCES `usuario_profissional` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
