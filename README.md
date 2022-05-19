# sample project for failure of native build

- Native build using the command 
```
./gradlew build -Dquarkus.package.type=native --info -Dnative-image.xmx=4g -Dquarkus.native.container-runtime=podman -x test

```
will get stuck after 
```
[qu-queue-service-1.0.0-SNAPSHOT-runner:58]    classlist:   6,661.60 ms,  0.96 GB
[qu-queue-service-1.0.0-SNAPSHOT-runner:58]        (cap):   2,878.81 ms,  0.96 GB
[qu-queue-service-1.0.0-SNAPSHOT-runner:58]        setup:   5,013.37 ms,  0.96 GB
[qu-queue-service-1.0.0-SNAPSHOT-runner:58]     (clinit):   2,138.11 ms,  2.76 GB
[qu-queue-service-1.0.0-SNAPSHOT-runner:58]   (typeflow):   4,514.87 ms,  2.76 GB
[qu-queue-service-1.0.0-SNAPSHOT-runner:58]    (objects):  61,942.22 ms,  2.76 GB
[qu-queue-service-1.0.0-SNAPSHOT-runner:58]   (features):   5,233.48 ms,  2.76 GB
[qu-queue-service-1.0.0-SNAPSHOT-runner:58]     analysis:  77,525.62 ms,  2.76 GB
[qu-queue-service-1.0.0-SNAPSHOT-runner:58]     universe:   7,109.15 ms,  2.76 GB
[qu-queue-service-1.0.0-SNAPSHOT-runner:58]      (parse):   9,281.43 ms,  2.67 GB
[qu-queue-service-1.0.0-SNAPSHOT-runner:58]     (inline):  26,006.50 ms,  2.67 GB

```
- what was tried so far:
  - downgrading the graalvm build image from `22.0.0.2-Final-java17` to `21.3.2.0-Final-java17` **[NO EFFECT]**
  - upgrading gradle to `7.4.2` **[NO EFFECT]**
  - remove dependencies on lombok **[NO EFFECT]**
  - using `docker` instead of `podman`
    ```
    ./gradlew build -Dquarkus.package.type=native --info -Dnative-image.xmx=4g -x test
    ```
    **[NO EFFECT]**
  - remove most of business code **[NATIVE BUILD WORKED]**
    - after returning it piece by piece, the build failed after adding the entities in package `com.qu.entities`.
    - concerned about cyclic referencing being the reason, I generated equals and hash methods for each entity.**[NO EFFECT]**
  
