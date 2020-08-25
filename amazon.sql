-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 25, 2020 at 10:56 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.3.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `amazon`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `catalog`
--

CREATE TABLE `catalog` (
  `id` int(11) NOT NULL,
  `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `parent_id` int(11) NOT NULL DEFAULT 0,
  `sort_order` tinyint(4) NOT NULL DEFAULT 0
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `catalog`
--

INSERT INTO `catalog` (`id`, `name`, `parent_id`, `sort_order`) VALUES
(1, 'Laptop', 0, 0),
(2, 'Điện thoại', 0, 1),
(3, 'Tivi', 0, 2),
(4, ' Acer', 1, 0),
(5, ' Apple', 1, 1),
(6, 'Asus', 1, 2),
(7, 'Dell', 1, 3),
(8, 'HP', 1, 5),
(9, 'Apple', 2, 0),
(10, 'Asus', 2, 1),
(11, 'BlackBerry', 2, 3),
(12, 'HTC', 2, 4),
(13, 'AKAI', 3, 0),
(14, 'JVC', 3, 1),
(15, 'LG', 3, 2),
(16, 'Panasonic', 3, 3),
(17, 'Samsung', 3, 5),
(18, 'Toshiba', 3, 6);

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `transaction_id` int(255) NOT NULL,
  `id` int(255) NOT NULL,
  `product_id` int(255) NOT NULL,
  `qty` int(11) NOT NULL DEFAULT 0,
  `amount` decimal(15,4) NOT NULL DEFAULT 0.0000,
  `data` text COLLATE utf8_bin NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT 0
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(255) NOT NULL,
  `userId` int(255) NOT NULL,
  `catalog_id` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `price` decimal(15,2) NOT NULL DEFAULT 0.00,
  `content` text COLLATE utf8_unicode_ci NOT NULL,
  `discount` int(11) NOT NULL,
  `image_link` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `image_list` text COLLATE utf8_unicode_ci NOT NULL,
  `created` int(11) NOT NULL DEFAULT 0,
  `view` int(11) NOT NULL DEFAULT 0
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `userId`, `catalog_id`, `name`, `price`, `content`, `discount`, `image_link`, `image_list`, `created`, `view`) VALUES
(2, 19, 15, 'Tivi LG 4000', '199.67', 'Acer Aspire 5 Slim Laptop,Graphics, 4GB DDR4, 128GB SSD, Backlit Keyboard, Windows 10 in S Mode, A515-43-R19L,Silver', 10, 'product2.jpg', '', 0, 2),
(3, 20, 13, 'Tivi Akai', '209.99', 'Bài viết cho sản phẩm này đang được cập nhật ...', 0, 'product1.jpg', '', 0, 4),
(4, 21, 16, 'Tivi Panasonic', '239.59', 'Bài viết cho sản phẩm này đang được cập nhật ...', 0, 'product3.jpg', '', 0, 0),
(5, 19, 17, 'Tivi Samsung', '229.19', 'Bài viết cho sản phẩm này đang được cập nhật ...', 0, 'product4.jpg', '', 0, 1),
(6, 19, 15, 'Tivi LG 5000', '239.59', 'Bài viết cho sản phẩm này đang được cập nhật ...', 0, 'product5.jpg', '', 0, 0),
(7, 22, 18, 'Tivi Toshiba', '209.99', 'Bài viết cho sản phẩm này đang được cập nhật ...', 9, 'product6.jpg', '', 0, 8),
(8, 23, 14, 'Tivi JVC 500', '419.19', 'Bài viết cho sản phẩm này đang được cập nhật ...', 29, 'product7.jpg', '', 0, 68),
(9, 21, 15, 'Tivi LG 520', '209.99', '<p>\r\n	B&agrave;i viết cho sản phẩm n&agrave;y đang được cập nhật ...</p>\r\n', 0, 'product13.jpg', 'a:0:{}', 0, 16),
(16, 19, 2, 'Iphone 11 XS max', '209.99', 'Bài viết cho sản phẩm này đang được cập nhật ...', 19, 'product2.jpg', '', 0, 2),
(17, 19, 2, 'Iphone 11 XS max 2', '229.19', 'Bài viết cho sản phẩm này đang được cập nhật ...', 0, 'product1.jpg', '', 0, 4),
(18, 19, 2, 'Iphone 11 XS max 3', '419.19', 'Bài viết cho sản phẩm này đang được cập nhật ...', 0, 'product3.jpg', '', 0, 0),
(19, 19, 2, 'Iphone 11 XS max 4', '219.19', 'Bài viết cho sản phẩm này đang được cập nhật ...', 0, 'product4.jpg', '', 0, 1),
(20, 19, 2, 'Iphone 11 XS max 5', '339.99', 'Bài viết cho sản phẩm này đang được cập nhật ...', 0, 'product5.jpg', '', 0, 0),
(21, 19, 2, 'Iphone 11 XS max 6', '223.19', 'Bài viết cho sản phẩm này đang được cập nhật ...', 0, 'product6.jpg', '', 0, 8),
(22, 19, 2, 'Iphone 11 XS max 7', '399.99', 'Bài viết cho sản phẩm này đang được cập nhật ...', 29, 'product7.jpg', '', 0, 68),
(23, 19, 2, 'Iphone 11 XS max 8', '349.18', '<p>\r\n	B&agrave;i viết cho sản phẩm n&agrave;y đang được cập nhật ...</p>\r\n', 0, 'product13.jpg', 'a:0:{}', 0, 16),
(24, 19, 3, 'Tivi Sony Smart 43', '318.28', 'Bài viết cho sản phẩm này đang được cập nhật ...', 18, 'product2.jpg', '', 0, 2),
(25, 19, 3, 'Tivi Sony Smart 32', '199.99', 'Bài viết cho sản phẩm này đang được cập nhật ...', 0, 'product1.jpg', '', 0, 4),
(26, 19, 3, 'Tivi Sony Smart 43', '300.99', 'Bài viết cho sản phẩm này đang được cập nhật ...', 0, 'product3.jpg', '', 0, 0),
(27, 20, 3, 'Sony Android Tivi 4K 55\"\"', '349.29', 'Bài viết cho sản phẩm này đang được cập nhật ...', 0, 'product4.jpg', '', 0, 1),
(28, 21, 3, 'Sony Android Tivi 4K 32\"\"', '215.15', 'Bài viết cho sản phẩm này đang được cập nhật ...', 0, 'product5.jpg', '', 0, 0),
(29, 21, 3, 'Sony Android Tivi 4K 44\"\"', '300.99', 'Bài viết cho sản phẩm này đang được cập nhật ...', 19, 'product6.jpg', '', 0, 8),
(30, 22, 3, 'Sony Android Tivi 4K 65\"\"', '429.15', 'Bài viết cho sản phẩm này đang được cập nhật ...', 18, 'product7.jpg', '', 0, 68),
(31, 21, 3, 'Sony Android Tivi 4K 80\"\"', '219.59', '<p>\r\n	B&agrave;i viết cho sản phẩm n&agrave;y đang được cập nhật ...</p>\r\n', 0, 'product13.jpg', 'a:0:{}', 0, 16);

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

CREATE TABLE `review` (
  `productId` int(255) NOT NULL,
  `userId` int(255) NOT NULL,
  `content` text NOT NULL,
  `created` int(15) NOT NULL,
  `rate` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `shipping_location`
--

CREATE TABLE `shipping_location` (
  `id` int(255) NOT NULL,
  `userId` int(255) NOT NULL,
  `receiver_name` varchar(50) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `address` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `id` bigint(20) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT 0,
  `user_id` int(11) NOT NULL DEFAULT 0,
  `shipping_address_id` int(255) NOT NULL,
  `amount` decimal(15,2) NOT NULL DEFAULT 0.00,
  `payment` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `payment_info` text COLLATE utf8_bin NOT NULL,
  `message` varchar(255) COLLATE utf8_bin NOT NULL,
  `security` varchar(16) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `created` int(11) NOT NULL DEFAULT 0
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(255) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `created` int(11) NOT NULL,
  `type` int(2) NOT NULL DEFAULT 0
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `email`, `phone`, `password`, `created`, `type`) VALUES
(19, 'thanh', 'letrinhthanh45@gmail.com', '0966618558', '123', 1598327702, 0),
(20, 'tam', 'tamle@gmail.com', '0987112839', '123', 1598327887, 0),
(21, 'tam123', 'tamle123@gmail.com', '0987112839', '123', 1598327900, 0),
(22, 'thanh123', 'thanh123@gmail.com', '0987112129', '123', 1598328000, 0),
(23, 'thanh789', 'thanh789@gmail.com', '0987112839', '123', 1598329000, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `catalog`
--
ALTER TABLE `catalog`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);
ALTER TABLE `product` ADD FULLTEXT KEY `name` (`name`);

--
-- Indexes for table `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`productId`,`userId`);

--
-- Indexes for table `shipping_location`
--
ALTER TABLE `shipping_location`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `catalog`
--
ALTER TABLE `catalog`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `shipping_location`
--
ALTER TABLE `shipping_location`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
