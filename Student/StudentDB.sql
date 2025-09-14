create database studentDBa;
go
use studentDBa;
go
CREATE TABLE SinhVien (
    maSV VARCHAR(10) PRIMARY KEY,
    hoTen NVARCHAR(100) NOT NULL,
    ngaySinh DATE NOT NULL,
    nganhDT VARCHAR(10) NOT NULL 
        CHECK (nganhDT IN ('CNTT','KTPM')),
    dtb FLOAT NOT NULL 
        CHECK (dtb >= 0.0 AND dtb <= 10.0),
    lopSH VARCHAR(20) NOT NULL
);