package com.example.Controller;

import com.example.Domain.Anime;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = {"v1/animes", "v1/animes/"})
public class AnimesController {

    private List<String> animes;
    private List<Anime> animes1;
    //    @GetMapping("animes")
//    public ArrayList listaDeAnimes(){
//        ArrayList animes = new ArrayList<>();
//        animes.add("Naruto");
//        animes.add("Dragon Ball");
//        animes.add("One Piece");
//        animes.add("Black Clover");
//        animes.add("Boku no hero");
//        return animes;
//    }
//
//    //outra forma de fazer
//    @GetMapping("animes/list")
//    public List<String> listaDeAnimesList(){
//        return List.of("Nagatoro", "Banana Juice", "Arcane");
//    }

    @GetMapping("listaAnimes")
    public List<String> listaDeAnimes(){
        animes = Anime.listaAnimesNomes();
        return animes;
    }

    //http://localhost:8080/v1/animes/buscarPorNome?name=Dragon
    @GetMapping("buscarPorNome")
    public List<String> buscarAnimesPorNome(@RequestParam String name){
        List<Anime> animes = Anime.listaAnimes();
        List<String> nomesFiltrados = animes.stream()
                .filter(anime -> anime.getName().contains(name))
                .map(Anime::getName)
                .collect(Collectors.toList());
        return nomesFiltrados;
    }

    @GetMapping("buscarPorId/{id}")
    public List<Anime> buscarAnimePorId(@PathVariable int id){
        List<Anime> animes = Anime.listaAnimes();
        return animes.stream().filter(n -> n.getId() == id)
                .findFirst()
                .map(Collections::singletonList)  // Transforma o Anime em uma lista
                .orElseGet(Collections::emptyList);
    }
}

