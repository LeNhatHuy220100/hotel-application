package com.hotel.project.gui.home.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.bson.types.ObjectId;
import org.jfree.chart.ChartPanel;
import org.jfree.ui.RefineryUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotel.project.domain.DuLieuExcel;
import com.hotel.project.domain.HoaDon;
import com.hotel.project.model.ThongKeDichVuThang;
import com.hotel.project.model.ThongKePhongThang;
import com.hotel.project.repository.HoaDonRepository;
@Component
public class ThongKeDichVuTheoNam extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelDSHoaDon;
	private JTable table;
	private JTextField textField_1;
	private JButton btnThngK;
	@Autowired
	private HoaDonRepository hoaDonRepository;
	@Autowired
	private ThongKeTheoNam thongKeTheoNam;
	private List<HoaDon> listHoaDon;
	private JLabel label;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	public ThongKeDichVuTheoNam() {
		
	}
	/**
	 * Create the panel.
	 */
	@PostConstruct
	public void preparewPanel() {

		setBounds(359, 0, 1543, 1008);
		setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblThngKDoanh = new JLabel("THỐNG KÊ DOANH THU");
		lblThngKDoanh.setForeground(Color.RED);
		lblThngKDoanh.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngKDoanh.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblThngKDoanh.setBounds(255, 0, 1014, 90);
		getContentPane().add(lblThngKDoanh);
		
		JLabel lblThngKTheo = new JLabel("Thống kê theo:");
		lblThngKTheo.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblThngKTheo.setBounds(314, 83, 165, 56);
		getContentPane().add(lblThngKTheo);
		ButtonGroup group= new ButtonGroup();
		
		btnThngK = new JButton("Thống kê");
		btnThngK.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		btnThngK.setBounds(835, 83, 129, 43);
		getContentPane().add(btnThngK);
		
		JLabel lblDanhSchHa = new JLabel("Danh sách hóa đơn");
		lblDanhSchHa.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchHa.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblDanhSchHa.setBounds(12, 406, 472, 38);
		getContentPane().add(lblDanhSchHa);
		
		//----------------------- Hiện thị danh sách hóa đơn -------------------
		
		String[] colHeader = { "STT", "Mã hóa đơn", "Ngày lập","Mã dịch vụ","Tên dịch vụ","Đơn giá","Loại dịch vụ"};
		modelDSHoaDon = new DefaultTableModel(colHeader, 0);
		table = new JTable(modelDSHoaDon);	
		listHoaDon=getListHoaDon();	
		JScrollPane scrollPane = new JScrollPane(table);
		
		
		scrollPane.setBounds(111, 455, 1289, 390);
		getContentPane().add(scrollPane);
			
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2017","2018","2019","2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		comboBox_1.setBounds(680, 83, 99, 42);
		getContentPane().add(comboBox_1);
		
		JLabel lblNm = new JLabel("Năm");
		lblNm.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNm.setBounds(581, 98, 64, 26);
		getContentPane().add(lblNm);
		
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
		
		table.setModel(modelDSHoaDon);
		scrollPane.setViewportView(table);
		
		JButton btnDuLieu = new JButton("Biểu đồ");
		btnDuLieu.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		btnDuLieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDuLieu.setBounds(968, 870, 193, 41);
		getContentPane().add(btnDuLieu);
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(22, 199, 313, 160);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTngDanhThu = new JLabel("Dịch vụ sử dụng nhiều nhất");
		lblTngDanhThu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTngDanhThu.setBounds(-18, 13, 275, 34);
		panel.add(lblTngDanhThu);
		
		label = new JLabel("");
		label.setFont(new Font("Times New Roman", Font.BOLD, 28));
		label.setBounds(58, 60, 199, 43);
		panel.add(label);
		
		label6 = new JLabel("");
		label6.setBounds(57, 107, 200, 31);
		label6.setFont(new Font("Times New Roman", Font.BOLD, 28));
		panel.add(label6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(427, 199, 313, 160);
		getContentPane().add(panel_1);
		
		JLabel lblSLng = new JLabel("Số lượng dịch vụ đã sử dụng");
		lblSLng.setHorizontalAlignment(SwingConstants.CENTER);
		lblSLng.setBounds(0, 13, 301, 34);
		panel_1.add(lblSLng);
		
		label1 = new JLabel("");
		label1.setFont(new Font("Times New Roman", Font.BOLD, 28));
		label1.setBounds(53, 60, 199, 43);
		panel_1.add(label1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(800, 199, 313, 160);
		getContentPane().add(panel_1_1);
		
		JLabel lblSLng_1 = new JLabel("Dịch vụ sử dụng nhiều nhất");
		lblSLng_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSLng_1.setBounds(0, 13, 289, 34);
		panel_1_1.add(lblSLng_1);
		
		label2 = new JLabel("");
		label2.setFont(new Font("Times New Roman", Font.BOLD, 28));
		label2.setBounds(28, 49, 199, 40);
		panel_1_1.add(label2);
		
		label4 = new JLabel("");
		label4.setFont(new Font("Times New Roman", Font.BOLD, 28));
		label4.setBounds(28, 102, 222, 31);
		panel_1_1.add(label4);
		
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(Color.WHITE);
		panel_1_2.setBounds(1169, 199, 313, 160);
		getContentPane().add(panel_1_2);
		
		JLabel lblSLng_2 = new JLabel("Phòng có sử dụng ít nhất");
		lblSLng_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSLng_2.setBounds(-15, 13, 289, 40);
		panel_1_2.add(lblSLng_2);
		
		label3 = new JLabel("");
		label3.setFont(new Font("Times New Roman", Font.BOLD, 28));
		label3.setBounds(34, 61, 199, 34);
		panel_1_2.add(label3);
		
		
		label5 = new JLabel("");
		label5.setBounds(34, 98, 199, 34);
		label5.setFont(new Font("Times New Roman", Font.BOLD, 28));
		panel_1_2.add(label5);
		
	
		
	//	----------------- Chức năng thống kê -------------------
		btnThngK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				findAllByThangLapHoaDon(listHoaDon,
						 Integer.parseInt(comboBox_1.getSelectedItem().toString()));
			}
		});
		
		
		
//		----------------- Xuất file excel -------------------
		
//		----------------- Trực quan hóa dữ liệu -------------------
		btnDuLieu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BarChart_AWT chart = new BarChart_AWT(getListHoaDonForStatis(),Integer.parseInt(comboBox_1.getSelectedItem().toString()));
			    
//				barChart_AWT.pack();
//				RefineryUtilities.centerFrameOnScreen( barChart_AWT );        
//				barChart_AWT.setVisible( true ); 
			}
		});
	}

	public List<DuLieuExcel> getAllListDefaultTableModel(){
		List<DuLieuExcel> list=new ArrayList<DuLieuExcel>();
		int count=modelDSHoaDon.getRowCount();
		for (int i = 0; i < count; i++) {
			list.add(new DuLieuExcel(
					modelDSHoaDon.getValueAt(i, 1).toString(),
					modelDSHoaDon.getValueAt(i, 2).toString(), 
					modelDSHoaDon.getValueAt(i, 3).toString(), 
					modelDSHoaDon.getValueAt(i, 4).toString()));
		}
		return list;
	}
	public List<ThongKeDichVuThang> findAllThongKePhongThang(){
		List<ThongKeDichVuThang> list=new ArrayList<ThongKeDichVuThang>();
		int count=modelDSHoaDon.getRowCount();
		for (int i = 0; i < count; i++) {
			list.add(new ThongKeDichVuThang (new ObjectId(modelDSHoaDon.getValueAt(i, 1).toString()),
					LocalDateTime.now(),modelDSHoaDon.getValueAt(i, 3).toString(),modelDSHoaDon.getValueAt(i, 4).toString(),
					Double.parseDouble(modelDSHoaDon.getValueAt(i, 5).toString())
					));
		}
		return list;
	}
		
	
	public List<ThongKeDichVuThang> findAllByThangLapHoaDon(List<HoaDon> listHoaDon,int namLapHoaDon){
		List<ThongKeDichVuThang> list=new ArrayList<ThongKeDichVuThang>();
		setLabelEmpty();
		listHoaDon.stream()
			.filter(hoaDon->
					hoaDon.getThoiGianLHD().getYear()==namLapHoaDon)
			.forEach(hoaDon->{
				hoaDon.getListDichVu().forEach(chiTiet->{
					list.add(new ThongKeDichVuThang(hoaDon.getMaHoaDon(),
							hoaDon.getThoiGianLHD(), chiTiet.getMaDichVu(), chiTiet.getTenDichVu(), chiTiet.getGia()));
				});
			});
		
		double thanhTien=0;
		xoaHetModelTable();
		int i1=1;
		for (ThongKeDichVuThang dichVu : list) {
			modelDSHoaDon.addRow(new Object[] {
					i1++,dichVu.getMaDichVu(),dichVu.getThoiGianLHD(),dichVu.getMaDichVu(),
					dichVu.getTenDichVu(),dichVu.getDonGia()
			});
			
		}
		
		Map<String, Long> collect = list.stream().collect(
				Collectors.groupingBy(ThongKeDichVuThang::getTenDichVu,
				Collectors.counting()));

		
		Long value=collect.values().stream().max(Comparator.comparing(Long::doubleValue)).get();
		Long value1=collect.values().stream().min(Comparator.comparing(Long::doubleValue)).get();
		
		collect.entrySet().forEach(k->{
			if(k.getValue().doubleValue()==value.doubleValue()) {
				label.setText(k.getKey());
				label6.setText(String.valueOf(k.getValue()));
			}
		});
		
		collect.entrySet().forEach(k->{
			if(k.getValue().doubleValue()==value.doubleValue()) {
				label2.setText(k.getKey());
				label4.setText(String.valueOf(k.getValue()));
			}
		});
		
		collect.entrySet().forEach(k->{
			if(k.getValue().doubleValue()==value1.doubleValue()) {
				label3.setText(k.getKey());
				label5.setText(String.valueOf(k.getValue()));
			}
		});
		label1.setText(String.valueOf(list.size()));
		return list;
	}
	
	public void setLabelEmpty() {
		label.setText("");
		label1.setText("");
		label2.setText("");
		label3.setText("");
		label4.setText("");
		label5.setText("");
		label6.setText("");
	}
	
	public void xoaHetModelTable() {
		while (modelDSHoaDon.getRowCount()>0)
			modelDSHoaDon.removeRow(0);
	}
	
	public List<HoaDon> getListHoaDon(){
		List<HoaDon> list=new ArrayList<HoaDon>();
		list=hoaDonRepository.findAllByTrangThaiThanhToanIsTrue();
		
		int i=1;
		for (HoaDon hoaDon : list) {
			
			hoaDon.getListDichVu().forEach(dichVu->{
				int i1=0;
				modelDSHoaDon.addRow(new Object[] {
						i1++,hoaDon.getMaHoaDon(),converLocalDateTime(hoaDon.getThoiGianLHD()),dichVu.getMaDichVu(),
						dichVu.getTenDichVu(),dichVu.getGia(),dichVu.getPhongDichVu()
				});
			});
			
		}
		return list;
	}
	
	
	public List<HoaDon> getListHoaDonForStatis(){
		List<HoaDon> list=new ArrayList<HoaDon>();
		list=hoaDonRepository.findAllByTrangThaiThanhToanIsTrue();
		return list;
	}
	
	public String converLocalDateTime(LocalDateTime localDateTime) {
		DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String format=localDateTime.format(customFormatter);
		return format;
	}
	public static void main(String[] args) {
		
		ThongKe_GUI thongKe=new ThongKe_GUI();
		thongKe.setVisible(true);
	}
	
	//-------------- write excel -------------------------------
	public void writeExcel(List<DuLieuExcel> listHoaDon, String excelFilePath) throws IOException {
	    @SuppressWarnings("resource")
		Workbook workbook = new HSSFWorkbook();
	    Sheet sheet = workbook.createSheet();
	 
	    int rowCount = 0;
	 
	    for (DuLieuExcel hoaDon: listHoaDon) {
	        Row row = sheet.createRow(++rowCount);
	        writeBook(hoaDon, row);
	    }
	 
	    try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
	        workbook.write(outputStream);
	    }
	}
	
	private void writeBook(DuLieuExcel duLieuExcel, Row row) {
	    Cell cell = row.createCell(1);
	    cell.setCellValue(duLieuExcel.getMaHoaDon().toString());
	 
	    cell = row.createCell(2);
	    cell.setCellValue(duLieuExcel.getNgayLapHD());
	 
	    cell = row.createCell(3);
	    cell.setCellValue(duLieuExcel.getTenNhanVien());
	    
	    cell = row.createCell(4);
	    cell.setCellValue(duLieuExcel.getThanhTien());
	    
	}
	
		
}
