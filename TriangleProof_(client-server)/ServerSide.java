import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 



public class ServerSide {

    public static void main(String[] args) throws IOException 
    {
        DatagramSocket ds = new DatagramSocket(4321);
        byte[] receive = new byte[65535];
        byte[] receive2 = new byte[65535];
        byte[] receive3 = new byte[65535];
        
        DatagramPacket DpReceive = null;
         DatagramPacket DpReceive2 = null;
          DatagramPacket DpReceive3 = null;
        
      
        
        while(true)
        {
            DpReceive = new DatagramPacket(receive, receive.length);
            DpReceive2 = new DatagramPacket(receive2, receive2.length);
            DpReceive3 = new DatagramPacket(receive3, receive3.length);
            
            ds.receive(DpReceive); 
            ds.receive(DpReceive2); 
            ds.receive(DpReceive3); 
            
            
            String edgeString = new String(DpReceive.getData(),0,DpReceive.getLength());
            String edgeString2 = new String(DpReceive2.getData(),0,DpReceive2.getLength());
            String edgeString3 = new String(DpReceive3.getData(),0,DpReceive3.getLength());
            
            int edgeInt = Integer.parseInt(edgeString);
            int edgeInt2 = Integer.parseInt(edgeString2);
            int edgeInt3 = Integer.parseInt(edgeString3);
            
            if (edgeInt + edgeInt2 <= edgeInt3 || edgeInt + edgeInt3 <= edgeInt2 || edgeInt2 + edgeInt3 <= edgeInt)
            {
                System.out.println("not a triangle");
            }
            else
                System.out.println("triangle");
            
            
            
            if (data(receive).toString().equals("bye")) 
            { 
                System.out.println("Client sent bye.....EXITING"); 
                break; 
            }
            
            receive = new byte[65535];
            
            
        }
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
