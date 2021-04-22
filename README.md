Just run `./gradlew assemble`

```
e: com.squareup.anvil.compiler.AnvilCompilationException: Back-end (JVM) Internal error: Couldn't resolve class for ISPSQFlushSnackbarHelper.Factory.
File is unknown

        at com.squareup.anvil.compiler.codegen.PsiUtilsKt.requireClassDescriptor(PsiUtils.kt:502)
        at com.squareup.anvil.compiler.codegen.BindingModuleGenerator$flush$$inlined$flatMap$lambda$3$1.invoke(BindingModuleGenerator.kt:210)
        at com.squareup.anvil.compiler.codegen.BindingModuleGenerator$flush$$inlined$flatMap$lambda$3$1.invoke(BindingModuleGenerator.kt:68)
        at kotlin.sequences.TransformingSequence$iterator$1.next(Sequences.kt:210)
        ...
```
