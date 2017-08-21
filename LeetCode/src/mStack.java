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

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
//        q1.add(x);
//        top = x;

        q1.add(x);
        int size = q1.size();
        while (size > 1) {
            int y = q1.remove();
            q1.add(y);
            size--;
        }


    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
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

    /**
     * Get the top element.
     */
    public int top() {
        // return top;

        return q1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.isEmpty();
    }


    // Valid Parentheses
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(s.charAt(i));
            } else if (stack.isEmpty() || c == ')' && stack.peek() != '('
                    || c == '}' && stack.peek() != '{'
                    || c == ']' && stack.peek() != '[')
                return false;
            else
                stack.pop();
        }
        return stack.isEmpty() ? true : false;
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
        if (findNums == null) return findNums;
        for (int i = 0; i < findNums.length; i++) {
            boolean flag = false;
            for (int j = 0; j < nums.length; j++) {
                if (flag) {
                    if (nums[j] > findNums[i]) {
                        findNums[i] = nums[j];
                        break;
                    }
                } else {
                    if (findNums[i] == nums[j])
                        flag = true;
                }

                if (j == nums.length - 1)
                    findNums[i] = -1;
            }
        }
        return findNums;
    }


    // Medium Stack

    // Evaluate Reverse Polish Notation
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int a, b;
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                b = stack.pop();
                a = stack.pop();
                if (s.equals("+"))
                    stack.push(a + b);
                else if (s.equals("-"))
                    stack.push(a - b);
                else if (s.equals("*"))
                    stack.push(a * b);
                else
                    stack.push(a / b);
            } else
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
//    public interface NestedInteger {
//
//        // @return true if this NestedInteger holds a single integer, rather than a nested list.
//        public boolean isInteger();
//
//        // @return the single integer that this NestedInteger holds, if it holds a single integer
//        // Return null if this NestedInteger holds a nested list
//        public Integer getInteger();
//
//        // @return the nested list that this NestedInteger holds, if it holds a nested list
//        // Return null if this NestedInteger holds a single integer
//        public List<NestedInteger> getList();
//    }
//
//    public class NestedIterator implements Iterator<Integer> {
//
//        public NestedIterator(List<NestedInteger> nestedList) {
//            rec(nestedList);
//            Stack<Integer> temp = new Stack<>();
//            while(!stack.isEmpty())
//                temp.push(stack.pop());
//            stack=temp;
//        }
//
//        Stack<Integer> stack = new Stack<>();
//        public void rec(List<NestedInteger> nestedList) {
//            for (int i = 0; i < nestedList.size(); i++) {
//                if (nestedList.get(i).isInteger())
//                    stack.push(nestedList.get(i).getInteger());
//                else
//                    rec(nestedList.get(i).getList());
//            }
//        }
//        @Override
//        public Integer next() {
//            return stack.pop();
//        }
//
//        @Override
//        public boolean hasNext() {
//            return !stack.isEmpty();
//        }
//    }

    public interface NestedInteger {
        // Constructor initializes an empty nested list.
        //public NestedInteger();

        // Constructor initializes a single integer.
        //public NestedInteger(int value);

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    NestedInteger n = new NestedInteger() {
        @Override
        public boolean isInteger() {
            return false;
        }

        @Override
        public Integer getInteger() {
            return null;
        }

        @Override
        public void setInteger(int value) {

        }

        @Override
        public void add(NestedInteger ni) {

        }

        @Override
        public List<NestedInteger> getList() {
            return null;
        }
    };

    public NestedInteger deserialize(String s) {
        Stack<NestedInteger> st = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == '[') {
                NestedInteger n = new NestedInteger() {
                    @Override
                    public boolean isInteger() {
                        return false;
                    }

                    @Override
                    public Integer getInteger() {
                        return null;
                    }

                    @Override
                    public void setInteger(int value) {

                    }

                    @Override
                    public void add(NestedInteger ni) {

                    }

                    @Override
                    public List<NestedInteger> getList() {
                        return null;
                    }
                };

                st.push(n);
                index++;
            } else if (Character.isDigit(s.charAt(index))||s.charAt(index)=='-') {
                int present = index;
                index++;
                while (index < s.length()&&Character.isDigit(s.charAt(index))) {
                    index++;
                }
                NestedInteger n1 = new NestedInteger() {
                    @Override
                    public boolean isInteger() {
                        return false;
                    }

                    @Override
                    public Integer getInteger() {
                        return null;
                    }

                    @Override
                    public void setInteger(int value) {

                    }

                    @Override
                    public void add(NestedInteger ni) {

                    }

                    @Override
                    public List<NestedInteger> getList() {
                        return null;
                    }
                };

                n1.setInteger(Integer.parseInt(s.substring(present, index)));
                if(st.size()>0)
                {
                    NestedInteger n = st.pop();
                n.add(n1);
                st.push(n);
                }
                else{
                    st.push(n1);
                }
                if (index < s.length()&&s.charAt(index) == ']')
                    index++;
            } else if (s.charAt(index) == ']') {

                NestedInteger n1 = st.pop();
                NestedInteger n2 = st.pop();
                n2.add(n1);
                st.push(n2);
                index++;
            } else {
                index++;
            }
        }
        return st.pop();
    }

    public int c(int[] calories)
    {
    //    Integer.MAX_VALUE
//if(calories!=null)
//        //Integer[] what = Arrays.stream( calories ).boxed().toArray( Integer[]::new );
//        Arrays.sort(what,Collections.reverseOrder());
//        int miles = 0;
//        for (int i = 0; i <what.length; i++) {
//            miles+=Math.pow(2,i)*what[i];
//
//        }
//
//        System.out.println( miles);
        return 0;
    }



    public int b(int n, int[] ar)
    {
        int[] a = new int[6];
        for (int i = 0; i < n; i++) {
            a[ar[i]]++;
        }
        int v = a[1];
        int index =1;
        for (int i = 1; i < 6; i++) {
               if(a[i]>v)
               {
                   v=a[i];
                   index=i;
               }
        }
        return index;
    }

    public String a(String s)
    {
        if(s.isEmpty()||s.length()==0) return "NO";
        HashMap<Character,Integer> h = new HashMap<>();
        char[] c = s.toCharArray();
        for(char ch : c)
        {
            if(h.containsKey(ch))
            {
                int v = h.get(ch);
                v++;
                h.put(ch,v);
            }
            else {
                h.put(ch, 1);
            }
        }
        int count = 0;
        for(int v : h.values())
        {
            if(v%2!=0)
            {
                count++;
            }
        }

        if(count>1)
            return "NO";
        else
            return "YES";
     }

    List<String> results;
    public List<String> letterCombinations(String digits) {
        results = new ArrayList<>();
        if(digits.isEmpty()) return results;
        int len = digits.length();
        String[] input = new String[len];
        for(int i=0;i<len;i++)
        {
            switch(digits.charAt(i)) {
                case '2' :
                    input[i]="abc";
                    break;
                case '3' :
                    input[i]="def";
                    break;
                case '4' :
                    input[i]="ghi";
                    break;
                case '5' :
                    input[i]="jkl";
                    break;
                case '6' :
                    input[i]="mno";
                    break;
                case '7' :
                    input[i]="pqrs";
                    break;
                case '8' :
                    input[i]="tuv";
                    break;
                case '9' :
                    input[i]="wxyz";
                    break;

            }
        }
        char[] sofar = new char[len];
        comRec(input, sofar, 0);
        return results;
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> l = new ArrayList<>();
        Map<String,Integer> m = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String s = sort(strs[i]);
            if(m.containsKey(s)){
                l.get(m.get(s)).add(strs[i]);
            }
            else{
                m.put(s,l.size());
                List<String> ls = new ArrayList<>();
                ls.add(strs[i]);
                l.add(ls);
            }
        }
        return l;
    }

    public String sort(String original){
        char[] chars = original.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
    }

    public int countSubstrings(String s) {
        int l = s.length();
        int[][] m  = new int[l][l];
        int count=0;
        for(int i= 0; i<l;i++)
        {
            m[i][i]=1;
        }
        int k =0;
        for(int j =0;j<l;j++)
        {
            k=j;
            for(int i =0;i<l-j;i++)
            {

                if(s.charAt(i)==s.charAt(k)&&(i+1>k-1||m[i+1][k-1]>0))
                {
                    m[i][k]=1;
                    count+=1;
                }
                else{
                    m[i][k]=0;
                }
                k++;
            }
        }
        return count;

    }

    public void comRec(String[] input, char[] sofar, int level)
    {
        if(level==input.length) {
            results.add(Arrays.toString(sofar));
            return;
        }
        for(int i = 0; i<input[level].length();i++)
        {
            sofar[level]=input[level].charAt(i);
            comRec(input,sofar,level+1);
        }
    }

    public int lengthOfLongestSubstring(String s) {
//        Set<Character> set = new HashSet<>();
//        s.isEmpty();
//        int count = 0;
//        for(int i=0;i<s.length();i++) {
//            for (int j = i; j < s.length(); j++) {
//                if (set.contains(s.charAt(j))) {
//                    if (set.size() > count)
//                        count = set.size();
//                    set.clear();
//                } else
//                    set.add(s.charAt(j));
//            }
//        }
//        return count;
        if(s.isEmpty()) return 0;
        Set<Character> set = new HashSet<>();
        int count = 0;
        for(int i=0;i<s.length();i++) {
            for (int j = i; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    set.clear();
                } else{
                    set.add(s.charAt(j));
                    if (set.size() > count)
                        count = set.size();}
            }
            set.clear();
        }
        return count;
    }
//                     s = s.substring(1, s.length() - 1);
//                     if (s.length() == 0)
//                         return n;
//                     String[] str = s.split(",");
//                     for (int i = 0; i < str.length; i++) {
//                         n.add(deserialize(str[i]));
//                     }
//                 } else {
//                     n.setInteger(Integer.parseInt(s));
//                 }
//                 return n;



}



