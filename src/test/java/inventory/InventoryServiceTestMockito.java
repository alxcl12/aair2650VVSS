package inventory;

import inventory.model.InhousePart;
import inventory.model.Part;
import inventory.repository.InventoryRepository;
import inventory.service.InventoryService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

public class InventoryServiceTestMockito {
    private InventoryRepository repo;

    private InventoryService service;

    @BeforeEach
    void setUp() {
        service=Mockito.mock(InventoryService.class);
    }


    @Test
    @Order(1)
    void addInhousePart() {
        InhousePart p1=new InhousePart(1,"arahida",25.0,7,2,10,19);
        Mockito.when(service.getAllParts()).thenReturn(null);
        Mockito.doNothing().when(service).addInhousePart("arahida",25.0,7,2,10,19);
        service.addInhousePart("arahida",25.0,7,2,10,19);
        Mockito.verify(service,times(1)).addInhousePart("arahida",25.0,7,2,10,19);
        Mockito.verify(service,never()).getAllParts();
        assert true;
    }

    @Test
    @Order(2)
    void addInhousePart1() {
        InhousePart p1=new InhousePart(1,"arahida",25.0,7,2,10,19);
        Mockito.when(service.getAllParts()).thenReturn(null);
        Mockito.doNothing().when(service).addInhousePart("arahida",25.0,7,200,10,19);
        service.addInhousePart("arahida",25.0,7,200,10,19);
        Mockito.verify(service,times(1)).addInhousePart("arahida",25.0,7,200,10,19);
        Mockito.verify(service,never()).getAllParts();
        assert true;
    }
}