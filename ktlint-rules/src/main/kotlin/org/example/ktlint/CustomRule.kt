package org.example.ktlint

import com.pinterest.ktlint.core.Rule
import com.pinterest.ktlint.core.ast.ElementType
import org.jetbrains.kotlin.com.intellij.lang.ASTNode

class CustomRule : Rule(id = "custom-rule") {

    override fun beforeVisitChildNodes(
        node: ASTNode,
        autoCorrect: Boolean,
        emit: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> Unit
    ) {
        super.beforeVisitChildNodes(node, autoCorrect, emit)
        if (node.elementType == ElementType.VALUE_ARGUMENT) {
            val child = node.firstChildNode
            if (child.elementType == ElementType.STRING_TEMPLATE)
                emit(child.startOffset, "String templates are forbidden!", false)
        }
    }
}
