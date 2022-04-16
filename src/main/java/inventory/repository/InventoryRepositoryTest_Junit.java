package inventory.repository;

import inventory.model.InhousePart;
import inventory.model.Part;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class InventoryRepositoryTest_Junit {

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
    @Order(1)
    void testAddPart() {

        int size= repository.getAllParts().size();
        part=new InhousePart(1,"asd",-9.0,2,1,4,1);
        if(Part.isValidPart("asd",-9.0,2,1,4,"")=="")
            repository.addPart(part);

        assert repository.getAllParts().size() == size ;

    }

    @Test
    @Order(2)
    void testAddPart2() {
        int size= repository.getAllParts().size();
        part=new InhousePart(1,"asd",9.0,2,1,4,1);
        if(Part.isValidPart("asd",9.0,2,1,4,"")=="")
            repository.addPart(part);

        assert repository.getAllParts().size() == size+1 ;

    }

    @Test
    @Order(3)
    void testDeletePart() {
        int size= repository.getAllParts().size();
        part=new InhousePart(1,"asd",9.0,2,1,4,1);
        if(Part.isValidPart("asd",9.0,2,1,4,"")=="")
            repository.addPart(part);
        assert repository.getAllParts().size() == size+1 ;

        repository.deletePart(part);

        assert repository.getAllParts().size() == size;

    }
}