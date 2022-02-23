# language: pt

Funcionalidade: Gerenciar de um animal da loja

  Cenário: Lista somente animais disponíveis para a venda
    Dado que eu possua animais available
    Quando eu pesquiso por todos os animais available
    Então eu recebo a lista de animais available
#  Passo desnecessário, somente para exemplo
    E eu recebo uma outra lista de animais available


  Cenário: Lista somente animais pending
    Dado que eu possua animais pending
    Quando eu pesquiso por todos os animais pending
    Então eu recebo a lista com 2 animais

  Cenário: Não lista nenhum animal
    Dado que eu não possua animais sold
    Quando eu pesquiso por todos os animais sold
    Então eu recebo a lista com 0 animal