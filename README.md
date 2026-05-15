
# FeiTv 🎬 - Plataforma de Streaming
**Documentação do Projeto de Ciência da Computação - 3º Ciclo**

**Gabriel Vieira**

---

## 1. Introdução e Contextualização
O **FeiTv** é uma aplicação desktop desenvolvida como projeto prático para a disciplina de Ciência da Computação. O objetivo principal deste projeto é simular uma plataforma de streaming (semelhante a plataformas de mercado), onde os usuários podem explorar um catálogo de filmes e séries e gerir as suas próprias listas de reprodução (Playlists).

Além da funcionalidade para o utilizador final, o projeto foi construído para ser um laboratório prático de **Programação Orientada a Objetos (POO)** e integração com **Bancos de Dados Relacionais**.

---

## 2. Requisitos do Sistema

### 2.1. Requisitos Funcionais (O que o sistema faz)
 **RF01 - Gestão de Acesso:** O sistema deve permitir o cadastro de novos utilizadores e a autenticação (login) para acesso à plataforma.
  
  **RF02 - Catálogo de Vídeos:** O sistema deve listar todos os vídeos disponíveis na plataforma, diferenciando o que é "Filme" e o que é "Série".
  
 **RF03 - Interação com o Conteúdo:** O utilizador deve poder dar "Curtir" (Like) ou "Descurtir" (Dislike) nos vídeos.
  
 **RF04 - Gestão de Playlists (CRUD):** * O usuário pode criar uma nova lista de reprodução.
  * O usuário pode adicionar vídeos específicos a uma lista sua.
  * O usuário pode listar os vídeos que estão dentro de uma playlist.
  * O usuário pode excluir uma lista inteira.

### 2.2. Requisitos Não Funcionais (Como o sistema foi feito)
 **RNF01 - Linguagem:** Desenvolvido em **Java (versão 17+)**.
 
 **RNF02 - Interface:** Interface gráfica construída utilizando a biblioteca **Java Swing** (AWT), com telas configuradas usando *Absolute Layout* para sobreposição de imagens de fundo.
 
 **RNF03 - Persistência de Dados:** Banco de Dados **PostgreSQL**, com comunicação via driver JDBC.
 
 **RNF04 - Arquitetura:** O projeto deve seguir obrigatoriamente os padrões MVC e DAO.

---

## 3. Arquitetura e Padrões de Projeto (Design Patterns)

Para manter o código limpo, organizado e fácil de dar manutenção, o projeto não foi feito num único ficheiro. Foi adotada a seguinte divisão de responsabilidades:

### 3.1. Padrão MVC (Model - View - Controller)
* **Model (Modelo):** Classes responsáveis por representar as entidades do mundo real e as regras de negócio. Ex: `Usuario.java`, `ListaReproducao.java`.
* **View (Visão):** As telas interativas com as quais o utilizador interage. Ex: `TelaLogin.java`, `TelaPrincipal.java`. O código aqui é responsável apenas por "desenhar" botões e capturar cliques, sem fazer regras de banco de dados.
* **Controller (Controlador):** O "cérebro" que liga a View ao Model/DAO. Quando o utilizador clica em "Salvar" na View, o Controller recebe esses dados, verifica se são válidos e manda o DAO salvar. Ex: `ControleUsuario.java`.

### 3.2. Padrão DAO (Data Access Object)
Para não misturar código SQL (banco de dados) com código Java da interface, foi criado o pacote `dao`. Classes como `ListaDAO.java` e `UsuarioDAO.java` contêm todos os `INSERT`, `UPDATE`, `DELETE` e `SELECT`. 

### 3.3. Aplicação de POO: Herança e Encapsulamento
* **Encapsulamento:** Todos os atributos das classes de modelo são `private`. O acesso a eles é feito exclusivamente via métodos `getters` e `setters`, garantindo a proteção dos dados.
* **Herança:** Foi criada uma superclasse (classe pai) chamada `Video.java`, que contém atributos comuns (ID, Título, Curtidas). Dela, herdam duas subclasses (classes filhas):
  * `Filme.java`: Herda de Video e adiciona o atributo específico `duracaoMinutos`.
  * `Serie.java`: Herda de Video e adiciona o atributo específico `temporadas`.

---

## 4. Modelagem do Banco de Dados

A persistência foi feita no PostgreSQL. A modelagem lidou com o desafio de conectar múltiplas tabelas, especialmente a relação "Muitos para Muitos" (N:M) entre Playlists e Vídeos.

### 4.1. Relacionamentos
* **1:N (Usuário e Playlist):** Um usuário pode ter várias playlists, mas uma playlist pertence a apenas um usuário.
* **N:M (Playlist e Vídeos):** Uma playlist pode conter vários vídeos, e um vídeo pode estar em várias playlists de usuários diferentes. Por isso, foi criada a tabela associativa `tblista_video`.

### 4.2. Script SQL (DDL)
```sql
-- 1. Entidade Usuário
CREATE TABLE tbusuarios (
    usuario VARCHAR(50) PRIMARY KEY,
    senha VARCHAR(50) NOT NULL,
    nome VARCHAR(100)
);

-- 2. Entidade Pai (Vídeos)
CREATE TABLE tbvideos (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    tipo VARCHAR(10) NOT NULL, -- Define se a linha é 'Filme' ou 'Serie'
    duracao INT,               
    temporadas INT,            
    curtidas INT DEFAULT 0,
    descurtidas INT DEFAULT 0
);

-- 3. Entidade Playlists
CREATE TABLE tblistas (
    id_lista SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    usuario_id VARCHAR(50) REFERENCES tbusuarios(usuario)
);

-- 4. Tabela Associativa (Resolução de N:M)
CREATE TABLE tblista_video (
    id_lista INT REFERENCES tblistas(id_lista) ON DELETE CASCADE,
    id_video INT REFERENCES tbvideos(id) ON DELETE CASCADE,
    PRIMARY KEY (id_lista, id_video)
);

 ```

## 5. Organização pelo MVC e DAO

<img width="189" height="388" alt="image" src="https://github.com/user-attachments/assets/6228adb0-3f60-4049-ac81-2987ceda403e" />

