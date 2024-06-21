import React from 'react';
import {AccountBoxOutlined, TrendingUp} from "@mui/icons-material";


const salesData =
[
    {
        stats: "245K",
        title: "Sales",
        color: "primary",
        icon: <TrendingUp sx = {{fontSize: "1.75rem"}} />
    },
    {
        stats: "12.5K",
        title: "Customer",
        color: "success",
        icon: <AccountBoxOutlined sx = {{fontSize: "1.75rem"}} />
    },
]


const MonthlyOverview = () =>
{
    return (
        <div>
            MonthlyOverview
        </div>
    );
};

export default MonthlyOverview;