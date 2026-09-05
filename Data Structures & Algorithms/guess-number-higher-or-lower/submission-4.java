/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    
    public int guessNumber(int n) {
        
        int low = 1;
        int high = n;
        int mypick = 0;

        while(low <= high){
            mypick = low + (high - low) / 2;
            int result = guess(mypick);
            if(result == 0){
                return mypick;
            } else if(result == 1){
                low = mypick +1;
            } else if(result == -1){
                high = mypick -1;
            }
        }
        return mypick;
    }

    
}