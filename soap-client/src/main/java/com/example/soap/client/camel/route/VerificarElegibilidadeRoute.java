package com.example.soap.client.camel.route;

import com.javatechie.spring.soap.api.loaneligibility.Acknowledgement;
import com.javatechie.spring.soap.api.loaneligibility.CustomerRequest;
import com.javatechie.spring.soap.api.loaneligibility.LoanEligibilityIndicator;
import lombok.AllArgsConstructor;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.springframework.stereotype.Component;

import static com.example.soap.client.util.SoapConstants.*;

@Component
@AllArgsConstructor
public class VerificarElegibilidadeRoute extends RouteBuilder {

    public static final String ROUTE = "direct:elegibilidade";
    public static final String ROUTEV2 = "direct:elegibilidadev2";
    private final LoanEligibilityIndicator loanEligibilityClient;

    @Override
    public void configure() throws Exception {
        from(ROUTE)
        .process(exchange -> {
            CustomerRequest request = exchange.getMessage().getBody(CustomerRequest.class);
            Acknowledgement ack = loanEligibilityClient.customer(request);
            exchange.getMessage().setBody(ack);
        });

        from(ROUTEV2)
            .setHeader(CxfConstants.OPERATION_NAME, constant(CUSTOMER))
            .setExchangePattern(ExchangePattern.InOut) //faz o camel esperar o retorno
            .to("cxf://" + URL + "?serviceClass=" + SERVICE_CLASS)
            .process(exchange -> {
                Object[] responseArray = exchange.getMessage().getBody(Object[].class);
                Acknowledgement ack = (Acknowledgement) responseArray[0];
                exchange.getMessage().setBody(ack);
            });
    }
}
