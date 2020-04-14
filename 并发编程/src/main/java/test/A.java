package test;

/**
 * <p>Title: A</p>
 * <p>Company:浩鲸云计算科技股份有限公司 </p>
 * <p>Description:
 * 描述：
 * </p>
 *
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-04-13 22:42
 */
public class A implements CallBack {

    private B b;

    public A(B b) {
        this.b = b;
    }

    public void ask( final String quession){
        System.out.println("A 问B一个问题");
        new Thread(()->{
            //B想要帮A处理东西，就必须知道谁让自己处理的，所以要传入a，也要知道a想处理什么，所以要传入question
            b.executeMessage(A.this, quession);
        }).start();
        play();
    }

    public void play(){
        System.out.println("A:我要逛街去了");
    }


    // A 拿到B处理完成的结果, 可以进行一些操作, 比如把结果输出
    @Override
    public void solve(String result) {
        System.out.println("A拿到B的答案: "+result);
    }
}
