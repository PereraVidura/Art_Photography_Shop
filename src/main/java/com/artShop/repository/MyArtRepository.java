package com.artShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.artShop.entity.MyArtList;

@Repository
public interface MyArtRepository extends JpaRepository<MyArtList, Integer> {

}
