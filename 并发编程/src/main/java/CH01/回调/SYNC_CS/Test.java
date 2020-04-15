package CH01.回调.SYNC_CS;

/**
 * <p>Title: test</p>
 * <p>Company:浩鲸云计算科技股份有限公司 </p>
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

        System.out.println("1. 客户端发起请求 ");
        System.out.println();
        client.request("仿真运行请求");
    }
}
