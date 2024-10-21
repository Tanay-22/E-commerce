import * as at from "./ActionType";


const initialState =
{
    loading: false,
    orders: [],
    error: "",
};

const adminOrderReducer = (state = initialState, action) =>
{
    switch (action.type)
    {
        case at.GET_ORDERS_REQUEST:
            return {...state, loading: true };

        case at.GET_ORDERS_SUCCESS:
            return {...state, loading: false, orders: action.payload, error: "" };

        case at.GET_ORDERS_FAILURE:
            return {...state, orders: [], error: action.payload };

        case at.CONFIRMED_ORDER_REQUEST:
        case at.PLACED_ORDER_REQUEST:
        case at.DELIVERED_ORDER_REQUEST:
        case at.CANCELLED_ORDER_REQUEST:
            return {...state, loading: true };

        case at.CONFIRMED_ORDER_SUCCESS:
            return {...state, loading: false, confirmed: action.payload };

        case at.PLACED_ORDER_SUCCESS:
            return {...state, loading: false, placed: action.payload };

        case at.DELIVERED_ORDER_SUCCESS:
            return {...state, loading: false, delivered: action.payload };

        case at.CANCELLED_ORDER_SUCCESS:
            return {...state, loading: false, cancelled: action.payload };

        case at.CONFIRMED_ORDER_FAILURE:
        case at.PLACED_ORDER_FAILURE:
        case at.DELIVERED_ORDER_FAILURE:
        case at.CANCELLED_ORDER_FAILURE:
            return {...state, error: action.payload, loading: false};

        case at.DELETE_ORDER_REQUEST:
            return {...state,  loading: true };

        case at.DELETE_ORDER_SUCCESS:
            return {...state,  loading: false,
                orders: state.orders.filter((order) => order.id !== action.payload) };

        case at.DELETE_ORDER_FAILURE:
            return {...state,  loading: false, error: action.payload };

        case at.SHIP_ORDER_REQUEST:
            return {...state, loading: false, error: ""};

        case at.SHIP_ORDER_SUCCESS:
            return {...state, loading: false, shipped: action.payload};

        case at.SHIP_ORDER_FAILURE:
            return {...state, loading: false, error: action.payload};

        default:
            return state;
    }
};

export default adminOrderReducer;