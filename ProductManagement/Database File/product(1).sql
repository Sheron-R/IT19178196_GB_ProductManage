-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2021 at 12:36 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `PID` int(25) NOT NULL,
  `productname` varchar(100) NOT NULL,
  `productcode` varchar(100) NOT NULL,
  `productquantity` varchar(100) NOT NULL,
  `productdescription` varchar(200) NOT NULL,
  `productprice` varchar(100) NOT NULL,
  `productavailable` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`PID`, `productname`, `productcode`, `productquantity`, `productdescription`, `productprice`, `productavailable`) VALUES
(3, 'sdfgh', 'P04', '3', 'sdfghj', '$55', 'no'),
(6, 'Yamaha', 'P08', '3', 'New Model v5', '$86', 'no'),
(8, 'Headphones', 'P06', '5', 'New Model', '$12', 'yes'),
(9, 'Hp', 'P07', '5', 'New Model v3', '$38', 'yes'),
(10, 'Hp 7', 'P11', '7', 'New Model v9', '$40', 'yes'),
(11, 'Hp 8', 'P18', '8', 'New Model v0', '$90', 'no'),
(12, 'hi', 'P98', '23', 'Model v6', '$7', 'yES'),
(20, 'Hp laptop', 'P87', '2', 'core i7', '$98', 'yes'),
(33, 'casio', 'P59', '7', 'V6', '$60', 'no'),
(42, 'Yamaha Keyboard', 'P56', '1', 'PSR R 900', '$105', 'Yes'),
(43, 'Casio', 'P04', '3', 'New Model', '$55', 'no');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`PID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `PID` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=89;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
