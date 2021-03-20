package arrayAndString;
/*Given two strings, write a method to decide if one is a permutation of the
other.*/

import java.lang.reflect.Array;
import java.util.Arrays;

public class checkPermu {
    //check with interviewer case sensitive like God and dog or white space
    //first we can check if the length of each arrays if they are equal or not


    public static void main(String [] args){

        String s = "abcde";
        String t = "baedc";
        String c = "abc";
        String d = "cbd";
        System.out.println(isPermutation(c, d));
        System.out.println(isPermutationS(s, t));

    }
    //first solution using ASC II (128 characters) then count how many times each
    //character appears in the first array then decrease it in second array
    public static boolean isPermutation(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        int[] char_set = new int[128];
        char[] sToChar = s.toCharArray();

        for(char c : sToChar){
            char_set[c]++;
        }
        char[] tToChar = t.toCharArray();
        for(char ct : tToChar){
         char_set[ct]--;
         if (char_set[ct] < 0){
             return false;
         }
        }
        return true;
    }
    //second solution using build in sort

    public static boolean isPermutationS ( String s, String t){
        char[] sToChar = s.toCharArray();
        char[] tToChar = t.toCharArray();
        Arrays.sort(sToChar);
        Arrays.sort((tToChar));
        return Arrays.equals(sToChar,tToChar);
    }
}
