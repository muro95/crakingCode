package arrayAndString;

/*URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: if implementing in Java, please use a character array so that you can
perform this operation in place.)
EXAMPLE
Input: "Mr John Smith ", 13
Output: "Mr%20John%20Smith"*/
public class uRLify {
    public static void main(String[] args){
        String s= "Mr John Smith ";
        char[] sToChar = s.toCharArray();
        int trueLength = findLastCharacter(sToChar) + 1;
        replaceSpace(sToChar, trueLength);
        System.out.print(s);
        System.out.println();
        System.out.println(new String(sToChar));
    }

    public static int findLastCharacter(char[] str) {
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] != ' ') {
                return i;
            }
        }
        return -1;
    }

    public static void replaceSpace(char[] str, int trueLength){
        int spaceCount = 0;
        int index = 0;
        int i = 0;
        for( i = 0; i < trueLength; i++){
            if(str[i] == ' '){
                spaceCount++;
            }
        }
        index = trueLength + spaceCount*2;
        if(trueLength < str.length){
            str[trueLength] = '\0';
        }
        for( i = trueLength -1; i >= 0; i--){
            if(str[i] == ' '){
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            }else{
                str[index - 1] = str[i];
                index --;
            }
        }
    }
}
