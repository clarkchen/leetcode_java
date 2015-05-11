package MergeKSortedList;
import  MergeKSortedList.ListNode;
/**
 * Created by chenxi on 15/5/7.
 */
public class Solution{

    int left(int i) {
        return 2*i+1;
    }
    int right(int i){
        return 2*i+2;
    }
    void removeMin(int heapSize,ListNode nodes[]){
        nodes[0]=nodes[heapSize];
        Heapify(nodes,0,heapSize);
    }
    void Heapify(ListNode nodes[],int i,int heapSize){
        int l=left(i);
        int r=right(i);
        int smallest;
        ListNode temp;
        while(l<heapSize){
            if(nodes[i].val>nodes[l].val)
                smallest=l;
            else
                smallest=i;
            if(r<heapSize&&nodes[r].val<nodes[smallest].val)
                smallest=r;
            if(smallest==i)
                break;
            else{
                temp=nodes[smallest];
                nodes[smallest]=nodes[i];
                nodes[i]=temp;
                i=smallest;
                l=left(i);
                r=right(i);
            }
        }
    }
    void buildHeap(ListNode nodes[],int heapSize){
        for(int i=nodes.length/2-1;i>=0;i--){
            Heapify(nodes,i,heapSize);
        }
    }
    ListNode heapTop(ListNode nodes[]){
        return nodes[0];
    }
    void insertIntoTop(ListNode p, ListNode nodes[], int heapSize){
        nodes[0]=p;
        Heapify(nodes,0,heapSize);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;

        int heapSize;
        ListNode p;
        ListNode newpointer = new ListNode(0);
        ListNode head = newpointer;
        ListNode nodes[] = new ListNode[lists.length];
        int i=0,j=0;
        while(j<lists.length){
            if(lists[j]==null)
                j++;
            else{
                nodes[i]=lists[j];
                j++;
                i++;
            }
        }
        heapSize=i;
        if(i==0){
            return null;
        }
        buildHeap(nodes, heapSize);
        while(heapSize>1){
            p=heapTop(nodes);
            newpointer.next=p;
            newpointer=newpointer.next;
            if(p.next!=null){
                insertIntoTop(p.next, nodes, heapSize);
            }
            else{
                heapSize--;
                removeMin(heapSize, nodes);
            }

        }
        p=heapTop(nodes);
        newpointer.next=p;
        return head.next;


    }
}