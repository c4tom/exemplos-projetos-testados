Exemplo de um projeto com JSF + Primefaces + Hibernate + MySQL

## Créditos
 - http://www.feltex.com.br/felix/exemplo-completo-com-jsf-primefaces-hibernate-mysql/
 - https://www.roseindia.net/hibernate/hibernate5/hibernate-5-hello-world.shtml

Obs: Neste exemplo, adicionei o maven

## Requisitos

- Tomcat 8
- Maven 3.x
- Docker / Docker Toolbox (para windows 10 HOME) / Docker CE (Windows 10 PRO/Interprise)
- Git (linha de comando)

```
# Comando para iniciar um projeto Maven
mvn archetype:generate -DgroupId=com.cht -DartifactId=jphm -DarchetypeArtifactId=maven-archetype-webapp

# Comando para gerar o projeto para eclipse
cd jphm; mvn eclipse:eclipse -Dwtpversion=2.0
```