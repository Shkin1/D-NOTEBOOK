package CH01.回调.ASYNC_CS;


/**
 * <p>Title: Server</p>
 *
 * <p>Description:
 * 描述：
 * </p>
 *
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-04-15 08:14
 */
public class Server {
    public void requestHandler (CallBack callBack, String request) {
        System.out.println("2. 服务端: 服务端接收到客户端请求消息:" + request);
        System.out.println();

        // 模拟数据处理
        System.out.println("3. 服务端处理逻辑ing...."+" 当前线程:"+Thread.currentThread().getName());
        System.out.println();

        // 模拟服务端处理
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("4. 服务端: 数据处理成功, 状态码 200, 返回结果");
        System.out.println();

        callBack.call("状态码 200, 响应结果内容*****");
    }
}
