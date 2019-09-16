package cn.com.Inet2;

import org.omg.CORBA.DataInputStream;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    //流程
    // 创建服务器
    // 指定端口 使用ServerSocket创建服务器
    //阻塞式等待连接 accept
    //操作 输入输出流操作
    //释放资源
    public static void main(String[] args) throws IOException {
        System.out.println("----Server-----");
        // 指定端口 使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        //阻塞式等待连接 accept
        Socket client = server.accept();
        System.out.println("一个客户端建立了连接");
        //操作 输入输出流操作
//        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
//        String data = reader.readLine();

        java.io.DataInputStream dis = new java.io.DataInputStream(client.getInputStream());
        String data = dis.readUTF();
        System.out.println(data);
        //释放资源
        dis.close();
        client.close();
        server.close();
    }
}
