import java.util.Arrays;

/**
 * Created by viran on 03-07-2017.
 */
public class DynamicProgramming {

    // Ones and Zeroes
    public int findMaxForm(String[] strs, int m, int n) {
        int s = strs.length;
        if(strs==null||s==0)
            return 0;
        int mat[][][] = new int [s+1][m+1][n+1];

        for (int i = 0; i <=s; i++) {
            int one = 0, zero = 0;
            if(i>0)
            {
                for (int l = 0; l < strs[i-1].length(); l++) {
                    if(strs[i-1].charAt(l)=='0')
                        zero++;
                    else
                        one++;
                }
                for (int j = 0; j <= m; j++) {
                    for (int k = 0; k <= n; k++) {
                        if (i == 0)
                            mat[i][j][k] = 0;
                        else if (j >= zero&&k>=one)
                            mat[i][j][k] = Math.max(mat[i-1][j-zero][k-one]+1,mat[i-1][j][k]);
                        else
                            mat[i][j][k] = mat[i-1][j][k];
                    }
                }
            }
        }
        return mat[s][m][n];
    }

    public int lengthOfLIS(int[] nums) {

        if(nums==null || nums.length==0)
            return 0;
        int l = nums.length;
        int m[][] = new int[l][l];
        for (int i = 0; i < l; i++) {
            m[i][i]=1;
        }
        int max=0;
        for (int i = 0; i < l; i++) {
            for (int j = i+1; j < l; j++) {
                if(nums[j]>nums[j-1])
                    m[i][j]=m[i][j-1]+1;
                else
                    m[i][j]=m[i][j-1];
                if(m[i][j]>max)
                    max=m[i][j];

                Arrays.fill(m,1);

            }
        }
        return max;
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums==null||nums.length==0)
            return false;
        int l = nums.length;
        int m[][] = new int[l][l];
        for (int i = 0; i <l ; i++) {
            m[i][i]=nums[i];
            for (int j = i+1; j < l; j++) {
                m[i][j]=m[i][j-1]+nums[j];
                if(m[i][j]%k==0)
                    return true;
            }
        }
        return false;
    }

    public void reorderList(ListNode head) {
//        if(head==null||head.next==null||head.next.next==null)
//            return;
//        ListNode temp = head.next;
//        head.next = rec(head.next,head.next.next);
//        head.next.next=temp;
        if(head==null||head.next==null)
            return;
        ListNode s = head;
        ListNode f = head;

        while(f.next!=null&&f.next.next!=null)
        {
            s=s.next;
            f=f.next.next;
        }

        f=s.next;
        // swapping two terms at a time after s
        while(f.next!=null)
        {
            ListNode n = f.next;
            f.next=n.next;
            n.next=s.next;
            s.next=n;
        }

        ListNode h = head;
        f=s.next;
        while(h!=s)
        {
            s.next=f.next;
            f.next=h.next;
            h.next=f;
            h=f.next;
            f=s.next;
        }
    }

    public ListNode rec(ListNode s, ListNode f)
    {
        if(f.next==null||f.next.next==null)
        {
            ListNode v;
            if(f.next==null)
                v = s.next;
            else
                v = s.next.next;
            s.next = null;
            return v;
        }
        ListNode temp = s.next;
        ListNode value = rec(s.next,f.next.next);
        s.next=value;
        ListNode rvalue = value.next;
        value.next=temp;
        return rvalue;
    }

    public int numSquares(int n) {
        int[] ar = {1,4,9};
        return recu(n,ar);
    }

    private int recu(int n, int[] ar) {
        if(n<1)
            return n==0?0:Integer.MAX_VALUE;
        int count =Integer.MAX_VALUE;
        int v = 0;
        for (int i = 0; i < ar.length; i++) {
            v = recu(n-ar[i],ar);
            count = Math.min(count,v);
        }
        return 1+count;
    }


}
