import React from 'react';
import {Button, IconButton} from "@mui/material";
import RemoveCircleOutlineIcon from '@mui/icons-material/RemoveCircleOutline';
import AddCircleOutlineIcon from '@mui/icons-material/AddCircleOutline';

const CartItem = () =>
{
    return (
        <div className="p-5 shadow-lg border rounded-md">

            <div className="flex items-center">

                <div className="w-[5rem] h-[5rem] lg:h-[9rem] lg:w-[9rem]">
                    <img className="w-full h-full object-cover object-top" src="https://rukminim2.flixcart.com/image/416/416/xif0q/gamepad/z/2/q/tcbp03414-cosmic-byte-original-imagxf2w7fpzzdtm.jpeg?q=70&crop=false"
                         alt='' />
                </div>

                <div className="ml-5 space-y-1">

                    <p className="font-semibold">Mens SLim Jeans</p>
                    <p className="opacity-70">Size L</p>
                    <p className="opacity-70 mt-2">Seller: Cristiano</p>

                    <div className="flex space-x-5 items-center text-gray-900 pt-6">
                        <p className="font-semibold">1999</p>
                        <p className="opacity-50 line-through">1899</p>
                        <p className="text-green-600 font-semibold">5% off</p>
                    </div>

                </div>

                <div className="lg:flex items-center lg:space-x-10 pt-4">

                    <div className="flex items-center space-x-2">
                        <IconButton >
                            <RemoveCircleOutlineIcon />
                        </IconButton>
                        <span className="py-1.5 px-7 border rounded-sm">3</span>
                        <IconButton sx={{color:"RGB(145 85 253)"}}>
                        <AddCircleOutlineIcon />
                        </IconButton>

                    </div>

                    <div>
                        <Button sx={{color:"RGB(145 85 253)"}}>Remove</Button>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default CartItem;