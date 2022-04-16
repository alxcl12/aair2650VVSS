package inventory.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;

class InhousePartTestMockito {
    private InhousePart part;
    @BeforeEach
    void setUp() {
        part= Mockito.mock(InhousePart.class);
    }


    @Test
    @Order(1)
    void setMachineId() {
        Mockito.when(part.getMachineId()).thenReturn(101);
        Mockito.doNothing().when(part).setMachineId(101);
        part.setMachineId(101);
        Mockito.verify(part,Mockito.times(1)).setMachineId(101);
        assert true;
    }

    @Test
    @Order(2)
    void setMachineId1() {
        Mockito.doNothing().when(part).setMachineId(-1);

        Mockito.verify(part,never()).setMachineId(-1);
    }
}