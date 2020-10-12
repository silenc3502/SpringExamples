import { createAction, handleActions } from 'redux-actions'
import { delay, put, takeLatest, select, throttle } from 'redux-saga/effects'

const INCREASE = 'counter/INCREASE'
const DECREASE = 'counter/DECREASE'
const INCREASE_ASYNC = 'counter/INCREASE_ASYNC'
const DECREASE_ASYNC = 'counter/DECREASE_ASYNC'

export const increase = createAction(INCREASE)
export const decrease = createAction(DECREASE)
// 마우스 클릭 이벤트가 들어가지 않도록 undefined 설정
export const increaseAsync = createAction(INCREASE_ASYNC, () => undefined)
export const decreaseAsync = createAction(DECREASE_ASYNC, () => undefined)

// JS에서 function* 으로 붙은 녀석들은 Generator 객체를 생성한다.
function* increaseSaga() {
    // 강제 1초 대기
    yield delay(1000)
    // Vue Dispatch와 동일
    yield put(increase())
    const number = yield select(state => state.counter)
    console.log(`현재 값은 ${number}`)
}

function* decreaseSaga() {
    yield delay(1000)
    yield put(decrease())
}

export function* counterSaga() {
    yield throttle(3000, INCREASE_ASYNC, increaseSaga)
    // 기존에 진행중이던 작업이 있다면 강제 취소 처리
    // 가장 마지막 작업만 수행한다.
    yield takeLatest(DECREASE_ASYNC, decreaseSaga)
}
//export const increaseAsync = () => dispatch => {
//    setTimeout(() => {
//        dispatch(increase())
//    }, 1000)
//}

const initialState = 0

const counter = handleActions(
    {
        [INCREASE]: state => state + 1,
        [DECREASE]: state => state - 1
    },
    initialState
)

export default counter