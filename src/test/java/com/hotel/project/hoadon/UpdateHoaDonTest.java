package com.hotel.project.hoadon;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.hotel.project.domain.ChiTietDichVu;
import com.hotel.project.domain.ChiTietHoaDon;
import com.hotel.project.domain.DichVu;
import com.hotel.project.domain.HoaDon;
import com.hotel.project.domain.KhachHang;
import com.hotel.project.domain.LoaiPhong;
import com.hotel.project.domain.Phong;
import com.hotel.project.repository.DichVuRepository;
import com.hotel.project.repository.HoaDonRepository;
import com.hotel.project.repository.KhachHangRepository;
import com.hotel.project.repository.LoaiPhongRepository;
import com.hotel.project.repository.PhongRepository;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class UpdateHoaDonTest {
	
	Log log=LogFactory.getLog(UpdateHoaDonTest.class);
	@Autowired
	HoaDonRepository hoaDonRepo;
	@Autowired
	DichVuRepository dichVuRepo;
	@Autowired
	PhongRepository phongRepo;
	@Autowired
	KhachHangRepository khachHangRepo;
	
	@Autowired
	LoaiPhongRepository loaiPhongRepo;
	/*
	 * Chức năng đặt phòng
	 * Nhân viên tìm kiếm phòng phù hợp nhu cầu khách hàng.
	 * Nhân viên tìm kiếm khách hàng theo thẻ căn cước đã gọi trước đó.
	 * Nhân viên lập hóa đơn set trạng thái hóa đơn là chưa thanh toán.
	 * 
	 */
//	@Test
//	public void addHoaDon() {	
//		//Tìm kiếm loại phòng
//			List<Phong> loaiPhong=phongRepo.findAllByTenLoai("THUONG");
//			// tìm kiếm phòng số 101
//			Phong phong=phongRepo.findByMaPhong("101");
//			LoaiPhong loaiPhongTim=loaiPhongRepo.findLoaiByMaPhong(phong.getMaPhong());
//			List<ChiTietHoaDon> chiTietList=new ArrayList<ChiTietHoaDon>();	
//			
//			// tìm kiếm khách hàng có thẻ căn cước 9473824
//			KhachHang khachHang=khachHangRepo.findByTheCanCuoc("9473824");
//			
//			HoaDon hoaDon=new HoaDon(LocalDateTime.now(),
//					LocalDateTime.now(), 
//					LocalDateTime.now(),
//					LocalDate.of(2020, 11, 2),
//					LocalDate.of(2020, 11, 5),
//					false);	
//			
//			hoaDon.setTenKhachHang(khachHang.getTenKhachHang());
//			hoaDon.setTheCanCuoc(khachHang.getTheCanCuoc());
//			hoaDon.setSodienThoai(khachHang.getSoDienThoai());
//			
//			ChiTietHoaDon chiTiet=new ChiTietHoaDon(phong.getMaPhong(),loaiPhongTim.getTenLoai(),phong.getGiaPhong());		
//			chiTiet.setThoiGianTheuDau(LocalDate.of(2020, 11, 2));
//			chiTiet.setThoiGianTheuCuoi(LocalDate.of(2020, 11, 5));	
//			chiTietList.add(chiTiet);		
//			
//			List<ChiTietDichVu> chiTietDichVuList=new ArrayList<ChiTietDichVu>();	
//			hoaDon.setListHoaDon(chiTietList);
//			hoaDon.setListDichVu(chiTietDichVuList);
//			// tạo ra một hóa đơn mới
//			hoaDonRepo.addHoaDon(hoaDon);
//	}
	
	/*
	 * Chức năng hiện thị thông tin hóa đơn theo tên phòng
	 */
//	@Test
//	public void testUpdateHoaDon() {
//		HoaDon hoaDon=hoaDonRepo.findByTheCanCuocAndTrangThaiThanhToanAndMaPhong(
//				"9473824", "101");
//		System.out.println(hoaDon);	
//	}
	
	/*
	 * Chức năng nhận phòng
	 * 
	 */
	@Test
	public void findAndUpdateHoaDon() {
		KhachHang khachHang=khachHangRepo.findByTheCanCuoc("089233");
		HoaDon hoaDon=hoaDonRepo.updateKhachHang("9473824", "101", khachHang,LocalDateTime.now());		
		System.out.println("Update Hoa Don"+hoaDon);
	}
	/*
	 * 
	 * Chức năng update phòng(thêm dịch vụ)	
	 * 
	 */
	@Test
	public void UpdateDichVuInHoaDon() {
		// tìm kiếm dịch vụ
		DichVu dichVu=dichVuRepo.findByMaDichVu("1");
		DichVu dichVu2=dichVuRepo.findByMaDichVu("2");
		List<ChiTietDichVu> chiTietDichVUList=new ArrayList<ChiTietDichVu>();
		// thêm dịch vụ vào trong chi tiết dịch vụ và nhập vào số lượng dịch vụ muốn sử dụng
		ChiTietDichVu chiTietDichVu=new ChiTietDichVu(dichVu.getMaDichVu(),dichVu.getTenDichVu(),
				2, dichVu.getGiaDichVu(), "101");
		ChiTietDichVu chiTietDichVu1=new ChiTietDichVu(dichVu2.getMaDichVu(),dichVu2.getTenDichVu(),
				3, dichVu2.getGiaDichVu(), "101");		
		chiTietDichVUList.add(chiTietDichVu);
		chiTietDichVUList.add(chiTietDichVu1);
		chiTietDichVUList.forEach(c->{
			HoaDon hoaDon=hoaDonRepo.updateDichVu("9473824", "101", c);
			System.out.println(hoaDon);
		});
		
	}
	/*
	 * Chức năng thanh toán
	 */
	
}
