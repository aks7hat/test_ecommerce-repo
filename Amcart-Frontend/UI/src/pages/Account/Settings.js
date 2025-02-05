import React, { useCallback } from 'react'
import { logOut } from '../../utils/jwt-helper';
import { useNavigate } from 'react-router-dom';

const Settings = () => {
    const navigate = useNavigate();

    const onLogOut = useCallback(() => {
        logOut();
        navigate("/");
        window.location.reload();
    }, [navigate]);

    const handleNavigation = (path) => {
      navigate(path);
    };
  return (
    // <div>
    //     <button onClick={onLogOut} className='w-[150px] items-center h-[48px] bg-black border rounded-lg mt-2 text-white hover:bg-gray-800'>Logout</button>
    // </div>

    <div className="p-6 max-w-3xl mx-auto">
      {/* <h1 className="text-2xl font-semibold text-gray-800 mb-6">Settings</h1> */}
      <div className="space-y-6">
        <div className="bg-white border rounded-lg shadow-md p-6">
          <h2 className="text-lg font-medium text-gray-800 mb-4">Account Settings</h2>
          <div className="flex flex-col gap-4">
            <button onClick={() => handleNavigation("/account-details/profile")}
              className="w-full py-2 text-center bg-gray-100 text-gray-800 rounded-md hover:bg-gray-200 transition-all"
            > Edit Profile
            </button>
            <button onClick={() => handleNavigation("/account-details/profile")}
              className="w-full py-2 text-center bg-gray-100 text-gray-800 rounded-md hover:bg-gray-200 transition-all"
            > Change Password
            </button>
          </div>
        </div>
        <div className="bg-white border rounded-lg shadow-md p-6">
          <h2 className="text-lg font-medium text-gray-800 mb-4">Logout</h2>
          <button
            onClick={onLogOut}
            className="w-full py-2 text-center bg-red-100 text-red-600 rounded-md hover:bg-red-200 transition-all"
          >
            Logout
          </button>
        </div>
      </div>
    </div>
  )
}

export default Settings