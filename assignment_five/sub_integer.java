import java.util.*;
public class sub_integer {

    public static void main(String[] args){
        sub_integer si = new sub_integer();
        int[] s = {0, 67};
        int[] t = {100, 5, 66, 2, 32, 90};
        boolean c = si.sub_int(s, t);
        System.out.println(c);
    }

    public boolean sub_int(int[] s, int[] t){
        HashSet<Integer> hs = new HashSet<>();
        int count = 0;
        if(s.length > t.length){
            return false;
        }

        for (int j : s) {
            hs.add(j);
        }

        for (int j : t) {
            if (hs.contains(j)) {
                count++;
            }
        }

        return count == s.length;
    }
}
