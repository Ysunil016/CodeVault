package September;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabel {

	public static void main(String[] args) {
		System.out.println(partitionLabels("absghghjhfyrypooud"));
	}
	public static List<Integer> partitionLabels(String S) {
        List<Integer> resultLengths = new ArrayList<>();
        
        int[] lastIndices = new int[26];
        for(int i=0;i<S.length();i++){
            lastIndices[S.charAt(i) - 'a'] = i;
        }
        
        int i=0;
        while(i<S.length()){
            int endOccurance = lastIndices[S.charAt(i) - 'a'];
            int j = i;
            while(j != endOccurance){
                endOccurance = Math.max(endOccurance, lastIndices[S.charAt(j++) - 'a']);
            }
            resultLengths.add(j-i+1);
            i = j+1;
        }
        return resultLengths;
    }

}
