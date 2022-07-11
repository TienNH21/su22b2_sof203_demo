package mydemosof203.tiennh21.repositories.mysql;

import java.util.ArrayList;

public interface BaseRepositoryInterface<K, E> {
    public E insert(E entity);
    public E update(K key, E entity);
    public E delete(E entity);
    public ArrayList<E> paginate(int page, int limit);
    public E findById(K key);
}
