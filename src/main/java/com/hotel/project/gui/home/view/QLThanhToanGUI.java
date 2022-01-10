package com.hotel.project.gui.home.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotel.project.domain.ChiTietHoaDon;
import com.hotel.project.domain.HoaDon;
import com.hotel.project.domain.KhachHang;
import com.hotel.project.domain.Phong;
import com.hotel.project.repository.HoaDonRepository;
import com.hotel.project.repository.KhachHangRepository;
import com.hotel.project.repository.LoaiPhongRepository;
import com.hotel.project.repository.PhongRepository;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.awt.event.ActionEvent;

	
@Component
public class QLThanhToanGUI extends JPanel {
		/**
	 * 
	 */
	private static final long serialVersionUID = 6250730656352021769L;
		private JPanel contentPane;
		private JTable table;
		private JTextField textField_4;
		private JButton btnThanhToan;
		private JScrollPane scrollPane;
		private DefaultTableModel model;
		private JLabel btnjdo;
		private JButton btnTim;
		private JButton btnHuy;
		public String bientruyendi="ssssss";
		@Autowired
		private Home h ;
		static DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		private JTextField aaaa;
		private LocalDate ngayThue1;
		public static String ngayThueLHD;
		private String theCanCuoc;
		
		/**
		 * Create the panel.
		 */
		
		@Autowired
		private HoaDonRepository hoaDonRepository;
		@Autowired
		private KhachHangRepository khachHangRepository;
//		@Autowired
//		private CapNhatPhongGUI cnp;
		@Autowired
		private HoaDonGUI cnp;
		
		private List<HoaDon> list;
		
		private List<KhachHang> lisst;
		private int r ;
		private int xxx;
		private JButton btnNewButton;
		public QLThanhToanGUI() {
			
		}
		
		@PostConstruct
		public void preparePanel() {	
			setBounds(303, 0, 1599, 1008);
			setBackground(Color.WHITE);
			setLayout(null);
			
			JLabel lblDichVu = new JLabel("QUẢN LÝ THANH TOÁN");
			lblDichVu.setBackground(Color.WHITE);
			lblDichVu.setForeground(new Color(255, 69, 0));
			lblDichVu.setFont(new Font("Times New Roman", Font.BOLD, 30));
			lblDichVu.setHorizontalAlignment(SwingConstants.CENTER);
			lblDichVu.setBounds(0, 13, 1599, 36);
			add(lblDichVu, BorderLayout.NORTH);
			
			JPanel panel = new JPanel();
			panel.setBorder(null);
			panel.setBackground(Color.WHITE);
			panel.setBounds(0, 36, 1599, 972);
			add(panel);
			panel.setLayout(null);
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(76, 153, 1447, 726);
			panel.add(scrollPane);
			
			
			model = new DefaultTableModel(
					new String[] {
							"STT", "Tên khách hàng", "Thẻ Căn Cước", "Ngày Đặt","Ngày Trả","Nhận Phòng"
					}, 0){
			    public boolean isCellEditable(int row, int column)
			    {
			      return false;//This causes all cells to be not editable
			    }
			  };
			table = new JTable();
			table.setFont(new Font("Tahoma", Font.PLAIN, 18));
			table.setModel(model);
			scrollPane.setViewportView(table);
			table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
			table.getTableHeader().setOpaque(false);
			table.getTableHeader().setBackground(new Color(32,136,203));
			table.getTableHeader().setForeground(new Color(255,255,255));
			table.getTableHeader().setPreferredSize(new Dimension(scrollPane.getWidth(), 40));
			table.setRowHeight(40);
			table.setSelectionBackground(new Color(232,57,95));
			table.setSelectionForeground(new Color(255,255,255));
			table.setBackground(new Color(255,255,255));
			
			btnThanhToan = new JButton("Thanh Toán");
			
			btnThanhToan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnThanhToan.setBounds(1377, 906, 146, 42);
			panel.add(btnThanhToan);
			
			Panel panel_1_4 = new Panel();
			panel_1_4.setBounds(76, 98, 647, 42);
			panel.add(panel_1_4);
			panel_1_4.setLayout(new BorderLayout(0, 0));
	
			btnjdo = new JLabel("Tìm Kiếm     ");
			btnjdo.setFont(new Font("Times New Roman", Font.BOLD, 20));
			panel_1_4.add(btnjdo, BorderLayout.WEST);
			
			textField_4 = new JTextField();
			panel_1_4.add(textField_4, BorderLayout.CENTER);
			textField_4.setColumns(10);
			
			btnTim = new JButton("Tìm");
			btnTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			panel_1_4.add(btnTim, BorderLayout.EAST);
			
			btnHuy = new JButton("Huỷ Đơn");
			btnHuy.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnHuy.setBounds(76, 906, 146, 42);
			panel.add(btnHuy);
			
			btnNewButton = new JButton("LOAD LẠI DỮ LIỆU");
			btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnNewButton.setBounds(1281, 98, 242, 42);
			panel.add(btnNewButton);
			
			
			
			
			
			
		
			
			
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					resetBang();
					XoaHetDuLieuTrenTableModel();
					list = hoaDonRepository.findAllByTrangThaiThanhToan();
					docDLVaoBang(list);
					table.clearSelection();
				}
			});
			
			btnThanhToan.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					int r = table.getSelectedRow();
					if(r>=0)
					{
						DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						  String date = model.getValueAt(r, 3).toString();

						  //convert String to LocalDate
						  LocalDate localDate = LocalDate.parse(date, format);
						
						if((boolean) model.getValueAt(r, 5)==true) {
							
							cnp.dienThongtin(model.getValueAt(r, 2).toString(),localDate);	
							cnp.setVisible(true);
						}
						else
							JOptionPane.showMessageDialog(null, "Phải nhận phòng trước khi Thanh Toán");
					
					
					
					}
					else {
						JOptionPane.showMessageDialog(null, "Phải chọn dòng để Thanh Toán");
					}
				}
			});
			
			
			btnHuy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int r = table.getSelectedRow();
					System.out.println(r);
					if(r>=0)
					{
					String nhanphong =  model.getValueAt(r, 5).toString();
//					DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//					LocalDate local =  LocalDate.parse(model.getValueAt(r, 5).toString(),format);
						if(nhanphong.equals("false")) {
							HoaDon a= hoaDonRepository.findHoaDonTheoTheCanCuocchi1(model.getValueAt(r, 2).toString());
							hoaDonRepository.deleteHoaDon(a);
							XoaHetDuLieuTrenTableModel();
							list = hoaDonRepository.findAllByTrangThaiThanhToan();
							docDLVaoBang(list);
							table.clearSelection();
							QLDatPhongGUI qldt = new QLDatPhongGUI();
							qldt.hienthiPhong();
							JOptionPane.showMessageDialog(null, "Hủy thành công");
						}
						else {
						JOptionPane.showMessageDialog(null, "Nhận rồi là ko hủy được");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Phải chọn dòng để Huỷ");
					}
				}
			});
			
		btnTim.addActionListener(new ActionListener() {
			private HoaDon timHoaDonTheoTheCanCuoc;

			public void actionPerformed(ActionEvent arg0) {
				String tim = textField_4.getText();
				if(tim.length()>0)
				{
					XoaHetDuLieuTrenTableModel();
					timHoaDonTheoTheCanCuoc = hoaDonRepository.findHoaDonTheoTheCanCuocchi1(tim);
				//int ww = LocalDateTime.now().compareTo(ngayThue1);
					list.add(timHoaDonTheoTheCanCuoc);
					try {
						docDLVaoBang(list);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "không có Khách hàng Này");
					}
						
					}
					else {
						resetBang();
						XoaHetDuLieuTrenTableModel();
						
						list = hoaDonRepository.findAllByTrangThaiThanhToan();
						docDLVaoBang(list);
						table.clearSelection();
					}
					
					
					}
		});
			

			list = hoaDonRepository.findAllByTrangThaiThanhToan();
			docDLVaoBang(list);
			
		
			 r = table.getSelectedRow();
			 if(table.getSelectedRow()>=0) {
				 xxx= table.getSelectedRow();
			 }
			
		}
		
		
		public void docDLVaoBang(List<HoaDon> list) {
			int i =1;
			int dem=0;
			reset();
			for(HoaDon h :list) {
					if(h.getThoiGianNP()!=null) {
						String t = h.getThoiGianLHD().format(formatter);
						List<ChiTietHoaDon> zz = h.getListHoaDon();
						for(ChiTietHoaDon cthd :zz) {
							if(cthd.getTenKhachHang().equals("")) {
								dem++;
							}		
						}
						if(dem>0) {
							model.addRow(new Object[] {	
									i,h.getKhachHang().getTenKhachHang(),h.getKhachHang().getTheCanCuoc(),h.getThoiGianTheuDau(),h.getThoiGianTheuCuoi(),false
							});
						}
						else {
							model.addRow(new Object[] {	
									i,h.getKhachHang().getTenKhachHang(),h.getKhachHang().getTheCanCuoc(),h.getThoiGianTheuDau(),h.getThoiGianTheuCuoi(),true
							});
						}
					}
					else {
						String t = h.getThoiGianLHD().format(formatter);
						model.addRow(new Object[] {
								
								i,h.getKhachHang().getTenKhachHang(),h.getKhachHang().getTheCanCuoc(),h.getThoiGianTheuDau(),h.getThoiGianTheuCuoi(),false
						});
					}
				i++;
			}
			table.setModel(model);	
		}
		public String getTT(boolean tt) {
			if(tt==true) {
				return "Trống";
			}
			return "Đang ở";
		}
		public  void reset()
		{
			model.setRowCount(0);
		}
		public String truyenNgay()    {
	        return  model.getValueAt(1, 3).toString();
	    }
		public int truyenSoNgay()    {
			LocalDate ngayThue = (LocalDate) model.getValueAt(1, 3);
	        return LocalDate.now().compareTo(ngayThue);
	    }
		public  void XoaHetDuLieuTrenTableModel()
		{
			DefaultTableModel dm =(DefaultTableModel) table.getModel();
			dm.getDataVector().removeAllElements();
			list.removeAll(list);
		}
		public  void resetBang()
		{
			model.setRowCount(0);
		}
		
	
		
	}
