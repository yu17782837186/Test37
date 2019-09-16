package cn.com.Inet2;

import java.io.*;
import java.net.Socket;

public class Client {
    //创建客户端
    //建立连接 使用Socket创建客户端 +服务的地址和端口
    // 操作 输入输出流操作
    //释放资源
    public static void main(String[] args) throws IOException {
        System.out.println("----Client-----");
        //建立连接 使用Socket创建客户端 +服务的地址和端口
        Socket client = new Socket("localhost",8888);
        // 操作 输入输出流操作
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("hello");
//        String data = "hello";
//        writer.write(data);
//        writer.flush();
        //释放资源
        dos.close();
        client.close();
    }
}
