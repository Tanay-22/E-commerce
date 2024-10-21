import * as at from "./ActionType";
import {api} from "../../config/apiConfig";


export const createOrder = (reqData) => async (dispatch) =>
{
    console.log("req Data", reqData);
    dispatch({ type: at.CREATE_ORDER_REQUEST });
    try
    {
        const { data } = await api.post(`/api/orders`, reqData.address);

        if(data.id)
            reqData.navigate({ search : `step=3&order_id=${data.id}` });

        console.log("Order created ", data);

        dispatch({ type: at.CREATE_ORDER_SUCCESS, payload: data});
    }
    catch (error)
    {
        console.log("error - ", error);
        dispatch({ type: at.CREATE_ORDER_FAILURE, payload: error.message });
    }
}


export const getOrderById = (orderId) => async (dispatch) =>
{
    dispatch({ type: at.GET_ORDER_BY_ID_REQUEST });
    try
    {
        const { data } = await api.get(`/api/orders/${orderId}`);
        console.log("order by id - ", data);
        dispatch({ type: at.GET_ORDER_BY_ID_SUCCESS, payload: data });
    }
    catch(error)
    {
        dispatch({ type: at.GET_ORDER_BY_ID_FAILURE, payload: error.message });
    }
};