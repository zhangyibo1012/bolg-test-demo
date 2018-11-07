package com.zyb.socketIO_01;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Title: Server.java
 * @Package com.zyb.socketIO_01
 * @Description: TODO 服务器端
 * @Author ZhangYB
 * @Version V1.0
 */
@Slf4j
public class Server {

    final static int PORT = 8765;

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(PORT);
            log.info("server start..." );

            // 进行阻塞 客户端通过指定ip端口发送一个套接字 建立一个socket连接  就会返回一个真正的socket对象
            final Socket socket = server.accept();

            // 新建一个线程执行客户端的任务
            // 每连接一次就创建了一个线程  效率低
            new Thread(new ServerHandler(socket)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 关闭连接
            if (server != null){
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            server = null;
        }

    }

}
