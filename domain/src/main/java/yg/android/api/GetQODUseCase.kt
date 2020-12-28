package yg.android.api

import io.reactivex.Observable
import yg.android.model.QOD

class GetQODUseCase : BaseUseCase<QOD>() {
    override fun setupObservable(): Observable<QOD> {
        return ApiClient.getClient.getQOD()
    }
}