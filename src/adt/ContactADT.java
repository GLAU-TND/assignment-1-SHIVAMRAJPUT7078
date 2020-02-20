package adt;

import java.util.ArrayList;

public interface ContactADT<E> {
    boolean addContact(E item);

    boolean viewContact();

    ArrayList<E> searchContact(E item);

    E deleteContact(E item);
}
