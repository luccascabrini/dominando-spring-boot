package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1")
public class AnimesController {
    @GetMapping("animes")
    public ArrayList listaDeAnimes(){
        ArrayList animes = new ArrayList<>();
        animes.add("Naruto");
        animes.add("Dragon Ball");
        animes.add("One Piece");
        animes.add("Black Clover");
        animes.add("Boku no hero");
        return animes;
    }

    //outra forma de fazer
    @GetMapping("animes/list")
    public List<String> listaDeAnimesList(){
        return List.of("Nagatoro", "Banana Juice", "Arcane");
    }
}
