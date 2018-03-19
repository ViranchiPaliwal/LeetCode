
import java.util.Stack;

/**
 * Created by viran on 06-07-2017.
 */
class LinkedList {

    public ListNode partition(ListNode head, int x) {
        if(head==null)
            return null;
        ListNode small=null;
        ListNode big=null;
        ListNode st=null;
        ListNode bt=null;
        while(head!=null)
        {
            if(head.val<x)
            {
                if(small==null)
                {
                    small=head;
                    st=small;
                }
                else
                {
                    st.next=head;
                    st=st.next;
                }
            }
            else
            {
                if(big==null)
                {
                    big=head;
                    bt=big;
                }
                else
                {
                    bt.next=head;
                    bt=bt.next;
                }
            }
            head=head.next;
        }

        if(big!=null)
            bt.next=null;

        if(small!=null)
        {
            st.next=big;
            return small;
        }
        else
            return big;
    }

    public ListNode detectCycle(ListNode head) {

        ListNode s = head;
        ListNode f = head;

        while(f.next!=null&&f.next.next!=null)
        {
            s=s.next;
            f=f.next.next;
            if(s==f)
                break;
        }
        if(s!=f)
            return null;
        s=head;
        while(s!=f)
        {
            s=s.next;
            f=f.next;
        }
        return s;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode node = head;
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode dtail = dummy;
        while(node!=null&&node.next!=null)
        {
            ListNode current= node.next;
            node.next=current.next;
            node = current.next;
            current.next=dtail.next;
            dtail.next=current;
            dtail = dtail.next.next;
        }
    return dummy.next;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode hl3 = new ListNode(0);
        ListNode l3=hl3;
        int r=0;
        while(l1!=null&&l2!=null)
        {
            int val = l1.val + l2.val+r;
            r=val/10;
            val=val%10;
            ListNode n = new ListNode(val);
          //  n.next = l3.next;
            l3.next=n;
            l1=l1.next;
            l2=l2.next;
            l3=l3.next;
        }
        while(l1!=null)
        {
            int val = l1.val+r;
            ListNode n = new ListNode(val);
       //     n.next = l3.next;
            l3.next=n;
            r=0;
            l1=l1.next;
            l3=l3.next;
        }
        while(l2!=null)
        {
            int val = l2.val+r;
            ListNode n = new ListNode(val);
       //     n.next = l3.next;
            l3.next=n;
            r=0;
            l2=l2.next;
            l3=l3.next;
        }
        if(r!=0)
            l3.next=new ListNode(r);
        return hl3.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1!=null)
        {
            s1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null)
        {
            s2.push(l2.val);
            l2=l2.next;
        }

        ListNode hl3 = new ListNode(0);
        ListNode l3 = hl3;

        int r=0;
        while(!s1.isEmpty()||!s2.isEmpty())
        {
            int val = r;
            if(!s1.isEmpty())
            val +=  s1.pop();
            if(!s2.isEmpty())
                val +=  s2.pop();
            r=val/10;
            val=val%10;
            ListNode n = new ListNode(val);
            n.next = l3.next;
            l3.next=n;
        }

        return hl3.next;

    }

    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode odd = head;
        ListNode heven = head.next;
        ListNode even = head.next;

        while(odd!=null&&even!=null&&odd.next!=null&&even.next!=null)
        {
            odd.next=odd.next.next;
            odd=odd.next;
            even.next=even.next.next;
            even=even.next;
        }
        odd.next=heven;
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode hdummy = new ListNode(0);
        hdummy.next=head;
        ListNode tdummy = hdummy;
       while(head!=null&&head.next!=null)
       {
           if(head.val==head.next.val)
           {
               int v = head.val;
               while(head!=null&&head.val==v)
                   head=head.next;
               tdummy.next=head;
           }
           else
           {
               tdummy=tdummy.next;
               head=head.next;
           }
       }
       return hdummy.next;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode prev = dummy;
        int count = 0;
        while(count<m-1)
        {
            prev=prev.next;
            count++;
        }
        ListNode current = prev.next;
        count++;
        while(count!=n)
        {
            ListNode nxt = current.next;
            current.next= nxt.next;
            nxt.next=prev.next;
            prev.next=nxt;
            count++;
        }
        return dummy.next;
    }


}
