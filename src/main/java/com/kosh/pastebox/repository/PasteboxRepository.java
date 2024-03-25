package com.kosh.pastebox.repository;

import com.kosh.pastebox.entity.PasteBoxEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PasteboxRepository extends JpaRepository<PasteBoxEntity, Long> {

    PasteBoxEntity findByHash(String hash);

    @Query(value = "SELECT MAX(id) as max_id FROM PasteBoxEntity")
    Long findMaxHash();

}
