package crackingleetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the
 * minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.
 *
 * @author 58212
 * @date 2020-01-09 2:18
 */
public class BinaryWatch_401 {

    String[] clock = new String[]{"1", "2", "4", "8", "#32", "#16", "#8", "#4", "#2", "#1"};
    List<String> res = new ArrayList<>();

    public List<String> readBinaryWatch(int num) {
        List<String> lst = new ArrayList<>();
        read(0, clock, num, lst);
        return res;
    }

    private void read(int start, String[] clock, int num, List<String> lst) {
        if (num == 0) {
            String[] time = timeAssamble(lst);
            if ("false".equals(time[1])) {
                return;
            }
            res.add(time[0]);
            return;
        }
        for (int i = start; i < clock.length; i++) {
            lst.add(clock[i]);
            read(i + 1, clock, num - 1, lst);
            lst.remove(lst.size() - 1);
        }
    }

    private String[] timeAssamble(List<String> lst) {
        String[] res = new String[2];
        int hours = 0;
        int minutes = 0;
        for (String item : lst) {
            if (item.contains("#")) {
                minutes = minutes + Integer.parseInt(item.split("#")[1]);
            } else {
                hours = hours + Integer.parseInt(item);
            }
        }
        if (hours > 11 || minutes > 59) {
            res[1] = "false";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(hours);
        sb.append(":");
        if (minutes < 10) {
            sb.append("0");
        }
        sb.append(minutes);
        res[0] = sb.toString();
        return res;
    }

}
