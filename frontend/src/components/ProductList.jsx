import { Link } from "react-router-dom";
import { useEffect, useState } from "react";
import { productApi } from "../services/api.js";
import { EmptyState, ErrorState, LoadingState } from "./FeedbackState.jsx";
import ImageWithFallback from "./ImageWithFallback.jsx";

function ProductList() {
    const [products, setProducts] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const [reloadAttempt, setReloadAttempt] = useState(0);

    useEffect(() => {
        setLoading(true);
        setError(null);
        productApi.findAll()
            .then((res) => {
                setProducts(res.data || []);
            })
            .catch((error) => setError(error.message))
            .finally(() => setLoading(false));
    }, [reloadAttempt]);

    if (loading) return <LoadingState label="Cargando productos..." />;
    if (error) return <ErrorState message={error} onRetry={() => setReloadAttempt((attempt) => attempt + 1)} />;
    if (products.length === 0) {
      return <EmptyState title="No hay productos disponibles" description="Volvé a intentarlo más tarde." />;
    }

    return (
      <div className="meli-list-page" style={{ maxWidth: "800px", margin: "auto", padding: "2rem" }}>
        <div className="meli-list-grid" style={{ display: "flex", flexDirection: "column", gap: "1.5rem" }}>
          {products.map((product) => (
            <Link
              to={`/products/${product.id}`}
              key={product.id}
              className="meli-list-card"
              style={{
                display: "flex",
                alignItems: "center",
                gap: "1.5rem",
                padding: "1rem",
                border: "1px solid #eee",
                borderRadius: "8px",
                textDecoration: "none",
                color: "inherit",
                background: "#fff",
                boxShadow: "0 1px 4px rgba(0,0,0,0.1)"
              }}
            >
              <ImageWithFallback
                src={product.images?.[0]}
                alt={product.title}
                style={{ width: "100px", height: "100px", objectFit: "contain", backgroundColor: "#f5f5f5", flexShrink: 0 }}
              />
              <div style={{ display: "flex", flexDirection: "column" }}>
                <span style={{ fontSize: "0.85rem", color: "#666" }}>{product.brand}</span>
                <h2 style={{ fontSize: "1rem", margin: "0.25rem 0" }}>{product.title}</h2>
                <span style={{ fontSize: "1.1rem", fontWeight: "bold" }}>${product.price}</span>
              </div>
            </Link>
          ))}
        </div>
      </div>
    );
}

export default ProductList;
