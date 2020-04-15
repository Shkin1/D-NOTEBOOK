package CH01.回调.ASYNC_CS;

/**
 * <p>Title: CallBack</p>
 *
 * <p>Description:
 * 描述：回调模式, 回调接口类
 * </p>
 *
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-04-15 07:43
 */
public interface CallBack {

    /**
     * 服务器端回调客户端方法 --> 响应请求结果
     * @param response
     * @return
     */
    void call(String response);
}
