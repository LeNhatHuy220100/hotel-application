package com.hotel.project.repository;

import java.util.List;

import com.hotel.project.domain.KhachHang;

public interface KhachHangRepository {
	public KhachHang add(KhachHang khachHang);
	public KhachHang findByTheCanCuoc(String theCanCuoc);
	public List<KhachHang> findAll();
	void xoaKhTheoCanCuoc(String scc);
	List<KhachHang> findByTenKh(String tenKh);
	void updateKh(KhachHang kh, String maKh);
	void updateCC(String cc, String maKh);
}
