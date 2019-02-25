package com.prj.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prj.spring.boot.domain.Criticism;

public interface CriticismRepository extends JpaRepository<Criticism, Long> {

}
