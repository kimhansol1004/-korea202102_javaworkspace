package gui.backup;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ChatClient extends JFrame{
	JPanel p_north;
	JTextField t_ip;
	JTextField t_port;
	JButton bt_connect;
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	JButton bt_send;
	Socket socket;
	ClientMsgThread msgThread;
	
	public ChatClient() {
		p_north = new JPanel();
		t_ip = new JTextField("192.168.55.227",10);
		t_port = new JTextField(5);
		bt_connect = new JButton("접속");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		p_south = new JPanel();
		t_input = new JTextField(20);
		bt_send = new JButton("send");
		
		//조립 
		p_north.add(t_ip);
		p_north.add(t_port);
		p_north.add(bt_connect);
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		p_south.add(t_input);
		p_south.add(bt_send);
		add(p_south, BorderLayout.SOUTH);
		
		//이벤트 
		bt_connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//접속시도 
				connect();
			}
		});
		
		//윈도우창 닫을때 해야할 작업(쓰레드 종료: 즉 청취 종료) 
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				
			}
		});
		
		
		//보이기 
		setVisible(true);
		setBounds(0, 100, 300, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void connect() {
		String ip=t_ip.getText();
		int port=Integer.parseInt(t_port.getText());
		try {
			socket = new Socket(ip, port); //접속!!!!!!!
			//클라이언트 측의 대화용 쓰레드 생성 
			msgThread = new ClientMsgThread(socket, this);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ChatClient();

	}

}




