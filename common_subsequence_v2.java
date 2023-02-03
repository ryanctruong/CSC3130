import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class common_subsequence_v2{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Text1: ");
        String t1 = scan.next();

        System.out.print("Text2: ");
        String t2 = scan.next();

        String cs = common_string(t1, t2);
        System.out.println(cs);
    }

    public static String common_string(String text1, String text2) {
        // score: keeps the score, a/b_counter: index location for each string
        // last_spot: goes back to the last original spot //word: storing the word into a list
        int score = 0, a_counter = 0, b_counter = 0, last_spot = 0; String word = "";

        List<Character> a_list = new ArrayList<>(); //text 1
        List<Character> b_list = new ArrayList<>(); //text 2
        List<Character> c_list = new ArrayList<>(); // storing common subsequences(cs)
        List<String> cs_list = new ArrayList<>(); // creating strings for the chars founded
        List<Integer> score_list = new ArrayList<>(); // keeping score for each iteration

        // each letter is appended to a list
        for (char a : text1.toCharArray()) { a_list.add(a); }
        for (char b : text2.toCharArray()) { b_list.add(b); }

        // we want text1 to be the smaller size, so we perform a swap with
        if (a_list.size() > b_list.size()) {
            List<Character> temp = new ArrayList<>(a_list);
            a_list.clear();
            a_list.addAll(b_list);
            b_list.clear();
            b_list.addAll(temp);
        }

        while (true) {
            // checks if we are at the end of text2, and if text1 still has letters
            if (b_counter == b_list.size() && a_counter != a_list.size()) {
                a_counter++;
                b_counter = last_spot + 1;
            }
            // if text1 has no more letters that need to be searched, return results
            else if (a_list.size() == 0) {
                int value = score_list.get(0);
                for (Integer integer : score_list) {
                    if (integer > value) {
                        value = integer;
                    }
                }
                int length = 0;           
                String longestString = " ";
                for (String s : cs_list) {
                    if (s.length() > length) {
                        length = s.length();
                        longestString = s;
                    }
                }

                System.out.println(cs_list);
                System.out.println(score_list);
                if (value == 0) {
                    return "There is no such common subsequence, so the result is " + value + "!";
                } else {
                    return "The longest common subsequence is '" + longestString +
                            "' and its length is " + value + "!";
                }
                // if we have gone through text1, remove the first element, store the score, and iterate again
            } else if (a_counter == a_list.size()) {
                a_list.remove(0);
                score_list.add(score);

                for (char ch : c_list) {
                    word = word + ch;
                }
                cs_list.add(word);

                a_counter = 0; b_counter = 0; score = 0;
                word = ""; c_list.clear();
                // if we have found a common letter, add it to a list, then move to the next letter
            } else if (a_list.get(a_counter) == b_list.get(b_counter)) {
                c_list.add(b_list.get(b_counter));
                last_spot = b_counter;
                a_counter++; b_counter++; score++;
                // if no letters are found, continue to the next letter
            } else {
                b_counter++;
            }
        }
    }
}



