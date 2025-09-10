package com.example.balanceadortimes.balanceadortimesapi.service;

import com.example.balanceadortimes.balanceadortimesapi.entity.Jogador;
import com.example.balanceadortimes.balanceadortimesapi.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BalanceadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    public Map<String, List<Jogador>> balancear(List<Long> jogadoresIds) {

        List<Jogador> jogadoresPresentes = jogadorRepository.findAllById(jogadoresIds);

        if (jogadoresPresentes.size() < 2) {
            throw new RuntimeException("São necessários pelo menos 2 jogadores para formar os times");
        }

        jogadoresPresentes.sort(Comparator.comparing(Jogador::getNota).reversed());

        List<Jogador> timeA = new ArrayList<>();
        List<Jogador> timeB = new ArrayList<>();
        int somatorioNotasTimeA = 0;
        int somatorioNotasTimeB = 0;

        for (Jogador jogador : jogadoresPresentes) {
            if (somatorioNotasTimeA <= somatorioNotasTimeB) {
                timeA.add(jogador);
                somatorioNotasTimeA += jogador.getNota();
            } else {
                timeB.add(jogador);
                somatorioNotasTimeB += jogador.getNota();
            }
        }

        Map<String, List<Jogador>> times = new HashMap<>();
        times.put("timeA", timeA);
        times.put("timeB", timeB);

        return times;
    }
}

