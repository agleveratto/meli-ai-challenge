import { useEffect, useState } from "react";

const fallbackImage = `${import.meta.env.BASE_URL}mercadolibre.svg`;

function ImageWithFallback({ src, alt, ...props }) {
  const [imageSrc, setImageSrc] = useState(src || fallbackImage);

  useEffect(() => {
    setImageSrc(src || fallbackImage);
  }, [src]);

  return (
    <img
      {...props}
      src={imageSrc}
      alt={alt}
      onError={() => {
        if (imageSrc !== fallbackImage) {
          setImageSrc(fallbackImage);
        }
      }}
    />
  );
}

export default ImageWithFallback;
