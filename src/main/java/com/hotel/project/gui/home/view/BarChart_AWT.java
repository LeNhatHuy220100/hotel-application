package com.hotel.project.gui.home.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.hotel.project.domain.HoaDon;


public class BarChart_AWT  {
	private List<HoaDon> list;
	private static final String title = "Thống kê doanh thu";
	private int nam;
	//private ChartPanel chartPanel = createChart(list,nam);
	public BarChart_AWT( List<HoaDon> list,int nam) {
			JFrame f = new JFrame(title);
	        f.setTitle(title);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.setLayout( new FlowLayout() );                     
	        JFreeChart barChart = ChartFactory.createBarChart(
	    			 "Biểu đồ danh thu từng tháng trong 1 năm",           
			         "Tháng",            
			         "Tổng tiền",         
	    	         createDataset(list,nam),         
	    	         PlotOrientation.VERTICAL,           
	    	         true, true, false);
	    	      ChartPanel chartPanel = new ChartPanel( barChart );        
	    	      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );     
	        f.getContentPane().add(new ChartPanel(barChart));
	        f.setLocationRelativeTo(null);
	        f.pack();
	        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	    	f.setVisible(true);
	 }
	  
	   private CategoryDataset createDataset(List<HoaDon> listHoaDon,int nam) {
	      final String fiat = "Doanh Thu";        
	      final String thang1[] = {"Tháng 1","Tháng 2","Tháng 3","Tháng 4","Tháng 5",
	    		  "Tháng 6","Tháng 7","Tháng 8","Tháng 9","Tháng 10","Tháng 11","Tháng 12"};        
	      final String thang2 = "Tháng 2";        
	      final String thang3 = "Tháng 3";         
	      final String thang4 = "Tháng 4";          
	      final String userrating = "User Rating";        
	      final String safety = "safety";        
	      final DefaultCategoryDataset dataset = 
	      new DefaultCategoryDataset( );  
	      
	      
	      for (int i = 1; i < 13; i++) {
			List<HoaDon> list=findAllByNgayLapHoaDon(listHoaDon, i, nam);
			int tong=0;
			for (HoaDon hoaDon : list) {
				tong+=hoaDon.getThanhTien();
				dataset.addValue( tong, fiat , thang1[i-1] );    
			}
			tong=0;
	      }
//	      dataset.addValue( 1.0 , fiat , thang1 );        
//	      dataset.addValue( 3.0 , fiat , thang2 );        
//	      dataset.addValue( 5.0 , fiat , thang3 ); 
//	      dataset.addValue( 5.0 , fiat , thang4 );           
	      return dataset; 
	   }
	   public List<HoaDon> findAllByNgayLapHoaDon(List<HoaDon> listHoaDon,int thangLapHoaDon,int namLapHoaDon){
			List<HoaDon> list=new ArrayList<HoaDon>();
			list = listHoaDon.stream()
				.filter(hoaDon->hoaDon.getThoiGianLHD().getMonthValue()==thangLapHoaDon && 
						hoaDon.getThoiGianLHD().getYear()==namLapHoaDon)
				.collect(Collectors.toList());
			return list;
		}
	   
//	   public static void main( String[ ] args ) {
//	      BarChart_AWT chart = new BarChart_AWT("Car Usage Statistics", 
//	         "Which car do you like?");
//	      chart.pack( );        
//	      RefineryUtilities.centerFrameOnScreen( chart );        
//	      chart.setVisible( true ); 
//	   }
}
