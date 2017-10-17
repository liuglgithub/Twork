package com.liugl.alltest.suanfa;

import android.util.Log;

import java.util.Stack;

/**
 * Created by liugl on 2017/9/18.
 */

public class MidleTurnToBehind {

    private String testString = null;
    private Stack<Character> stack = null;

    public MidleTurnToBehind(String str){
        this.testString = str;
        stack = new Stack<Character>();
    }

    public void anaysisStr(){

        for (int i = 0; i < testString.length(); i++) {
            char c = testString.charAt(i);
            if (c == '+' || c == '-') {
                if (stack.isEmpty() || stack.peek() == '(') {
                    stack.push(c);
                } else {
                    while (!stack.isEmpty()
                            && (stack.peek() == '*' || stack.peek() == '/'
                            || stack.peek() == '+' || stack.peek() == '-')) {
                        System.out.print(stack.pop());
                    }
                    stack.push(c);
                }
            } else if (c == '*' || c == '/') {
                if (stack.isEmpty() || stack.peek() == '+'
                        || stack.peek() == '-' || stack.peek() == '(') {
                    stack.push(c);
                } else {
                    while (!stack.isEmpty()
                            && (stack.peek() == '/' || stack.peek() == '*')) {
                        System.out.print(stack.pop());
                    }
                    stack.push(c);
                }
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                char temp = ' ';
                while ((temp = stack.pop()) != '(') {
                    System.out.print(temp);
                }
            } else {
                System.out.print(c);
            }
        }
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
        }

    }

    public void anaysis(){
        for (int i = 0; i < testString.length(); i++) {
            char c = testString.charAt(i);

            if(c == '+' || c == '-'){
                if(stack.isEmpty() || stack.peek() == '('){
//                  当栈是空的时候，运算符可以直接入栈
                    stack.push(c);
                }else{
//                  当栈不为空的时候，就把优先级不大于（包括等于）当前运算符的内容输出
                    while (!stack.isEmpty() && (stack.peek() == '*'
                            || stack.peek() == '/' || stack.peek() == '+' || stack.peek() == '-')) {
//                        System.out.print(stack.pop());
                        Log.i("zhan_",""+ stack.pop());
                    }
//                  将此运算符之前的运算符出栈，之后当前运算符就要入栈。
                    stack.push(c);
                }
            }else if(c == '*' || c == '/'){
                if(stack.isEmpty() || stack.peek() == '+' || stack.peek() == '-'){
                    stack.push(c);
                }else {
                    while((!stack.isEmpty() && (stack.peek() == '/' || stack.peek() == '*'))){
//                        System.out.print(stack.pop());
                        Log.i("zhan_",""+ stack.pop());
                    }
                    stack.push(c);
                }

            }else if(c == '('){
                //  'c'运算符是优先级最高的运算符，只要出现这个运算符就要入栈
                stack.push(c);
            }else if(c == ')'){
//              如果出现了')'运算符则要把'（'运算符之后的所以的运算符出栈
                char temp;

                while ((temp = stack.peek()) != '(') {
//                    System.out.print(temp);
                    Log.i("zhan_",""+ temp);
                }
            }else{
//              如果当前字符不是运算符，则直接输出
//                System.out.print(c);
                Log.i("zhan_",""+ c);
            }
        }

        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
//                System.out.print(stack.pop());
                Log.i("zhan_",""+ stack.pop());
            }
        }

    }

    public   void main(String[] args) {
      MidleTurnToBehind testStacknew = new MidleTurnToBehind("A+B*(C-D)/E+F/H");
//      MidleTurnToBehind testStacknew = new MidleTurnToBehind("a+b*c+(d*e+f)*g");
//        MidleTurnToBehind testStacknew = new MidleTurnToBehind("a-b-c");
//      MidleTurnToBehind testStacknew = new MidleTurnToBehind("ac");
//        testStacknew.anaysisStr();
        testStacknew.anaysis();
    }
}
