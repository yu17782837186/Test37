package cn.com.inet;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UdpTalkClient {
    public static void main(String[] args) throws IOException {
        System.out.println("发送方启动中。。。");
        DatagramSocket client = new DatagramSocket(8888);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String data = reader.readLine();
            byte[] datas = data.getBytes();
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 6666));
            client.send(packet);
            if (data.equals("exit")) {
                break;
            }
        }
        client.close();
    }
}
