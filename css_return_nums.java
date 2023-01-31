import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class css_return_nums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Text1: ");
        String text1 = scan.next();

        System.out.print("Text2: ");
        String text2 = scan.next();

        int a = common_string(text1, text2);
        System.out.println(a);
    }
    public static int common_string(String text1, String text2) {
        int score = 0, a_counter = 0, b_counter = 0, last_spot = 0;

        List<Character> a_list = new ArrayList<>();
        List<Character> b_list = new ArrayList<>();
        List<Integer> score_list = new ArrayList<>();

        for (char a : text1.toCharArray()) {a_list.add(a);}
        for (char b : text2.toCharArray()) {b_list.add(b);}

        if (a_list.size() > b_list.size()) {
            List<Character> temp = new ArrayList<>(a_list);
            a_list.clear();
            a_list.addAll(b_list);
            b_list.clear();
            b_list.addAll(temp);
        }

        while (true) {
            if (b_counter == b_list.size() && a_counter != a_list.size()) {
                a_counter++;
                b_counter = last_spot + 1;
            }
            else if (a_list.size() == 0) {
                int value = score_list.get(0);
                for (Integer integer : score_list) {
                    if (integer > value) {
                        value = integer;
                    }
                }
                return value;
            } 
            else if (a_counter == a_list.size()) {
                a_list.remove(0);
                score_list.add(score);

                a_counter = 0; b_counter = 0; score = 0;
            } 
            else if (a_list.get(a_counter) == b_list.get(b_counter)) {
                last_spot = b_counter;
                a_counter++; b_counter++; score++;
            } 
            else {
                b_counter++;
            }
        }
    }
}
