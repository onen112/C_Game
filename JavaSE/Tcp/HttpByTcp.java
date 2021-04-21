import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 简易版http服务器
 *      当本地浏览器访问9003端口时会根据url的内容在页面显示不同内容
 *      在返回信息中只要完全满足http响应信息的基本格式即可
 * 
 */
public class HttpByTcp {
    private static final int port = 9003;
    public static void main(String[] args) throws IOException {
        // 创建tcp的服务器
        ServerSocket socketS  = new ServerSocket(port);
        System.out.println("服务器启动成功！");
        // 等待客户端连接
        Socket socket = socketS.accept();
        System.out.println("有客户端连接：ip = " +  socket.getInetAddress().getHostAddress() + ",端口："+socket.getPort() );
        //使用try resource方式省去close部分工作

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())
            );) {
            //获取请求信息（第一行 请求头信息）
            String msg = br.readLine();

            System.out.println(msg);

            //请求头中的url部分
            String url = msg.split(" ")[1];
            //设置返回信息
            String res = "<h1>其他页面</h1>";
            if(url .equals("/404")){
                res = "<h1>未找到页面！</h1>";
            }else if(url.equals("/200") ){
                res = "<h1>你好呀 web</h1>";
            }

            //写响应信息
            //响应头
            bw.write( msg.split(" ")[2] + " 200 ok \n");
            //响应行
            bw.write("Content-Type: text/html;charset=utf-8;Content-Length: " + res.getBytes().length + ";\n");
            //响应空行
            bw.write("\n");
            //响应体部分
            bw.write(res);

            //刷新
            bw.flush();
        }
    }
}