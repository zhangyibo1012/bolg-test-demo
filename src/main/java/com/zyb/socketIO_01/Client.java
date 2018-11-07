package com.zyb.socketIO_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Title: Client.java
 * @Package com.zyb.socketIO_01
 * @Description: TODO
 * @Author ZhangYB
 * @Version V1.0
 */
public class Client {

    final static String ADDRESS = "127.0.0.1";
    final static int PORT = 8765;

    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            // 建立连接
            socket = new Socket(ADDRESS , PORT);
            // 写入数据
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 写出数据 是否自动刷新
            out = new PrintWriter(socket.getOutputStream() , true);

            // 向服务器端发送数据
            out.println("接收到客户端的请求数据。。。");
             String response = in.readLine();
            System.out.println("Client:" + response );

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 关闭连接
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null){
                try {
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            }
    }
}
