import java.util.*;
public class binaryNumOperation {
    public static int solve(String str) {
        if(str == null || str.length() == 0) return -1;
        int res = str.charAt(0) - '0';
        for(int i = 1; i < str.length(); i += 2) {
            char op = str.charAt(i);
            int next = str.charAt(i + 1) - '0';
            switch(op) {
                case 'A':
                res &=  next;
                break;
                case 'B':
                res |= next;
                break;
                case 'C':
                res ^= next;
                break;
                default:
                return -1;
            }
        }
        return res;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solve(str));
    }
}

// str: 1C0C1C1A0B1