package inventory.repository;

import inventory.model.InhousePart;
import inventory.model.Part;
import inventory.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class AddProductTest {
    private Product product;
    private InventoryRepository repository;
    private int price;
    private String name;
    private ObservableList<Part> list;

    @BeforeEach
    void setUp() {
        repository= new InventoryRepository();
        InhousePart part=new InhousePart(1,"aaa",11.0,2,1,4,1);
        list = FXCollections.observableArrayList();
        list.add(part);
    }

    @AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    @Order(1)
    void addProduct1() {
        ObservableList<Product> lista=repository.getAllProducts();
        String error = "";
        if(Product.isValidProduct("",123.0,1,1,4,list,error).length()==0) {
            product = new Product(5, "", 123.0, 1, 1, 4, list);
            repository.addProduct(product);
        }
        assert (repository.getAllProducts().size() == lista.size());
    }
    @org.junit.jupiter.api.Test
    @Order(2)
    void addProduct2() {
        ObservableList<Product> lista=repository.getAllProducts();
        String error = "";
        if(Product.isValidProduct("somename",123.0,1,1,4,list,error)!=null) {
            product=new Product(6,"somename",123.0,1,1,4,list);
            repository.addProduct(product);
        }
        assert (repository.getAllProducts().size() == lista.size());
    }
    @org.junit.jupiter.api.Test
    @Order(3)
    void addProduct3() {
        ObservableList<Product> lista=repository.getAllProducts();
        String error = "";
        if(Product.isValidProduct("somename",0,1,1,4,list,error)==null) {
            product=new Product(7,"somename",0,1,1,4,list);
            repository.addProduct(product);
        }
        assert (repository.getAllProducts().size() != lista.size());
    }
    @org.junit.jupiter.api.Test
    @Order(4)
    void addProduct4() {
        int size1=repository.getAllProducts().size();
        String error = "";
        if(Product.isValidProduct("somename",123.0,1,4,1,list,error).length()!=0) {
            product=new Product(8,"somename",123.0,1,4,1,list);
            repository.addProduct(product);
        }
        assert (repository.getAllProducts().size() == size1);

    }
}