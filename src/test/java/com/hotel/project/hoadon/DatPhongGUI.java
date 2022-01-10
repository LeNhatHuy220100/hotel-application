package com.hotel.project.hoadon;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.hotel.project.domain.ChiTietDichVu;
import com.hotel.project.domain.ChiTietHoaDon;

import com.hotel.project.domain.HoaDon;
import com.hotel.project.domain.KhachHang;
import com.hotel.project.domain.LoaiPhong;
import com.hotel.project.domain.NhanVien;
import com.hotel.project.domain.Phong;
import com.hotel.project.repository.HoaDonRepository;
import com.hotel.project.repository.KhachHangRepository;
import com.hotel.project.repository.LoaiPhongRepository;
import com.hotel.project.repository.NhanVienRepository;
import com.hotel.project.repository.PhongRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class DatPhongGUI {
	@Autowired
	HoaDonRepository hoaDonRepo;
	
	@Autowired
	PhongRepository phongRepo;
	
	@Autowired
	KhachHangRepository khachHangRepo;
	
	@Autowired
	LoaiPhongRepository loaiPhongRepo;
	
	@Autowired
	NhanVienRepository nhanVienRepo;
	/*
	 * Chức năng đặt phòng
	 * Nhân viên tìm kiếm loại phòng phù hợp
	 * Nhân viên tìm kiếm phòng phù hợp nhu cầu khách hàng.
	 * Nhân viên tìm kiếm khách hàng theo thẻ căn cước đã gọi trước đó.
	 * Nhân viên lập hóa đơn set trạng thái hóa đơn là chưa thanh toán.
	 * 
	 */
	@Test
	public void addHoaDon() {	
		//Tìm kiếm loại phòng
		List<Phong> loaiPhong=phongRepo.findAllByTenLoai("THUONG");
		// tìm kiếm phòng số 101
		Phong phong=phongRepo.findByMaPhong("101");
		NhanVien nhanVien=nhanVienRepo.findByMaNhanVien("NV040");
		LoaiPhong loaiPhongTim=loaiPhongRepo.findLoaiByMaPhong(phong.getMaPhong());
		List<ChiTietHoaDon> chiTietList=new ArrayList<ChiTietHoaDon>();	
		
		// tìm kiếm khách hàng có thẻ căn cước 9473824
		KhachHang khachHang=khachHangRepo.findByTheCanCuoc("264522152");
		
		HoaDon hoaDon=new HoaDon(LocalDateTime.now(),
				LocalDateTime.now(), 
				LocalDateTime.now(),
				LocalDate.of(2020, 11, 2),
				LocalDate.of(2020, 11, 5),
				true);	
		
		hoaDon.setKhachHang(khachHang);
		
		ChiTietHoaDon chiTiet=new ChiTietHoaDon(phong.getMaPhong(),loaiPhongTim.getTenLoai(),phong.getSoGiuong(),phong.getSoNguoiToiDa(),phong.getGiaPhong());		
		chiTiet.setThoiGianTheuDau(LocalDate.of(2020, 11, 2));
		chiTiet.setThoiGianTheuCuoi(LocalDate.of(2020, 11, 5));	
		chiTiet.setTheCanCuoc("");
		chiTiet.setTenKhachHang("");
		chiTiet.setSoDienThoai("");
		
		chiTietList.add(chiTiet);		
		
		List<ChiTietDichVu> chiTietDichVuList=new ArrayList<ChiTietDichVu>();	
		hoaDon.setListHoaDon(chiTietList);
		hoaDon.setListDichVu(chiTietDichVuList);
		hoaDon.setNhanVien(nhanVien);
		// tạo ra một hóa đơn mới
		hoaDonRepo.addHoaDon(hoaDon);
	}
	
	
	
	
	
}
