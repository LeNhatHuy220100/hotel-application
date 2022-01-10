	package com.hotel.project.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "dichvu")
public class DichVu {
	@Id
	private String maDichVu;
	private	String tenDichVu;
	private double giaDichVu;	
	private String loaiDichVu;
	
}
