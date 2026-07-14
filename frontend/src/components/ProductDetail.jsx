import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import ThumbnailGallery from "./ThumbnailGallery.jsx";
import MainImage from "./MainImage.jsx";
import ProductInfo from "./ProductInfo.jsx";
import { productApi } from "../services/api.js";
import { EmptyState, ErrorState, LoadingState } from "./FeedbackState.jsx";

function ProductDetail() {
  const { id } = useParams();
  const [product, setProduct] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [selectedImage, setSelectedImage] = useState(null);
  const [reloadAttempt, setReloadAttempt] = useState(0);

  useEffect(() => {
    setLoading(true);
    setError(null);
    setProduct(null);
    setSelectedImage(null);
    productApi.findById(id)
      .then((res) => {
        setProduct(res.data || null);
      })
      .catch((err) => setError(err.message))
      .finally(() => setLoading(false));
  }, [id, reloadAttempt]);

  if (loading) return <LoadingState label="Cargando producto..." />;
  if (error) return <ErrorState message={error} onRetry={() => setReloadAttempt((attempt) => attempt + 1)} />;
  if (!product?.id) {
    return <EmptyState title="Producto no disponible" description="El producto solicitado no contiene información para mostrar." />;
  }

  return (
    <div className="meli-detail-page" style={{ padding: "2rem", maxWidth: "1200px", margin: "auto", display: "flex", gap: "2rem" }}>
      <ThumbnailGallery images={product.images} selectedImage={selectedImage} setSelectedImage={setSelectedImage} />
      <MainImage image={selectedImage || (Array.isArray(product.images) && product.images[0])} title={product.title} />
      <ProductInfo product={product} />
    </div>
  );
}

export default ProductDetail;
