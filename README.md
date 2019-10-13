# CURSO JAVA REST

## END-POINTS

- Principal da api - `/api`
***
- [GET] buscar todas as contas: `/api/conta` <br>
- [GET] buscar conta por id: `/api/conta/{id}` <br>
- [POST] inserir conta: `/api/conta` <br>
- [PUT] alterar conta: `/api/conta/{id}` <br>
- [DELETE] deletar conta: `/api/conta/{id}` <br>
***
- [GET] buscar todas as pessoas: `/api/pessoa` <br>
- [GET] buscar pessoa por id: `/api/pessoa/{id}` <br>
- [POST] inserir pessoa: `/api/pessoa` <br>
- [PUT] alterar pessoa: `/api/pessoa/{id}` <br>
- [DELETE] deletar pessoa: `/api/pessoa/{id}` <br>
***
- [GET] 'instanciar' um banco de dados: `/api/bd` (só funciona com o TomEE :D)

# Observações

## TomEE (TomEE 7.1.1 webprofile)

- As informações do banco deverão estar contidas no arquivo `resources/META-INF/resources.xml`<br>
- O EntityManager ( no arquivo `DAO/GenericDAO.java`) deve ser instânciado da seguinte forma: <br> `@PersistenceContext(unitName = "PU")` <br> `EntityManager em;`
- Se preferir você pode remover as seguintes linhas do arquivo `resources/META-INF/persistence.xml` <br> `<property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver" />` <br> `<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/curso-java-rest" />` <br> `<property name="javax.persistence.jdbc.user" value="root" />` <br> `<property name="javax.persistence.jdbc.password" value="" />`<br>


## Jboss (WildFly 17.0.1)

- As informações do banco deverão estar contidas no arquivo `resources/META-INF/persistence.xml`
- O EntityManager ( no arquivo `DAO/GenericDAO.java`) deve ser instânciado da seguinte forma: <br> `EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU");` <br> `EntityManager em = entityManagerFactory.createEntityManager();`
- Se preferir você pode remover o arquivo `resources/META-INF/resources.xml`

## Aplicação Web (AngularJS)                                                                                                                                                                        

- Está contida na pasta `webapp` <br>
- Fica no endereço raiz/root da sua aplicação ex: `localhost:8080/curso/`

## Aplicação Rest

- Está contida na pasta `java`<br>
- As requisições serão feitas apartir do endereço raiz/root ex: [GET] `localhost:8080/curso/api/pessoa/1`

                                                                                                                                                                            