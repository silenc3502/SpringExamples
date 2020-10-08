import React, { Component } from "react";
import qs from 'qs'

const About = ({ location }) => {
    const query = qs.parse(location.search, {
        ignoreQueryPrefix: true   // 이를 통해 문자열 맨 앞의 ?를 생략시킬 수 있다.
    });
    const showDetail = query.detail === 'true';
    return(
        <div>
            <h1>About</h1>
            <p>React Router Basics</p>
            { showDetail && <p>detail 값을 true로 설정했다!</p> }
        </div>
    )
}

export default About