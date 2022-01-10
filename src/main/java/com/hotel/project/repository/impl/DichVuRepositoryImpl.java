package com.hotel.project.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import com.hotel.project.domain.DichVu;
import com.hotel.project.repository.DichVuRepository;
import com.mongodb.client.result.DeleteResult;

@Repository
public class DichVuRepositoryImpl implements DichVuRepository{
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public DichVu addDichVu(DichVu dichVu) {
		return mongoTemplate.insert(dichVu);
	}
	@Override
	public DichVu findByMaDichVu(String maDichVu) {
		return mongoTemplate.findOne(new Query(where("maDichVu").is(maDichVu)), DichVu.class);
	}
	@Override
	public List<DichVu> findALL() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(DichVu.class);
	}
	@Override
	public boolean deleteDichVu(DichVu dichVu) {
		// TODO Auto-generated method stub
		boolean result;
		DeleteResult a = mongoTemplate.remove(dichVu);
		if(a.getDeletedCount()>0)
			result=true;
		else
			result = false;
		return result;
	}
	@Override
	public boolean updateDichVu(DichVu dichVu) {
		// TODO Auto-generated method stub
		@SuppressWarnings("static-access")
		Query query=new Query(where("_id").is(dichVu.getMaDichVu()));
		Update update=new Update().set("giaDichVu", dichVu.getGiaDichVu());
		DichVu dichvu = mongoTemplate.update(DichVu.class)
				.matching(query)
				.apply(update)
				.withOptions(FindAndModifyOptions.options().upsert(true).returnNew(true))
				.findAndModifyValue();
		boolean result;
		
		if(dichvu.getMaDichVu().length()>0)
			result=true;
		else
			result = false;
		return result;
	}
	//Tim kiem tuong doi theo ten dich vu
	@Override
	public List<DichVu> findByTenDichVuTuongDoi(String tenDichVu) {
		return mongoTemplate.find(new Query(where("tenDichVu").is(tenDichVu).regex(tenDichVu)), DichVu.class);
	}
	
}
