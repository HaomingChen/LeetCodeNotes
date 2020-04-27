package crackingleetcode;

/**
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
 * direction can be 0 (for left shift) or 1 (for right shift).
 * amount is the amount by which string s is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the end.
 * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 */
public class PerformStringShifts {

    public String stringShift(String s, int[][] shift) {
        if(s == null || s.length() == 0){
            return s;
        }
        int length = s.length();
        int offset = calculateShifts(shift, length);
        char[] c = new char[length];
        //calculate new index
        for(int i = 0; i < length; i++){
            c[(i + offset) % length] = s.charAt(i);
        }
        return String.valueOf(c);
    }

    private static int calculateShifts(int[][] shift, int length) {

        int offset = 0;
        for (int i = 0; i < shift.length; i++) {
            //go right
            if (shift[i][0] == 1) {
                offset += shift[i][1];
            } else {
                offset -= shift[i][1];
            }
        }
        if (offset < 0) {
            offset = length + offset % length;
        } else {
            offset = offset % length;
        }
        return offset;
    }
}
