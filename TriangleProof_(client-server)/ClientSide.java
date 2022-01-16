import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress;
import java.util.Scanner; 

public class ClientSide2 
{ 
    public static void main(String args[]) throws IOException 
    { 
        Scanner sc = new Scanner(System.in); 
  
        // Step 1:Create the socket object for 
        // carrying the data. 
        DatagramSocket ds = new DatagramSocket(); 
  
        InetAddress ip = InetAddress.getLocalHost(); 
        byte buf[] = null; 
        byte buf2[] = null; 
        byte buf3[] = null; 
        
        System.out.println("enter 3 edges...");
  
        // loop while user not enters "bye" 
        while (true) 
        { 
            System.out.print("edge 1: ");
            String inp = sc.nextLine(); 
            System.out.print("edge 2: ");
            String inp2 = sc.nextLine();
            System.out.print("edge 3: ");
            String inp3 = sc.nextLine();
  
            // convert the String input into the byte array. 
            buf = inp.getBytes(); 
            buf2 = inp2.getBytes(); 
            buf3 = inp3.getBytes(); 
  
            // Step 2 : Create the datagramPacket for sending 
            // the data. 
            DatagramPacket DpSend = 
                  new DatagramPacket(buf, buf.length, ip, 4321); 
            
            DatagramPacket DpSend2 = 
                  new DatagramPacket(buf2, buf2.length, ip, 4321); 
            
            DatagramPacket DpSend3 = 
                  new DatagramPacket(buf3, buf3.length, ip, 4321); 
  
            // Step 3 : invoke the send call to actually send 
            // the data. 
            ds.send(DpSend); 
            ds.send(DpSend2);
            ds.send(DpSend3);
  
            // break the loop if user enters "bye" 
            if (inp.equals("bye")) 
                break; 
        } 
    } 
}