package com.hotel.project.gui.home.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotel.project.domain.ChiTietHoaDon;
import com.hotel.project.domain.HoaDon;
import com.hotel.project.domain.Phong;
import com.hotel.project.repository.HoaDonRepository;
import com.hotel.project.repository.PhongRepository;

import javax.annotation.PostConstruct;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.awt.event.ActionEvent;
@Component
public class TraTienGui extends JFrame{
	private JTextField txtTienHD;
	private JTextField txtTienKhachTra;
	private JTextField txtTienThua;
	private JPanel contentPane;
	private JButton btnCompleted;
	private JButton btndong;
	private JLabel lblLoiTin;
	private double TongTienHD=0;
	private HoaDon hd_hienthi;
	DecimalFormat df = new DecimalFormat("###,###,### VNĐ");
	
	@Autowired
	HoaDonGUI hdg ;
	@Autowired
	HoaDonRepository hoaDonRepository;
	@Autowired
	PhongRepository phongrepo;
	public TraTienGui() {
	}
	
	@PostConstruct
	public void preparePanel() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100,700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		JLabel lblTieuDe = new JLabel("THANH TOÁN HÓA ĐƠN");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setForeground(Color.RED);
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblTieuDe.setBounds(12, 13, 676, 29);
		contentPane.add(lblTieuDe);
		
		JLabel lblTienHoaDon = new JLabel("Tổng Tiền Hoá Đơn");
		lblTienHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTienHoaDon.setForeground(Color.BLUE);
		lblTienHoaDon.setBounds(104, 101, 181, 32);
		contentPane.add(lblTienHoaDon);
		
		JLabel lblTienKhach = new JLabel("Số Tiền Khách Đưa");
		lblTienKhach.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTienKhach.setForeground(Color.BLUE);
		lblTienKhach.setBounds(104, 188, 198, 32);
		contentPane.add(lblTienKhach);
		
		JLabel lblRegex = new JLabel("");
		lblRegex.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRegex.setForeground(new Color(255, 0, 0));
		lblRegex.setBounds(314, 267, 322, 32);
		contentPane.add(lblRegex);
		
		JLabel lblTienThua = new JLabel("Số Tiền Thừa");
		lblTienThua.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTienThua.setForeground(Color.BLUE);
		lblTienThua.setBounds(104, 233, 125, 32);
		contentPane.add(lblTienThua);
		
		JComboBox cbbCurrency = new JComboBox();
		cbbCurrency.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cbbCurrency.setModel(new DefaultComboBoxModel(new String[] {"VND"}));
		cbbCurrency.setBounds(338, 144, 241, 32);
		contentPane.add(cbbCurrency);
		
		txtTienHD = new JTextField();
		txtTienHD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTienHD.setBounds(338, 102, 241, 29);
		contentPane.add(txtTienHD);
		txtTienHD.setColumns(10);
		txtTienHD.setEditable(false);
		
		
		txtTienKhachTra = new JTextField();
		txtTienKhachTra.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTienKhachTra.setColumns(10);
		txtTienKhachTra.setBounds(338, 189, 241, 30);
		contentPane.add(txtTienKhachTra);
		
		txtTienThua = new JTextField();
		txtTienThua.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTienThua.setColumns(10);
		txtTienThua.setBounds(338, 233, 241, 32);
		contentPane.add(txtTienThua);
		txtTienThua.setEditable(false);
		
		btnCompleted = new JButton("In Hoá Đơn");
		btnCompleted.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCompleted.setBounds(104, 309, 147, 43);
		contentPane.add(btnCompleted);
		
		btndong = new JButton("Đóng");
		btndong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btndong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btndong.setBounds(476, 304, 103, 43);
		contentPane.add(btndong);
		
		lblLoiTin = new JLabel("Loại Tiền");
		lblLoiTin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblLoiTin.setForeground(Color.BLUE);
		lblLoiTin.setBounds(104, 146, 125, 32);
		contentPane.add(lblLoiTin);
		
		System.out.println();
		btnCompleted.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NumberFormat num = NumberFormat.getNumberInstance();
				// Thông tin hóa đơn
				if (txtTienThua.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Số tiền khách đưa không hợp lệ!");
					return;
				}
				//update trang thai phong
				List<ChiTietHoaDon> list_cthd_hienthi = hd_hienthi.getListHoaDon();
				for(ChiTietHoaDon ct : list_cthd_hienthi) {
					Phong p = phongrepo.findByMaPhong(ct.getMaPhong());
					phongrepo.updatePhong(p, ct.getLoaiPhong(), true);
				}
				
				//update hoa don
				hoaDonRepository.updateTongTien(hd_hienthi.getKhachHang().getTheCanCuoc(), hd_hienthi.getThoiGianLHD(),TongTienHD);
				hoaDonRepository.updateTGTP(hd_hienthi.getKhachHang().getTheCanCuoc(), hd_hienthi.getThoiGianLHD(), LocalDateTime.now());
				hoaDonRepository.updateTrangThai(hd_hienthi.getKhachHang().getTheCanCuoc(), hd_hienthi.getThoiGianLHD());
				
				Bill.hd = hd_hienthi;
				Bill.maHD = hd_hienthi.getMaHoaDon().toString();
				Bill.TongTienHD= TongTienHD;
				double qqq;
				try {
					qqq = num.parse(txtTienKhachTra.getText()).doubleValue();
					System.out.println("  sss  "+qqq);
					Bill.TienKhachDua= qqq;
					
					Bill.TienThua = df.parse(txtTienThua.getText()).doubleValue();
					Bill bill = new Bill();
					PrintSupport.printComponent(Bill.textArea);
					//bill.setVisible(true);
					String cmds[] = new String[] {"cmd", "/c", "D:\\b.pdf"};
					try {
						Runtime.getRuntime().exec(cmds);
					}catch (Exception e1) {
						// TODO: handle exception
					}	
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				hdg.setVisible(false);
				setVisible(false);
				
			
			}
		});
		txtTienKhachTra.addKeyListener(new KeyAdapter() {		
			public boolean isNumeric(String str) {
				  return str.matches("\\d");  //match a number with optional '-' and decimal. "-?\\d+(\\.\\d+)?"
				}
			@Override
			public void keyReleased(KeyEvent e) {
				double money;
				NumberFormat num = NumberFormat.getNumberInstance();
				if (txtTienKhachTra.getText().equalsIgnoreCase("")) {
					lblRegex.setText("");
				}
				else if(isNumeric(txtTienKhachTra.getText().substring(txtTienKhachTra.getText().length()-1))==true)
					try {
						money = num.parse(txtTienKhachTra.getText()).doubleValue();
						txtTienKhachTra.setText(num.format(money));
						lblRegex.setText("");	
						double cusMoney = 0;
						if (!txtTienKhachTra.getText().equalsIgnoreCase(""))		
								cusMoney = num.parse(txtTienKhachTra.getText()).doubleValue();
						double total;
						
						//total = df.parse(txtTienHD.getText()).doubleValue();
						total = TongTienHD;
						double tamp = 0;
						if(cusMoney >= total) {
							tamp = cusMoney - total;
							txtTienThua.setText(String.valueOf(df.format(tamp)));
						}
						else
							txtTienThua.setText("");
					} catch (NumberFormatException | ParseException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
						lblRegex.setText("Vui lòng nhập ký tự số!");
					}
				else
					lblRegex.setText("Vui lòng nhập ký tự số!");
			}
		});
		btndong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
	public void dienThongTinTraTien(double TongTienHD,HoaDon hd_hienthi) {
		this.TongTienHD=TongTienHD;
		String a= df.format(TongTienHD);
		txtTienHD.setText(a);
		this.hd_hienthi=hd_hienthi;
	}
}
