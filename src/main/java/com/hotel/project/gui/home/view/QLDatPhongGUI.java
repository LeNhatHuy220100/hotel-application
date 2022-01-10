package com.hotel.project.gui.home.view;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import javax.swing.border.LineBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotel.project.domain.ChiTietHoaDon;
import com.hotel.project.domain.HoaDon;
import com.hotel.project.domain.LoaiPhong;
import com.hotel.project.domain.NhanVien;
import com.hotel.project.domain.Phong;
import com.hotel.project.repository.impl.HoaDonRepositoryImpl;

@Component
public class QLDatPhongGUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image img_std = new ImageIcon(Home.class.getResource("/com/hotel/project/gui/home/image/banner.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_family = new ImageIcon(Home.class.getResource("/com/hotel/project/gui/home/image/family.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_vip = new ImageIcon(Home.class.getResource("/com/hotel/project/gui/home/image/vip.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private String ngthue ="Ngày thuê: ";
	private String ngTra = "Ngày trả:    ";
	private DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	@Autowired
	private CapNhatPhongGUI cnp;
	@Autowired
	private DonDatPhongGUI dp;
	@Autowired
	private NhanPhongGUI np;
	
	private JPanel p101;
	private JPanel p102;
	private JPanel p103;
	private JPanel p104;
	private JPanel p105;
	private JPanel p201;
	private JPanel p202;
	private JPanel p203;
	private JPanel p204;
	private JPanel p205;
	private JPanel p301;
	private JPanel p302;
	private JPanel p303;
	private JPanel p304;
	private JPanel p305;
	private JPanel p401;
	private JPanel p402;
	private JPanel p403;
	private JPanel p404;
	private JPanel p405;
	
	private JLabel lblcmnd101, lblTen101, lblThue101, lblTra101;
	private Button btnCN101, btnNhan101;
	
	private JLabel lblcmnd102, lblTen102, lblThue102, lblTra102;
	private Button btnCN102, btnNhan102;
	
	private JLabel lblcmnd103, lblTen103, lblThue103, lblTra103;
	private Button btnCN103, btnNhan103;
	
	private JLabel lblcmnd104, lblTen104, lblThue104, lblTra104;
	private Button btnCN104, btnNhan104;
	
	private JLabel lblcmnd105, lblTen105, lblThue105, lblTra105;
	private Button btnCN105, btnNhan105;
	
	private JLabel lblcmnd201, lblTen201, lblThue201, lblTra201;
	private Button btnCN201, btnNhan201;
	
	private JLabel lblcmnd202, lblTen202, lblThue202, lblTra202;
	private Button btnCN202, btnNhan202;
	
	private JLabel lblcmnd203, lblTen203, lblThue203, lblTra203;
	private Button btnCN203, btnNhan203;
	
	private JLabel lblcmnd204, lblTen204, lblThue204, lblTra204;
	private Button btnCN204, btnNhan204;
	
	private JLabel lblcmnd205, lblTen205, lblThue205, lblTra205;
	private Button btnCN205, btnNhan205;
	
	private JLabel lblcmnd301, lblTen301, lblThue301, lblTra301;
	private Button btnCN301, btnNhan301;
	
	private JLabel lblcmnd302, lblTen302, lblThue302, lblTra302;
	private Button btnCN302, btnNhan302;
	
	private JLabel lblcmnd303, lblTen303, lblThue303, lblTra303;
	private Button btnCN303, btnNhan303;
	
	private JLabel lblcmnd304, lblTen304, lblThue304, lblTra304;
	private Button btnCN304, btnNhan304;
	
	private JLabel lblcmnd305, lblTen305, lblThue305, lblTra305;
	private Button btnCN305, btnNhan305;
	
	private JLabel lblcmnd401, lblTen401, lblThue401, lblTra401;
	private Button btnCN401, btnNhan401;
	
	private JLabel lblcmnd402, lblTen402, lblThue402, lblTra402;
	private Button btnCN402, btnNhan402;
	
	private JLabel lblcmnd403, lblTen403, lblThue403, lblTra403;
	private Button btnCN403, btnNhan403;
	
	private JLabel lblcmnd405, lblTen405, lblThue405, lblTra405;
	private Button btnCN405, btnNhan405;
	
	private JLabel lblcmnd404, lblTen404, lblThue404, lblTra404;
	private Button btnCN404, btnNhan404;

	@Autowired
	private HoaDonRepositoryImpl HoaDonRepo;
	
	@Autowired
	private Home h ;
	


	/**
	 * Create the panel.
	 */
	public QLDatPhongGUI() {

	}
	
	@PostConstruct
	public void preparePane() {
		setBackground(Color.WHITE);
		setBounds(303, 0, 1599, 1008);
		setLayout(null);
		
		JPanel paneltieuDe = new JPanel();
		paneltieuDe.setBackground(Color.WHITE);
		paneltieuDe.setBounds(40, 13, 1519, 79);
		add(paneltieuDe);
		paneltieuDe.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblTieuDe = new JLabel("QUẢN LÝ ĐẶT PHÒNG");
		lblTieuDe.setForeground(new Color(255, 69, 0));
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 30));
		paneltieuDe.add(lblTieuDe);
		
		JPanel panelPhong = new JPanel();
		panelPhong.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPhong.setBackground(new Color(244, 247, 252));
		panelPhong.setBounds(40, 151, 1519, 831);
		add(panelPhong);
		panelPhong.setLayout(null);
		
		JPanel panelLau1 = new JPanel();
		panelLau1.setForeground(SystemColor.info);
		panelLau1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelLau1.setBackground(SystemColor.controlDkShadow);
		panelLau1.setLayout(null);
		panelLau1.setBounds(0, 0, 81, 209);
		panelPhong.add(panelLau1);
		
		JLabel lblLau1 = new JLabel("L1");
		lblLau1.setForeground(SystemColor.controlHighlight);
		lblLau1.setBackground(Color.WHITE);
		lblLau1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblLau1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLau1.setBounds(12, 13, 56, 183);
		panelLau1.add(lblLau1);
		
		p101 = new JPanel();
		p101.setLayout(null);
		p101.setBorder(new LineBorder(new Color(0, 0, 128), 0));
		p101.setBackground(new Color(147, 112, 219));
		p101.setBounds(133, 13, 224, 185);
		panelPhong.add(p101);
		
		JLabel lbl101 = new JLabel("101");
		lbl101.setForeground(Color.WHITE);
		lbl101.setHorizontalAlignment(SwingConstants.CENTER);
		lbl101.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbl101.setBounds(0, 0, 224, 46);
		lbl101.setIcon(new ImageIcon(img_std));
		p101.add(lbl101);
		
		btnCN101 = new Button("Cập Nhật");
		btnCN101.setEnabled(false);
		btnCN101.setForeground(Color.WHITE);
		btnCN101.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCN101.setBackground(Color.gray);
		btnCN101.setBounds(85, 150, 129, 25);
		p101.add(btnCN101);
		
		lblcmnd101 = new JLabel("");
		lblcmnd101.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcmnd101.setForeground(Color.WHITE);
		lblcmnd101.setHorizontalAlignment(SwingConstants.CENTER);
		lblcmnd101.setBounds(0, 48, 224, 22);
		p101.add(lblcmnd101);
		
		lblTen101 = new JLabel("");
		lblTen101.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen101.setForeground(Color.WHITE);
		lblTen101.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTen101.setBounds(0, 70, 224, 20);
		p101.add(lblTen101);
		
		btnNhan101 = new Button("Nhận");
		btnNhan101.setEnabled(false);
		btnNhan101.setActionCommand("Nhận");
		btnNhan101.setForeground(Color.WHITE);
		btnNhan101.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNhan101.setBackground(Color.gray);
		btnNhan101.setBounds(10, 150, 69, 25);
		p101.add(btnNhan101);
		
		lblThue101 = new JLabel("");
		lblThue101.setHorizontalAlignment(SwingConstants.CENTER);
		lblThue101.setForeground(Color.WHITE);
		lblThue101.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThue101.setBounds(0, 91, 224, 20);
		p101.add(lblThue101);
		
		lblTra101 = new JLabel("");
		lblTra101.setHorizontalAlignment(SwingConstants.CENTER);
		lblTra101.setForeground(Color.WHITE);
		lblTra101.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTra101.setBounds(0, 113, 224, 20);
		p101.add(lblTra101);
		
		JPanel panelLau2 = new JPanel();
		panelLau2.setLayout(null);
		panelLau2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelLau2.setBackground(SystemColor.controlDkShadow);
		panelLau2.setBounds(0, 208, 81, 209);
		panelPhong.add(panelLau2);
		
		JLabel lblLau2 = new JLabel("L2");
		lblLau2.setForeground(SystemColor.controlLtHighlight);
		lblLau2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLau2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblLau2.setBounds(12, 13, 56, 183);
		panelLau2.add(lblLau2);
		
		JPanel panelLau3 = new JPanel();
		panelLau3.setForeground(SystemColor.controlDkShadow);
		panelLau3.setLayout(null);
		panelLau3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelLau3.setBackground(SystemColor.controlDkShadow);
		panelLau3.setBounds(0, 416, 81, 209);
		panelPhong.add(panelLau3);
		
		JLabel lblLau3 = new JLabel("L3");
		lblLau3.setForeground(SystemColor.controlLtHighlight);
		lblLau3.setHorizontalAlignment(SwingConstants.CENTER);
		lblLau3.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblLau3.setBounds(12, 13, 56, 183);
		panelLau3.add(lblLau3);
		
		JPanel panelLau4 = new JPanel();
		panelLau4.setLayout(null);
		panelLau4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelLau4.setBackground(SystemColor.controlDkShadow);
		panelLau4.setBounds(0, 622, 81, 209);
		panelPhong.add(panelLau4);
		
		JLabel lblLau4 = new JLabel("L4");
		lblLau4.setForeground(SystemColor.controlLtHighlight);
		lblLau4.setHorizontalAlignment(SwingConstants.CENTER);
		lblLau4.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblLau4.setBounds(12, 13, 56, 183);
		panelLau4.add(lblLau4);
		
		p201 = new JPanel();
		p201.setLayout(null);
		p201.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		p201.setBackground(new Color(147, 112, 219));
		p201.setBounds(133, 217, 224, 185);
		panelPhong.add(p201);
		
		JLabel lbl201 = new JLabel("201");
		lbl201.setIcon(new ImageIcon(img_family));
		lbl201.setForeground(Color.WHITE);
		lbl201.setBackground(Color.WHITE);
		lbl201.setHorizontalAlignment(SwingConstants.CENTER);
		lbl201.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbl201.setBounds(0, 0, 224, 46);
		p201.add(lbl201);
		
		btnCN201 = new Button("Cập Nhật");
		btnCN201.setForeground(Color.WHITE);
		btnCN201.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCN201.setEnabled(false);
		btnCN201.setBackground(Color.gray);
		btnCN201.setBounds(85, 150, 129, 25);
		p201.add(btnCN201);
		
		lblcmnd201 = new JLabel("");
		lblcmnd201.setBackground(Color.WHITE);
		lblcmnd201.setHorizontalAlignment(SwingConstants.CENTER);
		lblcmnd201.setForeground(Color.WHITE);
		lblcmnd201.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcmnd201.setBounds(0, 48, 224, 22);
		p201.add(lblcmnd201);
		
		lblTen201 = new JLabel("");
		lblTen201.setBackground(Color.WHITE);
		lblTen201.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen201.setForeground(Color.WHITE);
		lblTen201.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTen201.setBounds(0, 70, 224, 20);
		p201.add(lblTen201);
		
		btnNhan201 = new Button("Nhận");
		btnNhan201.setEnabled(false);
		btnNhan201.setForeground(Color.WHITE);
		btnNhan201.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNhan201.setBackground(Color.gray);
		btnNhan201.setActionCommand("Nhận");
		btnNhan201.setBounds(10, 150, 69, 25);
		p201.add(btnNhan201);
		
		lblThue201 = new JLabel("");
		lblThue201.setBackground(Color.WHITE);
		lblThue201.setHorizontalAlignment(SwingConstants.CENTER);
		lblThue201.setForeground(Color.WHITE);
		lblThue201.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThue201.setBounds(0, 91, 224, 20);
		p201.add(lblThue201);
		
		lblTra201 = new JLabel("");
		lblTra201.setBackground(Color.WHITE);
		lblTra201.setHorizontalAlignment(SwingConstants.CENTER);
		lblTra201.setForeground(Color.WHITE);
		lblTra201.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTra201.setBounds(0, 113, 224, 20);
		p201.add(lblTra201);
		
		p301 = new JPanel();
		p301.setLayout(null);
		p301.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		p301.setBackground(new Color(147, 112, 219));
		p301.setBounds(133, 427, 224, 185);
		panelPhong.add(p301);
		
		JLabel lbl301 = new JLabel("301");
		lbl301.setIcon(new ImageIcon(img_std));
		lbl301.setForeground(Color.WHITE);
		lbl301.setBackground(Color.WHITE);
		lbl301.setHorizontalAlignment(SwingConstants.CENTER);
		lbl301.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbl301.setBounds(0, 0, 224, 46);
		p301.add(lbl301);
		
		btnCN301 = new Button("Cập Nhật");
		btnCN301.setForeground(Color.WHITE);
		btnCN301.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCN301.setEnabled(false);
		btnCN301.setBackground(Color.gray);
		btnCN301.setBounds(85, 150, 129, 25);
		p301.add(btnCN301);
		
		lblcmnd301 = new JLabel("");
		lblcmnd301.setBackground(Color.WHITE);
		lblcmnd301.setHorizontalAlignment(SwingConstants.CENTER);
		lblcmnd301.setForeground(Color.WHITE);
		lblcmnd301.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcmnd301.setBounds(0, 48, 224, 22);
		p301.add(lblcmnd301);
		
		lblTen301 = new JLabel("");
		lblTen301.setBackground(Color.WHITE);
		lblTen301.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen301.setForeground(Color.WHITE);
		lblTen301.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTen301.setBounds(0, 70, 224, 20);
		p301.add(lblTen301);
		
		btnNhan301 = new Button("Nhận");
		btnNhan301.setEnabled(false);
		btnNhan301.setForeground(Color.WHITE);
		btnNhan301.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNhan301.setBackground(Color.gray);
		btnNhan301.setActionCommand("Nhận");
		btnNhan301.setBounds(10, 150, 69, 25);
		p301.add(btnNhan301);
		
		lblThue301 = new JLabel("");
		lblThue301.setBackground(Color.WHITE);
		lblThue301.setHorizontalAlignment(SwingConstants.CENTER);
		lblThue301.setForeground(Color.WHITE);
		lblThue301.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThue301.setBounds(0, 91, 224, 20);
		p301.add(lblThue301);
		
		lblTra301 = new JLabel("");
		lblTra301.setBackground(Color.WHITE);
		lblTra301.setHorizontalAlignment(SwingConstants.CENTER);
		lblTra301.setForeground(Color.WHITE);
		lblTra301.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTra301.setBounds(0, 113, 224, 20);
		p301.add(lblTra301);
		
		p401 = new JPanel();
		p401.setLayout(null);
		p401.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		p401.setBackground(new Color(147, 112, 219));
		p401.setBounds(133, 633, 224, 185);
		panelPhong.add(p401);
		
		JLabel lbl401 = new JLabel("401");
		lbl401.setIcon(new ImageIcon(img_vip));
		lbl401.setForeground(Color.WHITE);
		lbl401.setBackground(Color.WHITE);
		lbl401.setHorizontalAlignment(SwingConstants.CENTER);
		lbl401.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbl401.setBounds(0, 0, 224, 46);
		p401.add(lbl401);
		
		btnCN401 = new Button("Cập Nhật");
		btnCN401.setForeground(Color.WHITE);
		btnCN401.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCN401.setEnabled(false);
		btnCN401.setBackground(Color.gray);
		btnCN401.setBounds(85, 150, 129, 25);
		p401.add(btnCN401);
		
		lblcmnd401 = new JLabel("");
		lblcmnd401.setBackground(Color.WHITE);
		lblcmnd401.setHorizontalAlignment(SwingConstants.CENTER);
		lblcmnd401.setForeground(Color.WHITE);
		lblcmnd401.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcmnd401.setBounds(0, 48, 224, 22);
		p401.add(lblcmnd401);
		
		lblTen401 = new JLabel("");
		lblTen401.setBackground(Color.WHITE);
		lblTen401.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen401.setForeground(Color.WHITE);
		lblTen401.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTen401.setBounds(0, 70, 224, 20);
		p401.add(lblTen401);
		
		btnNhan401 = new Button("Nhận");
		btnNhan401.setEnabled(false);
		btnNhan401.setForeground(Color.WHITE);
		btnNhan401.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNhan401.setBackground(Color.gray);
		btnNhan401.setActionCommand("Nhận");
		btnNhan401.setBounds(10, 150, 69, 25);
		p401.add(btnNhan401);
		
		lblThue401 = new JLabel("");
		lblThue401.setBackground(Color.WHITE);
		lblThue401.setHorizontalAlignment(SwingConstants.CENTER);
		lblThue401.setForeground(Color.WHITE);
		lblThue401.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThue401.setBounds(0, 91, 224, 20);
		p401.add(lblThue401);
		
		lblTra401 = new JLabel("");
		lblTra401.setBackground(Color.WHITE);
		lblTra401.setHorizontalAlignment(SwingConstants.CENTER);
		lblTra401.setForeground(Color.WHITE);
		lblTra401.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTra401.setBounds(0, 113, 224, 20);
		p401.add(lblTra401);
		
		p102 = new JPanel();
		p102.setLayout(null);
		p102.setBorder(new LineBorder(new Color(0, 0, 128), 0));
		p102.setBackground(new Color(147, 112, 219));
		p102.setBounds(415, 13, 224, 185);
		panelPhong.add(p102);
		
		JLabel lbl102 = new JLabel("102");
		lbl102.setForeground(Color.WHITE);
		lbl102.setIcon(new ImageIcon(img_std));
		lbl102.setHorizontalAlignment(SwingConstants.CENTER);
		lbl102.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbl102.setBounds(0, 0, 224, 46);
		p102.add(lbl102);
		
		btnCN102 = new Button("Cập Nhật");
		btnCN102.setEnabled(false);
		btnCN102.setForeground(Color.WHITE);
		btnCN102.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCN102.setBackground(Color.gray);
		btnCN102.setBounds(85, 150, 129, 25);
		p102.add(btnCN102);
		
		lblcmnd102 = new JLabel("");
		lblcmnd102.setHorizontalAlignment(SwingConstants.CENTER);
		lblcmnd102.setForeground(Color.WHITE);
		lblcmnd102.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcmnd102.setBounds(0, 48, 224, 22);
		p102.add(lblcmnd102);
		
		lblTen102 = new JLabel("");
		lblTen102.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen102.setForeground(Color.WHITE);
		lblTen102.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTen102.setBounds(0, 70, 224, 20);
		p102.add(lblTen102);
		
		btnNhan102 = new Button("Nhận");
		btnNhan102.setEnabled(false);
		btnNhan102.setForeground(Color.WHITE);
		btnNhan102.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNhan102.setBackground(Color.gray);
		btnNhan102.setActionCommand("Nhận");
		btnNhan102.setBounds(10, 150, 69, 25);
		p102.add(btnNhan102);
		
		lblThue102 = new JLabel("");
		lblThue102.setHorizontalAlignment(SwingConstants.CENTER);
		lblThue102.setForeground(Color.WHITE);
		lblThue102.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThue102.setBounds(0, 91, 224, 20);
		p102.add(lblThue102);
		
		lblTra102 = new JLabel("");
		lblTra102.setHorizontalAlignment(SwingConstants.CENTER);
		lblTra102.setForeground(Color.WHITE);
		lblTra102.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTra102.setBounds(0, 113, 224, 20);
		p102.add(lblTra102);
		
		p202 = new JPanel();
		p202.setLayout(null);
		p202.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		p202.setBackground(new Color(147, 112, 219));
		p202.setBounds(415, 217, 224, 185);
		panelPhong.add(p202);
		
		JLabel lbl202 = new JLabel("202");
		lbl202.setIcon(new ImageIcon(img_family));
		lbl202.setForeground(Color.WHITE);
		lbl202.setBackground(Color.WHITE);
		lbl202.setHorizontalAlignment(SwingConstants.CENTER);
		lbl202.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbl202.setBounds(0, 0, 224, 46);
		p202.add(lbl202);
		
		btnCN202 = new Button("Cập Nhật");
		btnCN202.setForeground(Color.WHITE);
		btnCN202.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCN202.setEnabled(false);
		btnCN202.setBackground(Color.gray);
		btnCN202.setBounds(85, 150, 129, 25);
		p202.add(btnCN202);
		
		lblcmnd202 = new JLabel("");
		lblcmnd202.setBackground(Color.WHITE);
		lblcmnd202.setHorizontalAlignment(SwingConstants.CENTER);
		lblcmnd202.setForeground(Color.WHITE);
		lblcmnd202.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcmnd202.setBounds(0, 48, 224, 22);
		p202.add(lblcmnd202);
		
		lblTen202 = new JLabel("");
		lblTen202.setBackground(Color.WHITE);
		lblTen202.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen202.setForeground(Color.WHITE);
		lblTen202.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTen202.setBounds(0, 70, 224, 20);
		p202.add(lblTen202);
		
		btnNhan202 = new Button("Nhận");
		btnNhan202.setEnabled(false);
		btnNhan202.setForeground(Color.WHITE);
		btnNhan202.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNhan202.setBackground(Color.gray);
		btnNhan202.setActionCommand("Nhận");
		btnNhan202.setBounds(10, 150, 69, 25);
		p202.add(btnNhan202);
		
		lblThue202 = new JLabel("");
		lblThue202.setBackground(Color.WHITE);
		lblThue202.setHorizontalAlignment(SwingConstants.CENTER);
		lblThue202.setForeground(Color.WHITE);
		lblThue202.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThue202.setBounds(0, 91, 224, 20);
		p202.add(lblThue202);
		
		lblTra202 = new JLabel("");
		lblTra202.setBackground(Color.WHITE);
		lblTra202.setHorizontalAlignment(SwingConstants.CENTER);
		lblTra202.setForeground(Color.WHITE);
		lblTra202.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTra202.setBounds(0, 113, 224, 20);
		p202.add(lblTra202);
		
		p302 = new JPanel();
		p302.setLayout(null);
		p302.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		p302.setBackground(new Color(147, 112, 219));
		p302.setBounds(415, 427, 224, 185);
		panelPhong.add(p302);
		
		JLabel lbl302 = new JLabel("302");
		lbl302.setIcon(new ImageIcon(img_std));
		lbl302.setForeground(Color.WHITE);
		lbl302.setBackground(Color.WHITE);
		lbl302.setHorizontalAlignment(SwingConstants.CENTER);
		lbl302.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbl302.setBounds(0, 0, 224, 46);
		p302.add(lbl302);
		
		btnCN302 = new Button("Cập Nhật");
		btnCN302.setForeground(Color.WHITE);
		btnCN302.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCN302.setEnabled(false);
		btnCN302.setBackground(Color.gray);
		btnCN302.setBounds(85, 150, 129, 25);
		p302.add(btnCN302);
		
		lblcmnd302 = new JLabel("");
		lblcmnd302.setBackground(Color.WHITE);
		lblcmnd302.setHorizontalAlignment(SwingConstants.CENTER);
		lblcmnd302.setForeground(Color.WHITE);
		lblcmnd302.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcmnd302.setBounds(0, 48, 224, 22);
		p302.add(lblcmnd302);
		
		lblTen302 = new JLabel("");
		lblTen302.setBackground(Color.WHITE);
		lblTen302.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen302.setForeground(Color.WHITE);
		lblTen302.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTen302.setBounds(0, 70, 224, 20);
		p302.add(lblTen302);
		
		btnNhan302 = new Button("Nhận");
		btnNhan302.setEnabled(false);
		btnNhan302.setForeground(Color.WHITE);
		btnNhan302.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNhan302.setBackground(Color.gray);
		btnNhan302.setActionCommand("Nhận");
		btnNhan302.setBounds(10, 150, 69, 25);
		p302.add(btnNhan302);
		
		lblThue302 = new JLabel("");
		lblThue302.setBackground(Color.WHITE);
		lblThue302.setHorizontalAlignment(SwingConstants.CENTER);
		lblThue302.setForeground(Color.WHITE);
		lblThue302.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThue302.setBounds(0, 91, 224, 20);
		p302.add(lblThue302);
		
		lblTra302 = new JLabel("");
		lblTra302.setBackground(Color.WHITE);
		lblTra302.setHorizontalAlignment(SwingConstants.CENTER);
		lblTra302.setForeground(Color.WHITE);
		lblTra302.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTra302.setBounds(0, 113, 224, 20);
		p302.add(lblTra302);
		
		p402 = new JPanel();
		p402.setLayout(null);
		p402.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		p402.setBackground(new Color(147, 112, 219));
		p402.setBounds(415, 633, 224, 185);
		panelPhong.add(p402);
		
		JLabel lbl402 = new JLabel("402");
		lbl402.setIcon(new ImageIcon(img_vip));
		lbl402.setForeground(Color.WHITE);
		lbl402.setBackground(Color.WHITE);
		lbl402.setHorizontalAlignment(SwingConstants.CENTER);
		lbl402.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbl402.setBounds(0, 0, 224, 46);
		p402.add(lbl402);
		
		btnCN402 = new Button("Cập Nhật");
		btnCN402.setForeground(Color.WHITE);
		btnCN402.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCN402.setEnabled(false);
		btnCN402.setBackground(Color.gray);
		btnCN402.setBounds(85, 150, 129, 25);
		p402.add(btnCN402);
		
		lblcmnd402 = new JLabel("");
		lblcmnd402.setBackground(Color.WHITE);
		lblcmnd402.setHorizontalAlignment(SwingConstants.CENTER);
		lblcmnd402.setForeground(Color.WHITE);
		lblcmnd402.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcmnd402.setBounds(0, 48, 224, 22);
		p402.add(lblcmnd402);
		
		lblTen402 = new JLabel("");
		lblTen402.setBackground(Color.WHITE);
		lblTen402.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen402.setForeground(Color.WHITE);
		lblTen402.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTen402.setBounds(0, 70, 224, 20);
		p402.add(lblTen402);
		
		btnNhan402 = new Button("Nhận");
		btnNhan402.setEnabled(false);
		btnNhan402.setForeground(Color.WHITE);
		btnNhan402.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNhan402.setBackground(Color.gray);
		btnNhan402.setActionCommand("Nhận");
		btnNhan402.setBounds(10, 150, 69, 25);
		p402.add(btnNhan402);
		
		lblThue402 = new JLabel("");
		lblThue402.setBackground(Color.WHITE);
		lblThue402.setHorizontalAlignment(SwingConstants.CENTER);
		lblThue402.setForeground(Color.WHITE);
		lblThue402.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThue402.setBounds(0, 91, 224, 20);
		p402.add(lblThue402);
		
		lblTra402 = new JLabel("");
		lblTra402.setBackground(Color.WHITE);
		lblTra402.setHorizontalAlignment(SwingConstants.CENTER);
		lblTra402.setForeground(Color.WHITE);
		lblTra402.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTra402.setBounds(0, 113, 224, 20);
		p402.add(lblTra402);
		
		p103 = new JPanel();
		p103.setLayout(null);
		p103.setBorder(new LineBorder(new Color(0, 0, 128), 0));
		p103.setBackground(new Color(147, 112, 219));
		p103.setBounds(690, 13, 224, 185);
		panelPhong.add(p103);
		
		JLabel lbl103 = new JLabel("103");
		lbl103.setForeground(Color.WHITE);
		lbl103.setIcon(new ImageIcon(img_std));
		lbl103.setHorizontalAlignment(SwingConstants.CENTER);
		lbl103.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbl103.setBounds(0, 0, 224, 46);
		p103.add(lbl103);
		
		btnCN103 = new Button("Cập Nhật");
		btnCN103.setForeground(Color.WHITE);
		btnCN103.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCN103.setEnabled(false);
		btnCN103.setBackground(Color.gray);
		btnCN103.setBounds(85, 150, 129, 25);
		p103.add(btnCN103);
		
		lblcmnd103 = new JLabel("");
		lblcmnd103.setHorizontalAlignment(SwingConstants.CENTER);
		lblcmnd103.setForeground(Color.WHITE);
		lblcmnd103.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcmnd103.setBounds(0, 48, 224, 22);
		p103.add(lblcmnd103);
		
		lblTen103 = new JLabel("");
		lblTen103.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen103.setForeground(Color.WHITE);
		lblTen103.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTen103.setBounds(0, 70, 224, 20);
		p103.add(lblTen103);
		
		btnNhan103 = new Button("Nhận");
		btnNhan103.setEnabled(false);
		btnNhan103.setForeground(Color.WHITE);
		btnNhan103.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNhan103.setBackground(Color.gray);
		btnNhan103.setActionCommand("Nhận");
		btnNhan103.setBounds(10, 150, 69, 25);
		p103.add(btnNhan103);
		
		lblThue103 = new JLabel("");
		lblThue103.setHorizontalAlignment(SwingConstants.CENTER);
		lblThue103.setForeground(Color.WHITE);
		lblThue103.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThue103.setBounds(0, 91, 224, 20);
		p103.add(lblThue103);
		
		lblTra103 = new JLabel("");
		lblTra103.setHorizontalAlignment(SwingConstants.CENTER);
		lblTra103.setForeground(Color.WHITE);
		lblTra103.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTra103.setBounds(0, 113, 224, 20);
		p103.add(lblTra103);
		
		p203 = new JPanel();
		p203.setLayout(null);
		p203.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		p203.setBackground(new Color(147, 112, 219));
		p203.setBounds(690, 217, 224, 185);
		panelPhong.add(p203);
		
		JLabel lbl203 = new JLabel("203");
		lbl203.setIcon(new ImageIcon(img_family));
		lbl203.setForeground(Color.WHITE);
		lbl203.setHorizontalAlignment(SwingConstants.CENTER);
		lbl203.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbl203.setBounds(0, 0, 224, 46);
		p203.add(lbl203);
		
		btnCN203 = new Button("Cập Nhật");
		btnCN203.setForeground(Color.WHITE);
		btnCN203.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCN203.setBackground(Color.gray);
		btnCN203.setBounds(85, 150, 129, 25);
		p203.add(btnCN203);
		
		lblcmnd203 = new JLabel("");
		lblcmnd203.setHorizontalAlignment(SwingConstants.CENTER);
		lblcmnd203.setForeground(Color.WHITE);
		lblcmnd203.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcmnd203.setBounds(0, 48, 224, 22);
		p203.add(lblcmnd203);
		
		lblTen203 = new JLabel("");
		lblTen203.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen203.setForeground(Color.WHITE);
		lblTen203.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTen203.setBounds(0, 70, 224, 20);
		p203.add(lblTen203);
		
		btnNhan203 = new Button("Nhận");
		btnNhan203.setEnabled(false);
		btnNhan203.setForeground(Color.WHITE);
		btnNhan203.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNhan203.setBackground(Color.gray);
		btnNhan203.setActionCommand("Nhận");
		btnNhan203.setBounds(10, 150, 69, 25);
		p203.add(btnNhan203);
		
		lblThue203 = new JLabel("");
		lblThue203.setHorizontalAlignment(SwingConstants.CENTER);
		lblThue203.setForeground(Color.WHITE);
		lblThue203.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThue203.setBounds(0, 91, 224, 20);
		p203.add(lblThue203);
		
		lblTra203 = new JLabel("");
		lblTra203.setHorizontalAlignment(SwingConstants.CENTER);
		lblTra203.setForeground(Color.WHITE);
		lblTra203.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTra203.setBounds(0, 113, 224, 20);
		p203.add(lblTra203);
		
		p303 = new JPanel();
		p303.setLayout(null);
		p303.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		p303.setBackground(new Color(147, 112, 219));
		p303.setBounds(690, 427, 224, 185);
		panelPhong.add(p303);
		
		JLabel lbl303 = new JLabel("303");
		lbl303.setIcon(new ImageIcon(img_std));
		lbl303.setForeground(Color.WHITE);
		lbl303.setHorizontalAlignment(SwingConstants.CENTER);
		lbl303.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbl303.setBounds(0, 0, 224, 46);
		p303.add(lbl303);
		
		btnCN303 = new Button("Cập Nhật");
		btnCN303.setForeground(Color.WHITE);
		btnCN303.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCN303.setBackground(Color.gray);
		btnCN303.setBounds(85, 150, 129, 25);
		p303.add(btnCN303);
		
		lblcmnd303 = new JLabel("");
		lblcmnd303.setHorizontalAlignment(SwingConstants.CENTER);
		lblcmnd303.setForeground(Color.WHITE);
		lblcmnd303.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcmnd303.setBounds(0, 48, 224, 22);
		p303.add(lblcmnd303);
		
		lblTen303 = new JLabel("");
		lblTen303.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen303.setForeground(Color.WHITE);
		lblTen303.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTen303.setBounds(0, 70, 224, 20);
		p303.add(lblTen303);
		
		btnNhan303 = new Button("Nhận");
		btnNhan303.setEnabled(false);
		btnNhan303.setForeground(Color.WHITE);
		btnNhan303.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNhan303.setBackground(Color.gray);
		btnNhan303.setActionCommand("Nhận");
		btnNhan303.setBounds(10, 150, 69, 25);
		p303.add(btnNhan303);
		
		lblThue303 = new JLabel("");
		lblThue303.setHorizontalAlignment(SwingConstants.CENTER);
		lblThue303.setForeground(Color.WHITE);
		lblThue303.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThue303.setBounds(0, 91, 224, 20);
		p303.add(lblThue303);
		
		lblTra303 = new JLabel("");
		lblTra303.setHorizontalAlignment(SwingConstants.CENTER);
		lblTra303.setForeground(Color.WHITE);
		lblTra303.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTra303.setBounds(0, 113, 224, 20);
		p303.add(lblTra303);
		
		p403 = new JPanel();
		p403.setLayout(null);
		p403.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		p403.setBackground(new Color(147, 112, 219));
		p403.setBounds(690, 633, 224, 185);
		panelPhong.add(p403);
		
		JLabel lbl403 = new JLabel("403");
		lbl403.setIcon(new ImageIcon(img_vip));
		lbl403.setForeground(Color.WHITE);
		lbl403.setHorizontalAlignment(SwingConstants.CENTER);
		lbl403.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbl403.setBounds(0, 0, 224, 46);
		p403.add(lbl403);
		
		btnCN403 = new Button("Cập Nhật");
		btnCN403.setForeground(Color.WHITE);
		btnCN403.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCN403.setBackground(Color.gray);
		btnCN403.setBounds(85, 150, 129, 25);
		p403.add(btnCN403);
		
		lblcmnd403 = new JLabel("");
		lblcmnd403.setHorizontalAlignment(SwingConstants.CENTER);
		lblcmnd403.setForeground(Color.WHITE);
		lblcmnd403.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcmnd403.setBounds(0, 48, 224, 22);
		p403.add(lblcmnd403);
		
		lblTen403 = new JLabel("");
		lblTen403.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen403.setForeground(Color.WHITE);
		lblTen403.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTen403.setBounds(0, 70, 224, 20);
		p403.add(lblTen403);
		
		btnNhan403 = new Button("Nhận");
		btnNhan403.setEnabled(false);
		btnNhan403.setForeground(Color.WHITE);
		btnNhan403.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNhan403.setBackground(Color.gray);
		btnNhan403.setActionCommand("Nhận");
		btnNhan403.setBounds(10, 150, 69, 25);
		p403.add(btnNhan403);
		
		lblThue403 = new JLabel("");
		lblThue403.setHorizontalAlignment(SwingConstants.CENTER);
		lblThue403.setForeground(Color.WHITE);
		lblThue403.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThue403.setBounds(0, 91, 224, 20);
		p403.add(lblThue403);
		
		lblTra403 = new JLabel("");
		lblTra403.setHorizontalAlignment(SwingConstants.CENTER);
		lblTra403.setForeground(Color.WHITE);
		lblTra403.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTra403.setBounds(0, 113, 224, 20);
		p403.add(lblTra403);
		
		p104 = new JPanel();
		p104.setLayout(null);
		p104.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		p104.setBackground(new Color(147, 112, 219));
		p104.setBounds(967, 13, 224, 185);
		panelPhong.add(p104);
		
		JLabel lbl104 = new JLabel("104");
		lbl104.setIcon(new ImageIcon(img_std));
		lbl104.setForeground(Color.WHITE);
		lbl104.setHorizontalAlignment(SwingConstants.CENTER);
		lbl104.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbl104.setBounds(0, 0, 224, 46);
		p104.add(lbl104);
		
		btnCN104 = new Button("Cập Nhật");
		btnCN104.setForeground(Color.WHITE);
		btnCN104.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCN104.setEnabled(false);
		btnCN104.setBackground(Color.gray);
		btnCN104.setBounds(85, 150, 129, 25);
		p104.add(btnCN104);
		
		lblcmnd104 = new JLabel("");
		lblcmnd104.setHorizontalAlignment(SwingConstants.CENTER);
		lblcmnd104.setForeground(Color.WHITE);
		lblcmnd104.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcmnd104.setBounds(0, 48, 224, 22);
		p104.add(lblcmnd104);
		
		lblTen104 = new JLabel("");
		lblTen104.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen104.setForeground(Color.WHITE);
		lblTen104.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTen104.setBounds(0, 70, 224, 20);
		p104.add(lblTen104);
		
		btnNhan104 = new Button("Nhận");
		btnNhan104.setEnabled(false);
		btnNhan104.setForeground(Color.WHITE);
		btnNhan104.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNhan104.setBackground(Color.gray);
		btnNhan104.setActionCommand("Nhận");
		btnNhan104.setBounds(10, 150, 69, 25);
		p104.add(btnNhan104);
		
		lblThue104 = new JLabel("");
		lblThue104.setHorizontalAlignment(SwingConstants.CENTER);
		lblThue104.setForeground(Color.WHITE);
		lblThue104.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThue104.setBounds(0, 91, 224, 20);
		p104.add(lblThue104);
		
		lblTra104 = new JLabel("");
		lblTra104.setHorizontalAlignment(SwingConstants.CENTER);
		lblTra104.setForeground(Color.WHITE);
		lblTra104.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTra104.setBounds(0, 113, 224, 20);
		p104.add(lblTra104);
		
		p105 = new JPanel();
		p105.setLayout(null);
		p105.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		p105.setBackground(new Color(147, 112, 219));
		p105.setBounds(1241, 13, 224, 185);
		panelPhong.add(p105);
		
		JLabel lbl105 = new JLabel("105");
		lbl105.setIcon(new ImageIcon(img_std));
		lbl105.setForeground(Color.WHITE);
		lbl105.setHorizontalAlignment(SwingConstants.CENTER);
		lbl105.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbl105.setBounds(0, 0, 224, 46);
		p105.add(lbl105);
		
		btnCN105 = new Button("Cập Nhật");
		btnCN105.setForeground(Color.WHITE);
		btnCN105.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCN105.setEnabled(false);
		btnCN105.setBackground(Color.gray);
		btnCN105.setBounds(85, 150, 129, 25);
		p105.add(btnCN105);
		
		lblcmnd105 = new JLabel("");
		lblcmnd105.setHorizontalAlignment(SwingConstants.CENTER);
		lblcmnd105.setForeground(Color.WHITE);
		lblcmnd105.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcmnd105.setBounds(0, 48, 224, 22);
		p105.add(lblcmnd105);
		
		lblTen105 = new JLabel("");
		lblTen105.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen105.setForeground(Color.WHITE);
		lblTen105.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTen105.setBounds(0, 70, 224, 20);
		p105.add(lblTen105);
		
		btnNhan105 = new Button("Nhận");
		btnNhan105.setEnabled(false);
		btnNhan105.setForeground(Color.WHITE);
		btnNhan105.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNhan105.setBackground(Color.gray);
		btnNhan105.setActionCommand("Nhận");
		btnNhan105.setBounds(10, 150, 69, 25);
		p105.add(btnNhan105);
		
		lblThue105 = new JLabel("");
		lblThue105.setHorizontalAlignment(SwingConstants.CENTER);
		lblThue105.setForeground(Color.WHITE);
		lblThue105.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThue105.setBounds(0, 91, 224, 20);
		p105.add(lblThue105);
		
		lblTra105 = new JLabel("");
		lblTra105.setHorizontalAlignment(SwingConstants.CENTER);
		lblTra105.setForeground(Color.WHITE);
		lblTra105.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTra105.setBounds(0, 113, 224, 20);
		p105.add(lblTra105);
		
		p204 = new JPanel();
		p204.setLayout(null);
		p204.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		p204.setBackground(new Color(147, 112, 219));
		p204.setBounds(967, 217, 224, 185);
		panelPhong.add(p204);
		
		JLabel lbl204 = new JLabel("204");
		lbl204.setIcon(new ImageIcon(img_family));
		lbl204.setForeground(Color.WHITE);
		lbl204.setHorizontalAlignment(SwingConstants.CENTER);
		lbl204.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbl204.setBounds(0, 0, 224, 46);
		p204.add(lbl204);
		
		btnCN204 = new Button("Cập Nhật");
		btnCN204.setForeground(Color.WHITE);
		btnCN204.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCN204.setBackground(Color.gray);
		btnCN204.setBounds(85, 150, 129, 25);
		p204.add(btnCN204);
		
		lblcmnd204 = new JLabel("");
		lblcmnd204.setHorizontalAlignment(SwingConstants.CENTER);
		lblcmnd204.setForeground(Color.WHITE);
		lblcmnd204.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcmnd204.setBounds(0, 48, 224, 22);
		p204.add(lblcmnd204);
		
		lblTen204 = new JLabel("");
		lblTen204.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen204.setForeground(Color.WHITE);
		lblTen204.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTen204.setBounds(0, 70, 224, 20);
		p204.add(lblTen204);
		
		btnNhan204 = new Button("Nhận");
		btnNhan204.setEnabled(false);
		btnNhan204.setForeground(Color.WHITE);
		btnNhan204.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNhan204.setBackground(Color.gray);
		btnNhan204.setActionCommand("Nhận");
		btnNhan204.setBounds(10, 150, 69, 25);
		p204.add(btnNhan204);
		
		lblThue204 = new JLabel("");
		lblThue204.setHorizontalAlignment(SwingConstants.CENTER);
		lblThue204.setForeground(Color.WHITE);
		lblThue204.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThue204.setBounds(0, 91, 224, 20);
		p204.add(lblThue204);
		
		lblTra204 = new JLabel("");
		lblTra204.setHorizontalAlignment(SwingConstants.CENTER);
		lblTra204.setForeground(Color.WHITE);
		lblTra204.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTra204.setBounds(0, 113, 224, 20);
		p204.add(lblTra204);
		
		p304 = new JPanel();
		p304.setLayout(null);
		p304.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		p304.setBackground(new Color(147, 112, 219));
		p304.setBounds(967, 427, 224, 185);
		panelPhong.add(p304);
		
		JLabel lbl304 = new JLabel("304");
		lbl304.setIcon(new ImageIcon(img_std));
		lbl304.setForeground(Color.WHITE);
		lbl304.setHorizontalAlignment(SwingConstants.CENTER);
		lbl304.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbl304.setBounds(0, 0, 224, 46);
		p304.add(lbl304);
		
		btnCN304 = new Button("Cập Nhật");
		btnCN304.setForeground(Color.WHITE);
		btnCN304.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCN304.setBackground(Color.gray);
		btnCN304.setBounds(85, 150, 129, 25);
		p304.add(btnCN304);
		
		lblcmnd304 = new JLabel("");
		lblcmnd304.setHorizontalAlignment(SwingConstants.CENTER);
		lblcmnd304.setForeground(Color.WHITE);
		lblcmnd304.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcmnd304.setBounds(0, 48, 224, 22);
		p304.add(lblcmnd304);
		
		lblTen304 = new JLabel("");
		lblTen304.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen304.setForeground(Color.WHITE);
		lblTen304.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTen304.setBounds(0, 70, 224, 20);
		p304.add(lblTen304);
		
		btnNhan304 = new Button("Nhận");
		btnNhan304.setEnabled(false);
		btnNhan304.setForeground(Color.WHITE);
		btnNhan304.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNhan304.setBackground(Color.gray);
		btnNhan304.setActionCommand("Nhận");
		btnNhan304.setBounds(10, 150, 69, 25);
		p304.add(btnNhan304);
		
		lblThue304 = new JLabel("");
		lblThue304.setHorizontalAlignment(SwingConstants.CENTER);
		lblThue304.setForeground(Color.WHITE);
		lblThue304.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThue304.setBounds(0, 91, 224, 20);
		p304.add(lblThue304);
		
		lblTra304 = new JLabel("");
		lblTra304.setHorizontalAlignment(SwingConstants.CENTER);
		lblTra304.setForeground(Color.WHITE);
		lblTra304.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTra304.setBounds(0, 113, 224, 20);
		p304.add(lblTra304);
		
		p404 = new JPanel();
		p404.setLayout(null);
		p404.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		p404.setBackground(new Color(147, 112, 219));
		p404.setBounds(967, 633, 224, 185);
		panelPhong.add(p404);
		
		JLabel lbl404 = new JLabel("404");
		lbl404.setIcon(new ImageIcon(img_vip));
		lbl404.setForeground(Color.WHITE);
		lbl404.setHorizontalAlignment(SwingConstants.CENTER);
		lbl404.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbl404.setBounds(0, 0, 224, 46);
		p404.add(lbl404);
		
		btnCN404 = new Button("Cập Nhật");
		btnCN404.setForeground(Color.WHITE);
		btnCN404.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCN404.setBackground(Color.gray);
		btnCN404.setBounds(85, 150, 129, 25);
		p404.add(btnCN404);
		
		lblcmnd404 = new JLabel("");
		lblcmnd404.setHorizontalAlignment(SwingConstants.CENTER);
		lblcmnd404.setForeground(Color.WHITE);
		lblcmnd404.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcmnd404.setBounds(0, 48, 224, 22);
		p404.add(lblcmnd404);
		
		lblTen404 = new JLabel("");
		lblTen404.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen404.setForeground(Color.WHITE);
		lblTen404.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTen404.setBounds(0, 70, 224, 20);
		p404.add(lblTen404);
		
		btnNhan404 = new Button("Nhận");
		btnNhan404.setEnabled(false);
		btnNhan404.setForeground(Color.WHITE);
		btnNhan404.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNhan404.setBackground(Color.gray);
		btnNhan404.setActionCommand("Nhận");
		btnNhan404.setBounds(10, 150, 69, 25);
		p404.add(btnNhan404);
		
		lblThue404 = new JLabel("");
		lblThue404.setHorizontalAlignment(SwingConstants.CENTER);
		lblThue404.setForeground(Color.WHITE);
		lblThue404.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThue404.setBounds(0, 91, 224, 20);
		p404.add(lblThue404);
		
		lblTra404 = new JLabel("");
		lblTra404.setHorizontalAlignment(SwingConstants.CENTER);
		lblTra404.setForeground(Color.WHITE);
		lblTra404.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTra404.setBounds(0, 113, 224, 20);
		p404.add(lblTra404);
		
		p205 = new JPanel();
		p205.setLayout(null);
		p205.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		p205.setBackground(new Color(147, 112, 219));
		p205.setBounds(1241, 217, 224, 185);
		panelPhong.add(p205);
		
		JLabel lbl205 = new JLabel("205");
		lbl205.setIcon(new ImageIcon(img_std));
		lbl205.setForeground(Color.WHITE);
		lbl205.setHorizontalAlignment(SwingConstants.CENTER);
		lbl205.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbl205.setBounds(0, 0, 224, 46);
		p205.add(lbl205);
		
		btnCN205 = new Button("Cập Nhật");
		btnCN205.setEnabled(false);
		btnCN205.setForeground(Color.WHITE);
		btnCN205.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCN205.setBackground(Color.gray);
		btnCN205.setBounds(85, 150, 129, 25);
		p205.add(btnCN205);
		
		lblcmnd205 = new JLabel("");
		lblcmnd205.setHorizontalAlignment(SwingConstants.CENTER);
		lblcmnd205.setForeground(Color.WHITE);
		lblcmnd205.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcmnd205.setBounds(0, 48, 224, 22);
		p205.add(lblcmnd205);
		
		lblTen205 = new JLabel("");
		lblTen205.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen205.setForeground(Color.WHITE);
		lblTen205.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTen205.setBounds(0, 70, 224, 20);
		p205.add(lblTen205);
		
		btnNhan205 = new Button("Nhận");
		btnNhan205.setEnabled(false);
		btnNhan205.setForeground(Color.WHITE);
		btnNhan205.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNhan205.setBackground(Color.gray);
		btnNhan205.setActionCommand("Nhận");
		btnNhan205.setBounds(10, 150, 69, 25);
		p205.add(btnNhan205);
		
		lblThue205 = new JLabel("");
		lblThue205.setHorizontalAlignment(SwingConstants.CENTER);
		lblThue205.setForeground(Color.WHITE);
		lblThue205.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThue205.setBounds(0, 91, 224, 20);
		p205.add(lblThue205);
		
		lblTra205 = new JLabel("");
		lblTra205.setHorizontalAlignment(SwingConstants.CENTER);
		lblTra205.setForeground(Color.WHITE);
		lblTra205.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTra205.setBounds(0, 113, 224, 20);
		p205.add(lblTra205);
		
		p305 = new JPanel();
		p305.setLayout(null);
		p305.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		p305.setBackground(new Color(147, 112, 219));
		p305.setBounds(1241, 427, 224, 185);
		panelPhong.add(p305);
		
		JLabel lbl305 = new JLabel("305");
		lbl305.setIcon(new ImageIcon(img_std));
		lbl305.setForeground(Color.WHITE);
		lbl305.setHorizontalAlignment(SwingConstants.CENTER);
		lbl305.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbl305.setBounds(0, 0, 224, 46);
		p305.add(lbl305);
		
		btnCN305 = new Button("Cập Nhật");
		btnCN305.setEnabled(false);
		btnCN305.setForeground(Color.WHITE);
		btnCN305.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCN305.setBackground(Color.gray);
		btnCN305.setBounds(85, 150, 129, 25);
		p305.add(btnCN305);
		
		lblcmnd305 = new JLabel("");
		lblcmnd305.setHorizontalAlignment(SwingConstants.CENTER);
		lblcmnd305.setForeground(Color.WHITE);
		lblcmnd305.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcmnd305.setBounds(0, 48, 224, 22);
		p305.add(lblcmnd305);
		
		lblTen305 = new JLabel("");
		lblTen305.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen305.setForeground(Color.WHITE);
		lblTen305.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTen305.setBounds(0, 70, 224, 20);
		p305.add(lblTen305);
		
		btnNhan305 = new Button("Nhận");
		btnNhan305.setEnabled(false);
		btnNhan305.setForeground(Color.WHITE);
		btnNhan305.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNhan305.setBackground(Color.gray);
		btnNhan305.setActionCommand("Nhận");
		btnNhan305.setBounds(10, 150, 69, 25);
		p305.add(btnNhan305);
		
		lblThue305 = new JLabel("");
		lblThue305.setHorizontalAlignment(SwingConstants.CENTER);
		lblThue305.setForeground(Color.WHITE);
		lblThue305.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThue305.setBounds(0, 91, 224, 20);
		p305.add(lblThue305);
		
		lblTra305 = new JLabel("");
		lblTra305.setHorizontalAlignment(SwingConstants.CENTER);
		lblTra305.setForeground(Color.WHITE);
		lblTra305.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTra305.setBounds(0, 113, 224, 20);
		p305.add(lblTra305);
		
		p405 = new JPanel();
		p405.setLayout(null);
		p405.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		p405.setBackground(new Color(147, 112, 219));
		p405.setBounds(1241, 633, 224, 185);
		panelPhong.add(p405);
		
		JLabel lbl405 = new JLabel("405");
		lbl405.setIcon(new ImageIcon(img_vip));
		lbl405.setForeground(Color.WHITE);
		lbl405.setHorizontalAlignment(SwingConstants.CENTER);
		lbl405.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbl405.setBounds(0, 0, 224, 46);
		p405.add(lbl405);
		
		btnCN405 = new Button("Cập Nhật");
		btnCN405.setEnabled(false);
		btnCN405.setForeground(Color.WHITE);
		btnCN405.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCN405.setBackground(Color.gray);
		btnCN405.setBounds(85, 150, 129, 25);
		p405.add(btnCN405);
		
		lblcmnd405 = new JLabel("");
		lblcmnd405.setHorizontalAlignment(SwingConstants.CENTER);
		lblcmnd405.setForeground(Color.WHITE);
		lblcmnd405.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcmnd405.setBounds(0, 48, 224, 22);
		p405.add(lblcmnd405);
		
		lblTen405 = new JLabel("");
		lblTen405.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen405.setForeground(Color.WHITE);
		lblTen405.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTen405.setBounds(0, 70, 224, 20);
		p405.add(lblTen405);
		
		btnNhan405 = new Button("Nhận");
		btnNhan405.setEnabled(false);
		btnNhan405.setForeground(Color.WHITE);
		btnNhan405.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNhan405.setBackground(Color.gray);
		btnNhan405.setActionCommand("Nhận");
		btnNhan405.setBounds(10, 150, 69, 25);
		p405.add(btnNhan405);
		
		lblThue405 = new JLabel("");
		lblThue405.setHorizontalAlignment(SwingConstants.CENTER);
		lblThue405.setForeground(Color.WHITE);
		lblThue405.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThue405.setBounds(0, 91, 224, 20);
		p405.add(lblThue405);
		
		lblTra405 = new JLabel("");
		lblTra405.setHorizontalAlignment(SwingConstants.CENTER);
		lblTra405.setForeground(Color.WHITE);
		lblTra405.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTra405.setBounds(0, 113, 224, 20);
		p405.add(lblTra405);
		
		JPanel pMau1 = new JPanel();
		pMau1.setBorder(new LineBorder(new Color(0, 0, 0)));
		pMau1.setBackground(new Color(50, 205, 50));
		pMau1.setBounds(50, 105, 61, 33);
		add(pMau1);
		
		JPanel pMau2 = new JPanel();
		pMau2.setBorder(new LineBorder(new Color(0, 0, 0)));
		pMau2.setBackground(new Color(255, 165, 0));
		pMau2.setBounds(226, 106, 61, 33);
		add(pMau2);
		
		JPanel pMau3 = new JPanel();
		pMau3.setBorder(new LineBorder(new Color(0, 0, 0)));
		pMau3.setBackground(new Color(147, 112, 219));
		pMau3.setBounds(402, 106, 61, 33);
		add(pMau3);
		
		JButton btnDatPhong = new JButton("Tạo Đơn Đặt Phòng");
		btnDatPhong.setForeground(new Color(255, 255, 255));
		btnDatPhong.setBackground(new Color(65, 105, 225));
		btnDatPhong.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnDatPhong.setBounds(1288, 98, 254, 40);
		add(btnDatPhong);
		
		JLabel lblMau1 = new JLabel(": Đang ở");
		lblMau1.setHorizontalAlignment(SwingConstants.LEFT);
		lblMau1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblMau1.setBounds(123, 106, 91, 33);
		add(lblMau1);
		
		JLabel lblMau2 = new JLabel(": Đã đặt");
		lblMau2.setHorizontalAlignment(SwingConstants.LEFT);
		lblMau2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblMau2.setBounds(299, 106, 91, 33);
		add(lblMau2);
		
		JLabel lblMau3 = new JLabel(": Trống");
		lblMau3.setHorizontalAlignment(SwingConstants.LEFT);
		lblMau3.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblMau3.setBounds(475, 106, 91, 33);
		add(lblMau3);
		
		/*
		 * Nhan phong
		 * 
		 * */
		btnNhan101.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				np.setVisible(true);
				np.getLblTieuDe().setText("NHẬN PHÒNG 101");
				np.hienthiThongTin(lblcmnd101.getText(), "101");
			}
		});
		btnNhan102.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				np.setVisible(true);
				np.getLblTieuDe().setText("NHẬN PHÒNG 102");
				np.hienthiThongTin(lblcmnd102.getText(), "102");
				
			}
		});
		btnNhan103.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				np.setVisible(true);
				np.getLblTieuDe().setText("NHẬN PHÒNG 103");
				np.hienthiThongTin(lblcmnd103.getText(), "103");
				
			}
		});
		btnNhan104.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				np.setVisible(true);
				np.getLblTieuDe().setText("NHẬN PHÒNG 104");
				np.hienthiThongTin(lblcmnd104.getText(), "104");
				
			}
		});
		btnNhan105.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				np.setVisible(true);
				np.getLblTieuDe().setText("NHẬN PHÒNG 105");
				np.hienthiThongTin(lblcmnd105.getText(), "105");
				
			}
		});
		btnNhan201.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				np.setVisible(true);
				np.getLblTieuDe().setText("NHẬN PHÒNG 201");
				np.hienthiThongTin(lblcmnd201.getText(), "201");
				
			}
		});
		btnNhan202.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				np.setVisible(true);
				np.getLblTieuDe().setText("NHẬN PHÒNG 202");
				np.hienthiThongTin(lblcmnd202.getText(), "202");
				
			}
		});
		btnNhan203.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				np.setVisible(true);
				np.getLblTieuDe().setText("NHẬN PHÒNG 203");
				np.hienthiThongTin(lblcmnd203.getText(), "203");
				
			}
		});
		btnNhan204.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				np.setVisible(true);
				np.getLblTieuDe().setText("NHẬN PHÒNG 204");
				np.hienthiThongTin(lblcmnd204.getText(), "204");
				
			}
		});
		btnNhan205.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				np.setVisible(true);
				np.getLblTieuDe().setText("NHẬN PHÒNG 205");
				np.hienthiThongTin(lblcmnd205.getText(), "205");
				
			}
		});
		btnNhan301.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				np.setVisible(true);
				np.getLblTieuDe().setText("NHẬN PHÒNG 301");
				np.hienthiThongTin(lblcmnd301.getText(), "301");
				
			}
		});
		btnNhan302.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				np.setVisible(true);
				np.getLblTieuDe().setText("NHẬN PHÒNG 302");
				np.hienthiThongTin(lblcmnd302.getText(), "302");
				
			}
		});
		btnNhan303.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				np.setVisible(true);
				np.getLblTieuDe().setText("NHẬN PHÒNG 303");
				np.hienthiThongTin(lblcmnd303.getText(), "303");
				
			}
		});
		btnNhan304.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				np.setVisible(true);
				np.getLblTieuDe().setText("NHẬN PHÒNG 304");
				np.hienthiThongTin(lblcmnd304.getText(), "304");
				
			}
		});
		btnNhan305.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				np.setVisible(true);
				np.getLblTieuDe().setText("NHẬN PHÒNG 305");
				np.hienthiThongTin(lblcmnd305.getText(), "305");
				
			}
		});
		btnNhan401.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				np.setVisible(true);
				np.getLblTieuDe().setText("NHẬN PHÒNG 401");
				np.hienthiThongTin(lblcmnd401.getText(), "401");
				
			}
		});
		btnNhan402.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				np.setVisible(true);
				np.getLblTieuDe().setText("NHẬN PHÒNG 402");
				np.hienthiThongTin(lblcmnd402.getText(), "402");
				
			}
		});
		btnNhan403.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				np.setVisible(true);
				np.getLblTieuDe().setText("NHẬN PHÒNG 403");
				np.hienthiThongTin(lblcmnd403.getText(), "403");
				
			}
		});
		btnNhan404.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				np.setVisible(true);
				np.getLblTieuDe().setText("NHẬN PHÒNG 404");
				np.hienthiThongTin(lblcmnd404.getText(), "404");
				
			}
		});
		btnNhan405.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				np.setVisible(true);
				np.getLblTieuDe().setText("CẬP NHẬT PHÒNG 405");
				np.hienthiThongTin(lblcmnd405.getText(), "405");
				
			}
		});
		
		
		
		
		/*
		 * Cap Nhat phong
		 * 
		 * */
		btnCN101.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cnp.setVisible(true);
				cnp.getLblTieuDe().setText("CẬP NHẬT PHÒNG 101");
				cnp.hienthiThongTin(lblcmnd101.getText(), "101");
				
			}
		});
		btnCN102.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cnp.setVisible(true);
				cnp.getLblTieuDe().setText("CẬP NHẬT PHÒNG 102");
				cnp.hienthiThongTin(lblcmnd102.getText(), "102");
			}
		});
		btnCN103.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cnp.setVisible(true);
				cnp.getLblTieuDe().setText("CẬP NHẬT PHÒNG 103");
				cnp.hienthiThongTin(lblcmnd103.getText(), "103");
			}
		});
		btnCN104.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cnp.setVisible(true);
				cnp.getLblTieuDe().setText("CẬP NHẬT PHÒNG 104");
				cnp.hienthiThongTin(lblcmnd104.getText(), "104");
			}
		});
		btnCN105.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cnp.setVisible(true);
				cnp.getLblTieuDe().setText("CẬP NHẬT PHÒNG 105");
				cnp.hienthiThongTin(lblcmnd105.getText(), "105");
			}
		});
		btnCN301.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cnp.setVisible(true);
				cnp.getLblTieuDe().setText("CẬP NHẬT PHÒNG 301");
				cnp.hienthiThongTin(lblcmnd301.getText(), "301");
			}
		});
		btnCN302.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cnp.setVisible(true);
				cnp.getLblTieuDe().setText("CẬP NHẬT PHÒNG 302");
				cnp.hienthiThongTin(lblcmnd302.getText(), "302");
			}
		});
		btnCN303.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cnp.setVisible(true);
				cnp.getLblTieuDe().setText("CẬP NHẬT PHÒNG 303");
				cnp.hienthiThongTin(lblcmnd303.getText(), "303");
			}
		});
		btnCN304.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cnp.setVisible(true);
				cnp.getLblTieuDe().setText("CẬP NHẬT PHÒNG 304");
				cnp.hienthiThongTin(lblcmnd304.getText(), "304");
			}
		});
		btnCN305.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cnp.setVisible(true);
				cnp.getLblTieuDe().setText("CẬP NHẬT PHÒNG 305");
				cnp.hienthiThongTin(lblcmnd305.getText(), "305");
			}
		});
		btnCN201.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cnp.setVisible(true);
				cnp.getLblTieuDe().setText("CẬP NHẬT PHÒNG 201");
				cnp.hienthiThongTin(lblcmnd201.getText(), "201");
			}
		});
		btnCN202.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cnp.setVisible(true);
				cnp.getLblTieuDe().setText("CẬP NHẬT PHÒNG 202");
				cnp.hienthiThongTin(lblcmnd202.getText(), "202");
			}
		});
		btnCN203.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cnp.setVisible(true);
				cnp.getLblTieuDe().setText("CẬP NHẬT PHÒNG 203");
				cnp.hienthiThongTin(lblcmnd203.getText(), "203");
			}
		});
		btnCN204.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cnp.setVisible(true);
				cnp.getLblTieuDe().setText("CẬP NHẬT PHÒNG 204");
				cnp.hienthiThongTin(lblcmnd204.getText(), "204");
			}
		});
		btnCN205.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cnp.setVisible(true);
				cnp.getLblTieuDe().setText("CẬP NHẬT PHÒNG 205");
				cnp.hienthiThongTin(lblcmnd205.getText(), "205");
			}
		});
		btnCN401.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cnp.setVisible(true);
				cnp.getLblTieuDe().setText("CẬP NHẬT PHÒNG 401");
				cnp.hienthiThongTin(lblcmnd401.getText(), "401");
			}
		});
		btnCN402.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cnp.setVisible(true);
				cnp.getLblTieuDe().setText("CẬP NHẬT PHÒNG 402");
				cnp.hienthiThongTin(lblcmnd402.getText(), "402");
			}
		});
		btnCN403.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cnp.setVisible(true);
				cnp.getLblTieuDe().setText("CẬP NHẬT PHÒNG 403");
				cnp.hienthiThongTin(lblcmnd403.getText(), "403");
			}
		});
		btnCN404.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cnp.setVisible(true);
				cnp.getLblTieuDe().setText("CẬP NHẬT PHÒNG 404");
				cnp.hienthiThongTin(lblcmnd404.getText(), "404");
			}
		});
		btnCN405.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cnp.setVisible(true);
				cnp.getLblTieuDe().setText("CẬP NHẬT PHÒNG 405");
				cnp.hienthiThongTin(lblcmnd405.getText(), "405");
			}
		});
		
		
		
		
		/*
		 * Tao don dat phong
		 * 
		 * */
		btnDatPhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dp.setVisible(true);
				dp.getTxtMaNV().setText(h.getLblMaNV().getText());
				dp.getTxtTenNV().setText(h.getLblTenNV().getText());
			}
		});
		
		/*
		 * Hien thi mau cua phong
		 * 
		 * */
		hienthiPhong();
	}
	
	//Hien thi mau cua phong
	public void hienthiPhong() {
		List<HoaDon> hd = new ArrayList<HoaDon>();
		hd = HoaDonRepo.findAllByTrangThaiThanhToan();
		
		for(HoaDon d : hd) {
			for(ChiTietHoaDon ct : d.getListHoaDon()) {
				setMauPhongDat(ct.getMaPhong(), d);
			}
		}
		
	}
	
	
	//Chuyen mau phong da dat, thoi diem hien tai
	public void setMauPhongDat(String tenphong, HoaDon hd) {
		boolean ngayHomNay = hd.getThoiGianTheuDau().isEqual(LocalDate.now());
		switch (tenphong) {
		  case "101":
			  if(kiemtraPhongDaNhan(hd, "101")) {
				  p101.setBackground(new Color(50, 205, 50));
				  btnCN101.setEnabled(true);
				  btnNhan101.setEnabled(false);
				  
				  btnCN101.setBackground(Color.black);
				  btnNhan101.setBackground(Color.gray);
				  
				  lblcmnd101.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen101.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue101.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra101.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }else if(ngayHomNay==true){
				  p101.setBackground(new Color(255, 165, 0));
				  btnCN101.setEnabled(false);
				  btnNhan101.setEnabled(true);
				  
				  btnCN101.setBackground(Color.gray);
				  btnNhan101.setBackground(Color.black);
				  
				  lblcmnd101.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen101.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue101.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra101.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
			  }
		    
		    
		    break;
		  case "102":
			  if(kiemtraPhongDaNhan(hd, "102")) {
				  p102.setBackground(new Color(50, 205, 50));
				  btnCN102.setEnabled(true);
				  btnNhan102.setEnabled(false);
				  
				  btnCN102.setBackground(Color.black);
				  btnNhan102.setBackground(Color.gray);
				  
				  lblcmnd102.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen102.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue102.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra102.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }else if(ngayHomNay==true){
				  p102.setBackground(new Color(255, 165, 0));
				  btnCN102.setEnabled(false);
				  btnNhan102.setEnabled(true);
				  
				  btnCN102.setBackground(Color.gray);
				  btnNhan102.setBackground(Color.black);
				  
				  lblcmnd102.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen102.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue102.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra102.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }
			  
			  
		    break;
		  case "103":
			  if(kiemtraPhongDaNhan(hd, "103")) {
				  p103.setBackground(new Color(50, 205, 50));
				  btnCN103.setEnabled(true);
				  btnNhan103.setEnabled(false);
				  
				  btnCN103.setBackground(Color.black);
				  btnNhan103.setBackground(Color.gray);
				  
				  lblcmnd103.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen103.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue103.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra103.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
				  
			  }else if(ngayHomNay==true) {
				  p103.setBackground(new Color(255, 165, 0));
				  btnCN103.setEnabled(false);
				  btnNhan103.setEnabled(true);
				  
				  btnCN103.setBackground(Color.gray);
				  btnNhan103.setBackground(Color.black);
				  
				  lblcmnd103.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen103.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue103.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra103.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }
			    
			    
		    break;
		  case "104":
			  if(kiemtraPhongDaNhan(hd, "104")) {
				  p104.setBackground(new Color(50, 205, 50));
				  btnCN104.setEnabled(true);
				  btnNhan104.setEnabled(false);
				  
				  btnCN104.setBackground(Color.black);
				  btnNhan104.setBackground(Color.gray);
				  
				  lblcmnd104.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen104.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue104.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra104.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }else if(ngayHomNay==true) {
				  p104.setBackground(new Color(255, 165, 0));
				  btnCN104.setEnabled(false);
				  btnNhan104.setEnabled(true);
				  
				  btnCN104.setBackground(Color.gray);
				  btnNhan104.setBackground(Color.black);
				  
				  lblcmnd104.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen104.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue104.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra104.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
			  }
			    
			    
		    break;
		  case "105":
			  if(kiemtraPhongDaNhan(hd, "105")) {
				  p105.setBackground(new Color(50, 205, 50));
				  btnCN105.setEnabled(true);
				  btnNhan105.setEnabled(false);
				  
				  btnCN105.setBackground(Color.black);
				  btnNhan105.setBackground(Color.gray);
				  
				  lblcmnd105.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen105.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue105.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra105.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }else if(ngayHomNay==true){
				  p105.setBackground(new Color(255, 165, 0));
				  btnCN105.setEnabled(false);
				  btnNhan105.setEnabled(true);
				  
				  btnCN105.setBackground(Color.gray);
				  btnNhan105.setBackground(Color.black);
				  
				  lblcmnd105.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen105.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue105.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra105.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }
			    
			    
		    break;
		  case "201":
			  if(kiemtraPhongDaNhan(hd, "201")) {
				  p201.setBackground(new Color(50, 205, 50));
				  btnCN201.setEnabled(true);
				  btnNhan201.setEnabled(false);
				  
				  btnCN201.setBackground(Color.black);
				  btnNhan201.setBackground(Color.gray);
				  
				  lblcmnd201.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen201.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue201.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra201.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }else if(ngayHomNay==true){
				  p201.setBackground(new Color(255, 165, 0));
				  btnCN201.setEnabled(false);
				  btnNhan201.setEnabled(true);
				  
				  btnCN201.setBackground(Color.gray);
				  btnNhan201.setBackground(Color.black);
				  
				  lblcmnd201.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen201.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue201.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra201.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }
			    
			    
		    break;
		  case "202":
			  if(kiemtraPhongDaNhan(hd, "202")) {
				  p202.setBackground(new Color(50, 205, 50));
				  btnCN202.setEnabled(true);
				  btnNhan202.setEnabled(false);
				  
				  btnCN202.setBackground(Color.black);
				  btnNhan202.setBackground(Color.gray);
				  
				  lblcmnd202.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen202.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue202.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra202.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }else if(ngayHomNay==true) {
				  p202.setBackground(new Color(255, 165, 0));
				  btnCN202.setEnabled(false);
				  btnNhan202.setEnabled(true);
				  
				  btnCN202.setBackground(Color.gray);
				  btnNhan202.setBackground(Color.black);
				  
				  lblcmnd202.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen202.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue202.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra202.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }
			    
			    
		    break;
		  case "203":
			  if(kiemtraPhongDaNhan(hd, "203")) {
				  p203.setBackground(new Color(50, 205, 50));
				  btnCN203.setEnabled(true);
				  btnNhan203.setEnabled(false);
				  
				  btnCN203.setBackground(Color.black);
				  btnNhan203.setBackground(Color.gray);
				  
				  lblcmnd203.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen203.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue203.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra203.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }else if(ngayHomNay==true) {
				  p203.setBackground(new Color(255, 165, 0));
				  btnCN203.setEnabled(false);
				  btnNhan203.setEnabled(true);
				  
				  btnCN203.setBackground(Color.gray);
				  btnNhan203.setBackground(Color.black);
				  
				  lblcmnd203.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen203.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue203.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra203.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }
			    
			    
			break;   
		  case "204":
			  if(kiemtraPhongDaNhan(hd, "204")) {
				  p204.setBackground(new Color(50, 205, 50));
				  btnCN204.setEnabled(true);
				  btnNhan204.setEnabled(false);
				  
				  btnCN204.setBackground(Color.black);
				  btnNhan204.setBackground(Color.gray);
				  
				  lblcmnd204.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen204.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue204.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra204.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }else if(ngayHomNay==true){
				  p204.setBackground(new Color(255, 165, 0));
				  btnCN204.setEnabled(false);
				  btnNhan204.setEnabled(true);
				  
				  btnCN204.setBackground(Color.gray);
				  btnNhan204.setBackground(Color.black);
				  
				  lblcmnd204.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen204.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue204.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra204.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }
			    
			    
			break;
		  case "205":
			  if(kiemtraPhongDaNhan(hd, "205")) {
				  p205.setBackground(new Color(50, 205, 50));
				  btnCN205.setEnabled(true);
				  btnNhan205.setEnabled(false);
				  
				  btnCN205.setBackground(Color.black);
				  btnNhan205.setBackground(Color.gray);
				  
				  lblcmnd205.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen205.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue205.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra205.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
				  
			  }else if(ngayHomNay==true){
				  p205.setBackground(new Color(255, 165, 0));
				  btnCN205.setEnabled(false);
				  btnNhan205.setEnabled(true);
				  
				  btnCN205.setBackground(Color.gray);
				  btnNhan205.setBackground(Color.black);
				  
				  lblcmnd205.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen205.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue205.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra205.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }
			    
			    
			  break;
		  case "301":
			  if(kiemtraPhongDaNhan(hd, "301")) {
				  p301.setBackground(new Color(50, 205, 50));
				  btnCN301.setEnabled(true);
				  btnNhan301.setEnabled(false);
				  
				  btnCN301.setBackground(Color.black);
				  btnNhan301.setBackground(Color.gray);
				  
				  lblcmnd301.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen301.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue301.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra301.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }else if(ngayHomNay==true){
				  p301.setBackground(new Color(255, 165, 0));
				  btnCN301.setEnabled(false);
				  btnNhan301.setEnabled(true);
				  
				  btnCN301.setBackground(Color.gray);
				  btnNhan301.setBackground(Color.black);
				  
				  lblcmnd301.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen301.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue301.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra301.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
			  }
			    
			    
			  break;
		  case "302":
			  if(kiemtraPhongDaNhan(hd, "302")) {
				  p302.setBackground(new Color(50, 205, 50));
				  btnCN302.setEnabled(true);
				  btnNhan302.setEnabled(false);
				  
				  btnCN302.setBackground(Color.black);
				  btnNhan302.setBackground(Color.gray);
				  
				  lblcmnd302.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen302.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue302.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra302.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }else if(ngayHomNay==true) {
				  p302.setBackground(new Color(255, 165, 0));
				  btnCN302.setEnabled(false);
				  btnNhan302.setEnabled(true);
				  
				  btnCN302.setBackground(Color.gray);
				  btnNhan302.setBackground(Color.black);
				  
				  lblcmnd302.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen302.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue302.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra302.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }
			    
			    
			  break;
		  case "303":
			  if(kiemtraPhongDaNhan(hd, "303")) {
				  p303.setBackground(new Color(50, 205, 50));
				  btnCN303.setEnabled(true);
				  btnNhan303.setEnabled(false);
				  
				  btnCN303.setBackground(Color.black);
				  btnNhan303.setBackground(Color.gray);
				  
				  lblcmnd303.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen303.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue303.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra303.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }else if(ngayHomNay==true) {
				  p303.setBackground(new Color(255, 165, 0));
				  btnCN303.setEnabled(false);
				  btnNhan303.setEnabled(true);
				  
				  btnCN303.setBackground(Color.gray);
				  btnNhan303.setBackground(Color.black);
				  
				  lblcmnd303.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen303.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue303.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra303.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
			  }
			    
			    
			  break;
		  case "304":
			  if(kiemtraPhongDaNhan(hd, "304")) {
				  p304.setBackground(new Color(50, 205, 50));
				  btnCN304.setEnabled(true);
				  btnNhan304.setEnabled(false);
				  
				  btnCN304.setBackground(Color.black);
				  btnNhan304.setBackground(Color.gray);
				  
				  lblcmnd304.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen304.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue304.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra304.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }else if(ngayHomNay==true){
				  p304.setBackground(new Color(255, 165, 0));
				  btnCN304.setEnabled(false);
				  btnNhan304.setEnabled(true);
				  
				  btnCN304.setBackground(Color.gray);
				  btnNhan304.setBackground(Color.black);
				  
				  lblcmnd304.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen304.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue304.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra304.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }
			    
			    
			  break;
		  case "305":
			  if(kiemtraPhongDaNhan(hd, "305")) {
				  p305.setBackground(new Color(50, 205, 50));
				  btnCN305.setEnabled(true);
				  btnNhan305.setEnabled(false);
				  
				  btnCN305.setBackground(Color.black);
				  btnNhan305.setBackground(Color.gray);
				  
				  lblcmnd305.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen305.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue305.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra305.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }else if(ngayHomNay==true){
				  p305.setBackground(new Color(255, 165, 0));
				  btnCN305.setEnabled(false);
				  btnNhan305.setEnabled(true);
				  
				  btnCN305.setBackground(Color.gray);
				  btnNhan305.setBackground(Color.black);
				  
				  lblcmnd305.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen305.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue305.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra305.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }
			   
			    
			  break;
		  case "401":
			  if(kiemtraPhongDaNhan(hd, "401")) {
				  p401.setBackground(new Color(50, 205, 50));
				  btnCN401.setEnabled(true);
				  btnNhan401.setEnabled(false);
				  
				  btnCN401.setBackground(Color.black);
				  btnNhan401.setBackground(Color.gray);
				  
				  lblcmnd401.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen401.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue401.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra401.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }else if(ngayHomNay==true){
				  p401.setBackground(new Color(255, 165, 0));
				  btnCN401.setEnabled(false);
				  btnNhan401.setEnabled(true);
				  
				  btnCN401.setBackground(Color.gray);
				  btnNhan401.setBackground(Color.black);
				  
				  lblcmnd401.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen401.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue401.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra401.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }
			    
			    
			  break;
		  case "402":
			  if(kiemtraPhongDaNhan(hd, "402")) {
				  p402.setBackground(new Color(50, 205, 50));
				  btnCN402.setEnabled(true);
				  btnNhan402.setEnabled(false);
				  
				  btnCN402.setBackground(Color.black);
				  btnNhan402.setBackground(Color.gray);
				  
				  lblcmnd402.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen402.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue402.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra402.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }else if(ngayHomNay==true ){
				  p402.setBackground(new Color(255, 165, 0));
				  btnCN402.setEnabled(false);
				  btnNhan402.setEnabled(true);
				  
				  btnCN402.setBackground(Color.gray);
				  btnNhan402.setBackground(Color.black);
				  
				  lblcmnd402.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen402.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue402.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra402.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }
			    
			    
			  break;
		  case "403":
			  if(kiemtraPhongDaNhan(hd, "403")) {
				  p403.setBackground(new Color(50, 205, 50));
				  btnCN403.setEnabled(true);
				  btnNhan403.setEnabled(false);
				  
				  btnCN403.setBackground(Color.black);
				  btnNhan403.setBackground(Color.gray);
				  
				  lblcmnd403.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen403.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue403.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra403.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }else if(ngayHomNay==true){
				  p403.setBackground(new Color(255, 165, 0));
				  btnCN403.setEnabled(false);
				  btnNhan403.setEnabled(true);
				  
				  btnCN403.setBackground(Color.gray);
				  btnNhan403.setBackground(Color.black);
				  
				  lblcmnd403.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen403.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue403.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra403.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }
			    
			    
			  break;
		  case "404":
			  if(kiemtraPhongDaNhan(hd, "404")) {
				  p404.setBackground(new Color(50, 205, 50));
				  btnCN404.setEnabled(true);
				  btnNhan404.setEnabled(false);
				  
				  btnCN404.setBackground(Color.black);
				  btnNhan404.setBackground(Color.gray);
				  
				  lblcmnd404.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen404.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue404.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra404.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }else if(ngayHomNay==true){
				  p404.setBackground(new Color(255, 165, 0));
				  btnCN404.setEnabled(false);
				  btnNhan404.setEnabled(true);
				  
				  btnCN404.setBackground(Color.gray);
				  btnNhan404.setBackground(Color.black);
				  
				  lblcmnd404.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen404.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue404.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra404.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				  
			  }
			    
			    
			  break;
		  case "405":
			  if(kiemtraPhongDaNhan(hd, "405")) {
				  p405.setBackground(new Color(50, 205, 50));
				  btnCN405.setEnabled(true);
				  btnNhan405.setEnabled(false);
				  
				  btnCN405.setBackground(Color.black);
				  btnNhan405.setBackground(Color.gray);
				  
				  lblcmnd405.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen405.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue405.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra405.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				    
				  
			  }else if(ngayHomNay==true){
				  p405.setBackground(new Color(255, 165, 0));
				  btnCN405.setEnabled(false);
				  btnNhan405.setEnabled(true);
				  
				  btnCN405.setBackground(Color.gray);
				  btnNhan405.setBackground(Color.black);
				  
				  lblcmnd405.setText(hd.getKhachHang().getTheCanCuoc());
				  lblTen405.setText(hd.getKhachHang().getTenKhachHang());
				  lblThue405.setText(ngthue+df.format(hd.getThoiGianTheuDau()));
				  lblTra405.setText(ngTra+df.format(hd.getThoiGianTheuCuoi()));
				    
			  }
			    
		    break;
		}
	}
	
	//Kiem tra phong da nhan hay chua
	public boolean kiemtraPhongDaNhan(HoaDon d, String maPhong) {
		for(ChiTietHoaDon c : d.getListHoaDon()) {
			if(c.getMaPhong().equalsIgnoreCase(maPhong)) {
				if(c.getThoiGianTheuDau() == null) {
					return false;
				}
			}
		}
		return true;
	}
	
	//set trong
	public void setTrong() {
		//101
		p101.setBackground(new Color(147, 112, 219));
		
		btnCN101.setForeground(Color.WHITE);
		btnCN101.setEnabled(false);
		btnCN101.setBackground(Color.gray);
		
		btnNhan101.setEnabled(false);
		btnNhan101.setForeground(Color.WHITE);
		btnNhan101.setBackground(Color.gray);
		
		lblcmnd101.setText("");
		lblTen101.setText("");
		lblThue101.setText("");
		lblTra101.setText("");
		
		//102
		p102.setBackground(new Color(147, 112, 219));
		
		btnCN102.setForeground(Color.WHITE);
		btnCN102.setEnabled(false);
		btnCN102.setBackground(Color.gray);
		
		btnNhan102.setEnabled(false);
		btnNhan102.setForeground(Color.WHITE);
		btnNhan102.setBackground(Color.gray);
		
		lblcmnd102.setText("");
		lblTen102.setText("");
		lblThue102.setText("");
		lblTra102.setText("");
		
		//103
		p103.setBackground(new Color(147, 112, 219));
		
		btnCN103.setForeground(Color.WHITE);
		btnCN103.setEnabled(false);
		btnCN103.setBackground(Color.gray);
		
		btnNhan103.setEnabled(false);
		btnNhan103.setForeground(Color.WHITE);
		btnNhan103.setBackground(Color.gray);
		
		lblcmnd103.setText("");
		lblTen103.setText("");
		lblThue103.setText("");
		lblTra103.setText("");
		
		//104
		p104.setBackground(new Color(147, 112, 219));
		
		btnCN104.setForeground(Color.WHITE);
		btnCN104.setEnabled(false);
		btnCN104.setBackground(Color.gray);
		
		btnNhan104.setEnabled(false);
		btnNhan104.setForeground(Color.WHITE);
		btnNhan104.setBackground(Color.gray);
		
		lblcmnd104.setText("");
		lblTen104.setText("");
		lblThue104.setText("");
		lblTra104.setText("");
		
		//105
		p105.setBackground(new Color(147, 112, 219));
		
		btnCN105.setForeground(Color.WHITE);
		btnCN105.setEnabled(false);
		btnCN105.setBackground(Color.gray);
		
		btnNhan105.setEnabled(false);
		btnNhan105.setForeground(Color.WHITE);
		btnNhan105.setBackground(Color.gray);
		
		lblcmnd105.setText("");
		lblTen105.setText("");
		lblThue105.setText("");
		lblTra105.setText("");
		
		//201
		p201.setBackground(new Color(147, 112, 219));
		
		btnCN201.setForeground(Color.WHITE);
		btnCN201.setEnabled(false);
		btnCN201.setBackground(Color.gray);
		
		btnNhan201.setEnabled(false);
		btnNhan201.setForeground(Color.WHITE);
		btnNhan201.setBackground(Color.gray);
		
		lblcmnd201.setText("");
		lblTen201.setText("");
		lblThue201.setText("");
		lblTra201.setText("");
		
		//202
		p202.setBackground(new Color(147, 112, 219));
		
		btnCN202.setForeground(Color.WHITE);
		btnCN202.setEnabled(false);
		btnCN202.setBackground(Color.gray);
		
		btnNhan202.setEnabled(false);
		btnNhan202.setForeground(Color.WHITE);
		btnNhan202.setBackground(Color.gray);
		
		lblcmnd202.setText("");
		lblTen202.setText("");
		lblThue202.setText("");
		lblTra202.setText("");
		
		//203
		p203.setBackground(new Color(147, 112, 219));
		
		btnCN203.setForeground(Color.WHITE);
		btnCN203.setEnabled(false);
		btnCN203.setBackground(Color.gray);
		
		btnNhan203.setEnabled(false);
		btnNhan203.setForeground(Color.WHITE);
		btnNhan203.setBackground(Color.gray);
		
		lblcmnd203.setText("");
		lblTen203.setText("");
		lblThue203.setText("");
		lblTra203.setText("");
		
		//204
		p204.setBackground(new Color(147, 112, 219));
		
		btnCN204.setForeground(Color.WHITE);
		btnCN204.setEnabled(false);
		btnCN204.setBackground(Color.gray);
		
		btnNhan204.setEnabled(false);
		btnNhan204.setForeground(Color.WHITE);
		btnNhan204.setBackground(Color.gray);
		
		lblcmnd204.setText("");
		lblTen204.setText("");
		lblThue204.setText("");
		lblTra204.setText("");
		
		//205
		p205.setBackground(new Color(147, 112, 219));
		
		btnCN205.setForeground(Color.WHITE);
		btnCN205.setEnabled(false);
		btnCN205.setBackground(Color.gray);
		
		btnNhan205.setEnabled(false);
		btnNhan205.setForeground(Color.WHITE);
		btnNhan205.setBackground(Color.gray);
		
		lblcmnd205.setText("");
		lblTen205.setText("");
		lblThue205.setText("");
		lblTra205.setText("");
		
		//301
		p301.setBackground(new Color(147, 112, 219));
		
		btnCN301.setForeground(Color.WHITE);
		btnCN301.setEnabled(false);
		btnCN301.setBackground(Color.gray);
		
		btnNhan301.setEnabled(false);
		btnNhan301.setForeground(Color.WHITE);
		btnNhan301.setBackground(Color.gray);
		
		lblcmnd301.setText("");
		lblTen301.setText("");
		lblThue301.setText("");
		lblTra301.setText("");
		
		//302
		p302.setBackground(new Color(147, 112, 219));
		
		btnCN302.setForeground(Color.WHITE);
		btnCN302.setEnabled(false);
		btnCN302.setBackground(Color.gray);
		
		btnNhan302.setEnabled(false);
		btnNhan302.setForeground(Color.WHITE);
		btnNhan302.setBackground(Color.gray);
		
		lblcmnd302.setText("");
		lblTen302.setText("");
		lblThue302.setText("");
		lblTra302.setText("");
		
		//303
		p303.setBackground(new Color(147, 112, 219));
		
		btnCN303.setForeground(Color.WHITE);
		btnCN303.setEnabled(false);
		btnCN303.setBackground(Color.gray);
		
		btnNhan303.setEnabled(false);
		btnNhan303.setForeground(Color.WHITE);
		btnNhan303.setBackground(Color.gray);
		
		lblcmnd303.setText("");
		lblTen303.setText("");
		lblThue303.setText("");
		lblTra303.setText("");
		
		//304
		p304.setBackground(new Color(147, 112, 219));
		
		btnCN304.setForeground(Color.WHITE);
		btnCN304.setEnabled(false);
		btnCN304.setBackground(Color.gray);
		
		btnNhan304.setEnabled(false);
		btnNhan304.setForeground(Color.WHITE);
		btnNhan304.setBackground(Color.gray);
		
		lblcmnd304.setText("");
		lblTen304.setText("");
		lblThue304.setText("");
		lblTra304.setText("");
		
		//305
		p305.setBackground(new Color(147, 112, 219));
		
		btnCN305.setForeground(Color.WHITE);
		btnCN305.setEnabled(false);
		btnCN305.setBackground(Color.gray);
		
		btnNhan305.setEnabled(false);
		btnNhan305.setForeground(Color.WHITE);
		btnNhan305.setBackground(Color.gray);
		
		lblcmnd305.setText("");
		lblTen305.setText("");
		lblThue305.setText("");
		lblTra305.setText("");
		
		//401
		p401.setBackground(new Color(147, 112, 219));
		
		btnCN401.setForeground(Color.WHITE);
		btnCN401.setEnabled(false);
		btnCN401.setBackground(Color.gray);
		
		btnNhan401.setEnabled(false);
		btnNhan401.setForeground(Color.WHITE);
		btnNhan401.setBackground(Color.gray);
		
		lblcmnd401.setText("");
		lblTen401.setText("");
		lblThue401.setText("");
		lblTra401.setText("");
		
		//402
		p402.setBackground(new Color(147, 112, 219));
		
		btnCN402.setForeground(Color.WHITE);
		btnCN402.setEnabled(false);
		btnCN402.setBackground(Color.gray);
		
		btnNhan402.setEnabled(false);
		btnNhan402.setForeground(Color.WHITE);
		btnNhan402.setBackground(Color.gray);
		
		lblcmnd402.setText("");
		lblTen402.setText("");
		lblThue402.setText("");
		lblTra402.setText("");
		
		//403
		p403.setBackground(new Color(147, 112, 219));
		
		btnCN403.setForeground(Color.WHITE);
		btnCN403.setEnabled(false);
		btnCN403.setBackground(Color.gray);
		
		btnNhan403.setEnabled(false);
		btnNhan403.setForeground(Color.WHITE);
		btnNhan403.setBackground(Color.gray);
		
		lblcmnd403.setText("");
		lblTen403.setText("");
		lblThue403.setText("");
		lblTra403.setText("");
		
		//404
		p404.setBackground(new Color(147, 112, 219));
		
		btnCN404.setForeground(Color.WHITE);
		btnCN404.setEnabled(false);
		btnCN404.setBackground(Color.gray);
		
		btnNhan404.setEnabled(false);
		btnNhan404.setForeground(Color.WHITE);
		btnNhan404.setBackground(Color.gray);
		
		lblcmnd404.setText("");
		lblTen404.setText("");
		lblThue404.setText("");
		lblTra404.setText("");
		
		//405
		p405.setBackground(new Color(147, 112, 219));
		
		btnCN405.setForeground(Color.WHITE);
		btnCN405.setEnabled(false);
		btnCN405.setBackground(Color.gray);
		
		btnNhan405.setEnabled(false);
		btnNhan405.setForeground(Color.WHITE);
		btnNhan405.setBackground(Color.gray);
		
		lblcmnd405.setText("");
		lblTen405.setText("");
		lblThue405.setText("");
		lblTra405.setText("");
		
		
	}
	
}
