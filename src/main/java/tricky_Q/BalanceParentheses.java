package main.java.tricky_Q;

import java.util.Stack;

public class BalanceParentheses {
    public static void main(String[] args) {
        String parentheses = "{[()]({}[]){}}";
        System.out.println(getBalanced(parentheses));

    }

    private static boolean getBalanced(String parentheses) {
        Stack<Character> stack = new Stack<>();
        for(char c : parentheses.toCharArray()){
            if(c=='{'||c=='('||c=='[')
                stack.push(c);
            else if(c=='}'||c==')'||c==']'){
                if(stack.empty())
                    return false;
                char top = stack.peek();
                if((c=='}' && top =='{')||
                        (top == '('&& c==')')||
                        (top=='[' && c==']'))
                    stack.pop();
                else return false;
            }
        }
        return stack.empty();
    }
}
