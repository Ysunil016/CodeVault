package May.WeekTwo;

public class FindJudgeInTown {

	public static void main(String[] args) {
		int[][] arr = {{1,3},{1,4},{2,3},{2,4},{4,3}};
		System.out.println(findJudge(4,arr));
	}
	 public static int findJudge(int N, int[][] trust) {
	        int[] store = new int[N];
	        if(trust.length==0)
	            return 1;
	        for(int i=0;i<trust.length;i++){
	            int A = trust[i][0];
	            int B = trust[i][1];
	            // A Cannot be Judge, Checking If He is Nominated for Judge Ambigously
	                store[A-1] -= 1;
	            // B Can Be, if Not Already Eliminated
	                store[B-1] += 1; 
	        }
	      int judgeLen = 0;
	        int judgeIndex = -1;
	        for(int i=0;i<N;i++){
	            if(store[i] == N-1){
	                judgeLen++;
	                judgeIndex = i+1;
	            }
	            if(judgeLen>1)
	                return -1;
	        }
	        return judgeIndex;
	    }

}
