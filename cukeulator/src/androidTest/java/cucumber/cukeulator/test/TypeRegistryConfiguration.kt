package cucumber.cukeulator.test

import io.cucumber.core.api.TypeRegistry
import io.cucumber.core.api.TypeRegistryConfigurer
import io.cucumber.cucumberexpressions.ParameterType
import io.cucumber.cucumberexpressions.Transformer
import java.util.Locale

class TypeRegistryConfiguration : TypeRegistryConfigurer {
    override fun locale(): Locale {
        return Locale.ENGLISH
    }

    override fun configureTypeRegistry(typeRegistry: TypeRegistry) {
        typeRegistry.defineParameterType(
            ParameterType(
                "digit",
                "[0-9]",
                Int::class.java,
                Transformer { s: String -> s.toInt() } as Transformer<Int>,
            ),
        )

        typeRegistry.defineParameterType(
            ParameterType(
                "operator",
                "[+–x\\/=]",
                Char::class.java,
                Transformer { text: String -> text[0] } as Transformer<Char>,
            ),
        )
    }
}