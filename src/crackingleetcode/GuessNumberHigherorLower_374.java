package crackingleetcode;

/**
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 *
 * @author 58212
 * @date 2020-02-01 21:10
 */
public class GuessNumberHigherorLower_374 {
}

class GuessGame {
    int guess(int mid) {
        return 1;
    }
}

class Solution extends GuessGame {

    public int guessNumber(int n) {
        int lowerBound = 1;
        int upperBound = n;
        int mid = -1;
        while (true) {
            mid = lowerBound + (upperBound - lowerBound) / 2;
            int res = guess(mid);
            if (res == -1) {
                upperBound = mid - 1;
            } else if (res == 1) {
                lowerBound = mid + 1;
            } else {
                break;
            }
        }
        return mid;
    }
}