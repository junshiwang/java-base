package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient1
{
    public static void main(String[] args)
    {
        Socket socket=null;
        PrintWriter out=null;
        BufferedReader in=null;
        String serverIP="127.0.0.1";    //服务器端ip地址
        int port=5000;    //服务器端端口号
        try
        {
            socket=new Socket(serverIP,port);
//            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(socket.getOutputStream(),true);
            while(true)
            {
                int number=(int)(Math.random()*10)+1;
                System.out.println("客户端正在发送的内容为："+number);
                out.println(number);
                Thread.sleep(2000);
            }
        }
        catch(InterruptedException | IOException e)
        {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }
}