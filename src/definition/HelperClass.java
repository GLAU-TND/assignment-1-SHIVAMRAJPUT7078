package definition;

public class HelperClass<Person> {
    private Node<Person> head = null;
    private Person data;
    private Node<Person> next;

    private static class Node<E> {
        private Node<E> head;
        private E data;
        private Node<E> next;

        public Node(Node<E> head, E data, Node<E> next) {
            this.head = head;
            this.data = data;
            this.next = next;
        }

        public Node<E> getHead() {
            return head;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node(E data) {
            this.data = data;
        }
    }
}
