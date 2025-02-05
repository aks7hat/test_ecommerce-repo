import React from 'react'

const SvgFavourite = ({color="white"}) => {
    return (
        <svg width="34" height="34" viewBox="0 0 34 34" fill="none" xmlns="http://www.w3.org/2000/svg">
            <circle cx="17.1291" cy="16.9111" r="16.1796" fill={color} />
            <path d="M16.7199 12.7121C15.3451 11.1099 13.0525 10.6789 11.3299 12.146C9.60735 13.6131 9.36484 16.0661 10.7176 17.8013C11.8423 19.244 15.246 22.2867 16.3616 23.2716C16.4864 23.3817 16.5488 23.4368 16.6216 23.4585C16.6851 23.4774 16.7547 23.4774 16.8182 23.4585C16.891 23.4368 16.9534 23.3817 17.0782 23.2716C18.1938 22.2867 21.5975 19.244 22.7222 17.8013C24.075 16.0661 23.862 13.5977 22.1099 12.146C20.3577 10.6943 18.0947 11.1099 16.7199 12.7121Z" stroke="#3C4242" strokeWidth="1.26066" strokeLinecap="round" strokeLinejoin="round" />
        </svg>


    )
}

export default SvgFavourite