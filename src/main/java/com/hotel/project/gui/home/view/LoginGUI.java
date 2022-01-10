package com.hotel.project.gui.home.view;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.monitor.BtreeIndexCounters;
import org.springframework.stereotype.Component;

import com.hotel.project.HotelProjectApplication;
import com.hotel.project.domain.NhanVien;
import com.hotel.project.repository.NhanVienRepository;

import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

import javax.annotation.PostConstruct;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPasswordField;

@Component
@Profile("dev")
public class LoginGUI extends JFrame{

//	private JFrame frameLogin;
	private JTextField textFieldDN;
	private int xx, xy;
	private JPasswordField passwordField;
	private NhanVien nhanvien = new NhanVien();
	private Image img_logo = new ImageIcon(Home.class.getResource("/com/hotel/project/gui/home/image/logo.jpg")).getImage().getScaledInstance(250, 160, Image.SCALE_SMOOTH);
	@Autowired
	private NhanVienRepository nhanVienRepository;
	
	
	

//	/**
//	 * Launch the application.
//	 */
//	
//	public JFrame getFrameLogin() {
//		return frameLogin;
//	}
//
//	public void setFrameLogin(JFrame frameLogin) {
//		this.frameLogin = frameLogin;
//	}

	public NhanVien getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(NhanVien nhanvien) {
		this.nhanvien = nhanvien;
	}

	/**
	 * Create the application.
	 */
//	public LoginGUI() {
//		initialize();
//	}
//	
	private void showMessage(String message, JTextField txt) {
		txt.requestFocus();
		JOptionPane.showMessageDialog(null, message);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	@PostConstruct
	private void initialize() {
//		frameLogin = new JFrame();
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(Color.DARK_GRAY);
		panelLeft.setBounds(0, 0, 349, 620);
		getContentPane().add(panelLeft);
		panelLeft.setLayout(null);
		
		JLabel lblImage = new JLabel("New label");
		lblImage.setIcon(new ImageIcon(LoginGUI.class.getResource("/com/hotel/project/gui/home/image/Webp.net-resizeimage.jpg")));
		lblImage.setBounds(-27, -29, 399, 329);
		panelLeft.add(lblImage);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(0, 324, 341, 166);
		panelLeft.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(img_logo));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		
		textFieldDN = new JTextField();
		textFieldDN.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		textFieldDN.setBounds(404, 142, 454, 52);
		getContentPane().add(textFieldDN);
		textFieldDN.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(404, 193, 269, 52);
		getContentPane().add(separator);
		
		JLabel lblDN = new JLabel("Tên Đăng Nhập");
		lblDN.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblDN.setBounds(404, 90, 191, 52);
		getContentPane().add(lblDN);
		
		JLabel lblPassword = new JLabel("Mật Khẩu");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblPassword.setBounds(404, 236, 144, 52);
		getContentPane().add(lblPassword);
		
		JButton btnDN = new JButton("Đăng Nhập");
		btnDN.setForeground(Color.WHITE);
		btnDN.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnDN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDN.setBackground(new Color(255, 99, 71));
		btnDN.setBounds(667, 411, 191, 52);
		getContentPane().add(btnDN);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(404, 338, 269, 52);
		getContentPane().add(separator_1);
		
		JLabel lblX = new JLabel("x");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lblX.setForeground(new Color(255, 69, 0));
		lblX.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblX.setBounds(896, 0, 28, 29);
		getContentPane().add(lblX);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		passwordField.setBounds(404, 287, 454, 52);
		getContentPane().add(passwordField);
		setBounds(100, 100,924, 544);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx= e.getX();
				xy= e.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent agr0) {
				int x = agr0.getXOnScreen();
				int y = agr0.getYOnScreen();
				setLocation(x -xx, y - xy);
				
			}
		});
		
		btnDN.addActionListener (new ActionListener () {
		@Override
		public void actionPerformed(ActionEvent e) {
			dangNhap();
		}			
	});
		
		textFieldDN.addKeyListener((KeyListener) new KeyAdapter() {

			  public void keyPressed(KeyEvent e) {
			    if (e.getKeyCode()==KeyEvent.VK_ENTER){
			    	dangNhap();
			    }
			  }
			});
		
		passwordField.addKeyListener((KeyListener) new KeyAdapter() {

			  public void keyPressed(KeyEvent e) {
			    if (e.getKeyCode()==KeyEvent.VK_ENTER){
			    	dangNhap();
			    }
			  }
			});
		
	}
		
		public void dangNhap() {
			NhanVien nv= nhanVienRepository.findByTK(textFieldDN.getText());
			if(nv!=null) {
				
				char chPassword[]=passwordField.getPassword();
				String passWord= new String(chPassword);
				if(nv.getTaiKhoan().getMatKhau().equals(passWord.trim())) {
					dispose();
					ApplicationContext app=new SpringApplicationBuilder(HotelProjectApplication.class)
							.headless(true)
							.web(WebApplicationType.NONE)
							.headless(false)
							.profiles("dev")
							.run();
					
					SwingUtilities.invokeLater(() -> {
			            Home home = app.getBean(Home.class);
			            home.setVisible(true);
			            
			            nhanvien = nhanVienRepository.findByMaNhanVien(textFieldDN.getText());
			            home.getLblMaNV().setText(nhanvien.getMaNhanVien());
			            home.getLblTenNV().setText(nhanvien.getTenNhanVien());
			            if(nhanvien.getChucVu().equals("Nhân viên")) {
				            home.getBtnNhanVien().setEnabled(false);
				            home.getBtnThongKe().setEnabled(false);
				            home.getBtnphong().setEnabled(false);
				            
				            for (MouseListener al : home.getBtnNhanVien().getMouseListeners()) {
							    home.getBtnNhanVien().removeMouseListener(al);
							  }
				            for (MouseListener al : home.getBtnThongKe().getMouseListeners()) {
							    home.getBtnThongKe().removeMouseListener(al);
							  }
				            for (MouseListener al : home.getBtnphong().getMouseListeners()) {
							    home.getBtnphong().removeMouseListener(al);
							  }
				        
			            }
					
			        });
					
					
					
				}
				else {
					showMessage("Mật khẩu sai !!!!", passwordField);
				}
			}
			else {
				showMessage("Tài khoản sai !!!", textFieldDN);
			}

		}
		
		
		
}
