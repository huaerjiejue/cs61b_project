public class SSLlist {
    private static class IntNode{
        public int item;
        public IntNode nest;
        public IntNode(int i, IntNode n){
            item = i;
            nest = n;
        }
    }
    private IntNode sentinel;
    private int size;
    public SSLlist(){
        sentinel = new IntNode(63, null);
        size = 0;
    }

    public void addFirst(int x){
        sentinel.nest = new IntNode(x, sentinel.nest);
        size += 1;
    }

    public int getFirst(){
        return sentinel.nest.item;
    }

    public void addLast(int x){
        IntNode p = new IntNode(x, null);
        IntNode q = sentinel;
        while(q.nest != null){
            q = q.nest;
        }
        q.nest = p;
        size += 1;
    }
    public void insert(int x, int position){
        IntNode p = new IntNode(x, null);
        IntNode q = sentinel;
        for (int i = 0; i < position - 1; i++) {
            q = q.nest;
        }
        p.nest = q.nest;
        q.nest = p;
        size += 1;
    }

    public int size(){
        return size;
    }

    public void items(){
        IntNode q = sentinel;
        while(q.nest != null){
            System.out.println(q.nest.item);
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
        test.size();
    }



}
