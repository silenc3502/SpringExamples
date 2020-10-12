import React, { Component } from "react";
import { connect } from 'react-redux'
import Counter from "./Counter";
import { increaseAsync, decreaseAsync } from "./counter";

const CounterContainer = ({ number, increaseAsync, decreaseAsync }) => {
    return(
        <Counter number={ number } onIncrease={ increaseAsync } onDecrease={ decreaseAsync }/>
    )
}

export default connect(
    state => ({
        number: state.counter
    }),
    {
        increaseAsync,
        decreaseAsync
    }
) (CounterContainer)