# API Documentation

### Public Endpoints

- POST /api/v1/
- GET /{shortUrl}
- GET /api/v1/health

#### POST /

- For Auto Generated Short-URL

###### Sample cURLRequest:

```
curl -LX POST 'http://localhost:8080/api/v1/' \
--header 'Content-Type: application/json' \
--data-raw '{
    "longUrl": "http://example.com/",
    "custom": false
}'
```

###### Sample Response:

```
{
    "shortKey": "f1f6af",
    "creationDate": "2020-09-06T08:30:12.827+00:00",
    "expirationDate": "2025-09-06T08:30:12.827+00:00"
}
```

- For Custom Short-URL

###### Sample Request

```
curl -LX POST 'http://localhost:8080/api/v1/' \
--header 'Content-Type: application/json' \
--data-raw '{
    "longUrl": "http://example.com/",
    "custom": true,
    "shortKey": "testlink"
}'
```
###### Sample Response

Errors: (to be decided)

#### GET {$BASEURL}/{shortUrl}

- Redirect (301)
- 404 Not Found

##### Sample Request
```
curl -LX GET 'http://localhost:8080/f1f6af'
```



#### GET /api/v1/health

Request:
```
curl -LX GET 'http://localhost:8080/api/v1/health'
```

Response:
```
Application Up & Running Successfully ! Total Memory: 154 MB , Free Memory: 111 MB
```



