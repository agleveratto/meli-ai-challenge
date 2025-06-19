# Common Utils - AGL MELI Microservices

Este módulo contiene utilidades compartidas entre los distintos microservicios del ecosistema AGL MELI. Su propósito es centralizar y reutilizar clases comunes para evitar duplicación de código y mejorar el mantenimiento.

---

## 📦 Contenido

- Clases utilitarias generales (como `JsonFileLoader`)
- Excepciones comunes (por ejemplo, para errores al leer archivos JSON)

---

## 🔧 Uso

Agregá este módulo como dependencia en tu microservicio (`pom.xml`):

```xml
<dependency>
  <groupId>com.agl.meli</groupId>
  <artifactId>common</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
