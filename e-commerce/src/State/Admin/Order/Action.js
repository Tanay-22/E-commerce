import {api} from "../../../config/apiConfig";
import * as at from "./ActionType";


export const getOrders = () =>
{
    // console.log("get all orders");
    return async (dispatch) =>
    {
        dispatch({ type: at.GET_ORDERS_REQUEST });
        try
        {
            const response = await api.get(`/api/admin/orders`);
            dispatch({ type: at.GET_ORDERS_SUCCESS, payload: response.data });
        }
        catch (error)
        {
            console.log(error);
            dispatch({ type: at.GET_ORDERS_FAILURE, payload: error.message });
        }
    };
};


export const confirmOrder = (orderId) => async (dispatch) =>
{
    dispatch({ type: at.CONFIRMED_ORDER_REQUEST });

    try
    {
        const response = await api.put(`/api/admin/orders/${orderId}/confirmed`);
        const data = response.data;
        dispatch({ type: at.CONFIRMED_ORDER_SUCCESS, payload: data });
    }
    catch(error)
    {
        dispatch({ type: at.CONFIRMED_ORDER_FAILURE, payload: error.message });
    }
};


export const shipOrder = (orderId) => async (dispatch) =>
{
    dispatch({ type: at.SHIP_ORDER_REQUEST });

    try
    {
        const response = await api.put(`/api/admin/orders/${orderId}/ship`);
        const data = response.data;
        console.log("shipped order", data);
        dispatch({ type: at.SHIP_ORDER_SUCCESS, payload: data });
    }
    catch(error)
    {
        dispatch({ type: at.SHIP_ORDER_FAILURE, payload: error.message });
    }
};


export const deliveredOrder = (orderId) => async (dispatch) =>
{
    dispatch({ type: at.DELIVERED_ORDER_REQUEST });

    try
    {
        const response = await api.put(`/api/admin/orders/${orderId}/deliver`);
        const data = response.data;
        console.log("delivered order", data);
        dispatch({ type: at.DELIVERED_ORDER_SUCCESS, payload: data });
    }
    catch(error)
    {
        dispatch({ type: at.DELIVERED_ORDER_FAILURE, payload: error.message });
    }
};


export const cancelOrder = (orderId) => async (dispatch) =>
{
    dispatch({ type: at.CANCELLED_ORDER_REQUEST });

    try
    {
        const response = await api.put(`/api/admin/orders/${orderId}/cancel`);
        const data = response.data;
        console.log("cancelled order", data);
        dispatch({ type: at.CANCELLED_ORDER_SUCCESS, payload: data });
    }
    catch(error)
    {
        dispatch({ type: at.CANCELLED_ORDER_FAILURE, payload: error.message });
    }
};


export const deleteOrder = (orderId) => async (dispatch) =>
{
    dispatch({ type: at.DELETE_ORDER_REQUEST });

    try
    {
        const response = await api.delete(`/api/admin/orders/${orderId}/delete`);
        const data = response.data;
        console.log("delete order", data);
        dispatch({ type: at.DELETE_ORDER_SUCCESS, payload: data });
    }
    catch(error)
    {
        dispatch({ type: at.DELETE_ORDER_FAILURE, payload: error.message });
    }
};