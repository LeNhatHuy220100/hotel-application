package com.hotel.project.gui.home.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import org.springframework.stereotype.Component;

import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

@Component
public class Help extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help frame = new Help();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	
	@PostConstruct
	public void preparePane() {
		setResizable(false);
		setBounds(0,0,1566,929);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 479, 883);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 0, 479, 50);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nội dung\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(12, 0, 117, 50);
		panel_1.add(lblNewLabel);
		
		JTree tree = new JTree();
		tree.setRootVisible(false);
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("JTree") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Quản lý thông tin đặt phòng");
						node_1.add(new DefaultMutableTreeNode("Đặt phòng"));
						node_1.add(new DefaultMutableTreeNode("Nhận phòng"));
						node_1.add(new DefaultMutableTreeNode("Cập nhật phòng"));
						node_1.add(new DefaultMutableTreeNode("Thanh toán"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Quản lý khách hàng");
						node_1.add(new DefaultMutableTreeNode("Thêm khách hàng"));
						node_1.add(new DefaultMutableTreeNode("Xóa khách hàng"));
						node_1.add(new DefaultMutableTreeNode("Tìm kiếm khách hàng"));
						node_1.add(new DefaultMutableTreeNode("Cập nhật thông tin khách hàng"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Quản lý nhân viên");
						node_1.add(new DefaultMutableTreeNode("Thêm nhân viên"));
						node_1.add(new DefaultMutableTreeNode("Xóa nhân viên"));
						node_1.add(new DefaultMutableTreeNode("Tìm kiếm nhân viên"));
						node_1.add(new DefaultMutableTreeNode("Sửa nhân viên"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Quản lý phòng");
						node_1.add(new DefaultMutableTreeNode("Sửa phòng"));
						node_1.add(new DefaultMutableTreeNode("Tìm kiếm phòng"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Quản lý thống kê");
						node_1.add(new DefaultMutableTreeNode("Thống kê doanh thu"));
					add(node_1);
					 
					
					/**
					 * DefaultMutableTreeNode node_1;
					add(new DefaultMutableTreeNode("Đăng nhập"));
					node_1 = new DefaultMutableTreeNode("Quản lý thông tin đặt phòng");
						node_1.add(new DefaultMutableTreeNode("Đặt phòng"));
						node_1.add(new DefaultMutableTreeNode("Nhận phòng"));
						node_1.add(new DefaultMutableTreeNode("Hủy phòng"));
						node_1.add(new DefaultMutableTreeNode("Cập nhật phòng"));
						node_1.add(new DefaultMutableTreeNode("Tìm kiếm hóa đơn "));
						node_1.add(new DefaultMutableTreeNode("Thanh toán"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Quản lý khách hàng");
						node_1.add(new DefaultMutableTreeNode("Thêm khách hàng"));
						node_1.add(new DefaultMutableTreeNode("Xóa khách hàng"));
						node_1.add(new DefaultMutableTreeNode("Tìm kiếm khách hàng"));
						node_1.add(new DefaultMutableTreeNode("Cập nhật thông tin khách hàng"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Quản lý dịch vụ");
						node_1.add(new DefaultMutableTreeNode("Thêm dịch vụ"));
						node_1.add(new DefaultMutableTreeNode("Xóa dịch vụ"));
						node_1.add(new DefaultMutableTreeNode("Tìm kiếm dịch vụ"));
						node_1.add(new DefaultMutableTreeNode("Cập nhật thông tin dịch vụ"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Quản lý nhân viên");
						node_1.add(new DefaultMutableTreeNode("Thêm nhân viên"));
						node_1.add(new DefaultMutableTreeNode("Xóa nhân viên"));
						node_1.add(new DefaultMutableTreeNode("Tìm kiếm nhân viên"));
						node_1.add(new DefaultMutableTreeNode("Sửa nhân viên"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Quản lý phòng");
						node_1.add(new DefaultMutableTreeNode("Sửa phòng"));
						node_1.add(new DefaultMutableTreeNode("Tìm kiếm phòng"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Quản lý thống kê");
						node_1.add(new DefaultMutableTreeNode("Thống kê doanh thu"));
						node_1.add(new DefaultMutableTreeNode("Xuất thông thống kê"));
					add(node_1);
					 */
				}
			}
		));
		tree.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tree.setBounds(10, 63, 457, 807);
		panel.add(tree);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(SystemColor.menu);
		panel_2.setBounds(491, 0, 1058, 883);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(0, 0, 1057, 881);
		panel_2.add(scrollPane_1);
		
		
		JLabel lblHTML = new JLabel("");
		lblHTML.setBackground(Color.WHITE);
		lblHTML.setVerticalAlignment(SwingConstants.TOP);
		lblHTML.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		scrollPane_1.setViewportView(lblHTML);
		
		
		tree.addMouseListener(new MouseAdapter() {
		      public void mouseClicked(MouseEvent me) {
		    	  DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
		    	  String t = selectedNode.getUserObject().toString();
		    	    if (t.equalsIgnoreCase("Đặt phòng")) {
		    	    	String tt = "<html>\r\n" + 
		    					"    <h1 style=\"font-size: 1.5em; color:blue;\">&nbsp;Đặt phòng</h1><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 1: </b> Bạn chọn vào nút “QUẢN LÝ ĐẶT PHÒNG” để hiển thị giao diện quản lý đặt phòng.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/DP_B1.jpg")+"\" alt=\"\" width=\"300\" height=\"500\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 2: </b> Sau đó bạn chọn vào nút “Tạo Đơn Đặt Phòng”, ứng dụng sẽ hiển thị giao diện đơn đặt phòng.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/DP_B2.jpg")+"\" alt=\"\" width=\"800\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 3: </b> Từ giao diện đơn đặt phòng, bạn nhập số thẻ căn cước của khách hàng, sau đó nhấn nút “Tìm” để tìm khách hàng.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/DP_B3.jpg")+"\" alt=\"\" width=\"700\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 4: </b> Sau khi tìm thấy khách hàng,  bạn chọn ngày thuê phòng, trả phòng của khách hàng. </p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/DP_B4.jpg")+"\" alt=\"\" width=\"750\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 5: </b> Sau đó bạn hãy nhấn nút “Load” để tìm phòng trống trong khoảng thời gian đó.</p><br>\r\n" +
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/DP_B5.jpg")+"\" alt=\"\" width=\"800\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 6: </b> Bạn chọn phòng trống trên bảng, sau đó nhấn nút “Thêm” để thêm phòng vào bảng phòng đã chọn.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/DP_B6.jpg")+"\" alt=\"\" width=\"1000\" height=\"500\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 7: </b> Cuối cùng bạn chọn nút “Đặt phòng” để hoàn tất việc đặt phòng. Nếu ngày thuê là ngày hiện tại thì phòng sẽ hiển thị <br>&nbsp;&nbsp;&nbsp;màu cam trên giao diện “QUẢN LÝ ĐẶT PHÒNG”.</p><br>\r\n" +
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/DP_B7.jpg")+"\" alt=\"\" width=\"800\" height=\"500\"></p><br>\r\n" + 
		    					"</html>";
		    	    	lblHTML.setText(tt);
		    	     
		    	    }else if (t.equalsIgnoreCase("Nhận phòng")) {
		    	    	String tt = "<html>\r\n" + 
		    					"    <h1 style=\"font-size: 1.5em; color:blue;\">&nbsp;Nhận phòng</h1><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 1: </b> Bạn chọn vào nút “QUẢN LÝ ĐẶT PHÒNG” để hiển thị giao diện quản lý đặt phòng.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/DP_B1.jpg")+"\" alt=\"\" width=\"300\" height=\"500\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 2: </b> Bạn nhấn vào nút “Nhận” ở những phòng đang ở trạng thái “Đã đặt” (phòng hiển thị màu cam), ứng dụng sẽ hiển thị <br>&nbsp;&nbsp;&nbsp;giao diện “Nhận phòng”.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/NP_B2.jpg")+"\" alt=\"\" width=\"800\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 3: </b> Bạn hãy nhập số thẻ căn cước của khách hàng vào ô thẻ căn cước sau đó nhấn nút “Tìm” để tìm thông tin khách hàng.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/NP_B3.jpg")+"\" alt=\"\" width=\"700\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 4: </b> Bạn tiếp tục điền số người ở tại phòng. </p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/NP_B4.jpg")+"\" alt=\"\" width=\"750\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 5: </b> Cuối cùng bạn nhấn nút “Nhận phòng” để hoàn tất việc nhận phòng.</p><br>\r\n" +
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/NP_B5.jpg")+"\" alt=\"\" width=\"800\" height=\"400\"></p><br>\r\n" + 
		    					"</html>";
		    	    	lblHTML.setText(tt);
		    	     
		    	    }else if (t.equalsIgnoreCase("Cập nhật phòng")) {
		    	    	String tt = "<html>\r\n" + 
		    					"    <h1 style=\"font-size: 1.5em; color:blue;\">&nbsp;Cập nhật phòng</h1><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 1: </b> Bạn chọn vào nút “QUẢN LÝ ĐẶT PHÒNG” để hiển thị giao diện quản lý đặt phòng.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/DP_B1.jpg")+"\" alt=\"\" width=\"300\" height=\"500\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 2: </b> Bạn nhấn vào nút “Cập nhật” ở những phòng đang ở trạng thái “Đang ở”, ứng dụng sẽ hiển thị giao diện cập nhật phòng.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/CNP_B2.jpg")+"\" alt=\"\" width=\"800\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 3: </b> Tiếp theo bạn nhập tên hoặc mã dịch vụ vào ô tìm kiếm sau đó nhấn nút “Tìm” dịch vụ bạn muốn thêm vào phòng.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/CNP_B3.jpg")+"\" alt=\"\" width=\"700\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 4: </b> Sau khi tìm được dịch vụ, bạn hãy chọn dịch vụ trên bảng, nhập số lượng và nhấn nút “Thêm” để thêm dịch vụ xuống bảng <br>&nbsp;&nbsp;&nbsp;“Dịch vụ đã sử dụng”. </p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/CNP_B4.jpg")+"\" alt=\"\" width=\"750\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 5: </b> Sau khi thêm dịch vụ, bạn hãy nhấn nút “Cập nhật” để hoàn tất việc cập nhật dịch vụ.</p><br>\r\n" +
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/CNP_B5.jpg")+"\" alt=\"\" width=\"800\" height=\"500\"></p><br>\r\n" + 
		    					"</html>";
		    	    	lblHTML.setText(tt);
		    	     
		    	    }else if (t.equalsIgnoreCase("Tìm kiếm phòng")) {
		    	    	String tt = "<html>\r\n" + 
		    					"    <h1 style=\"font-size: 1.5em; color:blue;\">&nbsp;Tìm kiếm phòng</h1><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 1: </b> Bạn chọn vào nút “QUẢN LÝ PHÒNG” để hiển thị giao diện quản lý phòng.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/TKP_B1.jpg")+"\" alt=\"\" width=\"300\" height=\"500\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 2: </b> : Bạn nhập mã phòng vào ô tìm kiếm , nhấn nút “Tìm” để tìm phòng.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/TKP_B2.jpg")+"\" alt=\"\" width=\"800\" height=\"400\"></p><br>\r\n" + 
		    					"</html>";
		    	    	lblHTML.setText(tt);
		    	     
		    	    }else if (t.equalsIgnoreCase("Sửa phòng")) {
		    	    	String tt = "<html>\r\n" + 
		    					"    <h1 style=\"font-size: 1.5em; color:blue;\">&nbsp;Sửa phòng</h1><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 1: </b> Bạn chọn vào nút “QUẢN LÝ PHÒNG” để hiển thị giao diện quản lý phòng.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/TKP_B1.jpg")+"\" alt=\"\" width=\"300\" height=\"500\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 2: </b> Bạn chọn phòng cần sửa trên bảng.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/SP_B2.jpg")+"\" alt=\"\" width=\"800\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 3: </b> Bạn có thể chỉnh sửa thông tin trên ô giá phòng, số giường, số người.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/SP_B3.jpg")+"\" alt=\"\" width=\"900\" height=\"400\"></p><br>\r\n" + 
		    					"</html>";
		    	    	lblHTML.setText(tt);
		    	     
		    	    }
		    	    
		    	    else if (t.equalsIgnoreCase("Cập nhật thông tin khách hàng")) {
		    	    	String tt = "<html>\r\n" + 
		    					"    <h1 style=\"font-size: 1.5em; color:blue;\">&nbsp;Cập nhật thông tin khách hàng</h1><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 1: </b> Chọn khách hàng cần sửa.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/SuaKH1.png")+"\" alt=\"\" width=\"900\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 2: </b> Sửa thông tin.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 3: </b> Chọn nút Sửa.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/SuaKH2.png")+"\" alt=\"\" width=\"900\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 4: </b> Chọn Yes.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/SuaKH3.jpg")+"\" alt=\"\" width=\"900\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 5: </b> Chọn Ok.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/SuaKH4.jpg")+"\" alt=\"\" width=\"900\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b style=\"color: red;\">Lưu ý: Không được sửa mã NV.</b> </p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b style=\"color: red;\">Nếu muốn sửa căn cước: sửa số căn cước -> nhấn F2.</b> </p><br>\r\n" + 
		    					"</html>";
		    	    	lblHTML.setText(tt);
		    	     
		    	    }else if (t.equalsIgnoreCase("Xóa khách hàng")) {
		    	    	String tt = "<html>\r\n" + 
		    					"    <h1 style=\"font-size: 1.5em; color:blue;\">&nbsp;Xóa khách hàng</h1><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 1: </b> Chọn dòng cần xóa.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/XoaKH1.png")+"\" alt=\"\" width=\"900\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 2: </b> Chọn nút Xóa hoặc Nhấn Delete.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/XoaKH2.png")+"\" alt=\"\" width=\"900\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 3: </b> : Chọn Yes.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/XoaKH3.jpg")+"\" alt=\"\" width=\"900\" height=\"400\"></p><br>\r\n" + 
		    					"</html>";
		    	    	lblHTML.setText(tt);
		    	     
		    	    }else if (t.equalsIgnoreCase("Thêm khách hàng")) {
		    	    	String tt = "<html>\r\n" + 
		    					"    <h1 style=\"font-size: 1.5em; color:blue;\">&nbsp;Thêm khách hàng</h1><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 1: </b> Nhập tên khách hàng.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/ThemKH1.png")+"\" alt=\"\" width=\"900\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 2: </b> Nhập căn cước gồm 12 ký tự số.</p><br>\r\n" + 
		    					
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 3: </b>Nhập Số DT.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/ThemKH2.png")+"\" alt=\"\" width=\"900\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 4: </b>Chọn loại khách hàng.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/ThemKH3.png")+"\" alt=\"\" width=\"900\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 5: </b>Chọn nút Thêm hoặc Nhấn Enter</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/ThemKH4.png")+"\" alt=\"\" width=\"900\" height=\"400\"></p><br>\r\n" + 
		    					"</html>";
		    	    	lblHTML.setText(tt);
		    	     
		    	    }else if (t.equalsIgnoreCase("Tìm kiếm khách hàng")) {
		    	    	String tt = "<html>\r\n" + 
		    					"    <h1 style=\"font-size: 1.5em; color:blue;\">&nbsp;Tìm kiếm khách hàng</h1><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 1: </b> Chọn kiểu tìm kiếm (theo tên hoặc căn cước).</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 2: </b> Nhập tên hoặc căn cước.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 3: </b> : Chọn Yes.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/TimKiemKH.png")+"\" alt=\"\" width=\"900\" height=\"400\"></p><br>\r\n" + 
		    					"</html>";
		    	    	lblHTML.setText(tt);
		    	     
		    	    }else if (t.equalsIgnoreCase("Sửa nhân viên")) {
		    	    	String tt = "<html>\r\n" + 
		    					"    <h1 style=\"font-size: 1.5em; color:blue;\">&nbsp;Sửa nhân viên</h1><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 1: </b> Chọn nhân viên cần sửa.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/SuaNV1.png")+"\" alt=\"\" width=\"900\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 2: </b> Sửa thông tin.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 3: </b> Chọn nút Sửa.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/SuaNV3.png")+"\" alt=\"\" width=\"900\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 4: </b> Chọn Yes.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/SuaNV4.jpg")+"\" alt=\"\" width=\"900\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 5: </b> Chọn Ok.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/SuaNV5.jpg")+"\" alt=\"\" width=\"900\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b style=\"color: red;\">Lưu ý: Không được sửa mã NV, nếu muốn sửa căn cước: sửa căn cước -> nhấn F2.</b> </p><br>\r\n" + 
		    					
		    					"</html>";
		    	    	lblHTML.setText(tt);
		    	     
		    	    }else if (t.equalsIgnoreCase("Xóa nhân viên")) {
		    	    	String tt = "<html>\r\n" + 
		    					"    <h1 style=\"font-size: 1.5em; color:blue;\">&nbsp;Xóa nhân viên</h1><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 1: </b> Chọn dòng cần xóa.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/XoaNV1.png")+"\" alt=\"\" width=\"900\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 2: </b> Chọn nút Xóa hoặc Nhấn Delete.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/XoaNV2.png")+"\" alt=\"\" width=\"900\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 3: </b> : Chọn Yes.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/XoaNV3.jpg")+"\" alt=\"\" width=\"900\" height=\"400\"></p><br>\r\n" + 
		    					"</html>";
		    	    	lblHTML.setText(tt);
		    	     
		    	    }else if (t.equalsIgnoreCase("Thêm nhân viên")) {
		    	    	String tt = "<html>\r\n" + 
		    					"    <h1 style=\"font-size: 1.5em; color:blue;\">&nbsp;Thêm nhân viên</h1><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/ThemNV1.png")+"\" alt=\"\" width=\"900\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 1: </b> : Nhập mã nhân viên theo qui ước bắt đầu bằng “NV” theo sau là 3 ký tự số.</p><br>\r\n" + 
		    					
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 2: </b>Nhập tên nhân viên.</p><br>\r\n" + 
		    					
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 3: </b>Nhập căn cước gồm 12 ký tự số.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/ThemNV2.png")+"\" alt=\"\" width=\"900\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 4: </b>Chọn ngày tháng năm sinh.</p><br>\r\n" + 
		    					
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 5: </b>Chọn giới tính.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 6: </b>Nhập địa chỉ.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/ThemNV3.png")+"\" alt=\"\" width=\"900\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 7: </b>Nhập Số DT.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 8: </b>Chọn chức vụ.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/ThemNV4.png")+"\" alt=\"\" width=\"900\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 9: </b>Chọn nút Thêm hoặc Nhấn Enter.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b style=\"color: red;\">-	Lưu ý: Tài khoản đăng nhập là mã NV, mật khẩu là ngày tháng năm sinh VD:02/04/1998   -> Mật khẩu: 241998</b> </p><br>\r\n" + 
		    					
		    					"</html>";
		    	    	lblHTML.setText(tt);
		    	     
		    	    }else if (t.equalsIgnoreCase("Tìm kiếm nhân viên")) {
		    	    	String tt = "<html>\r\n" + 
		    					"    <h1 style=\"font-size: 1.5em; color:blue;\">&nbsp;Tìm kiếm nhân viên</h1><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 1: </b> Chọn kiểu tìm kiếm (theo tên hoặc căn cước).</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 2: </b> Nhập tên hoặc căn cước.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 3: </b> : Chọn Yes.</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/TimKiemNV.png")+"\" alt=\"\" width=\"900\" height=\"400\"></p><br>\r\n" + 
		    					"</html>";
		    	    	lblHTML.setText(tt);
		    	     
		    	    }else if (t.equalsIgnoreCase("Thống kê doanh thu")) {
		    	    	String tt = "<html>\r\n" + 
		    					"    <h1 style=\"font-size: 1.5em; color:blue;\">&nbsp;Thống kê doanh thu</h1><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 1: </b> Chọn chức năng thống kê doanh thu trên thanh Menu</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/THK1.png")+"\" alt=\"\" width=\"300\" height=\"500\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 2: </b> Chọn hình thức thống kê theo doanh thu, phòng, dịch vụ trong thời gian tháng hoặc năm</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/THK2.png")+"\" alt=\"\" width=\"700\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 3: </b> Chọn thống kê doanh thu theo tháng</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/THK3.png")+"\" alt=\"\" width=\"700\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 4: </b> Chọn năm và tháng cần thống kê</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/THK4.png")+"\" alt=\"\" width=\"700\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 5: </b> Chọn biểu đồ hiển thị theo doanh số thống kê</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/THK5.png")+"\" alt=\"\" width=\"700\" height=\"400\"></p><br>\r\n" + 
		    					"</html>";
		    	    	lblHTML.setText(tt);
		    	     
		    	    }else if (t.equalsIgnoreCase("Thanh toán")) {
		    	    	String tt = "<html>\r\n" + 
		    					"    <h1 style=\"font-size: 1.5em; color:blue;\">&nbsp;Thanh toán</h1><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 1: </b> Chọn vào Nút Quản lý Thanh Toán</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/TT1.png")+"\" alt=\"\" width=\"300\" height=\"500\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 2: </b> Tìm kiếm Hoá Đơn Muốn Thanh Toán theo mã thẻ căn cước của khách hàng</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/TT2.png")+"\" alt=\"\" width=\"700\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 3: </b> Chọn vào hoá đơn cần thanh toán và chọn vào nút thanh toán</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/TT3.png")+"\" alt=\"\" width=\"700\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/TT31.png")+"\" alt=\"\" width=\"700\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 4: </b> Xem lại Thông tin Phòng và dịch vụ tại giao diện Hoá Đơn</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/TT4.png")+"\" alt=\"\" width=\"700\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 5: </b> Chọn vào Nút Thanh Toán để tiến Hành thanh toán tiền</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/TT5.png")+"\" alt=\"\" width=\"700\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 6: </b> Nhận Tiền từ khách Hàng và nhập Thông tin nhận tiền vào trường Số tiền khách \r\n" + 
		    					"đưa ở Giao Diện Thanh Toán Hoá Đơn\r\n" + 
		    					"</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/TT6.png")+"\" alt=\"\" width=\"700\" height=\"400\"></p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<b>Bước 7: </b> Nhấn Nút in hoá Đơn và xuất hoá đơn cho khách hàng</p><br>\r\n" + 
		    					"    <p>&nbsp;&nbsp;&nbsp;<img src=\""+Help.class.getResource("/com/hotel/project/gui/home/image/TT7.png")+"\" alt=\"\" width=\"700\" height=\"400\"></p><br>\r\n" + 
		    					"</html>";
		    	    	lblHTML.setText(tt);
		    	     
		    	    }
		    
		      }
		    });
	}
	
	/**
	 * Create the frame.
	 */
	public Help() {
		
	}
		

	
}








 







