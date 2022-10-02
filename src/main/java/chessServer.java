import services.ServiceConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class chessServer {
    public static void main(String[] args) throws Exception{
        //preparation server
        ServerSocket serverSocket= new ServerSocket(8088);
        System.out.println("Server Start : http://localhost:8088/");
        while (true) {
            //wait any client
            Socket clientSocket = serverSocket.accept();
            // create a new thread object
            PlayerHandler playerHandler= new PlayerHandler(clientSocket);
            // This thread will handle the client
            new Thread(playerHandler).start();
        }
    }
}
