import React, { useEffect, useState } from 'react'
import UserAvatar from './UserAvatar';

export const AccountIcon = () => {

    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const [username, setUsername] = useState('Welcome');
    useEffect(() => {
        if(localStorage.getItem('authToken') == null){
            setIsLoggedIn(false);
        }
        else{
            setIsLoggedIn(true);
            setUsername(localStorage.getItem('email'));
        }
      }, []);
    return (
        <>
            {isLoggedIn == false && 
            <svg width="44" height="44" viewBox="0 0 44 44" fill="none" className='hover:fill-black' xmlns="http://www.w3.org/2000/svg">
                <rect width="44" height="44" rx="8" fill="white" />
                <path d="M22 23.6666C24.3012 23.6666 26.1667 21.8011 26.1667 19.4999C26.1667 17.1987 24.3012 15.3333 22 15.3333C19.6988 15.3333 17.8333 17.1987 17.8333 19.4999C17.8333 21.8011 19.6988 23.6666 22 23.6666ZM22 23.6666C18.3181 23.6666 15.3333 25.9052 15.3333 28.6666M22 23.6666C25.6819 23.6666 28.6667 25.9052 28.6667 28.6666" stroke="#2A2F2F" strokeWidth="1.5" strokeLinecap="round" />
            </svg>
            }

            {isLoggedIn == true && 
            <>
                <UserAvatar username={username} />
                {/* <button className="flex items-center gap-2 px-4 py-2 text-sm text-black bg-[#ffffff] hover:text-[#3B829A] rounded-lg transition-all">
                    <svg xmlns="http://www.w3.org/2000/svg" className="w-4 h-4" fill="none" viewBox="0 0 24 24" stroke="currentColor" strokeWidth={2}>
                        <path
                        strokeLinecap="round"
                        strokeLinejoin="round"
                        d="M17 16l4-4m0 0l-4-4m4 4H7m6 4v1a2 2 0 01-2 2H5a2 2 0 01-2-2V7a2 2 0 012-2h6a2 2 0 012 2v1"
                        />
                    </svg>
                </button> */}
            </>
            }
        </>

    )
}
