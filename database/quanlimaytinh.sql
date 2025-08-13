-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 12, 2025 at 11:22 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlimaytinh`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `fullName` varchar(50) DEFAULT NULL,
  `userName` varchar(50) NOT NULL,
  `password` varchar(60) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`fullName`, `userName`, `password`, `role`, `status`, `email`) VALUES
('Phương Uyên', 'admin', '$2a$12$Y87zSnx.tpFvieylSeXuo.agjb7swi3UVnoo6KVMY9xP5STj4zJhm', 'Admin', 1, 'uyenuyen100103@gmail.com'),
('Nguyễn Hoàng Anh', 'anhquanly', '$2a$12$HEnLCsOWnz2eIUT5OKu0AOYSK0Fx1HCvK0/QOXvtytzq6dnee3ut2', 'Quản lý kho', 1, 'hoanganhhere@gmail.com'),
('Lê Văn An', 'nhap', '$2a$12$89As1J0AB0yrqGjnQUHtpevc6voGyvzAd8OvzkS1vGDo3YPO2P.Ia', 'Nhân viên nhập', 1, 'an1234@gmail.com'),
('Nguyễn Thị Phương Uyên', 'uyenne', '$2a$12$myOaq0kATMzNkbxgzQEkPu8ht2K0pXOGzZMZo6nSBowq6EyoLo7tS', 'Quản lý kho', 1, 'phuonguyen1002@gmail.com'),
('Trà Thị Hạ Mỹ', 'xuat', '$2a$12$PhiTGBbHjHoB3dbS6BmCC.rzdMCBqDrdK9Y8Ae8GPcKe1RpHiWARO', 'Nhân viên xuất', 1, 'myne2003@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `maPhieu` varchar(50) NOT NULL,
  `maMay` varchar(50) NOT NULL,
  `soLuong` int(11) DEFAULT NULL,
  `donGia` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`maPhieu`, `maMay`, `soLuong`, `donGia`) VALUES
('PN1', 'LP10', 1, 23490000),
('PN1', 'LP19', 1, 19490000),
('PN1', 'LP22', 1, 23490000),
('PN12', 'LP24', 1, 21490000),
('PN12', 'LP8', 1, 18390000),
('PN13', 'LP24', 1, 21490000),
('PN13', 'LP6', 1, 17490000),
('PN14', 'LP19', 1, 19490000),
('PN14', 'LP20', 1, 20790000),
('PN14', 'LP4', 1, 10690000),
('PN2', 'LP20', 1, 20790000),
('PN2', 'LP21', 2, 25990000),
('PN28', 'LP15', 2, 25190000),
('PN28', 'LP24', 1, 21490000),
('PN29', 'LP4', 1, 10690000),
('PN3', 'LP15', 1, 25190000),
('PN3', 'LP17', 1, 23190000),
('PN3', 'LP22', 1, 23490000),
('PN3', 'LP25', 1, 18390000),
('PN3', 'LP4', 2, 10690000),
('PN30', 'LP16', 1, 22990000),
('PN30', 'LP24', 1, 21490000),
('PN30', 'LP3', 1, 15000000),
('PN31', 'LP14', 1, 22490000),
('PN31', 'LP25', 1, 18390000),
('PN31', 'LP7', 1, 17490000),
('PN32', 'LP18', 1, 24990000),
('PN32', 'LP5', 1, 19290000),
('PN32', 'LP9', 1, 16490000),
('PN32', 'PC2', 1, 8290000),
('PN32', 'PC7', 1, 11200000),
('PN33', 'LP14', 1, 22490000),
('PN33', 'LP22', 1, 23490000),
('PN33', 'LP3', 1, 15000000),
('PN33', 'PC1', 1, 7090000),
('PN34', 'LP13', 1, 9990000),
('PN35', 'LP24', 2, 21490000),
('PN35', 'LP4', 1, 10690000),
('PN35', 'LP8', 1, 18390000),
('PN35', 'PC5', 1, 9190000),
('PN36', 'LP23', 1, 15690000),
('PN37', 'LP3', 1, 15000000),
('PN37', 'LP9', 1, 16490000),
('PN38', 'LP23', 20, 15690000),
('PN38', 'LP25', 1, 18390000),
('PN38', 'LP6', 30, 17490000),
('PN39', 'LP14', 2, 22490000),
('PN4', 'LP22', 1, 23490000),
('PN4', 'LP5', 1, 19290000),
('PN4', 'LP7', 1, 17490000),
('PN4', 'LP9', 1, 16490000),
('PN40', 'LP18', 1, 24990000),
('PN40', 'LP26', 2, 0),
('PN5', 'LP4', 3, 10690000),
('PN5', 'LP5', 1, 19290000),
('PN6', 'LP17', 1, 23190000),
('PN6', 'LP26', 1, 0),
('PN6', 'LP3', 1, 15000000),
('PN7', 'LP15', 1, 25190000),
('PN7', 'LP25', 1, 18390000),
('PN7', 'LP3', 1, 15000000),
('PN7', 'LP8', 5, 18390000);

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieuxuat`
--

CREATE TABLE `chitietphieuxuat` (
  `maPhieu` varchar(50) NOT NULL,
  `maMay` varchar(50) NOT NULL,
  `soLuong` int(11) DEFAULT NULL,
  `donGia` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chitietphieuxuat`
--

INSERT INTO `chitietphieuxuat` (`maPhieu`, `maMay`, `soLuong`, `donGia`) VALUES
('PX12', 'LP20', 1, 20790000),
('PX12', 'LP6', 1, 17490000),
('PX12', 'PC1', 1, 7090000),
('PX13', 'LP18', 1, 24990000),
('PX13', 'LP5', 2, 19290000),
('PX13', 'LP6', 1, 17490000),
('PX13', 'PC1', 4, 7090000),
('PX20', 'LP6', 2, 17490000),
('PX20', 'LP9', 1, 16490000),
('PX20', 'PC06', 1, 9690000),
('PX22', 'LP5', 1, 19290000),
('PX26', 'LP18', 1, 24990000),
('PX26', 'LP19', 1, 19490000),
('PX26', 'LP22', 1, 23490000),
('PX26', 'LP3', 1, 15000000),
('PX26', 'LP5', 1, 19290000),
('PX26', 'LP6', 1, 17490000),
('PX27', 'LP23', 1, 15690000),
('PX27', 'LP6', 1, 17490000),
('PX28', 'LP19', 1, 19490000),
('PX28', 'LP25', 1, 18390000),
('PX29', 'LP16', 1, 22990000),
('PX30', 'LP17', 1, 23190000),
('PX31', 'LP18', 1, 24990000),
('PX32', 'LP22', 1, 23490000),
('PX33', 'LP18', 1, 24990000),
('PX34', 'LP23', 1, 15690000),
('PX35', 'LP20', 1, 20790000),
('PX36', 'LP18', 1, 24990000),
('PX37', 'LP5', 1, 19290000),
('PX38', 'LP25', 1, 18390000),
('PX39', 'LP4', 1, 10690000),
('PX4', 'LP16', 1, 22990000),
('PX4', 'LP17', 1, 23190000),
('PX4', 'LP6', 1, 17490000),
('PX4', 'LP7', 1, 17490000),
('PX40', 'LP23', 1, 15690000),
('PX41', 'LP22', 1, 23490000),
('PX42', 'LP21', 1, 25990000),
('PX43', 'LP23', 1, 15690000),
('PX44', 'LP19', 1, 19490000),
('PX45', 'LP3', 1, 15000000),
('PX46', 'LP22', 1, 23490000),
('PX47', 'LP24', 1, 21490000),
('PX48', 'LP20', 1, 20790000),
('PX49', 'LP25', 1, 18390000),
('PX8', 'LP18', 1, 24990000),
('PX8', 'LP24', 1, 21490000),
('PX8', 'LP3', 1, 15000000),
('PX8', 'LP5', 1, 19290000),
('PX8', 'LP8', 1, 18390000),
('PX8', 'PC1', 1, 7090000);

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `maKH` varchar(10) NOT NULL,
  `tenKH` varchar(100) DEFAULT NULL,
  `sdtKH` varchar(20) DEFAULT NULL,
  `diaChi` varchar(255) DEFAULT NULL,
  `soLanMua` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`maKH`, `tenKH`, `sdtKH`, `diaChi`, `soLanMua`) VALUES
('KH01', 'Nguyễn Thàng Sang', '0324354670', 'Thôn 5, Xã Tiên Phước, Thành phố Đà Nẵng', 2),
('KH02', 'Nguyễn Thành Mỹ', '0345326178', 'Phường Ngũ Hành Sơn, Thành phố Đà Nẵng', 0),
('KH03', 'Nguyễn Thị Trà', '0343457687', 'Hòa Hải, Ngũ Hành Sơn, Đà Nẵng', 0),
('KH04', 'Nguyễn Uyên', '0355302219', '', 0),
('KH05', 'A', '0123456789', '', 0),
('KH06', 'A', '0987654321', '', 2),
('KH07', ' nè', '45678', '', 1),
('KH08', 'ohh', '04657568768', '', 0),
('KH09', 'DF', '567890876', '', 1),
('KH10', 'Lê Văn Khánh', '09876545666', '', 0),
('KH11', 'Nguyễn Hoàng Văn', '0123657894', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `maytinh`
--

CREATE TABLE `maytinh` (
  `maMay` varchar(50) NOT NULL,
  `tenMay` varchar(100) DEFAULT NULL,
  `soLuong` int(11) NOT NULL DEFAULT 0,
  `tenCpu` varchar(50) NOT NULL DEFAULT '0',
  `ram` varchar(50) NOT NULL DEFAULT '0',
  `cardManHInh` varchar(50) DEFAULT NULL,
  `gia` double NOT NULL DEFAULT 0,
  `mainBoard` varchar(50) DEFAULT NULL,
  `congSuatNguon` int(11) DEFAULT NULL,
  `loaiMay` varchar(50) DEFAULT NULL,
  `rom` varchar(50) DEFAULT NULL,
  `kichThuocMan` double DEFAULT NULL,
  `dungLuongPin` varchar(50) DEFAULT NULL,
  `xuatXu` varchar(50) DEFAULT NULL,
  `trangThai` int(11) DEFAULT NULL,
  `giaXuat` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `maytinh`
--

INSERT INTO `maytinh` (`maMay`, `tenMay`, `soLuong`, `tenCpu`, `ram`, `cardManHInh`, `gia`, `mainBoard`, `congSuatNguon`, `loaiMay`, `rom`, `kichThuocMan`, `dungLuongPin`, `xuatXu`, `trangThai`, `giaXuat`) VALUES
('LP10', 'Laptop Lenovo IdeaPad Gaming 3', 36, 'Intel Core i5 12500H', '16 GB', 'NVIDIA GeForce RTX 3050', 23490000, NULL, NULL, 'Laptop', '512 GB', 15.6, '4 Cell', 'Trung Quốc', 0, NULL),
('LP12', 'Laptop MSI Modern 14 B11MOU-1028VN', 23, 'Intel Core i3 115G4', '8 GB', 'Intel UHD Graphics', 13090000, NULL, NULL, 'Laptop', '256 GB', 14, '3 Cell', 'Trung Quốc', 0, NULL),
('LP13', 'Laptop HP 15s-fq2663TU', 20, 'Intel Core i3 1115G4', '4 GB', 'Intel UHD Graphics', 9990000, NULL, NULL, 'Laptop', '256 GB', 15.6, '3 Cell', 'Trung Quốc', 1, NULL),
('LP14', 'Laptop Lenovo IdeaPad 5 Pro 16IAH7', 5, 'Intel Core i5 12500H', '16 GB', 'Intel Iris Xe Graphics', 22490000, NULL, NULL, 'Laptop', '512 GB', 16, '4 Cell', 'Trung Quốc', 1, NULL),
('LP15', 'Laptop Lenovo IdeaPad 5 Pro 16IAH7', 28, 'Intel Core i7 12700H', '16 GB', 'Intel Iris Xe Graphics', 25190000, NULL, NULL, 'Laptop', '512 GB', 16, '75 Wh', 'Trung Quốc', 1, NULL),
('LP16', 'Laptop Acer Nitro Gaming AN515-57-54MV', 60, 'Intel Core i5 11400H', '8', 'NVIDIA GeForce RTX 3050', 22990000, NULL, NULL, 'Laptop', '512 GB', 15.6, '4 Cell ', 'Trung Quốc', 1, NULL),
('LP17', 'Laptop MSI Gaming Katana GF66 12UCK-815VN', 22, 'Intel Core i5 12450H', '8 GB', 'Intel UHD Graphics', 23190000, NULL, NULL, 'Laptop', '512 GB', 15.6, '53.5 Wh', 'Trung Quốc', 1, NULL),
('LP18', 'Laptop Asus TUF Gaming FX517ZC-HN077W', 18, 'Intel Core i5 12450H', '8 GB', 'NVIDIA GeForce RTX 3050', 24990000, NULL, NULL, 'Laptop', '512 GB', 15.6, '4 Cell', 'Trung Quốc', 1, NULL),
('LP19', 'Laptop HP Gaming Victus 16-e0175AX', 17, 'AMD Ryzen 5 5600H', '8 GB', 'NVIDIA GeForce RTX 3050 Ti', 19490000, NULL, NULL, 'Laptop', '512 GB', 16.1, '4 Cell', 'Trung Quốc', 1, NULL),
('LP20', 'Laptop MSI GF63 Thin 11UC-444VN', 17, 'Intel Core i5 11400H', '8 GB', 'NVIDIA GeForce RTX 3050', 20790000, NULL, NULL, 'Laptop', '512 GB', 15.6, '3 Cell', 'Trung Quốc', 1, NULL),
('LP21', 'Laptop Asus TUF Gaming FX517ZE-HN045W', 16, 'Intel Core i5 12450H', '8 GB', 'NVIDIA GeForce RTX 3050 Ti', 25990000, NULL, NULL, 'Laptop', '512 GB', 15.6, '4 Cell', 'Trung Quốc', 1, NULL),
('LP22', 'Laptop Lenovo Yoga Slim 7 Pro 14IHU5O', 17, 'Intel Core i5 11300H', '16 GB', 'Intel Iris Xe Graphics', 23490000, NULL, NULL, 'Laptop', '512 GB', 14, '4 Cell ', 'Trung Quốc', 1, NULL),
('LP23', 'Laptop Gigabyte U4 UD-50VN823SO', 33, 'Intel Core i5 1155G7', '16 GB', 'Intel Iris Xe Graphics', 15690000, NULL, NULL, 'Laptop', '512 GB', 14, '36 Wh', 'Trung Quốc', 1, NULL),
('LP24', 'Laptop Dell Vostro V5410 i5', 34, 'Intel Core i5 11320H', '8 GB', 'Intel Iris Xe Graphics', 21490000, NULL, NULL, 'Laptop', '512 GB', 14, '4 Cell', 'Trung Quốc', 1, NULL),
('LP25', 'Laptop MSI Gaming GF63 Thin 11SC-666VN', 50, 'Intel Core i5 11400H', '8 GB', 'NVIDIA GeForce GTX 1650', 18390000, NULL, NULL, 'Laptop', '512 GB', 15.6, '3 Cell', 'Trung Quốc', 1, NULL),
('LP26', 'rty', 3, 'ry', 'rty', '', 0, NULL, NULL, 'Laptop', '', 0, '', '', 1, NULL),
('LP27', 'vbb', 0, 'fgdf', 'bcb', 'fhgfh', 10000, NULL, NULL, 'Laptop', 'fhgh', 0, 'fgfh', 'fhgf', 1, NULL),
('LP3', 'Lenovo ThinkPad E14', 83, 'Intel Core i5 11G352', '8GB', 'OnBoard', 15000000, NULL, NULL, 'Laptop', '521GB', 14, '45Wh', 'Trung Quốc', 1, NULL),
('LP4', 'Lenovo Ideapad 3 15ITL6', 116, 'Intel Core i3 1115G4', '8GB', 'Onboard', 10690000, NULL, NULL, 'Laptop', '512GB', 15.6, '35Wh', 'Trung Quốc', 1, NULL),
('LP5', 'Gigabyte Gaming G5 GD', 11, 'Intel Core i5 11400H', '16GB', 'NVIDIA GeForce RTX 3050 4GB', 19290000, NULL, NULL, 'Laptop', '512GB', 15.6, '50Wh', 'Trung Quốc', 1, NULL),
('LP6', 'MSI Gaming GF63 Thin 11SC-1090VN', 89, 'Intel Core i5 11400H', '8GB', 'NVIDIA GeForce GTX 1650 4GB', 17490000, NULL, NULL, 'Laptop', '512GB', 15.6, '50Wh', 'Trung Quốc', 1, NULL),
('LP7', 'Laptop Asus TUF Gaming FX506LHB-HN188W', 19, 'Intel Core i5 10300H', '8 GB', 'NVIDIA GeForce GTX 1650', 17490000, NULL, NULL, 'Laptop', '512 GB', 15.6, '3 Cell', 'Trung Quốc', 1, NULL),
('LP8', 'Laptop MSI Gaming GF63 Thin 11SC-1090VN', 60, 'Intel Core i5 11400H', '8 GB', 'NVIDIA GeForce GTX 1650 4GB', 18390000, NULL, NULL, 'Laptop', '512 GB', 15.6, '3 Cell', 'Trung Quốc', 1, NULL),
('LP9', 'Laptop Asus TUF Gaming FA506IHRB-HN019W', 27, 'AMD Ryzen 5 4600H', '8 GB', 'NVIDIA GeForce GTX 1650', 16490000, NULL, NULL, 'Laptop', '512 GB', 12, '3 cell', 'Trung Quốc', 1, NULL),
('PC06', 'PC E-Power Office 08', 19, 'Intel Core i5 11400', '16 GB', 'Intel UHD Graphics 730', 9690000, 'Intel H510', 9690000, 'PC - Lắp ráp', '240 GB', NULL, NULL, 'Việt Nam', 1, NULL),
('PC1', 'PC E-Power Office 04', 16, 'Intel Core i3 10105', '8GB', 'Intel HD Graphics 630', 7090000, 'Intel H510', 0, 'Laptop', '240GB', NULL, NULL, 'Việt Nam', 1, NULL),
('PC2', 'PC E-Power Office 05', 30, 'Intel Core i5 10400', '8 GB', 'Intel UHD Graphics 630', 8290000, 'Intel H510', 300, 'PC - Lắp ráp', '8 GB', NULL, NULL, 'Việt Nam', 1, NULL),
('PC3', 'PC E-Power Office 07', 21, 'Intel Core i5 11400', '8 GB', 'Intel UHD Graphics 730', 8990000, 'Intel H510', 8990000, 'PC - Lắp ráp', '240 GB', NULL, NULL, 'Việt Nam', 1, NULL),
('PC30', 'ASUS Vivobook', 1, ' Ryzen 7 5800H ', '16GB', 'GTX 3060', 25000000, NULL, NULL, 'Laptop', '512GB', 24, '3000', 'Việt Nam', 1, NULL),
('PC4', 'PC Gaming E-Power G1650', 71, 'Intel Core i3 10100F', '8 GB', 'Intel UHD Graphics 730', 11990000, 'Intel H510', 300, 'PC - Lắp ráp', '240 GB', NULL, NULL, 'Việt Nam', 1, NULL),
('PC5', 'PC E-Power Office 06', 33, 'Intel Core i5 10400', '16 GB', 'Intel HD Graphics 630', 9190000, 'Intel H510', 200, 'PC - Lắp ráp', '240 GB', NULL, NULL, 'Việt Nam', 1, NULL),
('PC7', 'PC Acer Aspire AS-XC780 DT.B8ASV.006', 21, ' Intel Core i5-7400', '4GB', ' Intel HD Graphics 630 / GeForce GT 720 2GB', 11200000, 'Intel H510', 300, 'PC - Lắp ráp', '1TB', NULL, NULL, 'Việt Nam', 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `maNhaCungCap` varchar(50) NOT NULL,
  `tenNhaCungCap` varchar(50) DEFAULT NULL,
  `Sdt` varchar(50) DEFAULT NULL,
  `diaChi` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`maNhaCungCap`, `tenNhaCungCap`, `Sdt`, `diaChi`) VALUES
('NCC01', 'Công ty TNHH Máy tính Ánh Dương', '0905 123 456', '123 Lê Duẩn, Hải Châu, Đà Nẵng'),
('NCC02', 'Cửa hàng Điện tử Minh Phát', '0905 234 567', '45 Nguyễn Văn Linh, Hải Châu, Đà Nẵng\r\n\r\n'),
('NCC03', 'Công ty TNHH Hoàng Gia', '0905 567 890', '15 Phạm Văn Đồng, Cầu Giấy, Hà Nội'),
('NCC04', 'Công ty CP Thiết bị An Phát', '0905 456 789', '89 Lê Lợi, Quận 1, TP.HCM'),
('NCC05', 'Công ty TNHH Phú Hưng', '0905 345 678', '67 Trần Phú, Hoàn Kiếm, Hà Nội\r\n'),
('NCC06', 'Công ty TNHH Bảo Long', '0905 901 234', '21 Võ Văn Kiệt, Sơn Trà, Đà Nẵng'),
('NCC07', 'Công ty CP Sao Việt', '0905 890 123', '99 Trường Chinh, Tân Bình, TP.HCM\r\n\r\n'),
('NCC08', 'Cửa hàng Quang Huy', '0905 789 012', '56 Hai Bà Trưng, Hoàn Kiếm, Hà Nội'),
('NCC09', 'Nhà phân phối Đại Nam', '0905 678 901', '12 Điện Biên Phủ, Hải Châu, Đà Nẵng');

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `maPhieu` varchar(50) NOT NULL,
  `thoiGianTao` timestamp NULL DEFAULT NULL,
  `nguoiTao` varchar(50) DEFAULT NULL,
  `maNhaCungCap` varchar(50) DEFAULT NULL,
  `tongTien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phieunhap`
--

INSERT INTO `phieunhap` (`maPhieu`, `thoiGianTao`, `nguoiTao`, `maNhaCungCap`, `tongTien`) VALUES
('PN1', '2025-08-07 05:44:17', 'admin', 'NCC04', 66470000),
('PN12', '2025-08-12 06:52:05', 'admin', 'NCC05', 39880000),
('PN13', '2025-08-12 06:52:14', 'admin', 'NCC07', 38980000),
('PN14', '2025-08-12 06:52:50', 'admin', 'NCC04', 50970000),
('PN2', '2025-08-07 05:44:27', 'admin', 'NCC04', 72770000),
('PN28', '2025-08-12 06:52:38', 'admin', 'NCC02', 71870000),
('PN29', '2025-08-12 06:51:46', 'admin', 'NCC03', 10690000),
('PN3', '2025-08-07 05:44:35', 'admin', 'NCC04', 111640000),
('PN30', '2025-08-12 06:52:32', 'admin', 'NCC02', 59480000),
('PN31', '2025-08-12 06:54:38', 'nhap', 'NCC02', 58370000),
('PN32', '2025-08-12 06:52:20', 'admin', 'NCC06', 80260000),
('PN33', '2025-08-12 06:51:24', 'nhap', 'NCC09', 68070000),
('PN34', '2025-08-07 15:04:56', 'admin', 'NCC02', 9990000),
('PN35', '2025-08-07 05:48:39', 'admin', 'NCC06', 81250000),
('PN36', '2025-08-07 15:05:03', 'admin', 'NCC02', 15690000),
('PN37', '2025-08-07 15:05:14', 'admin', 'NCC02', 31490000),
('PN38', '2025-08-07 05:46:01', 'admin', 'NCC02', 856890000),
('PN39', '2025-08-12 06:51:37', 'admin', 'NCC02', 44980000),
('PN4', '2025-08-07 05:44:46', 'admin', 'NCC08', 76760000),
('PN40', '2025-08-07 05:43:46', 'anhquanly', 'NCC02', 24990000),
('PN5', '2025-08-07 05:44:57', 'admin', 'NCC04', 51360000),
('PN6', '2025-08-07 05:45:06', 'admin', 'NCC04', 38190000),
('PN7', '2025-08-07 05:45:15', 'admin', 'NCC07', 150530000);

-- --------------------------------------------------------

--
-- Table structure for table `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `maPhieu` varchar(50) NOT NULL,
  `thoiGianTao` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `nguoiTao` varchar(50) NOT NULL,
  `tongTien` double NOT NULL,
  `maKH` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phieuxuat`
--

INSERT INTO `phieuxuat` (`maPhieu`, `thoiGianTao`, `nguoiTao`, `tongTien`, `maKH`) VALUES
('PX12', '2025-08-10 01:54:23', 'admin', 45370000, 'KH01'),
('PX13', '2025-08-10 01:54:23', 'admin', 109420000, 'KH02'),
('PX20', '2025-08-07 05:47:27', 'admin', 61160000, NULL),
('PX22', '2025-08-07 05:47:19', 'admin', 19290000, NULL),
('PX26', '2025-08-07 05:47:11', 'admin', 119750000, NULL),
('PX27', '2025-08-06 15:41:14', 'Admin', 36498000, NULL),
('PX28', '2025-08-07 15:05:33', 'Admin', 41668000, NULL),
('PX29', '2025-08-08 14:02:58', 'Admin', 25289000.000000004, NULL),
('PX30', '2025-08-08 14:15:06', 'Admin', 25509000.000000004, NULL),
('PX31', '2025-08-08 14:20:28', 'Admin', 27489000.000000004, NULL),
('PX32', '2025-08-08 14:23:55', 'Admin', 25839000.000000004, NULL),
('PX33', '2025-08-08 14:24:42', 'Admin', 27489000.000000004, NULL),
('PX34', '2025-08-08 14:25:07', 'Admin', 17259000, NULL),
('PX35', '2025-08-08 15:33:27', 'Admin', 22869000, NULL),
('PX36', '2025-08-08 15:38:16', 'Admin', 27489000.000000004, NULL),
('PX37', '2025-08-08 15:38:32', 'Admin', 21219000, NULL),
('PX38', '2025-08-08 15:42:15', 'Admin', 20229000, NULL),
('PX39', '2025-08-08 15:42:42', 'Admin', 11759000.000000002, NULL),
('PX4', '2025-08-07 05:47:57', 'admin', 81160000, NULL),
('PX40', '2025-08-08 15:43:01', 'Admin', 17259000, NULL),
('PX41', '2025-08-08 15:43:54', 'Admin', 25839000.000000004, NULL),
('PX42', '2025-08-08 15:44:41', 'Admin', 28589000.000000004, NULL),
('PX43', '2025-08-08 15:51:06', 'Admin', 17259000, NULL),
('PX44', '2025-08-08 15:51:30', 'Admin', 21439000, NULL),
('PX45', '2025-08-08 15:52:14', 'Admin', 16500000.000000002, NULL),
('PX46', '2025-08-10 02:26:00', 'Admin', 25839000.000000004, NULL),
('PX47', '2025-08-10 02:48:36', 'Admin', 23639000.000000004, NULL),
('PX48', '2025-08-10 02:56:19', 'Admin', 22869000, NULL),
('PX49', '2025-08-10 04:30:33', 'Admin', 20229000, 'KH11'),
('PX8', '2025-08-07 05:48:15', 'admin', 106250000, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`userName`) USING BTREE;

--
-- Indexes for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD PRIMARY KEY (`maPhieu`,`maMay`),
  ADD KEY `FK_ChiTietPhieuNhap_MayTinh` (`maMay`);

--
-- Indexes for table `chitietphieuxuat`
--
ALTER TABLE `chitietphieuxuat`
  ADD PRIMARY KEY (`maPhieu`,`maMay`),
  ADD KEY `FK_ChiTietPhieuXuat_MayTinh` (`maMay`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`maKH`);

--
-- Indexes for table `maytinh`
--
ALTER TABLE `maytinh`
  ADD PRIMARY KEY (`maMay`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`maNhaCungCap`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`maPhieu`),
  ADD KEY `FK_PhieuNhap_NhaCungCap` (`maNhaCungCap`),
  ADD KEY `FK_PhieuNhap_Account` (`nguoiTao`);

--
-- Indexes for table `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD PRIMARY KEY (`maPhieu`),
  ADD KEY `FK_PhieuXuat_Account` (`nguoiTao`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `FK_ChiTietPhieuNhap_MayTinh` FOREIGN KEY (`maMay`) REFERENCES `maytinh` (`maMay`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_ChiTietPhieuNhap_PhieuNhap` FOREIGN KEY (`maPhieu`) REFERENCES `phieunhap` (`maPhieu`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `chitietphieuxuat`
--
ALTER TABLE `chitietphieuxuat`
  ADD CONSTRAINT `FK_ChiTietPhieuXuat_MayTinh` FOREIGN KEY (`maMay`) REFERENCES `maytinh` (`maMay`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_ChiTietPhieuXuat_PhieuXuat` FOREIGN KEY (`maPhieu`) REFERENCES `phieuxuat` (`maPhieu`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `FK_PhieuNhap_Account` FOREIGN KEY (`nguoiTao`) REFERENCES `account` (`userName`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_PhieuNhap_NhaCungCap` FOREIGN KEY (`maNhaCungCap`) REFERENCES `nhacungcap` (`maNhaCungCap`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD CONSTRAINT `FK_PhieuXuat_Account` FOREIGN KEY (`nguoiTao`) REFERENCES `account` (`userName`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
