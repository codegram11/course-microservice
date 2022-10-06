package codegram.microservice.store.product.repository;

import codegram.microservice.store.product.entity.Category;
import codegram.microservice.store.product.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.Date;
import java.util.List;


@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository  repository;

    @Test
    void whenFindByCategory_thenReturnListProduct() {
        Product product01 = Product.builder()
                .name("computer")
                .category(Category.builder().id(1L).build())
                .description("")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("1240.99"))
                .status("Created")
                .createAt(new Date()).build();
        repository.save(product01);

        List<Product> founds= repository.findByCategory(product01.getCategory());

        Assertions.assertEquals(3, founds.size());

    }
}