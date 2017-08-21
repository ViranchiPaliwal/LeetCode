import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by viran on 10-07-2017.
 */
public class mArray {
    public int minimumTotal(List<List<Integer>> triangle) {

        if(triangle==null) return 0;

         int value = triangle.get(0).get(0) + minimumTotal1(triangle.get(1),0,2,triangle);
         return value;
    }
    public int minimumTotal1(List<Integer> l, int index, int pos, List<List<Integer>> triangle)
    {
        if(triangle.size()<=pos)
            return 0;
        int value = Math.min(l.get(index)+ minimumTotal1(triangle.get(pos),index,pos+1,triangle),
                l.get(index+1)+ minimumTotal1(triangle.get(pos),index+1,pos+1,triangle));
        return value;
    }

    // minSubArrayLen

    public int minSubArrayLen(int s, int[] nums) {

//        if(nums==null||nums.length==0) return 0;
//        int d = Integer.MAX_VALUE;
//        int running = 0;
//        Map<Integer,Integer> h = new HashMap<>();
//        for(int i = 0; i<nums.length;i++)
//        {
//            running+=nums[i];
//            if(running>=s)
//            {
//                if(running == s && d>i+1)
//                {
//                    d = i+1;
//                }
//                else
//                {
//                    int key = running -s;
//                    if(h.containsKey(key))
//                    {
//                        int index = h.get(key);
//                        if(d>i-index){
//                            d = i-index;
//                        }
//                    }
//                }
//            }
//
//            h.put(running,i);
//        }
//        return d==Integer.MAX_VALUE?0:d;
        if(nums==null||nums.length==0) return 0;
        int d = Integer.MAX_VALUE;
        int running = 0;
        int l = nums.length;
        int[] h = new int[l];
        for(int i = 0; i<l;i++)
        {
            running+=nums[i];
            if(running>=s)
            {
                if(running >= s && d>i+1)
                {
                    d = i+1;
                }
                else
                {
                    int v = running -s;
                    for(int j=i-1;j>0;j--){
                        if(running-nums[j]>=s)
                        {
                            if(d>i-j)
                                d=i-j;

                        }
                        else
                            break;
                    }

                }
            }
        }
        return d==Integer.MAX_VALUE?0:d;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        if(nums==null) return null;
//        List<List<Integer>> l = new ArrayList<>();
//        Set<List<Integer>> set = new HashSet<>();
//        int len = nums.length;
//        for(int i=0;i<len;i++)
//        {
//            for(int j = i;j<len;j++)
//            {
//                List<Integer> t = new ArrayList<>();
//                int temp = i;
//                while(temp<=j){
//                    t.add(nums[j]);
//                    temp++;
//                }
//                if(!set.contains(t))
//                {
//                    l.add(t);
//                    set.add(t);
//                }
//            }
//        }
//        l.add(new ArrayList<>());
//        return l;

        // there are 2^n different set possible
        // https://www.mathsisfun.com/activity/subsets.html
        // pascal traingle to confirm number of set

        // 1<<n we looping for 2^n times
        // for each time checking which are one adding them to list
        if(nums==null) return null;
        List<List<Integer>> l = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int len = nums.length;
        for(int i=0;i<1<<len;i++)
        {
            List<Integer> t = new ArrayList<>();
            for(int j=0;j<len;j++)
            {
                if((i&(1<<j))>0)
                {
                    t.add(nums[j]);
                }
            }
            if(!set.contains(t))
            {
                l.add(t);
                set.add(t);
            }

            // int temp = i;
            // while(temp<len)
            // {
            //     List<Integer> t = new ArrayList<>();
            //     int temp2 = i;
            //     while(temp2<=temp)
            //     {
            //         t.add(nums[temp2]);
            //         temp2++;
            //     }
            //     if(!set.contains(t))
            //         {
            //             l.add(t);
            //             set.add(t);
            //         }
            //     temp++;
            // }
        }

        return l;

//         if(nums==null) return null;
//         List<List<Integer>> l = new ArrayList<>();
//         Set<List<Integer>> set = new HashSet<>();
//         int len = nums.length;
//         for(int i=0;i<len;i++)
//         {
//             int temp = i;
//             while(temp<len)
//             {
//                 List<Integer> t = new ArrayList<>();
//                 int temp2 = i;
//                 while(temp2<=temp)
//                 {
//                     t.add(nums[temp2]);
//                     temp2++;
//                 }
//                 if(!set.contains(t))
//                     {
//                         l.add(t);
//                         set.add(t);
//                     }
//                 temp++;
//             }
//         }

//         l.add(new ArrayList<>());
//         return l;
    }

    public int search(int[] nums, int target) {
        if(nums==null) return -1;
        int l = 0,h=nums.length-1,mid=0;

        while(l<=h)
        {
            if(l==h)
            {
                if(nums[l]==target)
                    return l;
                else
                    return -1;
            }
            if(nums[l]<nums[h]&&target>nums[h])
                return -1;
            mid = (l+h)/2;
            if(nums[mid]==target)
                return mid;

            HashMap<Integer,Integer> m = new HashMap<>();
           // m.containsKey()
            if(nums[mid]>=nums[l])
            {
                if(target<nums[mid])
                    h=mid;
                else
                    l=mid+1;
            }
            else
            {
                if(target>nums[mid])
                    h=mid;
                else
                    l=mid+1;
            }
        }
        return -1;
    }
}
