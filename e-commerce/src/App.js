import './App.css';
import {Route, Routes} from "react-router";
import CustomerRouters from "./Routers/CustomerRouters";
import React from "react";
import AdminRouters from "./Routers/AdminRouters";

function App()
{
    return (
        <div className="">
            <Routes>
                <Route path="/*" element={ <CustomerRouters /> } />
                <Route path="/admin/*" element={ <AdminRouters />}></Route>

            </Routes>
        </div>
    );
}

export default App;
