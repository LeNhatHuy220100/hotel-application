package com.hotel.project.phong;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import com.hotel.project.repository.PhongRepository;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class PhongTest {
	@Autowired
	MongoTemplate mongoTemplate;
	@Autowired
	PhongRepository phongRepository;
	/*
	 * Hiển thị tất cả các phòng theo loại phòng
	 */
	@Test
	public void findAllPhongByMaLoaiPhong() {
		System.out.println("Hiển thị tất cả các phòng theo loại phòng");
		phongRepository.findAllByTenLoai("THUONG").forEach(phong->{
			System.out.println(phong);
		});
	}
}
