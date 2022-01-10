package com.hotel.project.gui.home.view;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;

public class ThongKePanel extends JFrame {

	/**
	 * Create the panel.
	 */
	private ThongKe_GUI thongKe_GUI;
	private ThongKeTheoNam thongKeTheoNam;
	private JTextField txtThoongsK;
	private JTextField txtThngKDch;
	private JTextField txtThngKDch_1;
	public ThongKePanel() {
		
		setBounds(359, 0, 1543, 1008);
		setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblThngKDoanh = new JLabel("THỐNG KÊ");
		lblThngKDoanh.setForeground(Color.RED);
		lblThngKDoanh.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngKDoanh.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblThngKDoanh.setBounds(255, 13, 1014, 77);
		getContentPane().add(lblThngKDoanh);
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
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		lblNewLabel.setBounds(-12, 0, 357, 118);
		
		ImageIcon icon=new ImageIcon(ThongKePanel.class.getResource("/com/hotel/project/gui/thongke/image/ThongKeImg1.png"));
		Image img=icon.getImage();
		Image imageScale=img.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon=new ImageIcon(imageScale);
		lblNewLabel.setIcon(scaledIcon);
		
		
		
		panel.add(lblNewLabel);
		
		JTextPane txtpnDsadsad = new JTextPane();
		txtpnDsadsad.setText("Thống kê doanh thu theo tháng");
		txtpnDsadsad.setBounds(31, 135, 273, 40);
		panel.add(txtpnDsadsad);
		
		txtThoongsK = new JTextField();
		txtThoongsK.setText("  Thống kê doanh thu");
		txtThoongsK.setBounds(0, 164, 1525, 41);
		getContentPane().add(txtThoongsK);
		txtThoongsK.setColumns(10);
		lblNewLabel.setIcon(scaledIcon);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(476, 237, 10, -1);
		getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(400, 224, 345, 188);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 0, 345, 118);
		lblNewLabel_1.setBackground(Color.YELLOW);
		lblNewLabel_1.setIcon(scaledIcon);
		panel_2.add(lblNewLabel_1);
		
		JTextPane txtpnThngKDoanh = new JTextPane();
		txtpnThngKDoanh.setBounds(31, 131, 271, 44);
		panel_2.add(txtpnThngKDoanh);
		txtpnThngKDoanh.setText("Thống kê doanh thu theo năm");
		
		txtThngKDch = new JTextField();
		txtThngKDch.setText("Thống kê phòng");
		txtThngKDch.setColumns(10);
		txtThngKDch.setBounds(0, 443, 1525, 41);
		getContentPane().add(txtThngKDch);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(22, 497, 345, 188);
		getContentPane().add(panel_3);
		
		
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
		txtpnDsadsad_1.setBounds(30, 132, 315, 31);
		panel_3.add(txtpnDsadsad_1);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBackground(Color.WHITE);
		panel_2_2.setBounds(400, 497, 345, 188);
		getContentPane().add(panel_2_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setBackground(Color.YELLOW);
		lblNewLabel_1_1.setIcon(scaledIcon1);
		lblNewLabel_1_1.setBounds(0, 0, 345, 120);
		panel_2_2.add(lblNewLabel_1_1);
		
		JTextPane txtpnThngKDoanh_2 = new JTextPane();
		txtpnThngKDoanh_2.setText("Thống kê phòng theo năm");
		txtpnThngKDoanh_2.setBounds(22, 133, 292, 30);
		panel_2_2.add(txtpnThngKDoanh_2);
		
		txtThngKDch_1 = new JTextField();
		txtThngKDch_1.setText("Thống kê dịch vụ");
		txtThngKDch_1.setColumns(10);
		txtThngKDch_1.setBounds(0, 708, 1525, 41);
		getContentPane().add(txtThngKDch_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(Color.WHITE);
		panel_3_1.setBounds(22, 762, 345, 188);
		getContentPane().add(panel_3_1);
		
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
		txtpnDsadsad_1_1.setBounds(30, 132, 315, 22);
		panel_3_1.add(txtpnDsadsad_1_1);
		
		JPanel panel_2_2_1 = new JPanel();
		panel_2_2_1.setLayout(null);
		panel_2_2_1.setBackground(Color.WHITE);
		panel_2_2_1.setBounds(400, 762, 345, 188);
		getContentPane().add(panel_2_2_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("New label");
		lblNewLabel_1_1_1.setBackground(Color.YELLOW);
		lblNewLabel_1_1_1.setIcon(scaledIcon2);
		lblNewLabel_1_1_1.setBounds(0, 0, 345, 120);
		panel_2_2_1.add(lblNewLabel_1_1_1);
		
		JTextPane txtpnThngKDoanh_2_1 = new JTextPane();
		txtpnThngKDoanh_2_1.setText("Thống kê phòng theo năm");
		txtpnThngKDoanh_2_1.setBounds(51, 133, 229, 22);
		panel_2_2_1.add(txtpnThngKDoanh_2_1);
	

	}
	public static void main(String[] args) {
		
		ThongKePanel thongKePanel=new ThongKePanel();
		thongKePanel.setVisible(true);
	}
}
