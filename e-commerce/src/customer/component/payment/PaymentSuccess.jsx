import React, {useEffect, useState} from 'react';
import {useParams} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";

const PaymentSuccess = () =>
{
    const [ paymentId, setPaymentId ] = useState();
    const [ referenceId, setReferenceId ] = useState();
    const [ paymentStatus, setPaymentStatus] = useState();
    const{ orderId } = useParams();

    const dispatxh = useDispatch();
    const order = useSelector(store => store.order);
    // console.log(orderId)

    useEffect(() =>
    {
        const urlParams = new URLSearchParams(window.location.search);

        setPaymentId(urlParams.get("razorpay_payment_link_id"));
        setPaymentStatus(urlParams.get("razorpay_payment_link_status"));
    }, []);

    return (
        <div>
            PaymentSuccess
        </div>
    );
};

export default PaymentSuccess;