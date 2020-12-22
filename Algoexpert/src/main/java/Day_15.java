import java.util.*;

public class Day_15 {

    private static int part = 1;
    private static long timerStart;
    static Scanner scan = new Scanner(System.in);

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
        String[] numStrings = inputStrs.get(0).split(",");
        int index = 0;
        Map<Integer, Integer> seenLast = new HashMap<>();
        int last = -1;
        for(int i = 0; i < numStrings.length; i++)
        {
            int num = Integer.parseInt(numStrings[i]);
            index++;
            if(i == numStrings.length - 1)
            {
                last = num;
            }
            else
            {
                seenLast.put(num, index);
            }
        }

        while(index < 2020)
        {
            last = step(last, index, seenLast);
            index++;
        }

        lap(last);

        while(index < 30000000)
        {
            last = step(last, index, seenLast);
            index++;
        }

        lap(last);
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
