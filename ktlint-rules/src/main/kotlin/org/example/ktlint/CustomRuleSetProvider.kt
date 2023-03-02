package org.example.ktlint

import com.pinterest.ktlint.core.RuleProvider
import com.pinterest.ktlint.core.RuleSetProviderV2

class CustomRuleSetProvider : RuleSetProviderV2(
    id = "custom",
    about = About(
        maintainer = "Vilnius KUG",
        description = "Example of a custom rule set",
        license = null,
        issueTrackerUrl = null,
        repositoryUrl = null
    )
) {

    override fun getRuleProviders(): Set<RuleProvider> =
        setOf(
            RuleProvider { CustomRule() },
        )
}
