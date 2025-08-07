# Soap Webservice

## Propósito
Expor um serviço SOAP para verificar a eligibilidade de um cliente (**CustomerRequest**)

## URL
http://localhost:8080/ws/loanEligibility.wsdl

## Exemplo de payload valido
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:loan="http://www.javatechie.com/spring/soap/api/loanEligibility">
   <soapenv:Header/>
   <soapenv:Body>
      <loan:CustomerRequest>
         <loan:customerName>João da Silva</loan:customerName>
         <loan:age>35</loan:age>
         <loan:yearlyIncome>2000000</loan:yearlyIncome>
         <loan:cibilScore>700</loan:cibilScore>
         <loan:employmentMode>CLT</loan:employmentMode>
      </loan:CustomerRequest>
   </soapenv:Body>
</soapenv:Envelope>
```