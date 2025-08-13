package com.example.soap.client.mapper;

import com.example.soap.client.controller.request.ElegibilidadeRequest;
import com.example.soap.client.controller.response.ElegibilidadeResponse;
import com.javatechie.spring.soap.api.loaneligibility.Acknowledgement;
import com.javatechie.spring.soap.api.loaneligibility.CustomerRequest;
import com.javatechie.spring.soap.api.loaneligibility.ObjectFactory;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ElegibilidadeMapper {

    public static CustomerRequest map(ElegibilidadeRequest request) {
        CustomerRequest customer = new ObjectFactory().createCustomerRequest();
        customer.setCustomerName(request.getNomeDoCliente());
        customer.setAge(request.getIdade());
        customer.setCibilScore(request.getScore());
        customer.setEmploymentMode(request.getModeloDeTrabalho());
        customer.setYearlyIncome(request.getEntrada());
        return customer;
    }

    public static ElegibilidadeResponse map(Acknowledgement response) {
        if (response == null) {
            return new ElegibilidadeResponse();
        }
        return new ElegibilidadeResponse(response.isIsEligible(), response.getApprovedAmount(), response.getCriteriaMismatch());
    }
}
