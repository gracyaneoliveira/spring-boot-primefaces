package com.demo.prime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.prime.domain.Rss;

@Repository
public interface RssRepository extends JpaRepository<Rss, Long>{

}
