package definition;

import adt.ContactADT;

import java.util.ArrayList;

public class MyLinkedList<E> implements ContactADT<E> {
    private Node<E> head = null;

    private int size = 0;

    private Node<E> getNode(int index) {
        Node<E> response = head;
        for (int i = 0; i < index; i++) {
            response = response.getNext();
        }
        return response;
    }

    private void addLastContact(E item) {
        Node<E> node = new Node<E>(item, null);
    }

    @Override
    public boolean addContact(E item) {
        Node<E> node = new Node<E>(item, head);
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

    @Override
    public E deleteContact(E item) {

        return null;
    }

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {

            this.data = data;
            this.next = next;
        }


        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }
    }
}
