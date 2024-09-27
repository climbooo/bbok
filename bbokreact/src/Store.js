import rootReducer from './modules';
import { composeWithDevtools } from 'redux-devtools-extension';
import { createStore,  applyMiddleware } from "redux";
import ReduxThunk from 'redux-thunk';

const store = createStore(
    rootReducer,
    composeWithDevtools(applyMiddleware(ReduxThunk))
);

export default store;