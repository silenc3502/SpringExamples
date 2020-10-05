import React, { Component } from "react";

class LifeCycleSample extends Component {
    state = {
        number: 0,
        color: null
    }
    myRef = null
    constructor(props) {
        super(props);
        console.log('LifeCycle Constructor')
    }
    static getDerivedStateFromProps(nextProps, prevState) {
        if (nextProps.color !== prevState.color) {
            return { color: nextProps.color }
        }
        return null
    }
    componentDidMount() {
        console.log('LifeCycle componentDitMount()')
    }
    shouldComponentUpdate(nextProps, nextState) {
        console.log('LifeCycle shouldComponentUpdate()', nextProps, nextState)
        return nextState.number % 10 !== 4
    }
    componentWillUnmount() {
        console.log('LifeCycle componentWillUnmount()')
    }
    handleClick = () => {
        this.setState({
            number: this.state.number + 1
        })
    }
    getSnapshotBeforeUpdate(prevProps, prevState) {
        console.log('LifeCycle getSnapshotBeforeUpdate()', prevProps, prevState)
        if (prevProps.color !== this.props.color) {
            return this.myRef.style.color
        }
        return null
    }
    componentDidUpdate(prevProps, prevState, snapshot) {
        console.log('LifeCycle componentDidUpdate()', prevProps, prevState)
        if (snapshot) {
            console.log('Before Update Color: ', snapshot)
        }
    }
    render() {
        console.log('LifeCycle render()')
        const style = {
            color: this.props.color
        }
        return(
            <div>
                <h1 style={style} ref={ref => this.myRef=ref}>
                    { this.state.number }
                </h1>
                <p>color: { this.state.color }</p>
                <button onClick={ this.handleClick }>
                    Click
                </button>
            </div>
        )
    }
}

export default LifeCycleSample