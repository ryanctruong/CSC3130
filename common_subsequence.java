import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class common_subsequence {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Text1: ");
            String text1 = scan.next();

            System.out.print("Text2: ");
            String text2 = scan.next();

            int a = common_string(text1, text2);
            System.out.println(a);
        }
    }
    public static int common_string(String text1, String text2){
        int counter = 0; int a_counter = 0; int b_counter = 0;

        List<Character> a_list = new ArrayList<>();
        List<Character> b_list = new ArrayList<>();

        for (char c: text1.toCharArray()) { a_list.add(c);}
        for (char c : text2.toCharArray()) { b_list.add(c);}

        while(true){
            if (b_counter == b_list.size() && b_counter != 0) {
                a_counter++;
                b_counter = 0;
            }
            else if (a_counter == a_list.size() || b_list.size() == 0){
                return counter;
            }

            else if(a_list.get(a_counter) == b_list.get(b_counter)){
                b_list.subList(0, b_counter+1).clear();
                b_counter = 0;
                counter++;
                a_counter++;
            }

            else{
                b_counter++;
            }
        }
    }
}
