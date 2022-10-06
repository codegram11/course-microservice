package codegram.microservice.store.product.service;

import codegram.microservice.store.product.entity.Category;
import codegram.microservice.store.product.entity.Product;
import codegram.microservice.store.product.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceImplTest {

    @Mock
    private ProductRepository repository;

    private ProductService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        service=new ProductServiceImpl(repository);
        Product computer = Product.builder()
                .id(1L)
                .name("computer")
                .category(Category.builder().id(1L).build())
                .stock(Double.parseDouble("5"))
                .price(Double.parseDouble("4540.99"))
                .createAt(new Date()).build();

        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(computer));
        Mockito.when(repository.save(computer)).thenReturn(computer);
    }

    @Test
    void whenValidGetID_thenReturnProduct() {
        Product found= service.getProduct(1L);
        Assertions.assertEquals("computer", found.getName());
    }

    @Test
    void whenValidUpdateStock_thenReturnNewStock() {
        Product newStock= service.updateStock(1L,Double.parseDouble("8"));
        Assertions.assertEquals(13, newStock.getStock());
    }
}