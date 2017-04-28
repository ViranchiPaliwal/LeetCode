/**
 * Created by viran on 24-04-2017.
 */
import java.util.*;
public class Code {

    int count = 0;
    public int maxDepth(TreeNode root) {
        if(root!=null)
        {
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        }
        else
        {
            return 0;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }

    int tilt = 0;
    public int findTilt(TreeNode root) {
        findTiltRec(root);
        return tilt;
    }
    public int findTiltRec(TreeNode root)
    {
        if (root==null) return 0;
        int suml = findTiltRec(root.left);
        int sumr = findTiltRec(root.right);
        tilt += Math.abs(suml-sumr);
        return root.val + suml + sumr;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) { return ((p==null) == (q==null));}
        else if(p.val==q.val)
        {
            return (isSameTree(p.left,q.left)&&isSameTree(p.right,q.right));
        }
        else
        {
            return false;
        }

    }

    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        findDiameterRec(root);
        return diameter;

    }
    public int findDiameterRec(TreeNode root)
    {
        if(root == null) return 0;
        int left = findDiameterRec(root.left);
        int right = findDiameterRec(root.right);
        diameter = Math.max(diameter, left+right);
        return Math.max(left,right)+1;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return makeTree(nums,0,nums.length-1);
    }

    public TreeNode makeTree(int[] arr,int s,int e)
    {
        if(s>e)
        {return null;}
        int mid = (s+e)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = makeTree(arr,s,mid-1);
        root.right = makeTree(arr,mid+1,e);
        return root;
    }

    List<Integer> level = null;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        int h = findHeight(root);
        List<List<Integer>> b = new ArrayList<List<Integer>>();
        for(int i=h;i>0;i--)
        {
            level = new ArrayList<Integer>();
            foo(root,i);
            b.add(level);
        }
        return b;
    }
    public void foo(TreeNode root,int i)
    {
        if(root != null)
        {
            if(i==1)
            {
                level.add(root.val);
            }
            foo(root.left,i-1);
            foo(root.right,i-1);
        }

    }
    public int findHeight(TreeNode root)
    {
        if (root == null) return 0;
        int l = findHeight(root.left);
        int r = findHeight(root.right);

        return Math.max(l,r)+1;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        while(root!=null)
        {
            if(root.val>p.val && root.val > q.val)
                root = root.left;
            else if (root.val<p.val && root.val < q.val)
                root = root.right;
            else
                return root;
        }
        return null;
    }

    Map<Integer,Integer> m = new HashMap();
    int max = 1;
    public int[] findMode(TreeNode root) {
        traverse(root);
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(Map.Entry<Integer,Integer> h : m.entrySet())
        {
            if(h.getValue()==max)
            {
                a.add(h.getKey());
            }
        }
        int[] key = new int[a.size()];
        for(int i=0;i<a.size();i++)
            key[i]= a.get(i).intValue();
        return key;
    }
    public void traverse(TreeNode root)
    {
        if(root==null) return;
        int key = root.val;
        if(m.containsKey(key))
        {
            int value = m.get(key);
            m.put(key,value+1);
            if(value>=max)
                max=value+1;
        }
        else
            m.put(root.val,1);
        traverse(root.left);
        traverse(root.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return sameNode(root.left,root.right);
    }
    public boolean sameNode(TreeNode l, TreeNode r)
    {
        if(l == null || r == null)
        {
            if(l == null && r == null)
                return true;
            else
                return  false;
        }
        else if(l.val == r.val)
        {
            return sameNode(l.left,r.right) && sameNode(l.right,r.left);
        }
        else
            return false;
    }

    List<String> a = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        // if(root == null) return a;
        String l = new String();
        path(root,l);
        return a;

    }
    public void path(TreeNode root,String psf)
    {
        if(root==null) return;

        if(psf.isEmpty())
            psf=Integer.toString(root.val);
        else
            psf+="->"+Integer.toString(root.val);

        if(root.left == null && root.right == null)
            a.add(psf);
        else
        {
            path(root.left,psf);
            path(root.right,psf);
        }
    }

    public int minDepth(TreeNode root) {

        if (root == null) return 0;
        return min(root);

    }

    public int min(TreeNode root)
    {

        if(root.left == null || root.right == null)
        {
            if(root.left == null && root.right == null)
                return 1;
            else if(root.left!=null)
                return min(root.left)+1;
            else
                return min(root.right)+1;
        }
        else
            return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }

}
