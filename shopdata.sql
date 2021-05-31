-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 31, 2021 at 12:10 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shopdata`
--

-- --------------------------------------------------------

--
-- Table structure for table `cd_details`
--

CREATE TABLE `cd_details` (
  `cd_id` varchar(100) NOT NULL,
  `cd_name` varchar(100) NOT NULL,
  `cd_quantity` int(100) NOT NULL,
  `cd_price` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cd_details`
--

INSERT INTO `cd_details` (`cd_id`, `cd_name`, `cd_quantity`, `cd_price`) VALUES
('101', 'cd1', -5, 100),
('102', 'cd2', 9, 200),
('103', 'cd3', 9, 200),
('1045', 'cdetwq', 2434, 23545),
('105', 'cd5', 6, 200),
('106', 'cd6', 16, 500),
('108', 'cd8', 100, 100),
('109', 'cd9', 199, 200),
('111', 'cd11', 111, 111),
('115', 'cd15', 199, 1000),
('cd109', 'cd9', 123, 800),
('cd40', 'cd40', 97, 100);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cd_details`
--
ALTER TABLE `cd_details`
  ADD UNIQUE KEY `cd_id` (`cd_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
