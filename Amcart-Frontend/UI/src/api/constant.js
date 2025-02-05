import { getToken } from "../utils/jwt-helper";
export const API_URLS = {
    GET_PRODUCTS:'/api/products',
    GET_PRODUCT: (id) => `/api/product/${id}`,
    GET_CATEGORIES:'/api/category',
    GET_CATEGORY: (id) => `/api/category/${id}`,
}

export const API_BASE_URL = process.env.REACT_APP_API_BASE_URL || 'http://localhost:8080';
export const API_BASE_URL_ES = process.env.REACT_APP_ES_BASE_URL || 'http://localhost:8082';

export const getHeaders = ()=>{
    return {
        'Authorization':`Bearer ${getToken()}`
    }
}