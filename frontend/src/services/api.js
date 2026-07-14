const removeTrailingSlash = (url) => url.replace(/\/$/, '');

function getServiceUrl(serviceVariable) {
  const serviceUrl = import.meta.env[serviceVariable] || import.meta.env.VITE_API_URL;

  if (!serviceUrl) {
    throw new Error(
      `Falta configurar ${serviceVariable} o VITE_API_URL en las variables de entorno.`,
    );
  }

  return removeTrailingSlash(serviceUrl);
}

async function get(url, errorMessage) {
  const response = await fetch(url);

  if (!response.ok) {
    throw new Error(errorMessage);
  }

  return response.json();
}

const productServiceUrl = getServiceUrl('VITE_PRODUCT_API_URL');
const sellerServiceUrl = getServiceUrl('VITE_SELLER_API_URL');

export const productApi = {
  findAll: () => get(`${productServiceUrl}/api/v1/products`, 'Error al obtener productos'),
  findById: (id) => get(
    `${productServiceUrl}/api/v1/products/${encodeURIComponent(id)}`,
    'Producto no encontrado',
  ),
};

export const sellerApi = {
  findById: (id) => get(
    `${sellerServiceUrl}/api/v1/sellers/${encodeURIComponent(id)}`,
    'Vendedor no encontrado',
  ),
};
