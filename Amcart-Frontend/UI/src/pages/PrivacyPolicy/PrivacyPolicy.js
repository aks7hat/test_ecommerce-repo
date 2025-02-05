import React from 'react'
import content from '../../data/content.json'
import Footer from '../../components/Footer/Footer'
import './PrivacyPolicy.css'

const PrivacyPolicy = () => {
  return (
    <>
        <div className="privacy-container">
            <div className="privacy-header">
                <h1>Privacy Policy</h1>
                <p>Your privacy is our priority. This policy explains how we handle your information.</p>
            </div>
            <div className="privacy-content">
                <section>
                <h2>1. Information We Collect</h2>
                <p>
                    When you use AmCart, we collect the information you provide, including your name, email
                    address, phone number, and payment details. We also gather data about your browsing
                    behavior on our platform.
                </p>
                </section>
                <section>
                <h2>2. How We Use Your Information</h2>
                <ul>
                    <li>To process orders and deliver products.</li>
                    <li>To improve your shopping experience.</li>
                    <li>To notify you of promotions and updates.</li>
                    <li>To ensure secure transactions.</li>
                </ul>
                </section>
                <section>
                <h2>3. Sharing Your Information</h2>
                <p>
                    We respect your privacy and do not sell your data to third parties. However, we may
                    share your information with trusted partners for payment processing, order fulfillment,
                    and compliance with legal requirements.
                </p>
                </section>
                <section>
                <h2>4. Your Rights</h2>
                <p>
                    You have the right to access, update, or delete your personal information. Please
                    contact us if you wish to exercise these rights.
                </p>
                </section>
                <section>
                <h2>5. Data Security</h2>
                <p>
                    We use advanced security measures to protect your personal data. However, no system is
                    100% secure, and we cannot guarantee complete data safety.
                </p>
                </section>
                <section>
                <h2>6. Changes to This Policy</h2>
                <p>
                    We may update this Privacy Policy to reflect changes in our practices. Please review it
                    periodically.
                </p>
                </section>
                <section>
                <h2>7. Contact Us</h2>
                <p>
                    If you have questions about this Privacy Policy, reach out to us at
                    <a href="mailto:privacy@amcart.com"> privacy@amcart.com</a>.
                </p>
                </section>
            </div>
        </div>
        <Footer content={content?.footer}/>
    </>
  )
}

export default PrivacyPolicy