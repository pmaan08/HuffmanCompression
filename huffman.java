import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;

//node class for each node present in Huffman-tree
class HuffmanNode
{
    int freq;
    char c;
 
    //Instantiation of left and right chil
    HuffmanNode leftchild;
    HuffmanNode rightchild;

}
 //Comparator class helps us compare on basis of values in java
 class MyComparator implements Comparator<HuffmanNode>
 {
     // x is left child & y is right child
    public int compare(HuffmanNode x , HuffmanNode y)
     {
         return x.freq - y.freq;
     }
 }

 public class Huffman
 {
    //print fucntion
    public static void printCode(HuffmanNode root, String s)
    {
        //if left and right are null
        //then it is a leaf node and we print it
        //then traverse the tree
        if(root.leftchild == null && root.rightchild == null && Character.isLetter(root.c))
        {
            //c is character in node
            System.out.println(root.c + ":" + s );
            return ;
        }
        //recursive calls to generate left and right tree
        //and add "0" for leftchild and "1" for  right child
        printCode(root.leftchild,s + "0");
        printCode(root.rightchild,s + "1");
    } 
    //main function
     public static void main(String[] args)
     {
         Scanner sc=new Scanner(System.in);
         //exapmle of already existing array
         int n=6;
         char[] charArray={'a','b','c','d','e','f'};
         int[] charfreq = {5,9,12,13,16,45};

         //use priority queue 
         //make a min-priority queue 
         //use binary heap tree
         //min-heap tree is used as a priority queue 
         //the value of the frequency field will be used to compare the values of the two nodes
         //the least frequent character is the root,so min-heap
         PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n,new MyComparator());

         for(int i=0;i<n;i++)
         {
             //Huffman node object to add it in the priority queue
             HuffmanNode hn = new HuffmanNode();

             hn.c = charArray[i];
             hn.freq = charfreq[i];

             //intial 
             hn.leftchild=null;
             hn.rightchild=null;

             //add the node to the tree
             q.add(hn);
        }
        //root of Huffman 
        HuffmanNode root = null;

        //Now, extract/remove min. two values from the heap
        //untill the size of heap is quals 1
        //all nodes will be extracted
        //.peek() to fetch the first element present at the instant
        //.poll() to return & remove the elemnt extracted by peek()
        while(q.size() > 1)
        {
            HuffmanNode x = q.peek();
            q.poll();

            HuffmanNode y = q.peek();
            q.poll();

            //new node to equal to
            HuffmanNode parent = new HuffmanNode();

            parent.freq = x.freq + y.freq;
            parent.c='-';

            parent.leftchild = x;
            parent.rightchild = y;
            root = parent ;

            //add the proot to the queue
            q.add(parent);
        }
        //Call the print function to print it recusrsively
        printCode(root,"");
    }//end of main
    
    
 }
 
