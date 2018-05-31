package jayhou.work;

import java.util.Date;

public class Log {
    public static void d(String tag, String message) {
//        Date data = new Date("yyyy-MM-dd");
        System.out.println(tag + "  " + message);
    }
}
