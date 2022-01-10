package com.hotel.project.domain;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "loaiphong")
public class LoaiPhong {
	private String tenLoai;
	private String moTa;
	private List<Phong> phongList; 
}
