package com.kosh.pastebox.repository;

import com.kosh.pastebox.entity.PasteBoxEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasteboxRepository extends JpaRepository<PasteBoxEntity, Long> {

    PasteBoxEntity findByHash(String hash);

}
