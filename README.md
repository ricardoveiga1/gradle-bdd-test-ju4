## Projeto para rest apis com BDD(cucumber)


## Referências
- https://github.com/cucumber/cucumber-expressions#readme


- Alt + Enter : para criar os steps definitions no mac e intellij
- open app/build/reports/feature.html   no terminal
- ./gradlew clean -  limpa pasta build com os compilados
- ./gradlew test - com inclusão do CucumberRunner o gradlew identifica os testes

## Anotações
 - Breve explicação do projeto: criamos um builder padrão chamado user, utilizamos o mesmo para criar usuário padrão e usamos hooks para deleção ao final do teste. Implementamos o conceito de designer client api para criar as chamadas das Apis e posteriormente executar os testes de forma mais limpa.