package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dao.GuestDAO;

public class ReservationDetail extends JFrame{
	JFrame rd = new JFrame();
	JPanel title = new JPanel();
	JPanel table = new JPanel();
	JLabel nowid = new JLabel();
	Font tfont = new Font("휴먼편지체", Font.BOLD, 20);
	GuestDAO gg = new GuestDAO();
	ReservationDetail(String id) {
		
		rd.setBounds(30, 30, 600, 130);
		rd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		rd.setLayout(null);
		rd.setVisible(true);	
		rd.add(title);
		title.setBackground(Color.white);
		title.setBounds(0, 0, 600, 40);
		nowid.setText("["+ id + "] 님의 예약내역");
		nowid.setFont(tfont);
		title.add(nowid);
		rd.add(table);
		table.setBounds(0, 40, 600, 60);
		table.setBackground(Color.gray);
		table.add(gg.detail(id));
		
		
	}
	
}
