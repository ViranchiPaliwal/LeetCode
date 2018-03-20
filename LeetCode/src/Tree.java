import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
public class Tree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> l = new ArrayList<Double>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int len = 0, i = 0;
        Double sum=0.0;
        while(!q.isEmpty()){
            len = q.size();
            while(len>i){
                TreeNode n = q.poll();
                sum+=n.val;
                if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
                i++;
            }
            l.add(sum/len);
            sum=0.0;
            i=0;
        }
        return l;
    }

    int max = 0;
    public int maxDepth(TreeNode root) {
        findMax(root,0);
        return max;
    }
    public void findMax(TreeNode root, int soFar){
        if(root==null){
            max = Math.max(max,soFar);
            return;
        }
        findMax(root.left,soFar+1);
        findMax(root.right,soFar+1);

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums==null||nums.length==0){
            return null;
        }
        return mbt(nums,0,nums.length-1);
    }

    public TreeNode mbt(int[] n, int l, int h){
        if(l>h){return null;}
        int mid = indexer(n,l,h);
        TreeNode root = new TreeNode(n[mid]);
        root.left=mbt(n,l,mid-1);
        root.right=mbt(n,mid+1,h);
        return root;
    }

    public int indexer(int[] n, int l, int h){
        int max = Integer.MIN_VALUE, in = -1;
        for(int i=l;i<=h;i++){
            if(max<n[i]){
                max=n[i];
                in=i;
            }
        }
        return in;
    }

    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode temp = root.left;
        root.left=invertTree(root.right);
        root.right=invertTree(temp);
        return root;
    }
}
