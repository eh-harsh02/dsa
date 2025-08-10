public class TowersOfHanoi {
    public static void towerOfHanoi (int n, char source_rod, char destination_rod, char aux_rod) {
        if(n == 1) {
            System.out.println("Move disk " + n + " "+source_rod + " --> " + destination_rod);
            return;
        }
        towerOfHanoi(n - 1, source_rod, aux_rod, destination_rod);
        System.out.println("Move disk " + n + " "+source_rod + " --> " + destination_rod);
        towerOfHanoi(n-1, aux_rod, destination_rod, source_rod);

    }
    public static void main(String[] args) {
        int n = 1;
        towerOfHanoi(n, 'A', 'B', 'C');
    }
}
