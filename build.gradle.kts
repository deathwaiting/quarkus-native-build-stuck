plugins {
    java
    id("io.quarkus")
}

repositories {
    mavenLocal()
    mavenCentral()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    implementation("io.quarkus:quarkus-container-image-jib")
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation("io.quarkus:quarkus-resteasy-reactive-jackson")
    implementation("io.quarkus:quarkus-jaxrs-client-reactive")
    implementation("io.quarkus:quarkus-hibernate-reactive-panache")
    implementation("io.quarkus:quarkus-smallrye-openapi")
//    implementation("io.quarkus:quarkus-smallrye-jwt")
    implementation("io.quarkus:quarkus-liquibase")
    implementation("io.quarkus:quarkus-mailer")
    implementation("io.quarkus:quarkus-reactive-pg-client")
    implementation("io.quarkus:quarkus-smallrye-metrics")
    implementation("io.quarkus:quarkus-arc")
    implementation("io.quarkus:quarkus-oidc")
    implementation("org.hibernate.validator:hibernate-validator")
    implementation("io.quarkus:quarkus-jdbc-postgresql")
    implementation("io.quarkus:quarkus-keycloak-admin-client")
    implementation("io.quarkus:quarkus-cache")
    implementation("org.mapstruct:mapstruct:1.4.1.Final")


    compileOnly("javax.validation:validation-api:2.0.1.Final")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.4.1.Final")


    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.quarkus:quarkus-junit5-mockito")
    testImplementation("io.quarkus:quarkus-test-security-oidc")
    testImplementation("io.rest-assured:rest-assured")
    testImplementation("org.testcontainers:postgresql:1.15.1")
    testImplementation("org.jdbi:jdbi3-core:3.1.0")
    testImplementation("com.tngtech.keycloakmock:mock:0.6.0");
    testImplementation("io.quarkus:quarkus-test-oidc-server")
    testImplementation("uk.co.datumedge:hamcrest-json:0.2")
    testImplementation("org.skyscreamer:jsonassert:1.5.0")
}

group = "com.qu"
version = "1.0.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}


