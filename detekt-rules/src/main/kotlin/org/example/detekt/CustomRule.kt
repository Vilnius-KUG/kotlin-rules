package org.example.detekt

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.Debt
import io.gitlab.arturbosch.detekt.api.Issue
import io.gitlab.arturbosch.detekt.api.Rule
import io.gitlab.arturbosch.detekt.api.Severity

class CustomRule(config: Config) : Rule(config) {

    override val issue = Issue(
        id = "custom-issue",
        severity = Severity.Minor,
        description = "Custom rule example",
        debt = Debt.FIVE_MINS,
    )
}
