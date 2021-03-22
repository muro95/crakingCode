package arrayAndString;

/*Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z).*/

public class stringCompression {

    public static void main(String [] args){
        String n = "aabcccccaaa";
        String m = "aabbcccdef";


        System.out.println(stringCompression(m));

    }
    public static String stringCompression(String n){

        if(n == null || n.length() <2){
            return n;
        }
        int count = 0;
       StringBuilder sb = new StringBuilder();
        for(int i = 1; i < n.length(); i++){
            count++;
            if(n.charAt(i) != n.charAt(i-1)){
                sb.append(n.charAt(i-1));
                sb.append(count);
                count = 0;
            }else if (i + 1 >= n.length()){
                sb.append(n.charAt(i));
                sb.append(count +1);
            }
        }
        System.out.println(n);
        System.out.println(sb.toString());
        return  sb.length() >= n.length() ? n : sb.toString();
    }
}
