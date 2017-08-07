package hundred.h1.ten.t1;

/**
 * description:
 *
 * @author zhangshibo  [2017/6/9].
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        String aM[] = {"", "M", "MM", "MMM"};
        String aC[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String aX[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String aI[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return aM[num / 1000] + aC[(num % 1000) / 100] + aX[(num % 100) / 10] + aI[num % 10];
    }

    public static void main(String[] args){
        int input = 1009;

        System.out.println(new IntegerToRoman().intToRoman(input));
    }
}
