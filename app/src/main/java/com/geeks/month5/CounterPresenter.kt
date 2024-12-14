package com.geeks.month5

class CounterPresenter {

    private val model = CounterModel()
    private var view: CounterView? = null

    fun attachView(view: CounterView) {
        this.view = view
        view.showResult(model.getCount())
    }

    fun onIncrementClick() {
        model.increment()
        val count = model.getCount()
        processCount()
    }




    fun onDecrement() {
        model.decrement()
        val count = model.getCount()
        processCount()
    }


    private fun processCount() {
        val count = model.getCount()
        view?.showResult(count)

        when(count){
            10-> view?.showToast("Поздравляем!")
            15-> view?.changeTextColor(android.graphics.Color.GREEN)
            else -> view?.changeTextColor(android.graphics.Color.BLACK)
        }
    }

    fun detachView() {
        view = null
    }
}
