FROM eclipse-temurin:17-jdk-alpine


WORKDIR /app


COPY . .


RUN chmod +x ./mvnw


RUN ./mvnw -DoutputFile=target/mvn-dependency-list.log -B -DskipTests clean dependency:list install


CMD ["sh", "-c", "java -jar target/quarkus-app/quarkus-run.jar"]