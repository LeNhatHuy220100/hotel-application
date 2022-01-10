package com.hotel.project.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "chitiethoadon")
public class ChiTietHoaDon {
	private String maPhong;
	private String loaiPhong;
	private int soGiuong;
	private int soNguoiToiDa;
	private double giaPhong; 
	private LocalDate thoiGianTheuDau;
	private LocalDate thoiGianTheuCuoi;	
	private double donGia;
	private double thanhTien;	
	
	private String theCanCuoc;
	private String tenKhachHang;
	private String soDienThoai;
	
	public ChiTietHoaDon(String maPhong, String loaiPhong ,int soGiuong,int soNguoiToiDa,double donGia) {
		super();
		this.maPhong = maPhong;
		this.loaiPhong = loaiPhong;			
		this.donGia=donGia;	
		this.soGiuong=soGiuong;
		this.soNguoiToiDa=soNguoiToiDa;
	}	

	/*
	 * thành tiền bằng thời gian ngày thêu nhân cho đơn giá(giá phòng) 
	 * tính thành tiền của một phòng.
	 */
	public double tinhThanhTien() {
		
		return 0;
	}
	
	 
}
