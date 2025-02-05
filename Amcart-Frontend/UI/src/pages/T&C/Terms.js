import React from 'react'
import content from '../../data/content.json'
import Footer from '../../components/Footer/Footer'
import './Terms.css'

const Terms = () => {
  return (
    <>
            <div className="terms-container">
      <header className="terms-header">
        <h1>Terms and Conditions</h1>
        <p>Welcome to AmCart! Please read these terms and conditions carefully before using our platform.</p>
      </header>

      <section className="terms-section">
        <h2>1. Introduction</h2>
        <p>
          These Terms and Conditions govern your use of AmCart's website and services. By accessing or using our 
          platform, you agree to comply with these terms. If you do not agree, you may not use the services.
        </p>
      </section>

      <section className="terms-section">
        <h2>2. Account Registration</h2>
        <p>
          To access certain features, you may be required to create an account. You are responsible for maintaining 
          the confidentiality of your account and password and for restricting access to your account.
        </p>
      </section>

      <section className="terms-section">
        <h2>3. Use of Services</h2>
        <ul>
          <li>Users must not misuse the platform for illegal purposes.</li>
          <li>You agree not to interfere with or disrupt the platform’s functionality.</li>
          <li>AmCart reserves the right to terminate accounts found violating these terms.</li>
        </ul>
      </section>

      <section className="terms-section">
        <h2>4. Payment and Billing</h2>
        <p>
          All payments made on AmCart are processed securely. By making a purchase, you agree to provide valid 
          payment details. We are not responsible for payment failures due to incorrect information.
        </p>
      </section>

      <section className="terms-section">
        <h2>5. Returns and Refunds</h2>
        <p>
          AmCart offers a hassle-free return and refund policy. Refer to our <a href="/refund-policy">Refund Policy</a> 
          page for detailed information on eligibility and procedures.
        </p>
      </section>

      <section className="terms-section">
        <h2>6. Promotions and Discounts</h2>
        <p>
          AmCart may offer limited-time promotions. Discounts are subject to specific terms and cannot be combined 
          unless explicitly stated.
        </p>
      </section>

      <section className="terms-section">
        <h2>7. Intellectual Property</h2>
        <p>
          All content, trademarks, and logos on AmCart are the property of their respective owners. Unauthorized 
          use of these materials is strictly prohibited.
        </p>
      </section>

      <section className="terms-section">
        <h2>8. Limitation of Liability</h2>
        <p>
          AmCart is not responsible for any damages resulting from the use or inability to use our platform. This 
          includes errors, interruptions, or data loss.
        </p>
      </section>

      <section className="terms-section">
        <h2>9. Changes to Terms</h2>
        <p>
          AmCart reserves the right to update these terms at any time. Users will be notified of significant 
          changes, and continued use of the platform constitutes acceptance of these updates.
        </p>
      </section>

      <footer className="terms-footer">
        <p>By using AmCart, you agree to these terms and conditions. For more information, contact our support team at <a href="mailto:support@amcart.com">support@amcart.com</a>.</p>
      </footer>
    </div>
        <Footer content={content?.footer}/>
    </>
  )
}

export default Terms