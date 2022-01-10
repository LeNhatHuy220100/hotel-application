package com.hotel.project.gui.home.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.hotel.project.domain.ChiTietHoaDon;
import com.hotel.project.domain.HoaDon;
import com.hotel.project.domain.LoaiPhong;
import com.hotel.project.domain.Phong;
import com.hotel.project.repository.LoaiPhongRepository;
import com.hotel.project.repository.PhongRepository;
import com.hotel.project.repository.impl.HoaDonRepositoryImpl;


@Component
public class QLPhongGUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField txtMaPhong;
	private JTextField txtTT;
	private JTextField txtGiaPhong;
	private JTextField txtTK;
	private JTextField txtLoaiPhong;
	private JTable table;
	private JTextField txtSG;
	private JTextField txtSN;
	private JComboBox<String> comboBox;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	
	@Autowired
	private PhongRepository phongRepository;
	@Autowired
	private LoaiPhongRepository loaiPhongRepository;
	@Autowired
	private HoaDonRepositoryImpl hoadonrepo;

	/**
	 * Create the panel.
	 */
	public QLPhongGUI() {

	}
	
	@PostConstruct
	public void preparePanel() {
		
		setBounds(303, 0, 1599, 1008);
		setBackground(new Color(255,255,255));
		setLayout(null);
		
		JLabel lblTieuDe = new JLabel("QUẢN LÝ PHÒNG");
		lblTieuDe.setBounds(26, 13, 1543, 56);
		lblTieuDe.setForeground(new Color(255, 69, 0));
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTieuDe);
		
		JPanel panelND = new JPanel();
		panelND.setBounds(26, 94, 1543, 914);
		panelND.setBorder(null);
		panelND.setBackground(new Color(255,255,255));
		add(panelND);
		panelND.setLayout(null);
		
		JPanel panelMaPhong = new JPanel();
		panelMaPhong.setBackground(new Color(255,255,255));
		panelMaPhong.setBounds(221, 62, 484, 39);
		panelND.add(panelMaPhong);
		panelMaPhong.setLayout(new BorderLayout(0, 0));
		
		JLabel lblMaPhong = new JLabel("Mã Phòng     ");
		panelMaPhong.add(lblMaPhong, BorderLayout.WEST);
		lblMaPhong.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		txtMaPhong = new JTextField();
		txtMaPhong.setEditable(false);
		panelMaPhong.add(txtMaPhong, BorderLayout.CENTER);
		txtMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMaPhong.setBackground(new Color(255,255,255));
		txtMaPhong.setColumns(10);
		
		JPanel panelGiaPhong = new JPanel();
		panelGiaPhong.setBackground(new Color(255,255,255));
		panelGiaPhong.setBounds(840, 114, 484, 39);
		panelND.add(panelGiaPhong);
		panelGiaPhong.setLayout(new BorderLayout(0, 0));
		
		JLabel lblGiaPhong = new JLabel("Giá Phòng    ");
		panelGiaPhong.add(lblGiaPhong, BorderLayout.WEST);
		lblGiaPhong.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		txtGiaPhong = new JTextField();
		panelGiaPhong.add(txtGiaPhong, BorderLayout.CENTER);
		txtGiaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtGiaPhong.setColumns(10);
		txtGiaPhong.setBackground(new Color(255,255,255));
		
		JPanel panelTT = new JPanel();
		panelTT.setBackground(new Color(255,255,255));
		panelTT.setBounds(221, 114, 484, 39);
		panelND.add(panelTT);
		panelTT.setLayout(new BorderLayout(0, 0));
		
		txtTT = new JTextField();
		txtTT.setEditable(false);
		panelTT.add(txtTT, BorderLayout.CENTER);
		txtTT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTT.setColumns(10);
		txtTT.setBackground(new Color(255,255,255));
		
		JLabel lblTT = new JLabel("Tình Trạng   ");
		panelTT.add(lblTT, BorderLayout.WEST);
		lblTT.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JPanel panelLoaiPhong = new JPanel();
		panelLoaiPhong.setBackground(new Color(255,255,255));
		panelLoaiPhong.setBounds(840, 62, 484, 39);
		panelND.add(panelLoaiPhong);
		panelLoaiPhong.setLayout(new BorderLayout(0, 0));
		
		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setEditable(false);
		panelLoaiPhong.add(txtLoaiPhong, BorderLayout.CENTER);
		txtLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtLoaiPhong.setColumns(10);
		txtLoaiPhong.setBackground(new Color(255,255,255));
		
		JLabel lblLoaiPhong = new JLabel("Loại Phòng   ");
		panelLoaiPhong.add(lblLoaiPhong, BorderLayout.WEST);
		lblLoaiPhong.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JPanel panelTK = new JPanel();
		panelTK.setBackground(new Color(255,255,255));
		panelTK.setBounds(99, 250, 691, 39);
		panelND.add(panelTK);
		panelTK.setLayout(new BorderLayout(0, 0));
		
		txtTK = new JTextField();
		panelTK.add(txtTK, BorderLayout.CENTER);
		txtTK.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTK.setColumns(10);
		
		JLabel lblTK = new JLabel("Tìm Kiếm    ");
		panelTK.add(lblTK, BorderLayout.WEST);
		lblTK.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton btnTK = new JButton("Tìm Kiếm");
		panelTK.add(btnTK, BorderLayout.EAST);
		btnTK.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JButton btnSua = new JButton("Sửa ");
		btnSua.setBounds(1326, 250, 115, 39);
		panelND.add(btnSua);
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(100, 309, 1341, 541);
		panelND.add(scrollPane);
		
		model = new DefaultTableModel(
				new String[] {
					"STT", "Mã Phòng", "Loại Phòng", "Giá Tiền","Số giường", "Số người ở" ,"Trạng Thái","Ghi chú"
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
		
		
		
		JPanel panelSG = new JPanel();
		panelSG.setBackground(new Color(255,255,255));
		panelSG.setBounds(221, 166, 484, 39);
		panelND.add(panelSG);
		panelSG.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSG = new JLabel("Số Giường    ");
		lblSG.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panelSG.add(lblSG, BorderLayout.WEST);
		
		txtSG = new JTextField();
		txtSG.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSG.setColumns(10);
		txtSG.setBackground(new Color(255,255,255));
		panelSG.add(txtSG, BorderLayout.CENTER);
		
		JPanel panelSN = new JPanel();
		panelSN.setBackground(new Color(255,255,255));
		panelSN.setBounds(840, 162, 484, 39);
		panelND.add(panelSN);
		panelSN.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSN = new JLabel("Số Người      ");
		lblSN.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panelSN.add(lblSN, BorderLayout.WEST);
		
		txtSN = new JTextField();
		txtSN.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSN.setColumns(10);
		txtSN.setBackground(new Color(255,255,255));
		panelSN.add(txtSN, BorderLayout.CENTER);
		
		comboBox = new JComboBox<String>();
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"THƯỜNG", "VIP", "GIA ĐÌNH"}));
		comboBox.setSelectedIndex(0);
		comboBox.setMaximumRowCount(3);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		comboBox.setBounds(812, 250, 131, 39);
		panelND.add(comboBox);
		
		JPanel panelTTP = new JPanel();
		panelTTP.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 120, 215)));
		panelTTP.setBounds(98, 21, 1342, 208);
		panelND.add(panelTTP);
		panelTTP.setLayout(null);
		panelTTP.setBackground(new Color(255,255,255));
		
		
		/**
		 * Doc du lieu vao bang luc ban dau
		 */
		resetBang();
		
		/**
		 * Doc du lieu len textfield
		 */
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				txtMaPhong.setText(model.getValueAt(row, 1).toString());
				txtLoaiPhong.setText(model.getValueAt(row, 2).toString());
				txtGiaPhong.setText(model.getValueAt(row, 3).toString());
				txtSG.setText(model.getValueAt(row, 4).toString());
				txtSN.setText(model.getValueAt(row, 5).toString());
				txtTT.setText(model.getValueAt(row, 6).toString());
				
				//Kiem tra trang thai phong
				capnhatPhongTrong();
			}
		});
		
		/**
		 * Loc phong theo loai phong
		 */
		comboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	String lp = "";
		    	lp = comboBox.getSelectedItem().toString();
		        reset();
		       
		        List<Phong> list2 = phongRepository.findAllByTenLoai(getTenLoaiPhongTuCB(lp));
		        docDLVaoBang(list2, lp);
		    }
		});
		
		/**
		 * Tim kiem phong bang button
		 */
		btnTK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				timkiemPhong();
			}
		});
		
		/**
		 * Tim kiem phong bang nut enter
		 */
		txtTK.addKeyListener(new KeyAdapter() {
			@Override
	        public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_ENTER){
	                timkiemPhong();
	            }
	        }
		});
		
		/**
		 * update phong
		 */
		btnSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				if(txtMaPhong.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng");
				}else if(txtGiaPhong.getText().equalsIgnoreCase("")||
						txtSG.getText().equalsIgnoreCase("")||
						txtSN.getText().equalsIgnoreCase("")){
					JOptionPane.showMessageDialog(null, "Vui lòng điển thông tin cập nhật");
					
				}else {
					if(kiemtra() == true) {
						Phong p = phongRepository.findByMaPhong(txtMaPhong.getText());
						p.setSoGiuong(Integer.parseInt(txtSG.getText()));
						p.setSoNguoiToiDa(Integer.parseInt(txtSN.getText()));
						p.setGiaPhong(Double.parseDouble(txtGiaPhong.getText()));
						Phong kq = phongRepository.updatePhong(p, getTenLoaiPhongTuCB(txtLoaiPhong.getText()),true);
						if(kq == null) {
							JOptionPane.showMessageDialog(null, "Cập nhật không thành công");
						}else {
							JOptionPane.showMessageDialog(null, "Cập nhật thành công");
							reset();
						}
					}
				
				}
				
			}
		});
		
	}
	
	//Doc du lieu vao bang
	public void docDLVaoBang(List<Phong> list, String lp) {
		int i =1;
		reset();
		for(Phong p :list) {
			model.addRow(new Object[] {
					i, p.getMaPhong(), lp, p.getGiaPhong(), p.getSoGiuong(), p.getSoNguoiToiDa(), getTT(p.isTrangThai()), ghichuPhongDaDat(p.getMaPhong())
			});
			i++;
		}
		table.setModel(model);
		
	}
	
	//Lay ten loai phong tu cb
	public String getTenLoaiPhongTuCB(String tr) {
		String lp = "GIADINH";
		if(tr.equalsIgnoreCase("THƯỜNG")) {
			lp="THUONG";
		}else if(tr.equalsIgnoreCase("VIP")) {
			lp="VIP";
		}
		return lp;
	}
	
	//Lay ten loai phong tu json
	public String getTenLoaiPhongTuJson(String tr) {
		String lp = "GIA ĐÌNH";
		if(tr.equalsIgnoreCase("THUONG")) {
			lp="THƯỜNG";
		}else if(tr.equalsIgnoreCase("VIP")) {
			lp="VIP";
		}
		return lp;
	}
	
	//Tao trang thai tren bang
	public String getTT(boolean tt) {
		if(tt==true) {
			return "Trống";
		}
		return "Đang ở";
	}
	
	//Xoa bang
	public  void reset()
	{
		model.setRowCount(0);
	}
	
	//Tim kiem phong
	public void timkiemPhong() {
		String key = "";
		key = txtTK.getText();
		if(key.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Nhập mã phòng vào ô tìm kiếm");
		}else {
			Phong p = phongRepository.findByMaPhong(key);
			if(p == null) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy phòng thích hợp");
				txtTK.requestFocus();
			}else {
				reset();
				LoaiPhong lp = loaiPhongRepository.findLoaiByMaPhong(p.getMaPhong());
				model.addRow(new Object[] {
						1, p.getMaPhong(), getTenLoaiPhongTuJson(lp.getTenLoai()) , p.getGiaPhong(), p.getSoGiuong(), p.getSoNguoiToiDa(), getTT(p.isTrangThai()), ghichuPhongDaDat(p.getMaPhong())
				});
			}
		}
	}
	
	//kiem tra bieu thuc chinh quy
	public boolean kiemtra() {
		String giaphong = txtGiaPhong.getText().trim();
		String songuoi = txtSN.getText().trim();
		String sogiuong = txtSG.getText().trim();
		
		if(giaphong.length() > 0) {
			try {
				Double x = Double.parseDouble(giaphong);
				if(x <= 0) {
					JOptionPane.showMessageDialog(null, "Giá phòng không phù hợp");
					return false;
				}
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Giá phòng là số");
				return false;
			}
		} 
		if(songuoi.length() > 0) {
			try {
				int x = Integer.parseInt(songuoi);
				if(x <= 0) {
					JOptionPane.showMessageDialog(null, "Số người không phù hợp");
					return false;
				}
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Số người là số");
				return false;
			}
		}
		if(sogiuong.length() > 0) {
			try {
				int x = Integer.parseInt(sogiuong);
				if(x <= 0) {
					JOptionPane.showMessageDialog(null, "Số giường không phù hợp");
					return false;
				}
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Số giường là số");
				return false;
			}
		} 
		
		return true;
	}
	
	//Khong cap nhat phong dang o
	public void capnhatPhongTrong() {
		int row = table.getSelectedRow();
		String ghichu ="";
		ghichu = model.getValueAt(row, 7).toString();
		if(txtTT.getText().equalsIgnoreCase("Đang ở")||ghichu.equalsIgnoreCase("Phòng đã đặt")) {
			txtSG.setEditable(false);
			txtSN.setEditable(false);
			txtGiaPhong.setEditable(false);
		}else {
			txtSG.setEditable(true);
			txtSN.setEditable(true);
			txtGiaPhong.setEditable(true);
		}
	}
	
	//Doc du lieu vao ban luc ban dau
	public void resetBang() {
		List<Phong> list1 = phongRepository.findAllByTenLoai("THUONG");
		docDLVaoBang(list1, "THƯỜNG");
	}
	
	//ghi chu phong da dat
	public String ghichuPhongDaDat(String maPhong) {
		List<HoaDon> listhd = hoadonrepo.findAllByTrangThaiThanhToan();
		for(HoaDon d : listhd) {
			if(d.getThoiGianNP() == null) {
				for(ChiTietHoaDon cthd : d.getListHoaDon()) {
					if(maPhong.equalsIgnoreCase(cthd.getMaPhong())) {
						return "Phòng đã đặt";
					}
				}
			}
			
		}
		return "";
	}
	
}
