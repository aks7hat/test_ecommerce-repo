import React, { useEffect, useMemo, useState } from 'react'
import FilterIcon from '../../components/common/FilterIcon';
import content from '../../data/content.json';
import Categories from '../../components/Filters/Categories';
import PriceFilter from '../../components/Filters/PriceFilter';
import ColorsFilter from '../../components/Filters/ColorsFilter';
import SizeFilter from '../../components/Filters/SizeFilter';
import ProductCard from './ProductCard';
import { Link, useLoaderData, useLocation, useNavigate, useParams, useSearchParams } from 'react-router-dom'
import { getAllProducts, getAllProductsByTypeId, getProductsList } from '../../api/fetchProducts';
import { useDispatch, useSelector } from 'react-redux';
import { setLoading } from '../../store/features/common'
import ProductCardSearch from './ProductCardSearch';
const categories = content?.categories;

const ProductSearchListPage = ({categoryType}) => {

  const categoryData = useSelector((state)=> state?.categoryState?.categories);
  const dispatch = useDispatch();
  const [products,setProducts] = useState([]);
  const [filtersCategory, setFiltersCategory] = useState([]);
  const [actualProducts, setActualProducts] = useState([]);
  const params = useParams();
  const [categoryKey, setCategoryKey] = useState();
  const navigate = useNavigate();
  const location = useLocation();
  const [searchResultList, setSearchResultList] = useState([]);
  const { searchResults, query } = location.state || { searchResults: [] };
  const categoryContent = useMemo(()=>{
    return categories?.find((category)=> category.code === categoryType);
  },[categoryType]);
  
  const productListItems = useMemo(()=>{
    return content?.products?.filter((product)=> product?.category_id === categoryContent?.id );
  },[categoryContent]);

  const category = useMemo(()=>{
    return categoryData?.find(element => element?.code === categoryType);
  },[categoryData, categoryType]);

  useEffect(()=>{
    dispatch(setLoading(true));
    console.log("Search" + searchResults);
    console.log(category);
    if(params?.type != undefined && !window.location.href.includes('new')){
      setCategoryKey(params?.type);
      getAllProductsByTypeId(params?.type, category?.id).then(res=>{
        setProducts(res);
        setActualProducts(res);
      }).catch(err=>{
        
      }).finally(()=>{
        dispatch(setLoading(false));
      })
    }
    else if(params?.type != undefined && window.location.href.includes('new')){
      setCategoryKey(params?.type);
      getAllProductsByTypeId(params?.type).then(res=>{
        setProducts(res);
        setActualProducts(res);
      }).catch(err=>{
        
      }).finally(()=>{
        dispatch(setLoading(false));
      })      
    }
    else{
      setCategoryKey(`Search Results for ${query}`)
      getProductsList().then(res=>{
        setProducts(res);
        setActualProducts(res);
      }).catch(err=>{
        
      }).finally(()=>{
        dispatch(setLoading(false));
      })      
    }
    
  },[category?.id, dispatch, params?.type]);

  useEffect(() => {
    dispatch(setLoading(true));
    setTimeout(() => {
      setSearchResultList(searchResults);
      dispatch(setLoading(false));
    },200);
  },[searchResults])

  const categoryTypeName = useMemo(() => {
    return categoryData?.find((category)=> category.code === categoryType);
  },[categoryData,categoryType])

  const filterProducts = (type) => {
    if(type){
      dispatch(setLoading(true));
      setTimeout(() => {
        setFiltersCategory((prev) => {
          if (prev.includes(type?.name)) {
            return prev.filter((e) => e !== type?.name);
          } else {
            return [...prev, type?.name];
          }
        });
        dispatch(setLoading(false));
      }, 100);
    }
  }

  // useEffect(() => {
  //   if (filtersCategory.length === 0) {
  //     setSearchResultList(searchResults);
  //   } else {
  //     const filteredProducts = searchResults.filter((prod) =>
  //       // filtersCategory.includes(prod?.categoryTypeName)
  //       filtersCategory.map((e) => prod?.categoryTypeName.includes(e))
  //     );
  //     setSearchResultList(filteredProducts);
  //   }
  // }, [filtersCategory]);

  const filterPrice = (min, max) => {
    const prodList = [];
    dispatch(setLoading(true));
    searchResults?.map((prod)=> {
      if(prod?.price >= min && prod?.price <= max){
        prodList.push(prod);
      }
    });
    
    setTimeout(() => {
      setSearchResultList(prodList);
      dispatch(setLoading(false));
    },300);
  }

  return (
    <div>
        <div className='flex'>
            <div className='w-[20%] p-[10px] border rounded-lg m-[20px]'>
                {/* Filters */}
                <div className='flex justify-between '>
                <p className='text-[16px] text-gray-600'>Filter</p>
                <FilterIcon />
                
                </div>
                <div>
                  {/* Product types */}
                {/* <p className='text-[16px] text-black mt-5'>Categories</p>
                <Categories types={categoryTypeName?.categoryTypes} onSelect={filterProducts}/> */}
                <hr></hr>
                </div>
                  {/* Price */}
                  <PriceFilter onChange = {filterPrice}/>
                  <hr></hr>
                  {/* Colors */}
                  {/* <ColorsFilter colors={categoryContent?.meta_data?.colors}/> */}
                  <hr></hr>
                   {/* Sizes */}
                   {/* <SizeFilter sizes={categoryContent?.meta_data?.sizes}/> */}
            </div>

            <div className='p-[15px]'>
            <p className='text-black text-lg'>{categoryKey}</p>
                {/* Products */}
                <div className='pt-4 grid grid-cols-1 lg:grid-cols-3 md:grid-cols-2 gap-8 px-2'>
                {searchResultList?.map((item,index)=>(
                  <ProductCardSearch key={item?.id+"_"+index} {...item} title={item?.name}/>
                ))}
                </div>

            </div>

        </div>
    </div>
  )
}

export default ProductSearchListPage;