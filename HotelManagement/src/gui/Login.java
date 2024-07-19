package gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.GuestDAO;

public class Login extends JFrame implements ActionListener {
	JPanel[] m = new JPanel[5];

	JLabel title = new JLabel("휴먼 호텔");
	JLabel wel = new JLabel("환영합니다");
	JLabel id = new JLabel("ID");
	JLabel pw = new JLabel("PW");
	TextField idt = new TextField(13);
	TextField pwt = new TextField(13);
	JButton loginButton = new JButton("로그인");
	JButton joinButton = new JButton("회원가입");
	Font rfont = new Font("HY엽서M", Font.BOLD, 20);
	Screen res = new Screen();
	private GuestDAO ua = new GuestDAO();

	public Login() {
		res.frame.setVisible(false);
		this.setBounds(200, 200, 300, 200);
		this.setLayout(new GridLayout(5, 1));
		for (int i = 0; i < m.length; i++) {
			m[i] = new JPanel();
			this.add(m[i]);
		}
		pwt.setEchoChar('*');

		m[0].add(title);
		m[1].add(id);
		m[1].add(idt);
		m[2].add(pw);
		m[2].add(pwt);
		m[3].add(wel);
		m[4].add(loginButton);
		m[4].add(joinButton);
		// 컴포넌트 중에 save 컴포넌트는 인터페이스의 기능을 사용할 컴포넌트 이다
		loginButton.addActionListener(this);
		joinButton.addActionListener(this);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String getid = idt.getText();
		String getpw = pwt.getText();
		if (e.getSource().equals(joinButton)) {
			this.setVisible(false);
			new Join();

		} else if (e.getSource().equals(loginButton)) {
			wel.setText("아이디 혹은 패스워드가 일치하지 않습니다.");
			if (ua.chkuser(getid, getpw) != null) {
				this.setVisible(false);
				res.mainScreen(getid);

			} else {
				System.out.println("실패");
			}

		}

	}

}
