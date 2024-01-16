package org.example.iterables;

public class Main {
    public static void main(String[] args) {
        Node n1 = new Node(1,null);
        Node n2 = new Node(2,n1);
        Node n3 = new Node(3,n2);
        for(Node tmp:n3){
            System.out.println(tmp.data);
        }
    }
}
