package test;

/**
 * <p>Title: TestAB</p>
 * <p>Company:浩鲸云计算科技股份有限公司 </p>
 * <p>Description:
 * 描述：
 * </p>
 *
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-04-13 22:51
 */
public class TestAB {
    public static void main(String[] args) {
        B b = new B();
        A a = new A(b);
        a.ask("1+1=?");
    }
}
