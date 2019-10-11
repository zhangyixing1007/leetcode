/**
* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode(int x) { val = x; }
* }
*/
class Solution
{
    public ListNode sortList(ListNode head)
    {
        List<Integer> list = new ArrayList<>();
        ListNode record = head;
        while (head!=null)
        {
            list.add(head.val);
            head = head.next;
        }
        // int [] arr = list.toArray(new int[0]);
        int[] arr = new int[list.size()];
        for (int i =0; i < list.size(); i++)
        arr[i] = list.get(i);
        
        int curr = 0;
        while (curr <= arr.length)
        {
            for (int i = arr.length - curr; i>1; i--)
            {
                if (arr[i-1 + curr]<arr[i/2-1 +curr])
                {
                    int tmp = arr[i-1 + curr];
                    arr[i-1 + curr] = arr[i/2-1 + curr];
                    arr[i/2-1 +curr] = tmp;
                }
            }
            curr++;
        }
        
        curr = 0;
        
        head = record;
        while (head!=null)
        {
            head.val = arr[curr];
            head = head.next;
            curr++;
        }
        
        return record;
    }
}
