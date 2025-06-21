# 🛒 AGL - Meli E-Commerce Backend - Proyecto Multimódulo

Este repositorio contiene el backend de la plataforma AGL MELI, organizado como un proyecto **multi-módulo Maven**. 

Cada módulo representa un microservicio independiente o una librería reutilizable.

---

## 📦 Estructura del proyecto
```css
├── common/             → Librería compartida con utilidades comunes
├── product-service/    → Microservicio de productos
├── seller-service/     → Microservicio de vendedores
├── pom.xml             → POM padre para gestionar todos los módulos
└── README.md           → Este archivo
```

---

## 🚀 ¿Cómo compilar el proyecto completo?

Desde la raíz del repositorio:
```bash
    mvn clean install
```

Esto compilará todos los módulos definidos en el pom.xml raíz, incluyendo tests.

## 📁 Módulos

### 🔧 common/

Librería compartida entre microservicios. Incluye:
- Clases utilitarias (JsonFileLoader)
- Excepciones comunes

➡️ Ver README del módulo common

⸻

### 🛍️ product-service/

Microservicio encargado de exponer una API REST para la consulta de productos. Utiliza common para cargar datos desde archivos JSON.

➡️ Ver [README](product-service/README.md) del módulo product-service

⸻

### 🛠️ Requisitos
- Java 17
- Maven 3.8
- Git

⸻

🧪 Tests

Cada módulo tiene sus propios tests. Para ejecutar todos:
```bash
    mvn test
```