import React, { useState, useRef, useCallback } from 'react';

import TodoTemplate from "./todo_components/TodoTemplate";
import TodoInsert from "./todo_components/TodoInsert";
import TodoList from "./todo_components/TodoList";

const TodoTestApp = () => {
    const [todos, setTodos] = useState([
        {
            id: 1,
            text: 'ReactJS',
            checked: true
        },
        {
            id: 2,
            text: 'Git',
            checked: false
        },
        {
            id: 3,
            text: 'Golang',
            checked: false
        }
    ])

    const nextId = useRef(4)

    const onInsert = useCallback(
        text => {
            const todo = {
                id: nextId.current,
                text,
                checked: false
            }

            setTodos(todos.concat(todo))
            nextId.current += 1
        }, [todos]
    )

    const onRemove = useCallback(
        id => {
            setTodos(todos.filter(todo => todo.id !== id))
        }, [todos]
    )

    const onToggle = useCallback(
        id => {
            setTodos(
                todos.map(todo =>
                    todo.id === id ? { ...todo, checked: !todo.checked } : todo
                )
            )
        }, [todos]
    )

    return (
        <div>
            <div>Todo App</div>
            <TodoTemplate>
                <TodoInsert onInsert={ onInsert }/>
                <TodoList todos={ todos } onRemove={ onRemove } onToggle={ onToggle }/>
            </TodoTemplate>
        </div>
    );
}

export default TodoTestApp;
