package com.nikno8.java_mirea.pract16;

import com.nikno8.java_mirea.pract16.entity.Phone;
import com.nikno8.java_mirea.pract16.repository.PhoneRepository;
import com.nikno8.java_mirea.pract16.service.PhoneServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PhoneServiceTest {
    @Mock
    PhoneServiceImpl service;
    @Mock
    PhoneRepository repository;
    @Captor
    ArgumentCaptor<Phone> captor;
//    @Test
//    void getManufactureByPhone(){
//        Phone phone = new Phone();
//        Manufacture manufacture = new Manufacture();
//        manufacture.setId(1L);
//        manufacture.setName("Apple");
//        phone.setId(1L);
//        phone.setManufacture(manufacture);
//        phone.setName("Iphone Xr");
//        manufacture.setPhones(Collections.singletonList(phone));
//
//        Mockito.when(repository.findById(1L).get().getManufacture()).thenReturn(manufacture);
//
//        assertEquals("Iphone Xr",service.getManufactureByPhone(1L).getName());
//    }

//    @Test
//    void getFilterPhone(){
//        Phone phone = new Phone();
//        Manufacture manufacture = new Manufacture();
//        manufacture.setId(1L);
//        manufacture.setName("Samsung");
//        phone.setId(1L);
//        phone.setManufacture(manufacture);
//        phone.setName("Galaxy Fold");
//        Phone phone1 = new Phone();
//        phone1.setName("Galaxay S23");
//        phone1.setId(2L);
//        Manufacture manufacture1 = new Manufacture();
//        manufacture1.setId(2L);
//        phone1.setManufacture(manufacture1);
//        manufacture1.setPhones(Collections.singletonList(phone1));
//        manufacture.setPhones(Collections.singletonList(phone));
//
//        Mockito.when(service.getFilterPhone()).thenReturn(Collections.singletonList(phone));
//        assertEquals("Galaxy S23",service.getFilterPhone().get(0).getName());
//    }

    @Test
    void setPhone(){
        Phone phone = new Phone();
        phone.setId(1L);
        phone.setName("Galaxy Fold");
        service.setPhone(phone);
        Mockito.verify(repository).save(captor.capture());
        Phone phone1 = captor.getValue();

        assertEquals("Galaxy Fold",phone1.getName());
    }
}
