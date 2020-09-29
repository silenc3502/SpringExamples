import React, { Component } from "react";

class ChangeClickEventHandler extends Component {
    state = {
        message: ''
    }
    constructor(props) {
        super(props);
        this.handleChange = this.handleChange.bind(this)
        this.handleClick = this.handleClick.bind(this)
    }
    handleChange(e) {
        this.setState({
            message: e.target.value
        })
    }
    handleClick() {
        alert(this.state.message)
        this.setState({
            message: ''
        })
    }
    render() {
        return(
            <div>
                <h1>Change Click Event Handler</h1>
                <input type="text" name="message" placeholder="Input Anything"
                       value={ this.state.message }
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

export default ChangeClickEventHandler