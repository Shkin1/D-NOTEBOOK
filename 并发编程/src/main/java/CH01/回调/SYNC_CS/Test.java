package CH01.回调.SYNC_CS;

/**
 * <p>Title: test</p>
 *
 * <p>Description:
 * 描述：
 * </p>
 *
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-04-15 07:55
 */
public class Test {

    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client(server);

        // one-by-one式请求, 服务器方同步式处理响应
        client.request("仿真运行请求1");
        System.out.println("--------------over-----------------");
        client.request("仿真运行请求2");
        System.out.println("--------------over-----------------");
        client.request("仿真运行请求3");
        System.out.println("--------------over-----------------");
    }
}
