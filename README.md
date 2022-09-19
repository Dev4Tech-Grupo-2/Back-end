# Back-end

### About the project:
API developed to manage students and teachers in a classroom for the Little Geniuses Fictional School.

### Technologies Used:
- Java 11
- MySQL
- Swagger
- Spring (Boot, JPA, Web, Security)
- Flyway Lombok

### Members:
- Alejandro Yujra Espejo
- Caique Bezerra
- Luiz Nascimento
- Renato Borges Viana

### To test the project:
1. Download [Eclipse](https://www.eclipse.org/downloads/)
2. Install and configure MySQL
3. Download the project in the console: ```git clone https://github.com/Dev4Tech-Grupo-2/Back-end.git```
4. Open Eclipse and Go to 'Imports' and select the project
5. Run
6. Install [Postman](https://www.postman.com/downloads/) to run the tests

### API
The API was developed using OAuth2 for authentication, in this project we use a Bearer Token that is generated after user authentication, so it is possible to make requests to the API.

### Generate token [POST] - [/oauth/token]:
For the request it is necessary to inform the Client Server in 'Authorization' and authenticate the user in the following request, the 'grant_type' to be used is 'password':
+ Request (application/json)
  + Headers
    * Authorization: Basic Auth - [username] and [password]
    * Body: [username], [password] and [grant_type]
    
+ Response 200 (application/json)
    + Body
     ```
     {
        "access_token": "[token]",
        "token_type": "bearer",
        "expires_in": 304000,
        "full_name": "[full_name]",
        "user_id": 1,
        "jti": [jti]
     }
     ```

### Resources available in the API:
- Teacher
- Student
- Class
- User

### Teacher [/teachers]

#### List [GET]

+ Request (application/json)
    + **Headers:** Authorization: Bearer [acess_token]
    
+ Response 200 (application/json)
    + Body
     ```
     {
       "content": [
          {
              "id": 1,
              "name": "Alex da Silva Brasil",
              "phone": "11938714876",
              "email": "alex.brasil@email.com.br",
              "salary": 3200.00,
              "street": "R. Joaquim Távora, 1339",
              "city": "São Paulo",
              "country": "Brasil",
              "postalCode": "01415002",
              "state": "São Paulo"
          },
      ],
      "pageable": {
          "sort": {
              "empty": true,
              "sorted": false,
              "unsorted": true
          },
          "offset": 0,
          "pageSize": 10,
          "pageNumber": 0,
          "unpaged": false,
          "paged": true
      },
      "last": true,
      "totalElements": 10,
      "totalPages": 1,
      "size": 10,
      "number": 0,
      "sort": {
          "empty": true,
          "sorted": false,
          "unsorted": true
      },
      "numberOfElements": 10,
      "first": true,
      "empty": false
    }
     ```
     
#### Find [GET /teachers/{id}]

+ Request (application/json)
    + **Headers:** Authorization: Bearer [acess_token]
    
+ Response 200 (application/json)
    + Body
     ```
     {
       "id": 1,
       "name": "Alex da Silva Brasil",
       "phone": "11938714876",
       "email": "alex.brasil@email.com.br",
       "salary": 3200.00,
       "street": "R. Joaquim Távora, 1339",
       "city": "São Paulo",
       "country": "Brasil",
       "postalCode": "01415002",
       "state": "São Paulo"
     }
     ```
#### Insert [POST]
 
+ Request (application/json)
    + **Headers:** Authorization: Bearer [acess_token]
    + Body
    ```
    {
      "name": "Alex da Silva Brasil",
      "phone": "11938714876",
      "email": "alex.brasil@email.com.br",
      "salary": 3200.00,
      "street": "R. Joaquim Távora, 1339",
      "city": "São Paulo",
      "country": "Brasil",
      "postalCode": "01415002",
      "state": "São Paulo"
    }
    ```

+ Response 201 (application/json)
    + Body
    ```
    {
      "id": 11,
      "name": "Alex da Silva Brasil",
      "phone": "11938714876",
      "email": "alex.brasil@email.com.br",
      "salary": 3200.00,
      "street": "R. Joaquim Távora, 1339",
      "city": "São Paulo",
      "country": "Brasil",
      "postalCode": "01415002",
      "state": "São Paulo"
    }
    ```
  
#### Update [PUT /teachers/{id}]

+ Request (application/json)
    + **Headers:** Authorization: Bearer [acess_token]
    + Body
    ```
    {
      "name": "Alex da Silva Brasil dos Santos",
      "phone": "11938714876",
      "email": "alex.brasil@email.com.br",
      "salary": 5000.00,
      "street": "R. Joaquim Távora, 1339",
      "city": "São Paulo",
      "country": "Brasil",
      "postalCode": "01415002",
      "state": "São Paulo"
    }
    ```

+ Response 200 (application/json)
    + Body
    ```
    {
      "id": 11,
      "name": "Alex da Silva Brasil dos Santos",
      "phone": "11938714876",
      "email": "alex.brasil@email.com.br",
      "salary": 5000.00,
      "street": "R. Joaquim Távora, 1339",
      "city": "São Paulo",
      "country": "Brasil",
      "postalCode": "01415002",
      "state": "São Paulo"
    }
    ```
    
#### Remove [DELETE /teachers/{id}]

+ Request (application/json)
    + **Headers:** Authorization: Bearer [acess_token]
    
+ Response 204 (application/json) - No Content
