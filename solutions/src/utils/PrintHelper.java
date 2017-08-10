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

    private static final String NEW_LINE = "\n";

    private static final String TAB = "  ";

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
        return intMatrixToString(matrix, iLen(getMatrixMax(matrix)));
    }

    private static int getMatrixMax(int[][] matrix) {
        int max = 0;
        for (int[] row : matrix) {
            for (int i : row) {
                max = Math.max(i, max);
            }
        }
        return max;
    }

    private static String intMatrixToString(int[][] matrix, int numLen) {
        StringBuilder sb = new StringBuilder();
        sb.append(ARRAY_START);
        sb.append(NEW_LINE).append(TAB);
        final String append = ARRAY_SPLIT + NEW_LINE + TAB;
        for (int[] array : matrix) {
            sb.append(intArrayToString(array, numLen)).append(append);
        }
        int lastPos = sb.lastIndexOf(append);
        if (lastPos != -1) {
            sb.delete(lastPos, lastPos + append.length());
        }
        sb.append(NEW_LINE + ARRAY_END);
        return sb.toString();
    }

    private static String intArrayToString(int[] array, int numLen) {
        StringBuilder sb = new StringBuilder();
        sb.append(ARRAY_START);
        for (int i : array) {
            (appendBlankIfNecessary(sb, i, numLen)).append(ARRAY_SPLIT);
        }
        int lastPos = sb.lastIndexOf(ARRAY_SPLIT);
        if (lastPos != -1) {
            sb.delete(lastPos, lastPos + ARRAY_SPLIT.length());
        }
        sb.append(ARRAY_END);
        return sb.toString();
    }

    private static String intArrayToString(int[] array) {
        return intArrayToString(array, iLen(getArrayMax(array)));
    }

    private static StringBuilder appendBlankIfNecessary(StringBuilder sb, int src, int needLen) {
        for (int i = 0; i < needLen - iLen(src); i++) {
            sb.append(" ");
        }
        sb.append(src);
        return sb;
    }

    private static int getArrayMax(int[] array) {
        int max = 0;
        for (int i : array) {
            max = Math.max(max, i);
        }
        return max;
    }

    private static int iLen(int i) {
        int result = 0;
        while (i != 0) {
            i = i / 10;
            result++;
        }
        return result;
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
