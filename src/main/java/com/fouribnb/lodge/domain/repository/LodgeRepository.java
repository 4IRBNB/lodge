package com.fouribnb.lodge.domain.repository;

import com.fouribnb.lodge.domain.entity.Lodge;
import java.util.Optional;
import java.util.UUID;

public interface LodgeRepository {
    Lodge save(Lodge lodge);

    Optional<Lodge> findById(UUID id);
}
