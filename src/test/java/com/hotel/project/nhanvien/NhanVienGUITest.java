package com.hotel.project.nhanvien;

import java.time.LocalDate;
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
import com.hotel.project.domain.NhanVien;
import com.hotel.project.domain.Phong;
import com.hotel.project.domain.TaiKhoan;
import com.hotel.project.repository.KhachHangRepository;
import com.hotel.project.repository.NhanVienRepository;
import com.hotel.project.repository.PhongRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class NhanVienGUITest {
	
	@Autowired
	NhanVienRepository nhanVienRepo;
	
	/* 
	 * 
	 * Thêm nhân viên
	 * 
	 *  */
	
	@Test
	public void addNhanVien() {
		
		/*NhanVien nhanVien=new NhanVien("323","phong","3872163876", "nhan vien", true, LocalDate.of(2000, 4, 19));
		NhanVien nhanVien1=new NhanVien("543","hien","3872163355", "nhan vien", true, LocalDate.of(2000, 8, 2));
		NhanVien nhanVien2=new NhanVien("767","huy","3872163312", "quan ly", true, LocalDate.of(2000, 2, 2));
		NhanVien nhanVien3=new NhanVien("434","tu","3872163921", "quan ly", true, LocalDate.of(2000, 7, 1));
		
		TaiKhoan taiKhoan=new TaiKhoan(nhanVien.getMaNhanVien(), "123", true);
		TaiKhoan taiKhoan1=new TaiKhoan(nhanVien1.getMaNhanVien(), "123", true);
		TaiKhoan taiKhoan2=new TaiKhoan(nhanVien2.getMaNhanVien(), "123", true);
		TaiKhoan taiKhoan3=new TaiKhoan(nhanVien3.getMaNhanVien(), "123", true);
		
		nhanVien.setTaiKhoan(taiKhoan);
		nhanVien1.setTaiKhoan(taiKhoan1);
		nhanVien2.setTaiKhoan(taiKhoan2);
		nhanVien3.setTaiKhoan(taiKhoan3);
			
		nhanVienRepo.add(nhanVien);
		nhanVienRepo.add(nhanVien1);
		nhanVienRepo.add(nhanVien2);
		nhanVienRepo.add(nhanVien3);*/
	}
}