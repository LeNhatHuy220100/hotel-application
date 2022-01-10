package com.hotel.project.khachhang;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.hotel.project.domain.KhachHang;
import com.hotel.project.domain.LoaiPhong;
import com.hotel.project.domain.Phong;
import com.hotel.project.repository.KhachHangRepository;
import com.hotel.project.repository.PhongRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class ThemKhachHangGUITest {
	
	@Autowired
	KhachHangRepository khachHangRepo;
	
	/* 
	 * 
	 * Thêm khách hàng
	 * 
	 *  */
	
	@Test
	public void addKhachHang() {
		KhachHang khachHang=new KhachHang("phong", "9473824", "083286332", true);
		KhachHang khachHang1=new KhachHang("hien", "463243", "982367434", true);
		KhachHang khachHang2=new KhachHang("huy", "089233", "962397699", false);
		KhachHang khachHang3=new KhachHang("tu", "584375", "754637655", false);
		
		khachHangRepo.add(khachHang);
		khachHangRepo.add(khachHang1);
		khachHangRepo.add(khachHang2);
		khachHangRepo.add(khachHang3);
	}
}