-- Cập nhật số lượng tồn của sản phẩm sau khi thêm hàng nhập
create proc CapNhatSoLuongTon @soluong int, @masp varchar(255)
as 
begin
	update SanPham
	set SoLuongTon = SoLuongTon + @soluong
	where SanPhamID=@masp
end

-- Cập nhật số lượng tồn của sản phẩm sau khi thêm hàng nhập
create trigger CapNhatSanPhamSauKhiThem 
on HangNhap after insert
as
	declare @soluong int, @masp varchar(255)
	select @soluong=hn.SoLuong, @masp=hn.SanPhamID from HangNhap as hn inner join inserted as i
	on hn.SanPhamID = i.SanPhamID
	if(@soluong > 0)
		exec CapNhatSoLuongTon @soluong, @masp
	else
		rollback

-- Cập nhật số lượng, tổng tiền, ngày nhập khi thêm cùng nhà cung cấp và sản phẩm
create proc CapNhatHangNhap @mancc varchar(255), @masp varchar(255), @soluong int, @tongtien money, @ngaynhap datetime
as
begin
	update HangNhap
	set SoLuong = SoLuong + @soluong,
		TongTien = TongTien + @tongtien,
		NgayNhap = @ngaynhap
	where NhaCungCapID=@mancc and SanPhamID=@masp
end

create trigger ThemHangNhap
on HangNhap instead of insert
as
	declare @mancc varchar(255), @masp varchar(255), @soluong int, @tongtien money, @ngaynhap datetime
	select @mancc=NhaCungCapID, @masp=SanPhamID, @soluong=SoLuong, @tongtien=TongTien, @ngaynhap=NgayNhap from inserted
	if exists (select * from HangNhap where SanPhamID=@masp and NhaCungCapID=@mancc)
		exec CapNhatHangNhap @mancc, @masp, @soluong, @tongtien, @ngaynhap
	else 
		insert HangNhap
		select * from inserted

-- Giảm số lượng tồn
create proc GiamSoLuongTon @soluong int, @masp varchar(255)
as
begin
	update SanPham
	set SoLuongTon = SoLuongTon - @soluong
	where SanPhamID=@masp
end

-- Cập nhật số lượng tồn của sản phẩm sau khi xoá hàng nhập
create trigger CapNhatSanPhamSauKhiXoa
on HangNhap after delete
as
	declare @soluong int, @masp varchar(255)
	if exists (select * from deleted)
		begin
			select @soluong=SoLuong, @masp=SanPhamID from deleted
			exec GiamSoLuongTon @soluong, @masp
		end
	else
		rollback

-- Kiểm tra số điện thoại và email của nhân viên không trùng khi thêm nhân viên
create trigger KiemTraSDTEmailNhanVien
on NhanVien instead of insert
as
	declare @sdt varchar(255), @email varchar(255)
	select @sdt=SoDienThoai, @email=Email from inserted
	
	if exists (select * from NhanVien where SoDienThoai=@sdt or Email=@email)
		rollback
	else
		insert NhanVien
		select * from inserted

-- Xoá chi tiết hoá đơn trước khi xoá hoá đơn
create trigger XoaHoaDon
on HoaDon instead of delete
as
	declare @mahd varchar(255)
	select @mahd=HoaDonID from deleted
	delete from ChiTietHoaDon where HoaDonID=@mahd
	delete from HoaDon where HoaDonID=@mahd

