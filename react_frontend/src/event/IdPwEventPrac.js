import React, { Component } from "react";

class IdPwEventPrac extends Component {
    state = {
        id: '',
        pw: ''
    }
    handleChange = (e) => {
        this.setState({
            [e.target.name]: e.target.value
        })
    }
    handleClick = (e) => {
        alert(this.state.id + ': ' + this.state.pw)
        this.setState({
            id: '',
            pw: ''
        })
    }
    render() {
        return(
            <div>
                <h1>Id Password Event Practice</h1>
                <input type="text" name="id" placeholder="Input ID"
                       value={ this.state.id }
                       onChange={
                           this.handleChange
                       }
                />
                <input type="text" name="pw" placeholder="Input Password"
                       value={ this.state.pw }
                       onChange={
                           this.handleChange
                       }
                />
                <button onClick={
                    this.handleClick
                }>Click Test</button>
            </div>
        )
    }
}

export default IdPwEventPrac