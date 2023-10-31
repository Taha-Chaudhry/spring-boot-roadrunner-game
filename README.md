# spring-boot-roadrunner-game

# Roadrunner game
Pixi.js game made in javascript based on a game by Potch at Glitch

Play the game for free [here.](https://taha-chaudhry.github.io/roadrunner-game/)

## Preview
<img width="378" alt="Screenshot 2023-10-31 at 2 46 41 PM" src="https://github.com/Taha-Chaudhry/spring-boot-roadrunner-game/assets/46199675/0fcb107c-195b-43eb-ab0f-3b832040d294">
<img width="1754" alt="Screenshot 2023-10-31 at 3 54 44 PM" src="https://github.com/Taha-Chaudhry/spring-boot-roadrunner-game/assets/46199675/5189dae4-4b17-41c7-ae0f-f91c2ee2d18e">


## Usage
In the project directory:

### Create Docker network:
```
docker network create game
```

### Create PostgreSQL database Container:
```
docker run --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=admin --network game -d postgres
```

### Build and Create Game Container:
```
docker image build -t springboot-road-runner-game .
docker run --name springboot-road-runner-game -p 8080:8080 --network game -d springboot-road-runner-game
```

### Create Prometheus Container:
```
docker run \
    --name prometheus \
    -p 9090:9090 \
    -v /PATH/TO/prometheus.yml:/etc/prometheus/prometheus.yml \
    -v prometheus-data:/prometheus \
    --net game \
    -d \
    prom/prometheus
```
### Start project
```
./mvnw spring-boot:run
```

