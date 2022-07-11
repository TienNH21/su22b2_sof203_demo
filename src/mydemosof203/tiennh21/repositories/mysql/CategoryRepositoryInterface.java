package mydemosof203.tiennh21.repositories.mysql;

import mydemosof203.tiennh21.models.Category;

public interface CategoryRepositoryInterface
    extends BaseRepositoryInterface<Integer, Category> {
    public Category findByNameEqual(String name);
}
