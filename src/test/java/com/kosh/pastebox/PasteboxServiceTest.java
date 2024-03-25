package com.kosh.pastebox;

import com.kosh.pastebox.api.response.PasteboxResponse;
import com.kosh.pastebox.entity.PasteBoxEntity;
import com.kosh.pastebox.exception.NotFoundEntityException;
import com.kosh.pastebox.repository.PasteboxRepository;
import com.kosh.pastebox.service.PasteboxService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PasteboxServiceTest {

    @Autowired
    private PasteboxService pasteboxService;

    @MockBean
    private PasteboxRepository pasteboxRepository;

    @Test
    public void notExistHash(){
        when(pasteboxRepository.findByHash(anyString())).thenThrow(NotFoundEntityException.class);
        assertThrows(NotFoundEntityException.class, () -> pasteboxService.getByHash("sgod78fsgdf1e09"));
    }

    @Test
    public void getExistHash(){
        PasteBoxEntity entity = new PasteBoxEntity();
        entity.setHash("1");
        entity.setData("data");
        entity.setPublic(true);

        when(pasteboxRepository.findByHash("1")).thenReturn(entity);

        PasteboxResponse expected = new PasteboxResponse("data", true);
        PasteboxResponse actual = pasteboxService.getByHash("1");

        assertEquals(expected, actual);
    }

}
