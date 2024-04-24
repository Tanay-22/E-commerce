import React from 'react';
import {HomePage} from "../customer/component/pages/homePage/HomePage";
import {Route, Routes} from "react-router";
import Cart from "../customer/component/cart/Cart";
import Navigation from "../customer/component/Navigation/Navigation";
import {Footer} from "../customer/component/Footer/Footer";
import Product from "../customer/component/Product/Product";
import ProductDetails from "../customer/component/ProductDetails/ProductDetails";
import Checkout from "../customer/component/checkout/Checkout";
import Order from "../customer/component/order/Order";
import OrderDetails from "../customer/component/order/OrderDetails";

const CustomerRouters = () =>
{
    return (
        <div>
            <div>
                <Navigation />
            </div>
            <Routes>

                <Route path="/" element={ <HomePage /> } />
                <Route path="/cart" element={ <Cart /> } />
                <Route path="/:level1/:level2/:level3" element={ <Product /> } />
                <Route path="/product/:productId" element={ <ProductDetails /> } />
                <Route path="/checkout" element={ <Checkout /> } />
                <Route path="/account/order" element={ <Order /> } />
                <Route path="/account/order/:orderId" element={ <OrderDetails /> } />


            </Routes>
            <div>
                <Footer />
            </div>
        </div>
    );
};

export default CustomerRouters;