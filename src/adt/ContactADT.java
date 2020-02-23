package adt;

public interface ContactADT<E> {
    boolean add(E item);

    boolean view();

    E delete(E item);
}
