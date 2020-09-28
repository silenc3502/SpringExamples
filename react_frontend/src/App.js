import React from 'react';
import './App.css';
import MyTestComponent from './MyTestComponent'
import DefaultPropsTest from "./DefaultPropsTest";
import TypePropsTest from  './TypePropsTest'
import NumberPropsTest from './NumberPropsTest'

function App() {
    const reactText = 'Golang'
    const condition = true
    const style = {
        backgroundColor: 'gray',
        border: '1px solid black',
        height: Math.round(Math.random() * 300) + 50,
        width: Math.round(Math.random() * 300) + 50,
    }
    return (
        <div className="my-div">
            <h1>Hello ReactJS</h1>
            <h2>Golang Based ReactJS</h2>
            <h3>{ reactText }</h3>
            {
                condition ? '참' : '거짓'
            }
            <p>{ condition && '가즈아' }</p>
            <div style={style}></div>
            <form>
                First name: <br/>
                <input type="text" name="firstname"/><br/>
                Last name: <br/>
                <input type="text" name="lastname"/><br/>
            </form>
            // You can't write comment!
            /* this, too */
            <div
                // We can do it!
            />
            <MyTestComponent name="Test"/>
            <DefaultPropsTest/>
            <TypePropsTest name={3}/>
            <NumberPropsTest name="Rust" age={10}/>
        </div>
    );
}

export default App;
