import java.util.*;

public class Day_20 {
    private static int part = 1;
    private static long timerStart;
    static Scanner scan = new Scanner(System.in);

    private static Map<Integer, List<List<Integer>>> rules;
    private static Map<Integer, Character> rulesEnd;

    public static void main(String[] args) {
        ArrayList array = new ArrayList<String>();
        while (true){
            var v = scan.nextLine();
            if(v.equals("-1"))
                break;
            array.add(v);
        }
        solve(array);

    }

    public static void solve(List<String> inputStrs)
    {
        List<TileData> tiles = new ArrayList<>();
        TileData tileData = null;
        String last = "";
        for(String s : inputStrs)
        {
            if(s.startsWith("Tile "))
            {
                tileData = new TileData();
                tileData.id = Integer.parseInt(s.substring(5, s.indexOf(":")));
            }
            else if(s.trim().isEmpty())
            {
                tileData.botEdge = last;
                last = "";
                tiles.add(tileData);
            }
            else
            {
                if(last.isEmpty())
                {
                    tileData.topEdge = s;
                }
                last = s;
                tileData.leftEdge = tileData.leftEdge + s.substring(0, 1);
                tileData.rightEdge = tileData.rightEdge + s.substring(s.length() - 1);
            }
        }
        tiles.add(tileData);

        long answer = 1;
        int t = 0;
        for(int i = 0; i < tiles.size(); i++)
        {
            TileData td1 = tiles.get(i);

            boolean top = false;
            boolean left = false;
            boolean bottom = false;
            boolean right = false;
            for(int j = 0; j < tiles.size(); j++)
            {
                if(i == j)
                    continue;

                TileData td2 = tiles.get(j);

                if(stringsMatch(td1.topEdge, td2.botEdge) || stringsMatch(td1.topEdge, td2.topEdge) || stringsMatch(td1.topEdge, td2.leftEdge) || stringsMatch(td1.topEdge, td2.rightEdge))
                {
                    top = true;
                }
                if(stringsMatch(td1.botEdge, td2.botEdge) || stringsMatch(td1.botEdge, td2.topEdge) || stringsMatch(td1.botEdge, td2.leftEdge) || stringsMatch(td1.botEdge, td2.rightEdge))
                {
                    bottom = true;
                }
                if(stringsMatch(td1.leftEdge, td2.botEdge) || stringsMatch(td1.leftEdge, td2.topEdge) || stringsMatch(td1.leftEdge, td2.leftEdge) || stringsMatch(td1.leftEdge, td2.rightEdge))
                {
                    left = true;
                }
                if(stringsMatch(td1.rightEdge, td2.botEdge) || stringsMatch(td1.rightEdge, td2.topEdge) || stringsMatch(td1.rightEdge, td2.leftEdge) || stringsMatch(td1.rightEdge, td2.rightEdge))
                {
                    right = true;
                }
            }

            int count = (top ? 0 : 1) + (bottom ? 0 : 1) + (left ? 0 : 1) + (right ? 0 : 1);
            if(count == 2)
            {
                answer *= td1.id;
                t++;
            }
        }

        lap(answer);
    }

    public static boolean stringsMatch(String s1, String s2)
    {
        return s1.equals(s2) || s1.equals(reverseString(s2));
    }

    public static String reverseString(String s)
    {
        StringBuilder toReturn = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--)
        {
            char b = s.charAt(i);
            toReturn.append(b);
        }
        return toReturn.toString();
    }

    private static class TileData
    {
        public int id;
        public String topEdge = "";
        public String botEdge = "";
        public String rightEdge = "";
        public String leftEdge = "";
    }


    public static int step(int lastSpoken, int index, Map<Integer, Integer> seenLast)
    {
        int seenLastTemp = seenLast.getOrDefault(lastSpoken, -1);
        seenLast.put(lastSpoken, index);
        return seenLastTemp == -1 ? 0 : (index - seenLastTemp);
    }

    public static void lap(long answer)
    {
        long timeSpent = (System.nanoTime() - timerStart) / 1000;
        if(timeSpent < 1000)
            System.out.println("Part " + part + ": " + answer + ", Duration: " + timeSpent + "µs");
        else
            System.out.println("Part " + part + ": " + answer + ", Duration: " + (timeSpent / 1000.0) + "ms");
        timerStart = System.nanoTime();
        part++;
    }

}
