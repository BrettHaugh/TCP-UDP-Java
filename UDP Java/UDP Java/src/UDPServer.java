import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        int serverPort = 14001; // same port as client will send to
        DatagramSocket serverSocket = new DatagramSocket(serverPort); // creates our socket
        System.out.print("Server ready");

        while(true) {
            byte[] receiveData = new byte[2048]; // buffer to store the return message
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket); // fill packet with data
            String message = new String(receivePacket.getData());
            String modMessage = message.toUpperCase();
            System.out.print(message+"\n"+modMessage);
            byte[] sendData = modMessage.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, 
                receivePacket.getAddress(), receivePacket.getPort());
            serverSocket.send(sendPacket);
        }
    }
}
