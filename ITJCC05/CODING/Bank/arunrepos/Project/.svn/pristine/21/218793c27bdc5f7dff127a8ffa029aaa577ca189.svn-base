
package testcodes;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class Inetadrs {
    public static void main(String[] args) {
        try
        {
        InetAddress ipad =InetAddress.getLocalHost();
            System.out.println("ip address is "+ipad.getHostAddress());
            InetSocketAddress ip=new InetSocketAddress(ipad, 100);
            System.out.println("ip is "+ip);
        }catch(UnknownHostException unkn)
        {
            unkn.printStackTrace();

        }
    }

}
