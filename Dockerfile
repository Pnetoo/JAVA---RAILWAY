FROM eclipse-temurin:21-jdk-alpine

# Instala bash (necessário para rodar ./mvnw corretamente em Alpine)
RUN apk add --no-cache bash

WORKDIR /app

# Copia os arquivos essenciais primeiro
COPY mvnw .
COPY mvnw.cmd .
COPY .mvn/ .mvn/
COPY pom.xml .
COPY src/ src/

# Dá permissão de execução ao mvnw
RUN chmod +x ./mvnw

# Usa bash para executar o script mvnw corretamente
RUN /bin/bash ./mvnw -DoutputFile=target/mvn-dependency-list.log -B -DskipTests clean dependency:list install

# Executa a aplicação
CMD ["sh", "-c", "java -jar target/quarkus-app/quarkus-run.jar"]
