package codegram.microservice.store.product.service;

import codegram.microservice.store.product.entity.Category;
import codegram.microservice.store.product.entity.Product;
import codegram.microservice.store.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{


    private final ProductRepository repository;


    @Override
    public List<Product> listAllProduct() {
        return repository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        product.setStatus("CREATE");
        product.setCreateAt(new Date());
        return repository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product product1=getProduct(product.getId());
        if(product1==null){
            return null;
        }
        product1.setName(product.getName());
        product1.setDescription(product.getDescription());
        product1.setCategory(product.getCategory());
        product1.setPrice(product.getPrice());
        return repository.save(product1);
    }

    @Override
    public Product deleteProduct(Long id) {
        Product product1=getProduct(id);
        if(product1==null){
            return null;
        }
        product1.setStatus("DELETE");
        return repository.save(product1);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return repository.findByCategory(category);
    }

    @Override
    public Product updateStock(Long id, Double quantity) {
        Product product1=getProduct(id);
        if(product1==null){
            return null;
        }
        Double stock= product1.getStock()+ quantity;
        product1.setStock(stock);
        return repository.save(product1);
    }
}
