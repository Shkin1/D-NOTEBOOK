package test;

/**
 * <p>Title: B</p>
 *
 * <p>Description:
 * 描述：
 * </p>
 *
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-04-13 22:43
 */
public class B {

    public void executeMessage(CallBack callBack, String quession) {
        System.out.println(
                callBack.getClass()+"问的问题-->"+quession
        );

        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        callBack.solve("我大B的回答是2~~~");
    }
}
