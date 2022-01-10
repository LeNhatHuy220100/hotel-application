package com.hotel.project.hoadon;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.hotel.project.domain.HoaDon;
import com.hotel.project.repository.HoaDonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class ThanhToanHoaDonGUI {
	@Autowired
	HoaDonRepository hoaDonRepo;
	
	
	/*
	*Hiển thị danh sách các hóa đơn
	*/
	@Test
	public void showHoaDonList() {
		List<HoaDon> listHoaDon=hoaDonRepo.findAllByTrangThaiThanhToan();
		listHoaDon.forEach(hd->{
			System.out.println(hd);
		});
	}
	/*
	 * Hiển thị thông tin hóa đơn dùng để thanh toán
	 */
	@Test
	public void showHoaDonByTheCanCuoc() {
		HoaDon hoaDon=hoaDonRepo.findAndUpdateBytheCanCuocAndTrangThaiThanhToan("9473824",LocalDateTime.now());
		System.out.println(hoaDon);	
		System.out.println(hoaDon.getNhanVien());
		
		hoaDon.getListDichVu().forEach(dv->{
			System.out.println(dv);
		});
	// tính thành tiền của hóa đơn
		double thanhTienCuaHoaDon=hoaDon.tinhThanhTien(hoaDon.getListHoaDon(),hoaDon.getListDichVu());
		System.out.println("Thành tiền của hóa đơn :"+thanhTienCuaHoaDon);
	}
}
