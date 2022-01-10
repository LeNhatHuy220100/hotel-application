package com.hotel.project;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelProjectApplication {

	public static void main(String[] args) {
		Thread r1= new Thread(new GDDangNhap());
		Thread r2= new Thread(new LogoChoLoadUD());
		r2.start();
		r1.start();
	}
}
	