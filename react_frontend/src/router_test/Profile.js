import React from "react";
import { withRouter } from "react-router-dom";
import WithRouterSample from './WithRouterSample'

const data = {
    test1: {
        name: 'test1',
        description: 'test1 desc'
    },
    test2: {
        name: 'test2',
        description: 'test2 desc'
    },
}

const Profile = ({ match }) => {
    const { username } = match.params
    const profile = data[username]

    if (!profile) {
        return <div>존재하지 않는 사용자다!</div>
    }

    return(
        <div>
            <h2>
                { username }({ profile.name })
            </h2>
            <p>{ profile.description }</p>
            <WithRouterSample/>
        </div>
    )
}

export default withRouter(Profile)