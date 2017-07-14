import java.util.*;
import java.util.LinkedList;

/**
 * Created by viran on 12-07-2017.
 */
public class mStack {


    // Implement Stack using Queues // two approaches
    Queue<Integer> q1;
    //Queue<Integer> q2;
    //int top;

    public mStack() {
//        q1 = new LinkedList<>();
//        q2 = new LinkedList<>();

        q1 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
//        q1.add(x);
//        top = x;

        q1.add(x);
        int size = q1.size();
        while(size>1)
        {
            int y = q1.remove();
            q1.add(y);
            size--;
        }


    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
//        while(q1.size()>1)
//        {
//            top = q1.remove();
//            q2.add(top);
//        }
//
//        Queue<Integer> temp = q1;
//        q1=q2;
//        q2=temp;
//        return q2.poll();

        return q1.poll();
    }

    /** Get the top element. */
    public int top() {
        // return top;

        return q1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }




    // Valid Parentheses
    public boolean isValid(String s) {
        if(s==null||s.length()==0) return true;
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c =s.charAt(i);
            if(c=='('||c=='{'||c=='[')
            {
                stack.push(s.charAt(i));
            }
            else if(stack.isEmpty() || c==')' && stack.peek()!='('
                    || c=='}' && stack.peek()!='{'
                    || c==']' && stack.peek()!='[')
                return false;
            else
                stack.pop();
        }
        return stack.isEmpty()?true:false;
    }




    // Min Stack
//    /** initialize your data structure here. */
//    Stack<Node> s;
//    int min = Integer.MAX_VALUE;
//
//    public MinStack() {
//        s = new Stack();
//    }
//
//    public void push(int x) {
//
//        if(x<min)
//            min=x;
//        Node n = new Node(x,min);
//        s.push(n);
//    }
//
//    public void pop() {
//        if(min==s.peek().min)
//        {
//            s.pop();
//            if(s.isEmpty())
//            {
//                min = Integer.MAX_VALUE;
//            }
//            else
//            {
//                min = s.peek().min;
//            }
//        }
//        else
//            s.pop();
//    }
//
//    public int top() {
//        return s.peek().val;
//    }
//
//    public int getMin() {
//        return (int)s.peek().min;
//    }
//
//    class Node{
//        int val;
//        int min;
//        public Node(int v, int m)
//        {
//            val=v;
//            min=m;
//        }
//    }


    // Implement Queue using Stacks // Two approaches
//    Stack<Integer> s1;
//    Stack<Integer> s2;
//
//    /** Initialize your data structure here. */
//    public MyQueue() {
//        s1 = new Stack();
//        s2 = new Stack();
//
//    }
//
////     /** Push element x to the back of queue. */
////     public void push(int x) {
////       while(!s1.isEmpty())
////         {
////             s2.push(s1.pop());
////         }
////         s1.push(x);
////         while(!s2.isEmpty())
////         {
////             s1.push(s2.pop());
////         }
////             }
//
////     /** Removes the element from in front of queue and returns that element. */
////     public int pop() {
////        return s1.pop();
////     }
//
////     /** Get the front element. */
////     public int peek() {
////         return s1.peek();
////     }
//
////     /** Returns whether the queue is empty. */
////     public boolean empty() {
////         return s1.isEmpty();
////     }
//
//
//    int first;
//    /** Push element x to the back of queue. */
//    public void push(int x) {
//        if(s1.isEmpty())
//            first=x;
//        s1.push(x);
//    }
//
//    /** Removes the element from in front of queue and returns that element. */
//    public int pop() {
//        if(!s2.isEmpty())
//            return s2.pop();
//        else
//        {
//            while(s1.size()>1)
//            {
//                s2.push(s1.pop());
//            }
//            return s1.pop();
//        }
//
//    }
//
//    /** Get the front element. */
//    public int peek() {
//        if(!s2.isEmpty()){
//            return s2.peek();
//        }
//        else {
//            return first;
//        }
//    }
//
//    /** Returns whether the queue is empty. */
//    public boolean empty() {
//        return s1.isEmpty() && s2.isEmpty();
//    }



    // Next Greater Element I
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        if(findNums==null) return findNums;
        for(int i = 0; i<findNums.length; i++)
        {
            boolean flag = false;
            for(int j = 0; j<nums.length; j++)
            {
                if(flag)
                {
                    if(nums[j]>findNums[i])
                    {
                        findNums[i]=nums[j];
                        break;
                    }
                }
                else
                {
                    if(findNums[i]==nums[j])
                        flag = true;
                }

                if(j==nums.length-1)
                    findNums[i]=-1;
            }
        }
        return findNums;
    }


    // Medium Stack

    // Evaluate Reverse Polish Notation
    public int evalRPN(String[] tokens) {
        if(tokens==null||tokens.length==0) return 0;
        Stack<Integer> stack = new Stack<>();
        int a, b;
        for (int i = 0; i <tokens.length; i++) {
            String s = tokens[i];
            if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/"))
            {
                b = stack.pop();
                a = stack.pop();
                if(s.equals("+"))
                    stack.push(a+b);
                else if (s.equals("-"))
                    stack.push(a-b);
                else if (s.equals("*"))
                    stack.push(a*b);
                else
                    stack.push(a/b);
            }
            else
                stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }

    public String decodeString(String s) {
        String[] sar = s.split("]|\\[");
        for (int i = 0; i < sar.length; i++) {

        }
        return "";
    }

// Flatten Nested List Iterator
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {

        public NestedIterator(List<NestedInteger> nestedList) {
            rec(nestedList);
            Stack<Integer> temp = new Stack<>();
            while(!stack.isEmpty())
                temp.push(stack.pop());
            stack=temp;
        }

        Stack<Integer> stack = new Stack<>();
        public void rec(List<NestedInteger> nestedList) {
            for (int i = 0; i < nestedList.size(); i++) {
                if (nestedList.get(i).isInteger())
                    stack.push(nestedList.get(i).getInteger());
                else
                    rec(nestedList.get(i).getList());
            }
        }
        @Override
        public Integer next() {
            return stack.pop();
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

}



