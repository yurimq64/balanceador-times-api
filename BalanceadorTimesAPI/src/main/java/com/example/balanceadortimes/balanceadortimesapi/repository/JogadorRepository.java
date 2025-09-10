package com.example.balanceadortimes.balanceadortimesapi.repository;

import com.example.balanceadortimes.balanceadortimesapi.entity.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {

}
