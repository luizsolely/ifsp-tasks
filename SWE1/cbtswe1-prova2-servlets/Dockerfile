FROM maven:3.9.9-eclipse-temurin-21-alpine AS build

WORKDIR /app

COPY pom.xml .
RUN mvn -q -DskipTests dependency:go-offline

COPY src ./src
RUN mvn -q -DskipTests package

FROM eclipse-temurin:21-jre-alpine

ARG TOMCAT_VERSION=9.0.106
ENV CATALINA_HOME=/opt/tomcat
ENV PATH="${CATALINA_HOME}/bin:${PATH}"

RUN apk add --no-cache curl tar \
    && curl -fsSL "https://archive.apache.org/dist/tomcat/tomcat-9/v${TOMCAT_VERSION}/bin/apache-tomcat-${TOMCAT_VERSION}.tar.gz" \
        | tar -xz -C /opt \
    && mv "/opt/apache-tomcat-${TOMCAT_VERSION}" "${CATALINA_HOME}" \
    && rm -rf "${CATALINA_HOME}/webapps/"* \
        "${CATALINA_HOME}/bin/"*.bat \
        "${CATALINA_HOME}/temp/"* \
        "${CATALINA_HOME}/logs/"*

WORKDIR ${CATALINA_HOME}

COPY --from=build /app/target/cbtswe1-prova2.war ${CATALINA_HOME}/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
