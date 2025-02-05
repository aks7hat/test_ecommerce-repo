import axios from "axios";
import { API_BASE_URL, API_URLS, API_BASE_URL_ES } from "./constant"


export const getAllProducts = async (id,typeId)=>{
    let url = API_BASE_URL + API_URLS.GET_PRODUCTS + `?categoryId=${id}`;
    if(typeId){
        url = url + `&typeId=${typeId}`;
    }

    try{
        const result = await axios(url,{
            method:"GET"
        });
        return result?.data;
    }
    catch(err){
        console.error(err);
    }
}

export const getAllProductsByTypeId = async (typeId, catId)=>{
    let url = API_BASE_URL + API_URLS.GET_PRODUCTS + `/type/${typeId}`;
    if(catId){
        url = url + `?categoryId=${catId}`;
    }
    try{
        const result = await axios(url,{
            method:"GET"
        });
        return result?.data;
    }
    catch(err){
        console.error(err);
    }
}

export const getProductBySlug = async (slug)=>{
    const url = API_BASE_URL + API_URLS.GET_PRODUCTS + `/${slug}`;
    try{
        const result = await axios(url,{
            method:"GET",
        });
        return result?.data;
    }
    catch(err){
        console.error(err);
    }
}

export const getProductById = async (id)=>{
    const url = API_BASE_URL + API_URLS.GET_PRODUCTS + `/${id}`;
    try{
        const result = await axios(url,{
            method:"GET",
        });
        return result?.data;
    }
    catch(err){
        console.error(err);
    }
}

export const searchProducts = async (query)=>{
    const url = API_BASE_URL_ES +'/api/search' + `/${query}`;
    try{
        const result = await axios(url,{
            method:"GET",
        });
        console.log(result)
        return result?.data;
    }
    catch(err){
        console.error(err);
    }
}

export const getProductsList = async ()=>{
    let url = API_BASE_URL + API_URLS.GET_PRODUCTS + `/all`;
    try{
        const result = await axios(url,{
            method:"GET"
        });
        return result?.data;
    }
    catch(err){
        console.error(err);
    }
}