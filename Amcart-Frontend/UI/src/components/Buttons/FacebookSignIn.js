import React, { useCallback } from 'react'
import facebookLogo from '../../assets/img/facebook.jpg'
import { API_BASE_URL } from '../../api/constant'
const FacebookSignIn = () => {

  const handleClick = useCallback(()=>{
    window.location.href = API_BASE_URL +"/oauth2/authorization/facebook";
  },[])

  return (
    <button onClick={handleClick} className='flex justify-center items-center border w-full rounded border-gray-600 h-[48px] hover:bg-slate-50'>
        <img src={facebookLogo} alt='google-icon' style={{width:'20px', height:'21px'}}/>
        <p className='px-2 text-gray-500'>Continue With Facebook</p>
    </button>
  )
}

export default FacebookSignIn