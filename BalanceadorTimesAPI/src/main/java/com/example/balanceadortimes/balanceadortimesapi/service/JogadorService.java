package com.example.balanceadortimes.balanceadortimesapi.service;

import com.example.balanceadortimes.balanceadortimesapi.entity.Jogador;
import com.example.balanceadortimes.balanceadortimesapi.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    public Jogador saveJogador(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    public List<Jogador> findAllJogadores() {
        return jogadorRepository.findAll();
    }

    public Optional<Jogador> findJogadorById(Long id) {
        return jogadorRepository.findById(id);
    }

    public Jogador updateJogador(Long id, Jogador updatedJogador) {
        return jogadorRepository.findById(id)
                .map(jogador -> {
                    jogador.setNome(updatedJogador.getNome());
                    jogador.setNota(updatedJogador.getNota());
                    return jogadorRepository.save(jogador);
                })
                .orElseThrow(() -> new RuntimeException("Não existe um jogador com esse ID"));
    }

    public void deleteJogador(Long id) {
        jogadorRepository.deleteById(id);
    }
}
