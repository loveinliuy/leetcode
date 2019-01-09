package h0.t4;

/**
 * description:
 *
 * @author zhangshibo  [2017/7/26].
 */
public class MultiplyStrings {


    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }


//    public String multiply(String num1, String num2) {
//        if (num2.length() > num1.length()) {
//            String temp = num1;
//            num1 = num2;
//            num2 = temp;
//        }
//
//        int[][] multi = new int[num2.length()][num1.length() + 1];
//        for (int i = num2.length() - 1; i >= 0; i--) {
//            int increment = 0;
//            for (int j = num1.length() - 1; j >= -1; j--) {
//                if (j == -1) {
//                    multi[num2.length() - i - 1][j + 1] = increment;
//                } else {
//                    int val = (num1.charAt(j) - '0') * (num2.charAt(i) - '0') + increment;
//                    multi[num2.length() - i - 1][j + 1] = val % 10;
//                    increment = val / 10;
//                }
//            }
//        }
//        //PrintHelper.printMatrix(multi);
//
//        StringBuilder sb = new StringBuilder();
//        int rincre = 0;
//        int row = multi.length;
//        int col = multi[0].length;
//        for (int k = 0; k < col * 2 - 1; k++) {
//            int diff = col - k - 1;
//            int temp = 0;
//            boolean added = false;
//            for (int j = 0; j < col; j++) {
//                int i = j - diff;
//                if (isValidIndex(i, row) && isValidIndex(j, col)) {
//                    temp += multi[i][j];
//                    added = true;
//                }
//            }
//            if (added) {
//                temp += rincre;
//                sb.append(temp % 10);
//                rincre = temp / 10;
//            }
//        }
//        if (rincre != 0) {
//            sb.append(rincre);
//        }
//
//
//        sb.reverse();
//
//        int pos = 0;
//        while ('0' == sb.charAt(pos) && pos < sb.length() - 1) {
//            pos++;
//        }
//
//        return sb.substring(pos);
//    }
//
//    private static boolean isValidIndex(int i, int n) {
//        return i >= 0 && i < n;
//    }

    public static void main(String[] args) {
        String num1 = "1";
        String num2 = "1";

        System.out.println(new MultiplyStrings().multiply(num1, num2));
    }
}
