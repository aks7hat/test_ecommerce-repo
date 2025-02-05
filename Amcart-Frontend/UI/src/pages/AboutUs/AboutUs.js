import React from 'react'
import content from '../../data/content.json'
import Footer from '../../components/Footer/Footer'
import './AboutUs.css'

const AboutUs = () => {
  return (
      <>    
        <div className="about-us-container">
        <header className="about-us-header">
            <h1>Welcome to AmCart</h1>
            <p>
            At AmCart, we bring fashion to your fingertips. Our mission is to
            redefine the online shopping experience by offering a wide range of
            high-quality clothing for both men and women. Whether you're looking
            for the latest trends or timeless classics, we have something special
            for everyone.
            </p>
        </header>

        <section className="about-us-section">
            <h2>Who We Are</h2>
            <p>
            AmCart is more than just an online store; it’s a destination for style
            enthusiasts. Founded with a passion for fashion, we strive to deliver
            not only the finest apparel but also a seamless shopping journey. Our
            team works tirelessly to curate a collection that reflects diversity,
            elegance, and individuality.
            </p>
        </section>

        <section className="about-us-section">
            <h2>What We Offer</h2>
            <ul>
            <li>Premium Apparel: A wide selection of clothing for every occasion.</li>
            <li>Exciting Promotions: Enjoy exclusive deals, seasonal discounts, and festive sales.</li>
            <li>Tailored Shopping Experience: Advanced filters, product search, and personalized recommendations.</li>
            <li>Secure Payments: Multiple payment options with advanced security.</li>
            <li>Hassle-Free Returns: Easy return policies to guarantee satisfaction.</li>
            </ul>
        </section>

        <section className="about-us-section">
            <h2>Our Vision</h2>
            <p>
            To become a trusted name in fashion e-commerce by prioritizing
            customer satisfaction, quality, and innovation.
            </p>
        </section>

        <section className="about-us-section">
            <h2>Why Choose AmCart?</h2>
            <ul>
            <li>User-Friendly Platform: Sleek and intuitive design for effortless browsing.</li>
            <li>Dynamic Pricing: Competitive prices and special discounts during sales.</li>
            <li>Customer Support: Dedicated assistance available 24/7.</li>
            <li>Sustainability: Committed to ethical sourcing and eco-friendly practices.</li>
            </ul>
        </section>

        <footer className="about-us-footer">
            <h2>Join the AmCart Family</h2>
            <p>
            We’re excited to have you with us as we continue to grow and redefine
            online fashion retail. Follow us on social media for the latest
            updates, trends, and exclusive offers.
            </p>
            <p className="cta">Stay Stylish, Stay AmCart!</p>
        </footer>
        </div>
        <Footer content={content?.footer}/>
    </>
  )
}

export default AboutUs