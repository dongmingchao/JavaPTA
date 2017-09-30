package three;

import java.time.LocalDateTime;

public class Datetest {
    public static void main(String[] args) {
        if (isMondayToFriday())
        System.out.println("工作日+董明超201621123029");
        else System.out.println("休息+董明超201621123029");
    }
    public static boolean isMondayToFriday(){
        LocalDateTime dateTime = LocalDateTime.now();
        int d=dateTime.getDayOfWeek().getValue();
        if (d>0&&d<6) return true;
        else return false;
    }
}
