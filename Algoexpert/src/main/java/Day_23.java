import java.util.*;

public class Day_23 {
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
        String[] inputInts = inputStrs.get(0).split("");

        //Part 1
        Map<Integer, CustomLinkedNode> cups = new HashMap<>();
        CustomLinkedNode firstCup = null;
        CustomLinkedNode currentCup = null;
        CustomLinkedNode one = null;
        for(int i = 0; i < inputInts.length; i++)
        {
            int num = Integer.parseInt(inputInts[i]);
            CustomLinkedNode node = new CustomLinkedNode(num);
            if(i == 0)
            {
                firstCup = node;
                currentCup = firstCup;
            }
            else
            {
                currentCup.next = node;
                currentCup = currentCup.next;
            }
            cups.put(num, node);

            if(num == 1)
                one = node;
        }
        currentCup.next = firstCup;

        currentCup = firstCup;
        run(100, currentCup, one, cups);

        //Part 2 Not working, but I'm close?
        cups = new HashMap<>();
        for(int i = 0; i < inputInts.length; i++)
        {
            int num = Integer.parseInt(inputInts[i]);
            CustomLinkedNode node = new CustomLinkedNode(num);
            if(i == 0)
            {
                firstCup = node;
                currentCup = firstCup;
            }
            else
            {
                currentCup.next = node;
                currentCup = currentCup.next;
            }
            cups.put(num, node);

            if(num == 1)
                one = node;
        }
        for(int i = 10; i <= 1_000_000; i++)
        {
            CustomLinkedNode node = new CustomLinkedNode(i);
            cups.put(i, node);
            currentCup.next = node;
            currentCup = currentCup.next;
        }
        currentCup.next = firstCup;
        currentCup = firstCup;
        run(10_000_000, currentCup, one, cups);
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
