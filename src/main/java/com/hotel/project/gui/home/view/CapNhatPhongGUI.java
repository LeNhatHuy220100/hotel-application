package com.hotel.project.gui.home.view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.annotation.PostConstruct;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotel.project.domain.ChiTietDichVu;
import com.hotel.project.domain.ChiTietHoaDon;
import com.hotel.project.domain.DichVu;
import com.hotel.project.domain.HoaDon;
import com.hotel.project.domain.LoaiPhong;
import com.hotel.project.domain.Phong;
import com.hotel.project.repository.impl.DichVuRepositoryImpl;
import com.hotel.project.repository.impl.HoaDonRepositoryImpl;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

@Component
public class CapNhatPhongGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JTextField txtcmnd;
	private JTextField txtThue;
	private JTextField txtTra;
	private JTextField txtNhan;
	private JTextField txtTK;
	private JTable table;
	private JTable table_1;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private DefaultTableModel model, model1;
	private DefaultListModel<String> model_list;
	private JLabel lblTieuDe = new JLabel("CẬP NHẬT THÔNG TIN PHÒNG");
	private JTextField txtcmnd_kho;
	private JTextField txttenkh_kho;
	private JTextField txtsdt_kho;
	private JTextField txtSL;
	private JButton btnThem;
	private DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	private String thecancuoc ="", phongdichvu="";
	private int i_bang =0;
	private List<ChiTietDichVu> listctdv = new ArrayList<ChiTietDichVu>();
	@Autowired
	DichVuRepositoryImpl dichvurepo;
	@Autowired
	HoaDonRepositoryImpl hoadonrepo;

	public JLabel getLblTieuDe() {
		return lblTieuDe;
	}

	public void setLblTieuDe(JLabel lblTieuDe) {
		this.lblTieuDe = lblTieuDe;
	}

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhatPhongGUI frame = new CapNhatPhongGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public CapNhatPhongGUI() {
	
	}
	
	@PostConstruct
	public void preparePane() {
		setBounds(303, 0, 1599, 1008);
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
		
		JPanel pnTTDatPhong = new JPanel();
		pnTTDatPhong.setBackground(Color.WHITE);
		pnTTDatPhong.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin \u0111\u1EB7t ph\u00F2ng", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 120, 215)));
		pnTTDatPhong.setBounds(37, 97, 521, 482);
		contentPane.add(pnTTDatPhong);
		pnTTDatPhong.setLayout(null);
		
		JLabel lblTenKH = new JLabel("Tên Khách Hàng");
		lblTenKH.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTenKH.setBounds(12, 80, 161, 43);
		pnTTDatPhong.add(lblTenKH);
		
		JLabel lblSDT = new JLabel("Số Điện Thoại");
		lblSDT.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSDT.setBounds(12, 136, 161, 43);
		pnTTDatPhong.add(lblSDT);
		
		JLabel lblcmnd = new JLabel("CMND");
		lblcmnd.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblcmnd.setBounds(12, 24, 161, 43);
		pnTTDatPhong.add(lblcmnd);
		
		JLabel lblThue = new JLabel("Ngày Thuê");
		lblThue.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblThue.setBounds(12, 192, 161, 43);
		pnTTDatPhong.add(lblThue);
		
		JLabel lblTra = new JLabel("Ngày Trả");
		lblTra.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTra.setBounds(12, 248, 161, 43);
		pnTTDatPhong.add(lblTra);
		
		txtTenKH = new JTextField();
		txtTenKH.setBackground(Color.WHITE);
		txtTenKH.setEditable(false);
		txtTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(173, 80, 334, 43);
		pnTTDatPhong.add(txtTenKH);
		
		txtSDT = new JTextField();
		txtSDT.setBackground(Color.WHITE);
		txtSDT.setEditable(false);
		txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSDT.setColumns(10);
		txtSDT.setBounds(173, 136, 334, 43);
		pnTTDatPhong.add(txtSDT);
		
		txtcmnd = new JTextField();
		txtcmnd.setBackground(Color.WHITE);
		txtcmnd.setEditable(false);
		txtcmnd.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtcmnd.setColumns(10);
		txtcmnd.setBounds(173, 24, 334, 43);
		pnTTDatPhong.add(txtcmnd);
		
		txtThue = new JTextField();
		txtThue.setBackground(Color.WHITE);
		txtThue.setEditable(false);
		txtThue.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtThue.setColumns(10);
		txtThue.setBounds(173, 192, 334, 43);
		pnTTDatPhong.add(txtThue);
		
		txtTra = new JTextField();
		txtTra.setBackground(Color.WHITE);
		txtTra.setEditable(false);
		txtTra.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTra.setColumns(10);
		txtTra.setBounds(173, 248, 334, 43);
		pnTTDatPhong.add(txtTra);
		
		txtNhan = new JTextField();
		txtNhan.setBackground(Color.WHITE);
		txtNhan.setEditable(false);
		txtNhan.setBounds(173, 304, 334, 43);
		pnTTDatPhong.add(txtNhan);
		txtNhan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtNhan.setColumns(10);
		
		JLabel lblNhan = new JLabel("Thời Gian Nhận ");
		lblNhan.setBounds(12, 304, 161, 43);
		pnTTDatPhong.add(lblNhan);
		lblNhan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JPanel pnTTDV = new JPanel();
		pnTTDV.setBackground(Color.WHITE);
		pnTTDV.setBorder(new TitledBorder(null, "Th\u00F4ng tin d\u1ECBch v\u1EE5", TitledBorder.LEFT, TitledBorder.TOP, null, SystemColor.textHighlight));
		pnTTDV.setBounds(570, 97, 970, 482);
		contentPane.add(pnTTDV);
		pnTTDV.setLayout(null);
		
		JLabel lblTK = new JLabel("Tìm Kiếm");
		lblTK.setHorizontalAlignment(SwingConstants.CENTER);
		lblTK.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTK.setBounds(12, 35, 121, 43);
		pnTTDV.add(lblTK);
		
		txtTK = new JTextField();
		txtTK.setBackground(Color.WHITE);
		txtTK.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTK.setColumns(10);
		txtTK.setBounds(133, 35, 289, 43);
		pnTTDV.add(txtTK);
		
		JButton btnTK = new JButton("Tìm");
		btnTK.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnTK.setBounds(434, 35, 97, 43);
		pnTTDV.add(btnTK);
		
		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnThem.setBounds(861, 35, 97, 43);
		pnTTDV.add(btnThem);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(132, 77, 290, 242);
		pnTTDV.add(layeredPane);
		layeredPane.setLayout(new BorderLayout(0, 0));
		
		JList<String> list = new JList<String>();
		list.setVisibleRowCount(5);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		layeredPane.add(list, BorderLayout.NORTH);
		
		model_list = new DefaultListModel<String>();
		list.setModel(model_list);
		
		
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 91, 946, 378);
		pnTTDV.add(scrollPane);
		
		model = new DefaultTableModel(
				new String[] {
						"STT", "M\u00E3 d\u1ECBch v\u1EE5", "T\u00EAn d\u1ECBch v\u1EE5", "Đơn giá"
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
		 table.setBackground(Color.WHITE);
		 
		txtSL = new JTextField();
		txtSL.setBackground(Color.WHITE);
		txtSL.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSL.setColumns(10);
		txtSL.setBounds(684, 35, 165, 43);
		pnTTDV.add(txtSL);
		
		JLabel lblSL = new JLabel("Số lượng");
		lblSL.setHorizontalAlignment(SwingConstants.CENTER);
		lblSL.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSL.setBounds(563, 35, 121, 43);
		pnTTDV.add(lblSL);
		
		JPanel pnTTDVD = new JPanel();
		pnTTDVD.setBackground(Color.WHITE);
		pnTTDVD.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin d\u1ECBch v\u1EE5 \u0111\u00E3 d\u00F9ng", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 120, 215)));
		pnTTDVD.setBounds(570, 592, 970, 302);
		contentPane.add(pnTTDVD);
		pnTTDVD.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(12, 26, 946, 259);
		pnTTDVD.add(scrollPane_1);
		
		model1 = new DefaultTableModel(
				new String[] {
						"STT", "M\u00E3 d\u1ECBch v\u1EE5", "T\u00EAn d\u1ECBch v\u1EE5", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1"
				}, 0){
		    public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		  };
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table_1.setModel(model1);
		scrollPane_1.setViewportView(table_1);
		table_1.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
		table_1.getTableHeader().setOpaque(false);
		table_1.getTableHeader().setBackground(new Color(32,136,203));
		table_1.getTableHeader().setForeground(new Color(255,255,255));
		table_1.getTableHeader().setPreferredSize(new Dimension(scrollPane_1.getWidth(), 40));
		table_1.setRowHeight(40);
		table_1.setSelectionBackground(new Color(232,57,95));
		table_1.setSelectionForeground(new Color(255,255,255));
		table_1.setBackground(Color.WHITE);
		
		JPanel pnKHO = new JPanel();
		pnKHO.setBackground(Color.WHITE);
		pnKHO.setLayout(null);
		pnKHO.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin kh\u00E1ch h\u00E0ng \u1EDF", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 120, 215)));
		pnKHO.setBounds(37, 592, 521, 298);
		contentPane.add(pnKHO);
		
		JLabel lblcmnd_kho = new JLabel("CMND");
		lblcmnd_kho.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblcmnd_kho.setBounds(12, 25, 161, 43);
		pnKHO.add(lblcmnd_kho);
		
		JLabel lbltenkh_kho = new JLabel("Tên Khách Hàng");
		lbltenkh_kho.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbltenkh_kho.setBounds(12, 81, 161, 43);
		pnKHO.add(lbltenkh_kho);
		
		JLabel lblsdt_kho = new JLabel("Số Điện Thoại");
		lblsdt_kho.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblsdt_kho.setBounds(12, 137, 161, 43);
		pnKHO.add(lblsdt_kho);
		
		txtcmnd_kho = new JTextField();
		txtcmnd_kho.setBackground(Color.WHITE);
		txtcmnd_kho.setEditable(false);
		txtcmnd_kho.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtcmnd_kho.setColumns(10);
		txtcmnd_kho.setBounds(173, 25, 334, 43);
		pnKHO.add(txtcmnd_kho);
		
		txttenkh_kho = new JTextField();
		txttenkh_kho.setBackground(Color.WHITE);
		txttenkh_kho.setEditable(false);
		txttenkh_kho.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txttenkh_kho.setColumns(10);
		txttenkh_kho.setBounds(173, 81, 334, 43);
		pnKHO.add(txttenkh_kho);
		
		txtsdt_kho = new JTextField();
		txtsdt_kho.setBackground(Color.WHITE);
		txtsdt_kho.setEditable(false);
		txtsdt_kho.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtsdt_kho.setColumns(10);
		txtsdt_kho.setBounds(173, 137, 334, 43);
		pnKHO.add(txtsdt_kho);
		
		JButton btnCpNht = new JButton("Cập nhật");
		btnCpNht.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCpNht.setBounds(1390, 902, 150, 43);
		contentPane.add(btnCpNht);
		
		
		
		/*
		 * Suggestion
		 * 
		 * */
		txtTK.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					model_list.removeAllElements();
					String val = txtTK.getText().trim();
					if(!val.equalsIgnoreCase("")==true) {
						List<DichVu> l_dv = new ArrayList<DichVu>();
						l_dv = dichvurepo.findByTenDichVuTuongDoi(val);
						for(DichVu dv : l_dv) {
							model_list.addElement(dv.getTenDichVu());
							if(model_list.getSize() > 6)
								break;
						}
					
					}
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				if(!list.isSelectionEmpty()) {
					String key =model_list.getElementAt(list.getSelectedIndex());
					txtTK.setText(key);
					model_list.removeAllElements();
					
					//Tim dich vu
					DichVu v = dichvurepo.findByMaDichVu(key);
					List<DichVu> lv1 = dichvurepo.findByTenDichVuTuongDoi(key);
					
					if(v == null && lv1.size()==0) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy dịch vụ thích hợp");
						txtTK.requestFocus();
					}else {
						
						if(v == null) {
							//v3 = v1;
							int i =1;
							reset(model);
							for(DichVu dv : lv1) {
								model.addRow(new Object[] {
										i, dv.getMaDichVu(), dv.getTenDichVu() , dv.getGiaDichVu()
								});
								i++;
							}
						}else {
							reset(model);
							model.addRow(new Object[] {
										1, v.getMaDichVu(), v.getTenDichVu() , v.getGiaDichVu()
							});
						}
					}
				}
				
			}
		});
		

		/*
		 * Tim kiem dich vu
		 * 
		 * */
		reset(model);
		btnTK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				timkiemDV();
				model_list.removeAllElements();
			}
		});
		
		/*
		 * Them dich vu vao bang
		 * 
		 * */
		btnThem.setEnabled(false);
		btnThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(kiemtra()) {
					if(txtSL.getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng điển số lượng");
						txtSL.requestFocus();
					}else {
						themDVVaoBang();
					}
					
				}
				
			}
		});
		
		/*
		 * Mo khoa nut them dich vu
		 * 
		 * */
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnThem.setEnabled(true);
			}
		});
		
		/*
		 * Cap nhat dich vu
		 * 
		 * */
		btnCpNht.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateCTDV();
				hienthiThongTin(thecancuoc, phongdichvu);
			}
		});
		
	}
	
	
	//Tim kiem dich vu
	public void timkiemDV() {
		String key = "";
		key = txtTK.getText();
		if(key.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Nhập tên dịch vụ vào ô tìm kiếm");
		}else {
			DichVu v = dichvurepo.findByMaDichVu(key);
			List<DichVu> lv1 = dichvurepo.findByTenDichVuTuongDoi(key);
			
			if(v == null && lv1.size()==0) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy dịch vụ thích hợp");
				txtTK.requestFocus();
			}else {
				
				if(v == null) {
					//v3 = v1;
					int i =1;
					reset(model);
					for(DichVu dv : lv1) {
						model.addRow(new Object[] {
								i, dv.getMaDichVu(), dv.getTenDichVu() , dv.getGiaDichVu()
						});
						i++;
					}
				}else {
					reset(model);
					model.addRow(new Object[] {
								1, v.getMaDichVu(), v.getTenDichVu() , v.getGiaDichVu()
					});
				}
					
				
				
			}
		}
	}
		
	//Xoa bang
	public  void reset(DefaultTableModel m)
	{
		m.setRowCount(0);
	}
	
	//Doc du lieu vao bang
		public void docDLVaoBang(List<ChiTietDichVu> list, String maPhong) {
			int i =1;
			reset(model1);
			for(ChiTietDichVu ctdv :list) {
				if(ctdv.getPhongDichVu().equalsIgnoreCase(maPhong)) {
					model1.addRow(new Object[] {
							i, ctdv.getMaDichVu(), ctdv.getTenDichVu(), ctdv.getSoLuong(), ctdv.getGia()
					});
					i++;
				}
				
			}
			table_1.setModel(model1);
			i_bang = table_1.getRowCount();
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
		txtNhan.setText(dtf.format(hd_hienthi.getThoiGianNP()));
		//Khach hang o
		txtcmnd_kho.setText(ct.getTheCanCuoc());
		txttenkh_kho.setText(ct.getTenKhachHang());
		txtsdt_kho.setText(ct.getSoDienThoai());
		//Danh sach dich vu da dung
		docDLVaoBang(hd_hienthi.getListDichVu(), maPhong);
		reset(model);
		txtTK.setText("");
		txtSL.setText("");
		btnThem.setEnabled(false);
		listctdv=hd_hienthi.getListDichVu();
		
		//Lay the can cuoc , phong dich vu
		phongdichvu = maPhong;
		thecancuoc = theCanCuoc;
	}
	
	//Them dich vu vao bang
	public void themDVVaoBang() {
		int row = table.getSelectedRow();
		int i=1;
		
		int sua=0;
		//Sua list dich vu
		ChiTietDichVu ctdv = new ChiTietDichVu(model.getValueAt(row, 1).toString(), 
				model.getValueAt(row, 2).toString(),
				Integer.parseInt(txtSL.getText()),
				Double.parseDouble(model.getValueAt(row, 3).toString()), 
				phongdichvu);
		 for(ChiTietDichVu ct : listctdv) {
			 if(ct.getMaDichVu().equalsIgnoreCase(ctdv.getMaDichVu())&&
					 ct.getGia()==ctdv.getGia()&&
					 ct.getPhongDichVu().equalsIgnoreCase(phongdichvu)) {
				 ct.setSoLuong(ct.getSoLuong()+ctdv.getSoLuong());
				 sua++;
			 }
		 }
		 if(sua==0) {
			 listctdv.add(ctdv);
		 }
		 
		 //In list dich vu vao bang
		 reset(model1);
		 for(ChiTietDichVu ct : listctdv) {
			 if(ct.getPhongDichVu().equalsIgnoreCase(phongdichvu)) {
				 model1.addRow(new Object[] {
							i, ct.getMaDichVu() , 
							ct.getTenDichVu(),
							ct.getSoLuong(), 
							ct.getGia()
					});
				 i++;
			 }
			 
		 }
		
	}
	
	//kiem tra bieu thuc chinh quy
	public boolean kiemtra() {
		String soluong = txtSL.getText().trim();
		
		if(soluong.length() > 0) {
			try {
				int x = Integer.parseInt(soluong);
				if(x <= 0) {
					JOptionPane.showMessageDialog(null, "Số lượng không phù hợp");
					return false;
				}
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Số lượng là số");
				return false;
			}
		}
		
		
		return true;
	}
	
	//Cap nhat dich vu vao hoa don
	public void updateCTDV() {
		
		if(JOptionPane.showConfirmDialog(null, "Bạn có muốn cập nhật ?") == 0) {
			HoaDon d = hoadonrepo.updateListDichVu(thecancuoc, phongdichvu, listctdv);
			
			listctdv = new ArrayList<ChiTietDichVu>();
		
		}
		
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
}
