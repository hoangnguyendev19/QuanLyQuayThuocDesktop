package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateID {
    private static String lastDate = "";
    private static int counter;
    public static String dateFormat() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyy");
        String datePart = dateFormat.format(new Date());
        return datePart;
    }
    public static String sinhMa(String ten) {
       Date datenow = new Date();
       SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyHHmmss");
       String formattedDate = dateFormat.format(datenow);
       String maPhatSinh = formattedDate;
       return ten + maPhatSinh;
    }
}
