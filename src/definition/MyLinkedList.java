package definition;

import adt.ContactADT;

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

    public void addLast(E item) {
        Node<E> node = new Node<E>(tail.getPrevious(), item, tail);
        tail.getPrevious().next = node;
        tail = node;
        size++;
    }

    private boolean addFirst(E item) {
        Node<E> node;
        if (head == null) {
            node = new Node<>(null, item, null);
            head = node;
            tail = node;
        } else {
            node = new Node<>(null, item, head);
            head.previous = node;
            head = node;
        }
        size++;
        return true;
    }

    private boolean addAfter(Node<E> node, E item) {
        Node<E> nextNode = node.getNext();
        if (nextNode == null) {
            Node<E> newNode = new Node<>(node, item, null);
            node.next = newNode;
            tail = newNode;
        } else {
            Node<E> newNode = new Node<>(node, item, nextNode);
            node.next = newNode;
            nextNode.previous = newNode;
        }
        size++;
        return true;
    }



    @Override
    public boolean add(E item) {
        return add(size, item);
    }

    public boolean add(int index, E item) throws IndexOutOfBoundsException {
        if (index < 0 && index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        } else if (index == 0) {
            return addFirst(item);
        } else {
            return addAfter(getNode(index - 1), item);
        }
    }

    @Override
    public boolean view() {
        return false;
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
        //if (size == 1) {
        if (head.getNext() == null) {
            data = response.getData();
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

    private E remove(Node<E> node) {
        Node<E> temp = node.getNext();
        if (temp == null) {
            return removeLast();
        } else if (node.getPrevious() == null) {
            return removeFirst();
        } else {
            temp.previous = node.getPrevious();
            node.getPrevious().next = node.getNext();
            size--;
        }
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
                    remove(getNode(i));
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
