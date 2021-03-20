package arrayAndString;

/*One Away: There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
EXAMPLE
pale, ple -> true
pales, pale -> true
pale, bale -> true
pale, bae -> false*/
public class oneAway {
    public static void main(String [] args){
        String s = "pale";
        String t = "ple";
        System.out.println(oneEditAway(s, t));
        System.out.println(oneEditAway2(s, t));

    }
    public static boolean oneEditAway(String first, String second){
        if(first.length() == second.length()){
            return oneEditReplace(first, second);
        }else if(first.length() + 1 == second.length()){
            return oneEditInsert(first, second);
        }else if (first.length() - 1 == second.length()){
            return oneEditInsert(second, first);
        }
        return false;
    }

    public static boolean oneEditReplace(String first, String second){
        boolean foundDifference = false;
        for(int i = 0; i < first.length(); i++){
            if(first.charAt(i) != second.charAt(i)){
                if(foundDifference){
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }
    public static boolean oneEditInsert(String s1, String s2){
        int index1 = 0;
        int index2 = 0;
        while ((index2 < s2.length() && index1 < s1.length())){
            if(s1.charAt(index1) != s2.charAt(index2)){
                if(index1 != index2){
                    return false;
                }
                index2++;
            }else{
                index1++;
                index2++;
            }
        }
        return true;
    }

    public static boolean oneEditAway2(String first, String second){
        //check length
        if(Math.abs(first.length() - second.length()) > 1){
            return  false;
        }

        //check shorted and longer String
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while(index2 < s2.length() && index1 < s1.length()){
            //ple pale
            //pale bae
            if(s1.charAt(index1) != s2.charAt(index2)){
                //ensure the first difference found
                if(foundDifference){
                    return false;
                }
                foundDifference = true;
                //on replace, move shorter pointer
                if(s1.length() == s2.length()){
                    index1++;
                }
            }else{
                index1++; //If matching, move shorter pointer
            }
            index2++; // always move pointer for longer string
        }
        return true;
    }
}
