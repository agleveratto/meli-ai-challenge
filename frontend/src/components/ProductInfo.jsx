import ActionPanel from "./ActionPanel.jsx";

function ProductInfo({ product }) {
  return (
    <div style={{ flex: 2 }}>
      <div style={{ display: "flex", flexDirection: window.innerWidth >= 768 ? "row" : "column", gap: "2rem" }}>
        <div style={{ flex: 2, display: "flex", flexDirection: "column", gap: "1rem" }}>
          <p style={{ color: "#999", fontSize: "0.9rem" }}>{product.category}</p>
          <h1 style={{ fontFamily:"Proxima Nova, -apple-system, Roboto, Arial, sans-serif" ,  fontSize: "22px", margin: 0 }}>{product.title}</h1>
          <p style={{ fontSize: "2rem", fontWeight: "bold" }}>${product.price}</p>
        </div>
        <div style={{
          flex: 1,
          marginTop: window.innerWidth < 768 ? "2rem" : 0,
          border: "1px solid #ddd",
          borderRadius: "8px",
          padding: "1rem",
          boxShadow: "0 2px 4px rgba(0, 0, 0, 0.05)",
          backgroundColor: "#fff"
        }}>
          <ActionPanel product={product} />
        </div>
      </div>
    </div>
  );
}

export default ProductInfo;