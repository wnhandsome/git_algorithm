package com.w6n.charpter4_stack.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValid {

    static boolean isValid(String s) {
        if (s == null || s.length() <= 1){
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){    //是左括号，就入栈
                stack.push(c);
            }else {     //是右括号，就与栈顶元素对应的右括号匹配
                if (stack.isEmpty()){   //栈为空，匹配失败，返回false
                    return false;
                }else {     //栈不为空，与栈顶元素对应的右括号匹配
                    Character key = stack.pop();
                    Character value = map.get(key);
                    if (value != c){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
}

