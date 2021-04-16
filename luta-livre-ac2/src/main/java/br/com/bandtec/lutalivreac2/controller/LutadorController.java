package br.com.bandtec.lutalivreac2.controller;

import br.com.bandtec.lutalivreac2.classes.Lutador;
import br.com.bandtec.lutalivreac2.repository.LutadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lutadores")
public class LutadorController {

    @Autowired
    private LutadorRepository lutadorRepository;

    @GetMapping
    public ResponseEntity getLutadores(){
        return ResponseEntity.status(200).body(lutadorRepository.findAll());
    }

    @GetMapping("/contagem-vivos")
    public ResponseEntity getLutadoresVivos(){
        return ResponseEntity.status(200).body(lutadorRepository.findByVidaGreaterThan(0.0));
    }

    @PostMapping
    public ResponseEntity postLutador(@RequestBody Lutador novoLutador){
        lutadorRepository.save(novoLutador);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/{id}/concentrar")
    public ResponseEntity postConcentrar(@PathVariable("id") Integer id){
        lutadorRepository.updateLutadorConcentracao(id);
        return  ResponseEntity.status(200).build();
    }

    @PostMapping("/golpe")
    public ResponseEntity postGolpear(){

    }

    @GetMapping("/mortos")
    public  ResponseEntity getLutadoresMortos(){
        return ResponseEntity.status(200).body(lutadorRepository.findByVidaEquals(0.0));
    }

}
