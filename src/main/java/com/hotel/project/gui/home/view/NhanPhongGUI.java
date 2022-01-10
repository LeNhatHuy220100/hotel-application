package com.hotel.project.gui.home.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotel.project.domain.ChiTietDichVu;
import com.hotel.project.domain.ChiTietHoaDon;
import com.hotel.project.domain.HoaDon;
import com.hotel.project.domain.KhachHang;
import com.hotel.project.domain.LoaiPhong;
import com.hotel.project.domain.Phong;
import com.hotel.project.repository.impl.HoaDonRepositoryImpl;
import com.hotel.project.repository.impl.KhachHangRepositoryImpl;
import com.hotel.project.repository.impl.LoaiPhongRepositoryImpl;
import com.hotel.project.repository.impl.PhongRepositoryImpl;

@Component
public class NhanPhongGUI extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JTextField txtcmnd;
	private JLabel lblTieuDe = new JLabel("NHẬN PHÒNG");
	private JTextField txtcmnd_kho;
	private JTextField txtTenKH_kho;
	private JTextField txtsdt_kho;
	private JTextField txtThue;
	private JTextField txtTra;
	private JTextField txtNhan;
	private JTable table;
	private JTextField txtSNO;
	private DefaultTableModel model;
	
	private String thecancuoc ="", phongdichvu="";
	private HoaDon hd_hientai = new HoaDon();
	private DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

	@Autowired
	HoaDonRepositoryImpl hoadonrepo;
	@Autowired
	PhongRepositoryImpl phongrepo;
	@Autowired
	LoaiPhongRepositoryImpl loaiphongrepo;
	@Autowired
	KhachHangRepositoryImpl khachhangrepo;
	@Autowired
	private QLDatPhongGUI qldp;

	public JLabel getLblTieuDe() {
		return lblTieuDe;
	}

	public void setLblTieuDe(JLabel lblTieuDe) {
		this.lblTieuDe = lblTieuDe;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanPhongGUI frame = new NhanPhongGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NhanPhongGUI() {
		
	}
	
	@PostConstruct
	public void preparePane() {
		setBounds(303, 0, 1599, 788);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnTieuDe = new JPanel();
		pnTieuDe.setBackground(Color.WHITE);
		pnTieuDe.setBounds(27, 13, 1525, 71);
		contentPane.add(pnTieuDe);
		pnTieuDe.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		lblTieuDe.setForeground(new Color(255, 69, 0));
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		pnTieuDe.add(lblTieuDe);
		
		JPanel pnTTNDD = new JPanel();
		pnTTNDD.setBackground(Color.WHITE);
		pnTTNDD.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin ng\u01B0\u1EDDi \u0111\u1EA1i di\u1EC7n", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 120, 215)));
		pnTTNDD.setBounds(37, 97, 521, 266);
		contentPane.add(pnTTNDD);
		pnTTNDD.setLayout(null);
		
		JLabel lblTenKH = new JLabel("Tên Khách Hàng");
		lblTenKH.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTenKH.setBounds(12, 80, 161, 43);
		pnTTNDD.add(lblTenKH);
		
		JLabel lblSDT = new JLabel("Số Điện Thoại");
		lblSDT.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSDT.setBounds(12, 136, 161, 43);
		pnTTNDD.add(lblSDT);
		
		JLabel lblcmnd = new JLabel("CMND");
		lblcmnd.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblcmnd.setBounds(12, 24, 161, 43);
		pnTTNDD.add(lblcmnd);
		
		txtTenKH = new JTextField();
		txtTenKH.setEditable(false);
		txtTenKH.setBackground(Color.WHITE);
		txtTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(173, 80, 334, 43);
		pnTTNDD.add(txtTenKH);
		
		txtSDT = new JTextField();
		txtSDT.setEditable(false);
		txtSDT.setBackground(Color.WHITE);
		txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSDT.setColumns(10);
		txtSDT.setBounds(173, 136, 334, 43);
		pnTTNDD.add(txtSDT);
		
		txtcmnd = new JTextField();
		txtcmnd.setEditable(false);
		txtcmnd.setBackground(Color.WHITE);
		txtcmnd.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtcmnd.setColumns(10);
		txtcmnd.setBounds(173, 24, 334, 43);
		pnTTNDD.add(txtcmnd);
		
		JPanel pnTTP = new JPanel();
		pnTTP.setBackground(Color.WHITE);
		pnTTP.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin ph\u00F2ng", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 120, 215)));
		pnTTP.setBounds(570, 97, 970, 266);
		contentPane.add(pnTTP);
		pnTTP.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(14, 26, 936, 220);
		pnTTP.add(scrollPane);
		
		model = new DefaultTableModel(
				new String[] {
						"STT", "Mã phòng", "Loại phòng", "Số giường", "Số người ở", "Giá tiền"
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
		
		JPanel pnTTKHO = new JPanel();
		pnTTKHO.setBackground(Color.WHITE);
		pnTTKHO.setLayout(null);
		pnTTKHO.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin kh\u00E1ch h\u00E0ng \u1EDF", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 120, 215)));
		pnTTKHO.setBounds(36, 376, 521, 298);
		contentPane.add(pnTTKHO);
		
		JLabel lblcmnd_kho = new JLabel("CMND");
		lblcmnd_kho.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblcmnd_kho.setBounds(12, 25, 161, 43);
		pnTTKHO.add(lblcmnd_kho);
		
		JLabel lblTenKH_kho = new JLabel("Tên Khách Hàng");
		lblTenKH_kho.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTenKH_kho.setBounds(13, 136, 161, 43);
		pnTTKHO.add(lblTenKH_kho);
		
		JLabel lblsdt_kho = new JLabel("Số Điện Thoại");
		lblsdt_kho.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblsdt_kho.setBounds(13, 192, 161, 43);
		pnTTKHO.add(lblsdt_kho);
		
		txtcmnd_kho = new JTextField();
		txtcmnd_kho.setBackground(Color.WHITE);
		txtcmnd_kho.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtcmnd_kho.setColumns(10);
		txtcmnd_kho.setBounds(173, 25, 334, 43);
		pnTTKHO.add(txtcmnd_kho);
		
		txtTenKH_kho = new JTextField();
		txtTenKH_kho.setEditable(false);
		txtTenKH_kho.setBackground(Color.WHITE);
		txtTenKH_kho.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTenKH_kho.setColumns(10);
		txtTenKH_kho.setBounds(174, 136, 334, 43);
		pnTTKHO.add(txtTenKH_kho);
		
		txtsdt_kho = new JTextField();
		txtsdt_kho.setBackground(Color.WHITE);
		txtsdt_kho.setEditable(false);
		txtsdt_kho.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtsdt_kho.setColumns(10);
		txtsdt_kho.setBounds(174, 192, 334, 43);
		pnTTKHO.add(txtsdt_kho);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnTim.setBounds(394, 82, 114, 43);
		pnTTKHO.add(btnTim);
		
		JButton btnNhanPhong = new JButton("Nhận Phòng");
		btnNhanPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNhanPhong.setBounds(1384, 683, 150, 43);
		contentPane.add(btnNhanPhong);
		
		JPanel pnTTDP = new JPanel();
		pnTTDP.setBackground(Color.WHITE);
		pnTTDP.setLayout(null);
		pnTTDP.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin \u0111\u1EB7t ph\u00F2ng", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 120, 215)));
		pnTTDP.setBounds(572, 374, 966, 299);
		contentPane.add(pnTTDP);
		
		txtThue = new JTextField();
		txtThue.setBackground(Color.WHITE);
		txtThue.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtThue.setEditable(false);
		txtThue.setColumns(10);
		txtThue.setBounds(177, 29, 334, 43);
		pnTTDP.add(txtThue);
		
		txtTra = new JTextField();
		txtTra.setBackground(Color.WHITE);
		txtTra.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTra.setEditable(false);
		txtTra.setColumns(10);
		txtTra.setBounds(177, 85, 334, 43);
		pnTTDP.add(txtTra);
		
		txtNhan = new JTextField();
		txtNhan.setBackground(Color.WHITE);
		txtNhan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtNhan.setEditable(false);
		txtNhan.setColumns(10);
		txtNhan.setBounds(177, 141, 334, 43);
		pnTTDP.add(txtNhan);
		
		JLabel lblNhan = new JLabel("Thời Gian Nhận ");
		lblNhan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNhan.setBounds(16, 141, 161, 43);
		pnTTDP.add(lblNhan);
		
		JLabel lblTra = new JLabel("Ngày Trả");
		lblTra.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTra.setBounds(16, 85, 161, 43);
		pnTTDP.add(lblTra);
		
		JLabel lblThue = new JLabel("Ngày Thuê");
		lblThue.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblThue.setBounds(16, 29, 161, 43);
		pnTTDP.add(lblThue);
		
		txtSNO = new JTextField();
		txtSNO.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSNO.setColumns(10);
		txtSNO.setBounds(725, 30, 227, 43);
		pnTTDP.add(txtSNO);
		
		JLabel lblSNO = new JLabel("Số người ở");
		lblSNO.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSNO.setBounds(586, 30, 139, 43);
		pnTTDP.add(lblSNO);
		
		
		/**
		 * Tim kiem khach hang
		 */
		btnTim.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	String key = "";
		    	key = txtcmnd_kho.getText();
		    	if(key.equalsIgnoreCase("")) {
		    		JOptionPane.showMessageDialog(null, "Vui lòng điển số CMND/thẻ căn cước của khách hàng");
		    	}else {
		    		KhachHang kh = khachhangrepo.findByTheCanCuoc(key);
		    		if(kh == null) {
		    			JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng");
		    		}else {
		    			txtTenKH_kho.setText(kh.getTenKhachHang());
		    			txtsdt_kho.setText(kh.getSoDienThoai());
		    		}
		    	}
		    }
		});
		
		
		/**
		 * Nhan phong
		 */
		btnNhanPhong.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	nhanPhong();
		    	qldp.hienthiPhong();
		    	
		    }
		});
	}
	
	//Xoa bang
	public  void reset(DefaultTableModel m)
	{
		m.setRowCount(0);
	}		
	
	//Hien thi thong tin, dung ben giao dien QLDatPhong
	public void hienthiThongTin(String theCanCuoc, String maPhong) {
		HoaDon hd_hienthi = findByTCCMaPhongTT(theCanCuoc, maPhong);
		ChiTietHoaDon ct = new ChiTietHoaDon();
		for(ChiTietHoaDon cthd : hd_hienthi.getListHoaDon()) {
			if(cthd.getMaPhong().equalsIgnoreCase(maPhong)) {
				ct = cthd;
			}
		}
		
		//khach hang dat phong
		txtcmnd.setText(hd_hienthi.getKhachHang().getTheCanCuoc());
		txtTenKH.setText(hd_hienthi.getKhachHang().getTenKhachHang());
		txtSDT.setText(hd_hienthi.getKhachHang().getSoDienThoai());
		txtThue.setText(df.format(hd_hienthi.getThoiGianTheuDau()));
		txtTra.setText(df.format(hd_hienthi.getThoiGianTheuCuoi()));
		txtNhan.setText(dtf.format(LocalDateTime.now()));
		
		//Phong
		Phong p = phongrepo.findByMaPhong(maPhong);
		LoaiPhong lp = loaiphongrepo.findLoaiByMaPhong(maPhong);
		reset(model);
		model.addRow(new Object[] {
				1, p.getMaPhong() , 
				lp.getTenLoai(),
				p.getSoGiuong(),
				p.getSoNguoiToiDa(),
				p.getGiaPhong()
		});
		
		//Lay the can cuoc , phong dich vu, ma phong
		phongdichvu = maPhong;
		thecancuoc = theCanCuoc;
		hd_hientai = hd_hienthi;
	}
	
	//Tim kiem Phong theo the can cuoc, ma phong, trang thai 
	public HoaDon findByTCCMaPhongTT(String theCanCuoc, String maPhong) {
		HoaDon dd = new HoaDon();
		List<HoaDon> listhdkhongtrong = hoadonrepo.findAllByTrangThaiThanhToan();
		for(HoaDon hoadon : listhdkhongtrong) {
			if(hoadon.getKhachHang().getTheCanCuoc().equalsIgnoreCase(theCanCuoc)) {
				for(ChiTietHoaDon ct : hoadon.getListHoaDon()) {
					if(ct.getMaPhong().equalsIgnoreCase(maPhong)) {
						dd=hoadon;
					}
				}
			}
		}
		return dd;
	}
	
	//kiem tra bieu thuc chinh quy
		public boolean kiemtra() {
			String soluong = txtSNO.getText().trim();
			
			if(soluong.length() > 0) {
				try {
					int x = Integer.parseInt(soluong);
					if(x < 0) {
						JOptionPane.showMessageDialog(null, "Số mgười lớn hơn 0");
						return false;
					}
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Số người là số");
					return false;
				}
			}
			
			
			return true;
		}
	
	//Nhan phong
	public void nhanPhong() {
		if(txtTenKH_kho.getText().equalsIgnoreCase("")) {
			txtTenKH_kho.requestFocus();
			JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin khách hàng ở");
		}else if(txtSNO.getText().equalsIgnoreCase("")){
			JOptionPane.showMessageDialog(null, "Vui lòng nhập số người ở");
		}else if(kiemtra()) {
			Phong ppp = phongrepo.findByMaPhong(phongdichvu);
			if(Integer.parseInt(txtSNO.getText())<=0) {
				JOptionPane.showMessageDialog(null, "Số người khác không phù hợp");
				txtSNO.setText("");
				txtSNO.requestFocus();
				
			}else if(Integer.parseInt(txtSNO.getText()) <= ppp.getSoNguoiToiDa()) {
				for(ChiTietHoaDon cthd : hd_hientai.getListHoaDon()) {
					if(cthd.getMaPhong().equalsIgnoreCase(phongdichvu)) {
						cthd.setTheCanCuoc(txtcmnd_kho.getText());
						cthd.setTenKhachHang(txtTenKH_kho.getText());
						cthd.setSoDienThoai(txtsdt_kho.getText());
						cthd.setThoiGianTheuCuoi(hd_hientai.getThoiGianTheuCuoi());
						cthd.setThoiGianTheuDau(hd_hientai.getThoiGianTheuDau());
						cthd.setSoNguoiToiDa(Integer.parseInt(txtSNO.getText()));
					}
				
				}
				hoadonrepo.updateListHoaDon(thecancuoc, phongdichvu, hd_hientai.getListHoaDon());
				//Set thoi gian nhan phong
				hoadonrepo.updateTGNP(thecancuoc, phongdichvu, LocalDateTime.now());
				//Set trang thai phong
				phongrepo.updatePhong(ppp, loaiphongrepo.findLoaiByMaPhong(phongdichvu).getTenLoai(), false);
				
				JOptionPane.showMessageDialog(null, "Nhận phòng thành công");
				resetJFrame();
				this.dispose();
				
				
			}else {
				JOptionPane.showMessageDialog(null, "Số người ở lớn hơn số người ở tối đa");
				txtSNO.setText("");
				txtSNO.requestFocus();
			}
			
			
			
		}
	}
	
	public void resetJFrame() {
		txtcmnd_kho.setText("");
		txtTenKH_kho.setText("");
		txtsdt_kho.setText("");
		txtSNO.setText("");
	}
}
	
	
	

