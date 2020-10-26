# language: pt
Funcionalidade: Cadastrar de Usuários
  Sendo um usuário
  Quero efetuar o cadastro no site das Lojas Americanas
  Para fazer compras

  Cenario: Cadastrar e-mail existente
    Dado que estou na home das Lojas Americanas
    E cliquei em cliente novo? Cadastrar
    E preenchi o e-mail com "teste@hotmail.com"
    E preenchi a senha com "teste"
    Quando clicar em Criar seu cadastro
    Então devo receber a mensagem "E-mail já cadastrado"

  Cenario: Cadastrar senha fraca
    Dado que estou na home das Lojas Americanas
    E cliquei em cliente novo? Cadastrar
    E preenchi o e-mail com "teste@hotmail.com"
    Quando preencher a senha com "ab"
    Então devo receber a mensagem "fraca

  Cenario: Cadastrar CPF inválido
    Dado que estou na home das Lojas Americanas
    E cliquei em cliente novo? Cadastrar
    E preenchi o e-mail com "teste@hotmail.com"
    Quando preencher o CPF com  "444"
    Então devo receber a mensagem "CPF inválido"