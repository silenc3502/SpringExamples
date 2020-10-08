import React, { Component } from "react";

class HistorySample extends Component {
    // 뒤로가기
    handleGoBack = () => {
        this.props.history.goBack()
    }

    // 홈으로 이동하기
    handleGoHome = () => {
        this.props.history.push('/')
    }

    // 라이프 사이클 활용 케이스
    componentDidMount() {
        console.log(this.props)

        // 페이지에 변화가 발생하려고 할 때면 동작!
        this.unblock = this.props.history.block('나갈까 ?')
    }

    componentWillUnmount() {
        // 컴포넌트의 마운트 해제가 확인되면 block 하지 않음
        if (this.unblock) {
            this.unblock()
        }
    }

    render() {
        return(
            <div>
                <button onClick={ this.handleGoBack }>Go Back!</button>
                <button onClick={ this.handleGoHome }>Go Home!</button>
            </div>
        )
    }
}

export default HistorySample