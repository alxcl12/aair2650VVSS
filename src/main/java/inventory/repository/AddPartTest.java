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

class AddPartTest {

    private Part part;
    private InventoryRepository repository;

    @BeforeEach
    void setUp() {
        repository= new InventoryRepository();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addPart() {
    }

    @org.junit.jupiter.api.Test
    @Order(1)
    void addPart1() {
        part=new InhousePart(1,"asd",9.0,2,1,4,1);
        repository.addPart(part);
    }
    @org.junit.jupiter.api.Test
    @Order(2)
    void addPart2() {
        part=new InhousePart(1,"fis",-10,2,10,4,1);
        repository.addPart(part);

    }
    @org.junit.jupiter.api.Test
    @Order(3)
    void addPart3() {
        part=new InhousePart(1,"crt",11.0,2,10,4,1);
        repository.addPart(part);
    }
    @org.junit.jupiter.api.Test
    @Order(4)
    void addPart4() {
        part=new InhousePart(1,"ndf",11.0,2,1,4,1);
        repository.addPart(part);
    }
}