import { Link } from "react-router-dom";
import { useEffect, useState } from "react";

function ProductList() {
    const [products, setProducts] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        setLoading(true);
        fetch('/products.json')
            .then((res) => {
                if (!res.ok) throw new Error('Archivo no encontrado o error de red');
                return res.json();
            })
            .then((data) => {
                setProducts(data);
                setLoading(false);
            })
            .catch((error) => setError(error.message))
            .finally(() => setLoading(false));
    }, []);

    if (loading) return <h1>Loading...</h1>;
    if (error) return <h1>Error: {error}</h1>;

    return (
        <div className="meli-list-page">
            <h1>Product List</h1>
            <div className="meli-list-grid">
                {products.map((product) => (
                    <Link to={`/products/${product.id}`} key={product.id} className="meli-list-card">
                        <img src={product.images} alt={product.title} />
                        <h2>{product.title}</h2>
                        <p>${product.price}</p>
                    </Link>
                ))}
            </div>
        </div>
    );
}

export default ProductList;