package Problems;

public class Find {

    public static void main(String args[]) {

        int max = 1000;
        Double min = 5.0;
        for (Double x = 1.0; x < max; x++) {
            for (Double y = 1.0; y < max; y++) {
                for (Double z = 1.0; z < max; z++) {
                    Double left = ((x / (y + z)) + (y / (x + z)) + (z / (x + y)));
                    if (left.intValue() == 4 && left < min) {
                        min = left;
                        System.out.println(left);
                        System.out.println("x = " + x);
                        System.out.println("y = " + y);
                        System.out.println("z = " + z);
                    }
                }
            }
        }
    }
}
