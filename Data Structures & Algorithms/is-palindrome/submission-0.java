class Solution {
    public boolean isPalindrome(String s) {

        if(s == null || s.isEmpty() || s.length() == 1){
            return true;
        }

        char[] charArray = s.toCharArray();

        int L = 0, R = charArray.length - 1;
        while(L < R){
            if(!isAlphaNumeric(charArray[L])){
                L++;
                continue;
            }
            
            if(!isAlphaNumeric(charArray[R])){
                R--;
                continue;
            }
            
            if(!isEqual(charArray[L], charArray[R])){
                return false;
            }
            R--;
            L++;
        }
        return true;
    }

    private boolean isEqual(char a, char b){
        if(Character.isDigit(a) && Character.isDigit(b)){
            return a == b;
        }
        if((a >= 'A' && a <= 'Z') || (a >= 'a' && a <= 'z') || (b >= 'A' && b <= 'Z') || (b >= 'a' && b <= 'z')){
            char A = Character.toUpperCase(a);
            char B = Character.toUpperCase(b);
            return A == B;
        }
        return false;
    }

    private boolean isAlphaNumeric(char ch){
        boolean isAsciiAlphanumeric = (ch >= 'A' && ch <= 'Z') || 
                              (ch >= 'a' && ch <= 'z') || 
                              (ch >= '0' && ch <= '9');
        return isAsciiAlphanumeric;
    }
}
