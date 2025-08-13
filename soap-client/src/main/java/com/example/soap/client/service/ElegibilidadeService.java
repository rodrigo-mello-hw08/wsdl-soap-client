package com.example.soap.client.service;

import com.example.soap.client.controller.request.ElegibilidadeRequest;
import com.example.soap.client.controller.response.ElegibilidadeResponse;
import com.example.soap.client.mapper.ElegibilidadeMapper;
import com.javatechie.spring.soap.api.loaneligibility.Acknowledgement;
import com.javatechie.spring.soap.api.loaneligibility.CustomerRequest;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Service;

import static com.example.soap.client.camel.route.VerificarElegibilidadeRoute.ROUTE;

@Service
public class ElegibilidadeService {

    private final ProducerTemplate template;

    public ElegibilidadeService(ProducerTemplate template) {
        this.template = template;
    }

    public ElegibilidadeResponse verificar(ElegibilidadeRequest request) {
        CustomerRequest customerRequest = ElegibilidadeMapper.map(request);
        Acknowledgement response = template.requestBody(ROUTE, customerRequest, Acknowledgement.class);
        return ElegibilidadeMapper.map(response);
    }

}
