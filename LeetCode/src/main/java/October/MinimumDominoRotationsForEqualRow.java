package October;

public class MinimumDominoRotationsForEqualRow {
    public static void main(String[] args) {


    }

    private static int findMaxD(int[] A,int[] B){
        int swaps = Math.min(
                numberOfSwaps(A[0], A, B),   // means make everything in A matches A[0]
                numberOfSwaps(A[0], B, A)    // means make everything in B matches A[0]
        );

        swaps = Math.min(swaps, numberOfSwaps(B[0], A, B));  // means make everything in A matches B[0]
        swaps = Math.min(swaps, numberOfSwaps(B[0], B, A));  // means make everything in B matches A[0]

        return swaps == Integer.MAX_VALUE ? -1 : swaps;
    }

    private static int numberOfSwaps(int a,int[] A,int[] B){
        int count= 0;
        for(int i=0;i<A.length;i++){
            if(A[i]!=a && B[i]!=a){
                return Integer.MAX_VALUE;
            }else if(A[i]!=a){
                count++;
            }
        }
        return count;
    }

}
