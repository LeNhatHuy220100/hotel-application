package com.hotel.project.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "khachhang")
public class KhachHang{
	@Id
	private ObjectId maKhachHang;	
	private String tenKhachHang;
	private String theCanCuoc;
	private String soDienThoai;
	private boolean loaiKhachHang;
	
	public KhachHang(String tenKhachHang, String theCanCuoc, String soDienThoai, boolean loaiKhachHang) {
		super();
		this.tenKhachHang = tenKhachHang;
		this.theCanCuoc = theCanCuoc;
		this.soDienThoai = soDienThoai;
		this.loaiKhachHang = loaiKhachHang;
	}
	
}
