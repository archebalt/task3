package lab1

enum class Alignment {
    LEFT,
    RIGHT,
    CENTER,
    WIDTH
}

private fun createStringWithRequiredWidth(withoutSpaces: MutableList<String>, lineWidth: Int = 120): String {
    var remainWidth = lineWidth
    var res = ""
    var i = 0
    while (i < withoutSpaces.size) {
        if (withoutSpaces[i].length < remainWidth) {
            res += withoutSpaces[i] + " "
            remainWidth -= (withoutSpaces[i].length + 1)
            i++
        } else if (withoutSpaces[i].length == remainWidth) {
            res += withoutSpaces[i] + '\n'
            remainWidth = lineWidth
            i++
        } else if (withoutSpaces[i].length > lineWidth && lineWidth == remainWidth) {
            for (e in 0 until remainWidth) {
                res += withoutSpaces[i][e]
            }
            res += '\n'
            withoutSpaces[i] = withoutSpaces[i].substring(remainWidth)
            remainWidth = lineWidth
        } else {
            res += '\n'
            remainWidth = lineWidth
        }
    }
    return res
}

private fun createWidthAlignString(requiredStringWidth: String, lineWidth: Int): String {
    var widthAlign = ""
    var i = 0
    while (i != requiredStringWidth.length) {
        var countSymbolsEachString = 0
        var eachString = ""
        var countProbels = 0
        while (requiredStringWidth[i] != '\n' && i < requiredStringWidth.length - 1) {
            if (requiredStringWidth[i] != ' ') {
                countSymbolsEachString++
                eachString += requiredStringWidth[i]
            } else if (requiredStringWidth[i + 1] != '\n') {
                countSymbolsEachString++
                eachString += requiredStringWidth[i]
                countProbels++
            }
            i++
            if (i == requiredStringWidth.length)
                break
        }
        val probels = lineWidth - countSymbolsEachString
        var numProbel = 0
        var del = 0
        if (countProbels != 0) {
            del = probels / countProbels
        }
        var ostDel = 0
        if (countProbels != 0) {
            ostDel = probels % countProbels
        }
        for (n in 0 until eachString.length) {
            if (eachString[n] != ' ') {
                widthAlign += eachString[n]
            }
            if (eachString[n] == ' ') {
                widthAlign += eachString[n]
                numProbel++
                for (l in 0 until del) {
                    widthAlign += " "
                }
                if (ostDel >= numProbel) {
                    widthAlign += " "
                }
            }
        }
        widthAlign += '\n'
        i++
    }
    return widthAlign
}

private fun createCenterAlignString(requiredStringWidth: String, lineWidth: Int): String {
    var centerAlign = ""
    var i = 0
    while (i != requiredStringWidth.length) {
        var countSymbolsEachString = 0
        var supi = i
        while (requiredStringWidth[i] != '\n' && i < requiredStringWidth.length - 1) {
            if (requiredStringWidth[i] != ' ')
                countSymbolsEachString++
            else if (requiredStringWidth[i + 1] != '\n')
                countSymbolsEachString++
            i++
            if (i == requiredStringWidth.length)
                break
        }
        val leftSpace = (lineWidth - countSymbolsEachString) / 2
        val rightSpace = (lineWidth - countSymbolsEachString) - leftSpace
        for (n in 0 until lineWidth) {
            if (n < leftSpace)
                centerAlign += " "
            else if (n >= (lineWidth - rightSpace)) {
                centerAlign += " "
            } else {
                centerAlign += requiredStringWidth[supi]
                supi++
            }
        }
        centerAlign += '\n'
        i++
    }
    return centerAlign
}

private fun createRightAlignString(requiredStringWidth: String, lineWidth: Int): String {
    var rightAlign = ""
    var i = 0
    while (i != requiredStringWidth.length) {
        var countSymbolsEachString = 0
        var supi = i
        while (requiredStringWidth[i] != '\n' && i < requiredStringWidth.length - 1) {
            if (requiredStringWidth[i] != ' ')
                countSymbolsEachString++
            else if (requiredStringWidth[i + 1] != '\n')
                countSymbolsEachString++
            i++
            if (i == requiredStringWidth.length)
                break
        }
        for (n in 0 until lineWidth) {
            if (n < (lineWidth - countSymbolsEachString)) rightAlign += " "
            else {
                rightAlign += requiredStringWidth[supi]
                supi++
            }
        }
        rightAlign += '\n'
        i++
    }
    return rightAlign
}

fun alignText(
    text: String,
    lineWidth: Int = 120,
    alignment: Alignment = Alignment.LEFT
): String {
    if (lineWidth < 1)
        throw Exception("длина меньше 1")
    val strElements = text.split(" ", "\n")
    val withoutSpaces: MutableList<String> = mutableListOf()
    for (i in 0 until strElements.size - 1) {
        if (strElements[i].isNotBlank())
            withoutSpaces.add(strElements[i])
    }
    val requiredStringWidth = createStringWithRequiredWidth(withoutSpaces, lineWidth)
    val alignStr = when (alignment) {
        Alignment.LEFT -> requiredStringWidth
        Alignment.WIDTH -> createWidthAlignString(requiredStringWidth, lineWidth)
        Alignment.RIGHT -> createRightAlignString(requiredStringWidth, lineWidth)
        Alignment.CENTER -> createCenterAlignString(requiredStringWidth, lineWidth)
    }
    return alignStr
}