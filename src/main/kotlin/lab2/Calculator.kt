package lab2

import kotlin.math.*

enum class ElemType(val value: Int) {
    NUMBER(0), PLUS(1), MINUS(1), MULTIPLY(2), DIVIDE(2), DEGREE(3),
    BRACKET(0), PI(4), E(4), SIN(4), COS(4), TG(4), CTG(4)
}

private fun isOperation(isOperation: String): Boolean {
    if (isOperation == "*" || isOperation == "/" || isOperation == "+" || isOperation == "-" || isOperation == "^")
        return true
    return false
}

private fun isFunction(isFunc: String, i: Int): Boolean {
    var b = false
    if (isFunc.length - i >= 3) {
        if (isFunc[i] == 's' && isFunc[i + 1] == 'i' && isFunc[i + 2] == 'n')
            b = true
        if (isFunc[i] == 'c' && isFunc[i + 1] == 'o' && isFunc[i + 2] == 's')
            b = true
        if (isFunc[i] == 'c' && isFunc[i + 1] == 't' && isFunc[i + 2] == 'g')
            b = true
    }
    if (isFunc.length - i >= 2) {
        if (isFunc[i] == 't' && isFunc[i + 1] == 'g')
            b = true

    }
    return b
}

private fun unaryMinus(minus: String, i: Int): Boolean {

    var b = false
    if (i == 0 && minus[i] == '-')
        b = true
    else if (minus[i] == '-' && minus[i - 1] == '(' || minus[i] == '-' && isOperationChar(minus[i - 1]))
        b = true

    return b
}

private fun unaryPlus(plus: String, i: Int): Boolean {
    var b = false
    if (i == 0 && plus[i] == '+')
        b = true
    else if (plus[i] == '+' && plus[i - 1] == '(' || plus[i] == '+' && isOperationChar(plus[i - 1]))
        b = true
    return b
}

private fun createListOfElements(expression: String): MutableList<Element> {
    val elements: MutableList<Element> = emptyList<Element>().toMutableList()
    var i = 0
    var b = false
    while (i < expression.length) {

        if (unaryMinus(expression, i)) {
            b = true
            i++
        } else if (unaryPlus(expression, i))
            i++
        else if (expression[i].isDigit()) {
            var digit = ""
            if (b) {
                digit += '-'
                b = false
            }
            while (expression[i].isDigit() || expression[i] == '.') {
                digit += expression[i]
                i++
                if (i == expression.length) break
            }
            elements.add(Element(digit, ElemType.NUMBER))
        } else if (isOperationChar(expression[i])) {
            when (expression[i]) {
                '+' -> elements.add(Element("+", ElemType.PLUS))
                '-' -> elements.add(Element("-", ElemType.MINUS))
                '*' -> elements.add(Element("*", ElemType.MULTIPLY))
                '/' -> elements.add(Element("/", ElemType.DIVIDE))
                '^' -> elements.add(Element("^", ElemType.DEGREE))
            }
            i++
        } else if (expression[i] == '(') {
            elements.add(Element("(", ElemType.BRACKET))
            i++
        } else if (expression[i] == ')') {
            elements.add(Element(")", ElemType.BRACKET))
            i++
        } else if (isFunction(expression, i)) {
            if (expression[i] == 's' && expression[i + 1] == 'i' && expression[i + 2] == 'n') {
                elements.add(Element("sin", ElemType.SIN))
                i += 3
            } else if (expression[i] == 'c' && expression[i + 1] == 'o' && expression[i + 2] == 's') {
                elements.add(Element("cos", ElemType.COS))
                i += 3
            } else if (expression[i] == 'c' && expression[i + 1] == 't' && expression[i + 2] == 'g') {
                elements.add(Element("ctg", ElemType.CTG))
                i += 3
            } else if (expression[i] == 't' && expression[i + 1] == 'g') {
                elements.add(Element("tg", ElemType.TG))
                i += 2
            }
        } else if (expression[i] == 'e') {
            elements.add((Element("e", ElemType.E)))
            i++
        } else if (expression[i] == 'p') {
            if (expression.length - i > 1) {
                if (expression[i + 1] == 'i') {
                    elements.add(Element("pi", ElemType.PI))
                    i += 2
                }
            } else break
        }
    }
    return elements
}

private fun isOperationChar(isOperation: Char): Boolean {
    if (isOperation == '*' || isOperation == '/' || isOperation == '+' || isOperation == '-' || isOperation == '^')
        return true
    return false
}

private fun fromInfixToPostfix(elements: MutableList<Element>): MutableList<Element> {
    val stack = emptyList<Element>().toMutableList()
    val postfixList = emptyList<Element>().toMutableList()
    for (i in 0 until elements.size) {
        if (elements[i].elemType == ElemType.BRACKET) {
            if (elements[i].element == "(") {
                stack.add(elements[i])
            } else {
                while (stack.isNotEmpty()) {
                    if (stack[stack.size - 1].element != "(") {
                        postfixList.add(stack[stack.size - 1])
                        stack.removeAt(stack.size - 1)
                    } else break
                }
                stack.removeAt(stack.size - 1)
            }
        } else if (elements[i].elemType == ElemType.NUMBER || elements[i].elemType == ElemType.E || elements[i].elemType == ElemType.PI) {
            postfixList.add(elements[i])
        } else if (isOperation(elements[i].element)) {
            if (stack.isEmpty()) {
                stack.add(elements[i])
            } else if (elements[i].elemType.value > stack[stack.size - 1].elemType.value) {
                stack.add(elements[i])
            } else if (elements[i].elemType.value <= stack[stack.size - 1].elemType.value) {
                while (stack.isNotEmpty()) {
                    if (elements[i].elemType.value <= stack[stack.size - 1].elemType.value) {
                        postfixList.add(stack[stack.size - 1])
                        stack.removeAt(stack.size - 1)
                    } else break
                }
                stack.add(elements[i])
            }
        } else {
            stack.add(elements[i])
        }
    }
    while (stack.isNotEmpty()) {
        postfixList.add(stack[stack.size - 1])
        stack.removeAt(stack.size - 1)
    }
    return postfixList
}

private fun withoutSpaces(expression: String): String {
    var expressionWithoutSpaces = ""
    for (i in expression.indices) {
        if (expression[i] != ' ')
            expressionWithoutSpaces += expression[i]
    }
    return expressionWithoutSpaces
}

private fun result(postfixElements: MutableList<Element>): Double {
    val stack = emptyList<Double>().toMutableList()
    for (i in 0 until postfixElements.size) {
        when (postfixElements[i].elemType) {
            ElemType.NUMBER -> {
                stack.add(postfixElements[i].element.toDouble())
            }
            ElemType.PLUS -> {
                stack.add(stack[stack.size - 1] + stack[stack.size - 2])
                stack.removeAt(stack.size - 2)
                stack.removeAt(stack.size - 2)
            }
            ElemType.MINUS -> {
                stack.add(stack[stack.size - 2] - stack[stack.size - 1])
                stack.removeAt(stack.size - 2)
                stack.removeAt(stack.size - 2)
            }
            ElemType.MULTIPLY -> {
                stack.add(stack[stack.size - 1] * stack[stack.size - 2])
                stack.removeAt(stack.size - 2)
                stack.removeAt(stack.size - 2)
            }
            ElemType.DIVIDE -> {
                stack.add(stack[stack.size - 2] / stack[stack.size - 1])
                stack.removeAt(stack.size - 2)
                stack.removeAt(stack.size - 2)
            }
            ElemType.SIN -> {
                stack.add(sin(stack[stack.size - 1] / 180 * Math.PI))
                stack.removeAt(stack.size - 2)
            }
            ElemType.COS -> {

                stack.add(cos(stack[stack.size - 1] / 180 * Math.PI))
                stack.removeAt(stack.size - 2)
            }
            ElemType.TG -> {
                stack.add(tan(stack[stack.size - 1] / 180 * Math.PI))
                stack.removeAt(stack.size - 2)
            }
            ElemType.CTG -> {
                stack.add(1 / tan(stack[stack.size - 1] / 180 * Math.PI))
                stack.removeAt(stack.size - 2)
            }
            ElemType.PI -> {
                stack.add(Math.PI)
            }
            ElemType.E -> {
                stack.add(Math.E)
            }
            ElemType.DEGREE -> {
                stack.add(stack[stack.size - 2].pow(stack[stack.size - 1]))
                stack.removeAt(stack.size - 2)
                stack.removeAt(stack.size - 2)
            }
        }
    }
    return stack[0]
}

fun calculator(expression: String): Double {
    val expressionWithoutSpaces = withoutSpaces(expression)
    val elements: MutableList<Element> = createListOfElements(expressionWithoutSpaces)
    val elements2: MutableList<Element> = fromInfixToPostfix(elements)
    return result(elements2)
}