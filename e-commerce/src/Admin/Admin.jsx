import React, {useState} from 'react';
import {
    Box,
    CssBaseline, Drawer,
    List,
    ListItem,
    ListItemButton,
    ListItemIcon, ListItemText,
    useMediaQuery,
    useTheme
} from "@mui/material";
import {useNavigate} from "react-router-dom";
import DashboardIcon from '@mui/icons-material/Dashboard';
import ProductionQuantityLimitsIcon from '@mui/icons-material/ProductionQuantityLimits';
import SupportAgentIcon from '@mui/icons-material/SupportAgent';
import ListAltIcon from '@mui/icons-material/ListAlt';
import AddIcon from '@mui/icons-material/Add';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import {Route, Routes} from "react-router";
import AdminDashboard from "./components/AdminDashboard";
import CreateProductForm from "./components/CreateProductForm";
import ProductTable from "./components/ProductTable";
import CustomerTable from "./components/CustomerTable";
import OrdersTable from "./components/OrdersTable";


const menu =
[
    { name: "DashBoard", path: "/admin", icon: <DashboardIcon /> },
    { name: "Products", path: "/admin/products", icon: <ProductionQuantityLimitsIcon /> },
    { name: "Customers", path: "/admin/customers", icon: <SupportAgentIcon /> },
    { name: "Orders", path: "/admin/orders", icon: <ListAltIcon /> },
    { name: "AddProduct", path: "/admin/product/create", icon: <AddIcon /> }
]

const Admin = () =>
{
    const theme = useTheme();
    const isLargeScreen = useMediaQuery(theme.breakpoints.up('lg'));
    const [ sideBarVisible, setSideBarVisible ] = useState(false);
    const navigate = useNavigate();

    const drawer = (
        <Box sx={{overflow:"auto", display:"flex", flexDirection:"column", justifyContent:"space-between",
                height: "100%"}}
    >

            {/*{isLargeScreen && <Toolbar />}*/}
            <List>
                {menu.map((item, index) =>
                    <ListItem key={item.name} disablePadding onClick={() => navigate(item.path)}>
                        <ListItemButton>
                            <ListItemIcon>{item.icon}</ListItemIcon>
                            <ListItemText>{item.name}</ListItemText>
                        </ListItemButton>
                    </ListItem>
                )}
            </List>

            <List>
                <ListItem disablePadding >
                    <ListItemButton>
                        <ListItemIcon><AccountCircleIcon /></ListItemIcon>
                        <ListItemText>Account</ListItemText>
                    </ListItemButton>
                </ListItem>
            </List>

        </Box>
    );



    return (
        <div className="relative">
            <div className="flex h-full">
                <CssBaseline />

                <div className="w-[15%] border border-r-gray-300 h-full sticky top-0">
                    {drawer}
                </div>

                <div className="w-[85%]">
                    <Routes>
                        <Route path = "/" element={<AdminDashboard />}></Route>
                        <Route path = "/product/create" element={<CreateProductForm />}></Route>
                        <Route path = "/products" element={<ProductTable />}></Route>
                        <Route path = "customers" element={<CustomerTable />}></Route>
                        <Route path = "/orders" element={<OrdersTable />}></Route>
                    </Routes>
                </div>

            </div>


        </div>
    );
};

export default Admin;