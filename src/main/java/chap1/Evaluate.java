package chap1;

import java.util.*;


public class Evaluate {
    public static void main(String[] args) {
        Stack<Character> ops = new Stack<Character>();
        Stack<Double> vals = new Stack<Double>();
        String str = "(1+((2+3)*(4*5))";
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                ops.push(str.charAt(i));
            } else if(str.charAt(i) == '+') {
                ops.push(str.charAt(i));
            } else if(str.charAt(i) == '-') {
                ops.push(str.charAt(i));
            } else if(str.charAt(i) == '*') {
                ops.push(str.charAt(i));
            } else if(str.charAt(i) == '/') {
                ops.push(str.charAt(i));
            } else if(str.charAt(i) == ')') {
                Character op = ops.pop();
                double v = vals.pop();
                if(op == '+') {
                    v = vals.pop() + v;
                } else if(op == '-') {
                    v = vals.pop() - v;
                } else if(op == '*') {
                    System.out.println("run *");
                    v = vals.pop() * v;
                } else if(op == '/') {
                    v = vals.pop() / v;
                }
                System.out.println(v);
                vals.push(v);
                System.out.println("1:" + vals);
            } else{
                vals.push((double)(str.charAt(i)-'0'));
                System.out.println("2: " + vals);
            }

        }
        System.out.println(vals.pop());
    }
}
