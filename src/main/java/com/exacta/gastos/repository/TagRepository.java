package com.exacta.gastos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exacta.gastos.entity.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

}
