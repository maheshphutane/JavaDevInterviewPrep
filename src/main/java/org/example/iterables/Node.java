package org.example.iterables;

import java.util.Iterator;

public class Node implements Iterable<Node>{
    int data;
    Node next;
    public Node(int data,Node next){
        this.data = data;
        this.next = next;
    }

    /**
     *
     * @return iterator
     */
    @Override
    public Iterator<Node> iterator() {
            return new NodeIterator(this);
    }

    static class NodeIterator implements Iterator<Node>{
        Node start;
        public NodeIterator(Node start){
            this.start = start;
        }

        @Override
        public boolean hasNext() {
            if(start!=null) return true;
            return false;
        }

        @Override
        public Node next() {
            Node tmp = start;
            start = start.next;
            return tmp;
        }
    }
}
