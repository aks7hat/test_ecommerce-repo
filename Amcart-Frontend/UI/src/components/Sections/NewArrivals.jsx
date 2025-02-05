import React from 'react'
import SectionHeading from './SectionsHeading/SectionHeading'
import Card from '../Card/Card';
import Jeans from '../../assets/img/jeans1.jpg'
import Shirts from '../../assets/img/shirts1.jpg'
import Tshirt from '../../assets/img/t-shirts1.jpg'
import dresses from '../../assets/img/dresses1.jpg'
import Carousel from 'react-multi-carousel';
import { responsive } from '../../utils/Section.constants';
import './NewArrivals.css';

const items = [{
    'title':'Jeans',
    imagePath:Jeans
},{
    'title':'Shirts',
    imagePath:Shirts
},{
    'title':'T-Shirts',
    imagePath:Tshirt
},{
    'title':'Dresses',
    imagePath:dresses
},
{
    'title':'Joggers',
    imagePath:require('../../assets/img/joggers1.jpg')
},
{
    'title':'Kurtis',
    imagePath:require('../../assets/img/kurtis1.jpg')
}];

const NewArrivals = () => {
  return (
    <>
    <SectionHeading title={'New Arrivals'}/>
    <Carousel
        responsive={responsive}
        autoPlay={false}
        swipeable={true}
        draggable={false}
        showDots={false}
        infinite={false}
        partialVisible={false}
        itemClass={'react-slider-custom-item'}
        className='px-8'
      >
        {items && items?.map((item,index)=> <Card key={item?.title +index} title={item.title} imagePath={item.imagePath} sectionTitle={'New Arrivals'}/>)}

      </Carousel>
    </>
  )
}

export default NewArrivals