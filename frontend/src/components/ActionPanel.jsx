import SellerDetail from "./SellerDetail";

function ActionPanel({ product }) {
  return (
    <div style={{ display: "flex", flexDirection: "column", gap: "1rem" }}>
      <div style={{ border: "1px solid #eee", padding: "1rem", borderRadius: "6px" }}>
        <button
          style={{
            backgroundColor: "#3483fa",
            color: "#fff",
            border: "none",
            borderRadius: "4px",
            padding: "0.75rem 1rem",
            cursor: "pointer",
            marginRight: "1rem",
            width: "100%"
          }}
        >
          Comprar ahora
        </button>
        <button
          style={{
            backgroundColor: "#00a650",
            color: "#fff",
            border: "none",
            borderRadius: "4px",
            padding: "0.75rem 1rem",
            cursor: "pointer",
            width: "100%"
          }}
        >
          Agregar al carrito
        </button>
      </div>

      <SellerDetail seller={product.sellerId} />

      <div style={{ border: "1px solid #eee", padding: "1rem", borderRadius: "6px" }}>
        <h3 style={{ marginTop: 0 }}>Medios de pago</h3>
        {product.paymentMethods ? (
          Array.isArray(product.paymentMethods) ? (
            <ul style={{ paddingLeft: "1.2rem", margin: 0 }}>
              {product.paymentMethods.map((m, i) => <li key={i}>{m}</li>)}
            </ul>
          ) : (
            <p>{product.paymentMethods}</p>
          )
        ) : (
          <p>Información no disponible</p>
        )}
      </div>
    </div>
  );
}

export default ActionPanel;