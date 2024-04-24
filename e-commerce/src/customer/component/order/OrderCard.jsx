import React from 'react';
import {Grid} from "@mui/material";
import AdjustIcon from '@mui/icons-material/Adjust';
import {useNavigate} from "react-router-dom";

const OrderCard = () =>
{
    const navigate = useNavigate();

    return (
        <div className="p-5 shadow-md shadow-black hover:shadow-2xl border"
            onClick={() => navigate(`/account/order/${5}`)}>
        >
            <Grid container spacing={2} sx={{justifyContent: "space-between"}}>

                <Grid item xs={6}>

                    <div className="flex cursor-pointer">
                        <img
                            src="https://tailwindui.com/img/ecommerce-images/product-page-02-secondary-product-shot.jpg"
                            alt=""
                            className="w-[5rem] h-[5rem] object-cover object-top"
                        />

                        <div className="ml-5 space-y-2">

                            <p className="">Men Slim Mid Rise Black Jeans</p>
                            <p className="opacity-50 text-xs font-semibold">Size: M</p>
                            <p className="opacity-50 text-xs font-semibold">Color: Black</p>

                        </div>
                    </div>
                </Grid>

                <Grid item xs={2}>
                    <p >&#8377;1099</p>
                </Grid>

                <Grid item xs={2}>
                    {true && <div>
                        <p>
                            <AdjustIcon
                                sx={{width: "15px", height: "15px"}}
                                className="text-green-600 mr-2"
                            />
                            <span>Delivered On March 03</span>
                        </p>
                        <p className="text-xs">Your Item HAs Been Delivered</p>
                    </div>
                    }
                    {false && <p>Excepted Delivery on March 03</p>}
                </Grid>
            </Grid>
        </div>
    );
};

export default OrderCard;