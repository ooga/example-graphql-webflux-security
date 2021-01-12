# example-graphql-webflux-security

Launch the app and query the server

## As anonymous

```
curl 'http://localhost:8080/graphql' -H 'Accept-Encoding: gzip, deflate, br' -H 'Content-Type: application/json' -H 'Accept: application/json' -H 'Connection: keep-alive' --data-binary '{"query":"query {users {id}}"}' --compressed
```
  
## As authenticated

```
curl 'http://localhost:8080/graphql' -H 'Accept-Encoding: gzip, deflate, br' -H 'Content-Type: application/json' -H 'Accept: application/json' -H 'Connection: keep-alive' -H 'Authorization: OK' --data-binary '{"query":"query {users {id}}"}' --compressed
```
  
Security is handled here https://github.com/ooga/example-graphql-webflux-security/blob/master/src/main/java/com/happn/repository/UserRepository.java#L44
