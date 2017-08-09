package h3.t7;

/**
 * description:
 *
 * @author zhangshibo  [2017/6/7].
 */
public class GuessNumberHigherOrLower {

    public abstract class GuessGame {

        private int beGuessed;

        public int guess(int num) {
            if (num > beGuessed) {
                return -1;
            } else if (num < beGuessed) {
                return 1;
            } else {
                return 0;
            }
        }

        public abstract int guessNumber(int n);

    }

    public class Solution extends GuessGame {

        public int guessNumber(int n) {
            int low = 1;
            int high = n;
            while (true) {
                int mid = low + (high - low) / 2;
                int r = guess(mid);
                if (r > 0) {
                    low = mid + 1;
                } else if (r < 0) {
                    high = mid;
                } else {
                    return mid;
                }
            }
        }

    }

    public class GuessGameProxy extends GuessGame {

        private GuessGame guessGame;

        public GuessGameProxy(GuessGame guessGame) {
            super();
            this.guessGame = guessGame;
        }

        @Override
        public int guessNumber(int n) {
            guessGame.beGuessed = 1702766719;//new Random().nextInt(n);
            System.out.println("I guessed the number is: " + guessGame.beGuessed);
            return guessGame.guessNumber(n);
        }
    }

    public void execute() {

        Solution solution = new Solution();

        GuessGame guessGame = new GuessGameProxy(solution);

        System.out.println(guessGame.guessNumber(2126753390));
    }

    public static void main(String[] args) {
        new GuessNumberHigherOrLower().execute();
    }
}
