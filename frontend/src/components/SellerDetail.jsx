import { useEffect, useState } from "react";
import { sellerApi } from "../services/api.js";
import { EmptyState, ErrorState, LoadingState } from "./FeedbackState.jsx";

function SellerDetail( {sellerId} ) {
  const [seller, setSeller] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [reloadAttempt, setReloadAttempt] = useState(0);

  useEffect(() => {
    setLoading(true);
    setError(null);
    setSeller(null);

    if (!sellerId) {
      setLoading(false);
      return;
    }

    sellerApi.findById(sellerId)
      .then((res) => {
        setSeller(res.data || null);
      })
      .catch((err) => setError(err.message))
      .finally(() => setLoading(false));
  }, [sellerId, reloadAttempt]);

  if (loading) return <LoadingState label="Cargando vendedor..." compact />;
  if (error) return <ErrorState message={error} onRetry={() => setReloadAttempt((attempt) => attempt + 1)} compact />;
  if (!seller?.id) {
    return <EmptyState title="Vendedor no disponible" description="No hay datos para mostrar." compact />;
  }

  return (    
    <div style={{ border: "1px solid #eee", padding: "1rem", borderRadius: "6px" }}>
    <h3 style={{ marginTop: 0 }}></h3>
    {seller.logoUrl && (
        <img
          src={seller.logoUrl}
          alt={`Logo de ${seller.name}`}
          style={{
            width: "80px",
            height: "80px",
            objectFit: "contain",
            borderRadius: "6px",
            marginBottom: "1rem"
          }}
        />
      )}
    <p>{seller.name || "Información no disponible"}</p>
    <button 
      onClick={() => window.open(seller.website, "_blank")}
      disabled={!seller.website}>
      Visitar sitio del vendedor
    </button>
  </div>
  );
}

export default SellerDetail;
