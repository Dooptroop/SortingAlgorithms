package SortingAlgorithms;
import java.util.Random;


public class Sorting {

	public static int[] selectionSort(int[] data, int delay, SortCanvas sortCanvas) {
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
	
	public static int[] insertionSort(int[] data, int delay, SortCanvas sortCanvas){
		int length = data.length;
		int key = 0;
		int j = 0;
		for(int i= 1; i<length; j++){
			key=data[j];
			i=j-1;
			while(i>=0 && data[i]>key){
				data[i+1] = data[i];
				i = i-1;
				data[i+1] = data[i];
			}
		}
		return data;
	}
	

	public synchronized void bubbleSort(int[] data, int delay, SortCanvas canvas)
				throws InterruptedException {
		  int length = data.length;
		  canvas.draw(-1,-1,-1);
		  System.out.println("Enter Bubble sort");
		  for(int i = 0;i<length;i++) {
		    for(int j = (length-1);j>=(i+1);j--) {
		      if(data[j]<data[j-1]) {
		    	System.out.println("Enter if SWAP");
		    	Thread.sleep(delay);
		        canvas.draw(j,j-1,j-1);
		        //canvas.paintBars(canvas.getGraphics(),canvas.getBars());
		        swap(data,j,j-1);
		      }
		    }
		  }
		  System.out.println("Exit Bubble sort");
		  canvas.draw(-1, -1, -1);
		}

	public void quickSort(int[] barsArray, int i, int j, int delay,
			SortCanvas sortCanvas) {
		// TODO Auto-generated method stub
		
	}
	
	private void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	    }
	
	public static boolean search(int[] array, int start, int n){
		if(array[start]==n){
			return true;
		}
		if(start<array.length){
			return search(array, start+1,n);
		}
		return false;
	}
	
	public static void quickSort(int[] array, int start, int end){
		if(start<end){
			int index = partition(array,start,end);
			quickSort(array, start, index-1);
			quickSort(array, index+1, end);
		}
	}

	private static int partition(int[] array, int start, int end) {
		// TO BE CODED
		return 0;
	}
	
}
