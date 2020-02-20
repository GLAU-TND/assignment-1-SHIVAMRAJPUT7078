package definition;

import adt.ContactADT;

public class MyLinkedList<E> implements ContactADT<E> {
    private Node<E> head = null;

    private int size = 0;

    private void addFirstE(E item) {


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
    public boolean searchContact(E item) {

        return false;
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
