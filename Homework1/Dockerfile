FROM bellsoft/liberica-openjdk-alpine:latest

COPY ./src ./sourceMyContainer

RUN javac -sourcepath ./sourceMyContainer -d out sourceMyContainer/Main.java

CMD java -classpath ./out Main