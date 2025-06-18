import { useParams, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";

function ProductDetail() {
  const { id } = useParams();
  const navigate = useNavigate();
  const [product, setProduct] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch('/products.json')
      .then((res) => {
        if (!res.ok) throw new Error("Archivo no encontrado");
        return res.json();
      })
      .then((data) => {
        const found = data.find((item) => item.id === id);
        if (!found) throw new Error("Producto no encontrado");
        setProduct(found);
      })
      .catch((err) => setError(err.message))
      .finally(() => setLoading(false));
  }, [id]);

  if (loading) return <h1>Loading...</h1>;
  if (error) return <h1>Error: {error}</h1>;

  return (
    <div className="meli-detail-page" style={{ padding: "2rem", maxWidth: "800px", margin: "auto" }}>
      <button onClick={() => navigate('/')} style={{ marginBottom: '1rem', padding: '0.5rem 1rem', cursor: 'pointer' }}>
        ← Volver al listado
      </button>
      <h1>{product.title}</h1>
      <img src={product.images} alt={product.title} style={{ width: "100%", maxWidth: "400px" }} />
      <p>{product.description}</p>
      <p><strong>Precio:</strong> ${product.price}</p>
      <p><strong>Marca:</strong> {product.brand}</p>
      <p><strong>Vendedor:</strong> {product.seller}</p>
      <p><strong>Categoría:</strong> {product.category}</p>
    </div>
  );
}

export default ProductDetail;