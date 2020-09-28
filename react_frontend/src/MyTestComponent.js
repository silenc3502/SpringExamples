import React, { Component } from "react";

class MyTestComponent extends Component {
    render() {
        return(
            <div>
                Awesome Golang Based { this.props.name }
            </div>
        )
    }
}

export default MyTestComponent