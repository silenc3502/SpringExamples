import React from 'react'
import styles from './CSSModule.module.css'

const CSSModule = () => {
    return (
        <div className={ styles.wrapper }>
            안녕, 나는 <span className="something">CSS Module 이야!</span>
        </div>
    )
}

export default CSSModule