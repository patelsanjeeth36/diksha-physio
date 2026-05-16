# Diksha Physiotherapy Website

A professional physiotherapy website for **Dr. Diksha Sharma**, built with Spring Boot 3 + Tailwind CSS. Features a beautiful single-page website and a callback request system backed by PostgreSQL.

## Tech Stack

| Layer      | Technology                          |
|------------|-------------------------------------|
| Backend    | Java 17, Spring Boot 3.2.5, Maven   |
| Database   | PostgreSQL (prod) / H2 (dev)        |
| Migrations | Flyway                              |
| Frontend   | HTML5, Tailwind CSS (CDN)           |
| Fonts      | Google Fonts — Playfair Display + Inter |
| Deployment | Render.com (free tier)              |

---

## Running Locally (Dev Mode with H2)

### Prerequisites
- Java 17+
- Maven 3.8+

### Steps

```bash
# 1. Clone the repo
git clone <your-repo-url>
cd diksha-physio

# 2. Run with the dev profile (uses H2 in-memory database)
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev

# On Windows:
mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=dev
```

The app starts at **http://localhost:8080**

- Website: http://localhost:8080/
- H2 Console: http://localhost:8080/h2-console (JDBC URL: `jdbc:h2:mem:dikshadb`)
- API – POST callback: `POST http://localhost:8080/api/callback`
- API – List callbacks: `GET http://localhost:8080/api/callback`

---

## Running Locally with PostgreSQL

```bash
# Set env vars (Linux/Mac)
export DB_URL=jdbc:postgresql://localhost:5432/dikshadb
export DB_USER=postgres
export DB_PASSWORD=yourpassword

# On Windows (PowerShell)
$env:DB_URL="jdbc:postgresql://localhost:5432/dikshadb"
$env:DB_USER="postgres"
$env:DB_PASSWORD="yourpassword"

# Run (default profile uses PostgreSQL + Flyway)
./mvnw spring-boot:run
```

---

## Setting Up Neon.tech (Free PostgreSQL)

1. Go to **https://neon.tech** and sign up for a free account
2. Create a new project (e.g. `diksha-physio`)
3. Neon will give you a connection string like:
   ```
   postgresql://user:password@ep-cool-name-123456.us-east-2.aws.neon.tech/neondb?sslmode=require
   ```
4. Use that as `DB_URL` (replace `postgresql://` with `jdbc:postgresql://`)

---

## Deploying to Render.com (Free Tier)

### 1. Build the JAR locally and push to GitHub

```bash
./mvnw clean package -DskipTests
git add .
git commit -m "Initial deployment"
git push origin main
```

### 2. Create a Web Service on Render

1. Go to **https://render.com** → New → **Web Service**
2. Connect your GitHub repository
3. Configure:
   - **Runtime**: Docker **or** Native (Java)
   - **Build Command**: `./mvnw clean package -DskipTests`
   - **Start Command** (from Procfile): `java -Xmx300m -Xss512k -jar target/diksha-physio-0.0.1-SNAPSHOT.jar`

### 3. Set Environment Variables on Render

In your Render service → **Environment** tab, add:

| Key           | Value                                    |
|---------------|------------------------------------------|
| `DB_URL`      | `jdbc:postgresql://<neon-host>/neondb?sslmode=require` |
| `DB_USER`     | your Neon username                       |
| `DB_PASSWORD` | your Neon password                       |
| `PORT`        | `8080` (Render sets this automatically)  |

### 4. Deploy

Click **Deploy** — Render will build and deploy. The site will be live at `https://your-app.onrender.com`.

---

## API Reference

### POST /api/callback
Create a callback request.

**Request body:**
```json
{
  "name": "Priya Sharma",
  "phone": "+91 98765 43210",
  "preferredTime": "Morning (9 AM – 12 PM)",
  "message": "Chronic lower back pain for 3 months"
}
```

**Response (201 Created):**
```json
{
  "id": 1,
  "message": "Callback request received. We will contact you shortly!"
}
```

### GET /api/callback
List all callback requests (admin use).

**Response (200 OK):** Array of `CallbackRequest` objects.

---

## Project Structure

```
diksha-physio/
├── src/
│   ├── main/
│   │   ├── java/com/diksha/physio/
│   │   │   ├── DikshaPhysioApplication.java
│   │   │   ├── config/CorsConfig.java
│   │   │   ├── controller/CallbackRequestController.java
│   │   │   ├── dto/CallbackRequestDto.java
│   │   │   ├── entity/CallbackRequest.java
│   │   │   ├── repository/CallbackRequestRepository.java
│   │   │   └── service/CallbackRequestService.java
│   │   └── resources/
│   │       ├── application.properties          (PostgreSQL / prod)
│   │       ├── application-dev.properties      (H2 / local dev)
│   │       ├── db/migration/V1__create_callback_requests.sql
│   │       └── static/index.html               (website)
│   └── test/...
├── Procfile
├── pom.xml
└── README.md
```

---

## Customisation Checklist

- [ ] Replace Dr. Diksha's photo placeholder in the hero and about sections
- [ ] Update clinic address, phone, and email in the Contact section
- [ ] Embed a real Google Maps `<iframe>` in the Contact section
- [ ] Update placeholder bio text with real credentials
- [ ] Add admin authentication to `GET /api/callback` before going live
