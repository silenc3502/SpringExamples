import React from 'react';
import './App.css';
import MyTestComponent from './MyTestComponent'
import DefaultPropsTest from "./DefaultPropsTest";
import TypePropsTest from  './TypePropsTest'
import NumberPropsTest from './NumberPropsTest'
import ConstructorPropsTest from './ConstructorPropsTest'
import ClickEventPropsTest from  './ClickEventPropsTest'
import NonConsEventPropsTest from "./NonConsEventPropsTest";
import EventPractice from './event/EventPractice'
import ChangeEventPrac from "./event/ChangeEventPrac";
import ReadChangeEventContent from "./event/ReadChangeEventContent";
import ChangeClickEventTest from "./event/ChangeClickEventTest";
import ChangeClickEventHandler from  './event/ChangeClickEventHandler'
import ChangeClickEventHandlerNonCons from './event/ChangeClickEventHandlerNonCons'
import IdPwEventPrac from './event/IdPwEventPrac'

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
            <ConstructorPropsTest name="Verilog" age={7}/>
            <ClickEventPropsTest name="C#" age={3}/>
            <NonConsEventPropsTest name="C++" age={2}/>
            <EventPractice/>
            <ChangeEventPrac/>
            <ReadChangeEventContent/>
            <ChangeClickEventTest/>
            <ChangeClickEventHandler/>
            <ChangeClickEventHandlerNonCons/>
            <IdPwEventPrac/>
        </div>
    );
}

export default App;
