import React, { useCallback } from 'react'
import githubLogo from '../../assets/img/github.png'
import { API_BASE_URL } from '../../api/constant'
const GithubSignIn = () => {

  const handleClick = useCallback(()=>{
    window.location.href = API_BASE_URL +"/oauth2/authorization/github";
  },[])

  return (
    <button onClick={handleClick} className='flex justify-center items-center border w-full rounded border-gray-600 h-[48px] hover:bg-slate-50'>
        <img src={githubLogo} alt='google-icon' style={{width:'31px', height:'31px'}}/>
        <p className='px-2 text-gray-500'>Continue With Github</p>
    </button>
  )
}

export default GithubSignIn