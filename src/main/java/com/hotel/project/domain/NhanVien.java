package com.hotel.project.domain;

import java.time.LocalDate;
import java.util.List;

//import javax.jws.Oneway;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder.ObtainVia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "nhanvien")
public class NhanVien {
	
	@Id
	private String maNhanVien;
	private String tenNhanVien;
	private String sdt;
	private String chucVu;
	private String canCuoc;
	private boolean gioiTinh;
	private LocalDate ngaySinh;
	private String diaChi;
	

	public NhanVien(String maNhanVien, String tenNhanVien, String sdt, String chucVu, String canCuoc, boolean gioiTinh,
			LocalDate ngaySinh, String diaChi) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.sdt = sdt;
		this.chucVu = chucVu;
		this.canCuoc = canCuoc;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
	}

	private TaiKhoan taiKhoan;
	
}
