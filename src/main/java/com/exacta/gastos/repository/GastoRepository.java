package com.exacta.gastos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exacta.gastos.entity.Gasto;

@Repository
public interface GastoRepository extends CrudRepository<Gasto, Long> {

}
