package com.hotel.project.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hotel.project.domain.KhachHang;
import com.hotel.project.repository.KhachHangRepository;

@Repository
public class KhachHangRepositoryImpl implements KhachHangRepository{
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public KhachHang add(KhachHang khachHang) {
		return mongoTemplate.insert(khachHang);
	}
	
	@Override
	public KhachHang findByTheCanCuoc(String theCanCuoc) {
		return mongoTemplate.findOne(new Query(where("theCanCuoc").is(theCanCuoc)), KhachHang.class);
	}

	@Override
	public List<KhachHang> findAll() {
		return mongoTemplate.findAll(KhachHang.class);
	}
	
	@Override
	public void xoaKhTheoCanCuoc(String scc) {
		mongoTemplate.remove(new Query(where("theCanCuoc").is(scc)), KhachHang.class);

	}
	
	@Override
	public List<KhachHang> findByTenKh(String tenKh) {
		List<KhachHang> Khs= mongoTemplate.find(new Query(where("tenKhachHang").is(tenKh).regex(tenKh)), KhachHang.class);
		return Khs;
	}
	
	@Override
	public void updateKh(KhachHang kh, String maKh) {
		Query query = new Query();
        query.addCriteria(Criteria.where("maKhachHang").is(maKh));
		
		Update update = new Update();
        update.set("tenKhachHang", kh.getTenKhachHang());
        update.set("theCanCuoc", kh.getTheCanCuoc());
        update.set("soDienThoai", kh.getSoDienThoai());
        update.set("loaiKhachHang", kh.isLoaiKhachHang());

		mongoTemplate.findAndModify(query, update, KhachHang.class);
		
	}
	
	@Override
	public void updateCC(String cc, String maKh) {
		Query query = new Query();
        query.addCriteria(Criteria.where("maKhachHang").is(maKh));
		
		Update update = new Update();
        update.set("theCanCuoc", cc);

		mongoTemplate.findAndModify(query, update, KhachHang.class);
		
	}
}
