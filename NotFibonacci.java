import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NotFibonacci {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Length: ");
        int length = scan.nextInt();

        for(int i = 0; i <= length; i++){
            System.out.println(not_fibonacci(i));
        }

        System.out.print("\nValue: ");
        int value = scan.nextInt();
        int v = where_in_sequence(value);
        System.out.println("Position: " + v);
    }

    public static int not_fibonacci(int i){
        if(i == 0){
            return 0;
        }
        if(i == 1){
            return 1;
        }
        else{
            return(2* not_fibonacci(i-1)) + not_fibonacci(i-2);
        }
    }

    public static int where_in_sequence(int i){
        List<Integer> value = new ArrayList<>();
        int counter = 0;
        while(true){
            int a = not_fibonacci(counter);
            if(i > a){
                counter++;
                value.add(a);
            }
            else if (i < a) { // if the value is lower than expected value
                return value.size()-1;
            } else{ // if exact value is found
                return value.size();
            }
        }
    }
}
