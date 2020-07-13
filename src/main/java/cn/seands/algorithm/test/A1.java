package cn.seands.algorithm.test;

public class A1 {

    public static String rt1(int n){
        if(n <= 0){
            return "";
        }
        return rt1(n-3)+n+rt1(n-2)+n;
    }

    public static int rt2(int a, int b){
        if(b == 0){
            return 0;
        }
        if(b % 2 == 0){
            return rt2(a+a, b/2);
        }
        return rt2(a+a, b/2)+a;
    }

    public static void main(String[] args) {
        if(4.1 >= 4){
            System.out.println("...");
        }
        System.out.println(1+2+"3");
        // 311361142246
        System.out.println(rt1(6));
        System.out.println(rt2(2, 25));
        System.out.println(rt2(3, 11));
    }
}
