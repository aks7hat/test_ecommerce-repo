import React, { useState } from 'react'
import content from '../../data/content.json'
import Footer from '../../components/Footer/Footer'
import './ContactUs.css'

export const ContactUs = () => {

    const [state, setState] = useState({
        name: '',
        email: '',
        message: ''
    });

    const onNameChange = (event) => {
        setState({ ...state, name: event.target.value})
    }
    const onEmailChange = (event) => {
        setState({...state, email: event.target.value})
    }
    const onMessageChange = (event) => {
        setState({...state, message: event.target.value})
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(state);
        alert("Information Submitted!!!");
        setState({
            name: '',
            email: '',
            message: ''
        })
    }

  return (
    <>    
        <div className="contact-container">
            <div className="contact-header">
                <h1>Contact Us</h1>
                <p>We’d love to hear from you! Reach out to us with any questions or feedback.</p>
            </div>
            <form className="contact-form" onSubmit={handleSubmit} method="POST">
                <div className="form-group">
                <label htmlFor="name">Full Name</label>
                <input type="text" id="name" placeholder="Enter your full name" required value={state.name} onChange={onNameChange} />
                </div>
                <div className="form-group">
                <label htmlFor="email">Email Address</label>
                <input type="email" id="email" placeholder="Enter your email" required value={state.email} onChange={onEmailChange}/>
                </div>
                <div className="form-group">
                <label htmlFor="message">Message</label>
                <textarea id="message" rows="5" placeholder="Type your message here" required value={state.message} onChange={onMessageChange}></textarea>
                </div>
                <button type="submit" className="submit-button">Send Message</button>
            </form>
            <div className="contact-info">
                <h2>Our Office</h2>
                <p>123 AmCart Lane, Business Park, New York, NY 10001</p>
                <p>Email: support@amcart.com</p>
                <p>Phone: +1 (555) 123-4567</p>
            </div>
        </div>

        <Footer content={content?.footer}/>
    </>
    )
}
