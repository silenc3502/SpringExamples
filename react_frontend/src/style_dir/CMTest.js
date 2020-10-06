import React from 'react'
import styles from './CMTest.module.css'

const CMTest = () => {
    return (
        <div className={ `${styles.wrapper} ${styles.inverted}` }>
            안녕, 나는 <span className="something">CSS Module 이야!</span>
        </div>
    )
}

export default CMTest