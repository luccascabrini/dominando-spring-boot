package com.example.Domain;

import java.util.List;
import java.util.stream.Collectors;

public class Anime {
    private int id;
    private  String name;
    public Anime(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Anime> listaAnimes(){
        return List.of(
                new Anime(1, "Dragon ball"),
                new Anime(2, "One Piece"),
                new Anime(3, "Naruto")
        );
    }

    public static List<String> listaAnimesNomes(){
        return listaAnimes().stream()
                .map(Anime::getName)
                .collect(Collectors.toList());
    }
}
