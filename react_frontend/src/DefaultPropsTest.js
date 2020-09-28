import React, { Component } from "react";

class DefaultPropsTest extends Component {
    static defaultProps = {
        name: 'Default Name'
    }
    render() {
        return(
            <div>
                Awesome Golang Based { this.props.name }
            </div>
        )
    }
}

export default DefaultPropsTest