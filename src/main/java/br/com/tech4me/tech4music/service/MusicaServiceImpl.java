package br.com.tech4me.tech4music.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.tech4music.model.Musica;
import br.com.tech4me.tech4music.repository.MusicaRepository;
import br.com.tech4me.tech4music.shared.MusicaDto;

@Service
public class MusicaServiceImpl implements MusicaService {
    @Autowired
    private MusicaRepository repositorio;


    @Override
    public List<MusicaDto> listarMusicas() {
        List<Musica> music = repositorio.findAll();
        return music.stream()
        .map(m -> new ModelMapper().map(m, MusicaDto.class))
        .collect(Collectors.toList()); 
       
    }


    @Override
    public Optional<MusicaDto> exibirPorId(String id) {
       Optional<Musica> music = repositorio.findById(id);

       if(music.isPresent()){
           return Optional.of(new ModelMapper().map(music.get(), MusicaDto.class));
       }
        return Optional.empty();
    }


    @Override
    public MusicaDto adicionarMusica(Musica musica) {
        repositorio.save(musica);
        return new ModelMapper().map(musica, MusicaDto.class);
    }


    @Override
    public void removerMusica(String id) {
        repositorio.deleteById(id);
        
    }


    @Override
    public MusicaDto atulizarMusica(String id, Musica musica) {
        musica.setId(id);
        repositorio.save(musica);
        return new ModelMapper().map(musica, MusicaDto.class);
    }


  
    
}
