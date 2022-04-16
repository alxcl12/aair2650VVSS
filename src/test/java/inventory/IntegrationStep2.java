/*
 *  @author albua
 *  created on 16/04/2022
 */
package inventory;

import inventory.model.InhousePart;
import inventory.model.Part;
import inventory.repository.InventoryRepository;
import inventory.service.InventoryService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;

class IntegrationStep2 {
    private InventoryRepository repo = new InventoryRepository();
    private InventoryService service = new InventoryService(repo);


    @Test
    void TestAdd(){
        InhousePart p1 = mock(InhousePart.class);

        int oldSize = service.getAllParts().size();
        service.addInhousePart(p1.getName(),p1.getPrice(),p1.getInStock(),p1.getMin(),p1.getMax(),p1.getMachineId());
        assert service.getAllParts().size() == oldSize+1;

        for(Part part: service.getAllParts()){
            if (part.getName() == null){
                p1 = (InhousePart) part;
            }
        }
        service.deletePart(p1);
    }

    @Test
    void TestDelete(){
        InhousePart p1 = mock(InhousePart.class);

        service.addInhousePart(p1.getName(),p1.getPrice(),p1.getInStock(),p1.getMin(),p1.getMax(),p1.getMachineId());
        int oldSize = service.getAllParts().size();

        for(Part part: service.getAllParts()){
            if (part.getName() == null){
                p1 = (InhousePart) part;
            }
        }
        service.deletePart(p1);
        assert service.getAllParts().size() == oldSize - 1;
    }
}
