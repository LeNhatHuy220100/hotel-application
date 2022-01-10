package com.hotel.project.gui.home.view;


import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.hotel.project.HotelProjectApplication;
import com.hotel.project.domain.NhanVien;
import com.hotel.project.repository.impl.NhanVienRepositoryImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.annotation.PostConstruct;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
@Component
@Profile("dev")
public class Home extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Image img_hotel = new ImageIcon(Home.class.getResource("/com/hotel/project/gui/home/image/hotel.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
	private Image img_worker = new ImageIcon(Home.class.getResource("/com/hotel/project/gui/home/image/profile.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
	private Image img_DatPhong = new ImageIcon(Home.class.getResource("/com/hotel/project/gui/home/image/receptionist.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_ThanhToan = new ImageIcon(Home.class.getResource("/com/hotel/project/gui/home/image/bill.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_Phong = new ImageIcon(Home.class.getResource("/com/hotel/project/gui/home/image/room-key.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_KhachHang = new ImageIcon(Home.class.getResource("/com/hotel/project/gui/home/image/customer.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_NhanVien = new ImageIcon(Home.class.getResource("/com/hotel/project/gui/home/image/employees.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_DichVu = new ImageIcon(Home.class.getResource("/com/hotel/project/gui/home/image/luggage.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_ThongKe = new ImageIcon(Home.class.getResource("/com/hotel/project/gui/home/image/statistics.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_Help = new ImageIcon(Home.class.getResource("/com/hotel/project/gui/home/image/about.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_About = new ImageIcon(Home.class.getResource("/com/hotel/project/gui/home/image/info.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);private Image img_LogOut = new ImageIcon(Home.class.getResource("/com/hotel/project/gui/home/image/exit.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	@Autowired
	private LoginGUI login;
	private JLabel lblMaNV, lblTenNV;
	private JButton btnNhanVien;
	private JButton btnThongKe;
	private JButton btnphong;
	
	@Autowired
	private QLDatPhongGUI dp;
	@Autowired
	private QLPhongGUI qlphong;
	@Autowired
	private QLDichVuGUI qldichvu ;
	@Autowired
	private QLThanhToanGUI tt;
	@Autowired
	private QLKH_GUI kh;
	@Autowired
	private QLNV nv;
	@Autowired
	private About about ;
	@Autowired
	private Help help;
	@Autowired
	private ThongKe_GUI tk;
	@Autowired
	private QuanLyThongKeGUI quanLyThongKeGUI;
	@Autowired
	private ThongKeTheoNam thongKeTheoNam;
	@Autowired
	private NhanVienRepositoryImpl nhanvienrepo;
	
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Home frame = new Home();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public JButton getBtnphong() {
		return btnphong;
	}

	public void setBtnphong(JButton btnphong) {
		this.btnphong = btnphong;
	}

	public JButton getBtnNhanVien() {
		return btnNhanVien;
	}

	public void setBtnNhanVien(JButton btnNhanVien) {
		this.btnNhanVien = btnNhanVien;
	}

	public JButton getBtnThongKe() {
		return btnThongKe;
	}

	public void setBtnThongKe(JButton btnThongKe) {
		this.btnThongKe = btnThongKe;
	}
	
	public JLabel getLblMaNV() {
		return lblMaNV;
	}

	public void setLblMaNV(JLabel lblMaNV) {
		this.lblMaNV = lblMaNV;
	}

	public JLabel getLblTenNV() {
		return lblTenNV;
	}

	public void setLblTenNV(JLabel lblTenNV) {
		this.lblTenNV = lblTenNV;
	}
	

	/**
	 * Create the frame.
	 */
	public Home() {
		
	}
	
	@PostConstruct
	private void preparePanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("FRESH");
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 303, 1008);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblIconHotel = new JLabel("");
		lblIconHotel.setIcon(new ImageIcon(img_worker));
		lblIconHotel.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconHotel.setBounds(0, 13, 131, 170);
		panel.add(lblIconHotel);
		
		JButton btnDatPhong = new JButton("   QUẢN LÝ ĐẶT PHÒNG");
		btnDatPhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dp.setTrong();
				dp.hienthiPhong();
				menuClicked(dp);
				
			}
		});
		btnDatPhong.setHorizontalAlignment(SwingConstants.LEFT);
		btnDatPhong.setForeground(Color.WHITE);
		btnDatPhong.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnDatPhong.setBackground(SystemColor.textInactiveText);
		btnDatPhong.setBounds(0, 196, 303, 56);
		btnDatPhong.setIcon(new ImageIcon(img_DatPhong));
		panel.add(btnDatPhong);
		
		JButton btnThanhToan = new JButton("   QUẢN LÝ THANH TOÁN");
		btnThanhToan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(tt);
			}
		});
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThanhToan.setHorizontalAlignment(SwingConstants.LEFT);
		btnThanhToan.setForeground(Color.WHITE);
		btnThanhToan.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnThanhToan.setBackground(SystemColor.textInactiveText);
		btnThanhToan.setBounds(0, 253, 303, 56);
		btnThanhToan.setIcon(new ImageIcon(img_ThanhToan));
		panel.add(btnThanhToan);
		
		JButton btnDichVu = new JButton("   QUẢN LÝ DỊCH VỤ");
		btnDichVu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				menuClicked(qldichvu);
			}
		});
		btnDichVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDichVu.setForeground(Color.WHITE);
		btnDichVu.setHorizontalAlignment(SwingConstants.LEFT);
		btnDichVu.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnDichVu.setBackground(SystemColor.textInactiveText);
		btnDichVu.setBounds(0, 310, 303, 56);
		btnDichVu.setIcon(new ImageIcon(img_DichVu));
		panel.add(btnDichVu);
		
		JButton btnKhachHang = new JButton("   QUẢN LÝ KHÁCH HÀNG");
		btnKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				menuClicked(kh);
			}
		});
		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnKhachHang.setForeground(Color.WHITE);
		btnKhachHang.setBackground(SystemColor.textInactiveText);
		btnKhachHang.setBounds(0, 367, 303, 56);
		btnKhachHang.setIcon(new ImageIcon(img_KhachHang));
		panel.add(btnKhachHang);
		
		btnphong = new JButton("   QUẢN LÝ PHÒNG");
		btnphong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				menuClicked(qlphong);
				qlphong.resetBang();
			}
		});
		btnphong.setHorizontalAlignment(SwingConstants.LEFT);
		btnphong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnphong.setForeground(Color.WHITE);
		btnphong.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnphong.setBackground(SystemColor.textInactiveText);
		btnphong.setBounds(0, 424, 303, 56);
		btnphong.setIcon(new ImageIcon(img_Phong));
		panel.add(btnphong);
		
		btnNhanVien = new JButton("   QUẢN LÝ NHÂN VIÊN");
		btnNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(nv);
			}
		});
		btnNhanVien.setForeground(Color.WHITE);
		btnNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNhanVien.setBackground(SystemColor.textInactiveText);
		btnNhanVien.setBounds(0, 481, 303, 56);
		btnNhanVien.setIcon(new ImageIcon(img_NhanVien));
		panel.add(btnNhanVien);
		
		btnThongKe = new JButton("   THỐNG KÊ DOANH THU");
		btnThongKe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//menuClicked(tk);
				menuClicked(quanLyThongKeGUI);
				//menuClicked(thongKeTheoNam);
			}
		});
		btnThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		btnThongKe.setForeground(Color.WHITE);
		btnThongKe.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnThongKe.setBackground(SystemColor.textInactiveText);
		btnThongKe.setBounds(0, 538,303, 56);
		btnThongKe.setIcon(new ImageIcon(img_ThongKe));
		panel.add(btnThongKe);
		
		JButton btnDamgXuat = new JButton("   ĐĂNG XUẤT");
		btnDamgXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất?") == 0) {
					dispose();
					
					ApplicationContext app=new SpringApplicationBuilder(HotelProjectApplication.class)
							.headless(true)
							.web(WebApplicationType.NONE)
							.headless(false)
							.profiles("dev")
							.run();
					
					SwingUtilities.invokeLater(() -> {
			              LoginGUI login = app.getBean(LoginGUI.class);
			              login.setVisible(true);
			          
			        });
					
					
				}
			}
		});
		btnDamgXuat.setHorizontalAlignment(SwingConstants.LEFT);
		btnDamgXuat.setForeground(Color.WHITE);
		btnDamgXuat.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnDamgXuat.setBackground(SystemColor.textInactiveText);
		btnDamgXuat.setBounds(0, 709,303, 56);
		btnDamgXuat.setIcon(new ImageIcon(img_LogOut));
		panel.add(btnDamgXuat);
		
		JButton btnHelp = new JButton("   HELP");
		btnHelp.setHorizontalAlignment(SwingConstants.LEFT);
		btnHelp.setForeground(Color.WHITE);
		btnHelp.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnHelp.setBackground(SystemColor.textInactiveText);
		btnHelp.setBounds(0, 595, 303, 56);
		panel.add(btnHelp);
		btnHelp.setIcon(new ImageIcon(img_Help));
		btnHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				help.setVisible(true);
			}
		});
		
		JButton btnAbout = new JButton("   ABOUT");
		btnAbout.setHorizontalAlignment(SwingConstants.LEFT);
		btnAbout.setForeground(Color.WHITE);
		btnAbout.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnAbout.setBackground(SystemColor.textInactiveText);
		btnAbout.setBounds(0, 652, 303, 56);
		panel.add(btnAbout);
		btnAbout.setIcon(new ImageIcon(img_About));
		btnAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				about.setVisible(true);
			}
		});
		
		
		
		lblMaNV = new JLabel("");
		lblMaNV.setForeground(SystemColor.info);
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaNV.setBounds(143, 53, 160, 38);
		panel.add(lblMaNV);
		
		lblTenNV = new JLabel("");
		lblTenNV.setForeground(SystemColor.info);
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenNV.setBounds(143, 107, 160, 38);
		panel.add(lblTenNV);
		
		
		contentPane.add(dp);
		contentPane.add(tt);
		contentPane.add(qlphong);
		contentPane.add(qldichvu);
		//contentPane.add(tk);
		contentPane.add(kh);
		contentPane.add(quanLyThongKeGUI);
		//contentPane.add(thongKeTheoNam);
		contentPane.add(nv);
	
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		menuClicked(dp);
		NhanVien nhanvien = nhanvienrepo.findByMaNhanVien(lblMaNV.getText());
		System.out.println(nhanvien);
	}
	
	
	public void menuClicked(JPanel pane) {
		dp.setVisible(false);
		tt.setVisible(false);
		qlphong.setVisible(false);
		qldichvu.setVisible(false);
		//tk.setVisible(false);
		kh.setVisible(false);
		nv.setVisible(false);
		quanLyThongKeGUI.setVisible(false);
		//thongKeTheoNam.setVisible(false);
		pane.setVisible(true);
	}
}
