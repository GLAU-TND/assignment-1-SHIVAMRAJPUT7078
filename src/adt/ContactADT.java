package adt;

public interface ContactADT<E> {
    boolean addContact(E item);

    boolean viewContact();

    boolean searchContact(E item);

    E deleteContact(E item);
}
