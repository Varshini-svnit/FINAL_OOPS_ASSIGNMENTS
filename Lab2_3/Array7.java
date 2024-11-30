package Lab2;


import java.util.Scanner;

class ArrayOperations7 {
    private int[] arr;

    public ArrayOperations7() {
        arr = new int[5];  
    }

    public ArrayOperations7(int size) {
        arr = new int[size];
    }

    public void inputElements() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter " + arr.length + " elements:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
    }

    public int findLargest() {
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        ArrayOperations7 arrayOp = new ArrayOperations7(6);  
        int largest = arrayOp.findLargest();
        System.out.println("The largest element in the array is: " + largest);
    }
}
