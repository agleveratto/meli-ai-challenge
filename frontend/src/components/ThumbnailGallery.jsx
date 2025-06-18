function ThumbnailGallery({ images, selectedImage, setSelectedImage }) {
  return (
    <div style={{ display: "flex", flexDirection: "column", gap: "0.5rem", flexShrink: 0, width: "80px" }}>
      {(Array.isArray(images) ? images : []).map((img, idx) => (
        <img
          key={idx}
          src={img}
          alt={`Thumbnail ${idx + 1}`}
          style={{
            width: "100%",
            height: "80px",
            objectFit: "cover",
            cursor: "pointer",
            borderRadius: "4px",
            border: img === selectedImage ? "2px solid #3483fa" : "1px solid #ddd"
          }}
          onClick={() => setSelectedImage(img)}
        />
      ))}
    </div>
  );
}

export default ThumbnailGallery;