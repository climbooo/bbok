import { createActions, handleActions } from "redux-actions";


const initialState = [];

export const GET_MENU           = 'menu/GET_MENU';
export const GET_MENUS          = 'menu/GET_MENUS';
export const GET_MENUS_KOREAN   = 'menu/GET_MENUS_KOREAN';
export const GET_MENUS_CHINESE  = 'menu/GET_MENUS_CHINESE';
export const GET_MENUS_JAPANESE = 'menu/GET_MENUS_JAPANESE';
export const GET_MENUS_WESTERN  = 'menu/GET_MENUS_WESTERN';
export const GET_MENUS_DESSERT  = 'menu/GET_MENUS_DESSERT';
export const GET_MENUS_BEVERAGE = 'menu/GET_MENUS_BEVERAGE';
export const GET_MENUS_ETC      = 'menu/GET_MENUS_ETC';

const actions = createActions({
    [GET_MENU]: () => {},
    [GET_MENUS]: () => {},
    [GET_MENUS_KOREAN]: () => {},
    [GET_MENUS_CHINESE]: () => {},
    [GET_MENUS_JAPANESE]: () => {},
    [GET_MENUS_WESTERN]: () => {},
    [GET_MENUS_DESSERT]: () => {},
    [GET_MENUS_BEVERAGE]: () => {},
    [GET_MENUS_ETC]: () => {}
});

const menuReducer = handleActions(
    {
        
    }
)