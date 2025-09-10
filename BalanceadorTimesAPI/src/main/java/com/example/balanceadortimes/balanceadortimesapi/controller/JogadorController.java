package com.example.balanceadortimes.balanceadortimesapi.controller;

import com.example.balanceadortimes.balanceadortimesapi.entity.Jogador;
import com.example.balanceadortimes.balanceadortimesapi.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @PostMapping
    public Jogador criarJogador(@RequestBody Jogador jogador) {
        return jogadorService.saveJogador(jogador);
    }

    @GetMapping
    public List<Jogador> listarJogadores() {
        return jogadorService.findAllJogadores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> listarJogadorPorId(@PathVariable Long id) {
        return jogadorService.findJogadorById(id)
                .map(jogador -> new ResponseEntity<>(jogador, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public Jogador atualizarJogador(@PathVariable Long id, @RequestBody Jogador updatedJogador) {
        return jogadorService.updateJogador(id, updatedJogador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirJogador(@PathVariable Long id) {
        jogadorService.deleteJogador(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
