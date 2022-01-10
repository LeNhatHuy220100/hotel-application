package com.hotel.project.gui.home.view;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.annotation.PostConstruct;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

@Component
public class About extends JFrame {

	private JPanel contentPane;
	private Image img_logo = new ImageIcon(Home.class.getResource("/com/hotel/project/gui/home/image/logo.jpg")).getImage().getScaledInstance(270, 180, Image.SCALE_SMOOTH);

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() {
		
	}
	
	@PostConstruct
	public void preparePane() {
		
		setSize(800, 440);
		setResizable(false);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 311, 408);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(0, 24, 307, 289);
		lblLogo.setIcon(new ImageIcon(img_logo));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblLogo);
		
		JLabel lblNewLabel = new JLabel("FRESH  - Chương trình quản lý đặt phòng khách sạn\r\n");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(326, 8, 543, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblVersion = new JLabel("Version 1.0\r\n\r\n");
		lblVersion.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblVersion.setBounds(326, 34, 545, 33);
		contentPane.add(lblVersion);
		
		JLabel lblFreshLChng = new JLabel("FRESH là chương trình quản lý đặt phòng khách sạn.\r\n");
		lblFreshLChng.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblFreshLChng.setBounds(324, 78, 543, 44);
		contentPane.add(lblFreshLChng);
		
		JLabel lblNewLabel_1_1 = new JLabel("FRESH chạy trên  hệ điều hành Windows 10.\r\n\r\n");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(324, 104, 543, 45);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\r\n         Phạm Quý Phong: Nhóm trưởng\r\n         ");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(327, 174, 543, 40);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("         Trần Ngọc Hiển");
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(327, 200, 543, 39);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Các thành viên dự án FRESH:\r\n");
		lblNewLabel_1_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_2_2.setBounds(325, 149, 543, 41);
		contentPane.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("\r\n         Lê Tuấn Tú");
		lblNewLabel_1_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_2_1_1.setBounds(330, 227, 543, 33);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Liên lạc:\r\n");
		lblNewLabel_1_2_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_2_1_2.setBounds(328, 292, 543, 40);
		contentPane.add(lblNewLabel_1_2_1_2);
		
		JLabel lblNewLabel_1_2_1_3 = new JLabel("         Lê Nhật Huy\r\n\r\n ");
		lblNewLabel_1_2_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_2_1_3.setBounds(330, 247, 543, 36);
		contentPane.add(lblNewLabel_1_2_1_3);
		
		JLabel lblNewLabel_1_2_1_4 = new JLabel("         Phạm Quý Phong: fresh@gmail.com");
		lblNewLabel_1_2_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_2_1_4.setBounds(327, 315, 543, 51);
		contentPane.add(lblNewLabel_1_2_1_4);
	}
}

