import java.util.Arrays;

public class sorting_algorithms {
    public static void main(String[] args){
        int[] a = {5,3,3,6,7,6,7,3,5,0,2};

        int[] b = {5,3,3,6,7,6,7,3,5,0,2};

        bubble_sort.bubbleSort(a);
        System.out.print("Bubble Sort: ");
        System.out.println(Arrays.toString(a));

        insertion_sort.insertionSort(a);
        System.out.print("Insertion Sort: ");
        System.out.println(Arrays.toString(a));

        selection_sort.selectionSort(a);
        System.out.print("Selection Sort: ");
        System.out.println(Arrays.toString(a));

        shell_sort.shellSort(a);
        System.out.print("Shell Sort: ");
        System.out.println(Arrays.toString(a));

        quick_sort.quickSort(b, 0, b.length-1);
        System.out.print("Quick Sort: ");
        System.out.println(Arrays.toString(b));

        merge_sort.mergeSort(b, 0, b.length-1);
        System.out.print("Merge Sort: ");
        System.out.println(Arrays.toString(b));
    }
    static class bubble_sort{
         static void bubbleSort(int[] a){
            int n = a.length;
            int tmp;
            for(int i = 0; i < n - 1; i++){
                for(int j = 0; j < n - 1 - i; j++){
                    if(a[j+1] < a[j]){
                        tmp = a[j];
                        a[j] = a[j+1];
                        a[j+1] = tmp;
                    }
                }
            }

        }
    }
    static class insertion_sort{
         static void insertionSort(int[] a){
            int tmp;
            for(int i = 0; i < a.length; i++){
                tmp = a[i];
                int j;
                for(j = i; j > 0 && tmp < a[j-1]; j--){
                    a[j] = a[j-1];
                }
                a[j] = tmp;
            }
        }
    }
    static class selection_sort{
        static void swap(int[]a, int i, int j){
            int tmp = a[j];
            a[j] = a[i];
            a[i] = tmp;
        }
        static void selectionSort(int[] a){
            for(int i = 0; i < a.length; i++){
                int minIndex = i;
                for(int j = i; j < a.length; j++){
                    if(a[j] < a[minIndex]){
                        minIndex = j;
                    }
                }
                swap(a, i, minIndex);
            }
        }
    }
    static class shell_sort{
        static void shellSort(int[] a){
            int n = a.length;
            for(int gap = n  / 2; gap > 0; gap /= 2){
                for(int i = gap; i < n; i++){
                    int tmp = a[i]; int j;
                    for(j = i; j >= gap && tmp < a[j-gap]; j-= gap){
                        a[j] = a[j-gap];
                    }
                    a[j] = tmp;
                }
            }
        }
    }
    static class quick_sort{
        static int partition(int[] numbers, int startIndex, int endIndex) {
            int midpoint = startIndex + (endIndex - startIndex) / 2;
            int pivot = numbers[midpoint];
            int low = startIndex;
            int high = endIndex;

            boolean done = false;
            while (!done) {
                while (numbers[low] < pivot) {
                    low = low + 1;
                }

                while (pivot < numbers[high]) {
                    high = high - 1;
                }

                if (low >= high) {
                    done = true;
                }
                else {
                    int temp = numbers[low];
                    numbers[low] = numbers[high];
                    numbers[high] = temp;
                    low++;
                    high--;
                }
            }
            return high;
        }
        static void quickSort(int[] a, int startIndex, int endIndex) {
            if (endIndex <= startIndex) {
                return;
            }

            int high = partition(a, startIndex, endIndex);

            quickSort(a, startIndex, high);

            quickSort(a, high + 1, endIndex);
        }
    }
    static class merge_sort{
         static void merge(int[] numbers, int i, int j, int k) {
            int mergedSize = k - i + 1;
            int[] mergedNumbers = new int[mergedSize];

            int mergePos = 0;
            int leftPos = i;
            int rightPos = j + 1;

            while (leftPos <= j && rightPos <= k) {
                if (numbers[leftPos] <= numbers[rightPos]) {
                    mergedNumbers[mergePos] = numbers[leftPos];
                    leftPos++;
                }
                else {
                    mergedNumbers[mergePos] = numbers[rightPos];
                    rightPos++;
                }
                mergePos++;
            }

            while (leftPos <= j) {
                mergedNumbers[mergePos] = numbers[leftPos];
                leftPos++;
                mergePos++;
            }

            while (rightPos <= k) {
                mergedNumbers[mergePos] = numbers[rightPos];
                rightPos++;
                mergePos++;
            }

            for (mergePos = 0; mergePos < mergedSize; mergePos++) {
                numbers[i + mergePos] = mergedNumbers[mergePos];
            }
        }
        private static void mergeSort(int[] numbers, int i, int k) {
            int j = 0;

            if (i < k) {
                j = (i + k) / 2;

                mergeSort(numbers, i, j);
                mergeSort(numbers, j + 1, k);
                merge(numbers, i, j, k);
            }
        }
    }


}

