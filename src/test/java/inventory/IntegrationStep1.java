/*
 *  @author albua
 *  created on 16/04/2022
 */
package inventory;

import inventory.model.InhousePart;
import inventory.model.Part;
import inventory.repository.InventoryRepository;
import inventory.service.InventoryService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class IntegrationStep1 {

    private InhousePart part;
    private InventoryRepository repository;
    private InventoryService service;

    @BeforeEach
    void setUp() {
        part=null;
        repository= new InventoryRepository();
        service=new InventoryService(repository);
    }

    @Test
    void testAddInhousePartService() {

        int size= service.getAllParts().size();
        if(Part.isValidPart("asd",-9.0,2,1,4,"")=="")
            service.addInhousePart("asd",-9.0,2,1,4,7);

        assert service.getAllParts().size() == size ;

    }

    @Test
    void testAddInhousePart2Service() {
        int size= service.getAllParts().size();
        if(Part.isValidPart("asd",9.0,2,1,4,"")=="")
            service.addInhousePart("asd",9.0,2,1,4,7);

        assert service.getAllParts().size() == size+1 ;

    }

    @Test
    void testDeletePartService() {
        int size= service.getAllParts().size();

        if(Part.isValidPart("asd",9.0,2,1,4,"")=="")
            service.addInhousePart("asd",9.0,2,1,4,7);
        assert service.getAllParts().size() == size+1 ;

        part= (InhousePart) service.lookupPart("asd");
        service.deletePart(part);

        assert service.getAllParts().size() == size;

    }

    @Test
    void testAddPartRepo() {

        int size= repository.getAllParts().size();
        part=new InhousePart(1,"asd",-9.0,2,1,4,1);
        if(Part.isValidPart("asd",-9.0,2,1,4,"")=="")
            repository.addPart(part);

        assert repository.getAllParts().size() == size ;

    }

    @Test
    void testAddPart2Repo() {
        int size= repository.getAllParts().size();
        part=new InhousePart(1,"asd",9.0,2,1,4,1);
        if(Part.isValidPart("asd",9.0,2,1,4,"")=="")
            repository.addPart(part);

        assert repository.getAllParts().size() == size+1 ;

    }

    @Test
    void testDeletePartRepo() {
        int size= repository.getAllParts().size();
        part=new InhousePart(1,"asd",9.0,2,1,4,1);
        if(Part.isValidPart("asd",9.0,2,1,4,"")=="")
            repository.addPart(part);
        assert repository.getAllParts().size() == size+1 ;

        repository.deletePart(part);

        assert repository.getAllParts().size() == size;

    }

    @Test
    void testGetPart() {
        part=new InhousePart(1,"name1",250,20,5,50,7);
        assert(part.getMachineId()==7);
        assert(part.getPrice()==250);
    }

    @Test
    void testSetPart() {
        part=new InhousePart(1,"name1",250,20,5,50,7);
        part.setMachineId(57);
        part.setPrice(120);
        assert(part.getMachineId()==57);
        assert(part.getPrice()==120);

    }

    @Test
    void testValidPart() {
        assert (Part.isValidPart("name1",250,20,5,50,"").length()==0);
        assert (Part.isValidPart("name1",-250,20,5,50,"").length()>0);
    }

    @Test
    void testAll(){
        testAddInhousePartService();
        testAddInhousePart2Service();
        testDeletePartService();
        testAddPartRepo();
        testAddPart2Repo();
        testDeletePartRepo();
        testGetPart();
        testSetPart();
        testValidPart();
    }
}
