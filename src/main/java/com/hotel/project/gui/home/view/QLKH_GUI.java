package com.hotel.project.gui.home.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotel.project.domain.HoaDon;
import com.hotel.project.domain.KhachHang;
import com.hotel.project.repository.HoaDonRepository;
import com.hotel.project.repository.KhachHangRepository;

import javax.swing.JComboBox;
import javax.annotation.PostConstruct;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JRadioButton;
@Component
public class QLKH_GUI extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaKH;
	private JTable table;
	private JTextField txtTenKH;
	private JTextField txtCanCuoc;
	private JTextField txtSDT;
	private JTextField txtTimKiem;
	
	@Autowired
	private KhachHangRepository khachHangRepository;
	@Autowired
	private HoaDonRepository hoadonRepository;
	private JComboBox cbxLoaiKH;
	private DefaultTableModel model;
	private List<KhachHang> listKH;
	private JRadioButton rdbtnTheoCnCc;
	private JRadioButton rdbtnTheoHTn;
	/**
	 * Create the panel.
	 */
	@PostConstruct
	public void prepaPanel() {
		//setSize(1014,715);
			setBounds(303, 0, 1599, 1008);
			setBackground(new Color(255,255,255));
			setLayout(null);
			
			JLabel lblQunLKhch = new JLabel("QUẢN LÝ KHÁCH HÀNG");
			lblQunLKhch.setForeground(Color.RED);
			lblQunLKhch.setFont(new Font("Times New Roman", Font.BOLD, 30));
			lblQunLKhch.setHorizontalAlignment(SwingConstants.CENTER);
			lblQunLKhch.setBounds(0, 0, 1599, 59);
			add(lblQunLKhch);
			
			JLabel lblNewLabel = new JLabel("Mã KH:");
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lblNewLabel.setBounds(83, 145, 70, 31);
			add(lblNewLabel);
			
			JLabel lblTnKh = new JLabel("Tên KH:");
			lblTnKh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lblTnKh.setBounds(83, 213, 70, 25);
			add(lblTnKh);
			
			JLabel lblThCnCc = new JLabel("Căn Cước:");
			lblThCnCc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lblThCnCc.setBounds(544, 142, 126, 37);
			add(lblThCnCc);
			
			JLabel lblSt = new JLabel("Số ĐT:");
			lblSt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lblSt.setBounds(544, 213, 70, 25);
			add(lblSt);
			
			txtMaKH = new JTextField();
			txtMaKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtMaKH.setBounds(184, 141, 270, 39);
			txtMaKH.setEnabled(false);
			add(txtMaKH);
			txtMaKH.setColumns(10);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(58, 313, 1509, 677);
			add(scrollPane);
			
			table = new JTable();
			model = new DefaultTableModel(
					new String[] {
							"STT","T\u00EAn KH", "Th\u1EBB C\u0103n C\u01B0\u1EDBc", "S\u1ED1 \u0110T", "Lo\u1EA1i KH"
					}, 0){
			    public boolean isCellEditable(int row, int column)
			    {
			      return false;//This causes all cells to be not editable
			    }
			  };
			table.setModel(model);
			scrollPane.setViewportView(table);
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
			
			/**
			 * Doc du lieu vao bang
			 */
			docDLNVVaoBang();
				
			JButton btnThm = new JButton("Thêm");
			btnThm.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnThm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnThm.setBounds(1051, 207, 84, 37);
			add(btnThm);
			
			JButton btnXa = new JButton("Xóa");
			btnXa.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnXa.setBounds(1297, 207, 84, 37);
			add(btnXa);
			
			JButton btnSa = new JButton("Sửa");
			btnSa.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnSa.setBounds(1176, 207, 84, 37);
			add(btnSa);
			
			JLabel lblLoiKh = new JLabel("Loại KH:");
			lblLoiKh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lblLoiKh.setBounds(1054, 140, 122, 36);
			add(lblLoiKh);
			
			cbxLoaiKH = new JComboBox();
			cbxLoaiKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
			cbxLoaiKH.setModel(new DefaultComboBoxModel(new String[] {"Khách hàng ở", "Khách hàng đặt phòng"}));
			cbxLoaiKH.setBounds(1155, 135, 270, 39);
			add(cbxLoaiKH);
			
			txtTenKH = new JTextField();
			txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtTenKH.setColumns(10);
			txtTenKH.setBounds(184, 206, 270, 39);
			add(txtTenKH);
			
			txtCanCuoc = new JTextField();
			txtCanCuoc.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtCanCuoc.setColumns(10);
			txtCanCuoc.setBounds(645, 137, 270, 39);
			add(txtCanCuoc);
			
			txtSDT = new JTextField();
			txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtSDT.setColumns(10);
			txtSDT.setBounds(645, 206, 270, 39);
			add(txtSDT);
			
			JButton btnXaR = new JButton("Xóa Rỗng");
			btnXaR.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnXaR.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnXaR.setBounds(1418, 207, 104, 37);
			add(btnXaR);
			
			JLabel lblTmKimKh = new JLabel("Tìm kiếm KH:");
			lblTmKimKh.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblTmKimKh.setBounds(462, 52, 122, 34);
			add(lblTmKimKh);
			
			txtTimKiem = new JTextField();
			txtTimKiem.setBounds(594, 52, 173, 34);
			txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
			add(txtTimKiem);
			txtTimKiem.setColumns(10);
			
			rdbtnTheoCnCc = new JRadioButton("Theo căn cước");
			rdbtnTheoCnCc.setFont(new Font("Tahoma", Font.PLAIN, 20));
			rdbtnTheoCnCc.setBounds(773, 53, 161, 31);
			rdbtnTheoCnCc.setBackground(new Color(255,255,255));
			rdbtnTheoCnCc.setSelected(true);
			
			rdbtnTheoHTn = new JRadioButton("Theo họ tên");
			rdbtnTheoHTn.setFont(new Font("Tahoma", Font.PLAIN, 20));
			rdbtnTheoHTn.setBounds(936, 53, 142, 31);
			rdbtnTheoHTn.setBackground(new Color(255,255,255));
			
			ButtonGroup group1= new ButtonGroup();
			group1.add(rdbtnTheoCnCc);
			group1.add(rdbtnTheoHTn);
			add(rdbtnTheoCnCc);
			add(rdbtnTheoHTn);
			
			JButton btnLoad = new JButton("Load\r\n");
			btnLoad.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			btnLoad.setBounds(1476, 278, 73, 31);
			add(btnLoad);
			
			JButton btnTm = new JButton("Tìm");
			btnTm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnTm.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnTm.setBounds(1086, 53, 93, 33);
			add(btnTm);
			
			JPanel panelTTP = new JPanel();
			panelTTP.setBorder((Border) new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin Khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 120, 215)));
			panelTTP.setBounds(58, 96, 1493, 178);
			add(panelTTP);
			panelTTP.setLayout(null);
			panelTTP.setBackground(new Color(255,255,255));
			
			/**
			 * Doc du lieu len textfield
			 */
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int row = table.getSelectedRow();
					KhachHang kh= khachHangRepository.findByTheCanCuoc(model.getValueAt(row, 2).toString());
					txtMaKH.setText(kh.getMaKhachHang().toString());
					txtTenKH.setText(model.getValueAt(row, 1).toString());
					txtCanCuoc.setText(model.getValueAt(row, 2).toString());
					txtSDT.setText(model.getValueAt(row, 3).toString());
					if(model.getValueAt(row, 4).toString()=="Khách hàng ở")
						cbxLoaiKH.setSelectedItem("Khách hàng ở");
					else
						cbxLoaiKH.setSelectedItem("Khách hàng đặt phòng");
				}
			});
			
			btnThm.addActionListener (new ActionListener () {
				@Override
				public void actionPerformed(ActionEvent e) {
					themKH();
					
				}
			});
			
			btnXa.addActionListener (new ActionListener () {
				@Override
				public void actionPerformed(ActionEvent e) {
					xoaKH();
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
								KhachHang kh= new KhachHang(txtTenKH.getText().trim(), txtCanCuoc.getText(), txtSDT.getText(), xetLoaiKHTrenMongo(cbxLoaiKH.getSelectedItem().toString()));
								khachHangRepository.updateKh(kh,txtMaKH.getText());
								String cc= model.getValueAt(t, 2).toString();
								List<HoaDon> hd= hoadonRepository.findAllByTrangThaiThanhToanVaCC(cc);
								for (HoaDon h : hd) {
									hoadonRepository.updateKhTrongHD(kh,h.getMaHoaDon().toString());
								}
								
								model.setValueAt(txtTenKH.getText().trim(), t, 1);
								model.setValueAt(txtSDT.getText(), t, 3);
								model.setValueAt(cbxLoaiKH.getSelectedItem().toString(), t, 4);
								JOptionPane.showMessageDialog(null, "Sửa thành công !!!!");									
							}
						}
					}
				}
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
			
			txtTimKiem.addKeyListener((KeyListener) new KeyAdapter() {

				  public void keyPressed(KeyEvent e) {
				    if (e.getKeyCode()==KeyEvent.VK_ENTER){
				    	timKiem();
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
			
			txtTenKH.addKeyListener((KeyListener) new KeyAdapter() {

				  public void keyPressed(KeyEvent e) {
				    if (e.getKeyCode()==KeyEvent.VK_ENTER){
				    	themKH();
				    }
				  }
				});
			
			txtCanCuoc.addKeyListener((KeyListener) new KeyAdapter() {

				  public void keyPressed(KeyEvent e) {
				    if (e.getKeyCode()==KeyEvent.VK_ENTER){
				    	themKH();
				    }
				  }
				});
			
			txtSDT.addKeyListener((KeyListener) new KeyAdapter() {

				  public void keyPressed(KeyEvent e) {
				    if (e.getKeyCode()==KeyEvent.VK_ENTER){
				    	themKH();
				    }
				  }
				});
			
			cbxLoaiKH.addKeyListener((KeyListener) new KeyAdapter() {

				  public void keyPressed(KeyEvent e) {
				    if (e.getKeyCode()==KeyEvent.VK_ENTER){
				    	themKH();
				    }
				  }
				});
			
			table.addKeyListener((KeyListener) new KeyAdapter() {

				  public void keyPressed(KeyEvent e) {
				    if (e.getKeyCode()==KeyEvent.VK_DELETE){
				    	xoaKH();
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
	
	public void themKH() {
		if(ktKHCoChua()&&ktRegex()) {
			KhachHang kh= new KhachHang(txtTenKH.getText().trim(),txtCanCuoc.getText(), txtSDT.getText(), xetLoaiKHTrenMongo(cbxLoaiKH.getSelectedItem().toString()));
			kh.toString();
			khachHangRepository.add(kh);
			model.addRow(new Object[] {
					model.getRowCount()+1,kh.getTenKhachHang(),kh.getTheCanCuoc(),kh.getSoDienThoai(),xetLoaiKHTrenTable(kh.isLoaiKhachHang())
			});
			xoaTrang();
		}
	}
	
	public void timKiem() {
		if(regexTimKiem()) {
			if(rdbtnTheoHTn.isSelected()) {
				List<KhachHang> khs=khachHangRepository.findByTenKh(txtTimKiem.getText());
				if(khs.size()!=0) {
					xoaHetModelTable();
					int i=1;
					for (KhachHang kh : khs) {
						model.addRow(new Object[] {
								i++,kh.getTenKhachHang(),kh.getTheCanCuoc(),kh.getSoDienThoai(),xetLoaiKHTrenTable(kh.isLoaiKhachHang())
						});
					}
				}
				else {
					showMessage("Không tìm thấy !!!!", txtTimKiem);
				}
			}
			else {
				KhachHang kh=khachHangRepository.findByTheCanCuoc(txtTimKiem.getText());
				if(kh!=null) {
					xoaHetModelTable();
					model.addRow(new Object[] {
							1,kh.getTenKhachHang(),kh.getTheCanCuoc(),kh.getSoDienThoai(),xetLoaiKHTrenTable(kh.isLoaiKhachHang())
					});
				}else
					showMessage("Không tìm thấy !!!!", txtTimKiem);
			}
		}
	}
	
	public void xoaKH() {
//		int t= table.getSelectedRow();
//		if(t==-1)
//			JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng cần xóa !!!!");
//		else {
//			int r= JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa không ???","Xóa",JOptionPane.YES_NO_OPTION);
//			if(r==JOptionPane.YES_OPTION) {
//				//XÃ³a Array List
//				String ma= txtMaKH.getText();
//				khachHangRepository.xoaKhTheoMa(ma);
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
					khachHangRepository.xoaKhTheoCanCuoc(table.getModel().getValueAt(rows[i], 2).toString());
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
//					KhachHang kh= new KhachHang(txtTenKH.getText(), txtCanCuoc.getText(), txtSDT.getText(), xetLoaiKHTrenMongo(cbxLoaiKH.getSelectedItem().toString()));
					String ccm=txtCanCuoc.getText();
					String cc= model.getValueAt(t, 2).toString();
					List<HoaDon> hd= hoadonRepository.findAllByTrangThaiThanhToanVaCC(cc);
					List<HoaDon> hd_dn = new ArrayList<HoaDon>();
					for(HoaDon d :hd) {
						if(d.getThoiGianNP()!=null) {
							hd_dn.add(d);
						}
					}
					
					if(hd_dn.size() > 0) {
						JOptionPane.showMessageDialog(null, "Khách hàng đã nhận phòng");
					}else {
						khachHangRepository.updateCC(ccm,txtMaKH.getText());
						if(hd.size()!=0) {
							for (HoaDon h : hd) {
								
								hoadonRepository.updateCCKhTrongHD(ccm,h.getMaHoaDon().toString());
								
							}
						}
						model.setValueAt(txtCanCuoc.getText(), t, 2);
						JOptionPane.showMessageDialog(null, "Sửa thành công !!!!");
					}
					
					
				}
			}
		}
	}
	
	public void docDLNVVaoBang() {
//		listKH=khachHangRepository.findAll();
//		xoaHetModelTable();
//		int i =1;
//		for (KhachHang kh : listKH) {
//			model.addRow(new Object[] {
//					i,kh.getTenKhachHang(),kh.getTheCanCuoc(),kh.getSoDienThoai(),xetLoaiKHTrenTable(kh.isLoaiKhachHang())
//			});
//			i++;
//		}

//		listKH=khachHangRepository.findAll();
//		ArrayList<KhachHang> khs = new ArrayList<KhachHang>();
//		for (KhachHang kh : listKH) {
//			khs.add(kh);
//		}
//		int t=model.getRowCount();
//		if(t<khs.size()) {
//			for(int i=t;i<t+20;i++) {
//				if(i<khs.size()) {
//					model.addRow(new Object[] {
//							i+1,khs.get(i).getTenKhachHang(),khs.get(i).getTheCanCuoc(),khs.get(i).getSoDienThoai(),xetLoaiKHTrenTable(khs.get(i).isLoaiKhachHang())
//					});
//				}
//			}
//		}
		
		listKH=khachHangRepository.findAll();
		ArrayList<KhachHang> khs = new ArrayList<KhachHang>();
		for (KhachHang kh : listKH) {
			khs.add(kh);
		}
		int t=model.getRowCount();
		if(t<khs.size()) {
			for(int i=0;i<t+20;i++) {
				if(i<khs.size()) {
					if(ktraKHDaCoTrongTable(khs.get(i), t)) {
						int m=model.getRowCount();
						model.addRow(new Object[] {
								m+1,khs.get(i).getTenKhachHang(),khs.get(i).getTheCanCuoc(),khs.get(i).getSoDienThoai(),xetLoaiKHTrenTable(khs.get(i).isLoaiKhachHang())
						});
					}
				}
			}
		}
	}
	
	public boolean ktraKHDaCoTrongTable(KhachHang k, int t) {
			for (int i = 0; i < t; i++) {
				if(k.getTheCanCuoc().equals(model.getValueAt(i, 2).toString())) {
					return false;
				}
			}
			return true;
		
	}
	
	public String xetLoaiKHTrenTable(boolean loaiKH) {
		if(loaiKH==true)
			return "Khách hàng ở";
		return "Khách hàng đặt phòng";
	}
	
	public boolean xetLoaiKHTrenMongo(String loaiKH) {
		if(loaiKH.equals("Khách hàng ở"))
			return true;
		return false;
	}
	
	public void xoaHetModelTable() {
		while (model.getRowCount()>0)
			model.removeRow(0);
	}
	
	public void xoaTrang() {
		txtMaKH.setText("");
		txtTenKH.setText("");
		txtCanCuoc.setText("");
		txtSDT.setText("");
		cbxLoaiKH.setSelectedItem("Khách hàng ở");
	}
	
	public boolean ktKHCoChua() {
		String scc=txtCanCuoc.getText();
		List<KhachHang> khs=khachHangRepository.findAll();
		for (KhachHang khachHang : khs) {
			if(khachHang.getTheCanCuoc().equals(scc)) {
				showMessage("Khách hàng đã có !!!!", txtTenKH);
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
	public boolean ktRegex() {
		
		if(!(txtTenKH.getText().length()>0 && txtTenKH.getText().matches("( *[a-zA-Z0-9'Ạ-ỹÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+ *)+"))){
			showMessage("Error: Tên KH không để rỗng, là chữ thường in hoa, số bất kỳ, ký tự ', chữ có dấu, khoảng trắng, Không có có tự đặc biệt trừ dấu ' !!!", txtTenKH);
			return false;
		}
		
		if(!(txtCanCuoc.getText().length()>0 && txtCanCuoc.getText().matches("[0-9]{12}"))){
			showMessage("Error: Căn cước không để rỗng và gồm 12 ký tự số !!!", txtCanCuoc);
			return false;
		}
		
		if(!(txtSDT.getText().length()>0 && txtSDT.getText().matches("[(+84)0][0-9]{9}")))
		{
		showMessage("Error: Số điện thoại gồm 10 số và bắt đầu bằng : +84 .... hoặc 0.... !!!", txtSDT);
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
