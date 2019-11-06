package com.github.rkruk.spring.demo.model.repositories;

import com.github.rkruk.spring.demo.model.domain.Advert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertRepository extends JpaRepository<Advert, Long> {
}
