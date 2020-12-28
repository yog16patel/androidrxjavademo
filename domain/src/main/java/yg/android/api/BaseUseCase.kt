package yg.android.api

import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers


abstract class BaseUseCase<Output> {

    private var myCompositeDisposable: CompositeDisposable = CompositeDisposable()

    private fun <T> execute(observer: T) where T : Disposable, T : Observer<Output> {
        val observable = setupObservable()

        myCompositeDisposable.add(
            observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    Log.e("Yogesh", "donOnSubscribe")
                }.subscribeWith(observer)
        )
    }

    fun execute(
        onNext: (Output) -> Unit,
        onError: (Throwable) -> Unit,
        onComplete: () -> Unit = {}
    ) {
        execute(object : DisposableObserver<Output>() {
            override fun onNext(t: Output) = onNext(t)
            override fun onError(e: Throwable) = onError(e)
            override fun onComplete() = onComplete()
        })
    }

    abstract fun setupObservable(): Observable<Output>
}