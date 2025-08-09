public class recursionExample {
    
    public int printDecre(int n) {
        if(n == 0) return 0;
        else 
        System.out.print(n + " ");
        return printDecre(n - 1);
    }
    public int fact(int n) {
        if(n <= 1) return 1;
        
        return n*fact(n-1);
    }
    public int fib(int n) {
        if(n <= 1) return n;
        return fib(n-1) + fib(n-2);
    }
    public static void main(String[] args) {
        recursionExample obj = new recursionExample();
        obj.printDecre(5);
        System.out.println();
        int factRes = obj.fact(5);
        System.out.println(factRes);
        int fibRes = obj.fib(5);
        System.out.println(fibRes);
    }
}
