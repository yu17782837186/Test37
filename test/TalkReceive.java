package cn.com.inet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable {
//    private DatagramSocket server;
//    private String from;
//    public TalkReceive(int port,String from) {
//        this.from = from;
//        try {
//            this.server = new DatagramSocket(port);
//        } catch (SocketException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void run() {
//        while(true) {
//            byte[] container = new byte[1024*60];
//            DatagramPacket packet = new DatagramPacket(container,0,container.length);
//            try {
//                server.receive(packet);
//                byte[] data = packet.getData();
//                int len = packet.getLength();
//                String datas = new String(data,0,len);
//                System.out.println(from+":"+datas);
//                if (datas.equals("exit")) {
//                    break;
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        server.close();
//    }
    private DatagramSocket server;
    private String from;
    public TalkReceive(int port,String from) {
        this.from = from;
        try {
            this.server = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true) {
            byte[] container = new byte[1024*60];
            DatagramPacket packet = new DatagramPacket(container,0,container.length);
            try {
                server.receive(packet);
                byte[] data = packet.getData();
                int len = packet.getLength();
                String str = new String(data,0,len);
                System.out.println(from+":"+str);
                if (str.equals("exit")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        server.close();
    }
}
