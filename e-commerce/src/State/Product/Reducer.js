import {
    FIND_PRODUCTS_BY_ID_FAILURE,
    FIND_PRODUCTS_BY_ID_REQUEST,
    FIND_PRODUCTS_BY_ID_SUCCESS, FIND_PRODUCTS_FAILURE,
    FIND_PRODUCTS_REQUEST,
    FIND_PRODUCTS_SUCCESS
} from "./ActionType";

const initialState =
{
    products : [],
    product : null,
    loading : false,
    error : null
};

export const costumerProductReducer = (state = initialState, action) =>
{
    switch (action.type)
    {
        case FIND_PRODUCTS_BY_ID_REQUEST:
        case FIND_PRODUCTS_REQUEST:
            return { ...state, loading: true, error: null }

        case FIND_PRODUCTS_SUCCESS:
            return { ...state, loading: false, products: action.payload, error: null }

        case FIND_PRODUCTS_BY_ID_SUCCESS:
            return { ...state, loading: false, product: action.payload, error: null }

        case FIND_PRODUCTS_BY_ID_FAILURE:
        case FIND_PRODUCTS_FAILURE:
            return { ...state, loading: false, error: action.payload }

        default:
            return state;
    }
}