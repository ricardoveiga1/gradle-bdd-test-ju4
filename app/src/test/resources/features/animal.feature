# language: pt

Funcionalidade: Gerenciar de um animal da loja

  Cenário: Lista somente animais disponíveis para a venda
    Dado que eu possua animais dispiníveis
    Quando eu pesquiso por todos os animais disponíveis
    Então eu recebo a lista de animais disponíveis
