package inventory.service;

import inventory.model.InhousePart;
import inventory.model.Part;
import inventory.repository.InventoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class InventoryServiceTest_Junit {

    private Part part;
    private InventoryRepository repository;
    private InventoryService service;

    @BeforeEach
    void setUp() {
        part=null;
        repository= new InventoryRepository();
        service=new InventoryService(repository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Order(1)
    void testAddInhousePart() {

        int size= service.getAllParts().size();
        if(Part.isValidPart("asd",-9.0,2,1,4,"")=="")
            service.addInhousePart("asd",-9.0,2,1,4,7);

        assert service.getAllParts().size() == size ;

    }

    @Test
    @Order(2)
    void testAddInhousePart2() {
        int size= service.getAllParts().size();
        if(Part.isValidPart("asd",9.0,2,1,4,"")=="")
            service.addInhousePart("asd",9.0,2,1,4,7);

        assert service.getAllParts().size() == size+1 ;

    }

    @Test
    @Order(3)
    void testDeletePart() {
        int size= service.getAllParts().size();

        if(Part.isValidPart("asd",9.0,2,1,4,"")=="")
            service.addInhousePart("asd",9.0,2,1,4,7);
        assert service.getAllParts().size() == size+1 ;

        part=service.lookupPart("asd");
        service.deletePart(part);

        assert service.getAllParts().size() == size;

    }
}