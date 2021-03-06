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
		
		textArea.append("\n				KH??CH S???N FRESH \n");
		textArea.append("\n		84/20 Hu???nh Kh????ng An , Ph?????ng 5, G?? V???p, Th??nh Ph??? H??? Ch?? Minh \n");
		textArea.append("	---------------------------------------------------------------------\n\n");
		textArea.append("			PHI???U THANH TO??N \n");
		textArea.append("\n			S??? H??a ????n          :" + maHD + "\n");
		textArea.append("			Ng??y L???p H??a ????n    :" +  hd.getThoiGianLHD()+ "\n");
		textArea.append("			Nh??n Vi??n           :" + hd.getNhanVien().getTenNhanVien() + "\n");
		textArea.append("	---------------------------------------------------------------------\n\n");
		textArea.append("			TH??NG TIN KH??CH H??NG \n");
		textArea.append("\n			T??n kh??ch h??ng      :  " + hd.getKhachHang().getTenKhachHang()+ "\n");
		textArea.append("			Ch???ng minh nh??n d??n :  " + hd.getKhachHang().getTheCanCuoc() + "\n");
		textArea.append("			S??? ??i???n tho???i       :  " + hd.getKhachHang().getSoDienThoai() + "\n");
		textArea.append("\n--------------------------------------------------------------------------------------------\n");
		//"   |    T??n xe    |      M??u xe ???   |Ph??n Kh???i|     S??? khung      |  S??? m??y  |   Th??nh ti???n    |\n"
		
		
		DecimalFormat df = new DecimalFormat("#,###,###,### VN??");
		NumberFormat num = NumberFormat.getNumberInstance();
		int tableRowCount  =hd.getListHoaDon().size();
		double TienDichVu=0;
		double TongTienCuaHD=0;
		String tenXe, mauXe, phanKhoi, soKhung, soMay, thanhTien;
		int ngay= hd.getThoiGianTheuCuoi().compareTo(hd.getThoiGianTheuDau());
		List<ChiTietHoaDon> listPhong=hd.getListHoaDon();
		List<ChiTietDichVu> listDichVu= hd.getListDichVu();
		
		for(ChiTietHoaDon cthd : listPhong) {
			textArea.append(String.format("|%-10s|%-20s|%-9s|%-14s|%-14s|%-16s\n", "T??n Ph??ng", "T??n Kh??ch H??ng","Lo???i Ph??ng","Gi?? Ph??ng","Ph??? Thu","Th??nh ti???n"));
			for(ChiTietDichVu ctdv : listDichVu) {
				if(cthd.getMaPhong().equals(ctdv.getPhongDichVu()))
				TienDichVu +=ctdv.tinhThanhTien();
			}
			textArea.append(String.format("|%-10s|%-20s|%-9s|%-15s|%-14s|%-16s\n",cthd.getMaPhong(), cthd.getTenKhachHang(),cthd.getLoaiPhong(),df.format(cthd.getDonGia()),df.format(TienDichVu),df.format(TienDichVu+(cthd.tinhThanhTien()*ngay))));
			textArea.append(String.format("	Th??ng Tin D???ch V??? C???a Ph??ng %-10s\n",cthd.getMaPhong()));
			textArea.append(String.format("|%-30s|%-9s|%-15s|%-15s\n","T??n D???ch V???","S??? L?????ng", "     ????n Gi??      ", "  Ti???n D???ch V???"));
			
			for(ChiTietDichVu ctdv : listDichVu) {
				if(cthd.getMaPhong().equals(ctdv.getPhongDichVu()))
				{
					textArea.append(String.format("|%-30s|%-9d|%-18s|%-15s\n", ctdv.getTenDichVu(), ctdv.getSoLuong(), df.format(ctdv.getGia()), df.format(ctdv.getGia()*ctdv.getSoLuong())));
				}		
			}
			textArea.append("-----------------------------------------------------------------------------------------------\n");
			TienDichVu=0;
		}
		textArea.append(String.format("\n					Ti???n Kh??ch ????a       : %15s" , df.format(TienKhachDua)));
		textArea.append(String.format("\n					Total                : %15s" ,df.format(TongTienHD)));
		textArea.append(String.format("\n					Ti???n Th???a l???i        : %15s" , df.format(TienThua)));
		
		textArea.append("\n 			     		Ng??y xu???t h??a ????n  :  " + LocalDateTime.now() +"\n");
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
