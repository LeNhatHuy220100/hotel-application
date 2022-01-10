package com.hotel.project.gui.home.view;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.hotel.project.domain.HoaDon;
import com.hotel.project.repository.HoaDonRepository;


public class BarChart_Nam  {
	private static final String title = "Thống kê doanh thu";
	public BarChart_Nam(List<HoaDon> list) {
	     
		JFrame f = new JFrame(title);
        f.setTitle(title);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout( new FlowLayout() );                 
        JFreeChart barChart = ChartFactory.createBarChart(
        		 "Biểu đồ danh thu trong năm",           
		         "Năm",            
		         "Tổng tiền",          
    	         createDataset(list),         
    	         PlotOrientation.VERTICAL,           
    	         true, true, false);
    	      ChartPanel chartPanel = new ChartPanel( barChart );        
    	      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );     
        f.getContentPane().add(new ChartPanel(barChart));
        f.pack();
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null);
    	f.setVisible(true);
		
	 }
	   
	   private CategoryDataset createDataset(List<HoaDon> listHoaDon) {
	      final String fiat = "Doanh Thu";        
	      final String thang1[] = {"Năm 2017","Năm 2018","Năm 2019","Năm 2020"
	    		  };              
	      final DefaultCategoryDataset dataset = 
	      new DefaultCategoryDataset( );  
	      
	      
	      for (int i = 2017; i < 2021; i++) {
			List<HoaDon> list=findAllByNgayLapHoaDon(listHoaDon,i);
			int tong=0;
			int d=1;
			for (HoaDon hoaDon : list) {
				tong+=hoaDon.getThanhTien();
				dataset.addValue( tong, fiat , String.valueOf("Nam"+i));
			}
			tong=0;
			d++;
	      }
//	      dataset.addValue( 1.0 , fiat , thang1 );        
//	      dataset.addValue( 3.0 , fiat , thang2 );        
//	      dataset.addValue( 5.0 , fiat , thang3 ); 
//	      dataset.addValue( 5.0 , fiat , thang4 );           
	      return dataset; 
	   }
	   public List<HoaDon> findAllByNgayLapHoaDon(List<HoaDon> listHoaDon,int namLapHoaDon){
			List<HoaDon> list=new ArrayList<HoaDon>();
			list = listHoaDon.stream()
				.filter(hoaDon->
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
