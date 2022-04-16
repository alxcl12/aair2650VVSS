/*
 *  @author albua
 *  created on 16/04/2022
 */
package inventory;

import inventory.model.InhousePart;
import inventory.repository.InventoryRepository;
import inventory.service.InventoryService;
import org.junit.jupiter.api.Test;

class IntegrationStep3 {
    private InventoryRepository repo = new InventoryRepository();
    private InventoryService service = new InventoryService(repo);

    @Test
    void TestAdd(){
        InhousePart p1 = new InhousePart(1, "Washer",0.75f,250,10,300,4);

        service.addInhousePart(p1.getName(),p1.getPrice(),p1.getInStock(),p1.getMin(),p1.getMax(),p1.getMachineId());

        assert service.lookupPart(p1.getName()).getPrice() == p1.getPrice();
        assert service.lookupPart(p1.getName()).getName().equals(p1.getName());
    }

    @Test
    void TestDelete(){
        InhousePart p1 = new InhousePart(1, "Washer",0.75f,250,10,300,4);

        service.addInhousePart(p1.getName(),p1.getPrice(),p1.getInStock(),p1.getMin(),p1.getMax(),p1.getMachineId());
        int oldSize = service.getAllParts().size();

        InhousePart p2 = (InhousePart) service.lookupPart("Washer");
        service.deletePart(p2);

        assert service.getAllParts().size() == oldSize - 1;
    }
}
