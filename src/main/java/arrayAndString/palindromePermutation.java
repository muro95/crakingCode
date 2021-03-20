package arrayAndString;

/*Palindrome Permutation: Given a string, write a function to check if it is a permutation of
a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
permutation is a rearrangement of letters. The palindrome does not need to be limited to just
dictionary words.
EXAMPLE
Input: Tact Coa
Output: True (permutations: "taco cat'; "atc o eta·; etc.) */
public class palindromePermutation {

    public static void main(String[] args ){
        String s = "code";
        System.out.println(canPermutePalindrome("tactcoa"));
    }

    public static boolean canPermutePalindrome(String s){
        int[] char_counts = new int[128];
        for(int i = 0; i < s.length(); i++){
            char_counts[s.charAt(i)]++;
        }
        int count = 0;
        for(int i = 0; i < 128; i++){
            count += char_counts[i] %2;
        }
        return count <= 1;
    }
}
