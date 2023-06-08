package com.mapping.one_to_one.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapping.one_to_one.entity.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop,Integer>{

}
