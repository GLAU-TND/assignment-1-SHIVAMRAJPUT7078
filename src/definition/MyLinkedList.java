package definition;

import adt.ContactADT;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ContactADT<E> {
    private Node<E> head = null;
    private Node<E> tail = null;

    private int size = 0;

    public int getSize() {
        return size;
    }

    // This method is for for getting data at a particular index
    public E get(int index) {
        Node<E> node = getNode(index);
        return node.getData();
    }

    private Node<E> getNode(int index) {
        Node<E> response = head;
        for (int i = 0; i < index && response != null; i++) {
            response = response.getNext();
        }
        return response;
    }

    private void addLast(E item) {
        Node<E> node = new Node<E>(tail.getPrevious(), item, tail);
        tail.getPrevious().next = node;
        tail = node;
        size++;
    }

    private boolean addFirst(E item) {
        Node<E> node = new Node<>(head, item, tail);
        head = node;
        tail = node;
        size++;
        return true;
    }

    private boolean addAfter(Node<E> node, E item) {

        /*
        * Node<E> nextNode = node.getNext();
        if (nextNode == null) {
            Node<E> newNode = new Node<>(node, item, null);
            node.next = newNode;
            rear = newNode;
        } else {
            Node<E> newNode = new Node<>(node, item, nextNode);
            node.next = newNode;
            nextNode.previous = newNode;
        }
        size++;*/
        //Node<E> temp1 = null;
        if (node.getNext() != null) {
            Node<E> temp = new Node<>(node, item, node.getNext());
            node.getNext().previous = temp;
            node.next = temp;
            size++;
        }//(node.getNext() == null)
        else {
            Node<E> newNode = new Node<>(node, item, node.getNext());
            node.next = newNode;
            node.getNext().previous = newNode;
            addLast(item);
        }
        /*else {
            addFirst(item);
        }*/
        return true;
    }

    @Override
    public boolean add(E item) {
        Node<E> node = new Node<E>(null, item, head);
        head = node;
        size++;
        return true;
    }

    @Override
    public boolean view() {
        return false;
    }

    @Override
    public ArrayList<E> search(E item) {
        ArrayList<E> list = new ArrayList<>();
        E data = null;
        for (int i = 0; i < size; i++) {
            data = getNode(i).getData();
            if (item.equals(data)) {
                list.add(data);
            }
        }
        return list;
    }

    private int getIndex(E item) {
        int response = -1;
        E data = null;
        for (int i = 0; i < size; i++) {
            data = getNode(i).getData();
            if (item.equals(data)) {
                response = i;
            }
        }
        return response;
    }

    private E removeFirst() {
        E data = null;
        Node<E> response = head;
        if (size == 1) {
            data = head.getData();
            head = tail = null;
            size--;
            return data;
        } else {
            head = response.getNext();
            response.getNext().previous = head;
            data = response.getNext().getData();
            size--;
            return data;
        }

    }

    private E removeLast() {
        E response = null;
        Node<E> node = getNode(size - 1);
        if (node.getPrevious() != null) {
            node.getPrevious().next = tail;
            tail = node.getPrevious();
            response = node.getData();
            size--;
            return response;
        } else {
            return removeFirst();
        }
    }

    private E removeAfter(Node<E> node) {
        E response = null;
        Node<E> temp = node.getNext();
        if (temp != null) {
            temp.getNext().previous = node;
            node.next = temp.getNext();
            response = temp.getData();
            return response;
        } else return removeLast();
    }

    private E remove() {
        return null;
    }

    @Override
    public E delete(E item) {
        if (getIndex(item) < 0) {
            throw new NoSuchElementException("No such element in present");
        } else {
            E data = null;
            Node<E> nod = null;
            for (int i = 0; i < size; i++) {
                data = getNode(i).getData();
                if (item.equals(data)) {
                    if (i == 0) {
                        data = removeFirst();
                    } else if (i == size - 1) {
                        data = removeLast();
                    } else {
                        nod = getNode(i - 1);
                        data = removeAfter(nod);
                    }

                }
            }
            return data;
        }
    }

    private static class Node<E> {
        Node<E> previous;
        private E data;
        private Node<E> next;

        public Node(Node<E> previous, E data, Node<E> next) {
            this.previous = previous;
            this.data = data;
            this.next = next;
        }

        public Node(E data) {
            this.data = data;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }
    }
}
