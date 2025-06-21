# 🛒 AGL - Meli E-Commerce Frontend + Backend

Este proyecto es una solución fullstack que simula un e-commerce básico con frontend en React + Vite y backend en Java 17. Inspirado en la experiencia de usuario de MercadoLibre.

---

## 📦 [Backend (Java 17)](backend/README.md)

---

## 📦 [Frontend modular (React + Vite)](frontend/README.md)

---

## 🧠 Desafíos y cómo se resolvieron

### 📁 1. Persistencia sin base de datos
**Desafío:** Persistir productos y promociones sin base de datos.

**Solución:** Se implementó un `JsonFileLoader<T>` genérico que permite cargar cualquier archivo JSON tipado a cualquier clase usando Jackson. Esto evita duplicación y hace el código reutilizable para nuevos recursos.

### 🔌 2. Control de errores y respuestas unificadas
**Desafío:** Que todos los endpoints devuelvan una respuesta estructurada, y capturar errores como producto no encontrado o fallas al cargar archivos.

**Solución:** Se creó una clase `ApiResponse<T>` para estructurar las respuestas (`status`, `data`, `message`), y un `@RestControllerAdvice` para manejar excepciones como `JsonFileException` y `ProductNotFoundException`.

### 📚 3. Aprendizaje en React
**Desafío:** Familiarizarse con el ecosistema moderno de React (React + Vite), comprender el enrutamiento con React Router DOM y trabajar con estados y efectos para consumir APIs.

**Solución:** Se implementó un frontend modular utilizando componentes funcionales y `useEffect` para llamadas asíncronas. Se utilizó `React Router` para la navegación entre vistas y se aplicaron buenas prácticas como separación de responsabilidades y estructuras limpias.

### 🧪 4. Separación de responsabilidades en React
**Desafío:** Evitar que la lógica esté acoplada entre componentes.

**Solución:** Cada vista está separada. La navegación se maneja con React Router y se puede escalar fácilmente a más secciones (checkout, login, etc.).

---

## 🔄 Posibles mejoras futuras

- Pruebas unitarias e2e (Jest + React Testing Library)
- Sistema de autenticación

---

## 👤 Autor

Desarrollado por [Alan Leveratto](https://github.com/agleveratto).
