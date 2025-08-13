package com.example.soap.client.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElegibilidadeRequest {
    private String nomeDoCliente;
    private Integer idade;
    private Long entrada;
    private Integer score;
    private String modeloDeTrabalho;
}
