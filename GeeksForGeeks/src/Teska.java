import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Teska {

	public static void main(String[] args) {

	}

	public static List<String> classifyEdges(int gNodes, List<Integer> gFrom, List<Integer> gTo,
			List<Integer> gWeight) {

		int maxResult = Integer.MAX_VALUE;
		for (int i = 0; i < gFrom.size(); i++) {
			LinkedList<Integer> queue = new LinkedList<Integer>();
			queue.add(gFrom.get(i));
			for (int j = 0; j < gTo.size(); j++) {
				
			}
		}

		return new ArrayList<String>();
	}
}
