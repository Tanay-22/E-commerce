import React from 'react';
import AliceCarousel from 'react-alice-carousel';
import 'react-alice-carousel/lib/alice-carousel.css';
import { mainCarouselData } from './MainCaroselData';


// const navigate = use
const items = mainCarouselData.map((item) => <img src={item.image} 
                                                className='cursor-pointer -z-10' 
                                                alt='' role='presentation'/>)

const MainCarosel = () => (
    <AliceCarousel
        items={items}
        disableButtonsControls
        autoPlay
        autoPlayInterval={2000}
        infinite
    />
);

export default MainCarosel;