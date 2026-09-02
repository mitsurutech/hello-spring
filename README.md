# hello-spring

A hello-world Spring Boot app, small enough to be a first test of deploying to
`learntools.dev`.

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
