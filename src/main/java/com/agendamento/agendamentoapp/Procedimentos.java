package com.agendamento.agendamentoapp;

import java.util.ArrayList;
import java.util.List;

public class Procedimentos {
    public static List<Procedimento> getProcedimentosPredefinidos() {
        List<Procedimento> procedimentos = new ArrayList<>();
        procedimentos.add(new Procedimento("Depilação a Laser", "Remoção de pelos com laser", 100.0));
        procedimentos.add(new Procedimento("Remoção de Tatuagem", "Remoção de tatuagens indesejadas", 150.0));
        // Adicione outros procedimentos predefinidos aqui, se necessário
        return procedimentos;
    }
}
