import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;



public class ServerSide {
    
    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

   public static void main(String[] args) throws IOException {
       
       DatagramSocket ds = new DatagramSocket(1234);
       byte[] receive = new byte[65535];
       byte[] receive2 = new byte[65535];
       
       DatagramPacket DpReceive = null;
       DatagramPacket DpReceive2 = null;
       
       while(true)
       {
           DpReceive = new DatagramPacket(receive, receive.length);
           DpReceive2 = new DatagramPacket(receive2, receive2.length);
           ds.receive(DpReceive);
           ds.receive(DpReceive2);
           
           System.out.println("client message: " + data(receive));
           System.out.println("key: " + data(receive2));
           
           String edgeString = new String(DpReceive.getData(),0,DpReceive.getLength());
           String edgeString2 = new String(DpReceive2.getData(),0,DpReceive2.getLength());
           int key = Integer.parseInt(edgeString2);  

           String encrypted = encrypt(edgeString, key);
           System.out.println("\nEncrypted String is: " + encrypted);
           String decrypted = decrypt(encrypted, key);
           System.out.println("\nDecrypted String is: "
           + decrypted);
           System.out.println("\n");
        
           receive = new byte[65535];
       }
       
       
    }
   
    public static String encrypt(String str, int key) {
        String encrypted = "";
        for (int i = 0; i < str.length(); i++) {
        int c = str.charAt(i);
        if (Character.isUpperCase(c)) {
        c = c + (key % 26);
            if (c > 'Z') {
            c = c - 26;
            }
        } 
        else if (Character.isLowerCase(c)) {
            c = c + (key % 26);
                if (c > 'z') {
                c = c - 26;
                }
        }
        
        encrypted += (char) c;
    }
        
    return encrypted;
    
    }
    
    public static String decrypt(String str, int key) {
        String decrypted = "";
        for (int i = 0; i < str.length(); i++) {
        int c = str.charAt(i);
            if (Character.isUpperCase(c)) {
            c = c - (key % 26);
                if (c < 'A') {
                c = c + 26;
                }
            } 
            else if (Character.isLowerCase(c)) {
                c = c - (key % 26);
                    if (c < 'a') {
                    c = c + 26;
                    }
            }
            
            decrypted += (char) c;
            
            }
       
            return decrypted;
    }
    
    public static StringBuilder data(byte[] a)
    {
        if (a == null)
        return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0)
        {
        ret.append((char) a[i]);
        i++;
        }
        return ret;
    }

}
