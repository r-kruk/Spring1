package com.github.rkruk.spring.demo.model.repositories;

import com.github.rkruk.spring.demo.model.domain.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertRepository extends JpaRepository<Advert, Long> {

//    List<Advert> findAllByUser (User user);

    List<Advert> findAllByOrderByPostedDesc ();
}
