package store.kirinit.greedy;

import java.util.Scanner;

public class P1541_greedy {
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String example = sc.nextLine();
        String[] str = example.split("-");
        for (int i = 0; i < str.length; i++) {
            int temp = mySum(str[i]);
            if (i == 0) answer += temp;
            else answer -= temp;
        }
        System.out.println(answer);
    }

    private static int mySum(String s) {
        int sum = 0;
        String[] str = s.split("[+]");
        for (int i = 0; i < str.length; i++) {
            sum += Integer.parseInt(str[i]);
        }
        return sum;
    }

}
