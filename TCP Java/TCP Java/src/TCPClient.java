import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws Exception {
        Scanner inFromUser = new Scanner(System.in); //for user input
        Socket clientSocket = new Socket("localhost", 15001); //make connection to server
        System.out.println("Enter your message: ");
        String message = inFromUser.nextLine();

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        outToServer.writeBytes(message+"\n");

        Scanner inFromServer = new Scanner(clientSocket.getInputStream());
        String modMessage = inFromServer.nextLine();
        System.out.println("Modified message: "+modMessage);

        clientSocket.close();
        outToServer.close();
        inFromServer.close();
        inFromUser.close();
    }
}
