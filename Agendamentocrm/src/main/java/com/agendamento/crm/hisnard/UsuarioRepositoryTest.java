package com.agendamento.crm.hisnard;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void testFindByUsername() {
        // given
        Usuario usuario = new Usuario();
        usuario.setUsername("john.doe");
        usuario.setPassword("password");
        usuarioRepository.save(usuario);

        // when
        Usuario found = usuarioRepository.findByUsername("john.doe");

        // then
        assertThat(found.getUsername()).isEqualTo(usuario.getUsername());
    }
}