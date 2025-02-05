import React, { useEffect, useMemo, useState } from 'react'
import FilterIcon from '../../components/common/FilterIcon';
import content from '../../data/content.json';
import Categories from '../../components/Filters/Categories';
import PriceFilter from '../../components/Filters/PriceFilter';
import ColorsFilter from '../../components/Filters/ColorsFilter';
import SizeFilter from '../../components/Filters/SizeFilter';
import ProductCard from './ProductCard';
import { getAllProducts } from '../../api/fetchProducts';
import { useDispatch, useSelector } from 'react-redux';
import { setLoading } from '../../store/features/common'
const categories = content?.categories;

const ProductListPage = ({categoryType}) => {

  const categoryData = useSelector((state)=> state?.categoryState?.categories);
  console.log(categoryData);
  const dispatch = useDispatch();
  const [products,setProducts] = useState([]);
  const [minPrice, setMinPrice] = useState(0);
  const [maxPrice, setMaxPrice] = useState(1000);
  const [filtersCategory, setFiltersCategory] = useState([]);
  const [actualProducts, setActualProducts] = useState([]);
  const categoryContent = useMemo(()=>{
    return categories?.find((category)=> category.code === categoryType);
  },[categoryType]);

  const categoryTypeName = useMemo(() => {
    return categoryData?.find((category)=> category.code === categoryType);
  },[categoryData,categoryType])
  
  const productListItems = useMemo(()=>{
    return content?.products?.filter((product)=> product?.category_id === categoryContent?.id );
  },[categoryContent]);

  const category = useMemo(()=>{
    return categoryData?.find(element => element?.code === categoryType);
  },[categoryData, categoryType]);

  useEffect(() => {
    setFiltersCategory([]);
  },[category?.id])
  useEffect(()=>{
    dispatch(setLoading(true));
    console.log(category);
    getAllProducts(category?.id).then(res=>{
      setProducts(res);
      setActualProducts(res);
    }).catch(err=>{
      
    }).finally(()=>{
      dispatch(setLoading(false));
    })
    
  },[category?.id, dispatch]);

  const filterProducts = (type) => {
    // dispatch(setLoading(true));
    // console.log(category);
    // if(type != null){
    //   getAllProducts(category?.id, type?.id).then(res=>{
    //     setProducts(res);
    //   }).catch(err=>{
        
    //   }).finally(()=>{
    //     dispatch(setLoading(false));
    //   })
    // }
    // else{
    //   getAllProducts(category?.id).then(res=>{
    //     setProducts(res);
    //   }).catch(err=>{
        
    //   }).finally(()=>{
    //     dispatch(setLoading(false));
    //   })
    // }
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
  };

  useEffect(() => {
    if (filtersCategory.length === 0 && minPrice == 0 && maxPrice == 1000) {
      setProducts(actualProducts);
    } 
    else if(filtersCategory.length === 0 && (minPrice > 0 || maxPrice < 1000)){
      const filteredProducts = actualProducts.filter((prod) =>
        prod?.price >= minPrice && prod?.price <= maxPrice
      );
      setProducts(filteredProducts);
    }
    else {
      const filteredProducts = actualProducts.filter((prod) =>
        filtersCategory.includes(prod?.categoryTypeName) && prod?.price >= minPrice && prod?.price <= maxPrice
      );
      setProducts(filteredProducts);
    }
  }, [filtersCategory,minPrice, maxPrice]);
  
  const filterPrice = (min, max) => {
    // const prodList = [];
    // products?.map((prod)=> {
    //   if(prod?.price >= min && prod?.price <= max){
    //     prodList.push(prod);
    //   }
    // });
    // setProducts(prodList);
    setMinPrice(min);
    setMaxPrice(max);
    const prodList = [];
    dispatch(setLoading(true));
    actualProducts?.map((prod)=> {
      if(filtersCategory.length === 0 && prod?.price >= min && prod?.price <= max){
        prodList.push(prod);
      }
      else if(prod?.price >= min && prod?.price <= max && filtersCategory.includes(prod?.categoryTypeName)){
        prodList.push(prod);
      }
    });
    // setProducts(prodList);
    setTimeout(() => {
      setProducts(prodList);
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
                <p className='text-[16px] text-black mt-5'>Categories</p>
                <Categories types={categoryTypeName?.categoryTypes} onSelect={filterProducts}/>
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
            <p className='text-black text-lg'>{category?.description}</p>
                {/* Products */}
                <div className='pt-4 grid grid-cols-1 lg:grid-cols-3 md:grid-cols-2 gap-8 px-2'>
                {products?.map((item,index)=>(
                  <ProductCard key={item?.id+"_"+index} {...item} title={item?.name}/>
                ))}
                {/* <ProductCard {...productListItems[0]}/> */}
                </div>

            </div>

        </div>
    </div>
  )
}

export default ProductListPage