package com.hotel.project.gui.home.view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotel.project.domain.ChiTietDichVu;
import com.hotel.project.domain.ChiTietHoaDon;
import com.hotel.project.domain.HoaDon;
import com.hotel.project.domain.NhanVien;
import com.hotel.project.domain.Phong;
import com.hotel.project.repository.HoaDonRepository;
import com.hotel.project.repository.impl.HoaDonRepositoryImpl;
import javax.swing.JTextArea;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Bill extends JFrame {

	private JPanel contentPane;
	public static JTextArea textArea;
	public static String maHD;
	public static double TongTienHD;
	public static double TienKhachDua;
	public static double TienThua;
	
	private String maCuaHD ="";
	public static HoaDon hd;
	
	/**
	 * Launch the application.
	 */
//	@Autowired 
//	HoaDonRepository hoaDonRepository;
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Bill frame = new Bill();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	/**
	 * Create the frame.
	 */
	public Bill() {
		
//	}
//	
//	@PostConstruct
//	public void preparePanel() {
//		try {
//			ConnectDB.getInstance().connect();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 11));
		textArea.setBounds(5, 5, 1000, 700);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println(maHD+" hien nek");
		System.out.println("\n"+hd+" hoa Don Day");
		//HoaDon hd = hoaDonRepository.getHoaDonByID("5fc42e82996b5272328b4fda");
		
		textArea.append("\n				KHÁCH SẠN FRESH \n");
		textArea.append("\n		84/20 Huỳnh Khương An , Phường 5, Gò Vấp, Thành Phố Hồ Chí Minh \n");
		textArea.append("	---------------------------------------------------------------------\n\n");
		textArea.append("			PHIẾU THANH TOÁN \n");
		textArea.append("\n			Số Hóa Đơn          :" + maHD + "\n");
		textArea.append("			Ngày Lập Hóa Đơn    :" +  hd.getThoiGianLHD()+ "\n");
		textArea.append("			Nhân Viên           :" + hd.getNhanVien().getTenNhanVien() + "\n");
		textArea.append("	---------------------------------------------------------------------\n\n");
		textArea.append("			THÔNG TIN KHÁCH HÀNG \n");
		textArea.append("\n			Tên khách hàng      :  " + hd.getKhachHang().getTenKhachHang()+ "\n");
		textArea.append("			Chứng minh nhân dân :  " + hd.getKhachHang().getTheCanCuoc() + "\n");
		textArea.append("			Số điện thoại       :  " + hd.getKhachHang().getSoDienThoai() + "\n");
		textArea.append("\n--------------------------------------------------------------------------------------------\n");
		//"   |    Tên xe    |      Màu xe ở   |Phân Khối|     Số khung      |  Số máy  |   Thành tiền    |\n"
		
		
		DecimalFormat df = new DecimalFormat("#,###,###,### VNĐ");
		NumberFormat num = NumberFormat.getNumberInstance();
		int tableRowCount  =hd.getListHoaDon().size();
		double TienDichVu=0;
		double TongTienCuaHD=0;
		String tenXe, mauXe, phanKhoi, soKhung, soMay, thanhTien;
		int ngay= hd.getThoiGianTheuCuoi().compareTo(hd.getThoiGianTheuDau());
		List<ChiTietHoaDon> listPhong=hd.getListHoaDon();
		List<ChiTietDichVu> listDichVu= hd.getListDichVu();
		
		for(ChiTietHoaDon cthd : listPhong) {
			textArea.append(String.format("|%-10s|%-20s|%-9s|%-14s|%-14s|%-16s\n", "Tên Phòng", "Tên Khách Hàng","Loại Phòng","Giá Phòng","Phụ Thu","Thành tiền"));
			for(ChiTietDichVu ctdv : listDichVu) {
				if(cthd.getMaPhong().equals(ctdv.getPhongDichVu()))
				TienDichVu +=ctdv.tinhThanhTien();
			}
			textArea.append(String.format("|%-10s|%-20s|%-9s|%-15s|%-14s|%-16s\n",cthd.getMaPhong(), cthd.getTenKhachHang(),cthd.getLoaiPhong(),df.format(cthd.getDonGia()),df.format(TienDichVu),df.format(TienDichVu+(cthd.tinhThanhTien()*ngay))));
			textArea.append(String.format("	Thông Tin Dịch Vụ Của Phòng %-10s\n",cthd.getMaPhong()));
			textArea.append(String.format("|%-30s|%-9s|%-15s|%-15s\n","Tên Dịch Vụ","Số Lượng", "     Đơn Giá      ", "  Tiền Dịch Vụ"));
			
			for(ChiTietDichVu ctdv : listDichVu) {
				if(cthd.getMaPhong().equals(ctdv.getPhongDichVu()))
				{
					textArea.append(String.format("|%-30s|%-9d|%-18s|%-15s\n", ctdv.getTenDichVu(), ctdv.getSoLuong(), df.format(ctdv.getGia()), df.format(ctdv.getGia()*ctdv.getSoLuong())));
				}		
			}
			textArea.append("-----------------------------------------------------------------------------------------------\n");
			TienDichVu=0;
		}
		textArea.append(String.format("\n					Tiền Khách Đưa       : %15s" , df.format(TienKhachDua)));
		textArea.append(String.format("\n					Total                : %15s" ,df.format(TongTienHD)));
		textArea.append(String.format("\n					Tiền Thừa lại        : %15s" , df.format(TienThua)));
		
		textArea.append("\n 			     		Ngày xuất hóa đơn  :  " + LocalDateTime.now() +"\n");
		contentPane.add(textArea);
	}
//	public void dienthongTTin(String maCuaHD, HoaDon hoadon) {
//		maHD = maCuaHD;
//		this.hd = hoadon;
//		
//	}
	private void setViewportView(JTable table) {
		// TODO Auto-generated method stub
		
	}
}
