import java.io.Serializable;

/**
 * <p>Title: TestStudent</p>
 * <p>Description:
 * 描述：
 * </p>
 *
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-04-09 14:13
 */
public class TestStudent implements Serializable {
    /**
     * serialVersionUID
     * 反序列化时,会根据serialVersionUID这个常量值来判断反序列得到的类信息是否与原来一致
     * 如果我们不指定serialVersionUID值,序列化将会把当前类的hashCode值赋给它
     *
     */

    private int no;
    private String name;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestStudent(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public TestStudent() {
    }

    @Override
    public String toString() {
        return "TestStudent{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
