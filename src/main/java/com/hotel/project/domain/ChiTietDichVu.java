package com.hotel.project.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "chitietdichvu")
public class ChiTietDichVu {
	private String maDichVu;
	private String tenDichVu;
	private double gia;
	private int soLuong;
	private double thanhTien;
	private String phongDichVu;
	
	public ChiTietDichVu(String maDichVu,String tenDichVu,int soLuong, double gia,String phongDichVu) {
		super();
		this.maDichVu=maDichVu;
		this.tenDichVu=tenDichVu;
		this.soLuong = soLuong;
		this.gia = gia;
		this.phongDichVu=phongDichVu;
		tinhThanhTien();
		
	}
	// tính thành tiền của một dịch vụ
	public double tinhThanhTien() {
		this.thanhTien=this.soLuong*this.gia;
		return this.thanhTien;
	}
}
