import java.lang.reflect.Field;

/**
 * @author Ryan Benasutti
 * @since 2017-04-30
 */
public class LazyCapture {
    private String memberName;
    private Class<?> classRef;
    private Field field;

    public LazyCapture(String memberName) {
        this.memberName = memberName;
    }

    public Object getValue() throws IllegalAccessException, ClassNotFoundException, NoSuchFieldException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
//        System.out.println(Arrays.toString(stackTrace));
        for (int i = stackTrace.length - 1; i >= 0; i--) {
            StackTraceElement elem = stackTrace[i];
//            System.out.println("Looking at: " + elem.getClassName());
            if (elem.toString().contains("lambda")) {
                classRef = Class.forName(stackTrace[i + 1].getClassName());
//                System.out.println(classRef.getName());
                break;
            }
        }

        field = classRef.getDeclaredField(memberName);
        field.setAccessible(true);
        return field.get(classRef.getClass());
    }
}
