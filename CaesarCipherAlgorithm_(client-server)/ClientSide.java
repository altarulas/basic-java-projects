import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;


public class ClientSide2 
{ 
    
     static Scanner sc = new Scanner(System.in);
     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    
    public static void main(String args[]) throws IOException 
    { 
        Scanner sc = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket();
        DatagramSocket ds2 = new DatagramSocket();
        
        InetAddress ip = InetAddress.getLocalHost();
        byte buf[] = null;
        byte buf2[] = null;
        
        while(true)
        {
            System.out.print("Enter any String: ");
            String inp = br.readLine();
            
            System.out.print("\nEnter the Key: ");
            int key = sc.nextInt();
            String keyString = Integer.toString(key);
            
            buf = inp.getBytes();
            buf2 = keyString.getBytes();
            
            DatagramPacket DpSend1 =
            new DatagramPacket(buf, buf.length, ip, 1234);
            
            DatagramPacket DpSend2 =
            new DatagramPacket(buf2, buf2.length, ip, 1234);
            
            ds.send(DpSend1);
            ds2.send(DpSend2);
        }
        
    } 
    
    
   
}