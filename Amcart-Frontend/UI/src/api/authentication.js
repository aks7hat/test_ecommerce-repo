import axios from "axios";
import { API_BASE_URL } from "./constant"


export const loginAPI = async (body)=>{
    const url = API_BASE_URL + '/api/auth/login';
    try{
        const response = await axios(url,{
            method:"POST",
            data:body
        });
        return response?.data;
        // console.log(response);
        // return {"token":"aaaa"};
    }
    catch(err){
        throw new Error(err);
    }
}

export const registerAPI = async (body)=>{
    const url = API_BASE_URL + '/api/auth/register';
    try{
        const response = await axios(url,{
            method:"POST",
            data:body
        });
        return response?.data;
    }
    catch(err){
        throw new Error(err);
    }
}

export const verifyAPI = async (body)=>{
    const url = API_BASE_URL + '/api/auth/verify';
    try{
        const response = await axios(url,{
            method:"POST",
            data:body
        });
        return response?.data;
    }
    catch(err){
        throw new Error(err);
    }
}

export const forgotPasswordRequest = async (email)=>{
    const url = API_BASE_URL + `/api/auth/forgot-password?email=${email}`;
    try{
        const response = await axios(url,{
            method:"POST",
        });
        return response?.data;
    }
    catch(err){
        throw new Error(err);
    }
}

export const ResetPasswordRequest = async (body)=>{
    const url = API_BASE_URL + `/api/auth/reset-password`;
    try{
        const response = await axios(url,{
            method:"POST",
            data:body
        });
        return response?.data;
    }
    catch(err){
        throw new Error(err);
    }
}