package Class_1104;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeaBattle {
    static int[][] sea = new int[4][6];

    static boolean isShielded = true;


    public static void main(String[] args) {
        makeSea();
        printSea();
        System.out.println(fireAt(4, 1));
        System.out.println(fireAt(4, 1));
        System.out.println(fireAt(2, 2));
        System.out.println(fireAt(2, 2));
    }

    public static void printSea() {
        for (int[] line : sea) {
            System.out.println(Arrays.toString(line));
        }
    }

    public static void makeSea() {
        for (int i = 0; i < sea[0].length; i++) {
            if (i == 3 || i == 4) {
                sea[0][i] = 1;
            }
        }
        for (int i = 1; i < sea.length; i++) {
            for (int j = 0; j < sea[0].length; j++) {
                if (j == 1) {
                    sea[i][j] = 1;
                }
                if (i > 1 && j == 3) {
                    sea[i][j] = 1;
                }
            }
        }
    }

    public static int fireAt(int xCord, int yCord) {
        xCord--;
        yCord--;
        int count = 0;
        if (sea[yCord][xCord] == 1) {
            if (isShipHrz(xCord,yCord)){
                int[] target = new int[] {xCord,yCord};
                List<int[]> cords = getHShipCords(xCord, yCord);
                for (int[] cord: cords){
                    if (Arrays.equals(cord,target)){
                        if (isShielded){
                            isShielded = false;
                        } else {
                            count++;
                            if (isShipHrz(xCord, yCord)) {
                                count += checkHrz(xCord, yCord);
                            } else {
                                count += checkVrt(xCord, yCord);
                                isShielded = true;
                            }
                        }
                    }
                }
            } else {
                int[] target = new int[] {xCord,yCord};
                List<int[]> cords = getVShipCords(xCord, yCord);
                for (int[] cord: cords){
                    if (Arrays.equals(cord,target)){
                        if (isShielded){
                            isShielded = false;
                        } else {
                            count++;
                            if (isShipHrz(xCord, yCord)) {
                                count += checkHrz(xCord, yCord);
                            } else {
                                count += checkVrt(xCord, yCord);
                                isShielded = true;
                            }
                        }
                    }
                }
            }
//            isShielded = false;
//            if (!isShielded) {
//
//            } else {
//                if (isShipHrz(xCord, yCord)) {
//                    count += checkHrz(xCord, yCord);
//                } else {
//                    count += checkVrt(xCord, yCord);
//                }
//            }
        }
        return count;
    }

    public static boolean isShipHrz(int xCord, int yCord) {
        return sea[yCord][xCord - 1] == 1 || sea[yCord][xCord + 1] == 1;
    }

    public static int checkHrz(int xCord, int yCord) {
        int count = 0;
        int currCord = xCord;
        while (xCord - 1 >= 0 && sea[yCord][xCord - 1] != 0) {
            xCord--;
            count++;
        }
        xCord = currCord;
        while (xCord + 1 < sea[yCord].length && sea[yCord][xCord + 1] != 0) {
            xCord++;
            count++;
        }
        return count;
    }

    public static int checkVrt(int xCord, int yCord) {
        int count = 0;
        int currCord = yCord;
        while (yCord - 1 >= 0 && sea[yCord - 1][xCord] != 0) {
            yCord--;
            count++;
        }
        yCord = currCord;
        while (yCord + 1 < sea.length && sea[yCord + 1][xCord] != 0) {
            yCord++;
            count++;
        }
        return count;
    }

    public static List<int[]> getHShipCords(int xCord, int yCord) {
        List<int[]> shipCords = new ArrayList<>();
        while (xCord-1>= 0 && sea[yCord][xCord-1] != 0) {
            xCord--;
        }
        while (xCord< sea[yCord].length && sea[yCord][xCord] == 1) {
            shipCords.add(new int[]{xCord,yCord});
            xCord++;
        }
        return shipCords;
    }

    public static List<int[]> getVShipCords(int xCord, int yCord) {
        List<int[]> shipCords = new ArrayList<>();
        while (yCord-1>= 0 && sea[yCord-1][xCord] != 0) {
            yCord--;
        }
        while (yCord< sea.length && sea[yCord][xCord] == 1) {
            yCord++;
            shipCords.add(new int[]{xCord,yCord});
        }
        return shipCords;
    }
}
