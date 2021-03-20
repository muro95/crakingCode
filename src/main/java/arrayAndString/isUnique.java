package arrayAndString;

/* Implement an algorithm to determine if a string has all unique characters. What if you
cannot use additional data structures? */

public class isUnique {

    //first step is asking the interviewer if String is an ASCII string or a Unicode string
    //check string length either pass 128 character (256 or extended version of ASCII
    //clarify the assumption with the interviewer)
    //if more than 128 return false
    public static void main(String[] args){
        String n = "hello World";
        System.out.println( isUnique(n));
        System.out.println(isUniqueS(n));

    }

    public static boolean isUnique(String n){
        if(n.length() > 128){
            return false;
        }
    boolean[] char_set = new boolean[128];
        for(int i = 0; i < n.length(); i++){
            int val = n.charAt(i);
            if(char_set[val]){
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }
    public static boolean isUniqueS(String n){
        if(n.length() > 128){
            return false;
        }
        for(int i = 0; i < n.length() -1; i++){
            for(int j = 1; j < n.length(); j++){
                if(n.charAt(i) == n.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
}
