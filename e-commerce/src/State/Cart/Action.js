import * as at from "./ActionType";

import {api} from "../../config/apiConfig";

export const getCart = () => async (dispatch) =>
{
    dispatch({type : at.GET_CART_REQUEST});

    try
    {
        const { data } = await api.get(`/api/cart/`);
        // console.log("cart - ", data);
        dispatch({type : at.GET_CART_SUCCESS, payload : data});
    }
    catch (error)
    {
        dispatch({type : at.GET_CART_FAILURE, payload : error.message})
    }
};


export const addItemToCart = (reqData) => async (dispatch) =>
{
    dispatch({type : at.ADD_ITEM_TO_CART_REQUEST});

    try
    {
        const { data } = await api.put(`/api/cart/add`, reqData);
        dispatch({type : at.ADD_ITEM_TO_CART_SUCCESS, payload : data});
    }
    catch (error)
    {
        dispatch({type : at.ADD_ITEM_TO_CART_FAILURE, payload : error.message})
    }
};


export const removeItemFromCart = (cartItemId) => async (dispatch) =>
{
    dispatch({type : at.REMOVE_CART_ITEM_REQUEST});

    try
    {
        const { data } = await api.delete(`/api/cart_items/${cartItemId}`);
        dispatch({type : at.REMOVE_CART_ITEM_SUCCESS, payload : cartItemId});
    }
    catch (error)
    {
        dispatch({type : at.REMOVE_CART_ITEM_FAILURE, payload : error.message})
    }
};


export const updateItemToCart = (reqData) => async (dispatch) =>
{
    dispatch({type : at.UPDATE_CART_ITEM_REQUEST});

    try
    {
        const { data } = await api.put(`/api/cart_items/${reqData.id}`, reqData, reqData.id);
        // console.log("data", data);
        dispatch({type : at.UPDATE_CART_ITEM_SUCCESS, payload : data});
    }
    catch (error)
    {
        dispatch({type : at.UPDATE_CART_ITEM_FAILURE, payload : error.message})
    }
};