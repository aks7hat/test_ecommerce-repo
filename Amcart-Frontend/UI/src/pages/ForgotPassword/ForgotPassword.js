import React, { useCallback, useState } from 'react'
import { useDispatch } from 'react-redux';
import { forgotPasswordRequest } from '../../api/authentication';
import { setLoading } from '../../store/features/common'

const ForgotPassword = () => {

    const [values,setValues] =useState({
        email:'',
    });
    const [msg, setMsg] = useState('');
    const dispatch = useDispatch();

    const handleOnChange = useCallback((e)=>{
        e.persist();
        setValues(values=>({
        ...values,
        [e.target.name]:e.target?.value,
        }))
    },[]);
    const onSubmit = useCallback((e) => {
        e.preventDefault();
        setMsg('');
        dispatch(setLoading(true));
        forgotPasswordRequest(values.email).then(res=>{
            if(res){
                setMsg("Password reset email sent!");
            }
        }).catch(err=>{
            setMsg("No user found with entered email id.");
        }).finally(()=>{
            dispatch(setLoading(false));
        });
        
    }, [dispatch, values]);

    return (
        <div className='px-8 w-full lg:w-[70%]'>    
          <p className='text-3xl font-bold pb-4 pt-4'>Forgot Password</p>        
          <div className='pt-4'>
            <form onSubmit={onSubmit}>
              <input type="email" name='email' value={values.email} onChange={handleOnChange} placeholder='Email address' className='h-[48px] w-full border p-2 border-gray-400' required/>
              <button className='border w-full rounded-lg h-[48px] mb-4 bg-black text-white mt-4 hover:opacity-80'>Reset Password</button>
            </form>
          </div>
          {msg && <p className='text-lg text-red-700'>{msg}</p>}
        </div>
      )
}

export default ForgotPassword