
import java.util.Scanner;
import java.util.Arrays;

public class Lab01_6_5 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter the number of elements: ");
		int elems = input.nextInt();
		
		System.out.println("Enter the elements: ");
		double arr[] = new double[elems];
		for (int i = 0; i < elems; i++) {
			arr[i] = input.nextDouble();
		}
		
		Arrays.sort(arr);
		
		double sum  = 0;
		
		System.out.print("The elements in sorted order: ");
		for (double i: arr) {
			System.out.print(i + " ");
			sum += i;
		}
		
		System.out.print("\nThe sum is: " + sum);
		System.out.print("\nThe average is: " + sum/elems);
	}

}