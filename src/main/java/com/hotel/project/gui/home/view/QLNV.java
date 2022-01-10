package com.hotel.project.gui.home.view;

import java.awt.Font;
import java.awt.Image;

import javax.annotation.PostConstruct;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotel.project.domain.NhanVien;
import com.hotel.project.domain.TaiKhoan;
import com.hotel.project.repository.NhanVienRepository;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;

@Component
public class QLNV extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtCanCuoc;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTextField txtTimKiem;
	private JTable table;
	
	@Autowired
	private NhanVienRepository nhanVienRepository;
	private DefaultTableModel model;
	private List<NhanVien> listNV;
	private JRadioButton rdbtnNam;
	private JRadioButton rdbtnN;
	private JComboBox cbxNgay;
	private JComboBox cbxNam;
	private JComboBox cbxThang;
	private JComboBox cbxchucVu;
	private JRadioButton rdbtnTheoCnCc;
	private JRadioButton rdbtnTheoHTn;
	private Image img_help = new ImageIcon(Home.class.getResource("/com/hotel/project/gui/home/image/unnamed.jpg")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private JButton btnLoad;
	private JButton btnHelp;
	private DateTimeFormatter formatDay = DateTimeFormatter.ofPattern("dd-LL-yyyy");
	
	/**
	 * Create the panel.
	 */
	@PostConstruct
	public void preparePanelNV() {
		setBounds(303, 0, 1599, 1008);
		setBackground(new Color(255,255,255));		
		setLayout(null);
		
		JLabel lblQunLNhn = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblQunLNhn.setForeground(Color.RED);
		lblQunLNhn.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLNhn.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblQunLNhn.setBounds(0, 0, 1599, 59);
		this.add(lblQunLNhn);
		
		JLabel lblMNv = new JLabel("Mã NV:");
		lblMNv.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMNv.setBounds(82, 142, 111, 31);
		add(lblMNv);
		
		JLabel lblTnNv = new JLabel("Tên NV:");
		lblTnNv.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTnNv.setBounds(82, 184, 109, 40);
		add(lblTnNv);
		
		JLabel lblNewLabel = new JLabel("Giới tính:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(554, 184, 111, 38);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ngày sinh:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(554, 233, 93, 40);
		add(lblNewLabel_1);
		
		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnNam.setBounds(679, 192, 83, 23);
		rdbtnNam.setBackground(new Color(255,255,255));
		rdbtnNam.setSelected(true);
		add(rdbtnNam);
		
		rdbtnN = new JRadioButton("Nữ");
		rdbtnN.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnN.setBounds(764, 192, 99, 23);
		rdbtnN.setBackground(new Color(255,255,255));
		ButtonGroup group= new ButtonGroup();
		group.add(rdbtnN);
		group.add(rdbtnNam);
		add(rdbtnNam);
		add(rdbtnN);
		
		cbxNgay = new JComboBox();
		cbxNgay.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbxNgay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cbxNgay.setBounds(646, 233, 43, 31);
		add(cbxNgay);
		
		cbxNam = new JComboBox();
		cbxNam.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbxNam.setModel(new DefaultComboBoxModel(new String[] {"1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005"}));
		cbxNam.setBounds(860, 233, 62, 31);
		add(cbxNam);
		cbxNam.setSelectedItem("2000");
		
		cbxThang = new JComboBox();
		cbxThang.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbxThang.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cbxThang.setBounds(753, 233, 43, 31);
		add(cbxThang);
		
		JLabel lblThng = new JLabel("Tháng");
		lblThng.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblThng.setBounds(693, 233, 54, 40);
		add(lblThng);
		
		JLabel lblNm = new JLabel("Năm");
		lblNm.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNm.setBounds(806, 233, 40, 40);
		add(lblNm);
		
		JLabel lblNewLabel_2 = new JLabel("Số ĐT:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(554, 139, 99, 35);
		add(lblNewLabel_2);
		
		JLabel lblSCmnd = new JLabel("Căn cước:");
		lblSCmnd.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSCmnd.setBounds(82, 238, 129, 31);
		add(lblSCmnd);
		
		JLabel lblChcV = new JLabel("Chức vụ:");
		lblChcV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblChcV.setBounds(1039, 184, 119, 41);
		add(lblChcV);
		
		JLabel lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblaCh.setBounds(1039, 139, 99, 35);
		add(lblaCh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 335, 1540, 660);
		add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel(
				new String[] {
						"STT", "M\u00E3 NV", "T\u00EAn NV", "Gi\u1EDBi t\u00EDnh", "Ng\u00E0y sinh", "S\u1ED1 \u0110T", "Căn cước", "Ch\u1EE9c v\u1EE5", "\u0110\u1ECBa ch\u1EC9"
				}, 0){
		    public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		  };
		
		table.setModel(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(32,136,203));
		table.getTableHeader().setForeground(new Color(255,255,255));
		table.getTableHeader().setPreferredSize(new Dimension(scrollPane.getWidth(), 40));
		table.setRowHeight(40);
		table.setSelectionBackground(new Color(232,57,95));
		table.setSelectionForeground(new Color(255,255,255));
		table.setBackground(new Color(255,255,255));
		scrollPane.setViewportView(table);
		
		
		JButton btnThm = new JButton("Thêm");
		btnThm.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnThm.setBounds(1039, 234, 73, 40);
		add(btnThm);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXa.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnXa.setBounds(1153, 234, 75, 40);
		add(btnXa);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnSa.setBounds(1272, 234, 73, 40);
		add(btnSa);
		
//		JLabel lblThngTinNhn = new JLabel("Thông tin Nhân viên");
//		lblThngTinNhn.setFont(new Font("Times New Roman", Font.PLAIN, 25));
//		lblThngTinNhn.setHorizontalAlignment(SwingConstants.CENTER);
//		lblThngTinNhn.setBounds(0, 105, 367, 34);
//		add(lblThngTinNhn);
		
		JButton btnXaR = new JButton("Xóa Rỗng");
		btnXaR.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnXaR.setBounds(1383, 234, 101, 40);
		add(btnXaR);
		
		
		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaNV.setBounds(173, 139, 277, 31);
		add(txtMaNV);
		txtMaNV.setColumns(10);
		
		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(173, 186, 277, 31);
		add(txtTenNV);
		
		txtCanCuoc = new JTextField();
		txtCanCuoc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCanCuoc.setColumns(10);
		txtCanCuoc.setBounds(173, 235, 277, 31);
		add(txtCanCuoc);
		
		cbxchucVu = new JComboBox();
		cbxchucVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cbxchucVu.setModel(new DefaultComboBoxModel(new String[] {"Nhân viên", "Quản lý"}));
		cbxchucVu.setBounds(1130, 184, 277, 33);
		add(cbxchucVu);
//		txtChucVu = new JTextField();
//		txtChucVu.setFont(new Font("Tahoma", Font.PLAIN, 22));
//		txtChucVu.setColumns(10);
//		txtChucVu.setBounds(101, 454, 227, 31);
//		add(txtChucVu);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(1130, 136, 277, 31);
		add(txtDiaChi);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSDT.setColumns(10);
		txtSDT.setBounds(645, 139, 277, 31);
		add(txtSDT);
		
		JLabel lblTmKimNv = new JLabel("Tìm kiếm NV:");
		lblTmKimNv.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTmKimNv.setBounds(454, 57, 122, 34);
		add(lblTmKimNv);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(586, 57, 173, 34);
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(txtTimKiem);
		
		rdbtnTheoCnCc = new JRadioButton("Theo căn cước");
		rdbtnTheoCnCc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnTheoCnCc.setBounds(765, 58, 161, 31);
		rdbtnTheoCnCc.setBackground(new Color(255,255,255));
		rdbtnTheoCnCc.setSelected(true);
		
		rdbtnTheoHTn = new JRadioButton("Theo họ tên");
		rdbtnTheoHTn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnTheoHTn.setBounds(928, 58, 142, 31);
		rdbtnTheoHTn.setBackground(new Color(255,255,255));

		
		ButtonGroup group1= new ButtonGroup();
		group1.add(rdbtnTheoCnCc);
		group1.add(rdbtnTheoHTn);
		add(rdbtnTheoCnCc);
		add(rdbtnTheoHTn);
		
		JButton btnTm = new JButton("Tìm");
		btnTm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTm.setBounds(1081, 57, 93, 33);
		add(btnTm);
		
		btnLoad = new JButton("Load\r\n");
		btnLoad.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnLoad.setBounds(1474, 303, 73, 31);
		add(btnLoad);
		
		btnHelp = new JButton("");
		btnHelp.setIcon(new ImageIcon(img_help));
		btnHelp.setBounds(1566, 0, 33, 31);
		add(btnHelp);
		
		JPanel panelTTP = new JPanel();
		panelTTP.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin Nhân viên", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 120, 215)));
		panelTTP.setBounds(28, 96, 1523, 206);
		add(panelTTP);
		panelTTP.setLayout(null);
		panelTTP.setBackground(new Color(255,255,255));
		
		/**
		 * Doc du lieu vao bang
		 */
		
		docDLNVVaoBang();
		
		/**
		 * Doc du lieu len textfield
		 */
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				txtMaNV.setText(model.getValueAt(row, 1).toString());
				txtTenNV.setText(model.getValueAt(row, 2).toString());
				txtCanCuoc.setText(model.getValueAt(row, 6).toString());
				cbxchucVu.setSelectedItem(model.getValueAt(row, 7).toString());
				txtDiaChi.setText(model.getValueAt(row, 8).toString());
				txtSDT.setText(model.getValueAt(row, 5).toString());
				if(model.getValueAt(row, 3).toString()=="Nam")
					rdbtnNam.setSelected(true);
				else
					rdbtnN.setSelected(true);
				LocalDate ns=  (LocalDate) model.getValueAt(row, 4);
				int ngay= ns.getDayOfMonth();
				int thang= ns.getMonthValue();
				int nam= ns.getYear();
				String ng=Integer.toString(ngay);
				String th=Integer.toString(thang);
				String na=Integer.toString(nam);
				cbxNgay.setSelectedItem(ng);
				cbxNam.setSelectedItem(na);
				cbxThang.setSelectedItem(th);
			}
		});
		
		btnThm.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				themNV();
				
			}
		});
		
		btnXa.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				xoaNV();
			}
		});
		
		btnSa.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				int t= table.getSelectedRow();
				if(t==-1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng cần sửa !!!!");
				}
				else {
					int r= JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn sửa không ???","Sửa",JOptionPane.YES_NO_OPTION);
					if(r==JOptionPane.YES_OPTION) {
						//XÃ³a Array List
						if(ktRegex()) {
							NhanVien nv= new NhanVien(model.getValueAt(t, 2).toString(), txtTenNV.getText().trim(), txtSDT.getText(), cbxchucVu.getSelectedItem().toString(), txtCanCuoc.getText(), getGTTuDuLieuNhap(), setNgaySinh(), txtDiaChi.getText().trim());
							nv.setTaiKhoan(new TaiKhoan(model.getValueAt(t, 2).toString(), setMatKhau(), getChucVu(cbxchucVu.getSelectedItem().toString())));
							nhanVienRepository.updateNV(nv);
							
							model.setValueAt(txtTenNV.getText().trim(), t, 2);
							model.setValueAt(getGTNV(getGTTuDuLieuNhap()).toString(), t, 3);
							model.setValueAt(setNgaySinh(), t, 4);
							model.setValueAt(txtSDT.getText(), t, 5);
							model.setValueAt(cbxchucVu.getSelectedItem().toString(), t, 7);
							model.setValueAt(txtDiaChi.getText().trim(), t, 8);
							JOptionPane.showMessageDialog(null, "Sửa thành công !!!!");
						}
				}
			}}
		});
		
		btnXaR.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				xoaTrang();

			}
		});
		
		btnTm.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				timKiem();
			}
		});
		
		btnLoad.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				docDLNVVaoBang();
			}
		});
		
		btnHelp.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Tài khoản là Mã NV, Mật khẩu là ngày tháng năm sinh !! VD: 02-04-2000 -> MK:242000 ");
			}
		});
		
		txtTimKiem.addKeyListener((KeyListener) new KeyAdapter() {

			  public void keyPressed(KeyEvent e) {
			    if (e.getKeyCode()==KeyEvent.VK_ENTER){
			    	timKiem();
			    }
			  }
			});
		
		cbxchucVu.addKeyListener((KeyListener) new KeyAdapter() {

			  public void keyPressed(KeyEvent e) {
			    if (e.getKeyCode()==KeyEvent.VK_ENTER){
			    	themNV();
			    }
			  }
			});
		
		txtMaNV.addKeyListener((KeyListener) new KeyAdapter() {

			  public void keyPressed(KeyEvent e) {
			    if (e.getKeyCode()==KeyEvent.VK_ENTER){
			    	themNV();
			    }
			  }
			});
		
		txtTenNV.addKeyListener((KeyListener) new KeyAdapter() {

			  public void keyPressed(KeyEvent e) {
			    if (e.getKeyCode()==KeyEvent.VK_ENTER){
			    	themNV();
			    }
			  }
			});
		
		txtCanCuoc.addKeyListener((KeyListener) new KeyAdapter() {

			  public void keyPressed(KeyEvent e) {
			    if (e.getKeyCode()==KeyEvent.VK_ENTER){
			    	themNV();
			    }
			  }
			});
		
		txtSDT.addKeyListener((KeyListener) new KeyAdapter() {

			  public void keyPressed(KeyEvent e) {
			    if (e.getKeyCode()==KeyEvent.VK_ENTER){
			    	themNV();
			    }
			  }
			});
		
		txtDiaChi.addKeyListener((KeyListener) new KeyAdapter() {

			  public void keyPressed(KeyEvent e) {
			    if (e.getKeyCode()==KeyEvent.VK_ENTER){
			    	themNV();
			    }
			  }
			});
		
		cbxNgay.addKeyListener((KeyListener) new KeyAdapter() {

			  public void keyPressed(KeyEvent e) {
			    if (e.getKeyCode()==KeyEvent.VK_ENTER){
			    	themNV();
			    }
			  }
			});
		
		cbxThang.addKeyListener((KeyListener) new KeyAdapter() {

			  public void keyPressed(KeyEvent e) {
			    if (e.getKeyCode()==KeyEvent.VK_ENTER){
			    	themNV();
			    }
			  }
			});
		
		cbxNam.addKeyListener((KeyListener) new KeyAdapter() {

			  public void keyPressed(KeyEvent e) {
			    if (e.getKeyCode()==KeyEvent.VK_ENTER){
			    	themNV();
			    }
			  }
			});
		
		rdbtnN.addKeyListener((KeyListener) new KeyAdapter() {

			  public void keyPressed(KeyEvent e) {
			    if (e.getKeyCode()==KeyEvent.VK_ENTER){
			    	themNV();
			    }
			  }
			});
		rdbtnNam.addKeyListener((KeyListener) new KeyAdapter() {

			  public void keyPressed(KeyEvent e) {
			    if (e.getKeyCode()==KeyEvent.VK_ENTER){
			    	themNV();
			    }
			  }
			});
		
		rdbtnTheoCnCc.addKeyListener((KeyListener) new KeyAdapter() {

			  public void keyPressed(KeyEvent e) {
			    if (e.getKeyCode()==KeyEvent.VK_ENTER){
			    	timKiem();
			    }
			  }
			});
		
		rdbtnTheoHTn.addKeyListener((KeyListener) new KeyAdapter() {

			  public void keyPressed(KeyEvent e) {
			    if (e.getKeyCode()==KeyEvent.VK_ENTER){
			    	timKiem();
			    }
			  }
			});
		
		table.addKeyListener((KeyListener) new KeyAdapter() {

			  public void keyPressed(KeyEvent e) {
			    if (e.getKeyCode()==KeyEvent.VK_DELETE){
			    	xoaNV();
			    }
			  }
			});
		
		txtMaNV.addKeyListener((KeyListener) new KeyAdapter() {

			  public void keyPressed(KeyEvent e) {
			    if (e.getKeyCode()==KeyEvent.VK_TAB){
			    	txtTenNV.requestFocus();
			    }
			  }
			});
		
		txtTimKiem.addKeyListener((KeyListener) new KeyAdapter() {

			  public void keyPressed(KeyEvent e) {
			    if (e.getKeyCode()==KeyEvent.VK_F5){
			    	xoaHetModelTable();
			    	txtTimKiem.setText("");
			    	docDLNVVaoBang();
			    }
			  }
			});
		
		txtCanCuoc.addKeyListener((KeyListener) new KeyAdapter() {

			  public void keyPressed(KeyEvent e) {
			    if (e.getKeyCode()==KeyEvent.VK_F2){
			    	updateCC();
			    }
			  }
			});
	}
	
	public void themNV() {
		if(ktKHCoChua()&&ktMaNV()&&ktRegex()) {
			NhanVien nv= new NhanVien(txtMaNV.getText(), txtTenNV.getText().trim(), txtSDT.getText(), cbxchucVu.getSelectedItem().toString(), txtCanCuoc.getText(), getGTTuDuLieuNhap(), setNgaySinh(), txtDiaChi.getText().trim());
			nv.setTaiKhoan(new TaiKhoan(txtMaNV.getText(), setMatKhau(), getChucVu(cbxchucVu.getSelectedItem().toString())));
			nhanVienRepository.add(nv);
			model.addRow(new Object[] {
					model.getRowCount()+1,nv.getMaNhanVien(), nv.getTenNhanVien(), getGTNV(nv.isGioiTinh()),nv.getNgaySinh(),nv.getSdt(),nv.getCanCuoc(),nv.getChucVu(),nv.getDiaChi()
			});
			xoaTrang();
		}
	}
	
	public void timKiem() {
		if(regexTimKiem()) {
			if(rdbtnTheoHTn.isSelected()) {
				List<NhanVien> nvs=nhanVienRepository.findByTenNhanVien(txtTimKiem.getText());
				if(nvs.size()!=0) {
					xoaHetModelTable();
					int i=1;
					for (NhanVien nv : nvs) {
						model.addRow(new Object[] {
								i++,nv.getMaNhanVien(), nv.getTenNhanVien(), getGTNV(nv.isGioiTinh()),nv.getNgaySinh(),nv.getSdt(),nv.getCanCuoc(),nv.getChucVu(),nv.getDiaChi()
						});
					}
				}else {
					showMessage("Không tìm thấy !!!!", txtTimKiem);
				}
			}
			else {
				NhanVien nv=nhanVienRepository.findBySoCanCuoc(txtTimKiem.getText());
				if(nv!=null) {
					xoaHetModelTable();
					model.addRow(new Object[] {
							1,nv.getMaNhanVien(), nv.getTenNhanVien(), getGTNV(nv.isGioiTinh()),nv.getNgaySinh(),nv.getSdt(),nv.getCanCuoc(),nv.getChucVu(),nv.getDiaChi()
					});
				}else
					showMessage("Không tìm thấy !!!!", txtTimKiem);
			}
		}
	}
	
	public void xoaNV() {
//		int t= table.getSelectedRow();
//		if(t==-1)
//			JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng cần xóa !!!!");
//		else {
//			int r= JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa không ???","Xóa",JOptionPane.YES_NO_OPTION);
//			if(r==JOptionPane.YES_OPTION) {
//				//XÃ³a Array List
//				String ma= txtMaNV.getText();
//				nhanVienRepository.xoaNVTheoMa(ma);
//				docDLNVVaoBang();
//				xoaTrang();
//	}}
		
		int[] rows = table.getSelectedRows();
		Arrays.sort(rows);//  tra ve mang cua mot tap hang da duoc chon
        if (rows.length == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng cần xóa !!!!");
        } else {
        	int r= JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa không ???","Xóa",JOptionPane.YES_NO_OPTION);
			if(r==JOptionPane.YES_OPTION) {
				for (int i = rows.length - 1; i >= 0; i--) {
					nhanVienRepository.xoaNVTheoMa(table.getModel().getValueAt(rows[i], 1).toString());
					xoaHetModelTable();
					xoaTrang();
					docDLNVVaoBang();
				}
                
                table.setModel(model);
			}
        }
	}
	
	public void updateCC() {
		int t= table.getSelectedRow();
		if(t==-1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng cần sửa !!!!");
		}
		else {
			int r= JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn sửa không ???","Sửa",JOptionPane.YES_NO_OPTION);
			if(r==JOptionPane.YES_OPTION) {
				//XÃ³a Array List
				if(ktRegex()) {
					String ccm= txtCanCuoc.getText();
					String ccc= model.getValueAt(t, 6).toString();
					nhanVienRepository.updateCC(ccm,ccc);
					
					model.setValueAt(txtCanCuoc.getText(), t, 6);
					JOptionPane.showMessageDialog(null, "Sửa thành công !!!!");
				}
			}}
	}
	
	public void docDLNVVaoBang() {
//		listNV= nhanVienRepository.findAllNV();
//		xoaHetModelTable();
//		int i =1;
//		for (NhanVien nv : listNV) {
//			model.addRow(new Object[] {
//					i,nv.getMaNhanVien(), nv.getTenNhanVien(), getGTNV(nv.isGioiTinh()),nv.getNgaySinh(),nv.getSdt(),nv.getCanCuoc(),nv.getChucVu(),nv.getDiaChi()
//			});
//			i++;
//		}
		
//		listNV=nhanVienRepository.findAllNV();
//		ArrayList<NhanVien> nvs = new ArrayList<NhanVien>();
//		for (NhanVien nv : listNV) {
//			nvs.add(nv);
//		}
//		int t=model.getRowCount();
//		if(t<nvs.size()) {
//			for(int i=t;i<t+20;i++) {
//				if(i<nvs.size()) {
//					model.addRow(new Object[] {
//							i+1,nvs.get(i).getMaNhanVien(), nvs.get(i).getTenNhanVien(), getGTNV(nvs.get(i).isGioiTinh()),nvs.get(i).getNgaySinh(),nvs.get(i).getSdt(),nvs.get(i).getCanCuoc(),nvs.get(i).getChucVu(),nvs.get(i).getDiaChi()
//					});
//
//				}
//			}
//		}
		
		listNV=nhanVienRepository.findAllNV();
		ArrayList<NhanVien> nvs = new ArrayList<NhanVien>();
		for (NhanVien nv : listNV) {
			nvs.add(nv);
		}
		int t=model.getRowCount();
		if(t<nvs.size()) {
			for(int i=t;i<t+20;i++) {
				if(i<nvs.size()) {
					if(ktraNVDaCoTrongTable(nvs.get(i), t)) {
						int m=model.getRowCount();
						model.addRow(new Object[] {
								i+1,nvs.get(i).getMaNhanVien(), nvs.get(i).getTenNhanVien(), getGTNV(nvs.get(i).isGioiTinh()),nvs.get(i).getNgaySinh(),nvs.get(i).getSdt(),nvs.get(i).getCanCuoc(),nvs.get(i).getChucVu(),nvs.get(i).getDiaChi()
						});
					}
				}
			}
		}
	
	}
	
	public boolean ktraNVDaCoTrongTable(NhanVien n, int t) {
		for (int i = 0; i < t; i++) {
			if(n.getMaNhanVien().equals(model.getValueAt(i, 2).toString())) {
				return false;
			}
		}
		return true;
	
}
	
	public LocalDate setNgaySinh() {
		int ng= Integer.parseInt((String) cbxNgay.getSelectedItem());
		int th= Integer.parseInt((String) cbxThang.getSelectedItem());
		int na= Integer.parseInt((String) cbxNam.getSelectedItem());
		LocalDate ns= LocalDate.of(na, th, ng);
		return ns;
	}
	
	public String setMatKhau() {
		int ng= Integer.parseInt((String) cbxNgay.getSelectedItem());
		int th= Integer.parseInt((String) cbxThang.getSelectedItem());
		int na= Integer.parseInt((String) cbxNam.getSelectedItem());
		String mk=""+ng+""+th+""+na;
		return mk;
	}
	
	public boolean getChucVu(String cv) {
		if(cv.equals("Quản lý"))
			return true;
		return false;
	}
	
	public String getGTNV(boolean gt) {
		if(gt==true) {
			return "Nam";
		}
		return "Nữ";
	}
	
	
	public boolean getGTTuDuLieuNhap() {
		if(rdbtnNam.isSelected())
			return true;
		return false;
	}
	
	public void xoaHetModelTable() {
		while (model.getRowCount()>0)
			model.removeRow(0);
	}
	
	public void xoaTrang() {
		txtMaNV.setText("");
		txtTenNV.setText("");
		txtDiaChi.setText("");
		txtSDT.setText("");
		txtCanCuoc.setText("");
		cbxchucVu.setSelectedItem("Nhân viên");
		cbxNgay.setSelectedItem("1");
		cbxThang.setSelectedItem("1");
		cbxNam.setSelectedItem("2000");
	}
	
	public boolean ktMaNV() {
		String ma=txtMaNV.getText();
		List<NhanVien> nvs=nhanVienRepository.findAllNV();
		for (NhanVien nhanVien : nvs) {
			if(nhanVien.getMaNhanVien().equals(ma)) {
				showMessage("Mã nhân viên bị trùng vui lòng nhập mã khác !!!!", txtMaNV);
				return false;
			}	
		}
		return true;
	}
	
	public boolean ktKHCoChua() {
		String scc=txtCanCuoc.getText();
		List<NhanVien> nvs=nhanVienRepository.findAllNV();
		for (NhanVien nv : nvs) {
			if(nv.getCanCuoc().equals(scc)) {
				showMessage("Khách hàng đã có !!!!", txtTenNV);
				xoaTrang();
				return false;
			}	
		}
		return true;
	}
	
	private void showMessage(String message, JTextField txt) {
		txt.requestFocus();
		JOptionPane.showMessageDialog(null, message);
	}
	public boolean ktNamNhuan() {
		int year= Integer.parseInt((String) cbxNam.getSelectedItem());
		// Nếu số năm chia hết cho 400,
	    // đó là 1 năm nhuận
	    if (year % 400 == 0) 
	        return true; 
	  
	    // Nếu số năm chia hết cho 4 và không chia hết cho 100,
	    // đó không là 1 năm nhuận
	    if (year % 4 == 0 && year % 100 != 0) 
	        return true;
	 
	    // trường hợp còn lại 
	    // không phải năm nhuận
	    return false; 
	}
	public boolean ktRegex() {
		if(!(txtMaNV.getText().length()>0 && txtMaNV.getText().matches("[N][V]\\d{3}"))){
			showMessage("Error: Ma NV không để trống và chứa khoảng trắng, bắt đầu bằng NV theo sau là 3 ký số !!!", txtMaNV);
			return false;
		}
		if(!(txtTenNV.getText().length()>0 && txtTenNV.getText().matches("( *[a-zA-Z0-9'Ạ-ỹÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+ *)+"))){
			showMessage("Error: Tên NV không để rỗng, là chữ thường in hoa, số bất kỳ, ký tự ', chữ có dấu, khoảng trắng, Không có có tự đặc biệt trừ dấu ' !!!", txtTenNV);
			return false;
		}
		int ng= Integer.parseInt((String) cbxNgay.getSelectedItem());
		int th= Integer.parseInt((String) cbxThang.getSelectedItem());
		int year= Integer.parseInt((String) cbxNam.getSelectedItem());
		if((ng==30&&th==2) || (ng==31&&th==2)) {
			JOptionPane.showMessageDialog(null, "Tháng 2 không có ngày 30,31 !!!");		
			return false;
		}
		if(ktNamNhuan()==false) {
			if(ng==29&&th==2) {
				JOptionPane.showMessageDialog(null, "Năm "+year+" không nhuận nên ko có ngày 29/2 !!!!");
				return false;
			}
		}
		if((ng==31&&th==4) || (ng==31&&th==6) || (ng==31&&th==9) || (ng==31&&th==11)) {
			JOptionPane.showMessageDialog(null, "Tháng "+th+" không có ngày 31 !!!!");
			return false;
		}
		if(!(txtDiaChi.getText().length()>0))
		{
		showMessage("Error: Địa chỉ không để trống !!!", txtDiaChi);
		return false;
		}
		if(!(txtCanCuoc.getText().length()>0 && txtCanCuoc.getText().matches("[0-9]{12}"))){
			showMessage("Error: Số căn cước không trống và gồm 12 ký tự số !!!", txtCanCuoc);
			return false;
		}
		if(!(txtSDT.getText().length()>0 && txtSDT.getText().matches("[(+84)0][0-9]{9}"))){
		showMessage("Error: Số điện thoại gồm 10 số và bắt đầu bằng : +84 .... hoặc 0.... !!!", txtSDT);
		return false;
		}
		int na= Integer.parseInt((String) cbxNam.getSelectedItem());
		int tuoi=LocalDate.now().getYear()-na;
		if(tuoi<=18) {
			JOptionPane.showMessageDialog(null,"Tuổi phải trên 18 tuổi !!!!");
			return false;
		}
		return true;
	}
	
	public boolean regexTimKiem() {
		if(!(txtTimKiem.getText().length()>0 && txtTimKiem.getText().matches("( *[a-zA-Z0-9'Ạ-ỹÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+ *)+"))){
			showMessage("Error: Không để rỗng, là chữ thường in hoa, số bất kỳ, ký tự ', chữ có dấu, khoảng trắng, Không có có tự đặc biệt trừ dấu ' !!!", txtTimKiem);
			return false;
		}
		return true;
	}
	
}
