package com.hotel.project;

import javax.swing.SwingUtilities;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.hotel.project.gui.home.view.LoginGUI;

@SpringBootApplication
public class GDDangNhap implements Runnable{
	
	public void chay() {
		ApplicationContext app=new SpringApplicationBuilder(HotelProjectApplication.class)
				.headless(true)
				.web(WebApplicationType.NONE)
				.headless(false)
				.profiles("dev")
				.run();
		SwingUtilities.invokeLater(() -> {
          LoginGUI login = app.getBean(LoginGUI.class);
          login.setVisible(true);
			
//			Home home = app.getBean(Home.class);
//          home.setVisible(true);
			
        
      });
	}
	@Override
	public void run() {
		
		chay();
		
		
	}

}
