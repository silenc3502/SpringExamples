import React, { Component } from "react";
import { NavLink, Route } from "react-router-dom";
import Profile from './Profile'

class Profiles extends Component {
    render() {
        const activeStyle = {
            background: 'black',
            color: 'white'
        }
        return(
            <div>
                <h1>User List</h1>
                <ul>
                    <li>
                        <NavLink activeStyle={ activeStyle } to="/profiles/test1" active>
                            Test1
                        </NavLink>
                    </li>
                    <li>
                        <NavLink activeStyle={ activeStyle } to="/profiles/test2">
                            Test2
                        </NavLink>
                    </li>
                </ul>

                <Route path="/profiles" exact render={ () => <div>Select User</div> }/>
                <Route path="/profiles/:username" component={ Profile }/>
            </div>
        )
    }
}

export default Profiles