# 🛒 AGL - Meli E-Commerce Frontend

Este proyecto es una interfaz web desarrollada con **React + Vite**, que consume una API local para mostrar productos y sus detalles, inspirado en la experiencia de usuario de MercadoLibre.

## 🚀 Tecnologías utilizadas

- [React](https://reactjs.org/)
- [Vite](https://vitejs.dev/)
- [React Router DOM](https://reactrouter.com/)

## 📦 Requisitos previos

- [Node.js (versión LTS)](https://nodejs.org/) instalado en tu sistema
- npm (viene con Node.js)

Verificá que estén instalados:

```bash
    node -v
    npm -v
```

## Configuración de API

Vite carga automáticamente los archivos de entorno según el comando:

- `.env.development`: se usa con `npm run dev` y configura los servicios locales.
- `.env.production`: se usa con `npm run build`; reemplazá `VITE_API_URL` por la URL real del gateway al desplegar.
- `.env.test`: se usa al ejecutar Vite con `--mode test`.

Se puede configurar una URL común de gateway con `VITE_API_URL`, o URLs por servicio con `VITE_PRODUCT_API_URL` y `VITE_SELLER_API_URL`. Para valores personales o secretos usá `.env.local` o `.env.[modo].local`; esos archivos no se versionan.
