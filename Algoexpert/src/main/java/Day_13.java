import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day_13 {

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
        long leaveTime = Long.parseLong(inputStrs.get(0));
        List<Integer> busIDs = new ArrayList<>();
        for(String id : inputStrs.get(1).split(","))
        {
            if(!id.equals("x"))
            {
                busIDs.add(Integer.parseInt(id));
            }
        }

        int smallID = 1;
        long smallest = Integer.MAX_VALUE;
        for(Integer id : busIDs)
        {
            if(leaveTime % id != 0)
            {
                long ciel = (int) (Math.ceil(leaveTime / (double) id) * id);
                if(ciel < smallest)
                {
                    smallest = ciel;
                    smallID = id;
                }
            }
            else
            {
                lap(0);
            }
        }

        lap((smallest - leaveTime) * smallID);


        // PART 2 uses the Chinese Remainder Theorem... I don't know it though...
        // The below was what I got and it works, but is not based off the Chinese Remainder Theorem
        // and is therefore not efficient enough to solve the problem quick enough
        busIDs = new ArrayList<>();
        boolean complete = false;
        int t = 0;
        int largestIndex = 0;
        for(String id : inputStrs.get(1).split(","))
        {
            if(id.equals("x"))
                busIDs.add(0);
            else
                busIDs.add(Integer.parseInt(id));

            if(busIDs.get(largestIndex) < busIDs.get(busIDs.size() - 1))
            {
                largestIndex = busIDs.size() - 1;
            }
        }

        while(!complete)
        {
            t += busIDs.get(largestIndex);
            complete = true;
            for(int i = 0; i < busIDs.size(); i++)
            {
                if(busIDs.get(i) == 0)
                    continue;

                if((t - largestIndex + i) % busIDs.get(i) != 0)
                {
                    complete = false;
                    break;
                }
            }
        }

        lap(t - largestIndex);
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
