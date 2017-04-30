/**
 * @author Ryan Benasutti
 * @since 2017-04-30
 */
public class Acceptor {
    private int num;
    private int testMember;

    public Acceptor(int num) {
        this.num = num;
        testMember = 1;
    }

    public void accept(Runnable runnable) {
        runnable.run();
    }

    public int getNum() {
        return num;
    }
}
