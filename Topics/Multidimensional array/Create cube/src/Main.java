import java.util.Arrays;

class ArrayOperations {
    public static int[][][] createCube() {
        int[][][] threeDimArray = {
                {
                        {0, 1, 2}, {3, 4, 5}, {6, 7, 8}
                },
                {
                        {0, 1, 2}, {3, 4, 5}, {6, 7, 8}
                },
                {
                        {0, 1, 2}, {3, 4, 5}, {6, 7, 8}
                }
        };
        System.out.println(Arrays.deepToString(threeDimArray));
        return threeDimArray;
    }

    public static void main(String[] args) {
        createCube();
    }
}