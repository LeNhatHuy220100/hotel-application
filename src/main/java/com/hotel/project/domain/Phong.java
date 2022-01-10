package com.hotel.project.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Phong {
	@Id
	private String maPhong;
	private boolean trangThai;
	private int soGiuong;
	private int soNguoiToiDa;
	private double giaPhong;
	
}
