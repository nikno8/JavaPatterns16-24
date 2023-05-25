package com.nikno8.java_mirea.pract16.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nikno8.java_mirea.pract16.entity.Manufacture;
import com.nikno8.java_mirea.pract16.entity.Phone;
import com.nikno8.java_mirea.pract16.repository.ManufactureRepository;
import com.nikno8.java_mirea.pract16.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class SchedulerServiceImpl implements SchedulerService{
    @Autowired
    ManufactureRepository repository1;
    @Autowired
    PhoneRepository repository2;
    private boolean enabled = true;

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    @Scheduled(initialDelay = 1L,fixedDelay = 30L,timeUnit = TimeUnit.MINUTES)
    @Transactional
    public void doScheduledTask() {
        if(enabled) {
            Path path = Path.of("/Users/vyacheslavbotoev/myfiles");
            try {
                Files.deleteIfExists(Path.of(path.toString() + "/Phones.json"));
                Files.deleteIfExists(Path.of(path.toString() + "/Manufactures.json"));
                Files.deleteIfExists(path);
                Files.createDirectories(path);
                List<Manufacture> manufactures = repository1.findAll();
                List<Phone> phones = repository2.findAll();
                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(new File(path.toString() + "/Manufactures.json"), manufactures);
                mapper.writeValue(new File(path.toString() + "/Phones.json"), phones);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
