package CH01.回调.SYNC_CS;

/**
 * <p>Title: Client</p>
 *
 * <p>Description:
 * 描述：One-by-One式回调, 同步式发送请求
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
        System.out.println("1. 客户端发起请求: "+requestHead);
        System.out.println();
        server.requestHandler(Client.this, requestHead);
    }


    @Override
    public void call(String response) {
        System.out.println("5. 客户端: 接受到服务端响应的消息" + response);
    }



}
