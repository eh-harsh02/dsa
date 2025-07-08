import java.util.Scanner;
public class typeCheck{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        // System.out.println(str);
        // scn.nextLine();
        char ch = str.trim().charAt(0);
        // System.out.println(ch);
        if(ch>='a' && ch<='z'){
            System.out.println("Lowercase");
        }else{
            System.out.println("Uppercase");
        }
        
    }
}