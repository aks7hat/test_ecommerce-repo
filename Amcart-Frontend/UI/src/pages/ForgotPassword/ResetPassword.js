import React, { useCallback, useState } from 'react'
import { useDispatch } from 'react-redux';
import { useSearchParams } from 'react-router-dom';
import { ResetPasswordRequest } from '../../api/authentication';
import { setLoading } from '../../store/features/common'

const ResetPassword = () => {

    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");
    const [message, setMessage] = useState("");
    const [passMsg, setPassMsg] = useState("");
    const [searchParams] = useSearchParams();
    const dispatch = useDispatch();

    const onSubmit= useCallback((e)=>{
    e.preventDefault();
    if(password != confirmPassword){
        setPassMsg("Your passwords do not match");
        return;
    }
    else{
        setPassMsg("");
    }
    const data = {
        token: searchParams.get("token"),
        password: password
    }
    dispatch(setLoading(true));
    ResetPasswordRequest(data).then(res=>{
        if(res){
            setMessage("Password updated Successfully!! You can now log in to your account.")
        }
    }).catch(err=>{
        setMessage("Your Token has expired, please try again.")
    }).finally(()=>{
        dispatch(setLoading(false));
    })


    },[dispatch, password, confirmPassword]);

    const handleOnChangePassword = useCallback((e)=>{
        e.persist();
        setPassword((prev) => e.target.value);
    },[]);
    
    const handleOnChangeConfirmPassword = useCallback((e)=>{
        e.persist();
        setConfirmPassword((prev) => e.target.value);
    },[]);
  return (
    <div className='px-8 w-full lg:w-[70%]'>
      <>
      <p className='text-3xl font-bold pb-4 pt-4'>Reset Password</p>
    
      {!message && <div className='pt-4'>
        <form onSubmit={onSubmit} autoComplete='off'>
          <label>Password </label>
          <input type="password" name='password' value={password} onChange={handleOnChangePassword} placeholder='Password' className='h-[48px] w-full border p-2 mt-2 mb-4 border-gray-400' required autoComplete='off'/>
          <label>Confirm Password </label>
          <input type="password" name='confirmPassword' value={confirmPassword} onChange={handleOnChangeConfirmPassword} placeholder='Confirm password' className='h-[48px] w-full border p-2 mt-2 mb-4 border-gray-400' required autoComplete='off'/>
          {passMsg && <p className='text-lg text-red-700'>{passMsg}</p>}
          <button className='border w-full rounded-lg h-[48px] mb-4 bg-black text-white mt-4 hover:opacity-80'>Reset Password</button>
        </form>
      </div>}
      {message && <p className='text-lg'>{message}</p>}
      </>
    </div>
  )
}

export default ResetPassword