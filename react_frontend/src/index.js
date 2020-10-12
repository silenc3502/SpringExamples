import React from 'react';
import ReactDOM from 'react-dom';
import { createStore, applyMiddleware } from "redux";
import { Provider } from 'react-redux'
import './index.css';
import App from './App';
import BackupApp from './BackupApp'
import * as serviceWorker from './serviceWorker';
import { BrowserRouter } from "react-router-dom";
import rootReducer, { rootSaga } from './asynchronous';
import {createLogger} from "redux-logger/src";
import {composeWithDevTools} from "redux-devtools-extension";
import createSagaMiddleware from 'redux-saga'
import ReduxThunk from 'redux-thunk'

const logger = createLogger();
const sagaMiddleware = createSagaMiddleware();
const store = createStore(
    rootReducer,
    composeWithDevTools(applyMiddleware(logger, ReduxThunk, sagaMiddleware))
)
sagaMiddleware.run(rootSaga)

ReactDOM.render(
  //<React.StrictMode>
  //<BrowserRouter>
  //  <BackupApp/>
  //  <App/>
  //</BrowserRouter>,
  //</React.StrictMode>,
  <Provider store={ store }>
    <App/>
  </Provider>,
  document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
