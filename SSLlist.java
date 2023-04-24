public class SSLlist {
    private static class IntNode{
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }
    private final IntNode sentinel;
    private int size;
    public SSLlist(){
        sentinel = new IntNode(63, null);
        size = 0;
    }

    public SSLlist(int x){
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;

    }

    public void addFirst(int x){
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    public int getFirst(){
        return sentinel.next.item;
    }

    public void addLast(int x){
        IntNode p = new IntNode(x, null);
        IntNode q = sentinel;
        while(q.next != null){
            q = q.next;
        }
        q.next = p;
        size += 1;
    }

    /**
     * insert x into the position
     * @param x
     * @param position
     * the position is the index of the list, but the first node is 0
     */
    public void insert(int x, int position){
        IntNode p = new IntNode(x, null);
        IntNode q = sentinel;
        for (int i = 0; i < position ; i++) {
            q = q.next;
        }
        p.next = q.next;
        q.next = p;
        size += 1;
    }

    public int size(){
        return this.size;
    }

    public void items(){
        IntNode q = sentinel;
        while(q.next != null){
            System.out.println(q.next.item);
            q = q.next;
        }
    }

    public static void main(String[] args) {
        SSLlist test = new SSLlist();
        test.addFirst(5);
        test.addFirst(10);
        test.addFirst(20);
        test.addLast(30);
        test.insert(15, 2);
        test.items();
        System.out.println(test.getFirst());
        System.out.println(test.size());

    }



}
