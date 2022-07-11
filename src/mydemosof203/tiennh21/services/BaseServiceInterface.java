package mydemosof203.tiennh21.services;

import java.util.ArrayList;

public interface BaseServiceInterface<K, E> {
    public E insert(E entity);
    public E update(K pk, E entity);
    public void delete(E entity);
    public ArrayList<E> paginate(int page, int limit);
    public E findById(K key);
}
