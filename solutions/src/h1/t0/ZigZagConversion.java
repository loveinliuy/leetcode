package h1.t0;

/**
 * description:
 *
 * @author zhangshibo  [2017/6/8].
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0;i<numRows ; i++){
            sb[i] = new StringBuilder();
        }

        int inc = 1;
        int index = 0;

        for(int i=0;i<s.length();i++){
            sb[index].append(s.charAt(i));
            if(index == 0){
                inc = 1;
            }
            if(index == numRows -1){
                inc = -1;
            }
            index += inc;
        }

        for(int i = 1; i< numRows; i++){
            sb[0].append(sb[i]);
        }

        return sb[0].toString();
    }

    public static void main(String[] args) {
        String input = "PAYPALISHIRING";
        int rows = 3;

        String result = new ZigZagConversion().convert(input, rows);

        String except = "PAHNAPLSIIGYIR";

        System.out.println(except.equals(result));
    }
}
