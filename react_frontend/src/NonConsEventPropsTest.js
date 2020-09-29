import React, { Component } from "react";
import PropTypes from 'prop-types'

class NonConsEventPropsTest extends Component {
    static defaultProps = {
        name: 'Default Name'
    }
    static propTypes = {
        name: PropTypes.string,
        age: PropTypes.number.isRequired
    }
    state = {
        number: 0
    }
    render() {
        return(
            <div>
                <p>NonConsEventPropsTest name: { this.props.name }.</p>
                <p>NonConsEventPropsTest age: { this.props.age }</p>
                <p>NonConsEventPropsTest Number: { this.state.number }</p>
                <button onClick={() => {
                    this.setState({
                        number: this.state.number + 1
                    })
                }}>Plus Button</button>
            </div>
        )
    }
}

export default NonConsEventPropsTest