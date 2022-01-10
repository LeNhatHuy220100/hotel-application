package com.hotel.project.gui.home.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.annotation.PostConstruct;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuanLyThongKeGUI extends JPanel{
	@Autowired
	private ThongKe_GUI thongKe_GUI;
	@Autowired
	private ThongKeTheoNam thongKeTheoNam;
	@Autowired
	private ThongKePhongThangGUI thongKePhongThangGUI;
	@Autowired
	private ThongKeDichVuThangGUI thongKeDichVuThangGUI;
	@Autowired
	private ThongKePhongNamGUI thongKePhongNamGUI;
	@Autowired
	private ThongKeDichVuTheoNam thongKeDichVuTheoNam;
	
	private JTextField txtThoongsK;
	private JTextField txtThngKDch;
	private JTextField txtThngKDch_1;
	public QuanLyThongKeGUI() {
		// TODO Auto-generated constructor stub
	}
	@PostConstruct
	public void prepare() {
		setBounds(359, 0, 1543, 1008);
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblThngKDoanh = new JLabel("THỐNG KÊ");
		lblThngKDoanh.setForeground(Color.RED);
		lblThngKDoanh.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngKDoanh.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblThngKDoanh.setBounds(255, 13, 1014, 77);
		add(lblThngKDoanh);
		ButtonGroup group= new ButtonGroup();
		
		//----------------------- Hiện thị danh sách hóa đơn -------------------
		
	
		
		/*
		 * JButton btnQuayV = new JButton("Quay về"); btnQuayV.setFont(new
		 * Font("Times New Roman", Font.PLAIN, 32)); btnQuayV.setBounds(86, 671, 174,
		 * 56); add(btnQuayV);
		 */
		
		JLabel lblTieuDe;
		lblTieuDe = new JLabel("THỐNG KÊ DOANH THU");
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		lblTieuDe.setForeground(Color.green);
		Box b = Box.createVerticalBox();
		b.add(lblTieuDe);
		
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				thongKe_GUI.setVisible(true);
			}
		});
		
		panel.setBackground(Color.WHITE);
		panel.setBounds(22, 224, 345, 188);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-12, 0, 357, 118);
		
		ImageIcon icon=new ImageIcon(ThongKePanel.class.getResource("/com/hotel/project/gui/thongke/image/ThongKeImg1.png"));
		Image img=icon.getImage();
		Image imageScale=img.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon=new ImageIcon(imageScale);
		lblNewLabel.setIcon(scaledIcon);
		
		
		
		panel.add(lblNewLabel);
		
		JTextPane txtpnDsadsad = new JTextPane();
		txtpnDsadsad.setText("Thống kê doanh thu theo tháng");
		txtpnDsadsad.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtpnDsadsad.setBounds(31, 135, 273, 40);
		panel.add(txtpnDsadsad);
		
		txtThoongsK = new JTextField();
		txtThoongsK.setText("  Thống kê doanh thu");
		txtThoongsK.setFont(new Font("Arial", Font.BOLD, 20));
		txtThoongsK.setBounds(0, 164, 1525, 41);
		add(txtThoongsK);
		txtThoongsK.setColumns(10);
		lblNewLabel.setIcon(scaledIcon);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(476, 237, 10, -1);
		add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(400, 224, 345, 188);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 0, 345, 118);
		lblNewLabel_1.setBackground(Color.YELLOW);
		lblNewLabel_1.setIcon(scaledIcon);
		panel_2.add(lblNewLabel_1);
		
		JTextPane txtpnThngKDoanh = new JTextPane();
		txtpnThngKDoanh.setBounds(31, 131, 273, 40);
		panel_2.add(txtpnThngKDoanh);
		txtpnThngKDoanh.setText("Thống kê doanh thu theo năm");
		txtpnThngKDoanh.setFont(new Font("Times New Roman", Font.BOLD, 20));
	
		
		txtThngKDch = new JTextField();
		txtThngKDch.setText("Thống kê phòng");
		txtThngKDch.setFont(new Font("Arial", Font.BOLD, 20));
		txtThngKDch.setColumns(10);
		txtThngKDch.setBounds(0, 443, 1525, 41);
		add(txtThngKDch);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(22, 497, 345, 188);
		add(panel_3);
		
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		ImageIcon icon1=new ImageIcon(ThongKePanel.class.getResource("/com/hotel/project/gui/thongke/image/ThonKeImg2.png"));
		Image img1=icon1.getImage();
		Image imageScale1=img1.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon1=new ImageIcon(imageScale1);
		
		lblNewLabel_2.setIcon(scaledIcon1);
		lblNewLabel_2.setBounds(0, 0, 345, 118);
		panel_3.add(lblNewLabel_2);
		
		JTextPane txtpnDsadsad_1 = new JTextPane();
		txtpnDsadsad_1.setText("Thống kê phòng theo tháng");
		txtpnDsadsad_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtpnDsadsad_1.setBounds(30, 132, 273, 40);
		panel_3.add(txtpnDsadsad_1);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBackground(Color.WHITE);
		panel_2_2.setBounds(400, 497, 345, 188);
		add(panel_2_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setBackground(Color.YELLOW);
		lblNewLabel_1_1.setIcon(scaledIcon1);
		lblNewLabel_1_1.setBounds(0, 0, 345, 120);
		panel_2_2.add(lblNewLabel_1_1);
		
		JTextPane txtpnThngKDoanh_2 = new JTextPane();
		txtpnThngKDoanh_2.setText("Thống kê phòng theo năm");
		txtpnThngKDoanh_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtpnThngKDoanh_2.setBounds(51, 133, 273, 40);
		panel_2_2.add(txtpnThngKDoanh_2);
		
		
		txtThngKDch_1 = new JTextField();
		txtThngKDch_1.setText("Thống kê dịch vụ");
		txtThngKDch_1.setFont(new Font("Arial", Font.BOLD, 20));
		txtThngKDch_1.setColumns(10);
		txtThngKDch_1.setBounds(0, 708, 1525, 41);
		add(txtThngKDch_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(Color.WHITE);
		panel_3_1.setBounds(22, 762, 345, 188);
		add(panel_3_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("New label");
		ImageIcon icon2=new ImageIcon(ThongKePanel.class.getResource("/com/hotel/project/gui/thongke/image/ThongKeImg3.png"));
		Image img2=icon2.getImage();
		Image imageScale2=img2.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon2=new ImageIcon(imageScale2);
		lblNewLabel_2_1.setIcon(scaledIcon2);
		lblNewLabel_2_1.setBounds(0, 0, 345, 118);
		panel_3_1.add(lblNewLabel_2_1);
		
		JTextPane txtpnDsadsad_1_1 = new JTextPane();
		txtpnDsadsad_1_1.setText("Thống kê phòng theo tháng");
		txtpnDsadsad_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtpnDsadsad_1_1.setBounds(30, 132,273, 40);
		panel_3_1.add(txtpnDsadsad_1_1);
		
		JPanel panel_2_2_1 = new JPanel();
		panel_2_2_1.setLayout(null);
		panel_2_2_1.setBackground(Color.WHITE);
		panel_2_2_1.setBounds(400, 762, 345, 188);
		add(panel_2_2_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("New label");
		lblNewLabel_1_1_1.setBackground(Color.YELLOW);
		lblNewLabel_1_1_1.setIcon(scaledIcon2);
		lblNewLabel_1_1_1.setBounds(0, 0, 345, 120);
		panel_2_2_1.add(lblNewLabel_1_1_1);
		
		JTextPane txtpnThngKDoanh_2_1 = new JTextPane();
		txtpnThngKDoanh_2_1.setText("Thống kê phòng theo năm");
		txtpnThngKDoanh_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtpnThngKDoanh_2_1.setBounds(51, 133, 273, 40);
		panel_2_2_1.add(txtpnThngKDoanh_2_1);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				thongKe_GUI.setVisible(true);
			}
		});
		
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				thongKeTheoNam.setVisible(true);
			}
		});
		panel_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				thongKePhongNamGUI.setVisible(true);
			}
		});
		
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				thongKePhongThangGUI.setVisible(true);
			}
		});
		panel_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				thongKeDichVuThangGUI.setVisible(true);
			}
		});
		panel_2_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				thongKeDichVuTheoNam.setVisible(true);
			}
		});
	}
}
