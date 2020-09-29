import React, { Component } from "react";
import './bgcolor.css'

class RefBGTest extends Component {
    state = {
        pw: '',
        clicked: false,
        validated: false
    }
    handleChange = (e) => {
        this.setState({
            pw: e.target.value
        })
    }
    handleClick = (e) => {
        this.setState({
            clicked: true,
            validated: this.state.pw == 'xxxx'
        })
        this.input.focus()
    }
    handleKeyPress = (e) => {
        if(e.key === 'Enter') {
            this.handleClick()
        }
    }
    render() {
        return(
            <div>
                <h1>Background Test</h1>
                <input ref={(ref) => this.input=ref}
                       type="password" value={ this.state.pw }
                       onChange={ this.handleChange }
                       className={ this.state.clicked ? (this.state.validated ? 'success' : 'failure') : ''}
                />
                <button onClick={
                    this.handleClick
                }>Validation</button>
            </div>
        )
    }
}

export default RefBGTest