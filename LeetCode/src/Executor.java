/**
 * Created by viran on 06-03-2017.
 */
public class Executor {
    public static void main(String[] args) {
//        TreeNode a = new TreeNode(2);
//        TreeNode b = new TreeNode(2);
//        TreeNode c = new TreeNode(4);
//        TreeNode d = new TreeNode(5);
//        TreeNode e = new TreeNode(6);
//        TreeNode f = new TreeNode(7);
//        a.left = b;
//        a.right = c;
//        b.left = d;
//        b.right = e;
//        c.left = f;
//        Code obj = new Code();
        //obj.levelOrderBottom(a);
        //obj.levelOrder(a);
        //int i = obj.findBottomLeftValue(a);
        // obj.greatestLevelValue(a);
        //obj.findMode(a);
        //obj.binaryTreePaths(a);

        //for linked list
//        ListNode a = new ListNode(2);
//        ListNode b = new ListNode(2);
//        ListNode c = new ListNode(4);
//        ListNode d = new ListNode(5);
//        ListNode e = new ListNode(6);
//        ListNode f = new ListNode(7);
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
//        e.next = f;
//        Code obj = new Code();
//        obj.getIntersectionNode(a,f);
//

//        DynamicProgramming d = new DynamicProgramming();
//        String[] str = new String[]{"10", "0", "1"};
//        d.findMaxForm(str,1,1);
//
//        DynamicProgramming e = new DynamicProgramming();
//        int[] a = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
//        d.lengthOfLIS(a);

//        DynamicProgramming f = new DynamicProgramming();
//        int[] ar = new int[]{23, 2, 6, 4, 7};
//        //  f.checkSubarraySum(ar,6);
//
//
//        ListNode a = new ListNode(1);
//        ListNode b = new ListNode(2);
//        ListNode c = new ListNode(3);
//        ListNode d = new ListNode(4);
//
//        ListNode e = new ListNode(5);
//        ListNode h = new ListNode(6);
//        ListNode i = new ListNode(7);
//
////        ListNode a = new ListNode(1);
////        ListNode b = new ListNode(2);
////        ListNode c = new ListNode(3);
////        ListNode d = new ListNode(3);
////
////        ListNode e = new ListNode(5);
////        ListNode h = new ListNode(7);
////        ListNode i = new ListNode(7);
//
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
//        e.next = h;
//        h.next = i;
//        i.next=null;
//
//        // f.reorderList(a);
//
//        LinkedList o = new LinkedList();
//        //o.detectCycle(a);
//
//        //  o.swapPairs(a);
//        // o.addTwoNumbers2(b,e);
//        //   o.oddEvenList(a);
//        // o.deleteDuplicates(a);
//        o.reverseBetween(a,3,6);
//
//
//        Arrays arrobjj = new Arrays();
//        //   ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>(new ArrayList<Integer>(Arrays));
//        //    objj.minimumTotal([[-1],[2,3],[1,-1,-3]])
//


//----------------- STACK----------------------------//
        mStack obj = new mStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();

        boolean ba =obj.isValid("[{()}]");

        int[] ar1 = {4,1,2};
        int [] ar2 = {1,3,4,2};
        obj.nextGreaterElement(ar1,ar2);

    }



}
