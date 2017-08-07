package utils;

/**
 * description:
 *
 * @author zhangshibo  [2017/7/26].
 */
public class PrintHelper {

    private static final String ARRAY_START = "[";

    private static final String ARRAY_SPLIT = ", ";

    private static final String ARRAY_END = "]";

    public static void printMatrix(int[][] matrix) {
        System.out.println(intMatrixToString(matrix));
    }

    public static void printArray(int[] array) {
        System.out.println(intArrayToString(array));
    }


    public static void printArray(Object[] array) {
        System.out.println(arrayToString(array));
    }

    private static String intMatrixToString(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        sb.append(ARRAY_START);
        for (int[] array : matrix) {
            sb.append(intArrayToString(array)).append(ARRAY_SPLIT);
        }
        int lastPos = sb.lastIndexOf(ARRAY_SPLIT);
        if (lastPos != -1) {
            sb.delete(lastPos, lastPos + ARRAY_SPLIT.length());
        }
        sb.append(ARRAY_END);
        return sb.toString();
    }

    private static String intArrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append(ARRAY_START);
        for (int i : array) {
            sb.append(i).append(ARRAY_SPLIT);
        }
        int lastPos = sb.lastIndexOf(ARRAY_SPLIT);
        if (lastPos != -1) {
            sb.delete(lastPos, lastPos + ARRAY_SPLIT.length());
        }
        sb.append(ARRAY_END);
        return sb.toString();
    }


    private static String arrayToString(Object[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append(ARRAY_START);
        for (Object o : array) {
            if (o instanceof Object[]) {
                sb.append(ARRAY_START);
                arrayToString((Object[]) o);
                sb.append(ARRAY_END);
            } else {
                sb.append(o.toString());
                sb.append(ARRAY_SPLIT);
            }
        }
        sb.append(ARRAY_END);
        return sb.toString();
    }
}
