package com.koreait.shoppingmall.android.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerMessageThread extends Thread{
	ChatServer chatServer;
	Socket socket;
	BufferedReader buffr; //듣기용
	BufferedWriter buffw;//말하기용 
	
	public ServerMessageThread(ChatServer chatServer, Socket socket) {
		this.chatServer=chatServer;
		this.socket=socket;
		
		try {
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//듣고
	public void listen() {
		String msg=null;
		
		try {
			msg=buffr.readLine();
			send(msg);//들은말을 다시 클라이언트에게 보내기
			chatServer.area.append(msg+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//말하기 :  멀티케스팅 (다수의 상대방에게 메시지 전송)
	public void send(String msg) {
		
		try {
			for(int i=0;i<chatServer.clientList.size();i++){
				ServerMessageThread smt=chatServer.clientList.get(i);
				smt.buffw.write(msg+"\n");
				smt.buffw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(true) {
			listen();
		}
	}
}








