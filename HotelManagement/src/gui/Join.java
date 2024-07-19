package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import dao.GuestDAO;
import dto.Guest;

public class Join extends JFrame implements ActionListener {
	JPanel[] m = new JPanel[5];
	JLabel title = new JLabel("회원가입");
	JLabel id = new JLabel("ID");
	JLabel pw = new JLabel("pw");
	TextField idt = new TextField(13);
	TextField pwt = new TextField(13);
	JButton joinButton = new JButton("회원가입");
	private Guest ut = new Guest();
	private GuestDAO ua = new GuestDAO();

//	Login lo = new Login();

	public Join() {
		this.setBounds(100, 100, 300, 250);
		this.setLayout(new GridLayout(5, 1));
		for (int i = 0; i < m.length; i++) {
			m[i] = new JPanel();
			this.add(m[i]);
		}

		m[0].add(title);
		m[1].add(id);
		m[1].add(idt);
		m[2].add(pw);
		m[2].add(pwt);

		m[4].add(joinButton);

		pwt.setEchoChar('*');

		joinButton.addActionListener(this);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String getid = idt.getText();
		String getpw = pwt.getText();
		if (e.getSource().equals(joinButton)) {
			ut.setId(getid);
			ut.setPw(getpw);
			if (ua.insert(ut)) {
				this.setVisible(false);
				JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
				new Screen();
			} else {
				JOptionPane.showMessageDialog(null, "중복된 아이디입니다.");
			}

		}

	}

}
