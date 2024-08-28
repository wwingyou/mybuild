# mybuild

This is a java build tool made for packaging project into jar or war file for educational purpose.

## JAR and WAR

JAR, which stands for "Java ARchive", is a format that aggregates classes and metadata. It was orignally designed for serving 'Applets', which are small executable programs that run inside web browser with JVM support, through a network. Downloading an applet as a JAR file is much faster than downloading each class file individually. Even though Java Applets are no longer supported, JAR remains a standard way to deploy Java libraries and executable application.

A JAR has special directory called `META-INF`. Files inside this directory (like `MANIFEST.MF`) are recognized by the Java Platform at runtime and are used for configuration. This directory is automatically created when using `jar` command. Beneath the `META-INF` directory, there are class files compiled from your Java source codes and other JAR files as dependencies, espacially under `lib` directory.

WAR is a JAR format for web application. It stores Servlets, JSPs, and static assets like HTML and CSS. It also include a special directory called `WEB-INF`, which have resources for servlet container. Underneath `WEB-INF` there are `classes` and `lib` directory, which stores class files of servlet and other utility, and dependency Jar files respectivily. Basically, any static files outside of `META-INF` and `WEB-INF` are served via there URI. For example, when WAR file that contains `hello/index.html` is deployed to servlet container running on `localhost:8080`, that HTML can be access at `http://localhost:8080/hello/index.html`. But static files inside `WEB-INF` are not accessable via their URI. So template files and other reousrce files that used by servlet but not directly accesable should be stored under `WEB-INF`, while other static file should store outside of `WEB-INF`. 

In a Maven project structure there are `java`, `resources`, and `webapp` directories. When you package project into WAR, Java files under `java` are compile and stored inside `WEB-INF/classes`, while files under `resources` are simply copied. Files under `webapp` are copied to the root of WAR file. To store static files that exposed directly via URI or template files under `WEB-INF`, you should add that files under `webapp`. Thus, a Maven project structure looks like this.

```
├── src
│   ├── main
│   │   ├── java
│   │   │   └── Servlet.java
│   │   ├── resources
│   │   │   └── application.properties
│   │   └── webapp
│   │       ├── WEB-INF
│   │       │   └── template.jsp
│   │       └── index.html
│   └── test
│       └── ...
├── pom.xml
```
If you build this project, what you will get is like this:

```
├── META-INF
│   └── MANIFEST.MF
├── WEB-INF
│   ├── classes
│   │   ├── Servlet.class
│   │   └── application.properties
│   ├── lib
│   │   └── dependency.jar
│   └── template.jsp
└── index.html
```

## Usage

### Package non-executable JAR
```bash
./package <module>
```

### Package executable JAR
```bash
./package --main-class <class> <module>
```

### Package WAR
```bash
./package --war <module>
```

## Reference
- [JAR File Spec](https://docs.oracle.com/en/java/javase/17/docs/specs/jar/jar.html#the-meta-inf-directory)
- [Jakarta Servlet 5.0 Specification](https://jakarta.ee/zh/specifications/servlet/5.0/jakarta-servlet-spec-5.0.pdf)
