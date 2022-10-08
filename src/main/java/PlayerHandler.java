import html.CodeHtml;
import services.ServiceConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PlayerHandler implements Runnable{
    private final Socket clientSocket;
    public PlayerHandler(Socket clientSocket){
        this.clientSocket= clientSocket;
    }
    @Override
    public void run() {
        try {
//preparation input
            BufferedReader reader =new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // Assign http requests to HttpWorker
            String req = reader.readLine();
            if(!req.contains("favicon.ico")){
                //reponse
                String response= ServiceConnection.reponseForConnection(req);
                //preparation output
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                //Send HTTP header
                out.println("HTTP/1.2 200");
                if (response.startsWith("{")){
                    out.println("Content-type: application/json");
                    out.println("Access-Control-Allow-Origin: *");
                }else
                    out.println("Content-type: text/html");
                out.println("Content-length: " + response.length());
                out.println("");
                //Send Response
                out.println(response);
                //closes

                out.println(CodeHtml.getMenuHtmlCode());
                out.flush();
                out.close();
            }

            clientSocket.close();
        }catch (Exception e){

        }

    }
}
