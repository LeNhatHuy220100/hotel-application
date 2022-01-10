package com.hotel.project.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.hotel.project.domain.LoaiPhong;
import com.hotel.project.domain.Phong;
import com.hotel.project.repository.PhongRepository;
import com.mongodb.client.model.Aggregates;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

import java.util.List;
@SuppressWarnings("unused")
@Repository
public class PhongRepositoryImpl implements PhongRepository{
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public Phong add(Phong phong) {
		return mongoTemplate.insert(phong);
	}
	
	@Override
	public Phong findByMaPhong(String maPhong) {
		return mongoTemplate.findOne(
				new Query(where("maPhong").is(maPhong)),
				Phong.class);
	}

	@Override
	public List<Phong> findAll() {
		return mongoTemplate.findAll(Phong.class);
	}

	@Override
	public List<Phong> findAllByTenLoai(String tenLoai) {
		Aggregation aggregate = newAggregation(
				match(Criteria.where("tenLoai").is(tenLoai)),
				unwind("phongList"),
				replaceRoot("phongList")
				);
		
		AggregationResults<Phong> aggregate2 = mongoTemplate.aggregate(aggregate,"loaiphong", Phong.class);
		return aggregate2.getMappedResults();
	}
	
	//Update phong
		@Override
		public Phong updatePhong(Phong p, String loai, boolean tt) {
			@SuppressWarnings("static-access")
			Query query=new Query(Criteria.where("_id").is(p.getMaPhong()));	
			Update update=new Update()
									.set("soGiuong", p.getSoGiuong())
									.set("soNguoiToiDa", p.getSoNguoiToiDa())
									.set("giaPhong", p.getGiaPhong())
									.set("trangThai", tt);
			Phong pp = mongoTemplate.update(Phong.class)
				.matching(query)
				.apply(update)
				.withOptions(FindAndModifyOptions.options().upsert(true).returnNew(true))
				.findAndModifyValue();
			
			@SuppressWarnings("static-access")
			Query query1=new Query(Criteria.where("tenLoai").is(loai).where("phongList._id").is(p.getMaPhong()));	
			Update update1=new Update()
									.set("phongList.$.soGiuong", p.getSoGiuong())
									.set("phongList.$.soNguoiToiDa", p.getSoNguoiToiDa())
									.set("phongList.$.giaPhong", p.getGiaPhong())
									.set("phongList.$.trangThai", tt);
			LoaiPhong lp = mongoTemplate.update(LoaiPhong.class)
				.matching(query1)
				.apply(update1)
				.withOptions(FindAndModifyOptions.options().upsert(true).returnNew(true))
				.findAndModifyValue();
			
			if(lp == null || pp == null) {
				return null;
			}
			
			return pp;
		}
}
