package socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
public class SocketServer
{
    public static void main(String[] args)
    {
        ServerSocket serverSocket=null;
        Socket clientSocket=null;
        BufferedReader in=null;
        int port=5000;
        String str=null;
        try
        {
            serverSocket=new ServerSocket(port, 1);    //创建服务器套接字
            System.out.println("服务器开启，等待连接。。。");
            while (true) {
                clientSocket=serverSocket.accept();// 获得链接
                //接收客户端发送的内容
                in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                str=in.readLine();
                System.out.println("客户端发送的内容为："+str);

            }
        }
        catch(IOException e)
        {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }
}