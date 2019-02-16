[![Build Status](https://travis-ci.org/ddubson/springboot-flyway-strategy.svg?branch=master)](https://travis-ci.org/ddubson/springboot-flyway-strategy)

# Spring Boot Flyway Strategy

Flyway Schema migrations for all environments:

```
src/main/resources/db/migration/schema
```

Data migrations for dev environment only
```
src/main/resources/db/migration/data/dev
```

Data migrations for prod environment only
```
src/main/resources/db/migration/data/prod
```

# Running the app

In DEV mode (executes schema + dev migrations):

```bash
./gradlew bootRun -Pargs=--spring.profiles.active=dev
```

In PROD mode (executes schema + prod migrations):

```bash
./gradlew bootRun -Pargs=--spring.profiles.active=prod
```

## Strategy

Write schema migrations for all environments in the schema
directory, and perform all data and state transitions in each
individual data directory.

Perform multiple migrations if schema requires putting a restriction on a field(s).

e.g.

> Creating a new non-null field requires that existing databases
> might not have data to fill in. Create two migrations for schema and one data migration.
> e.g. 
>
>  schema:
>
>       V1__addColumnToTable.sql
>       V2__addFkToColumn.sql
>
>  data/dev:
>
>       V1_1__wireUpExistingDevData.sql
>
>  data/prod:
>
>       V1_1__wireUpExistingProdData.sql
>
> Order of execution will be:
>   V1 -> V1_1 -> V2 for both `dev` and `prod` environments

This is a very granular but effective approach to schema/data migrations using flyway
