FROM openjdk:11
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
#RUN javac main.java
#CMD ["java", "main"]