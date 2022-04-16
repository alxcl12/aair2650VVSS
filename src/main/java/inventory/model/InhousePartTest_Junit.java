package inventory.model;

import inventory.repository.InventoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class InhousePartTest_Junit {

    private InhousePart part;

    @BeforeEach
    void setUp() {
        part=null;
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    @Order(1)
    void testGetPart() {
        part=new InhousePart(1,"name1",250,20,5,50,7);
        assert(part.getMachineId()==7);
        assert(part.getPrice()==250);
    }

    @Test
    @Order(2)
    void testSetPart() {
        part=new InhousePart(1,"name1",250,20,5,50,7);
        part.setMachineId(57);
        part.setPrice(120);
        assert(part.getMachineId()==57);
        assert(part.getPrice()==120);

    }

    @Test
    @Order(3)
    void testValidPart() {
        assert (Part.isValidPart("name1",250,20,5,50,"").length()==0);
        assert (Part.isValidPart("name1",-250,20,5,50,"").length()>0);
    }

}