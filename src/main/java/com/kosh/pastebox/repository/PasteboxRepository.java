package com.kosh.pastebox.repository;

import com.kosh.pastebox.entity.PasteBoxEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PasteboxRepository extends JpaRepository<PasteBoxEntity, Long> {

    PasteBoxEntity findByHash(String hash);

    @Query(value = "SELECT MAX(id) as max_id FROM PasteBoxEntity")
    Long findMaxHash();

    @Query(value = "SELECT * FROM pastebox WHERE is_public = true AND lifetime > current_timestamp " +
            "ORDER BY id DESC LIMIT :amount", nativeQuery = true)
    List<PasteBoxEntity> getListOfPublicAndAlive(@Param("amount") int amount);

}
