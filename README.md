# Free Sound Test

Este é um projeto de testes automatizado de API usando RestAssured. 

Foi usado a API do [Free Sound](https://freesound.org/docs/api/).

## Execução

### Properties

Para fazer execução deste é necessario informar o arquivo ` freesound.properties`, conforme descrito na [doc](https://freesound.org/docs/api/authentication.html) do freesound

```properties
base.uri = https://freesound.org/ #uri da api freesound

freesound.api.token.enable=true #hablita execucao via apitoken ou Oauth2
freesound.api.token= #api token do freesound

freesound.client.id = #client id da api
freesound.client.secret = #client secret da api
freesound.grant_type = #grant_type usando pela api. ex: authorization_code
freesound.code = #code de autorizacao da api
```

### Rodando os testes

via Maven
```shell
mvn test
```
via Maven Wrapper

```shell
./mvnw test
```


### Gerando Allure Report

via Maven
```shell
mvn allure:report
```
via Maven Wrapper
```shell
./mvnw allure:report
```

### Gerando Allure Report via serve
via Maven
```shell
mvn allure:serve
```
via Maven Wrapper
```shell
./mvnw allure:serve
```