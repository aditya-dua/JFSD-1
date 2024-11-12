

1. **Update the URL Entity** to store the user ID and fetch count.
2. **Create User Entity** (optional) for managing users if they are not stored separately.
3. **Enhance the Service Layer** to increment the fetch count on each access.
4. **Add New Endpoints** to list all shortened URLs.

### Step 1: Update the URL Entity

Modify the `URL` entity class to include the `userId` and `fetchCount` fields.

```java
package com.example.urlshortener.model;

import javax.persistence.*;

@Entity
public class URL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalUrl;
    private String shortUrl;
    private String userId;  // New field to store the user ID
    private int fetchCount; // New field to track how many times the URL was accessed

    // Getters and setters
}
```

### Step 2: Create or Integrate a User Entity (Optional)

If users are part of your application and stored in a separate table, you can create a `User` entity or integrate with an existing system. Here’s an example of a simple `User` entity:

```java
package com.example.urlshortener.model;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    // Additional fields and Getters/Setters
}
```
In a new package repository, create an interface URLRepository.java to interact with the database.

```java

package com.example.urlshortener.repository;

import com.example.urlshortener.model.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface URLRepository extends JpaRepository<URL, Long> {
    Optional<URL> findByShortUrl(String shortUrl);
    Optional<URL> findByOriginalUrl(String originalUrl);
}
```

You may also need a `UserRepository` to retrieve and manage users, if necessary:

```java
package com.example.urlshortener.repository;

import com.example.urlshortener.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Additional query methods if needed
}
```




### Step 3: Update the URL Service

In the `URLService` class, modify the `shortenUrl` method to include `userId` when saving a new URL, and add logic to increment `fetchCount` when a shortened URL is accessed.

```java
package com.example.urlshortener.service;

import com.example.urlshortener.model.URL;
import com.example.urlshortener.repository.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class URLService {

    @Autowired
    private URLRepository urlRepository;

    public String shortenUrl(String originalUrl, String userId) {
        Optional<URL> existingUrl = urlRepository.findByOriginalUrl(originalUrl);
        if (existingUrl.isPresent()) {
            return existingUrl.get().getShortUrl();
        }

        String encodedUrl = Base64.getUrlEncoder().encodeToString(originalUrl.getBytes(StandardCharsets.UTF_8)).substring(0, 8);
        URL url = new URL();
        url.setOriginalUrl(originalUrl);
        url.setShortUrl(encodedUrl);
        url.setUserId(userId);
        url.setFetchCount(0); // Initialize fetch count to 0

        urlRepository.save(url);
        return encodedUrl;
    }

    public String getOriginalUrl(String shortUrl) {
        URL url = urlRepository.findByShortUrl(shortUrl)
                               .orElseThrow(() -> new RuntimeException("URL not found"));

        // Increment fetch count each time the URL is accessed
        url.setFetchCount(url.getFetchCount() + 1);
        urlRepository.save(url);

        return url.getOriginalUrl();
    }

    public List<URL> getAllShortenedUrls() {
        return urlRepository.findAll();
    }
}
```

### Step 4: Update URL Controller

Modify the `URLController` class to:
1. Accept `userId` when creating a shortened URL.
2. Add an endpoint to retrieve all shortened URLs.

```java
package com.example.urlshortener.controller;

import com.example.urlshortener.model.URL;
import com.example.urlshortener.service.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/url")
public class URLController {

    @Autowired
    private URLService urlService;

    @PostMapping("/shorten")
    public String shortenUrl(@RequestBody UrlRequest request) {
        return urlService.shortenUrl(request.getOriginalUrl(), request.getUserId());
    }

    @GetMapping("/{shortUrl}")
    public String getOriginalUrl(@PathVariable String shortUrl) {
        return urlService.getOriginalUrl(shortUrl);
    }

    @GetMapping("/list")
    public List<URL> getAllShortenedUrls() {
        return urlService.getAllShortenedUrls();
    }
}
```

Here, we define `UrlRequest` as a DTO to encapsulate the `originalUrl` and `userId`.

### Step 5: Define a DTO for URL Shortening Requests

In a new package `dto`, create a class `UrlRequest.java` to handle the data coming from the client in the request body.

```java
package com.example.urlshortener.dto;

public class UrlRequest {

    private String originalUrl;
    private String userId;

    // Getters and setters
}
```

### Step 6: Run and Test the Application

1. **Run the Application**: Run the main method in `URLShortenerApplication.java`.
2. **Test the New Endpoints**:
   - **Create a Short URL**:
     - Send a POST request to `http://localhost:8080/api/v1/url/shorten` with a JSON body like:
       ```json
       {
           "originalUrl": "https://example.com",
           "userId": "12345"
       }
       ```
     - It should return a shortened URL.
   - **Retrieve Original URL and Update Fetch Count**:
     - Send a GET request to `http://localhost:8080/api/v1/url/{shortUrl}`.
     - The `fetchCount` should increment each time this endpoint is accessed.
   - **Get List of All Shortened URLs**:
     - Send a GET request to `http://localhost:8080/api/v1/url/list`.
     - This should return a list of all shortened URLs along with their `userId`, `originalUrl`, `shortUrl`, and `fetchCount`.

This completes the extended URL shortener app with user tracking, a list of shortened URLs, and a fetch count feature.