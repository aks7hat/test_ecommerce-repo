import React, { useState } from 'react'
import SvgFavourite from '../../components/common/SvgFavourite'
import { Link } from 'react-router-dom'

const ProductCardSearch = ({id,title,description,price,brand,url,productId}) => {
  const [color, setColor] = useState('white');
  return (
    <div className='flex flex-col hover:scale-105 relative'>
      <Link to={`/product/${productId}`}>
        <img className={`h-[320px] w-[280px]
         border rounded-lg cursor-pointer object-cover block`} src={url} alt={title}/>
         </Link>
         
         <div className='flex justify-between items-center'>
          <div className='flex flex-col pt-2'>
          <p className='text-[16px] p-1'>{title}</p>
          {description && <p className='text-[12px] px-1 text-gray-600'>{brand}</p>}
          </div>
          <div>
            <p>${price}</p>
          </div>
        </div>
        <button onClick={()=> color === 'white' ? setColor('pink') : setColor('white')} className='absolute top-0 right-0 pt-4 pr-4 cursor-pointer'><SvgFavourite color={color}/></button>
    </div>
  )
}

export default ProductCardSearch