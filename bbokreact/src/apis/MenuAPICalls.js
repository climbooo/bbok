import {
    GET_MENU,
    GET_MENUS,
    GET_MENUS_KOREAN,
    GET_MENUS_CHINESE,
    GET_MENUS_JAPANESE,
    GET_MENUS_WESTERN,
    GET_MENUS_DESSERT,
    GET_MENUS_BEVERAGE,
    GET_MENUS_ETC
} from '../modules/MenuModule.js';

export const callMenuListAPI = ({currentPage}) => {

    let requestURL;

    if(currentPage !== undefined || currentPage !== null) {
        requestURL = `http://${process.env.REACT_APP_RESTAPI_IP}:8080/api/v1/menus?offset=${currentPage}`;
    }else {
        requestURL = `http://${process.env.REACT_APP_RESTAPI_IP}:8080/api/v1/menus`;
    }
    console.log('[MenuAPICalls] requestURL :', requestURL);

    return async (dispatch, getState) => {

        const result = await fetch(requestURL, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Accept": "*/*"
            }
        })
        .then(response => response.json());
        if(result.status === 200) {
            console.log('[MenuAPICalls] callMenuAPI RESULT : ', result);
            dispatch({ type: GET_MENUS, payload: result.data });
        }
    };
}

export const callMenuDetaliAPI = ({menuCode}) => {
    const requestURL = `http://${process.env.REACT_APP_RESTAPI_IP}:8080/api/v1/menus/${menuCode}`;

    return async (dispatch, getState) => {

        const result = await fetch(requestURL, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Accept": "*/*"
            }
        })
        .then(response => response.json());

        console.log('[MenuAPICalls] callMenuDetailAPI RESULT : ', result);
        if(result.status === 200){
            console.log('[MenuAPICalls] callMenuDetailAPI SUCCESS');
            dispatch({ type: GET_MENU, payload: result.data });
        }
    };
}

export const callMenuListAboutKoreanAPI = ({currentPage}) => {

    let requestURL;
    
    if(currentPage !== undefined || currentPage !== null) {
        requestURL = `http://${process.env.REACT_APP_RESTAPI_IP}:8080/api/v1/menus/korean?offset=${currentPage}`;
    }else {
        requestURL = `http://${process.env.REACT_APP_RESTAPI_IP}:8080/api/v1/menus/korean`;
    }
    console.log('[MenuAPICalls] requestURL :', requestURL);
    // const requestURL = `http://${process.env.REACT_APP_RESTAPI_IP}:8080/api/v1/menus/korean`;
    
    return async (dispatch, getState) => {

        const result = await fetch(requestURL, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Accept": "*/*"
            }
        })
        .then(response => response.json());
        if(result.status === 200) {
            console.log('[MenuAPICalls] callMenuListAboutKoreanAPI RESULT: ', result);
            dispatch({ type: GET_MENUS_KOREAN, payload: result.data});
        }
    };
}

export const callMenuListAboutChineseAPI = () => {
    const requestURL = `http://${process.env.REACT_APP_RESTAPI_IP}:8080/api/v1/menus/chinese`;
    
    return async (dispatch, getState) => {

        const result = await fetch(requestURL, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Accept": "*/*"
            }
        })
        .then(response => response.json());
        if(result.status === 200) {
            console.log('[MenuAPICalls] callMenuListAboutChineseAPI RESULT: ', result);
            dispatch({ type: GET_MENUS_CHINESE, payload: result.data});
        }
    };
}

export const callMenuListAboutJapaneseAPI = () => {
    const requestURL = `http://${process.env.REACT_APP_RESTAPI_IP}:8080/api/v1/menus/japanese`;
    
    return async (dispatch, getState) => {

        const result = await fetch(requestURL, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Accept": "*/*"
            }
        })
        .then(response => response.json());
        if(result.status === 200) {
            console.log('[MenuAPICalls] callMenuListAboutJapaneseAPI RESULT: ', result);
            dispatch({ type: GET_MENUS_JAPANESE, payload: result.data});
        }
    };
}

export const callMenuListAboutWesternAPI = () => {
    const requestURL = `http://${process.env.REACT_APP_RESTAPI_IP}:8080/api/v1/menus/western`;
    
    return async (dispatch, getState) => {

        const result = await fetch(requestURL, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Accept": "*/*"
            }
        })
        .then(response => response.json());
        if(result.status === 200) {
            console.log('[MenuAPICalls] callMenuListAboutWesternAPI RESULT: ', result);
            dispatch({ type: GET_MENUS_WESTERN, payload: result.data});
        }
    };
}

export const callMenuListAboutDessertAPI = () => {
    const requestURL = `http://${process.env.REACT_APP_RESTAPI_IP}:8080/api/v1/menus/dessert`;
    
    return async (dispatch, getState) => {

        const result = await fetch(requestURL, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Accept": "*/*"
            }
        })
        .then(response => response.json());
        if(result.status === 200) {
            console.log('[MenuAPICalls] callMenuListAboutDessertAPI RESULT: ', result);
            dispatch({ type: GET_MENUS_DESSERT, payload: result.data});
        }
    };
}

export const callMenuListAboutBeverageAPI = () => {
    const requestURL = `http://${process.env.REACT_APP_RESTAPI_IP}:8080/api/v1/menus/beverage`;
    
    return async (dispatch, getState) => {

        const result = await fetch(requestURL, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Accept": "*/*"
            }
        })
        .then(response => response.json());
        if(result.status === 200) {
            console.log('[MenuAPICalls] callMenuListAboutBeverageAPI RESULT: ', result);
            dispatch({ type: GET_MENUS_BEVERAGE, payload: result.data});
        }
    };
}

export const callMenuListAboutEtcAPI = () => {
    const requestURL = `http://${process.env.REACT_APP_RESTAPI_IP}:8080/api/v1/menus/etc`;
    
    return async (dispatch, getState) => {

        const result = await fetch(requestURL, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Accept": "*/*"
            }
        })
        .then(response => response.json());
        if(result.status === 200) {
            console.log('[MenuAPICalls] callMenuListAboutEtcAPI RESULT: ', result);
            dispatch({ type: GET_MENUS_ETC, payload: result.data});
        }
    };
}