2# Automação de Testes de API usando BDD


## Referências
- https://github.com/cucumber/cucumber-expressions#readme
- https://docs.groovy-lang.org/next/html/documentation/working-with-collections.html


- Alt + Enter : para criar os steps definitions no mac e intellij
- open app/build/reports/feature.html   no terminal
- ./gradlew clean -  limpa pasta build com os compilados
- ./gradlew test - com inclusão do CucumberRunner o gradlew identifica os testes

## Anotações
 - Breve explicação do projeto: criamos um builder padrão chamado user, utilizamos o mesmo para criar usuário padrão e usamos hooks para deleção ao final do teste. 
 - Implementamos o conceito de designer client api para criar as chamadas das Apis e posteriormente executar os testes de forma mais limpa.
 - Podemos criar uma estratégia de seed(semente), para inputar dados automaticamente e executar nossos testes mais controlados
 - https://github.com/cucumber/cucumber-expressions#readme para aprender a transformar as palavras do cenário em variável
 - Devemos instalar o groovy para ajudar com groovy colletctions, possui um alto poder de facilitar as ASSERTIVAS
 - Para facilitar as ASSERTIVAS devo utilizar Groovy Collection, porque se não teria que varrer, checar se eles possuem, tratar o objeto 
 - https://docs.groovy-lang.org/next/html/documentation/working-with-collections.html
 - BUILDER : é uma classe que monta outra classe para facilitar e reduzir verbosidade




### Requisitos:
* Java 11
* Gradle 6.7+
* Docker


### Executar os Testes Localmente
* Subir a loja Swagger Pet Store - `docker run  --name petstore -d -p 12345:8080 swaggerapi/petstore3:unstable`
* Rodar os testes - `./gradlew test`
* Relatório do Cucumber - `app/build/reports/feature.html`