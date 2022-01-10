package com.hotel.project.repository;

import com.hotel.project.domain.LoaiPhong;

public interface LoaiPhongRepository {
	LoaiPhong add(LoaiPhong loaiPhong);
	LoaiPhong findLoaiByMaPhong(String maPhong);
}
