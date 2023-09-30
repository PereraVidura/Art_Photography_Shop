package com.artShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.artShop.entity.Art;

@Repository
public interface ArtRepository extends JpaRepository<Art,Integer> {

}
