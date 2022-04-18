package inventory;

import inventory.model.InhousePart;
import inventory.model.Part;
import inventory.repository.InventoryRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

class InventoryRepositoryTestMockito {
    private InventoryRepository repo;
    @BeforeEach
    void setUp() {
        repo = Mockito.mock(InventoryRepository.class);
    }

    @Test
    @Order(1)
    void addPart() {
        InhousePart p1=new InhousePart(1,"arahida",25.0,7,2,10,19);
        InhousePart p2=new InhousePart(2,"arahidaa",20.0,7,2,10,20);
        ObservableList<Part> l= FXCollections.observableArrayList();
        l.add(p1);
        Mockito.when(repo.getAllParts()).thenReturn(l);
        Mockito.doNothing().when(repo).addPart(p2);

        repo.addPart(p1);

        Mockito.verify(repo,times(1)).addPart(p1);
        Mockito.verify(repo,never()).getAllParts();

        assert true;
    }

    @Test
    @Order(2)
    void addPart1() {
        InhousePart p1=new InhousePart(1,"arahida",25.0,7,2,10,19);
        InhousePart p2=new InhousePart(2,"arahidaa",20.0,7,200,10,20);
        ObservableList<Part> l= FXCollections.observableArrayList();
        Mockito.when(repo.getAllParts()).thenReturn(l);
        Mockito.doNothing().when(repo).addPart(p2);

        repo.addPart(p1);

        Mockito.verify(repo,times(1)).addPart(p1);
        Mockito.verify(repo,never()).getAllParts();

        assert true;
    }
}