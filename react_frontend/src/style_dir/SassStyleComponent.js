import React from "react";
import './SassStyleComponent.scss';

const SassStyleComponent = () => {
    return(
        <div className="SassStyleComponent">
            <div className="box red"/>
            <div className="box orange"/>
            <div className="box yellow"/>
            <div className="box green"/>
            <div className="box blue"/>
            <div className="box indigo"/>
            <div className="box violet"/>
        </div>
    );
};

export default SassStyleComponent