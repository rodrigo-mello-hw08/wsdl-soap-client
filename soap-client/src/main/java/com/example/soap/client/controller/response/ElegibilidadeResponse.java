package com.example.soap.client.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElegibilidadeResponse {
    private Boolean elegivel;
    private Long quantiaAprovada;
    private List<String> listaDeInfracoes;
}