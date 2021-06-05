package br.com.tech4me.tech4music.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.tech4music.model.Musica;
import br.com.tech4me.tech4music.service.MusicaService;
import br.com.tech4me.tech4music.shared.MusicaDto;



@RestController
@RequestMapping("/api/musicas")
public class MusicaController {
    @Autowired
    private MusicaService serv;

    @GetMapping
    public ResponseEntity<List<MusicaDto>>listarMusicas(){
        return new ResponseEntity<>(serv.listarMusicas(), HttpStatus.OK);
    }
    

    @GetMapping(value = "/{id}")
    public ResponseEntity<MusicaDto> exibirPorId(@PathVariable String id){
        Optional<MusicaDto> music = serv.exibirPorId(id);

        if(music.isPresent()){
            return new ResponseEntity<>(music.get(), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<MusicaDto> addMusica(@RequestBody @Valid Musica musica){
        return new ResponseEntity<>(serv.adicionarMusica(musica), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
        public ResponseEntity<Void> removerMusica(@PathVariable String id){
            serv.removerMusica(id);
            Optional<MusicaDto> music = serv.exibirPorId(id);

            if(music.isPresent()){
                serv.removerMusica(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<MusicaDto> atualizarMusica(@PathVariable String id,  @RequestBody Musica musica){
        return new ResponseEntity<>(serv.atulizarMusica(id, musica), HttpStatus.OK);

    }

}
