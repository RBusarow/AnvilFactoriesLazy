Reproducer for an Anvil issue here: https://github.com/square/anvil/issues/246

Dagger has additional logic in its factories if the class is member-injected.  Anvil does not.  This causes two different but related issues.

example source:
``` Kotlin
import javax.inject.Inject
import javax.inject.Provider

class InjectClass @Inject constructor(
  val string: String
) {
      
  @Inject lateinit var stringProvider: Provider<String>
}
```

What Anvil generates:
``` Kotlin
public class InjectClass_Factory(
  private val param0: Provider<String>
) : Factory<InjectClass> {
  public override fun `get`(): InjectClass = newInstance(param0.get())

  public companion object {
    @JvmStatic
    public fun create(param0: Provider<String>): InjectClass_Factory = InjectClass_Factory(param0)

    @JvmStatic
    public fun newInstance(param0: String): InjectClass = InjectClass(param0)
  }
}
```
What Dagger generates:
``` Java
public final class InjectClass_Factory implements Factory<InjectClass> {
  private final Provider<String> stringProvider;

  private final Provider<String> stringProvider2;

  public InjectClass_Factory(Provider<String> stringProvider, Provider<String> stringProvider2) {
    this.stringProvider = stringProvider;
    this.stringProvider2 = stringProvider2;
  }

  @Override
  public InjectClass get() {
    InjectClass instance = newInstance(stringProvider.get());
    InjectClass_MembersInjector.injectStringProvider(instance, stringProvider2);
    return instance;
  }

  public static InjectClass_Factory create(Provider<String> stringProvider,
      Provider<String> stringProvider2) {
    return new InjectClass_Factory(stringProvider, stringProvider2);
  }

  public static InjectClass newInstance(String string) {
    return new InjectClass(string);
  }
}
```
____
### Issue 1 - `create(...)` functions are missing parameters
In the reproducer, just run `./gradlew build` to see it.

In Dagger-generated factories, the static `create()` function (and the constructor) include Providers for any member-injected parameters.  These extra providers are missing from the Anvil version.

This isn't always a problem, as it depends upon what Dagger generates in the Component.  This `create(...)` function is only called by the Component when it needs to create a `Provider<T>`, `Lazy<T>`, or singleton instance for that type.  In these cases, the signature mismatch fails the build in the Component's module (not the injected class's module).

example error:
```
error: method create in class InjectClass_Factory cannot be applied to given types;
    this.injectClassProvider = InjectClass_Factory.create(stringProvider, stringProvider);
                                                  ^
  required: Provider<String>
  found:    Provider<String>,Provider<String>
  reason: actual and formal argument lists differ in length
```
____
### Issue 2 - `get()` doesn't inject members

The Dagger-generated factory's `get()` performs member injection on a new instance before returning it.  The Anvil version does not perform member injection.

This is only a behavioral difference so it doesn't actually break the build.

In the reproducer, after the build issue is fixed, run the main function [here](https://github.com/RBusarow/AnvilReproducer/blob/factory_generation_member_injection/lib2/src/main/java/com/reproducer/MyComponent.kt) to see an `UninitializedPropertyAccessException`.

Anvil version:
``` Kotlin
  public override fun `get`(): InjectClass = newInstance(param0.get())
```
Dagger version:
``` Java
  @Override
  public InjectClass get() {
    InjectClass instance = newInstance(stringProvider.get());
    InjectClass_MembersInjector.injectStringProvider(instance, stringProvider2);
    return instance;
  }
```
