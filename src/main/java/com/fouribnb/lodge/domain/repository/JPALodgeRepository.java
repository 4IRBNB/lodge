package com.fouribnb.lodge.domain.repository;

import com.fouribnb.lodge.domain.entity.Lodge;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPALodgeRepository extends LodgeRepository, JpaRepository<Lodge, UUID> {

}
