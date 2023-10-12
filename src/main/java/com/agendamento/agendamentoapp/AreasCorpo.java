package com.agendamento.agendamentoapp;
import java.util.ArrayList;
import java.util.List;

public class AreasCorpo {
    private static List<String> areasCorpo;

    public AreasCorpo() {
        areasCorpo = new ArrayList<>();
        // Adicione as áreas de corpo pré-definidas no construtor, se necessário.
        inicializarAreasPreDefinidas();
    }

    // Método para adicionar uma área de corpo
    public void adicionarAreaCorpo(String area) {
        areasCorpo.add(area);
    }

    // Método para listar todas as áreas de corpo
    public List<String> getAreasCorpo() {
        return areasCorpo;
    }

    // Método para inicializar áreas de corpo pré-definidas
    private void inicializarAreasPreDefinidas() {
        areasCorpo.add("Abdômen");
        areasCorpo.add("Braço Esquerdo");
        areasCorpo.add("Braço Direito");
        areasCorpo.add("Perna Esquerda");
        areasCorpo.add("Perna Direita");
        areasCorpo.add("Costas");
        areasCorpo.add("Axila Esquerda");
        areasCorpo.add("Axila Direita");
        areasCorpo.add("Virilha");
        areasCorpo.add("Glúteos");
        areasCorpo.add("Cabeça");
        areasCorpo.add("Ombros");
    }
}
