import  java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        List<Integer> arr = new ArrayList<>() {{
            add(1);
            add(2);
            add(5);
            add(7);
            add(9);
        }};

        long min = arr.get(0);
        long max = min;
        long sum = min;

        for (int i = 1; i < arr.size(); i++) {
            sum += arr.get(i);
            if (arr.get(i) < min) {
                min = arr.get(i);
            }

            if (arr.get(i) > max) {
                max = arr.get(i);
            }
        }

        System.out.print((sum - max) + " " + (sum - min));
    }

}