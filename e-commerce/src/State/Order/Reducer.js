import * as at from "./ActionType";

const initialState =
{
    order : null,
    error : null,
    loading : false
};

export const orderReducer = (state = initialState, action) =>
{
    switch (action.type)
    {
        case at.CREATE_ORDER_REQUEST:
            return { ...state, loading: true, error: null };

        case at.CREATE_ORDER_SUCCESS:
            return { ...state, loading: false, success: true, order: action.payload, error: null };

        case at.CREATE_ORDER_FAILURE:
            return { ...state, loading: false, error: action.payload };

        case at.GET_ORDER_BY_ID_REQUEST:
            return { ...state, loading: true, error: null };

        case at.GET_ORDER_BY_ID_SUCCESS:
            return { ...state, loading: false, order: action.payload, error: null };

        case at.GET_ORDER_BY_ID_FAILURE:
            return { ...state, loading: false, error: action.payload };

        default:
            return state;
    }
}