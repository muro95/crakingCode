package arrayAndString;

/*Assume you have a method isSubString which checks if one word is a substring
of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of 51 using only one
call to isSubString (e.g., "waterbottle" is a rotation of" erbottlewat").*/

import java.util.HashMap;
import java.util.Map;

public class stringRotation {
    public static void main (String[] args){
        String s1 ="waterbottle";
        String s2= "erbottlewat";
        System.out.println(isSubString(s1,s2));

    }
    public static boolean isSubString(String s1, String s2){
        if(s2.length() > s1.length()){
            return false;
        }
        Map<Integer, Character> map = new HashMap<>();

        char[] s1ToChar = s1.toCharArray();
        for(int i = 0; i < s1ToChar.length; i++){
            map.put(i, s1ToChar[i]);
        }
        char[] s2ToChar = s2.toCharArray();
        for(char c : s2ToChar){
            if(!map.containsValue(c)){
                return false;
            }
        }
        return true;
    }
}
