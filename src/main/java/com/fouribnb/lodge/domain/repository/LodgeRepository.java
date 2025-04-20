package com.fouribnb.lodge.domain.repository;

import com.fouribnb.lodge.domain.entity.Lodge;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LodgeRepository {
    Lodge save(Lodge lodge);

    Optional<Lodge> findById(UUID id);

    Page<Lodge> findAll(Pageable pageable);

    Page<Lodge> findAllByUserId(Pageable pageable, Long currentUserId);
}
