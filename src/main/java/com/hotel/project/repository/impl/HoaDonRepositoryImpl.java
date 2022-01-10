package com.hotel.project.repository.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.hotel.project.domain.ChiTietDichVu;
import com.hotel.project.domain.ChiTietHoaDon;
import com.hotel.project.domain.DichVu;
import com.hotel.project.domain.HoaDon;
import com.hotel.project.domain.KhachHang;
import com.hotel.project.repository.HoaDonRepository;
import com.mongodb.client.result.DeleteResult;

@Repository
public class HoaDonRepositoryImpl implements HoaDonRepository{
	@Autowired
	MongoTemplate mongoTemplate;
	@Autowired
	KhachHangRepositoryImpl khachhangrepo;
	
	/*
	 * Them hoa don
	 * 
	 */
	@Override
	public HoaDon addHoaDon(HoaDon hoaDon) {
		return mongoTemplate.insert(hoaDon);
	}
	
	/*
	 * Tìm kiếm hóa đơn theo ma hoa don
	 * 
	 */
	@Override
	public HoaDon findByMaHoaDon(HoaDon hd
			) {
		@SuppressWarnings("static-access")
		Query query=new Query(Criteria.where("maHoaDon").is(hd.getMaHoaDon()));
										;	
		 return mongoTemplate.findOne(query, HoaDon.class);
	}
	
	
	/*
	 * Tìm kiếm hóa đơn theo thẻ căn cước, trạng thái thanh toán, mã phòng
	 * 
	 */
	@Override
	public HoaDon findByTheCanCuocAndTrangThaiThanhToanAndMaPhong(String theCanCuoc, String maPhong
			) {
		
		@SuppressWarnings("static-access")
		Query query=new Query(Criteria.where("khachHang.theCanCuoc").is(theCanCuoc).
										and("listHoaDon.maPhong").is(maPhong).
										and("trangThaiThanhToan").is(false));	
		 return mongoTemplate.findOne(query, HoaDon.class);
	}
	
	/*
	 * Chức năng cập nhật danh sach dich vu phòng
	 */
	@Override
	public HoaDon updateListDichVu(String theCanCuoc, String maPhong, List<ChiTietDichVu> listchiTietDichVu) {
		
		@SuppressWarnings("static-access")
		Query query=new Query(Criteria.where("khachHang.theCanCuoc").is(theCanCuoc).
				and("listHoaDon.maPhong").is(maPhong).
				and("trangThaiThanhToan").is(false));	
		Update update=new Update().set("listDichVu", listchiTietDichVu);
		HoaDon hoaDon = mongoTemplate.update(HoaDon.class)
			.matching(query)
			.apply(update)
			.withOptions(FindAndModifyOptions.options().upsert(true).returnNew(true))
			.findAndModifyValue();
		return hoaDon;
	}
	
	
	/*
	 * Chức năng cập nhật danh sach chi tiet hoa don
	 */
	@Override
	public HoaDon updateListHoaDon(String theCanCuoc, String maPhong, List<ChiTietHoaDon> listchiTietHoaDon) {
		@SuppressWarnings("static-access")
		Query query=new Query(Criteria.where("khachHang.theCanCuoc").is(theCanCuoc).
				and("listHoaDon.maPhong").is(maPhong).
				and("trangThaiThanhToan").is(false));	
		Update update=new Update().set("listHoaDon", listchiTietHoaDon);
		HoaDon hoaDon = mongoTemplate.update(HoaDon.class)
			.matching(query)
			.apply(update)
			.withOptions(FindAndModifyOptions.options().upsert(true).returnNew(true))
			.findAndModifyValue();
		return hoaDon;
	}
	@Override
	public HoaDon updateListHoaDon1(String theCanCuoc, String maPhong, List<ChiTietHoaDon> listchiTietHoaDon) {
		
		@SuppressWarnings("static-access")
		Query query=new Query(Criteria.where("khachHang.theCanCuoc").is(theCanCuoc).
				and("listHoaDon.maPhong").is(maPhong).
				and("trangThaiThanhToan").is(false));	
		Update update=new Update().set("listHoaDon", listchiTietHoaDon);
		HoaDon hoaDon = mongoTemplate.update(HoaDon.class)
			.matching(query)
			.apply(update)
			.withOptions(FindAndModifyOptions.options().upsert(true).returnNew(true))
			.findAndModifyValue();
		return hoaDon;
	}
	
	
	/*
	 * Chức năng cập nhật thoi gian nhan phong
	 */
	@Override
	public HoaDon updateTGNP(String theCanCuoc, String maPhong, LocalDateTime thoiGianNhanPhong) {
		KhachHang khachHang = khachhangrepo.findByTheCanCuoc(theCanCuoc);
		@SuppressWarnings("static-access")
		Query query=new Query(Criteria.where("khachHang").is(khachHang).
				and("listHoaDon.maPhong").is(maPhong).
				and("trangThaiThanhToan").is(false));	
		Update update=new Update().set("thoiGianNP", thoiGianNhanPhong);
		HoaDon hoaDon = mongoTemplate.update(HoaDon.class)
			.matching(query)
			.apply(update)
			.withOptions(FindAndModifyOptions.options().upsert(true).returnNew(true))
			.findAndModifyValue();
		return hoaDon;
	}
	@Override
	public HoaDon updateTGNP1(String theCanCuoc, String maPhong, LocalDateTime thoiGianNhanPhong) {
		
		@SuppressWarnings("static-access")
		Query query=new Query(Criteria.where("khachHang.theCanCuoc").is(theCanCuoc).
				and("listHoaDon.maPhong").is(maPhong).
				and("trangThaiThanhToan").is(false));	
		Update update=new Update().set("thoiGianNP", thoiGianNhanPhong);
		HoaDon hoaDon = mongoTemplate.update(HoaDon.class)
			.matching(query)
			.apply(update)
			.withOptions(FindAndModifyOptions.options().upsert(true).returnNew(true))
			.findAndModifyValue();
		return hoaDon;
	}
	
	/*
	 * Hiển thị tất cả các hóa đơn chưa thanh toán
	 */
	@Override
	public List<HoaDon> findAllByTrangThaiThanhToan() {
		return mongoTemplate.find(new Query(Criteria.where("trangThaiThanhToan").is(false)), HoaDon.class);
	}
	
	/*
	 * Update khach Hang
	 */
	@Override
	public HoaDon updateKHHD(String theCanCuoc, KhachHang kh) {
		KhachHang khachHang = khachhangrepo.findByTheCanCuoc(theCanCuoc);
		@SuppressWarnings("static-access")
		Query query=new Query(Criteria.where("khachHang").is(khachHang).
				and("trangThaiThanhToan").is(false));	
		Update update=new Update().set("khachHang.$.theCanCuoc", kh.getTheCanCuoc())
									.set("khachHang.$.tenKhachHang", kh.getTenKhachHang())
									.set("khachHang.$.soDienThoai", kh.getSoDienThoai())
									.set("khachHang.$.loaiKhachHang", kh.isLoaiKhachHang());
		HoaDon hoaDon = mongoTemplate.update(HoaDon.class)
			.matching(query)
			.apply(update)
			.withOptions(FindAndModifyOptions.options().upsert(true).returnNew(true))
			.findAndModifyValue();
		return hoaDon;
	}
	
	
	
	//Tu
	@Override
	public List<HoaDon> findAllByTrangThaiThanhToanVaCC(String scc) {
		return mongoTemplate.find(new Query(Criteria.where("trangThaiThanhToan").is(false).and("khachHang.theCanCuoc").is(scc)), HoaDon.class);
	}
	
	@Override
	public void updateKhTrongHD(KhachHang kh, String mhd) {
		Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(mhd));
		
		Update update = new Update();
        update.set("khachHang", kh);

		mongoTemplate.findAndModify(query, update, HoaDon.class);
		
	}
	
	@Override
	public void updateCCKhTrongHD(String cc, String mhd) {
		Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(mhd));
		
		Update update = new Update();
        update.set("khachHang.theCanCuoc", cc);

		mongoTemplate.findAndModify(query, update, HoaDon.class);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * tìm kiếm hóa đơn để thanh toán 
	 * tham số: số thẻ căn cước của khách hàng đại
	 * diện và trạng thái thanh toán là chưa thanh toán
	 */
	@Override
	public HoaDon findAndUpdateBytheCanCuocAndTrangThaiThanhToan(String theCanCuocToan,LocalDateTime thoiGianTP) {
		Query query=new Query(Criteria.where("trangThaiThanhToan").is(false).and("theCanCuoc").is(theCanCuocToan));
		Update update=new Update().set("thoiGianTP", thoiGianTP);
		HoaDon hoaDon=mongoTemplate.update(HoaDon.class)
		.matching(query)
		.apply(update)
		.findAndModifyValue();
		return hoaDon;
	}

	/*
	 * Chức năng nhận phòng
	 * Thêm khách hàng vào hóa đơn theo thẻ căn cước, trạng thái thanh toán, mã phòng
	 * Cập nhật thời gian nhận phòng
	 */
	@Override
	public HoaDon updateKhachHang(String theCanCuoc, String maPhong
			,KhachHang khachHang,LocalDateTime thoiGianNhanPhong) {
		@SuppressWarnings("static-access")
		Query query=new Query(Criteria.where("listKhachHang.theCanCuoc").is(theCanCuoc).
				where("listHoaDon.maPhong").is(maPhong).
				where("trangThaiThanhToan").is(false)
				.where("listHoaDon.maPhong").is(maPhong)
				);	
		Update update=new Update()
								.set("thoiGianNP", thoiGianNhanPhong)
								.set("listHoaDon.$.theCanCuoc", khachHang.getTheCanCuoc())
								.set("listHoaDon.$.tenKhachHang", khachHang.getTenKhachHang())
								.set("listHoaDon.$.soDienThoai",khachHang.getSoDienThoai());
		HoaDon hoaDon = mongoTemplate.update(HoaDon.class)
			.matching(query)
			.apply(update)
			.withOptions(FindAndModifyOptions.options().upsert(true).returnNew(true))
			.findAndModifyValue();
		return hoaDon;
	}

	/*
	 * Chức năng cập nhật phòng(thêm dịch vụ vào phòng)
	 */
	
	@Override
	public HoaDon updateDichVu(String theCanCuoc, String maPhong, ChiTietDichVu chiTietDichVu) {
		@SuppressWarnings("static-access")
		Query query=new Query(Criteria.where("listKhachHang.theCanCuoc").is(theCanCuoc).
				where("listHoaDon.maPhong").is(maPhong).
				where("trangThaiThanhToan").is(false));	
		Update update=new Update().addToSet("listDichVu", chiTietDichVu);
		HoaDon hoaDon = mongoTemplate.update(HoaDon.class)
			.matching(query)
			.apply(update)
			.withOptions(FindAndModifyOptions.options().upsert(true).returnNew(true))
			.findAndModifyValue();
		return hoaDon;
	}
	@Override
	public List<HoaDon> findHoaDonChuaThanhToan() {
		// TODO Auto-generated method stub
		@SuppressWarnings("static-access")
		Query query=new Query(Criteria.where("listHoaDon.trangThaiThanhToan").is(false));	
		 return mongoTemplate.find(query, HoaDon.class);
	}

	@Override
	public boolean deleteHoaDon(HoaDon hoaDon) {
		// TODO Auto-generated method stub
				boolean result;
				DeleteResult a = mongoTemplate.remove(hoaDon);
				if(a.getDeletedCount()>0)
					result=true;
				else
					result = false;
				return result;
	}

	@Override
	public HoaDon findHoaDonTheoNgayLap(LocalDate ngayLapHD) {
		return mongoTemplate.findOne(new Query(Criteria.where("thoiGianTheuDau").is(ngayLapHD)), HoaDon.class);
	}

	@Override
	public List<ChiTietHoaDon> findChiTietHD(String sdt) {
		HoaDon a= mongoTemplate.findOne(new Query(Criteria.where("khachHang.soDienThoai").is(sdt).and("trangThaiThanhToan").is(false)), HoaDon.class);
		if(a==null)
			return null;
		else
			return a.getListHoaDon();
	}

	@Override
	public List<ChiTietDichVu> findChiTietDichVu(String sdt) {
		HoaDon a= mongoTemplate.findOne(new Query(Criteria.where("listHoaDon.maPhong").is(sdt).and("trangThaiThanhToan").is(false)), HoaDon.class);
		if(a==null)
			return null;
		else
			return a.getListDichVu();
	}

	@Override
	public List<ChiTietDichVu> tinhTienChiTietDichVu(String tenPhong,LocalDateTime ngayLapHD) {
		// TODO Auto-generated method stub
		List<ChiTietDichVu> a;
		Query query = new Query(); 
		query.addCriteria(Criteria.where("thoiGianLHD").is(ngayLapHD).where("listHoaDon.maPhong").is(tenPhong));
		HoaDon list =  mongoTemplate.findOne(query, HoaDon.class);
		if(list==null)
			return null;
		else
			return list.getListDichVu();
	}

	@Override
	public HoaDon findHoaDonTheoTheCanCuoc(String theCanCuoc, LocalDate thoiGianThueDau) {
		HoaDon a= mongoTemplate.findOne(new Query(Criteria.where("khachHang.theCanCuoc").is(theCanCuoc).and("thoiGianTheuDau").is(thoiGianThueDau).and("trangThaiThanhToan").is(false)), HoaDon.class);
		if(a==null)
			return null;
		else
			return a;
	}

	@Override
	public HoaDon findHoaDonTheoTheCanCuocchi1(String theCanCuoc) {
		HoaDon a= mongoTemplate.findOne(new Query(Criteria.where("khachHang.theCanCuoc").is(theCanCuoc).and("trangThaiThanhToan").is(false)), HoaDon.class);
		if(a==null)
			return null;
		else
			return a;
	}

	@Override
	public HoaDon updateTGTP(String theCanCuoc,LocalDateTime thoiGianNP ,LocalDateTime thoiGianTP) {
		// TODO Auto-generated method stub
		Query query=new Query(Criteria.where("khachHang.theCanCuoc").is(theCanCuoc).
				and("thoiGianLHD").is(thoiGianNP).
				and("trangThaiThanhToan").is(false));	
		Update update=new Update().set("thoiGianTP", thoiGianTP);
		HoaDon hoaDon = mongoTemplate.update(HoaDon.class)
				.matching(query)
				.apply(update)
				.withOptions(FindAndModifyOptions.options().upsert(true).returnNew(true))
				.findAndModifyValue();
			return hoaDon;
	}

	@Override
	public HoaDon updateTrangThai(String theCanCuoc, LocalDateTime thoiGianNP) {
		Query query=new Query(Criteria.where("khachHang.theCanCuoc").is(theCanCuoc).
				and("thoiGianLHD").is(thoiGianNP).
				and("trangThaiThanhToan").is(false));	
		Update update=new Update().set("trangThaiThanhToan", true);
		HoaDon hoaDon = mongoTemplate.update(HoaDon.class)
				.matching(query)
				.apply(update)
				.withOptions(FindAndModifyOptions.options().upsert(true).returnNew(true))
				.findAndModifyValue();
			return hoaDon;
	}

	@Override
	public HoaDon updateTongTien(String theCanCuoc, LocalDateTime thoiGianNP, double TongTien) {
		Query query=new Query(Criteria.where("khachHang.theCanCuoc").is(theCanCuoc).
				and("thoiGianLHD").is(thoiGianNP).
				and("trangThaiThanhToan").is(false));	
		Update update=new Update().set("thanhTien", TongTien);
		HoaDon hoaDon = mongoTemplate.update(HoaDon.class)
				.matching(query)
				.apply(update)
				.withOptions(FindAndModifyOptions.options().upsert(true).returnNew(true))
				.findAndModifyValue();
			return hoaDon;
	}
	
	
//	------------------------------Xử lý thống kê---------------------------------
	@Override
	public List<HoaDon> findAllByTrangThaiThanhToanIsTrue() {
		return mongoTemplate.find(new Query(
				Criteria.where("trangThaiThanhToan").is(true)), HoaDon.class);
	}
	
}
