import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day_11 {
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
        char[][] seats = new char[inputStrs.size()][inputStrs.get(0).toCharArray().length];

        for(int i = 0; i < inputStrs.size(); i++)
        {
            seats[i] = inputStrs.get(i).toCharArray();
        }

        //PART 1
        boolean same = false;
        char[][] updated = seats;
        while(!same)
        {
            char[][] temp = updatePart1(updated);
            same = true;
            for(int i = 0; i < updated.length; i++)
            {
                if(!same)
                    break;
                for(int j = 0; j < updated[i].length; j++)
                {
                    if(temp[i][j] != updated[i][j])
                    {
                        same = false;
                        break;
                    }
                }
            }
            updated = temp;
        }

        int occupied = 0;
        for(char[] chars : updated)
        {
            for(char aChar : chars)
            {
                if(aChar == '#')
                {
                    occupied++;
                }
            }
        }

        lap(occupied);

        //PART 2
        same = false;
        updated = seats;
        while(!same)
        {
            char[][] temp = updatePart2(updated);
            same = true;
            for(int i = 0; i < updated.length; i++)
            {
                if(!same)
                    break;
                for(int j = 0; j < updated[i].length; j++)
                {
                    if(temp[i][j] != updated[i][j])
                    {
                        same = false;
                        break;
                    }
                }
            }
            updated = temp;
        }

        occupied = 0;
        for(char[] chars : updated)
        {
            for(char aChar : chars)
            {
                if(aChar == '#')
                {
                    occupied++;
                }
            }
        }

        lap(occupied);


    }

    public static char[][] updatePart1(char[][] seats)
    {
        char[][] updated = new char[seats.length][seats[0].length];

        for(int i = 0; i < updated.length; i++)
        {
            for(int j = 0; j < updated[i].length; j++)
            {
                char chatAt = seats[i][j];
                switch(chatAt)
                {
                    case 'L':
                        boolean occupied = true;
                        for(int iOff = -1; iOff < 2; iOff++)
                        {
                            if(!occupied)
                                break;
                            for(int jOff = -1; jOff < 2; jOff++)
                            {
                                if(iOff == 0 && jOff == 0 || i + iOff < 0 || j + jOff < 0 || i + iOff >= updated.length || j + jOff >= updated[i].length)
                                    continue;

                                char chatAtOff = seats[i + iOff][j + jOff];
                                if(chatAtOff == '#')
                                {
                                    occupied = false;
                                    break;
                                }
                            }
                        }

                        updated[i][j] = occupied ? '#' : 'L';
                        break;
                    case '#':
                        int occupiedCount = 0;
                        for(int iOff = -1; iOff < 2; iOff++)
                        {
                            for(int jOff = -1; jOff < 2; jOff++)
                            {
                                if(iOff == 0 && jOff == 0 || i + iOff < 0 || j + jOff < 0 || i + iOff >= updated.length || j + jOff >= updated[i].length)
                                    continue;

                                char chatAtOff = seats[i + iOff][j + jOff];
                                if(chatAtOff == '#')
                                {
                                    occupiedCount++;
                                }
                            }
                        }

                        updated[i][j] = occupiedCount >= 4 ? 'L' : '#';
                        break;
                    default:
                        updated[i][j] = '.';
                        break;
                }
            }
        }
        return updated;
    }

    public static char[][] updatePart2(char[][] seats)
    {
        char[][] updated = new char[seats.length][seats[0].length];

        for(int i = 0; i < updated.length; i++)
        {
            for(int j = 0; j < updated[i].length; j++)
            {
                char chatAt = seats[i][j];

                switch(chatAt)
                {
                    case 'L':
                        boolean occupied = true;

                        for(int iOff = -1; iOff < 2; iOff++)
                        {
                            if(!occupied)
                                break;
                            for(int jOff = -1; jOff < 2; jOff++)
                            {
                                if(iOff == 0 && jOff == 0)
                                    continue;
                                if(!occupied)
                                    break;
                                for(int scale = 1; scale < 100; scale++)
                                {
                                    int iOffScale = iOff * scale;
                                    int jOffScale = jOff * scale;
                                    if(i + iOffScale < 0 || j + jOffScale < 0 || i + iOffScale >= updated.length || j + jOffScale >= updated[i].length)
                                        continue;

                                    char chatAtOff = seats[i + iOffScale][j + jOffScale];
                                    if(chatAtOff == '#')
                                    {
                                        occupied = false;
                                        break;
                                    }
                                    else if(chatAtOff == 'L')
                                    {
                                        break;
                                    }
                                }
                            }
                        }

                        updated[i][j] = occupied ? '#' : 'L';
                        break;
                    case '#':
                        int occupiedCount = 0;

                        for(int iOff = -1; iOff < 2; iOff++)
                        {
                            for(int jOff = -1; jOff < 2; jOff++)
                            {
                                if(iOff == 0 && jOff == 0)
                                    continue;
                                for(int scale = 1; scale < 100; scale++)
                                {
                                    int iOffScale = iOff * scale;
                                    int jOffScale = jOff * scale;
                                    if(i + iOffScale < 0 || j + jOffScale < 0 || i + iOffScale >= updated.length || j + jOffScale >= updated[i].length)
                                        continue;

                                    char chatAtOff = seats[i + iOffScale][j + jOffScale];
                                    if(chatAtOff == '#')
                                    {
                                        occupiedCount++;
                                        break;
                                    }
                                    else if(chatAtOff == 'L')
                                    {
                                        break;
                                    }
                                }
                            }
                        }

                        updated[i][j] = occupiedCount >= 5 ? 'L' : '#';
                        break;
                    default:
                        updated[i][j] = '.';
                        break;
                }
            }
        }
        return updated;
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
