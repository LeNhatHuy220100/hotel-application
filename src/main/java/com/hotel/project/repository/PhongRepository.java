package com.hotel.project.repository;

import java.util.List;


import com.hotel.project.domain.Phong;


public interface PhongRepository {
	Phong add(Phong phong);
	Phong findByMaPhong(String maPhong);
	List<Phong> findAll();
	List<Phong> findAllByTenLoai(String tenLoai);
	//Update phong
	Phong updatePhong(Phong p, String loai, boolean tt);
	//loại phòng
}
