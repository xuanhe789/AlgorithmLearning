import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {
        Double a=171.43;
        Double b=242.56;
        BigDecimal bigDecimal = new BigDecimal(Double.toString(a));
        BigDecimal bigDecimal1 = new BigDecimal(Double.toString(b));
        double v = bigDecimal.add(bigDecimal1).setScale(5,BigDecimal.ROUND_DOWN).doubleValue();
         bigDecimal=bigDecimal.add(bigDecimal1).setScale(5,BigDecimal.ROUND_DOWN);
        System.out.println(a+b);
//
    }

}
