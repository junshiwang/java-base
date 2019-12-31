package io;

import java.io.*;
import java.net.URL;

public class TestIO {
    public  void FileInputStreamTest() throws IOException {
        java.net.URL uri = Thread.currentThread().getClass().getResource("/");
        System.out.println("uri:"+ uri);
        InputStream fis = this.getClass().getResourceAsStream("/tmp2.txt");
        //FileInputStream fis = (FileInputStream) Thread.currentThread().getClass().getResourceAsStream("tmp2.txt");
        byte[] buf = new byte[1024];
        int hasRead = 0;
        
        //read()返回的是单个字节数据（字节数据可以直接专程int类型)，但是read(buf)返回的是读取到的字节数，真正的数据保存在buf中
        while ((hasRead = fis.read(buf)) > 0) {
            //每次最多将1024个字节转换成字符串，这里tmp2.txt中的字符小于1024，所以一次就读完了
            //循环次数 = 文件字符数 除以 buf长度
            System.out.println(new String(buf, 0 ,hasRead));
            /*
             * 将字节强制转换成字符后逐个输出，能实现和上面一样的效果。但是如果源文件是中文的话可能会乱码
             
            for (byte b : buf)    {
                char ch = (char)b;
                if (ch != '\r')
                System.out.print(ch);
            }
            */
        }
        //在finally块里close更安全
        fis.close();
    }
    
    public void FileReaderTest() throws IOException {
        // 在try() 中打开的文件， JVM会自动关闭
        URL uri = this.getClass().getResource("/");
        FileReader fr = new FileReader(uri.getPath() + "tmp2.txt");
        char[] buf = new char[32];
        int hasRead = 0;
        // 每个char都占两个字节，每个字符或者汉字都是占2个字节，因此无论buf长度为多少，总是能读取中文字符长度的整数倍,不会乱码
        while ((hasRead = fr.read(buf)) > 0) {
            // 如果buf的长度大于文件每行的长度，就可以完整输出每行，否则会断行。
            // 循环次数 = 文件字符数 除以 buf长度
            System.out.println(new String(buf, 0, hasRead));
            // 跟上面效果一样
            // System.out.println(buf);
        }
    }
    
    public void FileOutputStreamTest() throws IOException {
        //在try()中打开文件会在结尾自动关闭
        URL uri = this.getClass().getResource("/");
        FileInputStream fis = new FileInputStream(uri.getPath() + "tmp2.txt");
        FileOutputStream fos = new FileOutputStream(uri.getPath()  + "tmp3.txt");
        byte[] buf = new byte[4];
        int hasRead = 0;
        while ((hasRead = fis.read(buf)) > 0) {
            //每读取一次就写一次，读多少就写多少
            fos.write(buf, 0, hasRead);
        }
//        fis.close();
//        fos.close();
        System.out.println("write success");
    }
    
    public void FileWriterTest() throws IOException {
        URL uri = this.getClass().getResource("/");
        try (FileWriter fw = new FileWriter(uri.getPath() + "tmp4.txt")) {
            fw.write("天王盖地虎\r\n");
            fw.write("宝塔镇河妖\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        TestIO testIO = new TestIO();
        //testIO.FileInputStreamTest();
        //testIO.FileReaderTest();
        //testIO.FileOutputStreamTest();
        testIO.FileWriterTest();
    }
}