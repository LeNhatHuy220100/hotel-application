package com.hotel.project.phong;

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

import com.hotel.project.domain.LoaiPhong;
import com.hotel.project.domain.Phong;
import com.hotel.project.repository.LoaiPhongRepository;
import com.hotel.project.repository.PhongRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class PhonGUITest {
	
	@Autowired
	PhongRepository phongRepository;
	
	@Autowired
	LoaiPhongRepository loaiPhongRepository;
	/*
	 * Thêm phòng
	 * 
	 */	
	@Test
	public void addPhong() {
		System.out.println("Thêm phòng----------------------------");
		Phong phong101=new Phong("101",  false,2,1,1000000);
		Phong phong102=new Phong("102", true,2,1,1000000);
		
		Phong phong301=new Phong("301", true,2,1,1000000);
		
		Phong phong401=new Phong("401", false,4,2,1600000);
		Phong phong402=new Phong("402", true,4,2,1600000);
		Phong phong403=new Phong("403", false,4,2,1600000);
		

		Phong phong201=new Phong("201", true,4,2,1300000);
		Phong phong202=new Phong("202", false,4,2,1300000);
		
		List<Phong> phongThuongList=new ArrayList<Phong>();
		List<Phong> phongGiaDinhList=new ArrayList<Phong>();
		List<Phong> phongVipList=new ArrayList<Phong>();
		
		phongThuongList.add(phong101);
		phongThuongList.add(phong102);
		phongThuongList.add(phong301);
		
		phongGiaDinhList.add(phong201);
		phongGiaDinhList.add(phong202);
		
		
		phongVipList.add(phong401);			
		phongVipList.add(phong402);
		phongVipList.add(phong403);
		
		LoaiPhong thuong=new LoaiPhong("THUONG","Phòng thường có 1 smart tivi, tủ lạnh",phongThuongList);
		LoaiPhong giaDinh=new LoaiPhong("GIADINH","Phòng gia đình có 2 smart tivi, tủ lạnh", phongGiaDinhList);	
		LoaiPhong vip=new LoaiPhong("VIP","Phòng vip có 2 smart tivi, tủ lạnh, bữa sáng miễn phí", phongVipList);
		
		phongRepository.add(phong101);
		phongRepository.add(phong102);
		phongRepository.add(phong201);
		phongRepository.add(phong202);
		phongRepository.add(phong301);
		phongRepository.add(phong401);
		phongRepository.add(phong402);
		phongRepository.add(phong403);
		
		loaiPhongRepository.add(thuong);
		loaiPhongRepository.add(giaDinh);
		loaiPhongRepository.add(vip);
	}	
}