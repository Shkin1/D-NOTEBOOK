package CH01.回调.SYNC_CS;

/**
 * <p>Title: Client</p>
 * <p>Company:浩鲸云计算科技股份有限公司 </p>
 * <p>Description:
 * 描述：同步式回调
 * </p>
 *
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-04-15 07:46
 */
public class Client implements CallBack {

    private Server server;

    public Client(Server server) {
        this.server = server;
    }

    public void request(final String requestHead){
        server.requestHandler(Client.this, requestHead);
    }


    @Override
    public void call(String response) {
        System.out.println("5. 客户端: 接受到服务端响应的消息" + response);
    }



}
