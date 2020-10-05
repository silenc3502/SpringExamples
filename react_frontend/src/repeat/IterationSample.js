import React, { Component } from "react";

class IterationSample extends Component {
    render() {
        const names = ["snow", "water", "fire", "thunder", "wind"];
        // 위의 names 리스트를 맵으로 연결해서 해당 요소에 대해 <li> 태그를 반복적으로 먹임
        const nameList = names.map(
            (name) => (<li>{ name }</li>)
        )
        return(
            <ul>
                { nameList }
            </ul>
        )
    }
}

export default IterationSample