import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        //creates a welcome socket for clients to connect to bound to a given port
        ServerSocket welcomeSocket = new ServerSocket(15001);
        System.out.println("Server ready...");

        while(true) {
            Socket serverSocket = welcomeSocket.accept(); //creates a connection to client
            Scanner inFromClient = new Scanner(serverSocket.getInputStream());
            String message = inFromClient.nextLine(); //read message from client
            System.out.println("Message recieved: "+message);
            String modMessage = message.toUpperCase();
            System.out.println("Modified message: "+modMessage);

            DataOutputStream outToClient = new DataOutputStream(serverSocket.getOutputStream());
            outToClient.writeBytes(modMessage+"\n");

            //close sockets & streams
            serverSocket.close();
            inFromClient.close();
            outToClient.close();
        }

    }
}
