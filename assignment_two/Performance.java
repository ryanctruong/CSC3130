public class Performance {
    public static void main(String[] args){
        Tester t;

        sorting_algorithms[] sa = {new bubble_sort(), new insertion_sort(), new selection_sort(),
                new shell_sort(), new quick_sort(), new merge_sort()};
        int[] s = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};

        for(sorting_algorithms methods : sa){
            t = new Tester(methods);
            System.out.println("-------------------------");
            for(int size : s ){
                System.out.print("Sorted " + size + " elements in ");
                t.test(20, size);
            }
        }
    }
}
