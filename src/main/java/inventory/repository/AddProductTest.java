package inventory.repository;

import inventory.model.InhousePart;
import inventory.model.Part;
import inventory.model.Product;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddProductTest {
    private Product product;
    private InventoryRepository repository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addProduct() {
    }
    @org.junit.jupiter.api.Test
    @Order(1)
    void addProduct1() {
        InhousePart part=new InhousePart(1,"aaa",11.0,2,1,4,1);
        ObservableList<Part> list = null;
        list.add(part);
        product=new Product(1,"",123.0,1,1,4,list);
        repository.addProduct(product);
    }
    @org.junit.jupiter.api.Test
    @Order(2)
    void addProduct2() {
        InhousePart part=new InhousePart(1,"aaa",11.0,2,1,4,1);
        ObservableList<Part> list = null;
        list.add(part);
        product=new Product(1,"somename",123.0,1,1,4,list);
        repository.addProduct(product);
    }
    @org.junit.jupiter.api.Test
    @Order(3)
    void addProduct3() {
        InhousePart part=new InhousePart(1,"aaa",11.0,2,1,4,1);
        ObservableList<Part> list = null;
        list.add(part);
        product=new Product(1,"somename",-1,1,1,4,list);
        repository.addProduct(product);
    }
    @org.junit.jupiter.api.Test
    @Order(4)
    void addProduct4() {
        InhousePart part=new InhousePart(1,"aaa",11.0,2,1,4,1);
        ObservableList<Part> list = null;
        list.add(part);
        product=new Product(1,"somename",123.0,1,4,1,list);
        repository.addProduct(product);
    }
}