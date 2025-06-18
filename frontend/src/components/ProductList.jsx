import { Link } from "react-router-dom";
import { useEffect, useState } from "react";

function ProductList() {
    const [products, setProducts] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        setLoading(true);
        fetch('http://localhost:8080/api/v1/products')
            .then((res) => {
                if (!res.ok) throw new Error('Error al obtener productos');
                return res.json();
            })
            .then((res) => {
                setProducts(res.data || []);
                setLoading(false);
            })
            .catch((error) => setError(error.message))
            .finally(() => setLoading(false));
    }, []);

    if (loading) return <h1>Loading...</h1>;
    if (error) return <h1>Error: {error}</h1>;

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
              <img
                src={product.images || "https://via.placeholder.com/100"}
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