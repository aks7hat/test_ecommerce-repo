import React from 'react'
import FbIcon from '../common/FbIcon'
import InstaIcon from '../common/InstaIcon'


const Footer = ({content}) => {
  return (
    <div className='bg-[#343434] text-white py-8 mt-10'>
        <div className='flex justify-around'>
            {content?.items && content?.items?.map((item,index)=>{
                return (
                    <div className='flex flex-col' key={index}>
                    <p className='text-[18px] pb-[10px]'>{item?.title}</p>
                    {item?.list && item?.list?.map((listItem,index)=><a className='flex flex-col text-[14px] py-2' key={index}
                     href={listItem?.path}>{listItem?.label}</a>)}
                     {item?.description && <p>{item?.description}</p>}
                    </div>
                )
            })}
        </div>
        <div className='flex gap-2 items-center justify-center py-4'>
          <a href=''><FbIcon /></a>
          <a href=''><InstaIcon /></a>  
        </div>
        <p className='text-sm text-white text-center content-center'>{content?.copyright}</p>

    </div>
  )
}


export default Footer