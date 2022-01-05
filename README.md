# Demos Resillence4J
Demos de aplicaciones de Patrones Resillence4J, estas pequeñas aplicaciones en SpringBoot sirven como ejemplos de los articulos expuestos en el [Blog de Mercury|https://mercurytfs.blogspot.com/].

##Instalacion
Una vez clonado el repo, compilar con `mvn` y lanzar el binario generado
```shell
mvn clean compile
cd ./target
java -jar resilenceTest-0.0.1-SNAPSHOT.jar
```
## Ejecución
Si no se cambia en el fichero de configuracion el puerto por defecto del servidor que ofrece Spring Boot, todas las demos deben estar sobre el puerto 8080
### Retry
Invocar 
> http://localhost:8080/retry
