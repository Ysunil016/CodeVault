import java.util.*;

public class Day_16 {

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
        int inputStage = 0;
        List<InputField> inputFields = new ArrayList<>();
        List<String[]> validTickets = new ArrayList<>();
        String[] ourTicket = new String[0];
        int errorRate = 0;
        for(String s : inputStrs)
        {
            if(s.trim().isEmpty())
            {
                inputStage++;
                continue;
            }

            if(inputStage == 0)
            {
                String[] parts = s.split(": ");
                InputField field = new InputField();
                field.text = parts[0];

                String[] ranges = parts[1].split("or");
                String[] nums = ranges[0].trim().split("-");
                field.min1 = Integer.parseInt(nums[0]);
                field.max1 = Integer.parseInt(nums[1]);
                nums = ranges[1].trim().split("-");
                field.min2 = Integer.parseInt(nums[0]);
                field.max2 = Integer.parseInt(nums[1]);

                inputFields.add(field);
            }
            else if(inputStage == 1)
            {
                if(s.contains("your ticket:"))
                    continue;
                ourTicket = s.trim().split(",");
            }
            else
            {
                if(s.contains("nearby tickets:"))
                    continue;
                String[] numbers = s.trim().split(",");

                boolean valid = false;
                for(String numStr : numbers)
                {
                    int num = Integer.parseInt(numStr);

                    valid = false;
                    for(InputField inputField : inputFields)
                    {
                        if((inputField.min1 <= num && inputField.max1 >= num) || (inputField.min2 <= num && inputField.max2 >= num))
                        {
                            valid = true;
                            break;
                        }
                    }
                    if(!valid)
                    {
                        errorRate += num;
                        break;
                    }
                }

                if(valid)
                {
                    validTickets.add(numbers);
                }
            }
        }
        lap(errorRate);

        boolean[][]  possibleMatches = new boolean[ourTicket.length][inputFields.size()];
        for(boolean[] possibleMatch : possibleMatches)
            Arrays.fill(possibleMatch, true);

        for(String[] validTicket : validTickets)
        {
            for(int j = 0; j < validTicket.length; j++)
            {
                int num = Integer.parseInt(validTicket[j]);
                for(int k = 0; k < inputFields.size(); k++)
                {
                    InputField inputField = inputFields.get(k);
                    if(!(inputField.min1 <= num && inputField.max1 >= num) && !(inputField.min2 <= num && inputField.max2 >= num))
                        possibleMatches[j][k] = false;
                }
            }
        }

        while(!isDone(possibleMatches))
            step(possibleMatches);

        long answer = 1;
        for(int j = 0; j < 6; j++)
        {
            for(int k = 0; k < possibleMatches.length; k++)
            {
                if(possibleMatches[k][j])
                {
                    answer *= Integer.parseInt(ourTicket[k]);
                    break;
                }
            }
        }

        lap(answer);
    }

    public static void step(boolean[][] possibleMatches)
    {
        for(int j = 0; j < possibleMatches.length; j++)
        {
            int count = 0;
            int index = -1;
            for(int k = 0; k < possibleMatches.length; k++)
            {
                if(possibleMatches[j][k])
                {
                    count++;
                    index = k;
                }
            }
            if(count == 1)
            {
                for(int i = 0; i < possibleMatches.length; i++)
                {
                    if(i != j)
                    {
                        possibleMatches[i][index] = false;
                    }
                }
            }
        }


        for(int j = 0; j < possibleMatches.length; j++)
        {
            int count = 0;
            int index = -1;
            for(int k = 0; k < possibleMatches.length; k++)
            {
                if(possibleMatches[k][j])
                {
                    count++;
                    index = k;
                }
            }
            if(count == 1)
            {
                for(int i = 0; i < possibleMatches.length; i++)
                {
                    if(i != j)
                    {
                        possibleMatches[index][i] = false;
                    }
                }
            }
        }
    }

    public static boolean isDone(boolean[][] possibleMatches)
    {
        boolean done = true;
        for(boolean[] possibleMatch : possibleMatches)
        {
            int count = 0;
            for(boolean b : possibleMatch)
            {
                if(b)
                {
                    count++;
                }
            }

            if(count > 1)
            {
                done = false;
                break;
            }
        }

        return done;
    }

    private static class InputField
    {
        public String text;
        public int min1;
        public int max1;
        public int min2;
        public int max2;
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
