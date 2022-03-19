package inventory.repository;

import inventory.model.InhousePart;
import inventory.model.Part;
import inventory.model.Product;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class AddPartTest {

    private Part part;
    private InventoryRepository repository;

    @BeforeEach
    void setUp() {
        part=null;
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

        int size= repository.getAllParts().size();
        part=new InhousePart(1,"asd",-9.0,2,1,4,1);
        if(Part.isValidPart("asd",-9.0,2,1,4,"")=="")
            repository.addPart(part);

        assert repository.getAllParts().size() == size+1 ;

    }
    @org.junit.jupiter.api.Test
    @Order(2)
    void addPart2() {
        int size= repository.getAllParts().size();
        part=new InhousePart(1,"asd",9.0,2,10,4,1);
        if(Part.isValidPart("asd",9.0,2,10,4,"")=="")
            repository.addPart(part);

        assert repository.getAllParts().size() == size+1 ;

    }
    @org.junit.jupiter.api.Test
    @Order(3)
    void addPart3() {
        int size= repository.getAllParts().size();
        part=new InhousePart(1,"asd",9.0,2,1,4,1);
        if(Part.isValidPart("asd",9.0,2,1,4,"")=="")
            repository.addPart(part);

        assert repository.getAllParts().size() == size+1 ;

    }
    @org.junit.jupiter.api.Test
    @Order(4)
    void addPart4() {
        int size= repository.getAllParts().size();
        part=new InhousePart(1,"asd",9.0,20,1,4,1);
        if(Part.isValidPart("asd",9.0,20,1,4,"")=="")
            repository.addPart(part);

        assert repository.getAllParts().size() == size+1 ;

    }
}