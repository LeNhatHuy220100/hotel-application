package com.hotel.project.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.hotel.project.domain.NhanVien;
import com.hotel.project.repository.NhanVienRepository;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;
@Repository
public class NhanVienRepositoryImpl implements NhanVienRepository{
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public NhanVien add(NhanVien nhanVien) {
		return mongoTemplate.insert(nhanVien);
	}

	/*
	 * tìm kiếm nhân viên theo mã nhân viên
	 */
	@Override
	public NhanVien findByMaNhanVien(String maNhanVien) {
		return mongoTemplate.findOne(new Query(where("maNhanVien").is(maNhanVien)), NhanVien.class);
	}

	/*
	 * xác thực tài khoản
	 */
	
	@SuppressWarnings("static-access")
	@Override
	public NhanVien authenticationByMaNhanVienAndMatKhau(String maNhanVien, String matKhau) {
		NhanVien nhanVien = mongoTemplate.findOne(new Query(where("taiKhoan.taiKhoan").where(maNhanVien)
				.where("taiKhoan.matKhau").is(matKhau)), NhanVien.class);
		return nhanVien;
	}

	/*
	 * tìm kiếm nhân viên theo tên nhân viên
	 */
	@Override
	public List<NhanVien> findByTenNhanVien(String tenNhanVien) {
		//List<NhanVien> nvs= mongoTemplate.find(new Query(where("tenNhanVien").is(tenNhanVien)), NhanVien.class);
		List<NhanVien> nvs= mongoTemplate.find(new Query(where("tenNhanVien").is(tenNhanVien).regex(tenNhanVien)), NhanVien.class);
		
//		Index
//		List<NhanVien> nvs= mongoTemplate.fin
		return nvs;
	}
	
	@Override
	public List<NhanVien> findAllNV() {
		return mongoTemplate.findAll(NhanVien.class);
	}
	@Override
	public void xoaNVTheoMa(String ma) {
		mongoTemplate.remove(new Query(where("maNhanVien").is(ma)), NhanVien.class);

	}
	@Override
	public void updateNV(NhanVien nv) {
		Query query = new Query();
        query.addCriteria(Criteria.where("maNhanVien").is(nv.getMaNhanVien()));
		
		Update update = new Update();
        update.set("tenNhanVien", nv.getTenNhanVien());
        update.set("sdt", nv.getSdt());
        update.set("chucVu", nv.getChucVu());
//        update.set("canCuoc", nv.getCanCuoc());
        update.set("gioiTinh", nv.isGioiTinh());
        update.set("ngaySinh", nv.getNgaySinh());
        update.set("diaChi", nv.getDiaChi());
        update.set("taiKhoan", nv.getTaiKhoan());

		mongoTemplate.findAndModify(query, update, NhanVien.class);
	}
	
	@Override
	public void updateCC(String cc, String ma) {
		Query query = new Query();
        query.addCriteria(Criteria.where("maNhanVien").is(ma));
		
		Update update = new Update();
        update.set("canCuoc", cc);

		mongoTemplate.findAndModify(query, update, NhanVien.class);
	}
	
	@Override
	public NhanVien findBySoCanCuoc(String scc) {
		return mongoTemplate.findOne(new Query(where("canCuoc").is(scc)), NhanVien.class);
	}
	@Override
	public NhanVien findByTK(String tk) {
		return mongoTemplate.findOne(new Query(where("taiKhoan.taiKhoan").is(tk)), NhanVien.class);
	}
}
