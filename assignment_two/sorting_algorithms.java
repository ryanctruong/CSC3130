public interface sorting_algorithms {
    int[] sort(int[] input);
}
    class bubble_sort implements sorting_algorithms{
        public int[] sort(int[] input){
            int n = input.length;
            int tmp;
            for(int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - 1 - i; j++) {
                    if (input[j + 1] < input[j]) {
                        tmp = input[j];
                        input[j] = input[j + 1];
                        input[j + 1] = tmp;
                    }
                }
            }
            return input;
        }
    }
    class insertion_sort implements sorting_algorithms{
        public int[] sort(int[] input){
            int tmp;
            for(int i = 0; i < input.length; i++){
                tmp = input[i];
                int j;
                for(j = i; j > 0 && tmp < input[j-1]; j--){
                    input[j] = input[j-1];
                }
                input[j] = tmp;
            }
            return input;
        }
    }
    class selection_sort implements sorting_algorithms{
        static void swap(int[]input, int i, int j){
            int tmp = input[j];
            input[j] = input[i];
            input[i] = tmp;
        }
        public int[] sort(int[] input){
            for(int i = 0; i < input.length; i++){
                int minIndex = i;
                for(int j = i; j < input.length; j++){
                    if(input[j] < input[minIndex]){
                        minIndex = j;
                    }
                }
                swap(input, i, minIndex);
            }
            return input;
        }
    }
    class shell_sort implements sorting_algorithms{
        public int[] sort(int[] input){
            int n = input.length;
            for(int gap = n  / 2; gap > 0; gap /= 2){
                for(int i = gap; i < n; i++){
                    int tmp = input[i]; int j;
                    for(j = i; j >= gap && tmp < input[j-gap]; j-= gap){
                        input[j] = input[j-gap];
                    }
                    input[j] = tmp;
                }
            }
            return input;
        }
    }

    class quick_sort implements sorting_algorithms{
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

        static void quickSort(int[] input, int startIndex, int endIndex) {
            if (endIndex <= startIndex) {
                return;
            }

            int high = partition(input, startIndex, endIndex);

            quickSort(input, startIndex, high);

            quickSort(input, high + 1, endIndex);
        }

        public int[] sort(int[] input) {
            quickSort(input, 0, input.length - 1);
            return input;
        }
    }

    class merge_sort implements sorting_algorithms {
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
                } else {
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

        static void mergeSort(int[] numbers, int i, int k) {
            int j;

            if (i < k) {
                j = (i + k) / 2;

                mergeSort(numbers, i, j);
                mergeSort(numbers, j + 1, k);
                merge(numbers, i, j, k);
            }
        }

        public int[] sort(int[] input) {
            mergeSort(input, 0, input.length - 1);
            return input;
        }
    }
