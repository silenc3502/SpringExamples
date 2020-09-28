import React, { Component } from "react";
import PropTypes from 'prop-types'

class TypePropsTest extends Component {
    static defaultProps = {
        name: 'Default Name'
    }
    static propTypes = {
        name: PropTypes.string
    }
    render() {
        return(
            <div>
                TypePropsTest { this.props.name }
            </div>
        )
    }
}

export default TypePropsTest