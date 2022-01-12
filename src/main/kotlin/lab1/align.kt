package lab1

enum class Alignment {
    LEFT ,
    RIGHT ,
    CENTER ,
    WIDTH
}

fun createStringWithRequiredWidth(withoutSpaces : MutableList<String> , lineWidth : Int = 120) : String {
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
        } else {
            res += '\n'
            remainWidth = lineWidth
        }
    }
    return res
}

fun createWidthAlignString(withoutSpaces : MutableList<String> , lineWidth : Int = 120) : String {
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
        } else {
            for (e in 0 until remainWidth) {
                res += withoutSpaces[i][e]
            }
            res += '\n'
            withoutSpaces[i] = withoutSpaces[i].substring(remainWidth)
            remainWidth = lineWidth
        }
    }
    return res
}

fun alignText(
    text : String ,
    lineWidth : Int = 120 ,
    alignment : Alignment = Alignment.LEFT
) : String {
    val strElements = text.split(" " , "\n")
    val withoutSpaces : MutableList<String> = mutableListOf()
    for (i in 0 until strElements.size - 1) {
        if (strElements[i].isNotBlank()) {
            withoutSpaces.add(strElements[i])
        }
    }
    val requiredStringWidth = createStringWithRequiredWidth(withoutSpaces , lineWidth)
    var alignStr = ""
    if (alignment == Alignment.LEFT) {
        alignStr = requiredStringWidth
    }
    if (alignment == Alignment.WIDTH) {
        alignStr = createWidthAlignString(withoutSpaces , lineWidth)
    }
    return alignStr
}