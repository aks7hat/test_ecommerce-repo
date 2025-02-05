import React, { useState, useRef, useEffect } from "react";
import { searchProducts } from "../../api/fetchProducts";
import { useNavigate } from "react-router-dom";

const SearchBox = () => {
  const [searchQuery, setSearchQuery] = useState("");
  const [results, setResults] = useState([]);
  const [isSearching, setIsSearching] = useState(false);
  const [showSuggestions, setShowSuggestions] = useState(false);
  const navigate = useNavigate();

  const searchContainerRef = useRef(null);

  // Debounce timer
  let debounceTimer;

  // Handle input change
  const handleSearchChange = (event) => {
    const value = event.target.value;
    setSearchQuery(value);
    setIsSearching(true);

    clearTimeout(debounceTimer);
    debounceTimer = setTimeout(() => {
      if (value.trim() !== "") {
        fetchSearchResults(value);
        setShowSuggestions(true);
      } else {
        setResults([]);
        setIsSearching(false);
        setShowSuggestions(false);
      }
    }, 500); // 300ms debounce
  };

  // Fetch search results
  const fetchSearchResults = async (query) => {
    try {
      const response = query.length > 2 ?  await searchProducts(query) : "";
      setResults(response);
    } catch (error) {
      console.error("Error fetching search results:", error);
    } finally {
      setIsSearching(false);
    }
  };

  const handleProductClick = (id) => {
    setShowSuggestions(false);
    navigate(`/product/${id}`);
    setSearchQuery("");
    // console.log(id);
  }
  const handleKeyDown = (event) => {
    if (event.key === "Enter") {
      setShowSuggestions(false);
      navigate("/products/search", { state: { searchResults: results, query: searchQuery } });
      setSearchQuery("");
    }
  };

  useEffect(() => {
    const handleOutsideClick = (event) => {
      if (
        searchContainerRef.current &&
        !searchContainerRef.current.contains(event.target)
      ) {
        setShowSuggestions(false);
      }
    };

    document.addEventListener("mousedown", handleOutsideClick);
    return () => {
      document.removeEventListener("mousedown", handleOutsideClick);
    };
  }, []);

  return (
    <div ref={searchContainerRef} style={{ margin: "20px auto", maxWidth: "600px", position: "relative" }}>
      {/* Search Input */}
      
      <input
        type="text"
        placeholder="🔍 Search for products..."
        value={searchQuery}
        onChange={handleSearchChange}
        onKeyDown={handleKeyDown}
        style={{
          width: "100%",
          padding: "12px 16px",
          fontSize: "16px",
          border: "1px solid #ddd",
          borderRadius: "6px",
          boxShadow: "0 2px 4px rgba(0, 0, 0, 0.1)",
          transition: "border-color 0.3s",
          color:"black"
        }}
      />

      {/* Loading indicator */}
      {/* {isSearching && (
        <p style={{ marginTop: "8px", fontSize: "14px", color: "#0077ff" }}>
          Searching...
        </p>
      )} */}

      {/* Search Results Dropdown */}
      {showSuggestions && results?.length > 0 && (
        <div
          style={{
            position: "absolute",
            top: "60px",
            left: 0,
            right: 0,
            border: "1px solid #ddd",
            borderRadius: "6px",
            backgroundColor: "#fff",
            boxShadow: "0 4px 8px rgba(0, 0, 0, 0.1)",
            zIndex: 10,
            maxHeight: "250px",
            overflowY: "auto",
          }}
        >
          {results.map((product) => (
            <div
              key={product.productId}
              onClick={() => handleProductClick(product.productId)}
              style={{
                display: "flex",
                alignItems: "center",
                padding: "10px",
                borderBottom: "1px solid #f1f1f1",
                cursor: "pointer",
                transition: "background-color 0.3s",
              }}
              onMouseOver={(e) =>
                (e.currentTarget.style.backgroundColor = "#f9f9f9")
              }
              onMouseOut={(e) =>
                (e.currentTarget.style.backgroundColor = "transparent")
              }
            >
              <img
                src={product?.url || "https://via.placeholder.com/40"}
                alt={product.name}
                style={{
                  width: "40px",
                  height: "40px",
                  borderRadius: "4px",
                  objectFit: "cover",
                  marginRight: "10px",
                }}
              />
              <div>
                <p
                  style={{
                    margin: 0,
                    fontSize: "14px",
                    fontWeight: "bold",
                    color: "#333",
                  }}
                >
                  {product.name}
                </p>
                <p
                  style={{
                    margin: "4px 0 0",
                    fontSize: "12px",
                    color: "#666",
                  }}
                >
                  ${product.price || "N/A"}
                </p>
              </div>
            </div>
          ))}
        </div>
      )}
    </div>
  );

};

export default SearchBox;
