package com.agendamento.crm.controller;

//nunca jamais ousem tocar no codigo de novo ass Leandro (sem alterações)

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendamento.crm.model.Clientes;
import com.agendamento.crm.repository.ClientesRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClientesRepository clientesRepository;

    @PostMapping
    public ResponseEntity<?> adicionarCliente(@RequestBody Clientes cliente) {
        // Verifica se o CPF é válido
        if (!validarCpf(cliente.getCpf())) {
            return ResponseEntity.badRequest().body("CPF inválido.");
        }
        // Valida a senha
        if (!validarSenha(cliente.getSenha())) {
            return ResponseEntity.badRequest().body("A senha deve ter pelo menos 8 caracteres, um caractere maiúsculo, um caractere minúsculo, um número e um caractere especial.");
        }
        // Salva o cliente no banco de dados
        clientesRepository.save(cliente);
        return ResponseEntity.ok(cliente);
        
    }

    @GetMapping
    public List<Clientes> listarClientes() {
        return clientesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clientes> buscarCliente(@PathVariable Long id) {
        Optional<Clientes> cliente = clientesRepository.findById(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCliente(@PathVariable Long id, @RequestBody Clientes cliente) {
        Optional<Clientes> clienteExistente = clientesRepository.findById(id);
        if (clienteExistente.isPresent()) {
            // Verifica se o CPF é válido
            if (!validarCpf(cliente.getCpf())) {
                return ResponseEntity.badRequest().body("CPF inválido.");
            }
            // Valida a nova senha, se informada
            if (cliente.getSenha() != null && !cliente.getSenha().isEmpty() && !validarSenha(cliente.getSenha())) {
                return ResponseEntity.badRequest().body("A nova senha deve ter pelo menos 8 caracteres, um caractere maiúsculo, um caractere minúsculo, um número e um caractere especial.");
            }
            // Atualiza os dados do cliente
            Clientes clienteAtualizado = clienteExistente.get();
            clienteAtualizado.setNome(cliente.getNome());
            clienteAtualizado.setNaturalidade(cliente.getNaturalidade());
            clienteAtualizado.setCpf(cliente.getCpf());
            clienteAtualizado.setDataNascimento(cliente.getDataNascimento());
            clienteAtualizado.setEndereco(cliente.getEndereco());
            clienteAtualizado.setBairro(cliente.getBairro());
            clienteAtualizado.setCidade(cliente.getCidade());
            clienteAtualizado.setEstado(cliente.getEstado());
            clienteAtualizado.setSexo(cliente.getSexo());
            clienteAtualizado.setTipoSanguineo(cliente.getTipoSanguineo());
            if (cliente.getSenha() != null && !cliente.getSenha().isEmpty()) {
                clienteAtualizado.setSenha(cliente.getSenha());
            }
            clienteAtualizado.setEmail(cliente.getEmail());
            clienteAtualizado.setTelefone(cliente.getTelefone());
            clientesRepository.save(clienteAtualizado);
            return ResponseEntity.ok(clienteAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerCliente(@PathVariable Long id) {
        Optional<Clientes> cliente = clientesRepository.findById(id);
        if (cliente.isPresent()) {
            clientesRepository.delete(cliente.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
		public static boolean validarCpf(String cpf) {
		    cpf = cpf.replaceAll("[^0-9]", ""); // Remove caracteres não numéricos
		    if (cpf.length() != 11) {
		        return false;
		    }
		    int[] digitos = new int[11];
		    for (int i = 0; i < 11; i++) {
		        digitos[i] = Integer.parseInt(cpf.substring(i, i + 1));
		    }
		    // Verifica se todos os dígitos são iguais
		    if (digitos[0] == digitos[1] && digitos[1] == digitos[2] && digitos[2] == digitos[3] &&
		        digitos[3] == digitos[4] && digitos[4] == digitos[5] && digitos[5] == digitos[6] &&
		        digitos[6] == digitos[7] && digitos[7] == digitos[8] && digitos[8] == digitos[9] &&
		        digitos[9] == digitos[10]) {
		        return false;
		    }
		    // Verifica o primeiro dígito verificador
		    int soma = 0;
		    for (int i = 0; i < 9; i++) {
		        soma += digitos[i] * (10 - i);
		    }
		    int resto = soma % 11;
		    int digitoVerificador1 = resto < 2 ? 0 : 11 - resto;
		    if (digitos[9] != digitoVerificador1) {
		        return false;
		    }
		    // Verifica o segundo dígito verificador
		    soma = 0;
		    for (int i = 0; i < 10; i++) {
		        soma += digitos[i] * (11 - i);
		    }
		    resto = soma % 11;
		    int digitoVerificador2 = resto < 2 ? 0 : 11 - resto;
		    if (digitos[10] != digitoVerificador2) {
		        return false;
		    }
		    return true;
		}
  

    public static boolean validarSenha(String senha) {
        // Verifica se a senha tem pelo menos 8 caracteres
        if (senha.length() < 8) {
            return false;
        }
        // Verifica se a senha contém pelo menos um caractere maiúsculo, um caractere minúsculo, um número e um caractere especial
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(senha);
        return matcher.matches();
    }

}