package hundred.h1.ten.t4;

/**
 * description:
 *
 * @author zhangshibo  [2017/8/7].
 */
public class WildcardMatching {

    public boolean isMatch(String s, String p){

        return false;
    }

    public static void main(String[] args){
        String s = "abcddddeeedf";
        String p = "a*e?f";

        System.out.println(new WildcardMatching().isMatch(s, p));
    }
}
