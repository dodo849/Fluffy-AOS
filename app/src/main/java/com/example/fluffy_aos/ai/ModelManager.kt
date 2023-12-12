package com.example.fluffy_aos.ai;

import com.chaquo.python.Python

class ModelManager() {
    fun execute() {
        val py = Python.getInstance()
        val pyObject = py.getModule("main")

        val jsonString =
            "{ \"age\": 0, \"weight\": 0, \"shoulder-height\": 0, \"neck-size\": 0, \"back-length\": 0, \"chest-size\": 0, \"food-amount\": 0, \"snack-amount\": 0, \"breed\": 0, \"class\": 0, \"sex\": 0, \"group\": 0, \"exercise\": 0, \"food-count\": 0, \"environment\": 0, \"defecation\": 0, \"food-kind\": 0 }"

        val obj = pyObject.callAttr("execute_model", jsonString)

        val result = obj.toString()
        println("result = ${result}")
    }
}
