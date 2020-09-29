import React, { Component } from "react";

class ChangeClickEventTest extends Component {
    render() {
        return(
            <div>
                <h1>Change Click Event Test</h1>
                <input type="text" name="message" placeholder="Input Anything"
                       onChange={
                           (e) => {
                               this.setState({
                                   message: e.target.value
                               })
                           }
                       }
                />
                <button onClick={
                    () => {
                        alert(this.state.message)
                        this.setState({
                            message: ''
                        })
                    }
                }>Click Test</button>
            </div>
        )
    }
}

export default ChangeClickEventTest