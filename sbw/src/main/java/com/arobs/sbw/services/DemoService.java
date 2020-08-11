package com.arobs.sbw.services;

import com.arobs.sbw.model.DemoEntity;
import com.arobs.sbw.repositories.DemoEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Autowired
    private DemoEntityRepository demoRepository;

    public int createEntity(DemoEntity entity) {
        return demoRepository.saveAndFlush(entity).getId();
    }
}
