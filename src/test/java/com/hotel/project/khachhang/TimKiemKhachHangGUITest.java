package com.hotel.project.khachhang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.hotel.project.domain.KhachHang;
import com.hotel.project.repository.KhachHangRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class TimKiemKhachHangGUITest {
	@Autowired
	KhachHangRepository khachHangRepo;
	
	/* 
	 * 
	 * Tìm kiếm khách hàng
	 * 
	 *  */
	
	@Test
	public void findAllKhachHang() {
		khachHangRepo.findAll().forEach(khachHang->{
			System.out.println(khachHang);
		});
	}
}
