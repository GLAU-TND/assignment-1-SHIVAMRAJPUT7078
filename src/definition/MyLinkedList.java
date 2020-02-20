package definition;

import adt.ContactADT;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ContactADT<E> {
    private Node<E> head = null;
    private Node<E> tail = null;

    private int size = 0;

    private Node<E> getNode(int index) {
        Node<E> response = head;
        for (int i = 0; i < index; i++) {
            response = response.getNext();
        }
        return response;
    }

    private void addLastContact(E item) {
        Node<E> node = new Node<E>(null, item, null);
    }

    @Override
    public boolean addContact(E item) {
        Node<E> node = new Node<E>(null, item, head);
        head = node;
        size++;
        return true;
    }

    @Override
    public boolean viewContact() {
        return false;
    }

    @Override
    public ArrayList<E> searchContact(E item) {
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

    @Override
    public E deleteContact(E item) {
        if (getIndex(item) < 0) {
            throw new NoSuchElementException("No such element in present");
        } else {
            E data = null;
            Node<E> nod = null;
            for (int i = 0; i < size; i++) {
                data = getNode(i).getData();

                if (item.equals(data)) {
                    nod = getNode(i);
                    if (i == 0) {

                    }

                }
            }
        }
        return null;
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
