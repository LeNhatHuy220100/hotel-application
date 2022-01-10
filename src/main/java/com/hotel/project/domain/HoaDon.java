package com.hotel.project.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "hoadon")
public class HoaDon {
	
	@Id
	private ObjectId maHoaDon;
	private LocalDateTime thoiGianLHD;
	private LocalDateTime thoiGianNP;
	private LocalDateTime thoiGianTP;	
	private LocalDate thoiGianTheuDau;
	private LocalDate thoiGianTheuCuoi;	
	private boolean trangThaiThanhToan;
	private double thanhTien=0;
	private KhachHang khachHang;
	private List<ChiTietHoaDon> listHoaDon;	
	private List<ChiTietDichVu> listDichVu;
	private NhanVien nhanVien;
	
	
	public HoaDon(LocalDateTime thoiGianLHD, LocalDateTime thoiGianNP, LocalDateTime thoiGianTP, LocalDate thoiGianTheuDau,LocalDate thoiGianTheuCuoi,
			boolean trangThaiThanhToan) {
		super();
		this.thoiGianLHD = thoiGianLHD;
		this.thoiGianNP = thoiGianNP;
		this.thoiGianTP = thoiGianTP;
		this.thoiGianTheuDau=thoiGianTheuDau;
		this.thoiGianTheuCuoi=thoiGianTheuCuoi;
		this.trangThaiThanhToan = trangThaiThanhToan;
		
	}
	
	// tính thành tiền của một hóa đơn
	public double tinhThanhTien(List<ChiTietHoaDon> listHoaDon,List<ChiTietDichVu> chiTietDichVu) {
		listHoaDon.forEach(chiTiet->{
			this.thanhTien+=chiTiet.getDonGia();
		});
		chiTietDichVu.forEach(dv->{
			this.thanhTien+=dv.getThanhTien();
		});
		return this.thanhTien;
	}
}
