package inventory;

import inventory.model.Product;
import inventory.repository.InventoryRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SerachProductTest {

    private InventoryRepository repository;

    @BeforeEach
    void setUp() {
        repository= new InventoryRepository();
    }

    @AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    @Order(1)
    void lookupProduct1() {
        String nume="product2";
        assert(repository.lookupProduct(nume).getName()!=null);
    }
    @org.junit.jupiter.api.Test
    @Order(2)
    void lookupProduct2() {
        String nume="asdfffghf";
        assert(repository.lookupProduct(nume)==null);
    }
}