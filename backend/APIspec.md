## API Specification For URL Shortener

### Public Endpoints

- POST /api/v1/
- GET /<short-url>

#### POST /

- For Auto Generated Short-URL

Request Payload: `{url: "https://www.example.com/", custom: false}`

- For Custom Short-URL

Request Payload: `{url: "https://www.example.com/", custom: true, customKey: "example"}`

Response Payload: `{url: "{BASEURL}/h3jS6x", creationDate: "2020-09-05T06:52:59.096Z", validUpto: "2025-09-05T06:52:59.096Z"}`

Errors: (to be decided)

#### GET /<short-url>

- Redirect Success: (to be decided)
- 404 Not Found


