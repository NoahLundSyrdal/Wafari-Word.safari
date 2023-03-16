package project;

public class test {
    private String[][] test;

    public static void main(String[] args) {
        test t = new test();
        t.createChar();
        System.out.println(t.test[0][0]);
    }

    public void createChar() {
        test = new String[10][10];

        
    }
}
