package com.hotel.project.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("taikhoan")
@Component
public class TaiKhoan {
	private String taiKhoan;
	private String matKhau;
	private boolean loaiTaiKhoan;
}
