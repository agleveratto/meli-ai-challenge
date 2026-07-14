import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import ThumbnailGallery from "./ThumbnailGallery.jsx";
import MainImage from "./MainImage.jsx";
import ProductInfo from "./ProductInfo.jsx";
import { productApi } from "../services/api.js";

function ProductDetail() {
  const { id } = useParams();
  const [product, setProduct] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [selectedImage, setSelectedImage] = useState(null);

  useEffect(() => {
    productApi.findById(id)
      .then((res) => {
        setProduct(res.data || {});
      })
      .catch((err) => setError(err.message))
      .finally(() => setLoading(false));
  }, [id]);

  if (loading) return <h1>Loading...</h1>;
  if (error) return <h1>Error: {error}</h1>;

  return (
    <div className="meli-detail-page" style={{ padding: "2rem", maxWidth: "1200px", margin: "auto", display: "flex", gap: "2rem" }}>
      <ThumbnailGallery images={product.images} selectedImage={selectedImage} setSelectedImage={setSelectedImage} />
      <MainImage image={selectedImage || (Array.isArray(product.images) && product.images[0])} title={product.title} />
      <ProductInfo product={product} />
    </div>
  );
}

export default ProductDetail;
