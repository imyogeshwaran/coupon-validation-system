FROM eclipse-temurin:17-jdk
COPY target/coupon-validation-system-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]