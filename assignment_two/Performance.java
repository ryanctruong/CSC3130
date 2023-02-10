import java.io.FileWriter;
import java.io.IOException;

public class Performance {
    public static void main(String[] args){
        Tester t;

        sorting_algorithms[] sa = {new bubble_sort(), new insertion_sort(), new selection_sort(),
                new shell_sort(), new quick_sort(), new merge_sort()};

        String[] names = {"Bubble Sort", "Insertion Sort", "Selection Sort", "Shell Sort", "Quick Sort", "Merge Sort"};

        int[] s = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};

        try{
            FileWriter fw = new FileWriter("output.txt");

            for(int i = 0; i < sa.length; i++){
                t = new Tester(sa[i]);
                fw.write(names[i] + "\n");
                for(int size : s ){
                    fw.write("\tSorted " + size + " elements in " + t.test(20, size) + "\n");
                }
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
