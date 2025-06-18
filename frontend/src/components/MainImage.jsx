function MainImage({ image, title }) {
  return (
    <div style={{ flex: 1, maxWidth: "400px" }}>
      <img
        src={image || "https://via.placeholder.com/400"}
        alt={title || "Producto sin imagen"}
        style={{ width: "100%", borderRadius: "8px" }}
      />
    </div>
  );
}

export default MainImage;