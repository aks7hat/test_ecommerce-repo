import React, { useEffect, useMemo, useState } from 'react'
import { useDispatch, useSelector } from 'react-redux';
import { selectCartItems } from '../../store/features/cart';
import { fetchUserDetails } from '../../api/userInfo';
import { setLoading } from '../../store/features/common';
import { useNavigate } from 'react-router-dom';
import PaymentPage from '../PaymentPage/PaymentPage';
import CheckoutForm from '../PaymentPage/CheckoutPayment';
import AddAddress from '../Account/AddAddress';
import Footer from '../../components/Footer/Footer';
import content from '../../data/content.json';

const Checkout = () => {
  const cartItems = useSelector(selectCartItems);
  const dispatch = useDispatch();
  const [userInfo,setUserInfo] = useState([]);
  const [error,setError] = useState('');
  const navigate = useNavigate();
  const [paymentMethod,setPaymentMethod] = useState('');
  const [addAddress, setAddAddress] = useState(false);
  const [selectedDeliveryDate, setSelectedDeliveryDate] = useState();

  const [formData, setFormData] = useState({
    cardNumber: "",
    cardHolder: "",
    cvv: "",
    upiId: "",
    cash: "Pay on Delivery",
  });
  const [paymentSuccess, setPaymentSuccess] = useState(false);

  // Handle method selection
  const handlePaymentMethod = (method) => {
    setPaymentMethod(method);
    setFormData({
      cardNumber: "",
      cardHolder: "",
      cvv:"",
      upiId: "",
      cash: "Pay on Delivery",
    });
    setPaymentSuccess(false);
  };

  // Handle input changes
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: name === "cardNumber" ? formatCardNumber(value) : value,
    }));
  };

  // Handle payment submission
  const handlePayment = (e) => {
    e.preventDefault();
    if(userInfo?.addressList.length == 0){
      setError("Enter Address to proceed!!");
      window.scrollTo({
        top: 0,
        left: 100,
        behavior: 'smooth'
    });
      return;
    }
    setPaymentSuccess(true);
  };

  const subTotal = useMemo(()=>{
    let value = 0;
    cartItems?.forEach(element => {
       value += element?.subTotal 
    });
    return value?.toFixed(2);
  },[cartItems]);

  useEffect(()=>{
    dispatch(setLoading(true))
    fetchUserDetails().then(res=>{
      setUserInfo(res);
    }).catch(err=>{

    }).finally(()=>{
      dispatch(setLoading(false))
    })
  },[dispatch]);

  const monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun",
    "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"
  ];
  const getDeliveryDate = () => {
    var date = new Date();
    return date.getDate();
  }
  const getDeliveryMonth = () => {
    var date = new Date();
    return monthNames[date.getMonth()];
  }
  const formatCardNumber = (value) => {
    return value
      .replace(/\D/g, "") 
      .replace(/(.{4})/g, "$1 ")
      .trim();
  };
  
  return (
    <>
    <div className='p-8 flex'>
      <div className='w-[70%]'>
        <div className='flex gap-8'>
          {/* Address */}
          <p className='font-bold'>Delivery address </p>
          {userInfo?.addressList && userInfo?.addressList?.length > 0 && 
          // <div>
          //   <p><b>{userInfo?.addressList?.[0]?.name}</b></p>
          //   <p>{userInfo?.addressList?.[0]?.street}</p>
          //   <p>{userInfo?.addressList?.[0]?.city} {userInfo?.addressList?.[0]?.state} {userInfo?.addressList?.[0]?.zipCode}</p>
          // </div>
          <div className="border border-gray-300 rounded-lg p-5 shadow-lg flex items-start space-x-4" style={{marginTop:"-10px",width:"40%"}}>
            <div className="bg-blue-100 text-blue-600 rounded-full h-10 w-10 flex items-center justify-center font-bold">
              📍
            </div>
            <div>
              <p className="font-semibold text-lg text-gray-800 mb-1">
                {userInfo?.addressList?.[0]?.name}
              </p>
              <p className="text-gray-600 text-sm">
                {userInfo?.addressList?.[0]?.street}
              </p>
              <p className="text-gray-600 text-sm">
                {userInfo?.addressList?.[0]?.city}, {userInfo?.addressList?.[0]?.state}{" "}
                {userInfo?.addressList?.[0]?.zipCode}
              </p>
            </div>
          </div>
          }
          {userInfo?.addressList?.length == 0 && !addAddress && 
          <button className="text-blue-900" style={{
            ...styles.optionButton, marginTop:'-12px'}} onClick={()=> {setAddAddress(true);setError("")}}>Add Address</button>}
          <div style={{marginTop: '-20px'}}>
            {addAddress && <AddAddress onCancel={()=> setAddAddress(false)}/>}          
          </div>
          {error && <p className='text-lg text-red-600'>{error}</p>}
        </div>
        <hr className='h-[2px] bg-slate-200 w-[90%] my-4'></hr>    
        {/* <div className='flex gap-8 flex-col'>
          Address
          <p className='font-bold'>Choose delivery</p>
          <div>
            <p>Select a day</p>
            <div className='flex gap-4 mt-4'>
                  <div className='w-[80px] h-[48px] flex flex-col justify-center border text-center mb-4 rounded-lg mr-4 cursor-pointer
                   hover:scale-110 bg-white border-gray-500 text-black-500 delivery-first' style={selectedDeliveryDate === 'first' ? {backgroundColor:'black', color: 'white', fontWeight: 700} : {backgroundColor:'white', color: 'black',fontWeight: 700}} onClick={() => setSelectedDeliveryDate('first')}><p className='text-center'>{getDeliveryDate()+4 + " " + getDeliveryMonth()}</p></div>

            <div className='w-[80px] h-[48px] flex flex-col justify-center border text-center mb-4 rounded-lg mr-4 cursor-pointer
                   hover:scale-110 bg-white border-gray-500 text-black-500 delivery-second' style={selectedDeliveryDate === 'second' ? {backgroundColor:'black', color: 'white',fontWeight: 700} : {backgroundColor:'white', color: 'black',fontWeight: 700}} onClick={() => setSelectedDeliveryDate('second')}><p className='text-center'>{getDeliveryDate()+6 + " " + getDeliveryMonth()}</p></div>
                  
                  </div>
          </div>
        </div> */}
        {/* <hr className='h-[2px] bg-slate-200 w-[90%] my-4'></hr> */}
        
        {/* {paymentMethod === 'CARD' && <PaymentPage userId={userInfo?.id} addressId={userInfo?.addressList?.[0]?.id}/>}
        
        {paymentMethod !== 'CARD' && <button className='w-[150px] items-center h-[48px] bg-black border rounded-lg mt-4 text-white hover:bg-gray-800' onClick={()=> navigate('/payment')}>Pay Now</button>} */}
      <div style={styles.pageContainer} className='flex flex-col gap-2'>
      <p className='font-bold'>Payment Method</p>
      <div style={styles.optionsContainer}>
        <div style={styles.paymentOptions}>
          <button
            style={{
              ...styles.optionButton,
              color:paymentMethod === "card" ? "white" : "rgb(51, 51, 51)",
              backgroundColor: paymentMethod === "card" ? "black" : "#fff",
            }}
            onClick={() => handlePaymentMethod("card")}
          >
            Credit/Debit Card
          </button>
          <button
            style={{
              ...styles.optionButton,
              color:paymentMethod === "cod" ? "white" : "rgb(51, 51, 51)",
              backgroundColor: paymentMethod === "cod" ? "black" : "#fff",
            }}
            onClick={() => handlePaymentMethod("cod")}
          >
            Cash on Delivery
          </button>
          <button
            style={{
              ...styles.optionButton,
              color:paymentMethod === "upi" ? "white" : "rgb(51, 51, 51)",
              backgroundColor: paymentMethod === "upi" ? "black" : "#fff",
            }}
            onClick={() => handlePaymentMethod("upi")}
          >
            UPI/Wallet
          </button>
        </div>
      </div>

      {/* Dynamic Payment Form */}
      {paymentMethod && (
        <form onSubmit={handlePayment} style={styles.paymentForm}>
          {paymentMethod === "card" && (
            <>
              <h3>Enter Card Details</h3>
              <input
                type="text"
                name="cardNumber"
                placeholder="Card Number"
                value={formData.cardNumber}
                onChange={handleInputChange}
                required
                style={styles.inputField}
              />
              <input
                type="text"
                name="cardHolder"
                placeholder="Card Holder Name"
                value={formData.cardHolder}
                onChange={handleInputChange}
                required
                style={styles.inputField}
              />
              <input
                type="password"
                name="cvv"
                placeholder="CVV"
                value={formData.cvv}
                onChange={handleInputChange}
                required
                style={styles.inputField}
              />
            </>
          )}

          {paymentMethod === "upi" && (
            <>
              <h3>Enter UPI/Wallet Details</h3>
              <input
                type="text"
                name="upiId"
                placeholder="UPI ID or Wallet Address"
                value={formData.upiId}
                onChange={handleInputChange}
                required
                style={styles.inputField}
              />
            </>
          )}

          {paymentMethod === "cod" && (
            <>
              <h3>Cash on Delivery Selected</h3>
              <p>No payment required now. Pay when you receive the order.</p>
            </>
          )}

          <button type="submit" style={styles.submitButton}>
            Proceed to order
          </button>
        </form>
      )}

      {/* Payment Success Message */}
      {paymentSuccess && (
        // <div style={styles.successMessage}>
        //   <h2>Payment Successful!</h2>
        //   <p>
        //     {paymentMethod === "card" &&
        //       `Paid using Card: ${formData.cardNumber.replace(/\d{12}(\d{4})/, "**** **** **** $1")}`}
        //     {paymentMethod === "upi" &&
        //       `Paid using UPI/Wallet: ${formData.upiId}`}
        //     {paymentMethod === "cod" && `Cash on Delivery selected.`}
        //   </p>
        // </div>
        <CheckoutForm userId={userInfo?.id} addressId={userInfo?.addressList?.[0]?.id} paymentType={paymentMethod}/>
      )}
    </div>
    </div>
      <div className='w-[30%] h-[30%] border rounded-lg border-gray-500 p-4 flex flex-col gap-4'>
        <p style={{textAlign:'center', fontWeight: 700, fontSize: 'larger'}}>Order Summary</p>
        <hr />
        <p>Items Count = {cartItems?.length}</p>
        <p>SubTotal = ${subTotal}</p>
        <p>Shipping = FREE</p>
        <hr className='h-[2px] bg-gray-400'></hr>
        <p style={{textAlign:'center', fontWeight: 700, fontSize: 'larger'}}>Cart Total = ${subTotal}</p>
      </div>
    </div>
    <Footer content={content?.footer}/>
    </>
  )
}

const styles = {
  pageContainer: {
    fontWeight: 700,
    fontFamily: "Arial, sans-serif",
    padding: "20px",
    maxWidth: "800px",
    backgroundColor: "#f9f9f9",
    border: "1px solid #ddd",
    borderRadius: "10px",
    boxShadow: "0 4px 8px rgba(0,0,0,0.1)",
  },
  header: {
    textAlign: "center",
    color: "#333",
  },
  optionsContainer: {
    textAlign: "center",
    marginBottom: "20px",
  },
  paymentOptions: {
    display: "flex",
    justifyContent: "space-around",
    marginTop: "10px",
  },
  optionButton: {
    padding: "10px 20px",
    border: "1px solid #ccc",
    borderRadius: "5px",
    cursor: "pointer",
    transition: "all 0.3s ease",
    color: "#333",
  },
  paymentForm: {
    display: "flex",
    flexDirection: "column",
    gap: "10px",
    marginTop: "20px",
  },
  inputField: {
    padding: "10px",
    border: "1px solid #ccc",
    borderRadius: "5px",
    fontSize: "14px",
  },
  submitButton: {
    backgroundColor: "black",
    color: "#fff",
    border: "none",
    padding: "10px",
    fontSize: "16px",
    borderRadius: "5px",
    cursor: "pointer",
  },
  successMessage: {
    marginTop: "20px",
    textAlign: "center",
    color: "green",
  },
};
export default Checkout