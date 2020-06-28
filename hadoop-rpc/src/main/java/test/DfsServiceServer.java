package test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import proto.DfsService;
import proto.DfsServiceImpl;

import java.io.IOException;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/6/28 22:39
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */

public class DfsServiceServer {
    public static void main(String[] args) throws IOException {
        DfsServiceImpl dfsService = new DfsServiceImpl();

        // 创建一个RPC builder
        RPC.Builder builder = new RPC.Builder(new Configuration());
        //指定RPC Server的参数
        builder.setBindAddress("localhost");
        builder.setPort(7788);

        //将自己的程序部署到server上
        builder.setProtocol(DfsService.class);
        builder.setInstance(dfsService);

        //创建Server
        RPC.Server server = builder.build();

        //启动服务
        server.start();
        System.out.println("server is start");



    }
}
