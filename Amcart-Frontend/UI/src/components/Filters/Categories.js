import React, { useEffect, useState } from 'react'

const Categories = ({types, onSelect=() => {}}) => {

  const [selectedFilters, setSelectedFilters] = useState({});
  const handleToggle = (e, type) => {

    const isChecked = e.target.checked;
    setSelectedFilters((prev) => ({
      ...prev,
      [type.code]: isChecked,
    }));

    if(e.target.checked){
      onSelect(type);
    }
    else{
      onSelect(type);
    }
  }

  useEffect(() => {
    const initialFilters = types?.reduce((acc, type) => {
      acc[type.code] = false; 
      return acc;
    }, {});
    setSelectedFilters(initialFilters);
  },[types])
  
  return (
    <div >
      {types?.map(type=>{
        return (
          <div className='flex items-center p-1' key={type?.id}>
            <input type='checkbox' name={type?.code} className='border rounded-xl w-4 h-4 accent-black text-black' onChange={(e) => handleToggle(e, type)} checked={selectedFilters[type?.code] || false}/>
            <label htmlFor={type?.code} className='px-2 text-[14px] text-gray-600'>{type?.name}</label>
          </div>
        )
      })}
    </div>
  )
}

export default Categories