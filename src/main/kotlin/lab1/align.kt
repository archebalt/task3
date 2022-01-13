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

fun createCenterAlignString(requiredStringWidth:String, lineWidth: Int) :String
{
    var centerAlign = ""
    var i = 0
    while(i != requiredStringWidth.length)
    {
        var countSymbolsEachString = 0
        var supi = i
        while(requiredStringWidth[i] != '\n' && i < requiredStringWidth.length - 1)
        {
            if(requiredStringWidth[i] != ' ')
                countSymbolsEachString++
            else if(requiredStringWidth[i+1] != '\n')
                countSymbolsEachString++
            i++
            if(i == requiredStringWidth.length)
                break
        }
        val leftSpace = (lineWidth - countSymbolsEachString) / 2
        val rightSpace = (lineWidth - countSymbolsEachString) - leftSpace
        for(n in 0 until lineWidth)
        {
            if(n < leftSpace )
                centerAlign += " "
            else if(n >= (lineWidth - rightSpace))
            {
                centerAlign += " "
            }
            else
            {
                centerAlign += requiredStringWidth[supi]
                supi++
            }
        }
        centerAlign += '\n'
        i++
    }
    return centerAlign
}

fun createRightAlignString(requiredStringWidth:String, lineWidth: Int) :String
{
    var rightAlign = ""
    var i = 0
    while(i != requiredStringWidth.length)
    {
        var countSymbolsEachString = 0
        var supi = i
        while(requiredStringWidth[i] != '\n' && i < requiredStringWidth.length - 1)
        {
            if(requiredStringWidth[i] != ' ')
                countSymbolsEachString++
            else if(requiredStringWidth[i+1] != '\n')
                countSymbolsEachString++
            i++
            if(i == requiredStringWidth.length)
                break
        }
        for(n in 0 until lineWidth)
        {
            if(n < (lineWidth - countSymbolsEachString)) rightAlign += " "
            else
            { rightAlign += requiredStringWidth[supi]
                supi++
            }
        }
        rightAlign += '\n'
        i++
    }
    return rightAlign
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

    if(alignment == Alignment.RIGHT)
    {
        alignStr = createRightAlignString(requiredStringWidth,lineWidth)
    }

    if(alignment == Alignment.CENTER)
    {
        alignStr = createCenterAlignString(requiredStringWidth,lineWidth)
    }

    return alignStr
}