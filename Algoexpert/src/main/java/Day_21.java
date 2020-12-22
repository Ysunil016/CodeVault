import java.util.*;

public class Day_21 {
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
        Map<String, List<String>> allergenList = new HashMap<>();
        List<List<String>> allIngredients = new ArrayList<>();
        Set<String> uniqueIngredients = new HashSet<>();
        for(String s : inputStrs)
        {
            List<String> ingredients = Arrays.asList(s.substring(0, s.indexOf("(contains ")).split(" "));
            allIngredients.add(ingredients);
            uniqueIngredients.addAll(ingredients);
            String[] allergens = s.substring(s.indexOf("(contains ") + 10, s.length() - 1).split(", ");

            for(String a : allergens)
            {
                if(allergenList.containsKey(a))
                {
                    List<String> possibleAllergens = allergenList.get(a);
                    for(int i = possibleAllergens.size() - 1; i >= 0; i--)
                    {
                        if(!ingredients.contains(possibleAllergens.get(i)))
                        {
                            possibleAllergens.remove(i);
                        }
                    }
                }
                else
                {
                    allergenList.put(a, new ArrayList<>(ingredients));
                }
            }
        }

        Map<String, String> allergenMapping = new HashMap<>();

        while(allergenList.size() > 0)
        {
            String toRemove = "";
            for(String a : allergenList.keySet())
            {
                List<String> ingredients = allergenList.get(a);
                if(ingredients.size() == 1)
                {
                    String ing = ingredients.get(0);
                    allergenMapping.put(a, ing);
                    toRemove = a;
                    for(String a2 : allergenList.keySet())
                    {
                        allergenList.get(a2).remove(ing);
                    }
                    break;
                }
            }

            if(!toRemove.isEmpty())
                allergenList.remove(toRemove);
        }

        List<String> hasNoAllergens = new ArrayList<>(uniqueIngredients);
        for(String a : allergenMapping.values())
        {
            hasNoAllergens.remove(a);
        }

        int total = 0;
        for(List<String> ingredients : allIngredients)
        {
            for(String ing : hasNoAllergens)
            {
                if(ingredients.contains(ing))
                    total++;
            }
        }

        lap(total);
        List<String> aSorted = new ArrayList<>(allergenMapping.keySet());
        aSorted.sort(String::compareTo);
        StringBuilder builder = new StringBuilder();
        for(String a : aSorted)
            builder.append(allergenMapping.get(a)).append(",");
        builder.deleteCharAt(builder.length() - 1);

        lap(builder.toString());
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
