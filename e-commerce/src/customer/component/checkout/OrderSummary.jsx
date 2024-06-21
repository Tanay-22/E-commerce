import React, {useEffect} from 'react';
import AddressCard from "../addressCard/AddressCard";
import CartItem from "../cart/CartItem";
import {Button} from "@mui/material";
import {useDispatch, useSelector} from "react-redux";
import {getOrderById} from "../../../State/Order/Action";
import {useLocation} from "react-router-dom";
import {createPayment} from "../../../State/Payment/Action";

const OrderSummary = () =>
{
    const dispatch = useDispatch();
    const location = useLocation();
    const order = useSelector(store => store.order);
    const searchParams = new URLSearchParams(location.search);
    const orderId = searchParams.get("order_id");

    useEffect(() =>
    {
        dispatch(getOrderById(orderId));
    },[orderId]);

    console.log("orderId", orderId);
    console.log("fetched Orders ",order.order);

    const handleCheckOut = () =>
    {
        dispatch(createPayment(orderId));
    }

    return (
        <div>
            <div className="p-5 shadow-lg rounded-s-md border">
                <AddressCard address = {order.order.shippingAddress}/>
                <div>

                    <div className="lg:grid grid-cols-3 lg:px-16 relative">
                        <div className="col-span-2">
                            {order.order?.orderItems.map((item) => (
                                <CartItem item = {item}/>
                            ))}
                        </div>
                        <div className="px-5 sticky top-0 h-[100vh] mt-5 lg:mt-0">
                            <div className="border">
                                <p className="uppercase text-opacity-60 pb-4">Price Details</p>
                                <hr/>
                                <div className="space-y-3 font-semibold mb-10">
                                    <div className="flex justify-between pt-3 text-black">
                                        <span className="pl-2">Price</span>
                                        <span>&#8377;{order.order?.totalPrice}</span>

                                    </div>

                                    <div className="flex justify-between pt-3">
                                        <span className="pl-2">Discount</span>
                                        <span className="text-green-600">&#8377;{order.order?.totalDiscount}</span>

                                    </div>

                                    <div className="flex justify-between pt-3">
                                        <span className="pl-2">Delivery Charge</span>
                                        <span className="text-green-600">Free</span>

                                    </div>

                                    <div className="flex justify-between pt-3">
                                        <span className="pl-2">Total Amount</span>
                                        <span className="text-green-600">&#8377;{order.order?.totalDiscountedPrice}</span>

                                    </div>
                                </div>
                            </div>

                            <Button variant="contained" className="w-full mt-5"
                                    sx={{px: "2.5rem", py: "0.7rem", bgcolor: "#9155fd"}}
                                    onClick={handleCheckOut}
                            >
                                Checkout
                            </Button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default OrderSummary;