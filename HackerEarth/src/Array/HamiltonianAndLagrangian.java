package Array;

import java.util.Scanner;

public class HamiltonianAndLagrangian {

	static Scanner scan = new Scanner(System.in);


	public static void main(String[] args) {

		int count = scan.nextInt();
		int[] ar = new int[count];
		for (int i = 0; i < count; i++) {
			ar[i] = scan.nextInt();
		}
		int max = ar[0];
		for (int i = 0; i < count; i++) {
			int maxi = findMax(ar,i);
			if(maxi!=max){
			    max = maxi;
			    System.out.print(maxi+" ");
			}
		}
	}
	
	static int findMax(int[] ar,int index){
	    int max = Integer.MIN_VALUE;
	    for(int i=index+1;i<ar.length;i++){
	        if(ar[i]>max)
	            max= ar[i];
	    }
	    return max;
	}


}
