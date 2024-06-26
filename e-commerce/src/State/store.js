import { applyMiddleware, combineReducers, legacy_createStore, compose } from "redux";
import { thunk } from "redux-thunk";
import { authReducer } from "./Auth/Reducer";
import {costumerProductReducer} from "./Product/Reducer";
import {cartReducer} from "./Cart/Reducer";
import {orderReducer} from "./Order/Reducer";
import adminOrderReducer from "./Admin/Order/Reducer";

const rootReducers = combineReducers(
{
                auth : authReducer,
                productB : costumerProductReducer,
                cart : cartReducer,
                order : orderReducer,
                adminOrder: adminOrderReducer
        }
);
const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

export const store = legacy_createStore(rootReducers, applyMiddleware(thunk));