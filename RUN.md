## 🛠 Instalación y ejecución 

### Frontend

1. Clonar el repo:
```bash
  git clone https://github.com/agleveratto/meli-ai-challenge.git
  cd frontend
```
2. Instalar dependencias:
```bash
  npm install
```
3. Ejecutar el proyecto:
```bash
  npm run dev
```

Accedé a `http://localhost:5173`

---

### Backend

1. Asegurate de tener Java 17 instalado
2. Clonar el repo:
```bash
  git clone https://github.com/agleveratto/meli-ai-challenge.git
  cd backend
```

3. Generar libreria common para uso posterior en los servicios
```bash
  cd common
  ./mvnw clean install
```
4. Levantar servicio de producto [*PRODUCT-SERVICE*](backend/product-service/README.md) 
```bash
  cd ../product-service
  ./mvnw spring-boot:run
```

Endpoints disponibles:

| Método | Ruta                 | Descripción                   |
|--------|----------------------|-------------------------------|
| GET    | `/products`          | Devuelve listado de productos |
| GET    | `/products/{id}`     | Devuelve detalle del producto |

---
