package mydemosof203.tiennh21.services;

import java.util.ArrayList;
import mydemosof203.tiennh21.models.Category;

import mydemosof203.tiennh21.repositories.mysql.CategoryRepository;

public class CategoryService 
    implements BaseServiceInterface<Integer, Category>{
    private CategoryRepository cateRepo;

    public CategoryService()
    {
        this.cateRepo = new CategoryRepository();
    }
    
    @Override
    public Category insert(Category entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Category update(Integer pk, Category entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Category entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Category> paginate(int page, int limit) {
        return this.cateRepo.paginate(page, limit);
    }

    @Override
    public Category findById(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Category findByNameEqual(String name)
    {
        return this.cateRepo.findByNameEqual(name);
    }
}
