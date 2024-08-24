import java.util.Scanner;
import java.net.InetAddress;
import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class UDPClient {

    public static void main(String[] args) throws Exception {
        Scanner inFromUser = new Scanner(System.in); // create user input
        DatagramSocket clientSocket = new DatagramSocket(); // UDP socket
        InetAddress serverAddress = InetAddress.getLocalHost(); // get IP of local host
        int serverPort = 14001;
        System.out.print("Enter your message: "); // get message from user
        String message = inFromUser.nextLine(); // read message from user
        byte[] sendData = message.getBytes(); // convert message to byte sequence
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
        clientSocket.send(sendPacket); // send the packet

        byte[] receiveData = new byte[2048]; // buffer to store the return message
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket); // fill packet with data
        String modifiedMessage = new String(receivePacket.getData()); // get message from packet
        System.out.print("From server: "+modifiedMessage);

        clientSocket.close(); // close the socket
        inFromUser.close(); // close the scanner
    }

}
