# Team 4: Ungewöhnliches Verhalten

## Running the Services

Replace $service with the folder of the desired service and run the following commands:

```bash
cd $service                                         # open folder
gradle bootJar                                      # build jar
docker-compose -f ./docker-compose.yml up --build   # run the docker image
```

## Ports

| Service | Port |
| --- | --- | 
| Anlaufstellenservice | 8080 |
| DVP Service | 8081 | 
| UV Ereignis Service | 8082 |
