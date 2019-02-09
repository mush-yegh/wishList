package com.wishlist.persistance.repository;

import com.wishlist.persistance.entity.SentRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SentRequestRepository  extends JpaRepository<SentRequestEntity,Long> {
}
