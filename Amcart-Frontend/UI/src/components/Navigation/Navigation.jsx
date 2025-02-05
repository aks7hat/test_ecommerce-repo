import React from 'react'
import { Wishlist } from '../common/Wishlist'
import { AccountIcon } from '../common/AccountIcon'
import { CartIcon } from '../common/CartIcon'
import { Link, NavLink, useNavigate } from 'react-router-dom'
import './Navigation.css';
import { useSelector } from 'react-redux'
import { countCartItems } from '../../store/features/cart'
import SearchBox from '../common/SearchBox'

const Navigation = ({variant="default"}) => {
  const cartLength = useSelector(countCartItems);
  const navigate = useNavigate();

  return (
    // <nav className='flex items-center py-6 px-16 justify-between gap-20 custom-nav'>
    //   <div className='flex items-center gap-6'>
    //     {/* Logo */}
    //     <a className='text-3xl text-black font-bold gap-8' href='/'><u>AmCart</u></a>
    //   </div>
    //   { variant ==="default" &&
    //   <div className='flex flex-wrap items-center gap-10'>
    //     {/* Nav items */}
    //     <ul className='flex gap-14 text-gray-600 hover:text-black'>
    //       <li><NavLink to='/products/all' className={({isActive})=> isActive ? 'active-link':''}>Shop</NavLink></li>
    //       <li><NavLink to='/men' className={({isActive})=> isActive ? 'active-link':''}>Men</NavLink></li>
    //       <li><NavLink to='/women' className={({isActive})=> isActive ? 'active-link':''}>Women</NavLink></li>
    //       {/* <li><NavLink to='/kids' className={({isActive})=> isActive ? 'active-link':''}>Kids</NavLink></li> */}
    //     </ul>

    //   </div>
    //   }
    //   { variant ==="default" &&
    //   <div className='flex justify-center'>
    //     {/* Search bar */}
    //     {/* <div className='border rounded flex overflow-hidden'>
    //       <div className="flex items-center justify-center px-4 border-1">
    //         <svg className="h-4 w-4 text-grey-dark" fill="currentColor" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M16.32 14.9l5.39 5.4a1 1 0 0 1-1.42 1.4l-5.38-5.38a8 8 0 1 1 1.41-1.41zM10 16a6 6 0 1 0 0-12 6 6 0 0 0 0 12z"/></svg>
    //         <input type="text" className="px-4 py-2 outline-none" placeholder="Search"/>
    //       </div> 

    //     </div> */}
    //     <SearchBox />
    //   </div>
    //   }

    //   <div className='flex flex-wrap items-center gap-4'>
    //     {/* Action Items - icons */}
    //     { variant ==="default" &&
    //     <ul className='flex gap-8 '>
    //       {/* <li><button ><Wishlist /></button></li> */}
    //       <li><button onClick={()=> navigate('/account-details/profile')}><AccountIcon/></button></li>
    //       <li><Link to='/cart-items' className='flex flex-wrap'><CartIcon />
    //       {cartLength > 0 && <div className='absolute ml-6 inline-flex items-center justify-center h-6 w-6 bg-black text-white rounded-full border-2 text-xs border-white'>{cartLength}</div>}
    //       </Link></li>
    //     </ul>}
    //     {
    //       variant === "auth" &&
    //       <ul className='flex gap-8'>
    //         <li className='text-black border border-black hover:bg-slate-100 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 focus:outline-none'><NavLink to={"/v1/login"} className={({isActive})=> isActive ? 'active-link':''}>Login</NavLink></li>
    //         <li className='text-black border border-black hover:bg-slate-100 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 focus:outline-none'><NavLink to="/v1/register" className={({isActive})=> isActive ? 'active-link':''}>Signup</NavLink></li>
    //       </ul>
    //     }
    //   </div>

    // </nav>
    <nav className='bg-[#343434] shadow-lg py-4 px-8 lg:px-16 flex items-center justify-between text-white mb-10' style={{height: '121px'}}>
    <div className='flex items-center gap-6'>
      {/* Logo */}
      <a className='text-4xl font-extrabold tracking-wide text-transparent bg-clip-text bg-gradient-to-r from-[#ffffff] via-[#cceeff] to-[#e3950f] transition-all duration-300 hover:scale-105 hover:text-[#ffffff] hover:from-[#ffffff] hover:to-[#ffffff]' href='/'><u>AmCart</u></a>
    </div>
    { variant ==="default" &&
    <div className='hidden lg:flex items-center space-x-12'>
      {/* Nav items */}
      <ul className='flex items-center gap-10 text-lg font-medium'>
        <li><NavLink to='/products/all' className={({ isActive }) =>`hover:text-[#f5deb3] transition ${isActive ? "text-[#f5deb3] border-b-2 border-[#f5deb3]" : ""}`}>Shop</NavLink></li>
        <li><NavLink to='/men' className={({ isActive }) =>`hover:text-[#f5deb3] transition ${isActive ? "text-[#f5deb3] border-b-2 border-[#f5deb3]" : ""}`}>Men</NavLink></li>
        <li><NavLink to='/women' className={({ isActive }) =>`hover:text-[#f5deb3] transition ${isActive ? "text-[#f5deb3] border-b-2 border-[#f5deb3]" : ""}`}>Women</NavLink></li>
        {/* <li><NavLink to='/kids' className={({isActive})=> isActive ? 'active-link':''}>Kids</NavLink></li> */}
      </ul>

    </div>
    }
    { variant ==="default" &&
    <div className='flex justify-center'>
      {/* Search bar */}
      {/* <div className='border rounded flex overflow-hidden'>
        <div className="flex items-center justify-center px-4 border-1">
          <svg className="h-4 w-4 text-grey-dark" fill="currentColor" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M16.32 14.9l5.39 5.4a1 1 0 0 1-1.42 1.4l-5.38-5.38a8 8 0 1 1 1.41-1.41zM10 16a6 6 0 1 0 0-12 6 6 0 0 0 0 12z"/></svg>
          <input type="text" className="px-4 py-2 outline-none" placeholder="Search"/>
        </div> 

      </div> */}
      <SearchBox />
    </div>
    }

    <div className='flex flex-wrap items-center gap-4'>
      {/* Action Items - icons */}
      { variant ==="default" &&
      <ul className='flex gap-8 '>
        {/* <li><button ><Wishlist /></button></li> */}
        <li><button onClick={()=> navigate('/account-details/profile')}><AccountIcon/></button></li>
        <li><Link to='/cart-items' className='flex flex-wrap'><CartIcon />
        {cartLength > 0 && <div className='absolute ml-6 inline-flex items-center justify-center h-6 w-6 bg-black text-white rounded-full border-2 text-xs border-white'>{cartLength}</div>}
        </Link></li>
      </ul>}
      {
        variant === "auth" &&
        <ul className='flex gap-8'>
          <li className='bg-[#ffffff] text-black border hover:bg-slate-100 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 focus:outline-none'><NavLink to={"/v1/login"} className={({isActive})=> isActive ? 'active-link':''}>Login</NavLink></li>
          <li className='bg-[#ffffff] text-black border hover:bg-slate-100 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 focus:outline-none'><NavLink to="/v1/register" className={({isActive})=> isActive ? 'active-link':''}>Signup</NavLink></li>
        </ul>
      }
    </div>

  </nav>
  )
}

export default Navigation