import java.util.*;

public class Day_24 {
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
        Map<Vect2I, Boolean> tiles = new HashMap<>();
        Vect2I current;
        for(String s : inputStrs)
        {
            current = new Vect2I(0, 0);
            int i = 0;
            while(i < s.length())
            {
                String sub = "" + s.charAt(i);
                if(s.charAt(i) == 'n' || s.charAt(i) == 's')
                {
                    i++;
                    sub += s.charAt(i);
                }
                moveVec(current, sub);
                i++;
            }

            if(tiles.containsKey(current))
                tiles.replace(current, !tiles.get(current));
            else
                tiles.put(current, false);
        }

        int blackSideUpCount = 0;
        for(Vect2I vect2I : tiles.keySet())
            if(!tiles.get(vect2I))
                blackSideUpCount++;
        lap(blackSideUpCount);

        Map<Vect2I, Boolean> tilesCopy;
        for(int y = -70; y < 70; y++)
            for(int x = -70; x < 70; x++)
                tiles.putIfAbsent(new Vect2I(x, y), true);

        List<String> dirs = Arrays.asList("e", "w", "nw", "ne", "se", "sw");
        for(int i = 0; i < 100; i++)
        {
            tilesCopy = new HashMap<>(tiles);
            for(Vect2I vect2I : tiles.keySet())
            {
                int black = 0;
                for(String dir : dirs)
                {
                    Vect2I copy = vect2I.clone();
                    moveVec(copy, dir);
                    if(tiles.containsKey(copy) && !tiles.get(copy))
                        black++;
                }

                if(tiles.get(vect2I) && black == 2)
                    tilesCopy.put(vect2I, false);
                else if(!tiles.get(vect2I) && (black == 0 | black > 2))
                    tilesCopy.put(vect2I, true);
            }
            tiles = tilesCopy;
        }

        blackSideUpCount = 0;
        for(Vect2I vect2I : tiles.keySet())
            if(!tiles.get(vect2I))
                blackSideUpCount++;

        lap(blackSideUpCount);
    }

    public static void moveVec(Vect2I vect2I, String s)
    {
        int i = 0;
        if(s.charAt(i) == 'e')
        {
            vect2I.add(1, 0);
        }
        else if(s.charAt(i) == 'w')
        {
            vect2I.add(-1, 0);
        }
        else if(s.charAt(i) == 'n')
        {
            i++;
            boolean even = vect2I.y % 2 == 0;
            vect2I.add(0, -1);
            if(s.charAt(i) == 'e' && !even)
                vect2I.add(1, 0);
            else if(s.charAt(i) == 'w' && even)
                vect2I.add(-1, 0);
        }
        else if(s.charAt(i) == 's')
        {
            i++;
            boolean even = vect2I.y % 2 == 0;
            vect2I.add(0, 1);
            if(s.charAt(i) == 'e' && !even)
                vect2I.add(1, 0);
            else if(s.charAt(i) == 'w' && even)
                vect2I.add(-1, 0);
        }
    }

    public static class Vect2I
    {
        public int x;
        public int y;

        public Vect2I(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public void add(int x, int y)
        {
            this.x += x;
            this.y += y;
        }

        @Override
        public boolean equals(Object o)
        {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Vect2I vect2I = (Vect2I) o;
            return x == vect2I.x &&
                    y == vect2I.y;
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(x, y);
        }

        @Override
        public String toString()
        {
            return "Vect2I{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        protected Vect2I clone()
        {
            return new Vect2I(x, y);
        }
    }

    public static void run(int runAmount, CustomLinkedNode currentCup, CustomLinkedNode one, Map<Integer, CustomLinkedNode> cups)
    {
        for(int i = 0; i < runAmount; i++)
        {
            CustomLinkedNode removed = currentCup.next;
            currentCup.next = currentCup.next.next.next.next;

            int destNumber = currentCup.value == 1 ? cups.size() : currentCup.value - 1;
            while(removed.value == destNumber || removed.next.value == destNumber || removed.next.next.value == destNumber)
            {
                destNumber--;
                if(destNumber == 0)
                    destNumber = cups.size();
            }

            CustomLinkedNode insertNode = cups.get(destNumber);
            removed.next.next.next = insertNode.next;
            insertNode.next = removed;

            currentCup = currentCup.next;
        }

        currentCup = one;
        if(runAmount == 100)
        {
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i < cups.size() - 1; i++)
            {
                currentCup = currentCup.next;
                stringBuilder.append(currentCup.value);
            }
            lap(stringBuilder.toString());
        }
        else
        {
            long num1 = currentCup.next.value;
            long num2 = currentCup.next.next.value;
            lap(num1 * num2);
        }


    }

    private static class CustomLinkedNode
    {
        public int value;
        public CustomLinkedNode next;

        public CustomLinkedNode(int value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return "CustomLinkedNode{" + value + '}';
        }
    }

    public static void lap(String answer)
    {
        long timeSpent = (System.nanoTime() - timerStart) / 1000;
        if(timeSpent < 1000)
            System.out.println("Part " + part + ": " + answer + ", Duration: " + timeSpent + "µs");
        else if(timeSpent < 1000000)
            System.out.println("Part " + part + ": " + answer + ", Duration: " + (timeSpent / 1000.0) + "ms");
        else
            System.out.println("Part " + part + ": " + answer + ", Duration: " + (timeSpent / 1000000.0) + "s");
        timerStart = System.nanoTime();
        part++;
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
