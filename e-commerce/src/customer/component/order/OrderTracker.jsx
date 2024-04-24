import React from 'react';
import Stepper from "@mui/material/Stepper";
import Step from "@mui/material/Step";
import StepLabel from "@mui/material/StepLabel";

const steps =
[
    "Placed",
    "Order Confirmed",
    "Shipped",
    "Out of Delivery",
    "Delivered"
]

const OrderTracker = ({activeStep}) =>
{
    return (
        <div className="w-full ">
            <Stepper activeStep={activeStep} alternativeLabel>
                {steps.map(label =>
                    <Step>
                        <StepLabel sx={{color:"#9155fd", fontSize:"44px"}}>
                            {label}
                        </StepLabel>
                    </Step>
                )}
            </Stepper>
        </div>
    );
};

export default OrderTracker;