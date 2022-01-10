package com.hotel.project.gui.home.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.Printable;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotel.project.domain.ChiTietDichVu;
import com.hotel.project.domain.ChiTietHoaDon;
import com.hotel.project.domain.DichVu;
import com.hotel.project.domain.HoaDon;
import com.hotel.project.domain.KhachHang;
import com.hotel.project.repository.HoaDonRepository;


import com.hotel.project.gui.home.view.QLThanhToanGUI;
import java.awt.Panel;
import javax.swing.JTextField;
import java.awt.Button;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

@Component
public class HoaDonGUI extends JFrame {
	
		private  String Ngayjdo ;
		private JTable tableDichVu;
		private JTable tablePhong;
		private JTextField txtTen;
		private JTextField txtSDT;
		private JTextField txtCMND;
		private JTextField txtNhanPhong;
		private JTextField txtTheCanCuoc;
		private JTextField txtTienPhong;
		private JTextField txtTongTien;
		private JPanel contentPane;
		private DefaultTableModel modelDichVu;
		private DefaultTableModel modelPhong;
		private String theCanCuoc ="", thoiGianThueDau="";
		private JLabel lblTieuDe;
		private double TienTongHD;
		static DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		private DecimalFormat df = new DecimalFormat("#,###,###,### VNĐ");
		
		@Autowired
		private TraTienGui traTienGUI;
//		@Autowired
//		private QLThanhToanGUI qLThanhToanGUI;
		
		
		
		public JTable getTablePhong() {
			return tablePhong;
		}

		public void setTablePhong(JTable tablePhong) {
			this.tablePhong = tablePhong;
		}
		

		public JLabel getLblTieuDe() {
			return lblTieuDe;
		}

		public void setLblTieuDe(JLabel lblTieuDe) {
			this.lblTieuDe = lblTieuDe;
		}

		
		@Autowired
		private HoaDonRepository hoaDonRepository;
		private List<ChiTietDichVu> listDichVu;
		private List<ChiTietDichVu> listDichVuso2;
		
		
		
		
		private double TongTienHD;
	
		private JTextField txtNgayLapHD;
		private HoaDon hd_hienthi;
		
		/**
		 * Create the panel.
		 */
		public HoaDonGUI() {
			getContentPane().setBackground(Color.WHITE);
			
}
		
		@PostConstruct
		public void preparePanel() {
		
		
			setBounds(359, 0, 1543, 1008);
			
			JLabel lblDichVu = new JLabel("HOÁ ĐƠN");
			lblDichVu.setBackground(Color.WHITE);
			lblDichVu.setForeground(new Color(255, 69, 0));
			lblDichVu.setFont(new Font("Times New Roman", Font.BOLD, 30));
			lblDichVu.setHorizontalAlignment(SwingConstants.CENTER);
			getContentPane().add(lblDichVu, BorderLayout.NORTH);
			
			JPanel panel = new JPanel();
			panel.setBorder(null);
			panel.setBackground(Color.WHITE);
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JButton btnNewButton = new JButton("Thanh Toán");
			btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnNewButton.setBounds(1292, 849, 159, 42);
			panel.add(btnNewButton);
			
			
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(Color.WHITE);
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng Tin Ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
			panel_2.setBounds(49, 271, 678, 561);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(12, 32, 654, 431);
			panel_2.add(scrollPane_1);
			
			modelPhong = new DefaultTableModel(
					new String[] {
							"STT", "Mã Phòng", "Khách Hàng","Thời Gian Ở", "Đớn Giá", "Thành Tiền"
					}, 0){
			    public boolean isCellEditable(int row, int column)
			    {
			      return false;//This causes all cells to be not editable
			    }
			  };
			tablePhong = new JTable();
			tablePhong.setFont(new Font("Tahoma", Font.PLAIN, 18));
			tablePhong.setModel(modelPhong);
			scrollPane_1.setViewportView(tablePhong);
			tablePhong.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
			tablePhong.getTableHeader().setOpaque(false);
			tablePhong.getTableHeader().setBackground(new Color(32,136,203));
			tablePhong.getTableHeader().setForeground(new Color(255,255,255));
			tablePhong.getTableHeader().setPreferredSize(new Dimension(scrollPane_1.getWidth(), 40));
			tablePhong.setRowHeight(40);
			tablePhong.setSelectionBackground(new Color(232,57,95));
			tablePhong.setSelectionForeground(new Color(255,255,255));
			tablePhong.setBackground(new Color(255,255,255));
			
			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(Color.WHITE);
			panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng Tin D\u1ECBch V\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
			panel_3.setBounds(739, 271, 712, 561);
			panel.add(panel_3);
			panel_3.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 35, 688, 431);
			panel_3.add(scrollPane);
			
			modelDichVu = new DefaultTableModel(
					new String[] {
							"STT", "Phòng", "Tên Dịch Vụ","Số Lượng", "Đớn Giá", "Thành Tiền"
					}, 0){
			    public boolean isCellEditable(int row, int column)
			    {
			      return false;//This causes all cells to be not editable
			    }
			  };
			tableDichVu = new JTable();
			tableDichVu.setFont(new Font("Tahoma", Font.PLAIN, 18));
			tableDichVu.setModel(modelDichVu);
			scrollPane.setViewportView(tableDichVu);
			tableDichVu.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
			tableDichVu.getTableHeader().setOpaque(false);
			tableDichVu.getTableHeader().setBackground(new Color(32,136,203));
			tableDichVu.getTableHeader().setForeground(new Color(255,255,255));
			tableDichVu.getTableHeader().setPreferredSize(new Dimension(scrollPane.getWidth(), 40));
			tableDichVu.setRowHeight(40);
			tableDichVu.setSelectionBackground(new Color(232,57,95));
			tableDichVu.setSelectionForeground(new Color(255,255,255));
			tableDichVu.setBackground(new Color(255,255,255));
			
			
			Panel panel_1_6 = new Panel();
			panel_1_6.setBounds(247, 495, 455, 39);
			panel_3.add(panel_1_6);
			panel_1_6.setLayout(new BorderLayout(0, 0));
			
			JLabel lblNewLabel_1_2 = new JLabel("Tổng tiền Dịch Vụ  ");
			lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
			panel_1_6.add(lblNewLabel_1_2, BorderLayout.WEST);
			
			txtTienPhong = new JTextField();
			txtTienPhong.setBackground(Color.WHITE);
			txtTienPhong.setColumns(10);
			txtTienPhong.setEditable(false);
			panel_1_6.add(txtTienPhong, BorderLayout.CENTER);
			txtTienPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			
			JPanel panel_4 = new JPanel();
			panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin \u0111\u1EB7t ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
			panel_4.setBackground(Color.WHITE);
			panel_4.setBounds(49, 25, 1402, 233);
			panel.add(panel_4);
			panel_4.setLayout(null);
			
			Panel panel_1 = new Panel();
			panel_1.setBounds(86, 94, 536, 42);
			panel_4.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			txtTen = new JTextField();
			txtTen.setBackground(Color.WHITE);
			panel_1.add(txtTen, BorderLayout.CENTER);
			txtTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtTen.setColumns(10);
			txtTen.setEditable(false);
			
			
			JLabel lblNewLabel = new JLabel("Tên khách hàng ");
			panel_1.add(lblNewLabel, BorderLayout.WEST);
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
			
			Panel panel_1_2 = new Panel();
			panel_1_2.setBounds(86, 32, 536, 42);
			panel_4.add(panel_1_2);
			panel_1_2.setLayout(new BorderLayout(0, 0));
			
			txtCMND = new JTextField();
			txtCMND.setBackground(Color.WHITE);
			panel_1_2.add(txtCMND, BorderLayout.CENTER);
			txtCMND.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtCMND.setColumns(10);
			txtCMND.setEditable(false);
			
			JLabel lblSLng = new JLabel("Số CMND          ");
			panel_1_2.add(lblSLng, BorderLayout.WEST);
			lblSLng.setFont(new Font("Times New Roman", Font.BOLD, 20));
			
			Panel panel_1_3 = new Panel();
			panel_1_3.setBounds(86, 152, 536, 42);
			panel_4.add(panel_1_3);
			panel_1_3.setLayout(new BorderLayout(0, 0));
			
			JLabel lblnGi = new JLabel("Số điện thoại      ");
			panel_1_3.add(lblnGi, BorderLayout.WEST);
			lblnGi.setFont(new Font("Times New Roman", Font.BOLD, 20));
			
			txtSDT = new JTextField();
			txtSDT.setBackground(Color.WHITE);
			panel_1_3.add(txtSDT, BorderLayout.CENTER);
			txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtSDT.setColumns(10);
			txtSDT.setEditable(false);
			
			Panel panel_1_1_1 = new Panel();
			panel_1_1_1.setBounds(803, 32, 507, 42);
			panel_4.add(panel_1_1_1);
			panel_1_1_1.setLayout(new BorderLayout(0, 0));
			
			JLabel lblNewLabel_1_1_1 = new JLabel("Thời Gian Nhận Phòng ");
			lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
			panel_1_1_1.add(lblNewLabel_1_1_1, BorderLayout.WEST);
			
			Panel panel_1_1_1_1 = new Panel();
			panel_1_1_1.add(panel_1_1_1_1, BorderLayout.SOUTH);
			panel_1_1_1_1.setLayout(new BorderLayout(0, 0));
			
			txtNhanPhong = new JTextField();
			txtNhanPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtNhanPhong.setBackground(Color.WHITE);
			panel_1_1_1.add(txtNhanPhong, BorderLayout.CENTER);
			txtNhanPhong.setColumns(10);
			txtNhanPhong.setEditable(false);
			
			Panel panel_1_2_1 = new Panel();
			panel_1_2_1.setBounds(803, 94, 507, 42);
			panel_4.add(panel_1_2_1);
			panel_1_2_1.setLayout(new BorderLayout(0, 0));
			
			JLabel lblNewLabel_1_1_1_1 = new JLabel("Ngày lập hoá đơn          ");
			lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
			panel_1_2_1.add(lblNewLabel_1_1_1_1, BorderLayout.WEST);
			
			txtNgayLapHD = new JTextField();
			txtNgayLapHD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtNgayLapHD.setBackground(Color.WHITE);
			txtNgayLapHD.setText((String) null);
			txtNgayLapHD.setEditable(false);
			txtNgayLapHD.setColumns(10);
			panel_1_2_1.add(txtNgayLapHD, BorderLayout.CENTER);
			
		
			
			Panel panel_1_2_1_2 = new Panel();
			panel_1_2_1_2.setBounds(825, 849, 435, 42);
			panel.add(panel_1_2_1_2);
			panel_1_2_1_2.setLayout(new BorderLayout(0, 0));
			
			JLabel lblNewLabel_1_2_2 = new JLabel("Thành Tiền  ");
			lblNewLabel_1_2_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
			panel_1_2_1_2.add(lblNewLabel_1_2_2, BorderLayout.WEST);
			
			txtTongTien = new JTextField();
			txtTongTien.setBackground(Color.WHITE);
			txtTongTien.setColumns(10);
			panel_1_2_1_2.add(txtTongTien, BorderLayout.CENTER);
			txtTongTien.setEditable(false);
			txtTongTien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			
//			String str = "2020-11-29T17:23:35.110+00:00"; 
//			LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
//			//listPhong = hoaDonRepository.findChiTietHD(dateTime);
//			System.out.println(dateTime);
//			listPhong = hoaDonRepository.findChiTietHD("0893478340");
			//System.out.println("AAAA   "+zxx +"   AAAAA");
			
//			docDLVaoBangPhong(listPhong);
//			tablePhong.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					r = tablePhong.getSelectedRow();
//					String maphong = modelPhong.getValueAt(r, 1).toString();
//					 if(tablePhong.getSelectedRow()>=0) {
//					xxx= tablePhong.getSelectedRow();
//					listDichVu = hoaDonRepository.findChiTietDichVu(maphong);
//					
//					docDLVaoBangDichVu(listDichVu);
//					 }
//				}
//			});
			
			
			
			
			tablePhong.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					int row = tablePhong.getSelectedRow();
					String maphong =(modelPhong.getValueAt(row, 1).toString());
					//txtCMND.setText(modelPhong.getValueAt(row, 2).toString());
					listDichVu = hoaDonRepository.findChiTietDichVu(maphong);
					
					double tienphong =Double.parseDouble((modelPhong.getValueAt(row, 5)).toString());
					double giaphong =Double.parseDouble((modelPhong.getValueAt(row, 4)).toString());
					double songay =Double.parseDouble((modelPhong.getValueAt(row, 3)).toString());
					txtTienPhong.setText(String.valueOf(df.format(tienphong-(giaphong*songay))));
					docDLVaoBangDichVu(listDichVu,maphong);
					listDichVu.removeAll(listDichVu);
					
				}
			});
			btnNewButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println(" zzzz"+hd_hienthi+" zzzz");
					DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
					LocalDateTime localDate = LocalDateTime.parse(txtNgayLapHD.getText(), formatter);
					System.out.println("\n AAAAA "+localDate+" BBBBBB");
					
					String ma=hd_hienthi.getMaHoaDon().toString();
					//bill=new Bill("5fc42e82996b5272328b4fda");
					
					//Bill.maHD = "Bill.maHD = hd_hienthi.getMaHoaDon().toString();";
					//bill.dienthongTTin(hd_hienthi.getMaHoaDon().toString(),hd_hienthi);
					//Bill.maHD=hd_hienthi.getMaHoaDon().toString();
					traTienGUI.dienThongTinTraTien(TienTongHD,hd_hienthi);	
					traTienGUI.setVisible(true);
					
					
					
//					String cmds[] = new String[] {"cmd", "/c", "D:\\a.pdf"};
//					try {
//					    Runtime.getRuntime().exec(cmds);
//					}catch (Exception e1) {
//						// TODO: handle exception
//				}
				}
			});
			
		}
		
		
		
		public void dienThongtin(String theCanCuoc,LocalDate thoiGianThueDau) {
			resetPhong();
			 hd_hienthi =  hoaDonRepository.findHoaDonTheoTheCanCuoc( theCanCuoc, thoiGianThueDau) ;
					//findByTCCMaPhongTT(theCanCuoc, thoiGianThueDau);
					txtCMND.setText(hd_hienthi.getKhachHang().getTheCanCuoc());
					txtNhanPhong.setText(hd_hienthi.getThoiGianNP().toString());
					txtSDT.setText(hd_hienthi.getKhachHang().getSoDienThoai().toString());
					txtTen.setText(hd_hienthi.getKhachHang().getTenKhachHang());
					txtNgayLapHD.setText(hd_hienthi.getThoiGianLHD().toString());
					int ngay= hd_hienthi.getThoiGianTheuCuoi().compareTo(hd_hienthi.getThoiGianTheuDau());
					double tienPhong = 0 ;
					int i =1;
					for(ChiTietHoaDon h :hd_hienthi.getListHoaDon()) {
						List<ChiTietDichVu> listdichvu = hoaDonRepository.findChiTietDichVu(h.getMaPhong());
								for(ChiTietDichVu p :listdichvu) {
									if(h.getMaPhong().equals(p.getPhongDichVu()))
									tienPhong += p.tinhThanhTien();				
						}
								modelPhong.addRow(new Object[] {
									i, h.getMaPhong(),h.getTenKhachHang(),ngay, h.getDonGia(),tienPhong+(h.getGiaPhong()*ngay)
							});						
						TongTienHD+=tienPhong+(h.getGiaPhong()*ngay);
						i++;
						tienPhong=0;
					}
					TongTienHD= TongTienHD*1.1;
//					modelDichVu.addRow(new Object[] {
//							1, 0,0,0,0,0
//					});	
					TienTongHD=TongTienHD;
					txtTongTien.setText(String.valueOf(df.format(TongTienHD)));
					TongTienHD=0;
					//tableDichVu.setModel(modelDichVu);
					
					resetDichVu();
					tablePhong.setModel(modelPhong);
					
					
					
		}
		
//		public void docDLVaoBangPhong(List<ChiTietHoaDon> list) {
//			//int soNgay = qLThanhToanGUI.truyenSoNgay();
//			
////			String str = qLThanhToanGUI.truyenNgay(); 
////			LocalDate dateTime = LocalDate.parse(str, formatter);
//			double tienPhong = 0 ;
//			int i =1;
//			resetPhong();
//			for(ChiTietHoaDon h :list) {
//				List<ChiTietDichVu> listdichvu = hoaDonRepository.findChiTietDichVu(h.getMaPhong());
//						for(ChiTietDichVu p :listdichvu) {
//							if(h.getMaPhong().equals(p.getPhongDichVu()))
//							tienPhong += p.tinhThanhTien();				
//				}
//						modelPhong.addRow(new Object[] {
//							i, h.getMaPhong(),h.getTenKhachHang(),h.laySoNgayO(), h.getDonGia(),tienPhong+h.tinhThanhTien()
//					});						
//				TongTienHD+=tienPhong+h.tinhThanhTien();
//				i++;
//			}
//			modelDichVu.addRow(new Object[] {
//					1, 0,0,0,0,0
//			});	
//			tableDichVu.setModel(modelDichVu);
//			tablePhong.setModel(modelPhong);
//			
//		}
		public void docDLVaoBangDichVu(List<ChiTietDichVu> list,String maPhong) {
			resetDichVu();
			int i =1;
			for(ChiTietDichVu h :list) {
				if(h.getPhongDichVu().equals(maPhong))
						modelDichVu.addRow(new Object[] {
							i, h.getPhongDichVu(),h.getTenDichVu(),h.getSoLuong(),h.getGia(),h.tinhThanhTien()
					});	
				i++;
			}
			System.out.println(" 22 22 ");
			tableDichVu.setModel(modelDichVu);
			//int row1 = tableDichVu.getSelectedRow();
			//double maphong1 =(modelPhong.getValueAt(row, 5));
			
			System.out.println("  bbb"+ list+ " aaaa");
		}
		
		public  void resetPhong()
		{
			modelPhong.setRowCount(0);
		}
		
		public  void resetDichVu()
		{
			modelDichVu.setRowCount(0);
		}
		
		public  void XoaHetDuLieuTrenTableModelso2(List<ChiTietDichVu> list)
		{
			DefaultTableModel dm =(DefaultTableModel) modelDichVu;
			dm.getDataVector().removeAllElements();
			list.removeAll(list);
		}
		public  void XoaHetDuLieuTrenTableModel()
		{
			DefaultTableModel dm =(DefaultTableModel) modelDichVu;
			dm.getDataVector().removeAllElements();
			listDichVu.removeAll(listDichVu);
		}
		public HoaDon findByTCCMaPhongTT(String theCanCuoc, String ThoiGianThueDau) {
			HoaDon dd = new HoaDon();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			LocalDate localDate = LocalDate.parse(ThoiGianThueDau, format);
			List<HoaDon> listhdkhongtrong = hoaDonRepository.findAllByTrangThaiThanhToan();
			for(HoaDon hoadon : listhdkhongtrong) {
				if(hoadon.getKhachHang().getTheCanCuoc().equalsIgnoreCase(theCanCuoc) && hoadon.getThoiGianTheuDau()==localDate) {
							dd=hoadon;
						
				}
			}
			return dd;
		}
}
		

