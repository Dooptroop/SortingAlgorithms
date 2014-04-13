package SortingAlgorithms;
import java.util.Random;
public class Sorting {

	public static int[] selectionSort(int[] data) {
		int length = data.length;
		int j = 0;
		int temp = 0;
		for(int i=0; i<length; i++){
			j=i;
			for(int k=i; k<length; k++){
				if(data[j]>data[k]) { j=k; }
			}
		
		temp=data[i];
		data[i]=data[j];
		data[j]=temp;
		}
		return data;
	}

	private static void shuffleArray(int[] data) {
		int index;
		int temp;
		Random random = new Random();
		for (int i = data.length - 1; i > 0; i--) {
			index = random.nextInt(i + 1);
			//System.out.println(index);
			temp = data[index];
			data[index] = data[i];
			data[i] = temp;
		}
	}
	public static void main(String[] args){
		int[] a = {0,1,2,3,4,5,6,7,8,9};
		displaySelectionSort(a);
		
		
		
		
		
	}

	private static void displaySelectionSort(int[] a) {
		System.out.println("Selection Sort");
		System.out.println("Before: ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		shuffleArray(a);
		System.out.println("After: ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		selectionSort(a);
		System.out.println("Sorted: ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
	}
}
