package cn.com.inet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TalkSend implements Runnable {
//    private DatagramSocket client;
//    private BufferedReader reader;
//    private String toIP;
//    private int toPort;
//    private int port;
//    public TalkSend(int port,String toIP,int toPort) {
//        this.toIP = toIP;
//        this.toPort = toPort;
//        this.port = port;
//        try {
//            this.client = new DatagramSocket(port);
//
//        } catch (SocketException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void run() {
//        reader = new BufferedReader(new InputStreamReader(System.in));
//       while(true) {
//           String data;
//           try {
//               data = reader.readLine();
//               byte[] datas = data.getBytes();
//               DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress(this.toIP,this.toPort));
//               client.send(packet);
//               if (data.equals("exit"))
//                   break;
//           } catch (IOException e) {
//               e.printStackTrace();
//           }
//       }
//       client.close();
//    }
    private DatagramSocket client;
    private BufferedReader reader;
    private String toIP;
    private int toPort;
    public TalkSend(int port,String toIP,int toPort) {
        this.toIP = toIP;
        this.toPort= toPort;
        try {
            this.client = new DatagramSocket(port);
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true) {
            String data = null;
            try {
                data = reader.readLine();
                byte[] datas = data.getBytes();
                DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress(toIP,toPort));
                client.send(packet);
                if (data.equals("exit")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        client.close();
    }
}
