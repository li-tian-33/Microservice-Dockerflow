# Microservice-Dockerflow
Reference architecture: Focus on docker flow for dev phase.

## Run:
Just run docker-compose up, all demo service will be startup.

## Debug:

- By add the below **JAVA_TOOL_OPTIONS** in the docker environment section of the docker-compose.yaml file to support **remote debug in container**.

```
  employee-service:
    build:
      context: ./employee
    environment:
      - JAVA_TOOL_OPTIONS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5006
    ports:
      - 9090:9090
      - 5006:5006
    depends_on:
      - config-center
```

- Setup up remote debug in 


## Notes:
Because of the time factor, **Department**,**Organization** services are not add docker or docker-compose support.

