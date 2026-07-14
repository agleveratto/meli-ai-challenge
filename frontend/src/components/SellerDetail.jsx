import { useEffect, useState } from "react";
import { sellerApi } from "../services/api.js";

function SellerDetail( {sellerId} ) {
  const [seller, setSeller] = useState({});
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    sellerApi.findById(sellerId)
      .then((res) => {
        setSeller(res.data || {});
      })
      .catch((err) => setError(err.message))
      .finally(() => setLoading(false));
  }, [sellerId]);

  if (loading) return <h1>Loading...</h1>;
  if (error) return <h1>Error: {error}</h1>;

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
