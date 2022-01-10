package com.hotel.project.dichvu;

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

import com.hotel.project.domain.DichVu;
import com.hotel.project.domain.KhachHang;
import com.hotel.project.domain.LoaiPhong;
import com.hotel.project.domain.Phong;
import com.hotel.project.repository.DichVuRepository;
import com.hotel.project.repository.KhachHangRepository;
import com.hotel.project.repository.PhongRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class DichVuGUITest {
	
	@Autowired
	DichVuRepository dichVuRepo;
	
	/* 
	 * 
	 * Thêm dịch vụ
	 * 
	 *  */	
	/*@Test
	public void addDichVu() {
		DichVu dichVu=new DichVu("1","Nuoc Ngot", 10000,"Đồ uống");
		DichVu dichVu1=new DichVu("2","Nuoc Loc", 50000,"Đồ uống");
		DichVu dichVu2=new DichVu("3","Com", 20000,"Thức ăn");
		dichVuRepo.addDichVu(dichVu);
		dichVuRepo.addDichVu(dichVu1);
		dichVuRepo.addDichVu(dichVu2);
	}*/
	
	//Tim dich vu
	@Test
	public void timdv(){
		DichVu v = new DichVu();
		//v = dichVuRepo.findByTenDichVu("Nuoc Ngot");
		//System.out.println(v);
	}
	
}