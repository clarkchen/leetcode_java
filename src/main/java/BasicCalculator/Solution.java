package BasicCalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by chenxi on 15/6/30.
 * 逆波兰表达式的精髓，是要免除括号的烦恼
 * HardPoint 是 对于优先级的考量，只要是符号，都要面对这个问题
 * 当然这里的边界条件，也确实非常伤人，Integer的最小值，要比最大值的绝对值大一，因为整数，需要考虑0
 */
public class Solution {
    private boolean is_num(char c)
    {
        return c>='0' && c<='9';
    }
    private boolean is_operator(char op)
    {
        return op== '+' || op == '-' || op=='*' || op == '/';
    }

    Map<Character, Integer> operatorPriority;
    public Solution()
    {
        Map<Character, Integer> operatorPriority = new HashMap<Character, Integer>();
        operatorPriority.put('(',0);
        operatorPriority.put('+',1);
        operatorPriority.put('-',1);
        operatorPriority.put('*',2);
        operatorPriority.put('/',2);
        this.operatorPriority = operatorPriority;
    }
    private boolean bigThan(char op1, char op2)
    {
        int opPri1 = this.operatorPriority.get(op1);
        int opPri2 = this.operatorPriority.get(op2);
        return opPri1 > opPri2;
    }
    private Integer cal(int v1, int v2, char op)
    {
        if(op=='+') return v1+v2;
        if(op=='-') return v1-v2;
        if(op=='*') return v1*v2;
        if(op=='/') return v1/v2;

        return null;
    }

    public int calculate(String s) {
        Stack<Character> operator = new Stack<Character>();
        Stack<Integer> values = new Stack<Integer>();
        for (int i=0;i<s.length();i++)
        {

            char cur = s.charAt(i);
            if (cur==' ') continue;

            if (is_num(cur)) {
                String num= "";
                while (i<s.length() && is_num(s.charAt(i)) ) {
                    num += String.valueOf(s.charAt(i));
                    i++;
                }
                //0-2147483648
                if (num.equals("2147483648"))
                {
                    if(operator.peek()=='-')
                    {
                        operator.pop();
                        operator.push('+');
                        values.push(-2147483648);
                    }
                    else
                    {
                        System.exit(0);
                    }
                }
                else{
                    Integer value = Integer.valueOf(num);
                    values.push(value);
                    if(i<s.length())
                    {
                        cur = s.charAt(i);
                    }
                    else
                    {
                        break;
                    }
                }

            }

            if(is_operator(cur)) {
                if (operator.isEmpty()) {
                    operator.push(cur);
                } else {
                    if (!bigThan(cur, operator.peek())) {
                        while (!operator.isEmpty() && !bigThan(cur, operator.peek())) {
                            int v2 = values.pop();
                            int v1 = values.pop();
                            char top = operator.pop();
                            int value = cal(v1, v2, top);
                            values.push(value);
                        }
                    }
                    operator.push(cur);

                }
            }
            else if (cur=='(')
            {
                operator.push(cur);
            }
            else if (cur==')')
            {
                while(!operator.isEmpty())
                {
                    char top = operator.pop();
                    if (top =='(') break;
                    int v2 = values.pop();
                    int v1 = values.pop();
                    int value = cal(v1, v2, top);
                    values.push(value);
                }
            }
        }
        while(!operator.isEmpty())
        {

            int v2 = values.pop();
            int v1   = values.pop();
            char top = operator.pop();
            int value = cal(v1, v2, top);
            values.push(value);
        }

        return values.peek();
    }
}
