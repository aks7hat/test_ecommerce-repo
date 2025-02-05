import React, { useMemo } from 'react'
import { Link, useLocation } from 'react-router-dom';
import Footer from '../../components/Footer/Footer';
import content from '../../data/content.json';

const OrderConfirmed = () => {

  const location = useLocation();

  const orderId = useMemo(()=>{
    const query = new URLSearchParams(location.search);
    const orderId = query.get('orderId');
    return orderId;
  },[location.search]);
  
  return (
    <>
    {/* <div className='p-8'>
        <h1 className='text-2xl'>Thank you for shopping with us!</h1>
        <p>Your order has been successfully placed. Your order ID is <strong>{orderId}</strong>.</p>
        <br/>
        <hr/>
        <br />
        <h2 className='underline text-blue-500'><Link to={'/account-details/orders'}>View All Orders here</Link></h2>
    </div> */}

    <div className="p-8 bg-gradient-to-br from-green-50 to-white rounded-lg shadow-lg max-w-3xl mx-auto">
      {/* Success Icon and Thank You Message */}
      <div className="text-center">
        <div className="inline-block p-4 bg-green-100 rounded-full shadow-md">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            className="h-12 w-12 text-green-600"
            fill="none"
            viewBox="0 0 24 24"
            stroke="currentColor"
            strokeWidth="2"
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              d="M9 12l2 2 4-4M7 12a5 5 0 118 0 5 5 0 01-8 0z"
            />
          </svg>
        </div>
        <h1 className="text-4xl font-bold text-green-700 mt-4">
          Thank you for shopping with us!
        </h1>
        {/* <p className="text-lg text-gray-700 mt-2">
          We appreciate your business and hope you enjoy your purchase!
        </p> */}
      </div>

      {/* Order ID Section */}
      <div className="bg-white mt-8 p-6 rounded-lg shadow-md border-t-4 border-green-600">
        <p className="text-lg text-gray-800">
          Your order has been successfully placed. 
        </p>
        <p className="mt-2 text-xl text-gray-800">
          <span className="font-semibold text-indigo-600">Order ID:</span>{" "}
          <span className="font-bold">{orderId}</span>
        </p>
      </div>

      {/* Divider */}
      <div className="mt-8 flex justify-center">
        <hr className="w-1/2 border-t-2 border-gray-300" />
      </div>

      {/* View Orders Button */}
      <div className="mt-6 text-center">
        <Link
          to="/account-details/orders"
          className="inline-block px-6 py-3 bg-blue-600 text-white font-semibold text-lg rounded-lg shadow-md hover:bg-blue-700 transition"
        >
          View All Orders
        </Link>
      </div>

      {/* Footer Message */}
      <p className="text-sm text-gray-500 mt-6 text-center">
        If you have any questions about your order, please contact our support team.
      </p>
    </div>

    <Footer content={content?.footer}/>
    </>
  )
}

export default OrderConfirmed