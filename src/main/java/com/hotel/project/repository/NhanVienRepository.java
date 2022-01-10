package com.hotel.project.repository;

import java.util.List;

import com.hotel.project.domain.NhanVien;

public interface NhanVienRepository {
	NhanVien add(NhanVien nhanVien);
	NhanVien findByMaNhanVien(String maNhanVien);
	NhanVien authenticationByMaNhanVienAndMatKhau(String maNhanVien,String matKhau);
	List<NhanVien> findAllNV();
	void xoaNVTheoMa(String ma);
	void updateNV(NhanVien nv);
	NhanVien findBySoCanCuoc(String scc);
	List<NhanVien> findByTenNhanVien(String tenNhanVien);
	NhanVien findByTK(String tk);
	void updateCC(String cc, String ma);
}
