import React from "react";
import { withRouter } from "react-router-dom";

const WithRouterSample = ({ location, match, history }) => {
    return(
        <div>
            <h2>location</h2>
            <textarea value={ JSON.stringify(location, null, 2)} rows={ 10 } readOnly={ true }/>
            <h2>match</h2>
            <textarea value={ JSON.stringify(match, null, 2)} rows={ 10 } readOnly={ true }/>
            <button onClick={ () => history.push('/') }>Goto Home</button>
        </div>
    )
}

export default withRouter(WithRouterSample)