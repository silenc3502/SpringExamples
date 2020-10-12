import { call, put } from 'redux-saga/effects'
import { startLoading, finishLoading } from './loading'

export default function createRequestSaga(type, request) {
    const SUCCESS = `${type}_SUCCESS`
    const FAILURE = `${type}_FAILURE`

    return function*(action) {
        // 실제 로딩 작업 시작
        yield put(startLoading(type))

        try {
            const response = yield call(request, action.payload)
            yield put({
                type: SUCCESS,
                payload: response.data
            })
        } catch (e) {
            yield put({
                type: FAILURE,
                payload: e,
                error: true
            })
        }

        // 실제 로딩 완료!
        yield put(finishLoading(type))
    }
}