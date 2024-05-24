package org.example;

public class Task1 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]); // при m = 0 будет бесконечный цикл
        StringBuilder ans = new StringBuilder();

        if (m > 0) {
            int cur = 0;
            ans.append(cur + 1);
            while ((cur + m - 1) % n != 0) {
                cur = (cur + m - 1) % n;
                ans.append(cur + 1);
            }
            System.out.println(ans);
        } else {
            m = -m;
            int cur = (m - 1) % n;
            while (cur != 0) {
                ans.append(cur + 1);
                cur = (cur + m - 1) % n;
            }
            ans.append(cur + 1);
            System.out.println(ans.reverse());
        }

    }
}

// 123451234512345123451
// 5 -3
// 1 4 2 5 3