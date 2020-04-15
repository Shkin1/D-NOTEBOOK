package CH01.回调.ASYNC_CS;

/**
 * <p>Title: Client</p>
 *
 * <p>Description:
 * 描述：异步回调
 * </p>
 *
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-04-15 08:14
 */
public class Client implements CallBack {

    private Server server;

    public Client(Server server) {
        this.server = server;
    }

    public void request(final String requestHead){
        System.out.println("1. 客户端发起请求(异步方式): "+requestHead);
        System.out.println();
        new Thread(() -> server.requestHandler(Client.this, requestHead
                +" 当前线程: "+Thread.currentThread().getName())).start();
    }


    @Override
    public void call(String response) {
        System.out.println("5. 客户端: 接受到服务端响应的消息" + response+" 当前线程: "+Thread.currentThread().getName());
    }



}
