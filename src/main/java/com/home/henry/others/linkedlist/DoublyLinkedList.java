package com.home.henry.others.linkedlist;

class Node<T> {
    T t;
    Node prev;
    Node next;

    public Node(T t) {
        this.t = t;
        this.prev = null;
        this.next = null;
    }

}

public class DoublyLinkedList<T> {

    DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private Node<T> head;
    private Node<T> tail;
    int size;

    public int size() {
        return size;
    }
    public boolean isEmpty() {return size == 0;}
    public boolean isPresent(T t) {
        if (head == null) {return false;}
        Node<T> temp = head;
        while (temp != null) {
            if (temp.t == t) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void traverseForward()
    {
        Node current = head;
        while (current != null) {
            System.out.print(current.t + " ");
            current = current.next;
        }
    }
    public void traverseBackward()
    {
        Node current = tail;
        while (current != null) {
            System.out.print(current.t + " ");
            current = current.prev;
        }
    }
    public void addHead(T t) {
        Node<T> newNode = new Node<>(t);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }

    public void add(T t) {
        this.addTail(t);
    }

    public void addTail(T t) {
        if (head == null) {
            this.addHead(t);
            return;
        }
        Node<T> newNode = new Node(t);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    public void removeHead() {
        if (size == 0) {
            throw new RuntimeException("empty");
        }
        Node<T> temp = head.next;
        if (temp == null) {
            tail = null;
        } else {
            temp.prev = null;
        }
        head = temp;
        size--;
    }

    public void removeTail() {
        if (size == 0) {
            throw new RuntimeException("empty");
        }
        Node<T> temp = tail.prev;
        temp.next = null;
        tail = temp;
        size--;
    }
    public boolean removeNode(T key) {
        Node<T> curr = head;
        if (curr == null) {return false;}
        if (curr.t == key) {
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            return true;
        }

        while (curr.next != null) {
            if (curr.next.t == key) {
                curr.next = curr.next.next;
                if (curr.next == null) {
                    tail = curr;
                } else {
                    curr.next = curr;
                }
                size--;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public void print() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.t + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addHead(1);
        list.addTail(2);
        list.addHead(3);
        list.addTail(4);
        System.out.println(list.isPresent(10));
        System.out.println(list.isPresent(3));
        list.print();
    }
}
