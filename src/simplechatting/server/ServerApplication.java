package simplechatting.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApplication {

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		
		try {															// 누군가 9090포트를 사용 시 서버가 열리지 않기 때문에, 예외 처리
			serverSocket = new ServerSocket(9090);
			System.out.println("========<< 서버 실행 >>========");
			
			Socket socket = serverSocket.accept();						// 클라이언트의 접속을 기다림 (방장이 방을 하나 팜)			
			
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter out = new PrintWriter(outputStream,  true);		// 데이터를 보내는 통로를 하나 만들어주는 작업
			out.println("join");
			
			InputStream inputStream = socket.getInputStream();			// 다시, 들어올 수 있는 문을 열어줌
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			
			String welcomeMessage = in.readLine();						// 누구누구가 접속했다~ 라는 메세지를 받음
			System.out.println(welcomeMessage);
			out.println(welcomeMessage);								// 서버가 다시 클라이언트에게 welcome메세지를 던져줌
			
			while(true) {
				in.readLine();
			}
	
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			if(serverSocket != null) {
				
				try {
					serverSocket.close();								// 서버 소켓이 열려있지 않을 수도 있기에, 예외처리
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("========<< 서버 종료 >>========");
		}
	}
}
