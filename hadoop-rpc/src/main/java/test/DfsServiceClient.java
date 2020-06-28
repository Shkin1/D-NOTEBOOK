package test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import proto.DfsService;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/6/28 22:42
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */

public class DfsServiceClient {
    public static void main(String[] args) throws IOException {

        /**
         * DfsService:服务端接口类
         * InetSocketAddress：服务端地址
         * Configuration：
         */
        DfsService proxy = RPC.getProxy(DfsService.class, 123L, new InetSocketAddress("localhost", 7788), new Configuration());
        String result = proxy.mkDir("/hive/xxx");
        System.out.println(result);

    }
}
