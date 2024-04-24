import './App.css';
import {Footer} from './customer/component/Footer/Footer';
import Navigation from './customer/component/Navigation/Navigation';
import Product from './customer/component/Product/Product';
import {HomePage} from './customer/component/pages/homePage/HomePage';
import Tester from './tester';
import ProductDetails from "./customer/component/ProductDetails/ProductDetails";
import Cart from "./customer/component/cart/Cart";
import Checkout from "./customer/component/checkout/Checkout";
import Order from "./customer/component/order/Order";
import OrderDetails from "./customer/component/order/OrderDetails";
import {Route, Routes} from "react-router";
import CustomerRouters from "./Routers/CustomerRouters";

function App()
{
    return (
        <div className="">
            <Routes>
                <Route path="/*" element={ <CustomerRouters /> } />
            </Routes>

        </div>

    );
}

export default App;
