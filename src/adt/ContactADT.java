package adt;

public interface ContactADT<E> {
    boolean addContact();

    boolean viewContact();

    long searchContact();

    long deleteContact();
}
