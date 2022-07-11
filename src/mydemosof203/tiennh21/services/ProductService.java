package mydemosof203.tiennh21.services;

import java.util.ArrayList;
import mydemosof203.tiennh21.models.Product;
import mydemosof203.tiennh21.repositories.mysql.ProductRepository;

public class ProductService implements BaseServiceInterface<Integer, Product>{
    private ProductRepository productRepo;

    public ProductService()
    {
        this.productRepo = new ProductRepository();
    }
    
    @Override
    public Product insert(Product entity) {
        return this.productRepo.insert(entity);
    }

    @Override
    public Product update(Integer pk, Product entity) {
        return this.productRepo.update(pk, entity);
    }

    @Override
    public void delete(Product entity) {
        this.productRepo.delete(entity);
    }

    @Override
    public ArrayList<Product> paginate(int page, int limit) {
        return this.productRepo.paginate(page, limit);
    }

    @Override
    public Product findById(Integer key) {
        return this.productRepo.findById(key);
    }
    
}
