package CH01.回调.ASYNC_CS;

/**
 * <p>Title: Test</p>
 * <p>Description:
 * 描述：
 * </p>
 *
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-04-15 08:14
 */
public class Test {
    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client(server);

        // 主线程异步发送3个请求
        client.request("仿真运行请求1");
        client.request("仿真运行请求2");
        client.request("仿真运行请求3");
    }
}
