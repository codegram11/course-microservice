package codegram.microservice.store.product.repository;

import codegram.microservice.store.product.entity.Category;
import codegram.microservice.store.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByCategory(Category category);


}
