/**
 * @author Ryan Benasutti
 * @since 2017-04-30
 */
public class Main {
    public static void main(String[] args) {
        Acceptor acceptor = new Acceptor(2);
        acceptor.accept(() -> {
            try {
                LazyCapture lazyCapture = new LazyCapture("testMember");
                System.out.println(lazyCapture.getValue());
            } catch (NoSuchFieldException e) {
                System.out.println("no such field");
            } catch (IllegalAccessException e) {
                System.out.println("illegal access");
            } catch (ClassNotFoundException e) {
                System.out.println("class not found");
            }
        });
    }
}
