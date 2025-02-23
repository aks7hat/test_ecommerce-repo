import React from 'react'
import HeroImg from '../../assets/img/hero-img1.jpg'
import Joggers from '../../assets/img/joggers.jpg'
import bgImage from '../../assets/img/bg-home.jpg'
import { useNavigate } from 'react-router-dom'

const HeroSection = () => {
  const navigate = useNavigate();
  const handleClick = (e) => {
    e.preventDefault();
    navigate('/products/all')
  }
  return (
    <div className='relative flex items-center bg-cover flext-start bg-center text-left h-svh w-full' style={{backgroundImage
    : `url(${bgImage})`}}>
        <div className='absolute top-0 right-0 bottom-0 left-0'></div>
        <main className='px-10 lg:px-24 z-10'>
            <div className='text-left'>
                {/* <h2 className='text-2xl text-white'>T-shirt / Tops</h2> */}
            </div>
            <p className='text-white sm:max-w-xl text-6xl' style={{color: 'crimson', marginTop:'-40px'}}>
            8220d887-4b67-4cf9-ab70-58f183317669
            </p>
            {/* <p className='mt-3 text-white sm:mt-5 sm:max-w-xl text-2xl'>
            cool / colorful / comfy
            </p> */}
            <button className='border rounded mt-10 border-black hover:bg-white hover:text-black hover:border-black text-white bg-black w-44 h-12' style={{backgroundColor: 'brown'}} onClick={handleClick}>
              Shop Now
            </button>
        </main>
        
    </div>
  )
}

export default HeroSection