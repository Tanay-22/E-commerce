import React, {useEffect} from 'react';
import {useDispatch, useSelector} from "react-redux";
import {store} from "../../State/store";
import {getOrders} from "../../State/Admin/Order/Action";
import {
    Avatar, AvatarGroup, Button, Card,
    CardHeader,
    Paper,
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableHead,
    TableRow
} from "@mui/material";

const OrdersTable = () =>
{
    const dispatch = useDispatch();

    const adminOrder = useSelector(store => store.adminOrder);

    useEffect(() =>
    {
        dispatch(getOrders)
    },[]);

    console.log("admin orders", adminOrder);
    return (
        <div>
            <Card className="mt-2">
                <CardHeader title="All Products" />

                <TableContainer component={Paper}>
                    <Table sx={{ minWidth: 650 }} aria-label="simple table">
                        <TableHead>
                            <TableRow>
                                <TableCell>Image</TableCell>
                                <TableCell>Product Title</TableCell>
                                <TableCell align="left">Product Id</TableCell>
                                <TableCell align="left">Cateogory</TableCell>
                                <TableCell align="left">Price</TableCell>
                                <TableCell align="left">Quantity</TableCell>
                                <TableCell align="left">Delete</TableCell>

                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {adminOrder?.orders?.map((item) => (
                                <TableRow
                                    key={item.name}
                                    sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                                >
                                    <TableCell align="left">
                                        <AvatarGroup>
                                            {item.orderItems.map((orderItem) =>
                                            <Avatar src={orderItem.product.imageUrl}></Avatar>)}
                                        </AvatarGroup>
                                    </TableCell>
                                    <TableCell align="left" scope="row">
                                        {item.orderItems.map((orderItem) =>
                                            <p>{orderItem.product.title}</p>)}
                                    </TableCell>
                                    <TableCell align="left">{item.id}</TableCell>
                                    <TableCell align="left">{item.totalPrice}</TableCell>
                                    <TableCell align="left">{item.quantity}</TableCell>
                                    <TableCell align="left">
                                        {/*<Button variant="outlined" color="warning"
                                                onClick={() => handleProductDelete(item.id)}
                                        >
                                            Delete
                                        </Button>*/}
                                    </TableCell>

                                </TableRow>
                            ))}
                        </TableBody>
                    </Table>
                </TableContainer>
            </Card>
        </div>
    );
};

export default OrdersTable;