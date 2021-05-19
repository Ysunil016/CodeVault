package September;

public class RobotBoundCircle {
    public static void main(String[] args) {
        String input = "GLRLLGLL";
        System.out.println(moveTheBar(input));
    }


    private static boolean moveTheBar(String dirs) {
        char direction = 'N';
        int x = 0;
        int y = 0;

        for (char X : dirs.toCharArray()) {
            if (X == 'G') {
                if (direction == 'N') {
                    y++;
                } else if (direction == 'E') {
                    x++;
                } else if (direction == 'S') {
                    y--;
                } else {
                    x--;
                }
            }
            if (X == 'R') {
                if (direction == 'N') {
                    direction = 'E';
                } else if (direction == 'E') {
                    direction = 'S';
                } else if (direction == 'S') {
                    direction = 'W';
                } else {
                    direction = 'N';
                }
            }
            if (X == 'L') {
                if (direction == 'N') {
                    direction = 'W';
                } else if (direction == 'E') {
                    direction = 'N';
                } else if (direction == 'S') {
                    direction = 'E';
                } else {
                    direction = 'S';
                }
            }
        }
        return (direction!='N' || (x==0 && y==0));
    }
}
