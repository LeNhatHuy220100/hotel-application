package com.hotel.project;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LogoChoLoadUD implements Runnable{
	
	
	public void showLoader() {
		JWindow window = new JWindow();
		URL url = this.getClass().getResource("/com/hotel/project/gui/home/image/progress.gif"); 
		ImageIcon ii = new ImageIcon(url);
		JLabel label = new JLabel(ii);
		
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		window.getContentPane().add(label);
		window.setBounds(((int)d.getWidth()-722)/2,((int)d.getHeight()-401)/2,722,401);
		window.setVisible(true);
		try {
		    Thread.sleep(10000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		window.setVisible(false);
	}
	@Override
	public void run() {
		new LogoChoLoadUD().showLoader();
		
	}

}
