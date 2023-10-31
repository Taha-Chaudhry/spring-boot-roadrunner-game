# spring-boot-roadrunner-game

# Roadrunner game
Pixi.js game made in javascript based on a game by Potch at Glitch

Play the game for free [here.](https://taha-chaudhry.github.io/roadrunner-game/)

## Preview
<img width="378" alt="Screenshot 2023-10-31 at 2 46 41 PM" src="https://github.com/Taha-Chaudhry/spring-boot-roadrunner-game/assets/46199675/0fcb107c-195b-43eb-ab0f-3b832040d294">

## Usage

### Create PostgreSQL database
```
docker run --name pg-database -p 5432:5432 -e POSTGRES_PASSWORD=admin -d postgres
```

### Start project
```
./mvnw spring-boot:run
```

