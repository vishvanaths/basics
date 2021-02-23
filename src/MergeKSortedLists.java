public class MergeKSortedLists {
    public static void main(String[] args) {
        int[][] lists = {{1, 4, 5}, {1, 3, 4}, {2, 6}};
        ListNode[] ls = new ListNode[lists.length];
        int i=0;
        for(int[] l1 : lists){
            ls[i++] = createList(l1);
        }

        printList(ls[0]);
        printList(ls[1]);
        printList(ls[2]);
        printList(mergeTwoLists(ls[0], ls[1]));
        printList(mergeKLists(ls));
    }

    public static ListNode createList(int[] list) {
        ListNode nList = null;
        ListNode tmp = null;
        for (int i : list) {
            if (nList == null) {
                nList = new ListNode(i);
                tmp = nList;
            } else {
                tmp.next = new ListNode(i);
                tmp = tmp.next;
            }
        }
        return nList;
    }

    private static void printList(ListNode list) {
        System.out.print("[");
        while (list != null) {
            System.out.print(list.val + ",");
            list = list.next;
        }
        System.out.println("null]");
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeHelper(lists, 0, lists.length - 1);
    }

    private static ListNode mergeHelper(ListNode[] lists, int l, int r) {
        if (l >= r) return lists[l]; //corner case
        int m = l + (r - l) / 2;
        ListNode l1 = mergeHelper(lists, l, m);
        ListNode l2 = mergeHelper(lists, m + 1, r);
        return mergeTwoLists(l1, l2);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode nList = null, temp = null;

        if(list1 == null){
            return list2;
        }

        if(list2 == null){
            return list1;
        }

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                if (nList == null) {
                    nList = temp = new ListNode(list1.val);
                } else {
                    temp.next = new ListNode(list1.val);
                    temp = temp.next;
                }
                list1 = list1.next;
            } else {
                if (nList == null) {
                    nList = temp = new ListNode(list2.val);
                } else {
                    temp.next = new ListNode(list2.val);
                    temp = temp.next;
                }
                list2 = list2.next;
            }
        }

        while (list1 != null) {
            temp.next = new ListNode(list1.val);
            temp = temp.next;
            list1 = list1.next;
        }

        while (list2 != null) {
            temp.next = new ListNode(list2.val);
            temp = temp.next;
            list2 = list2.next;
        }

        return nList;
    }


}

/**
 * Definition for singly-linked list.
 **/
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}