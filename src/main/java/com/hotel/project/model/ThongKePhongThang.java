package com.hotel.project.model;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ThongKePhongThang {
	@Id
	private ObjectId maHoaDon;
	private LocalDateTime thoiGianLHD;
	private String maPhong;
	private String loaiPhong;
	private Double giaPhong;
	
	
}
