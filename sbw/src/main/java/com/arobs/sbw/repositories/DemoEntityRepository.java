package com.arobs.sbw.repositories;

import com.arobs.sbw.model.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoEntityRepository extends JpaRepository<DemoEntity, Integer> {
}
