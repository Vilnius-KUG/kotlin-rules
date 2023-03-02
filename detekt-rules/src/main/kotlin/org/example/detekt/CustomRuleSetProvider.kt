package org.example.detekt

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.RuleSet
import io.gitlab.arturbosch.detekt.api.RuleSetProvider

class CustomRuleSetProvider : RuleSetProvider {

    override val ruleSetId = "custom"

    override fun instance(config: Config) = RuleSet(
        id = ruleSetId,
        rules = listOf(CustomRule(config)),
    )
}
