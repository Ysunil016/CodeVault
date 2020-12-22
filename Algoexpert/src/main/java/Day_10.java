import java.util.*;
import java.util.stream.Collectors;

public class Day_10 {

    private static Map<String, Long> cache;
    static Scanner scan = new Scanner(System.in);

    private static int part = 1;
    private static long timerStart;

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
        List<Integer> inputs = convertToInts(inputStrs);
        inputs.sort(Integer::compareTo);
        inputs.add(0, 0);
        inputs.add(inputs.get(inputs.size() - 1) + 3);

        int diff1 = 0;
        int diff3 = 0;

        for(int i = 1; i < inputs.size(); i++)
        {
            int diff = inputs.get(i) - inputs.get(i - 1);
            if(diff == 1)
            {
                diff1++;
            }
            else if(diff == 3)
            {
                diff3++;
            }
        }
        lap(diff1 * diff3);

        cache = new HashMap<>();
        long arrangements = getArrangements(inputs);
        lap(arrangements);

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

    public static List<Integer> convertToInts(List<String> input)
    {
        return input.stream().mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }

    public List<Long> convertToLongs(List<String> input)
    {
        return input.stream().mapToLong(Long::parseLong).boxed().collect(Collectors.toList());
    }


    public static long getArrangements(List<Integer> inputs)
    {
        if(inputs.size() == 1)
            return 1;

        long arrangements = 0;
        int index = 1;
        int current = inputs.get(0);
        while(inputs.size() > index && inputs.get(index) - current < 4)
        {
            List<Integer> subList = inputs.subList(index, inputs.size());
            String subListStr = Arrays.toString(subList.toArray(new Integer[0]));

            if(cache.containsKey(subListStr))
            {
                arrangements += cache.get(subListStr);
            }
            else
            {
                long subArrangements = getArrangements(subList);
                cache.put(subListStr, subArrangements);
                arrangements += subArrangements;
            }
            index++;
        }
        return arrangements;
    }
}
