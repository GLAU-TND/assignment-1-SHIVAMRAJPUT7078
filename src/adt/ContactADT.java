package adt;

public interface ContactADT<E> {
    boolean add(E item);

    boolean view();

    //ArrayList<E> search(E item);

    E delete(E item);
}
