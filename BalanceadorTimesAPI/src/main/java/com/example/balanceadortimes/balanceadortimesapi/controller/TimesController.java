package com.example.balanceadortimes.balanceadortimesapi.controller;

import com.example.balanceadortimes.balanceadortimesapi.entity.Jogador;
import com.example.balanceadortimes.balanceadortimesapi.service.BalanceadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/times")
public class TimesController {

    @Autowired
    private BalanceadorService balanceadorService;

    @PostMapping("/balancear")
    public Map<String, List<Jogador>> balancearTimes(@RequestBody List<Long> jogadoresIds) {
        return balanceadorService.balancear(jogadoresIds);
    }
}
