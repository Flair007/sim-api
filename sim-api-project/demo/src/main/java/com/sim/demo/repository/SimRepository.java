package com.sim.demo.repository;

import com.sim.demo.entity.Sim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimRepository extends JpaRepository<Sim,Integer> {
}
