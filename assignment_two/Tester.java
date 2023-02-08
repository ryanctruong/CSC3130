import java.text.DecimalFormat;
import java.util.Random;

public class tester {
    public sorting_algorithms sorting;
    public tester(sorting_algorithms sorting){
        this.sorting = sorting;
    }

    public double singleTest(int size){
        int[] c = new int[size];
        Random rand = new Random();

        for(int i = 0; i < size; i++){
            c[i] = rand.nextInt(100);
        }

        long start_time = System.nanoTime();
        sorting.sort(c);
        long end_time = System.nanoTime();

        return (end_time - start_time) / 1000000.0;
    }

    public void test(int iterations, int size){
        double time = 0;
        for(int i = 0; i < iterations; i++){
            time += singleTest(size);
        }

        double averageTime = time / iterations;
        DecimalFormat decimalFormat = new DecimalFormat("#.#####");

        double at = Double.parseDouble(decimalFormat.format(averageTime));

        System.out.println(at);
    }

//     public static void main(String[] args){
//         System.out.println("----SINGLE TEST RUN----");
//         single_print();
//         System.out.println("\n----MULTIPLE TEST RUN----");
//         multiple_print();
//     }

//     public static String single_test(sorting_algorithms x, int size){
//         tester t = new tester(x);
//         double time = t.singleTest(size);
//         return " " + time;
//     }

//     public static void multiple_test(sorting_algorithms x, int iterations, int size){
//         tester t = new tester(x);
//         t.test(iterations, size);
//     }

//     public static void single_print(){
//         int size = 100;
//         sorting_algorithms bs = new bubble_sort();
//         System.out.println("Bubble Sort:" + single_test(bs, size));

//         sorting_algorithms is = new insertion_sort();
//         System.out.println("Insertion Sort:" + single_test(is, size));

//         sorting_algorithms s = new selection_sort();
//         System.out.println("Selection Sort:" + single_test(s, size));

//         sorting_algorithms ss = new insertion_sort();
//         System.out.println("Shell Sort:" + single_test(ss, size));

//         sorting_algorithms qs = new quick_sort();
//         System.out.println("Shell Sort:" + single_test(qs, size));

//         sorting_algorithms ms = new merge_sort();
//         System.out.println("Merge Sort:" + single_test(ms, size));
//     }

//     public static void multiple_print(){
//         int iterations = 10;
//         int size = 100;

//         sorting_algorithms bs = new bubble_sort();
//         System.out.print("Bubble Sort: ");
//         multiple_test(bs,iterations, size);

//         sorting_algorithms is = new insertion_sort();
//         System.out.print("Insertion Sort: ");
//         multiple_test(is,iterations, size);

//         sorting_algorithms s = new selection_sort();
//         System.out.print("Selection Sort: ");
//         multiple_test(s,iterations, size);

//         sorting_algorithms ss = new shell_sort();
//         System.out.print("Shell Sort: ");
//         multiple_test(ss,iterations, size);

//         sorting_algorithms qs = new quick_sort();
//         System.out.print("Quick Sort: ");
//         multiple_test(qs,iterations, size);

//         sorting_algorithms ms = new merge_sort();
//         System.out.print("Merge Sort: ");
//         multiple_test(ms,iterations, size);
//     }
// }
