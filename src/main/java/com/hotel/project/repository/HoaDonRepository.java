package com.hotel.project.repository;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;

import com.hotel.project.domain.ChiTietDichVu;
import com.hotel.project.domain.ChiTietHoaDon;
import com.hotel.project.domain.HoaDon;
import com.hotel.project.domain.KhachHang;

public interface HoaDonRepository {
	//them hoa don
	public HoaDon addHoaDon(HoaDon hoaDon);
	//Loc hoa don theo trang thai
	public List<HoaDon> findAllByTrangThaiThanhToan();
	//Tim hoa don theo the can cuoc, ma phong, trang thai
	public HoaDon findByTheCanCuocAndTrangThaiThanhToanAndMaPhong(
			String theCanCuoc,String maPhong);
	//Update list dich vu
	public HoaDon updateListDichVu(String theCanCuoc, String maPhong, List<ChiTietDichVu> listchiTietDichVu);
	//Update list dich vu
	public HoaDon findByMaHoaDon(HoaDon hd);
	//Update list hoa don
	public HoaDon updateListHoaDon(String theCanCuoc, String maPhong, List<ChiTietHoaDon> listchiTietHoaDon);
	public HoaDon updateListHoaDon1(String theCanCuoc, String maPhong, List<ChiTietHoaDon> listchiTietHoaDon);
	//Update TGNPs
	public HoaDon updateTGNP(String theCanCuoc, String maPhong, LocalDateTime thoiGianNhanPhong);
	public HoaDon updateTGNP1(String theCanCuoc, String maPhong, LocalDateTime thoiGianNhanPhong);
	//Update khach hang
	public HoaDon updateKHHD(String theCanCuoc, KhachHang kh);
	
	//Tu
	public List<HoaDon> findAllByTrangThaiThanhToanVaCC(String scc);
	public void updateKhTrongHD(KhachHang kh, String mhd);
	public void updateCCKhTrongHD(String cc, String mhd);
	public HoaDon findAndUpdateBytheCanCuocAndTrangThaiThanhToan(String theCanCuocToan,LocalDateTime thoiGianTP);
	public HoaDon updateKhachHang(String theCanCuoc, String maPhong,
			KhachHang khachHang,LocalDateTime thoiGianNhanPhong);
	public HoaDon updateDichVu(String theCanCuoc, String maPhong,ChiTietDichVu chiTietDichVu);
	public List<HoaDon> findHoaDonChuaThanhToan();
	public  boolean deleteHoaDon(HoaDon ngayLapHD);
	public HoaDon findHoaDonTheoNgayLap(LocalDate ngayLapHD);
	public List<ChiTietHoaDon> findChiTietHD(String sdt);
	public List<ChiTietDichVu> findChiTietDichVu(String sdt);
	public  List<ChiTietDichVu> tinhTienChiTietDichVu(String tenPhong,LocalDateTime ngayLapHD);
	public HoaDon findHoaDonTheoTheCanCuoc(String theCanCuoc,LocalDate thoiGianThueDau);
	public HoaDon findHoaDonTheoTheCanCuocchi1(String theCanCuoc);
	public HoaDon updateTGTP(String theCanCuoc,LocalDateTime thoiGianNP ,LocalDateTime thoiGianTP);
	public HoaDon updateTrangThai(String theCanCuoc,LocalDateTime thoiGianNP );
	public HoaDon updateTongTien(String theCanCuoc,LocalDateTime thoiGianNP ,double TongTien);
	
	
	
	//------------------- Thống kê doan thu ----------------------------------------------
	
		//Tìm danh sách tất cả các hóa đơn đã thanh toán
		public List<HoaDon> findAllByTrangThaiThanhToanIsTrue();
}
