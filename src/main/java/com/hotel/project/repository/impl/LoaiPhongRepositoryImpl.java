package com.hotel.project.repository.impl;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.hotel.project.domain.LoaiPhong;
import com.hotel.project.repository.LoaiPhongRepository;
@Repository
public class LoaiPhongRepositoryImpl implements LoaiPhongRepository{
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public LoaiPhong add(LoaiPhong loaiPhong) {
		return mongoTemplate.insert(loaiPhong);
	}

	@Override
	public LoaiPhong findLoaiByMaPhong(String maPhong) {
		return mongoTemplate.findOne(new Query(where("phongList.maPhong").is(maPhong)), 
				LoaiPhong.class);
	}
}
