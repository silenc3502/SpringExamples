import React, { useState, useCallback } from "react";
import { MdAdd } from 'react-icons/md'
import './TodoInsert.scss';

const TodoInsert = ({ onInsert }) => {
    const [value, setValue] = useState('')
    const onChange = useCallback(e => {
        setValue(e.target.value)
    }, [])
    const onSubmit = useCallback(e => {
        onInsert(value)
        setValue('')

        // submit Event 는 Refresh(F5)를 발생시키므로
        // update 방지를 위해 사용한다!
        e.preventDefault();
    }, [onInsert, value])

    return(
        <form className="TodoInsert" onSubmit={ onSubmit }>
            <input placeholder="해야할 일을 입력하세요 ~" value={ value } onChange={ onChange }/>
            <button type="submit">
                <MdAdd/>
            </button>
        </form>
    );
};

export default TodoInsert