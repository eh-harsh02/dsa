public class removeVowels {
    public static String remVowels(String str){
        String ans = "";
        // for(int i=0; i<str.length(); i++){
        //     char ch = str.charAt(i);
        //     if(ch=='a'){
        //         ans = str.remove('a').toString();
        //     }
        // }
        ans = str.replaceAll("[aeiouAEIOU]", "");
        return ans;

    } 
    public static void main(String[] args) {
        String str = "hello";
        String ans = remVowels(str);
        System.out.println(ans);
    }
}
