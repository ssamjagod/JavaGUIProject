package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.GuestDAO;
import dao.RoomDAO;
import data.Calendar;
import dto.Guest;
import dto.RoomDTO;

public class Screen extends JFrame implements ActionListener {
	JFrame frame = new JFrame("www.HumanHotel.com");
	Calendar c = new Calendar();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel a1 = new JPanel();
	JPanel a2 = new JPanel();
	JPanel a3 = new JPanel();
	JPanel in1 = new JPanel();
	JPanel in4 = new JPanel();
	JPanel rArea = new JPanel();
	JPanel rT = new JPanel();
	JPanel rInf = new JPanel();
	JPanel rBut = new JPanel();
	JPanel rp = new JPanel();
	JPanel room = new JPanel();
	JPanel inpan = new JPanel();
	JPanel outpan = new JPanel();
	String[] roomdata = { "standard", "superior", "delux", "suite" };
	String[] p = { "인원수", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
	ArrayList<String> roomNumber = new ArrayList<String>();
	private static final String[] bimg = { "background/b1.jpg", "background/b2.jpg", "background/b3.jpg",
			"background/b4.jpg", "background/b5.jpg", "background/b6.jpg" };
	private static final String[] menuImg = { "menu/loc.png", "menu/introduce.png" };
	private static final String[] serImg = { // 이미지 경로 문자열로 저장
			"service/s1.png", "service/s2.png", "service/s3.png" };
	private static final String[] standard = { // 이미지 경로 문자열로 저장
			"standard/s1.jpg", "standard/s2.jpg", "standard/s3.jpg" };
	private static final String[] superior = { // 이미지 경로 문자열로 저장
			"superior/s1.jpg", "superior/s2.jpg", "superior/s3.jpg" };
	private static final String[] delux = { // 이미지 경로 문자열로 저장
			"delux/d1.jpg", "delux/d2.jpg", "delux/d3.jpg" };
	private static final String[] suite = { // 이미지 경로 문자열로 저장
			"suite/s1.jpg", "suite/s2.jpg", "suite/s3.jpg" };
	String[] temp = { "", "", "" };

	JLabel t3 = new JLabel("예약자명 ");
	JLabel t4 = new JLabel("입실");
	JLabel t5 = new JLabel("퇴실");
	JLabel t6 = new JLabel("인원수");
	JLabel rtype = new JLabel("객실");
	JLabel exp = new JLabel();
	JLabel locc = new JLabel();
	JLabel sLabel = new JLabel();
	JLabel rTitle = new JLabel();
	JLabel lblImage = new JLabel();
	JLabel lblImage1 = new JLabel();
	JLabel lblImage2 = new JLabel();
	JLabel lblImage3 = new JLabel();
	JLabel standardInf1 = new JLabel("STABDARD ROOM");
	JLabel standardInf2 = new JLabel("");
	JLabel standardInf3 = new JLabel("편안함과 쾌적함이 인상적인 휴식 공간");

	JLabel superiorInf1 = new JLabel("SUPERIOR ROOM");
	JLabel superiorInf2 = new JLabel();
	JLabel superiorInf3 = new JLabel("모던한 감각에 세련된 오리엔탈 무드를 가미한 공간");

	JLabel deluxInf1 = new JLabel("DELUXE ROOM");
	JLabel deluxInf2 = new JLabel();
	JLabel deluxInf3 = new JLabel("여유로운 공간과 비즈니스와 여행의 즐거움");

	JLabel suiteInf1 = new JLabel("SUITE ROOM");
	JLabel suiteInf2 = new JLabel();
	JLabel suiteInf3 = new JLabel("국내외 최정상의 VIP만을 위해 준비된 룸");

	Font font1 = new Font("휴먼편지체", Font.BOLD, 40);
	Font font2 = new Font("휴먼편지체", Font.BOLD, 30);
	Font font3 = new Font("휴먼편지체", Font.BOLD, 20);
	Font font4 = new Font("휴먼편지체", Font.BOLD, 15);
	JButton look = new JButton("예약확인");
	JButton join = new JButton("회원가입");
	JButton login = new JButton("로그인");
	JButton logout = new JButton("로그아웃");
	JTextField geustName = new JTextField(10);
	JButton introduce = new JButton("호텔소개");
	JButton location = new JButton("위치");
	JButton service = new JButton("서비스");
	JButton reservation = new JButton("예약하기");
	JButton indate = new JButton("체크인 날짜");
	JButton outdate = new JButton("체크아웃 날짜");
	JButton right = new JButton(">");
	JButton left = new JButton("<");
	JButton check = new JButton("예약하기");
	String nowid;
	JComboBox rType1 = new JComboBox(roomdata);
	JComboBox preview = new JComboBox(roomdata);
	JComboBox<String> roomNum;
	JComboBox rNUM = new JComboBox(p);
	JComboBox inYear = new JComboBox(c.year);
	JComboBox inMonth = new JComboBox(c.month);
	JComboBox inDay = new JComboBox(c.day);
	JComboBox outYear = new JComboBox(c.year);
	JComboBox outMonth = new JComboBox(c.month);
	JComboBox outDay = new JComboBox(c.day);
	JComboBox personNumber = new JComboBox(p);
	GuestDAO gd = new GuestDAO();
	RoomDAO rdao = new RoomDAO();
	
	int i = 0;
	int log = 0;
	int roomi = 0;
	String a = null;
	String iyear = null;
	String iMonth = null;
	String iDay = null;
	String oyear = null;
	String oMonth = null;
	String oDay = null;
	String in = null;
	String out = null;
	String roomType = null;
	String person = null;
	String roomnum = null;
	Guest tempg;
	
	
	public Screen() {
		mainScreen(nowid);
	}
	

	public void mainScreen(String getid) {
		Guest g = new Guest();
		tempg = g;
		nowid = getid;
		g.setId(nowid);

		frame.setBounds(30, 70, 880, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLayout(null);
		if (getid != null) {
			log = 1;
			JLabel tt1 = new JLabel("        Human Hotel     ");
			JLabel tt2 = new JLabel("[" + nowid + "]  님   환영합니다");

			frame.remove(a1);
			frame.add(panel1);
			panel1.setBackground(Color.LIGHT_GRAY);
			panel1.setBounds(0, 0, 900, 70);
			panel1.add(tt2);
			panel1.add(tt1);
			tt1.setFont(font1);
			panel1.add(look);
			panel1.add(logout);
			introduce.setFont(new Font("굴림", Font.BOLD, 12));
			location.setFont(new Font("굴림", Font.BOLD, 12));
			service.setFont(new Font("굴림", Font.BOLD, 12));
			reservation.setFont(new Font("굴림", Font.BOLD, 12));

			panel2.remove(lblImage1);
			panel2.remove(lblImage2);
			panel2.remove(lblImage3);
			look.addActionListener(this);
			logout.addActionListener(this);
		} else if (getid == null) {

			JLabel t1 = new JLabel("           Human Hotel     ");

			frame.add(a1);
			a1.setBackground(Color.LIGHT_GRAY);
			a1.setBounds(0, 0, 900, 70);
			a1.add(t1);
			t1.setFont(font1);
			a1.add(join);
			a1.add(login);
			introduce.setFont(new Font("굴림", Font.BOLD, 12));
			location.setFont(new Font("굴림", Font.BOLD, 12));
			service.setFont(new Font("굴림", Font.BOLD, 12));
			reservation.setFont(new Font("굴림", Font.BOLD, 12));
			login.addActionListener(this);
			join.addActionListener(this);
		}

		frame.add(panel2);
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2.setBounds(0, 70, 900, 200);
		panel2.setBackground(Color.white);

		lblImage1.setIcon(new ImageIcon(bimg[0]));
		lblImage2.setIcon(new ImageIcon(bimg[1]));
		lblImage3.setIcon(new ImageIcon(bimg[4]));

		panel2.add(lblImage1);
		panel2.add(lblImage2);
		panel2.add(lblImage3);
		// 배경이미지

		// b3 메뉴 선택 들어잇음
		panel3.setLayout(null);
		panel3.removeAll();
		frame.add(panel3);
		panel3.setBackground(Color.white);
		panel3.setBounds(10, 300, 880, 500);

		panel3.add(in1);

		in1.setBounds(0, 0, 440, 50);
		in1.setBackground(Color.gray);
		in1.setLayout(new GridLayout(1, 4));
		in1.add(introduce);
		in1.add(location);
		in1.add(service);
		in1.add(reservation);
		// b3
		panel3.add(rT);
		rT.setBounds(500, 0, 300, 50);
		rT.setBackground(Color.gray);
		rT.add(preview); // 객실타입 콤보박스

		panel3.setVisible(false);
		panel3.add(right);
		right.setBounds(800, 160, 50, 40);
		panel3.add(left);
		left.setBounds(450, 160, 50, 40);
		panel3.setVisible(true);
		// 설명 들어가있는 패널
		rInf.setBounds(505, 300, 300, 150);
		rInf.setBackground(Color.lightGray);
		rInf.setLayout(new GridLayout(4, 1));
		panel3.add(rInf);

		preview.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JComboBox crtt = (JComboBox) e.getSource();
				int index = crtt.getSelectedIndex();
				System.out.println(index);
				roomInf(index);
				if (index == 0) {
					temp = standard;
				} else if (index == 1) {
					temp = superior;
				} else if (index == 2) {
					temp = delux;
				} else if (index == 3) {
					temp = suite;
				}
				roompic(0, temp);
			}

		});

		rType1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e1) {

				JComboBox crt = (JComboBox) e1.getSource();
				int index = crt.getSelectedIndex();
				roomInf(index);
				if (index == 0) {
					rT.setVisible(false);
					rT.removeAll();
					temp = standard;
					String st = "standard";
					rdao.getrNum(roomNumber, st);
					JComboBox<String> rrrrr = new JComboBox<String>(roomNumber.toArray(new String[roomNumber.size()]));
					rT.add(rrrrr); // 룸넘버 들어갈 곳
					rrrrr.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							JComboBox crrr = (JComboBox) e.getSource();
							roomnum = rrrrr.getSelectedItem().toString();
						}

					});
					rT.setVisible(true);
				} else if (index == 1) {
					rT.setVisible(false);
					rT.removeAll();
//					rT.remove(rrrrr);
//					rT.remove(rtt);
					temp = superior;
					String su = "superior";
					rdao.getrNum(roomNumber, su);
					JComboBox<String> rrrrr = new JComboBox<String>(roomNumber.toArray(new String[roomNumber.size()]));
					rT.add(rrrrr); // 룸넘버 들어갈 곳
					rrrrr.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							JComboBox crrr = (JComboBox) e.getSource();
							roomnum = rrrrr.getSelectedItem().toString();
						}

					});
					rT.setVisible(true);

				} else if (index == 2) {
					rT.setVisible(false);
					repaint();
					rT.removeAll();
					temp = delux;
					String de = "delux";
					rdao.getrNum(roomNumber, de);
					JComboBox<String> rrrrr = new JComboBox<String>(roomNumber.toArray(new String[roomNumber.size()]));
					rT.add(rrrrr); // 룸넘버 들어갈 곳
					rrrrr.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							JComboBox crrr = (JComboBox) e.getSource();
							roomnum = rrrrr.getSelectedItem().toString();
						}

					});
					rT.setVisible(true);

				} else if (index == 3) {
					rT.setVisible(false);
					repaint();
					rT.removeAll();
//					rT.remove(rrrrr);
//					rT.remove(rtt);
					temp = suite;
					String sui = "suite";
					rdao.getrNum(roomNumber, sui);
					JComboBox<String> rrrrr = new JComboBox<String>(roomNumber.toArray(new String[roomNumber.size()]));

					rT.add(rrrrr); // 룸넘버 들어갈 곳
					rrrrr.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							JComboBox crrr = (JComboBox) e.getSource();
							roomnum = rrrrr.getSelectedItem().toString();
						}

					});
					rT.setVisible(true);
				}
				roompic(0, temp);
			}

		});

		introduce.addActionListener(this);
		location.addActionListener(this);
		service.addActionListener(this);
		reservation.addActionListener(this);
		right.addActionListener(this);
		left.addActionListener(this);
		
		
		
		look.setBorder(BorderFactory.createLineBorder(Color.black));
		join.setBorder(BorderFactory.createLineBorder(Color.black));
		login.setBorder(BorderFactory.createLineBorder(Color.black));
		logout.setBorder(BorderFactory.createLineBorder(Color.black));
		introduce.setBorder(BorderFactory.createLineBorder(Color.black));
		location.setBorder(BorderFactory.createLineBorder(Color.black));
		service.setBorder(BorderFactory.createLineBorder(Color.black));
		reservation.setBorder(BorderFactory.createLineBorder(Color.black));
		indate.setBorder(BorderFactory.createLineBorder(Color.black));
		outdate.setBorder(BorderFactory.createLineBorder(Color.black));
		right.setBorder(BorderFactory.createLineBorder(Color.black));
		left.setBorder(BorderFactory.createLineBorder(Color.black));
		check.setBorder(BorderFactory.createLineBorder(Color.black));
		
	}

	public void roomInf(int index) {

		if (index == 0) {

			standardInf1.setHorizontalAlignment(JLabel.CENTER);
			standardInf2.setHorizontalAlignment(JLabel.CENTER);
			standardInf3.setHorizontalAlignment(JLabel.CENTER);
			standardInf1.setFont(font3);
			standardInf3.setFont(font4);
			rInf.remove(superiorInf1);
			rInf.remove(superiorInf2);
			rInf.remove(superiorInf3);
			rInf.remove(deluxInf1);
			rInf.remove(deluxInf2);
			rInf.remove(deluxInf3);
			rInf.remove(suiteInf1);
			rInf.remove(suiteInf2);
			rInf.remove(suiteInf3);
			panel3.setVisible(false);

			rInf.add(standardInf1);
			rInf.add(standardInf2);
			rInf.add(standardInf3);
			panel3.setVisible(true);
		} else if (index == 1) {

			superiorInf1.setHorizontalAlignment(JLabel.CENTER);
			superiorInf2.setHorizontalAlignment(JLabel.CENTER);
			superiorInf3.setHorizontalAlignment(JLabel.CENTER);
			superiorInf1.setFont(font3);
			superiorInf3.setFont(font4);
			rInf.remove(standardInf1);
			rInf.remove(standardInf2);
			rInf.remove(standardInf3);
			rInf.remove(deluxInf1);
			rInf.remove(deluxInf2);
			rInf.remove(deluxInf3);
			rInf.remove(suiteInf1);
			rInf.remove(suiteInf2);
			rInf.remove(suiteInf3);
			panel3.setVisible(false);
			rInf.add(superiorInf1);
			rInf.add(superiorInf2);
			rInf.add(superiorInf3);
			panel3.setVisible(true);
		} else if (index == 2) {

			deluxInf1.setHorizontalAlignment(JLabel.CENTER);
			deluxInf2.setHorizontalAlignment(JLabel.CENTER);
			deluxInf3.setHorizontalAlignment(JLabel.CENTER);
			deluxInf1.setFont(font3);
			deluxInf3.setFont(font4);
			rInf.remove(standardInf1);
			rInf.remove(standardInf2);
			rInf.remove(standardInf3);
			rInf.remove(superiorInf1);
			rInf.remove(superiorInf2);
			rInf.remove(superiorInf3);
			rInf.remove(suiteInf1);
			rInf.remove(suiteInf2);
			rInf.remove(suiteInf3);
			panel3.setVisible(false);
			rInf.add(deluxInf1);
			rInf.add(deluxInf2);
			rInf.add(deluxInf3);
			panel3.setVisible(true);

		} else if (index == 3) {

			suiteInf1.setHorizontalAlignment(JLabel.CENTER);
			suiteInf2.setHorizontalAlignment(JLabel.CENTER);
			suiteInf3.setHorizontalAlignment(JLabel.CENTER);
			suiteInf1.setFont(font3);
			suiteInf3.setFont(font4);
			rInf.remove(standardInf1);
			rInf.remove(standardInf2);
			rInf.remove(standardInf3);
			rInf.remove(superiorInf1);
			rInf.remove(superiorInf2);
			rInf.remove(superiorInf3);
			rInf.remove(deluxInf1);
			rInf.remove(deluxInf2);
			rInf.remove(deluxInf3);
			repaint();
//			b3.setVisible(false);
			rInf.add(suiteInf1);
			rInf.add(suiteInf2);
			rInf.add(suiteInf3);
//			b3.setVisible(true);
		}

	}

	public void check() {
		
		String gName = geustName.getText();
		iyear = inYear.getSelectedItem().toString();
		iMonth = inMonth.getSelectedItem().toString();
		iDay = inDay.getSelectedItem().toString();
		oyear = outYear.getSelectedItem().toString();
		oMonth = outMonth.getSelectedItem().toString();
		oDay = outDay.getSelectedItem().toString();
		in = iyear + "/" + iMonth + "/" + iDay;
		out = oyear + "/" + oMonth + "/" + oDay;
		roomType = rType1.getSelectedItem().toString();
		person = personNumber.getSelectedItem().toString();

		tempg.setName(gName);
		tempg.setInDate(in);
		tempg.setOutDate(out);
		tempg.setrType(roomType);
		tempg.setPerNum(person);
		tempg.setrNum(roomnum);
		if (tempg.getName() != null && iyear != "YEAR" && iMonth != "MONTH" && iDay != "DAY" && oyear != "YEAR"
				&& oMonth != "MONTH" && oDay != "DAY" && roomType != "RoomType" && person != "인원수") {
			gd.reservation(tempg);
			rdao.ing(tempg.getrNum());
			JOptionPane.showMessageDialog(null, gName + " 님 예약 되었습니다.");
		} else {
			JOptionPane.showMessageDialog(null, "예약정보를 전부 입력해주세요");
		}
	}

	public void roompic(int i, String temp[]) {

		panel3.remove(lblImage);
		panel3.setLayout(null);
		panel3.add(lblImage);
		lblImage.setBounds(520, -50, 600, 400);
		lblImage.setIcon(new ImageIcon(temp[i]));

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == login) {
			frame.setVisible(false);
			new Login();
			repaint();

		} else if (e.getSource() == join) {
			frame.setVisible(false);
			new Join();
			repaint();
		} else if (e.getSource() == logout) {
			new Screen();
			repaint();
		} else if (e.getSource() == look) {
			new ReservationDetail(nowid);
			repaint();
		} else if (e.getSource() == introduce) {
			introduce.setForeground(Color.blue);
			service.setForeground(Color.black);
			location.setForeground(Color.black);
			reservation.setForeground(Color.black);
			repaint();
			rArea.setVisible(false);
			panel3.remove(locc);
			panel3.remove(sLabel);
			panel3.remove(rArea);
			panel3.remove(t3);
			panel3.remove(geustName);
			panel3.remove(t4);
			panel3.remove(t5);
			panel3.remove(t6);
			panel3.remove(rtype);
			panel3.remove(rArea);
			exp.setIcon(new ImageIcon(menuImg[1]));
			panel3.add(exp);
			
			
			rArea.setVisible(true);
			panel3.remove(rArea);
			exp.setBounds(30, 55, 400, 400);
		} else if (e.getSource() == location) {
			introduce.setForeground(Color.black);
			service.setForeground(Color.black);
			reservation.setForeground(Color.black);
			location.setForeground(Color.blue);
			repaint();
			rArea.setVisible(false);
			panel3.remove(exp);
			panel3.remove(sLabel);
			panel3.remove(t3);
			panel3.remove(geustName);
			panel3.remove(t4);
			panel3.remove(t5);
			panel3.remove(t6);
			panel3.remove(rtype);
			panel3.remove(rArea);
			locc.setIcon(new ImageIcon(menuImg[0]));
			panel3.add(locc);
			
			
			rArea.setVisible(true);
			locc.setBounds(30, 50, 400, 400);
		} else if (e.getSource() == service) {
			introduce.setForeground(Color.black);
			location.setForeground(Color.black);
			service.setForeground(Color.blue);
			reservation.setForeground(Color.black);
			repaint();
			rArea.setVisible(false);
			panel3.remove(locc);
			panel3.remove(exp);
			panel3.remove(rArea);
			panel3.remove(t3);
			panel3.remove(geustName);
			panel3.remove(t4);
			panel3.remove(t5);
			panel3.remove(t6);
			panel3.remove(rtype);
			panel3.remove(rArea);
			rArea.setVisible(true);
			i++;
			if (i == 3) {
				i = 0;
			}
			sLabel.setIcon(new ImageIcon(serImg[i]));
			panel3.add(sLabel);
			
			
			sLabel.setBounds(30, 30, 400, 400);
		} else if (e.getSource() == reservation) {
			repaint();
			if (log == 1) {
				introduce.setForeground(Color.black);
				service.setForeground(Color.black);
				location.setForeground(Color.black);
				reservation.setForeground(Color.blue);
				rArea.setVisible(false);
				panel3.remove(exp);
				panel3.remove(locc);
				panel3.remove(sLabel);
				panel3.remove(rArea);
				panel3.remove(t3);
				panel3.remove(geustName);
				panel3.remove(t4);
				panel3.remove(t5);
				panel3.remove(t6);
				panel3.remove(rtype);
				panel3.setVisible(false);
				panel3.add(rArea);
				panel3.setVisible(true);
				rArea.setBounds(0, 50, 430, 450);
				rArea.setBackground(Color.LIGHT_GRAY);
				rArea.setLayout(null);
				rArea.setVisible(true);
				rArea.add(t3); // 예약자명
				t3.setBounds(50, 40, 80, 50);
				rArea.add(geustName); // 예약자 textField
				geustName.setBounds(130, 50, 150, 30);
				rArea.add(t4); // 입실
				t4.setBounds(50, 90, 80, 50);
				rArea.add(inYear);
				inYear.setBounds(130, 100, 80, 30);
				rArea.add(inMonth);
				inMonth.setBounds(220, 100, 80, 30);
				rArea.add(inDay);
				inDay.setBounds(310, 100, 80, 30);
				rArea.add(outYear);
				outYear.setBounds(130, 150, 80, 30);
				rArea.add(outMonth);
				outMonth.setBounds(220, 150, 80, 30);
				rArea.add(outDay);
				outDay.setBounds(310, 150, 80, 30);
				rArea.add(t5); // 퇴실
				t5.setBounds(50, 140, 80, 50);
				rArea.add(t6); // 퇴실
				t6.setBounds(50, 250, 80, 50);

				rArea.add(rtype);
				rtype.setBounds(50, 190, 80, 50);

				rArea.add(rType1);
				rType1.setBounds(130, 200, 130, 30);
				// rt가 그거임 예약할때 하는거

				rArea.add(personNumber);
				personNumber.setBounds(130, 260, 130, 30);

				rArea.add(check);
				check.setBounds(300, 350, 100, 40);
				check.addActionListener(this);

			} else if (log == 0) {
				JOptionPane a2 = new JOptionPane();
				a2.showMessageDialog(null, "로그인이 필요합니다.");
			}
		} else if (e.getSource() == right) {
			repaint();
			i++;
			if (i == 3) {
				i = 0;
			}
			roompic(i, temp);
		} else if (e.getSource() == left) {
			repaint();
			i--;
			if (i == -1) {
				i = 2;
			}
			roompic(i, temp);
		}
		if (e.getSource() == check) {
			check();
		}
	}

}
