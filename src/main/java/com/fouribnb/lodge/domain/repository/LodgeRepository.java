package com.fouribnb.lodge.domain.repository;

import com.fouribnb.lodge.domain.entity.Lodge;

public interface LodgeRepository {
    Lodge save(Lodge lodge);
}
