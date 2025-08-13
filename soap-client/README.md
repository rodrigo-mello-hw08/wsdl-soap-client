# Proposito
Construir um serviço Client SOAP que chamasse o servidor atraves da lib camel-cxf-soap-starter

## Referências

https://www.youtube.com/watch?v=2NXIhZSZvMc
https://www.youtube.com/watch?v=96KpSllZQ20
https://camel.apache.org/components/4.10.x/cxf-component.html

## URL do serviço
POST http://localhost:9090/elegibilidade

## Exemplo de entrada
{
"nomeDoCliente": "João da Silva",
"idade": 35,
"entrada": 2000000,
"score":"700",
"modeloDeTrabalho": "CLT"
}

## Exemplo de saida
{
"elegivel": false,
"quantiaAprovada": 0,
"listaDeInfracoes": [
"Person age should be in between 30 and 60"
]
}