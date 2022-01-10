package com.hotel.project.repository;

import java.util.List;

import com.hotel.project.domain.DichVu;

public interface DichVuRepository {
	public DichVu addDichVu(DichVu dichVu);
	public DichVu findByMaDichVu(String maDichVu);
	public List<DichVu> findALL();
	public boolean deleteDichVu(DichVu dichVu);
	public boolean updateDichVu(DichVu dichVu);
	public List<DichVu> findByTenDichVuTuongDoi(String tenDichVu);
	
}
