public class Main {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        Solution solution = new Solution();
        try {
            solution.fillWithSymbols();
            solution.readFile();
            solution.writeFile();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
