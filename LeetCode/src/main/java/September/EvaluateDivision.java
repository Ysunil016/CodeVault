package September;

import java.util.*;

public class EvaluateDivision {

    public static void main(String[] args) {

    }

    static class Node {
        String key;
        double val;

        public Node(String k, double v) {
            key = k;
            val = v;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> g = buildGraph(equations, values); // build the graph

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++)
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet(), g); // call dfs for each queries -

        return result;
    }

    private double dfs(String s, String d, Set<String> visited, Map<String, List<Node>> g) {
        if (!(g.containsKey(s) && g.containsKey(d))) return -1.0; // if any vertex s, d is not in graph not path return -1;
        if (s.equals(d)) return 1.0; // if we reached on destination return 1; // if we reached on destination vertex

        visited.add(s); // mark visited
        for (Node node : g.get(s)) { // iterate all adjancent nodes
            if (!visited.contains(node.key)) {
                double ans = dfs(node.key, d, visited, g); // call dfs if not already visited
                if (ans != -1.0)
                    return ans * node.val;
            }
        }

        return -1;
    }

    // build graph from equarions variable and the values.
    private Map<String, List<Node>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Node>> g = new HashMap();
        for (int i = 0; i < values.length; i++) {
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            g.computeIfAbsent(src, k -> new ArrayList()).add(new Node(dest, values[i]));
            g.computeIfAbsent(dest, k -> new ArrayList()).add(new Node(src, 1 / values[i]));
        }
        return g;
}

}
