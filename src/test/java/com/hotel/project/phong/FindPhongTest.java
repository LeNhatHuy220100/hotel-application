package com.hotel.project.phong;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.hotel.project.domain.Phong;
import com.hotel.project.repository.LoaiPhongRepository;
import com.hotel.project.repository.PhongRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class FindPhongTest {
	
	@Autowired
	PhongRepository phongRepository;
	
	@Autowired
	LoaiPhongRepository loaiPhongRepository;
	
	/*
	 * Tìm kiếm phòng theo mã phòng
	 */
	@Test
	public void init() {
		System.out.println("Tìm kiếm phòng theo mã phòng---------------------------------");
		Phong phong=phongRepository.findByMaPhong("101");
		System.out.println("Phong so :" + phong.getMaPhong());
	}
	
	@Test
	public void findAllPhongByMaLoaiPhong() {
		System.out.println("Hiển thị tất cả các phòng theo loại phòng");
		phongRepository.findAllByTenLoai("THUONG").forEach(phong->{
			System.out.println(phong);
		});
	}
	/*
	 * Hiển thị tất cả các phòng.
	 */
	@Test
	public void findAllPhong() {
		System.out.println("Hiển thị tất cả các phòng-------------------------------------");
		List<Phong> list=new ArrayList<Phong>();
		list=phongRepository.findAll();
		list.forEach(phong->{
			System.out.println("phong :"+phong);
		});	
	}
}
