import java.net.*;
public class InetAddressDemo {
    public static void main(String para[]) throws UnknownHostException {
        // 获取本机地址信息
        InetAddress address1= InetAddress.getLocalHost();
        System.out.println("address1.getCanonicalHostName()= "     + address1.getCanonicalHostName());
        System.out.println("address1.getHostAddress()= " + address1.getHostAddress());
        System.out.println("address1.getHostName()= " + address1.getHostName());
        System.out.println("address1.toString()= " + address1.toString());
        System.out.println("====================================");
        // 获取指定域名地址信息
        InetAddress address2 = InetAddress.getByName("www.baidu.com");
        System.out.println("address2.getCanonicalHostName()= "     + address2.getCanonicalHostName());
        System.out.println("address2.getHostAddress()= " + address2.getHostAddress());
        System.out.println("address2.getHostName()= " + address2.getHostName());
        System.out.println("address2.toString()= " + address2.toString());
        System.out.println("====================================");
        // 比较两 InetAddress
        InetAddress address3 = InetAddress.getByAddress(address2.getAddress());
        System.out.println("address3.getCanonicalHostName()= "     + address3.getCanonicalHostName());
        System.out.println("address3.getHostAddress()= " + address3.getHostAddress());
        System.out.println("address3.getHostName()= " + address3.getHostName());
        if (address3.equals(address2))
            System.out.println("address3 equals address2");
        else
            System.out.println("address3 not equals address2");
    }
}