package com.nikno8.java_mirea.pract16;

import com.nikno8.java_mirea.pract16.entity.Manufacture;
import com.nikno8.java_mirea.pract16.repository.ManufactureRepository;
import com.nikno8.java_mirea.pract16.service.ManufactureService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ManufactureServiceTest {

    @Mock
    ManufactureRepository repository;
    @Test
    void getManu(){
        Manufacture manufacture = new Manufacture();
        manufacture.setAddress("USA");
        manufacture.setName("Apple");
        manufacture.setId(1L);

        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(manufacture));

        ManufactureService service = new ManufactureService();
        service.setRepository(repository);

        Assertions.assertEquals("Apple",service.getManu(1L).getName());
    }

}
