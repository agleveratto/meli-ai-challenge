import ImageWithFallback from "./ImageWithFallback.jsx";

function MainImage({ image, title }) {
  return (
    <div style={{ flex: 1, maxWidth: "400px" }}>
      <ImageWithFallback
        src={image}
        alt={title || "Producto sin imagen"}
        style={{ width: "100%", borderRadius: "8px" }}
      />
    </div>
  );
}

export default MainImage;
