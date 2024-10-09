package org.example.miniprojetspring.repository;

import org.example.miniprojetspring.entity.Case;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICaseRepository extends JpaRepository<Case,Integer> {
}
