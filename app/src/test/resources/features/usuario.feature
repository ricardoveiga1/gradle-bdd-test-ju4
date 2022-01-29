# language: pt

Funcionalidade: Gerenciar de um usuário na Petsore

  Algum contexto de negócio
  História do Jura
  Qualquer coisa que faça sentido para negócio

  Cenário: Cria um usuario na loja
    Quando faço um POST para /v3/user com os seguintes valores:
      | id         | 10                |
      | username   | ricardoveiga      |
      | firstName  | ricardo           |
      | lastName   | veiga             |
      | email      | ricardo@gmail.com |
      | password   | 12345             |
      | phone      | 6789              |
      | userStatus | 1                 |
    Então quando faço um GET para /v3/user/ricardo, o usuário criado é retornado


  Cenário: Cria um usuario na loja usando docstring
    Quando faço um POST para /v3/user com os seguintes valores:
        """json
        {
          "id": 10,
          "username": "theUser",
          "firstName": "John",
          "lastName": "James",
          "email": "john@email.com",
          "password": "12345",
          "phone": "12345",
          "userStatus": 1
        }
        """
    Então quando faço um GET para /v3/user/ricardo, o usuário criado é retornado


#  Cenário: Cria um usuario na loja refletindo o negócio
#    Quando crio um usuário
#    Então recebo status code 200
#      E o usuário é salvo no sistema

  Cenário: Cria um usuario na loja refletindo o negócio
    Quando crio um usuário
    Então usuário é salvo no sistema