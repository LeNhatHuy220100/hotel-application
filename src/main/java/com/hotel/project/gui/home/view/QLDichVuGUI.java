package com.hotel.project.gui.home.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotel.project.domain.DichVu;
import com.hotel.project.domain.HoaDon;
import com.hotel.project.domain.KhachHang;
import com.hotel.project.repository.DichVuRepository;
import com.hotel.project.repository.HoaDonRepository;

import java.awt.Panel;
import javax.swing.JTextField;
import java.awt.Button;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
@Component
public class QLDichVuGUI extends JPanel implements ActionListener{
	private JTable table;
	private JTextField txtTen;
	private JTextField txtMa;
	private JTextField txtGia;
	private JTextField txtLoai;
	private JTextField txtTim;
	private DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	@Autowired
	private DichVuRepository dichVuRepository;
	private List<DichVu> list;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnTim;
	private JButton btnThem;
	private JButton btnxoaTrang;
	private DichVu timDichVuTheoMa;
	
	public QLDichVuGUI() {
	}
	@PostConstruct
	public void preparePanel() {
		setBackground(Color.WHITE);
		setBounds(303, 0, 1599, 1008);
		//	setBackground(SystemColor.menu);
			setLayout(null);
			
			
			
			JLabel lblDichVu = new JLabel("QUẢN LÝ DỊCH VỤ");
			lblDichVu.setBackground(Color.WHITE);
			lblDichVu.setForeground(new Color(255, 69, 0));
			lblDichVu.setFont(new Font("Times New Roman", Font.BOLD, 30));
			lblDichVu.setHorizontalAlignment(SwingConstants.CENTER);
			lblDichVu.setBounds(0, 13, 1599, 36);
			add(lblDichVu, BorderLayout.NORTH);
			
			JPanel panel = new JPanel();
			panel.setBorder(null);
			panel.setBackground(Color.WHITE);
			panel.setBounds(0, 36, 1599, 972);
			add(panel);
			panel.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setBounds(45, 276, 1512, 670);
			panel.add(scrollPane);
			
			model = new DefaultTableModel(
					new String[] {
							"STT", "M\u00E3 D\u1ECBch V\u1EE5", "T\u00EAn D\u1ECBch V\u1EE5", "\u0110\u1EDBn Gi\u00E1", "Loại dịch vụ"
					}, 0){
			    public boolean isCellEditable(int row, int column)
			    {
			      return false;//This causes all cells to be not editable
			    }
			  };
			table = new JTable();
			table.setModel(model);
			table.setFont(new Font("Tahoma", Font.PLAIN, 18));
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
			
			 btnThem = new JButton("Thêm");
			btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnThem.setBounds(1135, 210, 123, 42);
			panel.add(btnThem);
			
			Panel panel_1_4 = new Panel();
			panel_1_4.setBounds(45, 211, 647, 42);
			panel.add(panel_1_4);
			panel_1_4.setLayout(new BorderLayout(0, 0));
			
			JLabel lblTim = new JLabel("Tìm Kiếm     ");
			lblTim.setFont(new Font("Times New Roman", Font.BOLD, 20));
			panel_1_4.add(lblTim, BorderLayout.WEST);
			
			txtTim = new JTextField();
			panel_1_4.add(txtTim, BorderLayout.CENTER);
			txtTim.setColumns(10);
			
			 btnTim = new JButton("Tìm");
			btnTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			panel_1_4.add(btnTim, BorderLayout.EAST);
			
			 btnXoa = new JButton("Xóa");
			btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnXoa.setBounds(1284, 211, 123, 42);
			panel.add(btnXoa);
			
			 btnSua = new JButton("Sửa");
			btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnSua.setBounds(1434, 210, 123, 42);
			panel.add(btnSua);
			
			btnxoaTrang = new JButton("Xóa trắng");
			btnxoaTrang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnxoaTrang.setBounds(987, 210, 123, 42);
			panel.add(btnxoaTrang);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Th\u00F4ng tin d\u1ECBch v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
			panel_2.setBackground(Color.WHITE);
			panel_2.setBounds(45, 42, 1512, 155);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			Panel panel_1 = new Panel();
			panel_1.setBounds(144, 88, 536, 42);
			panel_2.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JLabel lblNewLabel = new JLabel("Tên dịch vụ    ");
			panel_1.add(lblNewLabel, BorderLayout.WEST);
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
			
			txtTen = new JTextField();
			txtTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			panel_1.add(txtTen, BorderLayout.CENTER);
			txtTen.setColumns(10);
			
			Panel panel_1_1 = new Panel();
			panel_1_1.setBounds(144, 26, 536, 42);
			panel_2.add(panel_1_1);
			panel_1_1.setLayout(new BorderLayout(0, 0));
			
			JLabel lblMDchV = new JLabel("Mã dịch vụ     ");
			panel_1_1.add(lblMDchV, BorderLayout.WEST);
			lblMDchV.setFont(new Font("Times New Roman", Font.BOLD, 20));
			
			txtMa = new JTextField();
			txtMa.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			panel_1_1.add(txtMa, BorderLayout.CENTER);
			txtMa.setColumns(10);
			
			Panel panel_1_2 = new Panel();
			panel_1_2.setBounds(771, 87, 536, 42);
			panel_2.add(panel_1_2);
			panel_1_2.setLayout(new BorderLayout(0, 0));
			
			JLabel lblSLng = new JLabel("Loại dịch vụ   ");
			panel_1_2.add(lblSLng, BorderLayout.WEST);
			lblSLng.setFont(new Font("Times New Roman", Font.BOLD, 20));
			
			txtLoai = new JTextField();
			txtLoai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			panel_1_2.add(txtLoai, BorderLayout.CENTER);
			txtLoai.setColumns(10);
			
			Panel panel_1_3 = new Panel();
			panel_1_3.setBounds(771, 26, 536, 42);
			panel_2.add(panel_1_3);
			panel_1_3.setLayout(new BorderLayout(0, 0));
			
			JLabel lblnGi = new JLabel("Đơn giá          ");
			panel_1_3.add(lblnGi, BorderLayout.WEST);
			lblnGi.setFont(new Font("Times New Roman", Font.BOLD, 20));
			
			txtGia = new JTextField();
			txtGia.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			panel_1_3.add(txtGia, BorderLayout.CENTER);
			txtGia.setColumns(10);
		
		list = dichVuRepository.findALL();
		docDLVaoBang(list);
		
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnTim.addActionListener(this);
		btnxoaTrang.addActionListener(this);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				txtMa.setText(model.getValueAt(row, 1).toString());
				txtTen.setText(model.getValueAt(row, 2).toString());
				txtGia.setText(model.getValueAt(row, 3).toString());
				txtLoai.setText(model.getValueAt(row, 4).toString());
				txtMa.setEditable(false);
				txtTen.setEditable(false);
				txtLoai.setEditable(false);
			}
		});
	}
	public void docDLVaoBang(List<DichVu> list) {
		int i =1;
		reset();
		for(DichVu p :list) {
			
				model.addRow(new Object[] {
						i, p.getMaDichVu(),p.getTenDichVu(), p.getGiaDichVu(),p.getLoaiDichVu()
				});
	
			i++;
		}
		
		table.setModel(model);
		
	}
	public  void reset()
	{
		model.setRowCount(0);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			themDichVu();	
		}
		else if(o.equals(btnXoa)) {
			try {
				int r = table.getSelectedRow();
				Long a =Long.parseLong(model.getValueAt(r, 0).toString());
				model.removeRow(r);
				String maDichVu = txtMa.getText();
				String tenDichVu =txtTen.getText();
				double GiaDichVu = Double.parseDouble(txtGia.getText());
				String loaiDichVu = txtLoai.getText();
				DichVu dichVu = new DichVu(maDichVu, tenDichVu, GiaDichVu, loaiDichVu);
				dichVuRepository.deleteDichVu(dichVu);
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Phải chọn dòng để xóa");
		}
		}
		else if(o.equals(btnSua)) {
				int dong = table.getSelectedRow();
				if(dong>=0) {
					
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Phải chọn dòng để sửa" );
				}
				try {
					String maDichVu = txtMa.getText();
					String tenDichVu =txtTen.getText();
					double GiaDichVu = Double.parseDouble(txtGia.getText());
					String loaiDichVu = txtLoai.getText();
					DichVu dichVu = new DichVu(maDichVu, tenDichVu, GiaDichVu, loaiDichVu);
					boolean kq = dichVuRepository.updateDichVu(dichVu);	
					if(kq) {
						JOptionPane.showMessageDialog(this,"Cập Nhật Thành Công" );
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				XoaHetDuLieuTrenTableModel();
				list = dichVuRepository.findALL();
				docDLVaoBang(list);
				table.clearSelection();
					
		}
		else if(o.equals(btnTim)){
			String tim = txtTim.getText();
			if(tim.length()>0)
			{
			XoaHetDuLieuTrenTableModel();
			timDichVuTheoMa = dichVuRepository.findByMaDichVu(tim);
			list.add(timDichVuTheoMa);
			try {
				docDLVaoBang(list);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Không có dịch vụ này");
			}
				
			}
			else {
				XoaHetDuLieuTrenTableModel();
				list = dichVuRepository.findALL();
				docDLVaoBang(list);
			}
		}
		else {
		
				txtGia.setText("");
				txtLoai.setText("");
				txtMa.setText("");
				txtTen.setText("");
				txtTim.setText("");
				txtGia.setEditable(true);
				txtLoai.setEditable(true);
				txtMa.setEditable(true);
				txtTen.setEditable(true);
				txtTim.setEditable(true);
				table.clearSelection();
				txtMa.requestFocus();
			
		}
		
	}
	public void themDichVu() {
		if(validData1()) {
		String maDichVu = txtMa.getText().trim();
		String tenDichVu =txtTen.getText().trim();
		double GiaDichVu = Double.parseDouble(txtGia.getText());
		String loaiDichVu = txtLoai.getText().trim();
		DichVu dicVu = new DichVu(maDichVu, tenDichVu, GiaDichVu, loaiDichVu);
		try {
			DichVu dv = dichVuRepository.addDichVu(dicVu);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Đã Tồn Tại Dịch Vụ này");
		}
		
		
		XoaHetDuLieuTrenTableModel();
		list = dichVuRepository.findALL();
		docDLVaoBang(list);
		}
	}
	public  void XoaHetDuLieuTrenTableModel()
	{
		DefaultTableModel dm =(DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
		list.removeAll(list);
	}
	private boolean validData1() {
		String maDichVu = txtMa.getText().trim();
		String tenDichVu =txtTen.getText().trim();
		String giaDV = txtMa.getText().trim();
		String loaiDichVu = txtLoai.getText().trim();
		if (giaDV.length() > 0) {
			try {
				double GiaDichVu = Double.parseDouble(txtGia.getText());
				if (GiaDichVu <= 0) {
					JOptionPane.showMessageDialog(this, "Gia Dich Vu phải lớn hơn 0", "Cảnh Báo",JOptionPane.WARNING_MESSAGE);
					txtGia.selectAll();
					txtGia.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Nhập sai định dạng Giá", "Cảnh Báo",JOptionPane.WARNING_MESSAGE);
				txtGia.selectAll();
				txtGia.requestFocus();
				return false;
			}
		}
		if (txtMa.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Phải nhập MÃ vào", "Cảnh Báo",JOptionPane.WARNING_MESSAGE);
			txtMa.selectAll();
			txtMa.requestFocus();
			return false;
	}
		if (txtTen.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Phải nhập tên vào",  "Cảnh Báo",JOptionPane.WARNING_MESSAGE);
			txtTen.selectAll();
			txtTen.requestFocus();
			return false;
	}
		if (txtLoai.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Phải nhập Loại vào", "Cảnh Báo",JOptionPane.WARNING_MESSAGE);
				txtLoai.selectAll();
				txtLoai.requestFocus();
				return false;
		}
		
		return true;
		}
}
