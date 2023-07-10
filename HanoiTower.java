package recurse;

    public class HanoiTower {
        public static void main(String[] args) {
            int n = 5;
            hanoi(n,1, 2,3);
        }

        public static void hanoi(int n, int from, int to, int util) {
            if (n == 1) {
                System.out.println("Переложить диск 1 со стержня " + from + " на стержень " + to);
                return;
            }
            hanoi(n - 1, from, util, to);
            System.out.println("Переложить диск " + n + " со стержня " + from + " на стержень " + to);
            hanoi(n - 1, util, to, from);
        }
    }




