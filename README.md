# Hello World Spring Boot app: deploy a Java web app from GitHub

A hello-world Spring Boot (Java) web app. Deploy it free from its GitHub address with the MitsuruTech
[deploy a web app from GitHub](https://mitsurutech.co.uk/apps) feature: no account, nothing to
install. It is small enough to be a first test of deploying to `learntools.dev`, and the steps
are in the manual's [guide to deploying Python, Node, Go and Java apps from GitHub](https://mitsurutech.co.uk/help/deploy-app).

    Language        Java
    Build           mvn -q -DskipTests package
    Start           java -jar target/*.jar

Those are the platform's defaults; nothing here needs changing.

Three things worth copying into your own project:

- **Spring Boot reads `SERVER_PORT` from the environment by itself**, and the environment
  beats `application.properties`, so the platform's port wins with no code involved.
- **`<finalName>app</finalName>`.** The start command is a glob, `target/*.jar`, so it wants
  exactly one jar. Spring Boot's repackage leaves the pre-repackage jar as `.jar.original`,
  which the glob skips; naming the artifact also keeps the version out of the filename so the
  start command never needs editing.
- **The first build is slow.** Maven fetches Spring Boot and its dependencies through the
  platform's proxy, which allows Maven Central. Later builds reuse the cache.

## Running it yourself

    mvn spring-boot:run

## About

Made by [Mitsuru Technologies](https://mitsurutech.co.uk) for the
[MitsuruTech Learning Platform](https://mitsurutech.co.uk/learning): Python, Java, Go, Node, SQL and
Linux in the browser for schools and colleges, with container labs, web apps deployed from GitHub, and
quizzes that mark themselves. Try code with no account in the
[playground](https://mitsurutech.co.uk/playground).
