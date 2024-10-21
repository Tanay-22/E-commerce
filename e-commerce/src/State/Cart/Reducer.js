import * as at from "./ActionType";

const initialState =
{
    cart : null,
    loading : false,
    error : null,
    cartItems : []
}

export const cartReducer = (state = initialState, action) =>
{
    switch(action.type)
    {
        case at.ADD_ITEM_TO_CART_REQUEST :
            return { ...state, loading: true, error: null };

        case at.ADD_ITEM_TO_CART_SUCCESS :
            return { ...state, cartItems: [ ...state.cartItems, action.payload.cartItems], loading: false };

        case at.ADD_ITEM_TO_CART_FAILURE :
            return { ...state, loading: false, error: action.payload }

        case at.GET_CART_REQUEST :
            return { ...state, loading: true };

        case at.GET_CART_SUCCESS :
            return { ...state, cartItems: action.payload.cartItems, cart: action.payload, loading: false };

        case at.GET_CART_FAILURE :
            return { ...state, error: action.payload, loading: false };

        case at.REMOVE_CART_ITEM_REQUEST :
        case at.UPDATE_CART_ITEM_REQUEST :
            return { ...state, loading: true };

        case at.REMOVE_CART_ITEM_SUCCESS :
            return { ...state, deleteCartItem: action.payload, loading: false };

        case at.UPDATE_CART_ITEM_SUCCESS :
            return { ...state, updateCartItem: action.payload, loading: false };

        case at.REMOVE_CART_ITEM_FAILURE :
        case at.UPDATE_CART_ITEM_FAILURE :
            return { ...state, error: action.payload, loading: false };

        default :
            return state;
    }
}