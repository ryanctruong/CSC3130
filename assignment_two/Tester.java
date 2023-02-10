import java.text.DecimalFormat;
import java.util.Random;

public class Tester {
    public sorting_algorithms sorting;

    public Tester(sorting_algorithms sorting) {
        this.sorting = sorting;
    }

    public double singleTest(int size) {
        int[] c = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            c[i] = rand.nextInt(100);
        }

        long start_time = System.nanoTime();
        sorting.sort(c);
        long end_time = System.nanoTime();

        return (end_time - start_time) / 1000000.0;
    }

    public double test(int iterations, int size) {
        double time = 0;
        for (int i = 0; i < iterations; i++) {
            time += singleTest(size);
        }

        double averageTime = time / iterations;
        DecimalFormat decimalFormat = new DecimalFormat("#.#####");

        return Double.parseDouble(decimalFormat.format(averageTime));
    }
}
