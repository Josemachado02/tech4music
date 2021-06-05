package br.com.tech4me.tech4music.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.tech4music.model.Musica;
import br.com.tech4me.tech4music.shared.MusicaDto;

public interface MusicaService {
    List<MusicaDto> listarMusicas();

    Optional<MusicaDto> exibirPorId(String id);

    MusicaDto adicionarMusica(Musica musica);

    void removerMusica(String id);

    MusicaDto atulizarMusica(String id, Musica musica);

}
