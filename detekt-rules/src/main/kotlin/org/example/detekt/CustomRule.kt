package org.example.detekt

import io.gitlab.arturbosch.detekt.api.CodeSmell
import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.Debt
import io.gitlab.arturbosch.detekt.api.Entity
import io.gitlab.arturbosch.detekt.api.Issue
import io.gitlab.arturbosch.detekt.api.Rule
import io.gitlab.arturbosch.detekt.api.Severity
import org.jetbrains.kotlin.psi.KtValueArgumentList

class CustomRule(config: Config) : Rule(config) {

    override val issue = Issue(
        id = "custom-issue",
        severity = Severity.Minor,
        description = "Custom rule example",
        debt = Debt.FIVE_MINS,
    )

    override fun visitValueArgumentList(list: KtValueArgumentList) {
        super.visitValueArgumentList(list)
        list.arguments
            .filter { argument ->
                argument.stringTemplateExpression != null
            }
            .forEach { argument ->
                val smell = CodeSmell(
                    issue = issue,
                    entity = Entity.from(argument),
                    message = "String templates are forbidden!",
                )
                report(smell)
            }
    }
}
